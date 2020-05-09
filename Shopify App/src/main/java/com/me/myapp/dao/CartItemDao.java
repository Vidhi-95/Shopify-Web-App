package com.me.myapp.dao;

import com.me.myapp.model.Cart;
import com.me.myapp.model.CartItem;

public interface CartItemDao {

void addItemToCart(CartItem cartItem);
	
	void removeItemFromCart(CartItem cartItem);
	
	void removeAllItems(Cart Cart);
	
	CartItem getCartItemByProductId(int productId);
}
