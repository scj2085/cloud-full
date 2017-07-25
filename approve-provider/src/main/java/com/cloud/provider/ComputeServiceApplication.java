package com.cloud.provider;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;




/**
 * Hello world
 *
 */
@EnableAutoConfiguration	//整合mybatis使用，自动装配
@EnableDiscoveryClient		//@EnableDiscoveryClient注解，该注解能激活Eureka中的DiscoveryClient实现,用来注册到eureks服务和发现其它服务，才能实现本服务对其它服务信息的输出
@SpringBootApplication
public class ComputeServiceApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ComputeServiceApplication.class).web(true).run(args);
	}
}
