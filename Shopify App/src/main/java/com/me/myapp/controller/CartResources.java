package com.me.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.me.myapp.model.Product;
import com.me.myapp.model.Cart;
import com.me.myapp.model.CartItem;
import com.me.myapp.model.Customer;
import com.me.myapp.service.CartItemService;
import com.me.myapp.service.CartService;
import com.me.myapp.service.CustomerService;
import com.me.myapp.service.ProductService;

@Controller
@RequestMapping("/rest/cart")
public class CartResources {
	
	// Autowiring ProductService, CustomerService, CartService and CartItemService
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@RequestMapping("/{cartId}")
	// @Response body means response will be in json format. added jackson dependency for the same
	public@ResponseBody
	Cart getCartUsingId(@PathVariable(value = "cartId") int cartId) {
		return cartService.getCartById(cartId);
	}
	// HTTP Method Put to add products
	@RequestMapping(value = "/add/{productId}", method=RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	// add item to cart method
	public void addItem(@PathVariable(value = "productId") int productId, @AuthenticationPrincipal User activeUser) {
		
		// We are first getting customer obj from customer service and then using customer obj we are getting cart obj 
		Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
		Cart cart = customer.getCart();
		Product product = productService.getProductById(productId);
		
		// fetching cart item list
		List<CartItem> cartItems = cart.getCartItems();
		
		for(int i = 0;i<cartItems.size();i++) {
			if(product.getProductId()==cartItems.get(i).getProduct().getProductId()) {
				CartItem cItem = cartItems.get(i);
				// if a product already exists add just the quantity
				cItem.setQuantity(cItem.getQuantity()+1);
				// The below calculation is done to get the total Price of all the items in cart
				cItem.setTotalPrice(product.getProductPrice()*cItem.getQuantity());
				
				cartItemService.addItemToCart(cItem);
			}
		}
		
		CartItem cItem = new CartItem();
		cItem.setQuantity(1);
		cItem.setProduct(product);
		cItem.setTotalPrice(product.getProductPrice()*cItem.getQuantity());
		cItem.setCart(cart);
		
		cartItemService.addItemToCart(cItem);
		
		return;
	}

	// Removing products using put method
	@RequestMapping(value = "/remove/{productId}", method= RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable(value = "productId") int productId) {
		CartItem cItem = cartItemService.getCartItemByProductId(productId);
		cartItemService.removeItemFromCart(cItem);
	}
	// HTTP Method Delete
	@RequestMapping(value = "/{cartId}", method= RequestMethod.DELETE) // used cart id
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void clearCart(@PathVariable(value = "cartId") int cartId) { // method to clear the entire cart
		Cart myCart = cartService.getCartById(cartId);
		cartItemService.removeAllItems(myCart);
	}
	
	// To handle client side exceptions due to bad code
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify")
	public void handleClientSideErrors(Exception e) {}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "SeRvEr ErRoR - 500")
	public void handleServerErrors(Exception e) {}
	
}
