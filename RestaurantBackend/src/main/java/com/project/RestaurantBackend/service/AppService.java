package com.project.RestaurantBackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.RestaurantBackend.dao.FoodDAO;
import com.project.RestaurantBackend.dao.RestaurantDAO;
import com.project.RestaurantBackend.entity.Food_Dish;
import com.project.RestaurantBackend.entity.Restaurant;

@Service
public class AppService {
	@Autowired
	RestaurantDAO restaurantDAO;
	
	@Autowired
	FoodDAO foodDAO;
	
	public Restaurant getRestaurant(Integer mobileNumber) {
		Optional<Restaurant> opt= restaurantDAO.findById(mobileNumber);
		if(!opt.isPresent())return null;
		return opt.get();
	}
	
	public List<Food_Dish> getFoodDish() {
		return foodDAO.findAll();
	}
	
	public String addFoodDish(Food_Dish foodDish) {
		foodDAO.save(foodDish);
		return "New FoodDish has been added to Database, whose name is :"+foodDish.getName();
	}
	
	public String deleteFoodDish(String id) {
		Food_Dish foodDish=foodDAO.findById(id).get();
		foodDAO.delete(foodDish);
		return "FoodDish is deleted with Food id  :"+foodDish.getId();
	}
	
	public String updateFoodDish(Food_Dish foodDish) {
		foodDAO.save(foodDish);
		return "FoodDish is update id : "+foodDish.getId();
	}
}
