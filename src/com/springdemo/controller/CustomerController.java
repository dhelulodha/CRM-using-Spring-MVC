package com.springdemo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private static final Logger logger = Logger.getLogger(CustomerController.class);
	
	
	//inject the service in this controller
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel,HttpSession session) {
		
		//get the customers from dao 
		if(session.getAttribute("semail")!=null) {
			
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add to sprng mvc model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
		else {
			return "redirect:/users/logout";
		}
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel,HttpSession session) 
	{
		//new model attribute to bind data
	   if(session.getAttribute("semail")!=null) {
		Customer theCustomer=new Customer();
		theModel.addAttribute("customer", theCustomer);
		logger.debug(" ***redirectng to Add form ***");
		return "customer-form";
	}
	else {
		return "redirect:/users/logout";
	}
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
	{   
	  //save the customer using service
		
		customerService.saveCustomer(theCustomer);
		logger.debug(" *** Customer has been sucessfully saved. ***");
	  return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
    		Model theModel,HttpSession session)
    {
		if(session.getAttribute("semail")!=null) {
		//get customer from service
	     Customer theCustomer=customerService.getCustomer(theId);	
		
	     //set attribute 
		theModel.addAttribute("customer",theCustomer);
	     
		logger.debug(" ***redirectng to Update form ***");
		//send to form
		return "customer-form";
    }
		else {
			return "redirect:/users/logout";
		}
    }
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		//delete the customer
		
		customerService.deleteCustomer(theId);
		
		
		logger.debug(" *** Customer is sucessfully deleted***");
		return "redirect:/customer/list";
	}
	
}
