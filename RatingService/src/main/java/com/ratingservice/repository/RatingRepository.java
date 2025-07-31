package com.ratingservice.repository;

import com.ratingservice.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {

    //we define custom finder method
    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);
}
