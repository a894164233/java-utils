package com.baitao.javautils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.baitao.javautils")
public class JavaUtilsApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(JavaUtilsApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaUtilsApplication.class, args);
	}
}
