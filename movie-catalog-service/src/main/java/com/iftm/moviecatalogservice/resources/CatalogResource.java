package com.iftm.moviecatalogservice.resources;

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
import com.iftm.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{userID}")
	public List<CatalogItem> getCatalog(@PathVariable String userID) {
		
		UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userID, UserRating.class);
		
		return userRating.getRatings().stream()
				.map(rating -> {
					Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
					return new CatalogItem(movie.getName(), "FILMAÇO", rating.getRating());
				})
				.collect(Collectors.toList());
	}
	
	
}
