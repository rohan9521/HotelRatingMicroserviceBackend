package com.lcwd.hotel.HotelService.Repository;

import com.lcwd.hotel.HotelService.Entities.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface HotelRepository extends MongoRepository<Hotel,String>{
	
}