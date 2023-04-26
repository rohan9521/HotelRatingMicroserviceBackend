package com.user.service.UserService.External.Services;

import com.user.service.UserService.Entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="RATING-Service")
public interface RatingService{
    @GetMapping("ratings/{ratingId}")
    Rating getRating(@PathVariable("ratingId") String ratingId);
    //@PathVariable("hotelId") is because if hotelId name from getmapping 
    //doesnt match with variable name then else no need to right;

    @PostMapping("/ratings")
    public Rating createRating(Rating value);

    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable String ratingId, Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> deleteUser(@PathVariable String ratingId,Rating rating);


}