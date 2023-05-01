package com.lcwd.hotel.HotelService.Controllers;

import com.lcwd.hotel.HotelService.Entities.Hotel;
import com.lcwd.hotel.HotelService.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController{
	@Autowired
	private HotelService hotelService;
	//create
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel hotelNew = hotelService.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelNew);
	}	
 
	//get single Hotel
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId){
		Hotel hotel = hotelService.getHotel(hotelId);
		return ResponseEntity.ok(hotel);
	}
	
	//get single Hotel
	@GetMapping
	public ResponseEntity<List<Hotel>> getSingleHotel(){
		List<Hotel> allHotel = hotelService.getAllHotels();
		return ResponseEntity.ok(allHotel);
	}
}