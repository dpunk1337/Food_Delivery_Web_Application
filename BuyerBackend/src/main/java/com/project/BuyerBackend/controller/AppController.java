package com.project.BuyerBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project.BuyerBackend.entity.Buyer;
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
}
