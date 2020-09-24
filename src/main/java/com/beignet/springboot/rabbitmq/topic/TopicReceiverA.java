package com.beignet.springboot.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.a")
public class TopicReceiverA {
    @RabbitHandler
    public void receive(String msg){
        System.out.println("topicReceiver A 接收到消息:"+msg);

    }
}
