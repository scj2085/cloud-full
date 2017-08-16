package com.cloud.consume_feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Feign;
import feign.Logger;

/**
 * 
 * @author shichangjian
 *
 */
@Configuration
public class DisableHystrixConfiguration {
	
	
//	@Bean
//	@Scope("prototype")
//	public Feign.Builder feignBuilder(){//针对某个客户端关闭hystrix支持，用在@FeignClient注解中，指定此配置类
//		
//		return Feign.builder();
//	}

	@Bean
	Logger.Level feignLoggerLevel(){//日志级别，在@FeignClicent注解中，指定此注解类
		
		return Logger.Level.FULL; 
	}
}
