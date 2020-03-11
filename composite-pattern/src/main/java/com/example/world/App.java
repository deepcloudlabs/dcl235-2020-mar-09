package com.example.world;

import java.util.Arrays;
import java.util.List;

import com.example.world.domain.City;
import com.example.world.domain.Country;
import com.example.world.domain.Statistics;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(turkey);
		System.out.println(json);
		Country country = mapper.readValue(json, Country.class);
		System.out.println(country);
	}

	public static double doDataAnalytics(List<Statistics> data) {
		return data.stream().mapToDouble(Statistics::getGnp).sum() / data.size();
	}
}
