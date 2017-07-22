package com.cloud.sleuth2;

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
@EnableDiscoveryClient // @EnableDiscoveryClient注解来添加发现服务能力
@EnableCircuitBreaker
public class Strace2Application {
	
	@Bean
	@LoadBalanced//@LoadBalanced注解开启均衡负载能力
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Strace2Application.class, args);
	}
}
