package com.me.myapp.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.myapp.model.BillingAddress;
import com.me.myapp.model.Customer;
import com.me.myapp.model.ShippingAddress;
import com.me.myapp.service.CustomerService;

@Controller
public class RegisterController {
	// Autowiring customer Service
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/register")
	public String registerCustomer(Model mod) {
		
		// As part of customer registration we will need all the field including Billing address and shipping address.
		// So we will need to create objects for both of them
		Customer cust = new Customer();
		BillingAddress billingAddrs = new BillingAddress();
		ShippingAddress shippingAddrs = new ShippingAddress();
		cust.setBillingAddress(billingAddrs);
		cust.setShippingAddress(shippingAddrs);
		
		mod.addAttribute("customer",cust);
		return "registerCustomer";
	}
	//@Model Attribute - used to bind properties to Customer class
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer cust, BindingResult res, Model mod) {
		
		// if there are matching usernames or email fould in the database it will land on the same page after validating
		if(res.hasErrors()) {
			return "registerCustomer";
		}
		
		List<Customer> custList = customerService.getAllCustomers();
		// Methods to validate duplicate Email IDs and usernames so that unique records exist for each email and username
		for(int i =0; i<custList.size();i++) {
			if(cust.getCustomerEmail().equals(custList.get(i).getCustomerEmail())) {
				mod.addAttribute("emailValidationMsg","An account with this email Already exists");
				return "registerCustomer";
			}
		}
		
		for(int i =0; i<custList.size();i++) {
			if(cust.getUsername().equals(custList.get(i).getUsername())) {
				mod.addAttribute("usernameValidationMsg","An account with this username Already exists");
				return "registerCustomer";
			}
		}
		
		for(int i =0; i<custList.size();i++) {
			if(cust.getCustomerPhone().equals(custList.get(i).getCustomerPhone())) {
				mod.addAttribute("phoneValidationMsg","An account with this Phone number Already exists");
				return "registerCustomer";
			}
		}
		
		cust.setEnabled(true);
		customerService.addCustomer(cust);
		
		return "registerCustomerSuccess";
	}
}
