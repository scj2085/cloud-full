package com.cloud.approve_config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 当连接不到远程git会连接本地的git仓库，
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient//@EnableDiscoveryClient注解，用来将config-server注册到配置的服务注册中心上去。
@EnableConfigServer // @EnableConfigServer注解，开启Config Server
public class ConfigApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigApplication.class).web(true).run(args);
	}

}
