package io.kapur.moviecatalogservice.resources;

import java.util.Collections;
import java.util.List;

import io.kapur.moviecatalogservice.models.CatalogItem;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		return Collections.singletonList(new CatalogItem("Titanic",
				"Romantic Movie", 5));
	}
}
