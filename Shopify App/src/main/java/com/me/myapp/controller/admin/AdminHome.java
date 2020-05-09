
package com.me.myapp.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.me.myapp.model.Customer;
import com.me.myapp.model.Product;
import com.me.myapp.service.CustomerService;
import com.me.myapp.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminHome {
	
	@Autowired
	private CustomerService custService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping("/productInventory")
	public String productInventory(Model mod) {
		List<Product> prods = productService.getProductList();
		mod.addAttribute("products",prods);
		return "productInventory";
		}
	
	@RequestMapping("/customer")
	public String customerManagement(Model mod) {
		
		List<Customer> custList = custService.getAllCustomers();
		mod.addAttribute("customerList",custList);
		return "customerMgmt";
	}
}
