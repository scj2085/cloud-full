package com.cloud.consume_feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.consume_feign.config.DisableHystrixConfiguration;
import com.cloud.consume_feign.service.impl.ComputeClientHystrix;
import com.cloud.consume_feign.vo.User;


/**
 * 向approve-provider服务发送请求，并访问/add接口
 * @author shichangjian
 *
 */
//@FeignClient(value = "approve", fallback = ComputeClientHystrix.class)//fallback对服务降级的处理
@FeignClient(value = "approve",fallback = ComputeClientHystrix.class,configuration = DisableHystrixConfiguration.class)//fallback对服务降级的处理,configuration是针对approve一个服务的设置，关闭hystrix支持
public interface ComputeClient {

	@RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
	
	@RequestMapping(method = RequestMethod.GET, value = "/hello1")
	String hello1(@RequestParam("name1") String name1);
	
	@RequestMapping(method = RequestMethod.GET, value = "/hello2")
	User hello2(@RequestHeader("name1") String name1, @RequestHeader("age") Integer age);
	
	@RequestMapping(method = RequestMethod.POST, value = "/hello3")
	Integer hello3(@RequestBody User user);
	
}
