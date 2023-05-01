package com.lcwd.hotel.HotelService.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("micro_hotel")
public class Hotel{
    @Id
    private String id;
    private String name;
    private String location;
    private String about;
    private Rating rating;
}