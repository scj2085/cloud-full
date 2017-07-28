package com.cloud.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cloud.rabbitmq.service.SinkSender;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RabbitmqApplication.class)
@WebAppConfiguration
public class HelloApplicationTests {

	@Autowired
	private SinkSender sinkSender;
	
	@Test
	public void time(){
		sinkSender.output().send(MessageBuilder.withPayload("From SinkSender").build());
	}
	
}
