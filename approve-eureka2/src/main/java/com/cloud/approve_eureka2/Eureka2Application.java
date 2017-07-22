package com.cloud.approve_eureka2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * Hello world!
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class Eureka2Application {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(Eureka2Application.class).web(true).run(args);
	}
}
