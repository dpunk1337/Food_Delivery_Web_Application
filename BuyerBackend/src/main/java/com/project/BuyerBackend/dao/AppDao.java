package com.project.BuyerBackend.dao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.project.BuyerBackend.entity.DeliveryAgent;

@Repository
public class AppDao {
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	private static final String URL = "http://localhost:8085/buyerBackend/";
	
	public DeliveryAgent getAvailableDeliveryAgentInCity(String buyerCity) {
//		return restTemplate.getForObject(URL+"getAvailableDeliveryAgent/"+buyerCity, DeliveryAgent.class);
		return new DeliveryAgent("Johnny Walker",123);
	}

	public String buyerGetDishes(Integer mobileNumber) {
//		return restTemplate.getForObject(URL+"getDishes/"+mobileNumber, String.class);
		return "[ { \"dishId\": \"1\", \"name\": \"Tandoori Chicken\", \"price\": 400 }, { \"dishId\": \"2\", \"name\": \"Shahi Paneer\", \"price\": 300 }, { \"dishId\": \"3\", \"name\": \"Briyani\", \"price\": 200 }, { \"dishId\": \"4\", \"name\": \"Pizza\", \"price\": 100 }, { \"dishId\": \"5\", \"name\": \"Coffee\", \"price\": 50 } ]";
	}

	public String buyerGetRestaurantsInCity(String city) {
//		return restTemplate.getForObject(URL+"getRestaurantsInCity/"+city,String.class);
		return "[ { \"mobileNumber\": 1, \"name\": \"KFC\" }, { \"mobileNumber\": 2, \"name\": \"Dominos\" }, { \"mobileNumber\": 3, \"name\": \"Mc Donalds\" }, { \"mobileNumber\": 4, \"name\": \"Burger King\" }, { \"mobileNumber\": 5, \"name\": \"Subway\" }, { \"mobileNumber\": 6, \"name\": \"Los Pollos Hermanos\" } ]";
	}

	public void markDeliveryAgentAsAvailable(Integer deliveryAgentMobileNumber) {
		restTemplate.postForObject(URL+"markDeliveryAgentAsAvailable/"+deliveryAgentMobileNumber, deliveryAgentMobileNumber, String.class);
	}
}
