package com.example.service;

public abstract interface Calculator {
	double add(double x, double y);

	double sub(double x, double y);

	double mul(double x, double y);

	double div(double x, double y);

	default double kilometer2Mile(double km) {
		return mul(2 , km);
	};

	default double kilogram2Newton(double kg) {
		return kg;
	};
}
