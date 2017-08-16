package com.cloud.consume_ribbon.hystrixDemotion;

import org.springframework.web.client.RestTemplate;

import com.cloud.consume_ribbon.vo.User;
import com.netflix.hystrix.HystrixCommand.Setter;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;

/**
 * 开启缓存请求功能
 * @author shichangjian
 *
 */
public class HystrixOpenCache2 extends HystrixDemotion{
	
	private static final HystrixCommandKey GETTER_KEY = HystrixCommandKey.Factory.asKey("CommandKey");
	private RestTemplate restTemplate;
	private Long id;
	
	

	public HystrixOpenCache2(RestTemplate restTemplate,Long id){
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetSetGet")).andCommandKey(GETTER_KEY), restTemplate, id);
		this.restTemplate = restTemplate;
		this.id = id;
	}

	@Override
	protected User run() throws Exception {
		return restTemplate.getForObject("http://approve/addHystrixDemotion/{1}",User.class,id);
	}
	//把id放入缓存
	protected String getCacheKey(){
		return String.valueOf(id);
	}
	//刷新缓存，根据id进行清理
	public static void flushCache(Long id){
		HystrixRequestCache.getInstance(GETTER_KEY, HystrixConcurrencyStrategyDefault.getInstance()).clear(String.valueOf(id));
	}
}
