package com.lcwd.rating.Rating.Service.Controllers;

import com.lcwd.rating.Rating.Service.Entities.Rating;
import com.lcwd.rating.Rating.Service.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController{
	@Autowired
	private RatingService ratingService;
	//create
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating ratingNew = ratingService.create(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingNew);
	}	

 	@GetMapping
	public ResponseEntity<List<Rating>> getRatings(){
		List<Rating> ratingList = ratingService.getAllRatings();
		return ResponseEntity.ok(ratingList);
	}

	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		List<Rating> ratingsByHotel = ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(ratingsByHotel);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		List<Rating> ratingByUserList = ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(ratingByUserList);
	}

//
}