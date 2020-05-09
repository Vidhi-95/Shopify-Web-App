package com.me.myapp.service;

import java.util.List;

import com.me.myapp.model.Product;

public interface ProductService {

	List<Product> getProductList();
	
	Product getProductById(int id);
	
	void addProduct(Product product);
	
	void editProduct(Product product);
	
	void deleteProduct(Product product);
}
