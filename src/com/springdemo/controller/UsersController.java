package com.springdemo.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.entity.Customer;
import com.springdemo.entity.Users;
import com.springdemo.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	private static final Logger logger = Logger.getLogger(CustomerController.class);
	
	
	@RequestMapping("/login")
	public String login(Model theModel)
	{
		Users theUsers=new Users();
		//add to sprng mvc model
	    theModel.addAttribute("users", theUsers);
				
		return "user-loginForm";
	}
	
	
	@RequestMapping("/signup")
	public String signupForm(Model theModel) 
	{
		//new model attribute to bind data
		
		Users theUsers=new Users();
		theModel.addAttribute("users", theUsers);
		logger.debug(" ***redirectng to Signup form ***");
		return "user-signupForm";
	}
	
	
	//register
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("users") Users theUsers)
	{
		
		boolean result= usersService.saveUser(theUsers);
		
		if(result) {
		logger.debug(" ***redirectng to login form ***");
		return "redirect:/users/login";
		}
		else {
			logger.debug(" ***redirectng to signup form ***");
			return "user-signupForm";
		}
	}
	
	
	// Checks if the user credentials are valid or not.
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validateUsr
	(@RequestParam("email")String email, @RequestParam("password")String password,
			Model theModel ,HttpSession session) {
		boolean isValid = usersService.validateUser(email, password);     
		logger.info("Is user valid?= " + isValid);
             
		if(isValid) {
			     
			     addSession(email,session);
			     return "home-page";
	         }
		else {
		//	Users theUsers=new Users();
		//	theModel.addAttribute("users", theUsers);
			logger.info("****in else block****");
			     return "user-loginForm";
	        }
	    }
	
	
	private void addSession(String email, HttpSession session) {
	
		session.setAttribute("semail", email);
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
	    session.invalidate();			
		return "redirect:/users/login?act=lo";
	}
	
	}

	
	
