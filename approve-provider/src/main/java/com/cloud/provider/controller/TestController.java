package com.cloud.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Value("${from}")
    private String from;
    
    @Value("${approve}")
    private String approve;
    
    @Value("${db}")
    private String db;
    
    @Value("${random}")
    private int random;
    
    @RequestMapping("/from")
    public String from() {
        return this.from;
    }
    
    @RequestMapping("/approve")
    public String approve() {
    	return this.approve;
    }
    @RequestMapping("/db")
    public String db() {
    	return this.db;
    }
    @RequestMapping("/random")
    public int random() {
    	return this.random;
    }
}
