package com.user.service.UserService.External.Services;

import com.user.service.UserService.Entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-Service")
public interface HotelService{
    @GetMapping("hotels/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);
    //@PathVariable("hotelId") is because if hotelId name from getmapping 
    //doesnt match with variable name then else no need to right;
}