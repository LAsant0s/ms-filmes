package com.iftm.ratingsdataservice.models;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRating {
	
	private String userId;
	private List<Rating> ratings;
	
	public void initData(String userId) {
		this.setUserId(userId);
		this.setRatings(Arrays.asList(
				new Rating("550", 9),
				new Rating("268", 8),
				new Rating("78", 10)
		));
	}
	
}
