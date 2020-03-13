package com.example.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@EnableRetry
public class HrApiSpringBootClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApiSpringBootClientApplication.class, args);
	}

}
