package com.cloud.consume_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Hello world!
 *feign自带hystrix断路器，无需显式添加hystrix
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients // @EnableFeignClients注解开启Feign功能
public class FeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}
}
