package com.lcwd.hotel.HotelService.Services.UserServiceImpl;

import com.lcwd.hotel.HotelService.Entities.Hotel;
import com.lcwd.hotel.HotelService.Exceptions.ResourceNotFoundException;
import com.lcwd.hotel.HotelService.Repository.HotelRepository;
import com.lcwd.hotel.HotelService.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository repository;

	@Override
	public Hotel createHotel(Hotel hotel){
		String randomHotelId = UUID.randomUUID().toString();
		hotel.setId(randomHotelId);
		return repository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels(){
		return repository.findAll();
	}

	@Override
	public Hotel getHotel(String hotelId){
		return repository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel Not Found with"+hotelId));
	}
}