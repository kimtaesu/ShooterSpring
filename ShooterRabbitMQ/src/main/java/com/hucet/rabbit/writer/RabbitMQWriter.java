package com.hucet.rabbit.writer;

import com.hucet.rabbit.property.RabbitBinderProperty;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class RabbitMQWriter {

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

    public void shooting(String rountingKey, String message) {
        mRabbitTemplate.convertAndSend(rountingKey, message);
    }

}
