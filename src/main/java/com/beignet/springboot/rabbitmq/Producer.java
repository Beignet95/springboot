package com.beignet.springboot.rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    private static final  String EXCHANGE_NAME="QQNews";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String message = "hello word";
        String routingkey = "routingkey";
        channel.exchangeDeclare(EXCHANGE_NAME,"topic");
        channel.basicPublish(EXCHANGE_NAME,routingkey,null,message.getBytes("UTF-8"));
        connection.close();
        factory.clone();
    }
}
