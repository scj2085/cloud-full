package com.cloud.consume_ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient//@EnableDiscoveryClient注解来添加发现服务能力
@EnableCircuitBreaker//@EnableCircuitBreaker注解开启断路器功能，在feign中无需添加 ，自带的
public class RibbonApplication {
	
	@Bean
	@LoadBalanced//@LoadBalanced注解开启均衡负载能力
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}
}
