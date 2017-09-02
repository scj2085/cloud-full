package com.cloud.stream.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.SendTo;

import com.cloud.stream.StreamApplication;
import com.cloud.stream.vo.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@EnableBinding(value = {Processor.class})//内部集成了@inport配置类，在 加载了各种配置后再回来读取value中的类，指定一个或多个定义了@Input或@Output注解的接口.以此实现对消息通道（channel）的绑定。
public class SinkReceiver {

	private static Logger logger = LoggerFactory.getLogger(StreamApplication.class);
	
	
	@StreamListener(Sink.INPUT)//作用是将被修饰的 方法注册为RabbitMQ消息中间件上数据流的事件监听器，注解中的属性对应了监听的消息通道名。此注解可以自动转换json字符串，但是注意：要在配置中指定头消息的类型
	@SendTo(Source.OUTPUT)
	public Object receive(Object payload){
		logger.info("Received:" + payload);
		return "From Input Channel Return----------------" + payload;
	}
	
	
	// @ServiceActivator此注解没有@SteamListener注解强大，不能实现json字符串到对象的转换，这是因为在spring
	// cloud stream中实现了一套消息转换机制，在消息消费逻辑执行之前，消息转换机制会根据消息头的消息
	// 类型（即spring.cloud.stream.bindings.input.content-type=application/json参数）找到对应的消息转换器并实现对消息
	// 的自动转换
//	@ServiceActivator(inputChannel = Sink.INPUT)
//	public void receive2(User user){
//		logger.info("Received:" + user);
//	}
	
	
	
	
	
	//此方法是结合上面的方法做测试@ServiceActivator注解不能转换json，要是使用此注解，就经过此方法首先转换json
//	@Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
//	public User transform2(String message) {
//		System.err.println("===================JSON转换===========================");
//		ObjectMapper objectMapper = new ObjectMapper();
//		User user = null;
//		try {
//			user = objectMapper.readValue(message, User.class);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return user;
//	}
	
}
