package com.project.RestaurantFrontend.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.RestaurantFrontend.entity.Food_Dish;
import com.project.RestaurantFrontend.entity.User;

@Repository
public class AppDao {
	private static final String URL = "http://localhost:8083/restaurantFrontend/";
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public AppDao() {
		super();
	}

	public User getUser(Integer mobileNumber) {
		if(mobileNumber==null)return null;
		System.out.println(URL+"getUser/"+mobileNumber);
		User user=restTemplate.getForObject(URL+"getUser/"+mobileNumber, User.class);
		return user;
	}
	
	public List<Food_Dish> getAllFood() {
		System.out.println(URL+"getFood/");
		return restTemplate.getForObject(URL+"getFood", List.class);
	}
}
