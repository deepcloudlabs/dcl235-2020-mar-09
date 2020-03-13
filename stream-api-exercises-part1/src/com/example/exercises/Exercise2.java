package com.example.exercises;

import java.util.Collection;
import java.util.Comparator;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise2 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the most populated city of each continent
		countryDao.findAllCountries().stream().map(Country::getCities).flatMap(Collection::stream)
				.max(Comparator.comparing(City::getPopulation)).ifPresent(System.out::println);
	}

}
