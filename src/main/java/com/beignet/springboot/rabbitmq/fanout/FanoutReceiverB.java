package com.beignet.springboot.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiverB {
    @RabbitHandler
    public void receive(User user){
        System.out.println("fanoutReceiver B 接收到信息："+user);
    }
}
