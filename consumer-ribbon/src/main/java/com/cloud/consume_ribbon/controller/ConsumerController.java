package com.cloud.consume_ribbon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static Logger logger = LoggerFactory.getLogger(ConsumerController.class);
	
	@Autowired
	private ComputeService computeService;
    @Autowired
    RestTemplate restTemplate;
    
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add() {
		System.err.println("***************88");
		return computeService.addService();
	}
	@RequestMapping(value = "/trace-1", method = RequestMethod.GET)
	public String trace() {
		logger.info("***********trace-1******************");
		return restTemplate.getForEntity("http://trace-2/trace-2",String.class).getBody();
	}
}
