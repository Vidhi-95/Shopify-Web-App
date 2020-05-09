package com.me.myapp.service;

import com.me.myapp.model.Cart;

public interface CartService {

	Cart getCartById(int cartId);
	
	void update(Cart cart);
}
