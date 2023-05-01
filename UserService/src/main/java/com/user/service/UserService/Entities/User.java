package com.user.service.UserService.Entities;

import lombok.*;


import java.util.ArrayList;
import java.util.List;

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
@Document("micro_user")
public class User {

    @Id

    private String userId;

    private String name;

    private String email;

    private String about;
    //other user properties that you want

    private List<Rating> ratings=new ArrayList<>();


}