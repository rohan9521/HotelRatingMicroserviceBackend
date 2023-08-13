package com.hotelraing.JwtAuth.externlservice;


import com.hotelraing.JwtAuth.model.User;
import com.hotelraing.JwtAuth.model.UserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="USER-Service")
public interface UserValidationService  {
    @GetMapping("/users/exists/{email}")
    ResponseEntity<UserRequest> userExists(@PathVariable("email") String email);

    @PostMapping("/users/")
    ResponseEntity<UserRequest> addUser(UserRequest user);
}
