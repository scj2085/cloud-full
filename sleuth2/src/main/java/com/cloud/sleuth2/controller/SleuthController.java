package com.cloud.sleuth2.controller;

import javax.servlet.http.HttpServletRequest;

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
    
	@RequestMapping(value = "/trace-2", method = RequestMethod.GET)
	public String trace(HttpServletRequest request) {
		logger.info("***********trace-2******************");
		logger.info("***********==<call trace-2,TraceId={},SpanId={}>==******************",request.getHeader("X-B3-TraceId"),request.getHeader("X-B3-SpanId"));
		return "Trace";
	}
}
