package com.iftm.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.iftm.moviecatalogservice.models.CatalogItem;
import com.iftm.moviecatalogservice.models.Movie;
import com.iftm.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{userID}")
	public List<CatalogItem> getCatalog(@PathVariable String userID) {
		
		List<Rating> ratings = Arrays.asList(
			new Rating("12", 15),
			new Rating("15", 20)
		);

		return ratings.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), "FILMAO", rating.getRating());
		}).collect(Collectors.toList());
	}
	
	
}
