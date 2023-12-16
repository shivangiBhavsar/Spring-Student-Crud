package com.studentcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.studentcrud")
public class SpringBootHelloWorldExampleApplication extends SpringBootServletInitializer
{
	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(SpringBootHelloWorldExampleApplication.class);
	    }
public static void main(String[] args) 
{
SpringApplication.run(SpringBootHelloWorldExampleApplication.class, args);
}
}