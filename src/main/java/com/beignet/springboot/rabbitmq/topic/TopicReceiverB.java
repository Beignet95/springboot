package com.beignet.springboot.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.b")
public class TopicReceiverB {
    @RabbitHandler
    public void receive(String msg){
        System.out.println("topicReceiver B 接收到消息："+msg);

    }
}
