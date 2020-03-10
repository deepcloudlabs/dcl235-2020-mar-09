package com.example.service;

import java.util.Objects;

public class MyLazyThreadSafeLotteryService {
	private static MyLazyThreadSafeLotteryService instance = null;

	private MyLazyThreadSafeLotteryService() {

	}

	public static synchronized MyLazyThreadSafeLotteryService getInstance() {
		if (Objects.isNull(instance)) {
			instance = new MyLazyThreadSafeLotteryService();
		}
		return instance;
	}

}
