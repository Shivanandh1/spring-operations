package com.sqsconsumer.awssqs.service;

import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.listener.acknowledgement.Acknowledgement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class MessageReceiver {

    private static final Logger logger= (Logger) LoggerFactory.getLogger(MessageReceiver.class);

    private final String queueName="demoQueue";

    @SqsListener(queueName)
    public void listen(Message<?> message ){
        logger.info(message.getPayload()+"received on listen method "+ OffsetDateTime.now());

        Acknowledgement.acknowledge(message);
    }
}
