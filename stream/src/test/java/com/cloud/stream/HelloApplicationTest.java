//package com.cloud.stream;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import com.cloud.stream.service.MyChannel;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = StreamApplication.class)
//@WebAppConfiguration
//public class HelloApplicationTest {
//
//	@Autowired
//	private MyChannel myChannel;
//	
//	@Autowired
//	@Qualifier("Output-1")
//	private MyChannel sender;
//	
//	@Test
//	public void contextLoads(){
//		myChannel.output().send(MessageBuilder.withPayload("-----From SinkSender--------").build());
//		sender.output().send(MessageBuilder.withPayload("-----Output-1 SinkSender---------").build());
//	}
//}
