package com.cloud.stream2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Stream2Application {
	public static void main(String[] args) {
		new SpringApplicationBuilder(Stream2Application.class).web(true).run(args);
	}
}
