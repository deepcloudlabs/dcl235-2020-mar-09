package com.example.imdb;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.imdb.config.DatabaseConfig;
import com.example.imdb.entity.Movie;
import com.example.imdb.repository.MovieRepository;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext container =
				new AnnotationConfigApplicationContext(DatabaseConfig.class);
		MovieRepository repo = container.getBean(MovieRepository.class);
		System.err.println(repo.getClass());
//		repo.findOneById(1).ifPresent(System.out::println);
//		repo.findAll(4, 10).forEach(System.out::println);
//		repo.findAllByYearBetween(1970, 1979).forEach(System.out::println);
		Movie movie = new Movie("My Movie 55",2020,"tt124459");
		repo.save(movie).ifPresent(System.err::println);
//		movie.setTitle("My Movie 5");
//		repo.update(movie).ifPresent(System.err::println);
//		repo.removeById(280).ifPresent(System.err::println);
		container.close();
		System.err.println("COMPLETED!");		
	}
}
