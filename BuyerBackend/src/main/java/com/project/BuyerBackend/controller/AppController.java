package com.project.BuyerBackend.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project.BuyerBackend.entity.Buyer;
import com.project.BuyerBackend.entity.Orders;
import com.project.BuyerBackend.service.AppService;

@RestController
public class AppController {
	@Autowired
	AppService appService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@GetMapping("/buyerFrontend/getUser/{mobileNumber}")
	public String buyerGetUser(@PathVariable Integer mobileNumber) {
		Buyer buyer=appService.getBuyer(mobileNumber);
		if(buyer==null)return null;
		ObjectNode buyerObjectNode=objectMapper.createObjectNode();
		buyerObjectNode.put("mobileNumber",buyer.getMobileNumber());
		buyerObjectNode.put("password",buyer.getPassword());
		return buyerObjectNode.toPrettyString();
	}
	
	@PostMapping("/buyerFrontend/placeOrder")
	public String placeOrder(@RequestParam("mobileNumber") Integer buyerMobileNumber,
			@RequestParam("city") String buyerCity,
			@RequestParam("restaurantMobileNumber") Integer restaurantMobileNumber,
			@RequestBody String orderItems) {
		appService.placeOrder(buyerCity, buyerMobileNumber, restaurantMobileNumber, orderItems);
		return null;
	}
	
	@GetMapping("/buyerFrontend/getOrders/{mobileNumber}")
	public String buyerGetOrders(@PathVariable Integer mobileNumber) {
		List<Orders> orders= appService.getOrders(mobileNumber);		
		ArrayNode ordersObjectNode=objectMapper.createArrayNode();
		for(Orders order: orders) {
			ObjectNode childNode=objectMapper.createObjectNode();
			childNode.put("orderId",order.getOrderId());
			childNode.put("items",order.getItems());
			childNode.put("status",order.getStatus());
			ordersObjectNode.add(childNode);
		}
		return ordersObjectNode.toPrettyString();
	}
	
	@GetMapping("/buyerFrontend/getDishes/{mobileNumber}")
	public String buyerGetDishes(@PathVariable Integer mobileNumber) {
//		List<Orders> orders= appService.getOrders(mobileNumber);	
//		List<>
//		ArrayNode ordersObjectNode=objectMapper.createArrayNode();
//		for(Orders order: orders) {
//			ObjectNode childNode=objectMapper.createObjectNode();
//			childNode.put("orderId",order.getOrderId());
//			childNode.put("items",order.getItems());
//			childNode.put("status",order.getStatus());
//			ordersObjectNode.add(childNode);
//		}
//		return ordersObjectNode.toPrettyString();
		return " ";
	}
//	return new ArrayList<>(Arrays.asList(
//			new Dish("1","Tandoori Chicken",400),
//			new Dish("2","Shahi Paneer",300),
//			new Dish("3","Korma",200)
//			));

}
