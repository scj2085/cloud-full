//package com.cloud.stream2.controller;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Processor;
//import org.springframework.cloud.stream.messaging.Source;
//import org.springframework.integration.annotation.InboundChannelAdapter;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@EnableBinding(value  = Processor.class)
//public class Sender {
//	 private static Logger logger = LoggerFactory.getLogger(Sender.class);
//
//
//	@InboundChannelAdapter(value = Source.OUTPUT)//@InboundChannelAdapter注解用来绑定输出的管道，进行消息推送。本案例就推送格式化的时间
//	public String timerMessageSource() {
//		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//		logger.info("publish message :" + format);
//		return "{\"name\":\"张三\",\"age\":23}";
//	}
//	@StreamListener(Processor.INPUT)
//	public void receiveFromOutput(Object payload){
//		logger.info("Received:=========结收回执的消息：" + payload);
//	}
//}
