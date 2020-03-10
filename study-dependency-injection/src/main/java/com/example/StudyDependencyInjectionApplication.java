package com.example;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.Calculator;

// -Dspring.profiles.active=prod
@SpringBootApplication
public class StudyDependencyInjectionApplication implements ApplicationRunner {
	
	//	@Autowired
//	private Calculator calc;
	@Autowired
	private List<Calculator> calcs;
	@Autowired
	private Map<String,Calculator> calcsMap;
	@Value("#{constantService.fun(10)}")
	private int x;
	@Value("#{constantService.fun(20)}")
	private int y;

	public static void main(String[] args) {
		SpringApplication.run(StudyDependencyInjectionApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Vector<Integer> nums = new Vector<>();
		nums.addElement(42);
		nums.add(4);
		List<Integer> numbers = nums;
		
		System.err.println(calcs.getClass());
		System.err.println(calcsMap.getClass());
		calcs.forEach( calc -> 
		     System.err.println(calc.add(x, y))
		);
		calcsMap.forEach( (name,calc) -> 
		        System.err.println(calc.add(x, y))
		);
	}

}
