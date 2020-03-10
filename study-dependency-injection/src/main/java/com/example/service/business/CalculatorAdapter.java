package com.example.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.Calculator;

@Service
public class CalculatorAdapter implements Calculator {
	@Autowired
	private ComplexCalculator cc;

	public CalculatorAdapter() {
		System.err.println("CalculatorAdapter() is created!");
	}

	@Override
	public double add(double x, double y) {
		System.err.println("CalculatorAdapter::add");
		return cc.topla(x, y);
	}

	@Override
	public double sub(double x, double y) {
		return cc.eksilt(x, y);
	}

	@Override
	public double mul(double x, double y) {
		double sum = 0.0;
		for (double z = 0; z < x; z += 1.0)
			sum = cc.topla(sum, y);
		return sum;
	}

	@Override
	public double div(double x, double y) {
		double div = 0;
		while (x > 0) {
			x = cc.eksilt(x, y);
			div++;
		}
		return div;
	}

}
