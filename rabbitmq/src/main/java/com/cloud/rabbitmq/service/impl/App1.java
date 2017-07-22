package com.cloud.rabbitmq.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.handler.annotation.SendTo;

import com.cloud.rabbitmq.RabbitmqApplication;
import com.cloud.rabbitmq.vo.User;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 用于接收RabbitMQ消息的消费者，@EnableBinding，为应用启动消息驱动的功能，输入，输出消息通道的绑定
 * 在接口中通过@input和@output注解来定义消息通道，而用于定义绑定消息通道的接口侧可以被@EnableBinding注解的value参数来指定，从而应用启动的时候实现对定义消息通道的绑定
 * 
 * @author shichangjian
 *
 */
@EnableBinding(value = {Processor.class})//来指定一个或多个@input消息通道和@output消息通道的接口,实现对消息通道（Channel）的绑定，
//可以：@EnableBinding(value={Sink.class,Source.class}),Sink是input通道，Source是output
public class App1 {

	private static Logger logger = LoggerFactory.getLogger(App1.class);
	
	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public Object receiveFromInput(Object payload){
		logger.info("Received:---------------" + payload);
		return "From Input Channel Retrun - " + payload;
	}
//	@StreamListener(Sink.INPUT)
//	public void receive2(User user){
//		logger.info("Receiver" + user);
//	}
//	@StreamListener(Sink.INPUT)
//	public User transform(String message) throws Exception{
//		ObjectMapper objectMapper = new ObjectMapper();
//		User user = objectMapper.readValue(message,User.class);
//		return user;
//	}
}
