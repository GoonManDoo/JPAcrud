package com.example.shop;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class RabbitConsumer {
    @RabbitListener(queues = "PRE_NEWS")
    public void consume(Message message){
        System.out.println("메시지 : " + message);
        log.info("consumer consumes message: {}",message);
    }
}
