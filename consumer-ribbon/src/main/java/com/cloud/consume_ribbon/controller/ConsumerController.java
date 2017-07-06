package com.cloud.consume_ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cloud.consume_ribbon.serviceImpl.ComputeService;

/**
 * 来消费COMPUTE-SERVICE的add服务。通过直接RestTemplate来调用服务，计算10 + 20的值。
 * 
 * @author shichangjian
 *
 */
@RestController
public class ConsumerController {

	@Autowired
	private ComputeService computeService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return computeService.addService();
	}
}
