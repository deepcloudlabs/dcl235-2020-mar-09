package com.example.service;

import java.util.Objects;

public class MyLazyThreadSafeCacheCoherentLotteryService {
	private static volatile MyLazyThreadSafeCacheCoherentLotteryService instance = null;

	private MyLazyThreadSafeCacheCoherentLotteryService() {

	}

	public static synchronized MyLazyThreadSafeCacheCoherentLotteryService getInstance() {
		if (Objects.isNull(instance)) {
			instance = new MyLazyThreadSafeCacheCoherentLotteryService();
		}
		return instance;
	}

}
