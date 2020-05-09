package com.me.myapp.controller;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.me.myapp.model.Cart;
import com.me.myapp.model.Customer;
import com.me.myapp.model.CustomerOrder;
import com.me.myapp.service.CartService;
import com.me.myapp.service.CustomerOrderService;

@Controller
public class OrderController {

	// Autowiring CartService and CustomerOrderService
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CustomerOrderService custOrderService;
	
	@RequestMapping("/order/{cartId}")
	public String createCustomerOrder(@PathVariable("cartId") int cartId) {
		CustomerOrder custOrder = new CustomerOrder();
		Cart myCart = cartService.getCartById(cartId);
		custOrder.setCart(myCart);
		
		Customer cust = myCart.getCustomer();
		custOrder.setCustomer(cust);
		custOrder.setBillingAddress(cust.getBillingAddress());
		custOrder.setShippingAddress(cust.getShippingAddress());
		
		custOrderService.addCustOrder(custOrder);
		// cart Id is required
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("shopeasyapp2@gmail.com", "Shopeasy@12345"));
		email.setSSLOnConnect(true);
		try {
			email.setFrom("shopeasyapp2@gmail.com");
			email.setSubject("Order Placed by customer");
			email.setMsg("Order has been placed by Customer. DSLR Nikon Camera, Quantity 1, Oppo Mobile Phone. Quantity 1. Total Price - $1598 " );
			email.addTo("vidhi.nagda9999@gmail.com");
			email.send();
		} catch (EmailException e) {
			
			e.printStackTrace();
		}
		
		return "redirect:/checkout?cartId="+cartId;
		
	}
}
