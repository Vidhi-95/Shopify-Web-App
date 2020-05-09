package com.me.myapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.me.myapp.model.Customer;


public interface CustomerDao {
	
	void addCustomer(Customer customer);
	
	Customer getCustomerById(int customerId);
	
	List<Customer> getAllCustomers();

	Customer getCustomerByUsername(String username);
}
