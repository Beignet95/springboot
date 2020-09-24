package com.beignet.springboot.rabbitmq.RabbitMqConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {
    @Bean
    public CustomExchange delayExchage(){
        Map<String,Object> args = new HashMap<>();
        args.put("x-delayed-type","direct");
        return  new CustomExchange("delayed_exchange","x-delayed-message",true,false,args);
    }

    @Bean
    public Queue getQueue(){
        return new Queue("queue1");
    }

    @Bean
    public Queue getSimpleQueue(){
        return new Queue("simple_queue");
    }

    @Bean
    public Binding bind(){
        return BindingBuilder.bind(getQueue()).to(delayExchage()).with("queue1").noargs();

    }
}
