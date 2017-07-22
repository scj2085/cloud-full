package com.cloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableZipkinStreamServer// //使用Stream方式启动ZipkinServer，点击@EnableZipkinStreamServer注解的源码我们可以看到它也引入了@EnableZipkinServer注解，同时还创建了一个rabbit-mq的消息队列监听器。
public class ZipkinApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZipkinApplication.class, args);
	}
}
