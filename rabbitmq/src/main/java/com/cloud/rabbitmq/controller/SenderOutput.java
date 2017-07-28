package com.cloud.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.rabbitmq.service.SinkSender;

@RestController
public class SenderOutput {

	@Autowired
	private SinkSender sinkSender;
	
	@RequestMapping(value = "/output",method = RequestMethod.GET)
	public void output(){
		sinkSender.output().send(MessageBuilder.withPayload("From SinkSender").build());
	}
}
