package com.hucet.rabbit.reader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

/**
 * Created by taesu- on 2016-07-03.
 */
@Slf4j
@Configuration
public class MessageReceiver implements MessageListener {
    @Override
    public void onMessage(Message message) {
//        log.info("Received <" + message + ">");
    }
}
