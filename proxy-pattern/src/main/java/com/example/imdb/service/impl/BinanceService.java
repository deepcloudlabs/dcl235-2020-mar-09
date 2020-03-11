package com.example.imdb.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BinanceService {

	public String callBinance() {
		RestTemplate rt = new RestTemplate();
		return rt.getForEntity("https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT", String.class).getBody();
	}
}
