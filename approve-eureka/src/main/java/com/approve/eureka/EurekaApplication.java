package com.approve.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@EnableEurekaServer//提供一个服务注册中心，给其它应用进行对话
@SpringBootApplication
public class EurekaApplication {
	public static void main(String[] args) {
		//web(true标志显式请求Web或非Web环境（如果未设置，则根据类路径自动检测）
		//使用提供的命令行参数创建一个应用程序上下文（及其父代，如果指定）。
		new SpringApplicationBuilder(EurekaApplication.class).web(true).run(args);
	}
}
