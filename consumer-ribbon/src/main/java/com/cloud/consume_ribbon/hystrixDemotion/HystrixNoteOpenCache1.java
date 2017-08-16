package com.cloud.consume_ribbon.hystrixDemotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.cloud.consume_ribbon.vo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;

/**
 * 注解实现缓存
 * @author shichangjian
 *
 */
public class HystrixNoteOpenCache1 {

	@Autowired
	private RestTemplate restTemplate;
	
	@CacheResult
	@HystrixCommand
	public User getUserById(@CacheKey("id") Long id){//如果已经使用了@CacheKeyMethod指定缓存key的生成函数，那么@CacheKey注解不会生效，@CacheKeyMethod的优先级别高
//		public User getUserById(@CacheKey("id") Long id){//还可以访问参数对象内部属性作为缓存key，如(@CacheKey("id") User user)
		return restTemplate.getForObject("http://approve/addCache/{1}",User.class,id);
	}
	private Long getUserByIdCacheKey(Long id){
		return id;
	}
}
