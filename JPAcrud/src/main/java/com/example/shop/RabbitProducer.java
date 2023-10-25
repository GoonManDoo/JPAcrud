package com.example.shop;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class RabbitProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sendMessage(){
        rabbitTemplate.convertAndSend("PRE_NEWS", "PRE_NEWS");
    }
}
