package com.me.myapp.dao;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.me.myapp.model.Product;


public interface ProductDao {

List<Product> getProductList();
	
	Product getProductById(int id);
	
	void addProduct(Product product);
	
	void editProduct(Product product);
	
	void deleteProduct(Product product);
}
