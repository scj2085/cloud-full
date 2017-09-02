package com.cloud.stream3.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 配置sink和source绑定的管道。
 * 
 * @author shichangjian
 *
 */
@EnableBinding(Processor.class)
public class Transform {

	private static Logger logger = LoggerFactory.getLogger(Transform.class);
	private static String name = "logging";

	//进行输入和输出管道的转换
	@ServiceActivator(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
	public String transform(String payload) {
		logger.info("Transformed by +++++++++" + this.name + ":+++++++ " + payload);
		return payload;
	}


	//如果想改变消息的内容，可以在 @Transformer注解的方法中改变
	@Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
	public String transform4(String user) {
		System.err.println("===================改变消息===========================");
		return "{\"name\":\"李四\",\"age\":22}";
	}
}
