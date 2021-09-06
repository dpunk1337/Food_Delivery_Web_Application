package com.project.RestaurantFrontend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.RestaurantFrontend.dao.AppDao;
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
	
	public boolean notLoggedIn() {
		return CurrentUser.MOBILE_NUMBER==null;
	}

}