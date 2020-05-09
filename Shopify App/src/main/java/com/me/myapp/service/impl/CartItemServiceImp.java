package com.me.myapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.myapp.dao.CartItemDao;
import com.me.myapp.model.Cart;
import com.me.myapp.model.CartItem;
import com.me.myapp.service.CartItemService;

@Service
public class CartItemServiceImp implements CartItemService {
	
	@Autowired
	private CartItemDao cartItemDao;
	
	@Override
	public void addItemToCart(CartItem cartItem) {
		cartItemDao.addItemToCart(cartItem);
		
	}

	@Override
	public void removeItemFromCart(CartItem cartItem) {
		cartItemDao.removeItemFromCart(cartItem);
		
	}

	@Override
	public void removeAllItems(Cart cart) {
		cartItemDao.removeAllItems(cart);
		
	}

	@Override
	public CartItem getCartItemByProductId(int productId) {
		return cartItemDao.getCartItemByProductId(productId);
	}

}
