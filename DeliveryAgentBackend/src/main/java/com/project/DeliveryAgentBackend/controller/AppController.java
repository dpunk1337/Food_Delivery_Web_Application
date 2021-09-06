package com.project.DeliveryAgentBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project.DeliveryAgentBackend.entity.DeliveryAgent;
import com.project.DeliveryAgentBackend.service.AppService;

@RestController
public class AppController {
	@Autowired
	AppService appService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@GetMapping("/deliveryAgentFrontend/getUser/{mobileNumber}")
	public String deliveryAgentGetUser(@PathVariable Integer mobileNumber) {
		DeliveryAgent deliveryAgent=appService.getDeliveryAgent(mobileNumber);
		if(deliveryAgent==null)return null;
		ObjectNode deliveryAgentObjectNode=objectMapper.createObjectNode();
		deliveryAgentObjectNode.put("mobileNumber",deliveryAgent.getMobileNumber());
		deliveryAgentObjectNode.put("password",deliveryAgent.getPassword());
		return deliveryAgentObjectNode.toPrettyString();
	}
}
