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

	public String buyerGetDishes(Integer mobileNumber) {		
		return appDao.buyerGetDishes(mobileNumber);
	}

	public String buyerGetRestaurantsInCity(String city) {
		return appDao.buyerGetRestaurantsInCity(city);
	}

	public void updateBuyer(Integer buyerMobileNumber, Buyer buyer) {
		buyerDAO.deleteById(buyerMobileNumber);
		buyerDAO.save(buyer);
	}

	public void updateOrderStatus(String orderId, String status) {
		Optional<Orders> orderOpt=ordersDAO.findById(orderId);
		if(!orderOpt.isPresent())return;
		Orders order=orderOpt.get();
		ordersDAO.delete(order);
		order.setStatus(status);
		ordersDAO.save(order);
	}

	public void markDeliveryAgentAsAvailable(String orderId) {
		Optional<Orders> orderOpt=ordersDAO.findById(orderId);
		if(!orderOpt.isPresent())return;
		Orders order=orderOpt.get();
		appDao.markDeliveryAgentAsAvailable(order.getDeliveryAgentMobileNumber());
		
	}

	public void saveBuyer(Buyer buyer) {
		buyerDAO.save(buyer);	
	}

	public List<Orders> getOrdersForRestaurant(Integer mobileNumber) {
		return ordersDAO.restaurantGetOrders(mobileNumber);
	}

}
