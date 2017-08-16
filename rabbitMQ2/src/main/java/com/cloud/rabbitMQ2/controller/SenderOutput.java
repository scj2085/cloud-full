package com.cloud.rabbitMQ2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.rabbitMQ2.service.Receiver;


@RestController
public class SenderOutput {

//	@Autowired
//	private Receiver receiver;
//	
//	@RequestMapping(value = "/output",method = RequestMethod.GET)
//	public void output(){
//		receiver.process(hello);
//	}
}
