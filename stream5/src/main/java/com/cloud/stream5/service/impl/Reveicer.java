package com.cloud.stream5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.cloud.stream5.service.MyChannel;
import com.cloud.stream5.vo.User;


@Component
@EnableBinding(MyChannel.class)//内部集成了@inport配置类，在 加载了各种配置后再回来读取value中的类，指定一个或多个定义了@Input或@Output注解的接口.以此实现对消息通道（channel）的绑定。
public class Reveicer {

	
	@StreamListener(MyChannel.INPUT)//@StreamListener用于监听通道，由于生产者发送的是String，所以接收用Message<String> 
	public void reveicer(User user){//user对象的两种结果：1如果User是分别在生产者和消费者中定义的，并且包路径不同，那么会报错反序列化失败。原因是SCS会默认将POJO转换成二进制发送，并且携带包路径等信息；2，如果生产者和消费者使用的User是同一定义，或分别定义但包路径相同，那么就不会报错。


		System.err.println(user.getName());
//		System.err.println("\n" + message.getPayload());
	}
	@SendTo(MyChannel.OUTPUT_3)
	@StreamListener(MyChannel.INPUT2)//@StreamListener用于监听通道，由于生产者发送的是String，所以接收用Message<String> 
	public String reveicer2(String paylocad){//user对象的两种结果：1如果User是分别在生产者和消费者中定义的，并且包路径不同，那么会报错反序列化失败。原因是SCS会默认将POJO转换成二进制发送，并且携带包路径等信息；2，如果生产者和消费者使用的User是同一定义，或分别定义但包路径相同，那么就不会报错。
		
		
		System.err.println(paylocad);
		return "bbbbbbbbbb";
	}
}
