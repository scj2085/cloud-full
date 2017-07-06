package com.cloud.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;




/**
 * Hello world!
 *
 */
@EnableDiscoveryClient//@EnableDiscoveryClient注解，用来发现config-server服务，利用其来加载应用配置,该注解能激活Eureka中的DiscoveryClient实现，才能实现Controller中对服务信息的输出
@SpringBootApplication
public class ComputeServiceApplication {
	
	
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ComputeServiceApplication.class).web(true).run(args);
	}
}
