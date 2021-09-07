package com.project.BuyerBackend.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.BuyerBackend.dao.AppDao;
import com.project.BuyerBackend.dao.BuyerDAO;
import com.project.BuyerBackend.dao.OrdersDAO;
import com.project.BuyerBackend.entity.Buyer;
import com.project.BuyerBackend.entity.Orders;

@Service
public class AppService {
	@Autowired
	OrdersDAO ordersDAO;
	
	@Autowired
	BuyerDAO buyerDAO;
	
	@Autowired
	AppDao appDao;
	
	public Buyer getBuyer(Integer mobileNumber) {
		Optional<Buyer> opt= buyerDAO.findById(mobileNumber);
		if(!opt.isPresent())return null;
		return opt.get();
	}
	
	public String placeOrder(String buyerCity
			,Integer buyerMobileNumber
			,Integer restaurantMobileNumber
			,String items) {
		
		String oid=""+buyerMobileNumber+restaurantMobileNumber+(new Date()).toString();
		Orders order=new Orders(oid,restaurantMobileNumber,buyerMobileNumber,
				appDao.getAvailableDeliveryAgentInCity(buyerCity).getMobileNumber(),
				"with_restaurant",
				items);
		
		ordersDAO.save(order);
		return null;
	}

	public List<Orders> getOrders(Integer mobileNumber) {
		return ordersDAO.buyerGetOrders(mobileNumber);
	}

}
