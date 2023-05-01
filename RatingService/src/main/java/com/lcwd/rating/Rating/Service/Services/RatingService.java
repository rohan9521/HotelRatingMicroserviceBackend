package com.lcwd.rating.Rating.Service.Services;

import com.lcwd.rating.Rating.Service.Entities.Rating;

import java.util.List;

public interface RatingService{
	Rating create(Rating rating);

	//get all ratings
	List<Rating> getAllRatings();

	//get all by UserId
	List<Rating> getRatingByUserId(String userId);

	//get all by hotel
	List<Rating> getRatingByHotelId(String hotelId);

}