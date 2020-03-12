package com.example.exercises;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.domain.Director;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise1 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the number of movies of each director
        final Collection<Movie> movies = 
        		movieService.findAllMovies();
        System.out.println(movies);
        Map<Director,Integer> directors = new HashMap<>();
        // External Loop
        for (Movie movie : movies) {
        	for (Director director : movie.getDirectors()) {
        		Integer numOfMovies = directors.get(director);
        		if (Objects.isNull(numOfMovies))
        			numOfMovies = 0;
        		numOfMovies++;
        		directors.put(director, numOfMovies);
        	}
        }
        for (Map.Entry<Director, Integer> entry : directors.entrySet())
        	System.out.println(entry.getKey().getName()+": "+entry.getValue());
        movies.parallelStream().forEach( movie -> System.out.println(movie));
        Map<String,Long> dirMovCounts =
        		movies.stream().map( Movie::getDirectors )
                       .flatMap(Collection::stream)
                       .collect(Collectors.groupingBy(Director::getName,Collectors.counting()));
        dirMovCounts.forEach((name,count)->System.out.println(name+": "+count)); 
	}

}




