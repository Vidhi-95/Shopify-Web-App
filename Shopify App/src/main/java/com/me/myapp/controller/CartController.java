package com.me.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.me.myapp.model.Customer;
import com.me.myapp.model.CartItem;
import com.me.myapp.model.Product;
import com.me.myapp.service.CustomerService;
import com.me.myapp.dao.CartDao;
import com.me.myapp.dao.ProductDao;

// This controller handles the products added in cart and maintains unique cart Id
// while using rest services do /rest for url mapping
@Controller
@RequestMapping("/customer/cart")
public class CartController {
	
	@Autowired
	private CustomerService CustomerService;
	
	// We are binding the username with customer information
	@RequestMapping
	public String getmyCart(@AuthenticationPrincipal User activeUser) {
		Customer cust = CustomerService.getCustomerByUsername(activeUser.getUsername());
		int cartId = cust.getCart().getCartId();
		
		return "redirect:/customer/cart/"+cartId;
	}
	
	@RequestMapping("/{cartId}")
	public String getCartRedirect(@PathVariable(value="cartId") int cartId, Model mod) {
		mod.addAttribute("cartId",cartId);
		
		return "cart";
	}
}
	

