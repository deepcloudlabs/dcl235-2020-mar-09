package com.example;

import static com.example.service.MySingletonLotteryService.INSTANCE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SingletonPatternApplication {

	public static void main(String[] args) {
		INSTANCE.fun();
		SpringApplication.run(SingletonPatternApplication.class, args);
	}

}
