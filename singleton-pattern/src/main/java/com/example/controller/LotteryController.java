package com.example.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.LotteryService;

@RestController
@RequestMapping("numbers")
@CrossOrigin
public class LotteryController {
	private LotteryService lotteryService;
	
	public LotteryController(LotteryService lotteryService) {
		System.err.println("LotteryController is created!");
		this.lotteryService = lotteryService;
	}

	@PostConstruct
	public void init() {
		System.err.println("RestController is created!");
	}
	
	@GetMapping
	public List<List<Integer>> getNumbers(@RequestParam int n){
		return lotteryService.draw(n);
	}
}
