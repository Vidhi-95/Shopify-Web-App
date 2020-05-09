package com.me.myapp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.myapp.model.Product;
import com.me.myapp.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//To show all the products on the page
	@RequestMapping("/productList/all")
	public String getAllProducts(Model model) {
		List<Product> listOfProducts = productService.getProductList();
		model.addAttribute("products",listOfProducts);
		
		return "productList";
	}
	
	@RequestMapping("/viewProduct/{productId}")
	// To extract the value from {productId} we use path variable
	public String viewProduct(@PathVariable int productId, Model model) throws IOException{
		Product prod = productService.getProductById(productId);
		model.addAttribute("product",prod);
		
		return "viewProduct";
	}
	
	@RequestMapping("/productList")
	public String getProductFromCategory(@RequestParam(value = "searchCondition", required=false) String searchCondition, Model mod) {
	
	List<Product> products = productService.getProductList();
	mod.addAttribute("products",products);
	mod.addAttribute("searchCondition",searchCondition);
	
	return "productList";
	}
}

