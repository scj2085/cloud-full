//package com.cloud.rabbitmq.service.impl;
//
//import java.util.Date;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * 创建消息生产者
// * @author shichangjian
// *
// */
//@Component
//public class Sender {
//	
//	@Autowired
//    private AmqpTemplate rabbitTemplate;	//通过注入AmqpTemplate接口的实例来实现消息的发送
//	
//    public void send() {
//        String context = "hello " + new Date();
//        System.err.println("Sender : " + context);
//        this.rabbitTemplate.convertAndSend("hello", context);
//    }
//}
