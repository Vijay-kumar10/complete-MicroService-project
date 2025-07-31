package com.ratingservice.service;

import com.ratingservice.entities.Rating;

import java.util.List;

public interface RatingService {

    //CREATE RATING
    Rating createRating(Rating rating);

    //GET ALL RATINGS
    List<Rating> getRatings();

    //GET RATING BY HOTEL_ID
    List<Rating> getRatingByHotelId(String hotelId);

    //GET RATING BY USER_ID
    List<Rating> getRatingByUserId(String hotelId);


}
