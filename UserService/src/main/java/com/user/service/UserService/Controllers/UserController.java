package com.user.service.UserService.Controllers;

import com.user.service.UserService.Entities.User;
import com.user.service.UserService.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User userNew = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userNew);
    }

    //get single user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        User retireivedUser = userService.getUser(userId);
        return ResponseEntity.ok(retireivedUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(@PathVariable String Userid) {
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}