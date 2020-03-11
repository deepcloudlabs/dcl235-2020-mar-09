package com.example.imdb.controller;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.imdb.entity.Movie;
import com.example.imdb.service.MovieService;

@RestController
@RequestMapping("movies")
@Validated
public class ImdbController {
	@Autowired
	private MovieService movieSrv;

	@GetMapping("{id}")
	public Movie getMovie(@PathVariable @Validated @Min(1) int id) {
		System.err.println("Delegating to " + movieSrv.getClass());
		return movieSrv.findMovieById(id);
	}
}
