package com.me.myapp.service;

import com.me.myapp.model.Cart;
import com.me.myapp.model.CartItem;

public interface CartItemService {
	
	void addItemToCart(CartItem cartItem);
	
	void removeItemFromCart(CartItem cartItem);
	
	void removeAllItems(Cart cart);
	
	CartItem getCartItemByProductId(int productId);
}
