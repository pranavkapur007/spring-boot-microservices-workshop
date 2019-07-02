package io.kapur.moviecatalogservice.resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import io.kapur.moviecatalogservice.models.CatalogItem;
import io.kapur.moviecatalogservice.models.Rating;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		List<Rating> ratingList = new ArrayList<Rating>();
		ratingList.add(new Rating("1234", 3));
		ratingList.add(new Rating("5678", 4));

		return ratingList
				.stream()
				.map(rating -> new CatalogItem("Name", "Desc", rating
						.getRating())).collect(Collectors.toList());
	}
}
