package com.lcwd.hotel.HotelService.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/staff")
public class HotelStaffController {

    @GetMapping("/")
    public ArrayList<String> getStaff(){
        ArrayList<String> res = new ArrayList<String>();
        res.add ("Ram");
        res.add("Arnold");
        return res;

    }
}
