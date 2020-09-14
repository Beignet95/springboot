package com.beignet.springboot.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class Consumer {
    @RabbitListener(queues = "queue1")
    public void Receive(String msg){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String time = sdf.format(new Date());
        msg = time+":"+msg;
        System.out.println(msg);

    }
}

