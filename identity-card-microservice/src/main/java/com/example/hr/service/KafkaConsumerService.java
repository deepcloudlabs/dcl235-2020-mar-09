package com.example.hr.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.hr.entity.Employee;

@Service
public class KafkaConsumerService {
	@KafkaListener(topics = "employees")
	public void poll(Employee emp) {
		System.err.println("New event has arrived: " + emp);
	}
}
