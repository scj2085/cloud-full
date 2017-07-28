package com.cloud.provider.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.provider.dao.IApproveDao;
import com.cloud.provider.domain.Schedule;
import com.cloud.provider.vo.User;
import com.cloud.provider.vo.User1;



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
    @RequestMapping(value = "/addUser" ,method = RequestMethod.GET)
    public User addUser(@RequestParam("name1") String name1) {
    	
    	ServiceInstance instance = client.getLocalServiceInstance();
    	logger.info("/addUser, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + name1);
    	User user = new User();
    	user.setName1("李四");
    	return user;
    }
    @RequestMapping(value = "/addUserMap" ,method = RequestMethod.GET)
    public User addUserMap(@RequestParam("name") String name) {
    	
    	ServiceInstance instance = client.getLocalServiceInstance();
    	logger.info("/addUser, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + name);
    	User user = new User();
    	user.setName1("李四");
    	return user;
    }
    @RequestMapping(value = "/addUserMapList2" ,method = RequestMethod.GET)
    public User addUserMapList2(@RequestParam("name") String name) {
    	
    	ServiceInstance instance = client.getLocalServiceInstance();
    	logger.info("/addUser, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + name);
    	User user = new User();
    	user.setName1("李四");
    	return user;
    }
    @RequestMapping(value = "/addUserPost" ,method = RequestMethod.POST)
    public User addUserPost(@RequestBody User name) {
    	
    	ServiceInstance instance = client.getLocalServiceInstance();
    	logger.info("/addUser, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + name);
    	User user = new User();
    	user.setName1("李四");
    	return user;
    }
    @RequestMapping(value = "/addUserPUT" ,method = RequestMethod.PUT)
    public User addUserPUT(@RequestBody User user) {
    	
    	ServiceInstance instance = client.getLocalServiceInstance();
    	logger.info("/addUser, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + user);
    	User u = new User();
    	u.setName1("李四");
    	return u;
    }
    @RequestMapping(value = "/addUserDelete" ,method = RequestMethod.DELETE)
    public User addUserDelete(@RequestParam("name1") String name1) {
    	
    	ServiceInstance instance = client.getLocalServiceInstance();
    	logger.info("/addUser, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + name1);
    	User u = new User();
    	u.setName1("李四");
    	return u;
    }
}
