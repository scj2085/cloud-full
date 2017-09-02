package com.cloud.stream4.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;
/**
 * 此接口中可以定义多个输出和输入通道，提供了三个预定义接口通道，即Source.class单向输出通道，Sink.class单向输入通道，以及继承了它们两个的Processor.class
 * 开发时要自定义接口作为通道
 * @author shichangjian
 *
 */
@Component
public interface MyChannel {

	String TEST_CHANNEL_3 = "testChannel3";
	
	@Output("testChannel")//@Output代表输出，通道名是testChannel，此channel的名字testChannel是在注解中指定的，使用这个名字，而不是使用方法名
	MessageChannel output();
	
	@Output("testChannel2")//@Output代表输出，通道名是testChannel2，此channel的名字testChannel2是在注解中指定的，使用这个名字，而不是使用方法名
	MessageChannel output2();
	
	@Input(TEST_CHANNEL_3)//input代表输入通道，此通道名testChannel3必须与生产者对应才能接收消息，
	SubscribableChannel input3();
	
}
