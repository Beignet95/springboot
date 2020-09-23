package com.beignet.springboot.rabbitmq.QueueDemo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "simple_queue")
public class ReceiverA {
    @RabbitHandler
    public void QueueReceiver(String Queue1){
        System.out.println("Receive A: "+Queue1);
    }
}
