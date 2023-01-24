package com.project.RestaurantBackend.dao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class AppDao {
	@Lazy
	@Autowired
	RestTemplate restTemplate;
	
	private static final String BUYER_URL = "http://BUYER-BACKEND/restaurantBackend/";
	
	private static final String DELIVERY_AGENT_URL = "http://DELIVERY-AGENT-BACKEND/restaurantBackend/";
	
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public String getOrders(Integer mobileNumber) {
		return restTemplate.getForObject(BUYER_URL+"getOrders/"+mobileNumber, String.class); 
	}

	public void restaurantMarkAsPickedUp(String orderId) {
		restTemplate.postForObject(BUYER_URL+"markOrderAsPickedUp/"+orderId, orderId, String.class);
	}
	
}
