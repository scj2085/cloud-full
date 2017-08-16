package com.cloud.consume_ribbon.hystrixDemotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.cloud.consume_ribbon.vo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;

/**
 * 注解实现缓存清理
 * @author shichangjian
 *
 */
public class HystrixNoteRemoveCache {

	@Autowired
	private RestTemplate restTemplate;
	
	@CacheResult
	public User getUserById(Long id){
		return restTemplate.getForObject("http://approve/addCache/{1}",User.class,id);
	}
	@CacheRemove(commandKey = "getUserById")
	@HystrixCommand
	public User update(@CacheKey("id") User user){
		return restTemplate.postForObject("http://approve/removeCache",user,User.class);
	}
}
