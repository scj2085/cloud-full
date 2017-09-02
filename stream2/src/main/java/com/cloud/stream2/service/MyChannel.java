//package com.cloud.stream2.service;
//
//import org.springframework.cloud.stream.annotation.Output;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.stereotype.Component;
///**
// * 此接口中可以定义多个输出和输入通道，提供了三个预定义接口通道，即Source.class单向输出通道，Sink.class单向输入通道，以及继承了它们两个的Processor.class
// * 开发时要自定义接口作为通道
// * @author shichangjian
// *
// */
//@Component
//public interface MyChannel {
//
//	String OUTPUT = "test";
//	
//	@Output(OUTPUT)//@Output代表输出，通道名是test，
//	MessageChannel output();
//	
//	
//}
