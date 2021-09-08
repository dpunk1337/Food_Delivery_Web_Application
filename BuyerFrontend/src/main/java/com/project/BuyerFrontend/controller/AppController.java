package com.project.BuyerFrontend.controller;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project.BuyerFrontend.dao.AppDao;
import com.project.BuyerFrontend.entity.Dish;
import com.project.BuyerFrontend.entity.OrderItem;
import com.project.BuyerFrontend.entity.OrderItems;
import com.project.BuyerFrontend.entity.Orders;
import com.project.BuyerFrontend.entity.Restaurant;
import com.project.BuyerFrontend.entity.User;
import com.project.BuyerFrontend.prevalent.CurrentUser;

@Controller
public class AppController {
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	AppDao appDao;
	
	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		if(notLoggedIn())return "login";
		return "home";
	}
	
	@RequestMapping("/checkCredentials")
	public String checkCredentials(@RequestParam("mobile_number")Integer mobileNumber, @RequestParam("password")String password) {
		if(mobileNumber==null || password==null)return "redirect:/logInFailure";
		User user=appDao.getUser(mobileNumber);
		if(user==null)return "redirect:/logInFailure";
		if(!user.getPassword().equals(password))return "redirect:/logInFailure";
		CurrentUser.MOBILE_NUMBER=user.getMobileNumber();
		CurrentUser.PASSWORD=user.getPassword();
		CurrentUser.currentUser=user;
		return "redirect:/";
	}
	
	@RequestMapping("/logInFailure")
	public String loginFailure() {		
		return "logInFailure";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		CurrentUser.MOBILE_NUMBER=null;
		CurrentUser.PASSWORD=null;
		CurrentUser.currentUser=null;
		return "redirect:/";
	}
	
	public boolean notLoggedIn() {
		return CurrentUser.MOBILE_NUMBER==null;
	}
	
	@RequestMapping("/signUp")
	public String signUp(){
		return "signUp";
	}
	
	@RequestMapping(value = "/signUpSubmit", method = RequestMethod.POST )
	public String signUpSubmit(@ModelAttribute User user) {
		appDao.addUser(user);
		return "signUpSuccessful";
	}
	
	@RequestMapping("/seeRestaurants")
	public String seeRestaurants(Model model) {
		if(notLoggedIn())return "login";
		List<Restaurant>restaurants=appDao.getRestaurantsInCity();
		model.addAttribute("restaurants", restaurants);
		return "seeRestaurants";
	}
	
	@RequestMapping("/seeRestaurant")
	public String seeRestaurant(@RequestParam("mobileNumber")Integer mobileNumber,Model model) {
		if(notLoggedIn())return "login";
		List<Dish> dishes=appDao.getDishesInRestaurant(mobileNumber);
		OrderItems orderItems=new OrderItems(dishes,true);
		model.addAttribute("mobileNumber", mobileNumber);
		model.addAttribute("orderItems",orderItems);
		return "seeRestaurant";		
	}
	
	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST )
	public String placeOrder(@RequestParam("mobileNumber") Integer mobileNumber,@ModelAttribute("orderItems") OrderItems orderItems) {
		if(notLoggedIn())return "login";
		List<OrderItem> orderItemsList=orderItems.getOrderItemsList();
		List<OrderItem> validOrders=new ArrayList<OrderItem>();
		for(OrderItem item:orderItemsList) {
			if(item.getQuantity()<=0)continue;
			validOrders.add(item);
		}
		if(validOrders.size()==0)return "orderUnsuccessful";
		String validOrderItems=new String();
		try {validOrderItems = objectMapper.writeValueAsString(validOrders);
		} catch (JsonProcessingException e) {}
		appDao.placeOrder(validOrderItems,mobileNumber);
		return "orderSuccessful";
	}
	
	@RequestMapping(value ="/seeOrders")
	public String seeOrders(Model model) {
		if(notLoggedIn())return "login";
		List<Orders> orders=appDao.getOrders();
		model.addAttribute("orders",orders);
		return "seeOrders";
	}
	
	@RequestMapping(value ="/editProfile")
	public String seeEditProfilePage(Model model) {
		if(notLoggedIn())return "login";
		model.addAttribute("command",CurrentUser.currentUser);
		return "editProfile";
	}
	
	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST )
	public String updateProfile(@ModelAttribute("command") User user) {
		if(notLoggedIn())return "login";
		CurrentUser.currentUser=user;
		appDao.updateUser(user);
		return "redirect:/";
	}
	
	@RequestMapping("/markAsReceived/{orderId}")
	public String markOrderAsReceived(@PathVariable String orderId) {
		if(notLoggedIn())return "login";
		appDao.markOrderAsReceived(orderId);
		return "redirect:/seeOrders";
	}
	
	

}