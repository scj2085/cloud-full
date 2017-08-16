package com.cloud.consume_ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 可以通过提供服务方配置的ribbonServerList服务端列表去轮询访问以达到均衡负载的作用，
 * 和eureka联合使用时，ribbonServerList会被DiscoveryEnabledNIWSServerList重写，从eureka注册中心获取服务端列表，
 * 将职责委托给eureka来确定服务端已经启动
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient//@EnableDiscoveryClient注解来添加发现服务能力
@EnableCircuitBreaker//@EnableCircuitBreaker注解开启断路器功能，在feign中无需添加 ，自带的
//@SpringCloudApplication//此注解可以代替上面三个
public class RibbonClientApplication {
	
	@Bean
	@LoadBalanced//@LoadBalanced用来给RestTemplate做标记，以使用负载均衡的客户端LoadBalancedClient来配置它，注解开启均衡负载能力，负载均衡的规则：使用线性遍历ping服务实例的方式进行检查
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RibbonClientApplication.class, args);
	}
}
