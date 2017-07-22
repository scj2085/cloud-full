package com.cloud.cloudtest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Hello world!
 *
 */
@EnableAutoConfiguration // 整合mybatis使用
@EnableDiscoveryClient // @EnableDiscoveryClient注解，用来发现config-server服务，利用其来加载应用配置,该注解能激活Eureka中的DiscoveryClient实现，才能实现Controller中对服务信息的输出
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		new SpringApplicationBuilder(App.class).web(true).run(args);
	}
}
