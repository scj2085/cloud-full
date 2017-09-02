package com.cloud.stream4.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.stream4.service.MyChannel;
import com.cloud.stream4.vo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@EnableBinding(MyChannel.class)
public class SenderController{


	@Autowired
	@Qualifier("testChannel")//以指定名称注入，保证注入的准确性
	private MessageChannel myChannel;

	@Autowired
	@Qualifier("testChannel2")//以指定名称注入，保证注入的准确性
	private MessageChannel myChannel2;
	
	@RequestMapping(value = "/send",method=RequestMethod.GET)
	public void send(){//当send()被调用时输出channel会发送一个消息，在注入的MyChannel上提供唤醒output()来检索到目标通道
		User user = new User();
		user.setName("张三");
		user.setAge(34);
		myChannel.send(MessageBuilder.withPayload(user).build());
		myChannel2.send(MessageBuilder.withPayload("ssss").build());
	}
	
	@StreamListener(MyChannel.TEST_CHANNEL_3)//@StreamListener用于监听通道，由于生产者发送的是String，所以接收用Message<String> 
	public void reveicer(String payload){//user对象的两种结果：1如果User是分别在生产者和消费者中定义的，并且包路径不同，那么会报错反序列化失败。原因是SCS会默认将POJO转换成二进制发送，并且携带包路径等信息；2，如果生产者和消费者使用的User是同一定义，或分别定义但包路径相同，那么就不会报错。
		System.err.println("====================返回信息===========" + payload);
	}
}
