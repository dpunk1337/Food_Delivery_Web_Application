package com.project.DeliveryAgentBackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.DeliveryAgentBackend.dao.DeliveryAgentDAO;
import com.project.DeliveryAgentBackend.entity.DeliveryAgent;

@Service
public class AppService {
	@Autowired
	DeliveryAgentDAO deliveryAgentDAO;
	
	public DeliveryAgent getDeliveryAgent(Integer mobileNumber) {
		Optional<DeliveryAgent> opt= deliveryAgentDAO.findById(mobileNumber);
		if(!opt.isPresent())return null;
		return opt.get();
	}

}
