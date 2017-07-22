package com.cloud.sleuth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class SleuthController {

	private static Logger logger = LoggerFactory.getLogger(SleuthController.class);
	
    @Autowired
    RestTemplate restTemplate;
    
	@RequestMapping(value = "/trace-1", method = RequestMethod.GET)
	public String trace() {
		logger.info("***********trace-1******************");
		return restTemplate.getForEntity("http://trace-2/trace-2",String.class).getBody();
	}
}
