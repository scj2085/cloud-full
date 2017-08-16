package com.cloud.consume_feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.consume_feign.service.ComputeClient;
import com.cloud.consume_feign.vo.User;

@RestController
public class ConsumerController {

	@Autowired
	ComputeClient computeClient;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add() {
		return computeClient.add(10,2);
	}
	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	public String hello1() {
		return computeClient.hello1("ok");
	}
	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public User hello2() {
		return computeClient.hello2("hello2",2);
	}
	@RequestMapping(value = "/hello3", method = RequestMethod.GET)
	public Integer hello3() {
		return computeClient.hello3(new User("ok",99));
	}
}
