package com.cloud.consume_ribbon.controller;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cloud.consume_ribbon.serviceImpl.ComputeService;
import com.cloud.consume_ribbon.vo.User;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;

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
    
    @Autowired
    private SpringClientFactory clientFactory;

    @RequestMapping("/getServerList")
    public void getServerList() throws Exception {
        ZoneAwareLoadBalancer<Server> lb = (ZoneAwareLoadBalancer<Server>) clientFactory.getLoadBalancer("approve");
        ServerList<Server> serverList = lb.getServerListImpl();


        List<Server> serverDetailList = serverList.getInitialListOfServers();
        if (!CollectionUtils.isEmpty(serverDetailList)) {
            for (Server s : serverDetailList) {
                System.err.println(s.getHost() + "," + s.getPort());
            }
        } else {
            System.err.println("no service");
        }


    }
    
    
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add() {
		System.err.println("***************88");
	
		return computeService.addService();
	}
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public User addUser() {
		System.err.println("***************89");
		int a = 0;
//		if(a == 0) throw new RuntimeException("00000000000000");
		return a == 0 ? computeService.addUser():computeService.addUser(); 
	}
	@RequestMapping(value = "/addUserMap", method = RequestMethod.GET)
	public User addUserMap() {
		System.err.println("***************99");
		return computeService.addUserMap();
	}
	@RequestMapping(value = "/addUserObject", method = RequestMethod.GET)
	public User addUserObject() {
		System.err.println("***************100");
		return computeService.addUserObject();
	}
	@RequestMapping(value = "/addUserPost", method = RequestMethod.GET)
	public User addUserPost() {
		System.err.println("***************111");
		return computeService.addUserPost();
	}
	@RequestMapping(value = "/addUserPostUri", method = RequestMethod.GET)
	public User addUserPostUri() {
		System.err.println("***************111");
		return computeService.addUserPostUri();
	}
	@RequestMapping(value = "/addUserPUT", method = RequestMethod.GET)
	public User addUserPUT() {
		System.err.println("***************222");
		return computeService.addUserPUT();
	}
	@RequestMapping(value = "/addUserDelete", method = RequestMethod.GET)
	public User addUserDelete() {
		System.err.println("***************222");
		return computeService.addUserDelete();
	}
	@RequestMapping(value = "/trace-1", method = RequestMethod.GET)
	public String trace() {
		logger.info("***********trace-1******************");
		return restTemplate.getForEntity("http://trace-2/trace-2",String.class).getBody();
	}
}
