package com.userservice.controller;

import com.userservice.entities.User;
import com.userservice.service.UserService;
import feign.Response;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class  UserController {

    @Autowired
    private UserService userService;
    //createUser
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        System.out.println(user);
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


    int retryCount = 1;
    //get single user
    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "hotelRatingBreaker",fallbackMethod = "ratingHotelFallBack")
//    @Retry(name = "hotelRatingRetryBreaker",fallbackMethod = "ratingHotelFallBack")
    @RateLimiter(name = "hotelRatingRateLimiter",fallbackMethod = "ratingHotelFallBack")

    public ResponseEntity<User> getUser(@PathVariable String userId ){
        System.out.println("Retry count : " + retryCount++);
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }
    //jab bhi hum kisi function ka fallback function banate hai tab un dono ka input variable and return types same hona chiaye nahi to exception aa jati hai
    public ResponseEntity<User> ratingHotelFallBack(String userId,Exception e) {
        System.out.println("Fallback funciton is executed because some service are down : "+e.getMessage());
        User dummyUser = User.builder().id("12345")
                .email("dummy@email.com")
                .name("dummy user")
                .about("This is a dummy user.")
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dummyUser);
    }



    //get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    //delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable String userId){
        return ResponseEntity.ok(userService.deleteUserById(userId));
    }

    //update user
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(user));
    }

}
