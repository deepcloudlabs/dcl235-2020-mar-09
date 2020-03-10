package com.example.service;

public class MyEagerLotteryService {
	private static final MyEagerLotteryService instance = new MyEagerLotteryService();

	private MyEagerLotteryService() {

	}

	public static MyEagerLotteryService getInstance() {
		return instance;
	}

}
