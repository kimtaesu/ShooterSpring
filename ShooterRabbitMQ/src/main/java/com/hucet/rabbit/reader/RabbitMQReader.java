package com.hucet.rabbit.reader;

import com.hucet.rabbit.property.RabbitBinderProperty;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by taesu- on 2016-07-03.
 */
@Configuration
public class RabbitMQReader {
    @Autowired
    RabbitTemplate mRabbitTemplate;

    @Autowired
    RabbitBinderProperty rabbitBinderProperty;

    @PostConstruct
    public void shooterInit() {
        mRabbitTemplate.setExchange(exchange().getName());
        mRabbitTemplate.setQueue(queue().getName());
    }

    @Bean
    Queue queue() {
        Queue queue = new Queue(rabbitBinderProperty.getLoaderBinder().getQueueName(), true);
        return queue;
    }

    @Bean
    TopicExchange exchange() {
        TopicExchange exchange = new TopicExchange(rabbitBinderProperty.getLoaderBinder().getExchangeName());
        return exchange;
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(rabbitBinderProperty.getLoaderBinder().getRountingKey());
    }

    @Bean
    SimpleMessageListenerContainer container(MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(mRabbitTemplate.getConnectionFactory());
        container.setQueueNames(rabbitBinderProperty.getLoaderBinder().getQueueName());
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MessageReceiver reader) {
        return new MessageListenerAdapter(reader);
    }
}
