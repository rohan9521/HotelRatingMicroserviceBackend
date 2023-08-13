package com.hotelraing.JwtAuth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserRequest {
    private String userId;

    private String name;

    private String email;

    private String about;

    private String password;

    private List<Rating> ratings=new ArrayList<>();

    public String toString(){
        return "["+name+" "+email+" "+password+"]";
    }
}
