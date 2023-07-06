package com.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    public String sendMessageToTopic(String message){

        kafkaTemplate.send("Qburst_topic",message);
        return message;
    }
}
