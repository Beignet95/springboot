package com.beignet.springboot;

import com.beignet.springboot.rabbitmq.Consumer;
import com.beignet.springboot.rabbitmq.Producer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RabbitMQTest {
    @Autowired
    Consumer consumer;
    @Autowired
    Producer producer;
    @Test
    public void rabbitMQTest1(){
        producer.send("queue1","你很票量");
    }
}
