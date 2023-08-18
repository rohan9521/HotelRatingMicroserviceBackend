package com.user.service.UserService.Controllers;

import com.user.service.UserService.Entities.User;
import com.user.service.UserService.Services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        User retireivedUser = userService.getUser(userId);
        return ResponseEntity.ok(retireivedUser);
    }
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
//        logger.info("Fallback is executed because service is down : ", ex.getMessage());

        System.out.println(ex.getMessage());

        User user = User.builder().email("dummy@gmail.com").name("Dummy").about("This user is created dummy because some service is down").userId("141234").build();
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    @GetMapping("/exists/{email}")
        public ResponseEntity<User> validateUser(@PathVariable String email){
        User userFromDb = userService.findUserByUserName(email);
        System.out.println(email);
        return ResponseEntity.ok(userFromDb);
    }

}