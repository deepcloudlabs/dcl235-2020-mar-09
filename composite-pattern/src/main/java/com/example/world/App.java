package com.example.world;

import java.util.Arrays;
import java.util.List;

import com.example.world.domain.City;
import com.example.world.domain.Country;
import com.example.world.domain.Statistics;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		Country turkey = new Country("TUR", "Turkey", "Asia");
		City ankara = new City(1, "Ankara", 4_500_000, 8_000, 100000, turkey);
		City istanbul = new City(2, "İstanbul", 23_500_000, 9_000, 200000, turkey);
		turkey.setCapital(ankara);
		turkey.setCities(Arrays.asList(ankara, istanbul));
		Statistics countryStats = turkey;
		System.out.println(countryStats.getSurfaceArea());
		System.out.println(countryStats.getPopulation());
		System.out.println(countryStats.getGnp());
		System.out.println(Arrays.asList(turkey));
		System.out.println(Arrays.asList(ankara));
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(turkey);
		System.out.println(json);
		String jsonIn = "{\"code\":\"TUR\",\"name\":\"Turkey\",\"continent\":\"Asia\",\"capital\":{\"id\":1,\"name\":\"Ankara\",\"population\":4500000,\"gnp\":8000.0,\"surfaceArea\":100000.0},\"cities\":[1,{\"id\":2,\"name\":\"İstanbul\",\"population\":23500000,\"gnp\":9000.0,\"surfaceArea\":200000.0}],\"population\":28000000,\"surfaceArea\":300000.0,\"gnp\":17000.0}";
		Country country = mapper.readValue(jsonIn, Country.class);
		System.out.println(country);
	}
	public static double doDataAnalytics(List<Statistics> data) {
		return data.stream().mapToDouble(Statistics::getGnp).sum()
				/ data.size();
	}
}
