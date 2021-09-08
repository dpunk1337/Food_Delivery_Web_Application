package com.project.RestaurantFrontend.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.RestaurantFrontend.dao.AppDao;
import com.project.RestaurantFrontend.entity.Food_Dish;
import com.project.RestaurantFrontend.entity.Orders;
import com.project.RestaurantFrontend.entity.User;
import com.project.RestaurantFrontend.prevalent.CurrentUser;

@Controller
public class AppController {
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
	
	@RequestMapping("/addmenu")
	public String menu() {
		if(notLoggedIn())return "login";
		return "addMenu";
	}
	
	@RequestMapping("/add")
	public String Menuadd(@ModelAttribute Food_Dish foodDish){
		if(notLoggedIn())return "login";
		Integer mobile_number=CurrentUser.MOBILE_NUMBER;
		foodDish.setMobile_number(mobile_number);
		foodDish.setId(mobile_number+(new Date()).toString());
		appDao.addFood(foodDish);
		return "redirect:/food";
	}
	
	@RequestMapping("/deletefood/{id}")
	public String Menudelete(@PathVariable String id){
		if(notLoggedIn())return "login";
		appDao.deleteFood(id);
		return "redirect:/food";
	}
	
	@RequestMapping("/food")
	public String food(Model m){
		if(notLoggedIn())return "login";
		Integer mobile_number=CurrentUser.MOBILE_NUMBER;
		List<Food_Dish> list=appDao.getAllFoodOfRestaurant(mobile_number);  
        m.addAttribute("list",list);
		return "menu";
	}
	public boolean notLoggedIn() {
		return CurrentUser.MOBILE_NUMBER==null;
	}

	@RequestMapping(value ="/seeOrders")
	public String seeOrders(Model model) {
		if(notLoggedIn())return "login";
		List<Orders> orders=appDao.getOrders();
		model.addAttribute("orders",orders);
		return "seeOrders";
	}
	
	@RequestMapping("/markAsPickedUp/{orderId}")
	public String markOrderAsPickedUp(@PathVariable String orderId) {
		if(notLoggedIn())return "login";
		appDao.markOrderAsPickedUp(orderId);
		return "redirect:/seeOrders";
	}
}