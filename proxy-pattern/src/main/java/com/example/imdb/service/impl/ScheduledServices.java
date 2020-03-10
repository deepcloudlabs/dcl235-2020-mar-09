package com.example.imdb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledServices {
	@Autowired
	private BinanceService binanceService;

	@Scheduled(fixedRate = 3_000)
	public void run() {
		System.out.println(binanceService.callBinance());
	}
}
