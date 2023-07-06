package com.ecom.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
public class Consumer {

    @KafkaListener(topics = "Qburst_topic" , groupId = "Qburst_group")
    public void listenToTopic(String recieveMessage){

        System.out.println("The Massage recieve "+ recieveMessage);

    }

}
