package com.lcwd.rating.Rating.Service.Services.RatingServiceImpl;

import com.lcwd.rating.Rating.Service.Entities.Rating;
import com.lcwd.rating.Rating.Service.Exceptions.ResourceNotFoundException;
import com.lcwd.rating.Rating.Service.Repository.RatingRepository;
import com.lcwd.rating.Rating.Service.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository repository;

	@Override
	public Rating create(Rating rating){
		String randomHotelId = UUID.randomUUID().toString();
		rating.setRatingId(randomHotelId);
		return repository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings(){
		return repository.findAll();
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId){
		return repository.findByHotelId(hotelId);
	}

	@Override
	public List<Rating> getRatingByUserId(String userId){
		return repository.findByUserId(userId);
	}
}