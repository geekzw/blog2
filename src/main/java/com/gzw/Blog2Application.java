package com.gzw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = "com.gzw.mappers")
@EnableScheduling
public class Blog2Application {

	public static void main(String[] args) {
		SpringApplication.run(Blog2Application.class, args);
	}
}
