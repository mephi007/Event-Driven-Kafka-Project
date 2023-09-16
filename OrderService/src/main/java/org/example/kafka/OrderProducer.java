package org.example.kafka;


import org.apache.kafka.clients.admin.NewTopic;
import org.example.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer{

    private static final Logger logger = LoggerFactory.getLogger(OrderProducer.class);

    private NewTopic topic;
    private KafkaTemplate<String, OrderEvent> kafkatemplate;

    public OrderProducer(NewTopic topic, KafkaTemplate<String, OrderEvent> kafkaTemplate){
         this.topic = topic;
         this.kafkatemplate = kafkaTemplate;
    }

    public void sendMessage(OrderEvent event){
        logger.info(String.format("Order event ==> %s", event.toString()));
        Message<OrderEvent> message = MessageBuilder.withPayload(event).setHeader(KafkaHeaders.TOPIC, topic.name()).build();
        kafkatemplate.send(message);
    }

}