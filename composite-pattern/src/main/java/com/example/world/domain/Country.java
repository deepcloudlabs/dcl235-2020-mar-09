package com.example.world.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code")
public class Country implements Statistics {
	private String code;
	private String name;
	private String continent;
	@JsonManagedReference
	private City capital;
	@JsonManagedReference
	private List<City> cities = new ArrayList<>();

	public Country() {
	}

	public Country(String code, String name, String continent) {
		this.code = code;
		this.name = name;
		this.continent = continent;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public double getSurfaceArea() {
		return cities.stream().mapToDouble(City::getSurfaceArea).sum();
	}

	public double getGnp() {
		return cities.stream().mapToDouble(City::getGnp).sum();
	}

	public City getCapital() {
		return capital;
	}

	public void setCapital(City capital) {
		this.capital = capital;
	}

	public int getPopulation() {
		return cities.stream().mapToInt(City::getPopulation).sum();
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<City> getCities() {
		return cities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + ", continent=" + continent + ", surfaceArea="
				+ getSurfaceArea() + ", population=" + getPopulation() + ", gnp=" + getGnp() + ", capital=" + capital
				+ ", cities=" + cities + "]";
	}

}
