package com.beignet.springboot.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSenderA {

    @Autowired
    AmqpTemplate rabbitmqAmqpTemplate;
    public void send(String msg){
        System.out.println("send 发送消息："+msg);
        this.rabbitmqAmqpTemplate.convertAndSend("topicExchange","topic.1",msg);
    }

    public void send2(String msg){
        System.out.println("send2 发送消息："+msg);
        this.rabbitmqAmqpTemplate.convertAndSend("topicExchange","topic.a",msg);
    }

    public void send3(String msg){
        System.out.println("send3 发送消息："+msg);
        this.rabbitmqAmqpTemplate.convertAndSend("topicExchange","topic.b",msg);
    }
}
