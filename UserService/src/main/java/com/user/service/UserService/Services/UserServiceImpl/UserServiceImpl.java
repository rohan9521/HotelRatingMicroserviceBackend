package com.user.service.UserService.Services.UserServiceImpl;

import com.user.service.UserService.Entities.Hotel;
import com.user.service.UserService.Entities.Rating;
import com.user.service.UserService.Entities.User;
import com.user.service.UserService.Exceptions.ResourceNotFoundException;
import com.user.service.UserService.External.Services.HotelService;
import com.user.service.UserService.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.user.service.UserService.Repository.UserRepository;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserRepository repository;

	@Autowired
	private HotelService hotelService;

	@Override
	public User saveUser(User user){
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return repository.save(user);
	}

	@Override
	public List<User> getAllUser(){
		return repository.findAll();
	}

	@Override
	public User getUser(String userId){
		User user = repository.findById(userId).orElseThrow();
		//ArrayList<Ratings> ratings = restTemplate.getForObject("https://localhost:8081/users/"+user.getUserId(),ArrayList.class);
		//But this has some problem .. it converts to arraylist of linkedhashmap and not arrayList of ratings so
		//below implementation is correct.
		Rating[] ratings = restTemplate.getForObject("https://RATING-Service/users/"+user.getUserId(),Rating[].class);

		List<Rating> ratingList  = Arrays.stream(ratings).toList();

		List<Rating> ratingListWithHotel = ratingList.stream().map(rating->{
				//		Hotel hotel = restTemplate.getForObject("https://HOTEL_SERVICE/users/"+rating.getHotelId(),Hotel.class);
				Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratingListWithHotel);
		return user;
	}
}