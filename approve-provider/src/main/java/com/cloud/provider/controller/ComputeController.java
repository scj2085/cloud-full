package com.cloud.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.provider.dao.IApproveDao;
import com.cloud.provider.domain.Schedule;



@RestController
public class ComputeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private DiscoveryClient client;
    
    @Autowired
    private IApproveDao iApproveDao;
    
    
    /**
     * 我们实现一个RESTful API，通过传入两个参数a和b，最后返回a + b的结果。
     * @param a
     * @param b
     * @return
     */
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
    	
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        
        Schedule schedule = iApproveDao.find(1043);
        long c = schedule.getId();
        
//        return Long.bitCount(c);
        return r;
    }
}
