package com.iftm.ratingsdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.ratingsdataservice.models.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsService {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		return new Rating(movieId, 4);
	}
	
}
