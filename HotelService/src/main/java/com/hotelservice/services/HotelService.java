package com.hotelservice.services;

import com.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create hotel
    Hotel createHotel(Hotel hotel);

    //get all hotels
    List<Hotel> getAllHotels();

    //get single hotel
    Hotel getHotelById(String id);

}
