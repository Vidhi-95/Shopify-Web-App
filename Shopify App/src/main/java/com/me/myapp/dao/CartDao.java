package com.me.myapp.dao;

import java.io.IOException;

import com.me.myapp.model.Cart;

public interface CartDao {
	
	Cart getCartById(int cartId);
	
	void update(Cart cart);
	
	Cart validate(int CartId) throws IOException;
}
