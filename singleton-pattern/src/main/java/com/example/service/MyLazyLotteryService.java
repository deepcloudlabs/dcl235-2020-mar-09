package com.example.service;

import java.util.Objects;

public class MyLazyLotteryService {
	private static MyLazyLotteryService instance = null;

	private MyLazyLotteryService() {

	}

	public static MyLazyLotteryService getInstance() {
		if (Objects.isNull(instance)) {
			instance = new MyLazyLotteryService();
		}
		return instance;
	}

}
