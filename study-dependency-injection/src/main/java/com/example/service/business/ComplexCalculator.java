package com.example.service.business;

import org.springframework.stereotype.Service;

@Service
public class ComplexCalculator {
	public double topla(double a, double b) {
		System.err.println("ComplexCalculator::add");
		return a + b;
	}

	public double eksilt(double a, double b) {
		return a - b;
	}
}
