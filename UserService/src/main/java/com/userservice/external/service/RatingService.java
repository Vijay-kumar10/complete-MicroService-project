package com.userservice.external.service;

import com.userservice.entities.Hotel;
import com.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("ratings/users/{userId}")
    List<Rating> getRatingById(@PathVariable String userId);
}
