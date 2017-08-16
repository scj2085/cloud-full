package com.cloud.rabbitMQ2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class Receiver {

	
	private static Logger logger = LoggerFactory.getLogger(Receiver.class);
	
	@RabbitHandler
	public void process(String hello){
		System.err.println("Receiver" + hello);
	}
	
}
