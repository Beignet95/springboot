package com.beignet.springboot;

import com.beignet.springboot.rabbitmq.Consumer;
import com.beignet.springboot.rabbitmq.Producer;
import com.beignet.springboot.rabbitmq.QueueDemo.ReceiverA;
import com.beignet.springboot.rabbitmq.QueueDemo.SenderA;
import com.beignet.springboot.rabbitmq.fanout.FanoutSenderA;
import com.beignet.springboot.rabbitmq.fanout.User;
import com.beignet.springboot.rabbitmq.topic.TopicSenderA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitMQTest {
    @Autowired
    Consumer consumer;
    @Autowired
    Producer producer;
    @Autowired
    SenderA senderA;
    @Autowired
    ReceiverA receiverA;
    @Test
    public void rabbitMQTest1(){
        producer.send("queue1","你很票量");
    }

    @Test
    public void queueDemoTest(){
        senderA.Send("hello world a!");
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

    @Autowired
    TopicSenderA topicSenderA;

    @Test
    public void TopicTest(){
        String msg = "topic.1";
        String msg2 = "topic.a";
        String msg3 = "topic.b";
        topicSenderA.send(msg);
        topicSenderA.send2(msg2);
        topicSenderA.send3(msg3);
    }
    @Autowired
    FanoutSenderA fanoutSenderA;
    @Test
    public void fanoutTest(){
        User user = new User();
        user.setName("Beignet");
        user.setAge(23);
        fanoutSenderA.send(user);
    }
}
