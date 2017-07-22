package com.cloud.consume_ribbon.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ComputeService {

    @Autowired
    RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public Integer addService() {
    	Integer aa = restTemplate.getForEntity("http://approve/add?a=10&b=20", Integer.class).getBody();
    	System.err.println("********************" + aa);
        return aa;
    }
    
    public Integer addServiceFallback() {
        return 0;
    }
}
