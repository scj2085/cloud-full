package com.cloud.consume_ribbon.hystrixDemotion;

import org.springframework.web.client.RestTemplate;

import com.cloud.consume_ribbon.vo.User;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommand.Setter;

/**
 * 当对HystrixDemotion2实现了请求缓存之后，势必需要为UserPostCommand命令实现缓存的清理，以保证User被更新之后，Hystrix请求缓存中相同缓存key的结果被移除，这样在下次获取User的时候不会从缓存中获取到 未更新的结果
 * @author shichangjian
 *
 */
public class HystrixCloseCache3 extends HystrixCommand<User>{

	private RestTemplate restTemplate;
	private User user;
	
	public HystrixCloseCache3(RestTemplate restTemplate,Long id){
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetSetGet")));
		this.restTemplate = restTemplate;
		this.user = user;
	}

	@Override
	protected User run() {
		//写操作
		User r = restTemplate.postForObject("http://USER-SERVICE/users",user,User.class);
		//刷新缓存，清理缓存中失效的User
		HystrixOpenCache2.flushCache(user.getId());
		return r;
	}
}
