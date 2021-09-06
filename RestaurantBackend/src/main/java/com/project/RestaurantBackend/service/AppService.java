package com.project.RestaurantBackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.RestaurantBackend.dao.RestaurantDAO;
import com.project.RestaurantBackend.entity.Restaurant;

@Service
public class AppService {
	@Autowired
	RestaurantDAO restaurantDAO;
	
	public Restaurant getRestaurant(Integer mobileNumber) {
		Optional<Restaurant> opt= restaurantDAO.findById(mobileNumber);
		if(!opt.isPresent())return null;
		return opt.get();
	}

}
