package com.me.myapp.service;

import com.me.myapp.model.CustomerOrder;

public interface CustomerOrderService {
	
	void addCustOrder(CustomerOrder custOrder);
	
	double getCustOrderGrandTotal(int cartId);
}
