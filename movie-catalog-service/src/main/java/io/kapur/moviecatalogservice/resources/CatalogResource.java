package io.kapur.moviecatalogservice.resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import io.kapur.moviecatalogservice.models.CatalogItem;
import io.kapur.moviecatalogservice.models.Movie;
import io.kapur.moviecatalogservice.models.Rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {


		List<Rating> ratingList = new ArrayList<Rating>();
		ratingList.add(new Rating("1234", 3));
		ratingList.add(new Rating("5678", 4));

		return ratingList
				.stream()
				.map(rating -> {
					Movie movie = restTemplate.getForObject(
							"http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
					return new CatalogItem(movie.getName(), movie
							.getDescription(), rating.getRating());
				}).collect(Collectors.toList());

		/*
		 * Alternative way, valid for jdk 1.7 
		 * List<CatalogItem> catelogItem =new ArrayList<CatalogItem>();
		 * Movie movie; 
		 * for(Rating rate: ratingList){
		 * 	movie=restTemplate.getForObject("https://localhost:8081/movies/", Movie.class);
		 * catelogItem.add(movie.getName(), movie.getDescription(), rate.getRating()); } 
		 * return catelogItem;
		 */

	}
}
