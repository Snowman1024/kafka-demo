package com.kafka.demo.mode3;

import org.apache.kafka.clients.consumer.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Snowman2014
 * @Date 2020/1/17 17:00
 * @Version 1.0
 **/
@Service("myKafkaErrorHandler")
public class MyKafkaListenerErrorHandler implements KafkaListenerErrorHandler {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
        logger.info(message.getPayload().toString());
        return null;
    }

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
        logger.info(message.getPayload().toString());
        return null;
    }
}
