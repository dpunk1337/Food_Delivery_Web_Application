package com.project.RestaurantBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project.RestaurantBackend.entity.Food_Dish;
import com.project.RestaurantBackend.entity.Restaurant;
import com.project.RestaurantBackend.service.AppService;

@RestController
public class AppController {
	@Autowired
	AppService appService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@GetMapping("/restaurantFrontend/getUser/{mobileNumber}")
	public String restaurantGetUser(@PathVariable Integer mobileNumber) {
		Restaurant restaurant=appService.getRestaurant(mobileNumber);
		if(restaurant==null)return null;
		ObjectNode restaurantObjectNode=objectMapper.createObjectNode();
		restaurantObjectNode.put("mobileNumber",restaurant.getMobileNumber());
		restaurantObjectNode.put("password",restaurant.getPassword());
		return restaurantObjectNode.toPrettyString();
	}
	
	@GetMapping("/restaurantFrontend/getFood")
	public List<Food_Dish> foodGet() {
		return appService.getFoodDish();
	}
	
	@PostMapping("/restaurantFrontend/addFood")
	public String addfood(@RequestBody Food_Dish foodDish){
		return appService.addFoodDish(foodDish);
	}
	
	@DeleteMapping("/restaurantFrontend/deleteFood/{id}")
	public String deletefood(@PathVariable String id) {
		return appService.deleteFoodDish(id);
	}
	
	@PutMapping("/restaurantFrontend/updateFood")
	public String updatefood(@RequestBody Food_Dish foodDish) {
		return appService.updateFoodDish(foodDish);
	}
}
