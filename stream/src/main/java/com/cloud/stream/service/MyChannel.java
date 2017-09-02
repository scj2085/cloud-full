package com.cloud.stream.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * 定义一个消息生产者，向input消息通道发送数据，作为输出通道的接口
 * @author shichangjian
 *
 */
@Component
public interface MyChannel{

	String INPUT = "testChannel";
	String INPUT2 = "testChannel2";
	String OUTPUT_3 = "testChannel3";
	
	
	@Input(INPUT)//input代表输入通道，此通道名testChannel必须与生产者对应才能接收消息，
	SubscribableChannel input();
	
	@Input(INPUT2)//input代表输入通道，此通道名testChannel必须与生产者对应才能接收消息，
	SubscribableChannel input2();
	
	@Output(OUTPUT_3)
	MessageChannel output3();

}
