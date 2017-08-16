package com.cloud.consume_feign.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.consume_feign.service.ComputeClient;
import com.cloud.consume_feign.vo.User;

/**
 * Hystrix服务降级
 * @author shichangjian
 *
 */
@Component
public class ComputeClientHystrix implements ComputeClient {

	public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
		return -9999;
	}

	@Override
	public String hello1(@RequestParam("name1") String name1) {
		// TODO Auto-generated method stub
		return "error";
	}

	@Override
	public User hello2(@RequestHeader("name1") String name1,@RequestHeader("age") Integer age) {
		// TODO Auto-generated method stub
		return new User("error2",00);
	}

	@Override
	public Integer hello3(@RequestBody User user) {
		// TODO Auto-generated method stub
		return 3;
	}
	
}
