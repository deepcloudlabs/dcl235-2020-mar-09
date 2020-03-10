package com.example.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.inject.Singleton;

@Named
//@Singleton
@ApplicationScoped
public class LotteryService {
	private AtomicInteger counter = new AtomicInteger();

	public LotteryService() {
		System.err.println("Lottery is created once!");
	}

	public List<List<Integer>> draw(int n) {
		counter.addAndGet(n);
		return IntStream.range(0, n).mapToObj(i -> draw()).collect(Collectors.toList());
	}

	public List<Integer> draw() {
		return ThreadLocalRandom.current().ints(1, 50).distinct().limit(6).sorted().boxed()
				.collect(Collectors.toList());
	}

	public int getCounter() {
		return counter.get();
	}

}
