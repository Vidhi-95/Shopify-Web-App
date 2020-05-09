package com.me.myapp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.me.myapp.dao.CustomerOrderDao;
import com.me.myapp.model.Customer;
import com.me.myapp.model.CustomerOrder;

@Repository
@Transactional
public class CustomerOrderDaoImple implements CustomerOrderDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCustOrder(CustomerOrder custOrder) {
		Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(custOrder);
			session.flush();
		
	}

}
