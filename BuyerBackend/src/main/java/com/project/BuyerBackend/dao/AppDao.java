package com.project.BuyerBackend.dao;

import org.springframework.stereotype.Repository;

import com.project.BuyerBackend.entity.DeliveryAgent;

@Repository
public class AppDao {
	private static final String URL = "http://localhost:8085/buyerBackend/";
	
	public DeliveryAgent getAvailableDeliveryAgentInCity(String buyerCity) {
		return new DeliveryAgent("Johnny Walker",123);
	}
}
