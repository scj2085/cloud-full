package com.cloud.rabbitmq;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cloud.rabbitmq.service.impl.App2;

//import com.cloud.rabbitmq.service.impl.Sender;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RabbitmqApplication.class)
@WebAppConfiguration
public class HelloApplicationTests {

//    @Autowired
//    private Sender sender;
//    @Test
//    public void hello() throws Exception {
//        sender.send();
//    }
//	@Autowired
//	private SinkSender sinkSender;
	
//	@Test
//	public void time(){
//		App2 app2 = new App2();
//		app2.timerMessageSource();
//		
//	}
	
}
