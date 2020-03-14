package com.example;

import java.util.List;

public class StudyParallelStream {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(8, 2, 3, 4, 5, 6, 7, 1);
		numbers.parallelStream().filter(i -> i % 2 == 1).sorted().forEach(System.out::println);
		numbers.stream().filter(i -> i % 2 == 1).parallel().sorted().sequential().forEach(System.out::println);
	}

}
