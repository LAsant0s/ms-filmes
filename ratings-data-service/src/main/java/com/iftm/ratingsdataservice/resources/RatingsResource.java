package com.iftm.ratingsdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.ratingsdataservice.models.Rating;
import com.iftm.ratingsdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

	@RequestMapping("/movies/{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		return new Rating(movieId, 9);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable String userId) {
		UserRating userRating = new UserRating();
		userRating.initData(userId);
		return userRating;
	}
	
}
