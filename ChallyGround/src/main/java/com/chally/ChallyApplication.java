package com.chally;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.chally.dao") 
public class ChallyApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChallyApplication.class, args);
	}
}