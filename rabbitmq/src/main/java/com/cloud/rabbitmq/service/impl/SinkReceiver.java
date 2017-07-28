package com.cloud.rabbitmq.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.cloud.rabbitmq.service.SinkSender;

@EnableBinding(value = {Sink.class,SinkSender.class})//指定一个或多个定义了@Input或@Output注解的接口,以此实现对消息通道（Channel）的绑定，通过@EnableBinding绑定Sink接口，Sink接口是Stream默认实现对输入消息通道绑定的定义
public class SinkReceiver {

	private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);
	
	@StreamListener(Sink.INPUT)//将receive方法注册为input通道的监听处理器，通过此通道可以得到rabbitMQ中payload中输入的内容，
	public void receive(Object payload){
		logger.info("Received:" + payload);
	}
	
}
