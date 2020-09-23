package com.beignet.springboot.rabbitmq.QueueDemo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderA {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void Send(String msg){
        rabbitTemplate.convertAndSend("simple_queue",msg);
        System.out.println("sender A:"+msg);
    }
}
