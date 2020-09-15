package com.beignet.springboot.rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Producer {
    private static final  String EXCHANGE_NAME="QQNews";
    @Autowired
    RabbitTemplate rabbitTemplate;
    public void send(String queueName,String message){
        rabbitTemplate.convertAndSend("delayed_exchange",queueName,message,new MessagePostProcessor(){
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setHeader("x-depay",5000);
                System.out.println("消息推送："+message);
                return message;
            }
        });

    }
}
