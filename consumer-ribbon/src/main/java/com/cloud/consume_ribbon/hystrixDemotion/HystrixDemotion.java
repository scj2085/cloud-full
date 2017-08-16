package com.cloud.consume_ribbon.hystrixDemotion;
import org.springframework.web.client.RestTemplate;

import com.cloud.consume_ribbon.vo.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * 服务降级
 * @author shichangjian
 *
 */
public class HystrixDemotion extends HystrixCommand<User>{

	private RestTemplate restTemplate;
	private Long id;
	
	

	public HystrixDemotion(Setter setter,RestTemplate restTemplate,Long id){
		super(setter);
		this.restTemplate = restTemplate;
		this.id = id;
	}

	@Override
	protected User run() throws Exception {
		return restTemplate.getForObject("http://approve/addHystrixDemotion/{1}",User.class,id);
	}
	protected User getFallback(){
		return new User();
	}
}
