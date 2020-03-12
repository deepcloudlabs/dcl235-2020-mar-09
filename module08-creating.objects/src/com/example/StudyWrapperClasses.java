package com.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudyWrapperClasses {

	public static void main(String[] args) {
		// -Djava.lang.Integer.IntegerCache.high=1024
		int x = 42; // 4-byte, Stack, Value-type (primitive)
		// y: Reference Variable (64-bit) (4 Byte)
		// Compressed Oops
		Integer y = Integer.valueOf(42); // Java SE 5 (Auto Boxing) 
		            // Heap: 12 Byte + 4 Byte = 16 Byte
		List<Integer> numbers ;
		Integer a = Integer.valueOf(42);
		Integer b = Integer.valueOf(42);
		Integer u = Integer.valueOf(549);
		Integer v = Integer.valueOf(549);
		System.out.println(a==b); // true
		System.out.println(u==v);
		int []q = new int[0];
		var nums = List.of(1,2,3,4,5,6,7);
		var codes = Map.of(
			"istanbul-anadolu", 216, 
			"istanbul-avrupa", 212,
			"ankara", 312);
	}

}
