package io.kapur.movieinfoservice.resources;

import io.kapur.movieinfoservice.models.Movie;

import java.util.Collections;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		return new Movie(movieId, "Titanic", "Romantic Movie");
	}

}
