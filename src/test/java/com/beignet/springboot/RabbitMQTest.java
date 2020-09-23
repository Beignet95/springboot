package com.beignet.springboot;

import com.beignet.springboot.rabbitmq.Consumer;
import com.beignet.springboot.rabbitmq.Producer;
import com.beignet.springboot.rabbitmq.QueueDemo.SenderA;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
public class RabbitMQTest {
    @Autowired
    Consumer consumer;
    @Autowired
    Producer producer;
    @Autowired
    SenderA senderA;
    @Test
    public void rabbitMQTest1(){
        producer.send("queue1","你很票量");
    }

    @Test
    public void queueDemoTest(){
        senderA.Send("hello world!");
    }

    @Test
    public void QueueSend() {
        int i = 2;
        for (int j = 0; j < i; j++) {
            String msg = "Queue1 msg" + j + new Date();
            try {
                senderA.Send(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
