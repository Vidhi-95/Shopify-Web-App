package com.me.myapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.myapp.dao.CustomerOrderDao;
import com.me.myapp.model.Cart;
import com.me.myapp.model.CartItem;
import com.me.myapp.model.CustomerOrder;
import com.me.myapp.service.CartService;
import com.me.myapp.service.CustomerOrderService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
	
	@Autowired
	private CustomerOrderDao custOrderDao;
	
	@Autowired
	private CartService cartService;
	
	@Override
	public void addCustOrder(CustomerOrder custOrder) {
		custOrderDao.addCustOrder(custOrder);
		
	}

	@Override
	public double getCustOrderGrandTotal(int cartId) {
		double totalBillingAmount = 0;
		Cart cart = cartService.getCartById(cartId);
		List<CartItem> cartItems = cart.getCartItems();
		
		for(CartItem cItems: cartItems) {
			totalBillingAmount+=cItems.getTotalPrice();
		}
		return totalBillingAmount;
	}

}
