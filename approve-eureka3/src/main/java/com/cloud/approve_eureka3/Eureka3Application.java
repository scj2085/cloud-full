package com.cloud.approve_eureka3;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * Hello world!
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class Eureka3Application {
	public static void main(String[] args) {
		new SpringApplicationBuilder(Eureka3Application.class).web(true).run(args);
	}
}
