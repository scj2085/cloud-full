package com.cloud.stream3;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Stream3Application {
	public static void main(String[] args) {
		new SpringApplicationBuilder(Stream3Application.class).web(true).run(args);
	}
}
