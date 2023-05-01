package com.lcwd.hotel.HotelService.Services;

import com.lcwd.hotel.HotelService.Entities.Hotel;

import java.util.List;

public interface HotelService{
	Hotel createHotel(Hotel hotel);
	
	List<Hotel> getAllHotels();

	Hotel getHotel(String hotelId);
	
	//TODO
	//userupdate
	//userdelete
}