package com.userservice.service.implement;

import com.netflix.discovery.converters.Auto;
import com.userservice.entities.Hotel;
import com.userservice.entities.Rating;
import com.userservice.entities.User;
import com.userservice.exception.ResourceNotFoundException;
import com.userservice.external.service.HotelService;
import com.userservice.external.service.RatingService;
import com.userservice.repository.UserRepository;
import com.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User save(User user) {
        user.setId(UUID.randomUUID().toString());
        return   userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(String id) {
        User user = userRepo.findById(id).orElseThrow( ()-> new ResourceNotFoundException("User not found whose id is : "+id));
                //fetch rating of above user
//        http://localhost:8086/rating/users/6b0332a2-91ec-4ba0-a93c-9e2e40e3e23f
        List<Rating> ratings = List.of(restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+id , Rating[].class));
        List<Rating> ratingList = (List<Rating>) ratingService.getRatingById(id);
        //get all hotels according to rating
        for(Rating rating :ratings){
            System.out.println(rating);
//            Hotel hotel1 = restTemplate.getForObject("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
            Hotel hotel1 = hotelService.getHotelById(rating.getHotelId());
            rating.setHotel(hotel1);
            logger.info("Hotel set for rating with hotelId: {}", rating.getHotelId());
        }
        user.setRatings(ratings);
        return user;
    }

    @Override
    public User deleteUserById(String id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userRepo.deleteById(id);
        return user;
    }

    @Override
    public User updateUser(User user) {
        User existUser = userRepo.findById(user.getId()).orElseThrow(()-> new ResourceNotFoundException("User not found whose id is : "+user.getId()));
        existUser.setEmail(user.getEmail());
        existUser.setAbout(user.getAbout());
        existUser.setName(user.getName());
        return userRepo.save(existUser);
    }
}
