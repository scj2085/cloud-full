package com.cloud.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.rabbitmq.service.impl.Sender;

@RestController
public class SenderOutput {

	@Autowired
	private Sender sender;
	
	/**
	 * 消息生产者 
	 */
	@RequestMapping(value = "/sender",method = RequestMethod.GET)
	public void output(){
		sender.send();
	}
}
