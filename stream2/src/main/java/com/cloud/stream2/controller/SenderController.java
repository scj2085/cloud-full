//package com.cloud.stream2.controller;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.apache.kafka.clients.producer.internals.Sender;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.integration.support.MessageBuilder;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cloud.stream2.service.MyChannel;
//
//@RestController
//@EnableBinding(MyChannel.class)
//public class SenderController{
//
//
//	@Autowired
//	private MyChannel myChannel;
//	
//	@RequestMapping(value = "/send",method=RequestMethod.GET)
//	public void send(){
//		myChannel.output().send(MessageBuilder.withPayload("aaaaaaaaaaa").build());
//	}
//}
