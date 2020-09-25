package com.beignet.springboot.rabbitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSenderA {
    @Autowired
    AmqpTemplate rabbitmqAmqpTemplate;
    public void send(User user){
        System.out.println("fanoutSend A 发送："+user.toString());
        rabbitmqAmqpTemplate.convertAndSend("fanoutExchange","queueA",user);
    }
}
