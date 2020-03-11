package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.service.LotteryService;

@Configuration
public class AppConfig {
	@Bean(name = "elma")
	public LotteryService lotteryService() {
		return new LotteryService();
	}
}
