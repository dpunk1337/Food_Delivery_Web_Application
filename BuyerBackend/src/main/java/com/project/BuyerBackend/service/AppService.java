package com.project.BuyerBackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.BuyerBackend.dao.BuyerDAO;
import com.project.BuyerBackend.entity.Buyer;

@Service
public class AppService {
	@Autowired
	BuyerDAO buyerDAO;
	
	public Buyer getBuyer(Integer mobileNumber) {
		Optional<Buyer> opt= buyerDAO.findById(mobileNumber);
		if(!opt.isPresent())return null;
		return opt.get();
	}

}
