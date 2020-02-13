package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
@MapperScan("com.repository")
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

	}

	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
				.allowCredentials(true)
				.allowedHeaders("*")
				.allowedOrigins("*")
				.allowedMethods("*");
	}

}
