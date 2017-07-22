//package com.cloud.rabbitmq.service.impl;
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * 创建消息消费者
// * @author shichangjian
// *
// */
//@Component
//@RabbitListener(queues = "hello")	//通过@RabbitListener注解定义该类对hello队列的监听
//public class Receiver {
//
//    @RabbitHandler	//并用@RabbitHandler注解来指定对消息的处理方法。所以，该消费者实现了对hello队列的消费,输出消息的字符串内容
//    public void process(String hello) {
//        System.out.println("Receiver : " + hello);
//    }
//}
