package com.me.myapp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.me.myapp.dao.CartItemDao;
import com.me.myapp.model.Cart;
import com.me.myapp.model.CartItem;

@Repository
@Transactional
public class CartItemDaoImple implements CartItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addItemToCart(CartItem cartItemObj) {
		Session session = sessionFactory.getCurrentSession();
		// If hibernate finds a primary key then it updates the same obj else it creates a new on
		session.saveOrUpdate(cartItemObj);
		session.flush();
	}

	@Override
	public void removeItemFromCart(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();
	}

	@Override
	public void removeAllItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItems();
		
		for(CartItem cItem: cartItems) {
			removeItemFromCart(cItem);
		}
		
	}

	@Override
	public CartItem getCartItemByProductId(int productId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CartItem where productId = ?");
		query.setInteger(0, productId);
		session.flush();
		//return (CartItem) query.uniqueResult();
		return (CartItem) query.setMaxResults(1).uniqueResult();
	}

}
