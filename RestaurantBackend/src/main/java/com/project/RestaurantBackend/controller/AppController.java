package com.project.RestaurantBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
}
