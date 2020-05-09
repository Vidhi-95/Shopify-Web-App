package com.me.myapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.myapp.dao.CartDao;
import com.me.myapp.model.Cart;
import com.me.myapp.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	
	
	@Override
	public Cart getCartById(int cartId) {
		return cartDao.getCartById(cartId);
	}

	@Override
	public void update(Cart cart) {
		cartDao.update(cart);
		
	}

}
