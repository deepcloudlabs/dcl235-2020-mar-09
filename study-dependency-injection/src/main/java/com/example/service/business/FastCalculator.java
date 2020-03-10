package com.example.service.business;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

import com.example.service.Calculator;

@Service
//@ConditionalOnProperty(name="qos",havingValue = "fast")
public class FastCalculator implements Calculator {

	public FastCalculator() {
		System.err.println("FastCalculator() is created.");
	}

	@PostConstruct // Life-cycle Callback Annotation
	public void init() {
		System.err.println("FastCalculator() is initializec.");
	}

	@PreDestroy
	public void destroy() {
		System.err.println("FastCalculator() is destroyed.");
	}

	@Override
	public double add(double x, double y) {
		System.err.println("FastCalculator::add");
		return x + y;
	}

	@Override
	public double sub(double x, double y) {
		return x - y;
	}

	@Override
	public double mul(double x, double y) {
		return x * y;
	}

	@Override
	public double div(double x, double y) {
		return x / y;
	}

}
