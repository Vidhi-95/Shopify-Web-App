package com.me.myapp.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.me.myapp.model.Product;
import com.me.myapp.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminProduct {

	private Path path;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/product/addProduct")
	public String addProduct(Model mod) {
		Product prod = new Product();
		prod.setProductCategory("laptop");
		prod.setProductCondition("new");
		prod.setProductStatus("active");
		
		mod.addAttribute("product",prod);
		
		return "addProduct";
	}
	
	@RequestMapping(value = "/product/addProduct", method=RequestMethod.POST)
	// if we dont specify method it will by default take it as GET
	public String addProductsPost(@Valid @ModelAttribute("product") Product prod, 
			BindingResult res, HttpServletRequest request) {
		
		if(res.hasErrors()) {
			return "addProduct";
		}
		
		productService.addProduct(prod);
		
		MultipartFile prodImage = prod.getProductImage();
		//String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path path = Paths.get("C:\\Users\\vidhi\\Documents\\workspace-sts-3.9.12.RELEASE\\TestApp\\src\\main\\webapp\\resources\\images\\"
				+ prod.getProductId() + ".jpg");
		//path=Paths.get(rootDirectory + "\\resources\\images\\"+product.getProductId()+".jpg");
		
		if (prodImage!=null && !prodImage.isEmpty()) {
			try {
				prodImage.transferTo(new File(path.toString()));
			} catch (IOException e) {
				throw new RuntimeException("Product image saving failed",e);
			}
		}
		return "redirect:/admin/productInventory";
	}
	
	// Edit Product for Admin
	@RequestMapping("/product/editProduct/{id}")
	// as we are passing id in url, we need to define it in path variable
	public String editProduct(@PathVariable("id") int id, Model model) {
		Product product = productService.getProductById(id);
		
		model.addAttribute("product",product);
		
		return "editProduct";
	}
	
	@RequestMapping(value = "/product/editProduct", method=RequestMethod.POST)
	// if we dont specify method it will by default take it as GET
	public String editProductsPost(@Valid @ModelAttribute("product") Product product, 
			BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "editProduct";
		}
		
		MultipartFile productImage = product.getProductImage();
		//String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path path = Paths.get("C:\\Users\\vidhi\\Documents\\workspace-sts-3.9.12.RELEASE\\TestApp\\src\\main\\webapp\\resources\\images\\"
				+ product.getProductId() + ".jpg");
		//path=Paths.get(rootDirectory + "\\resources\\images\\"+product.getProductId()+".jpg");
		
		if (productImage!=null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			} catch (IOException e) {
				throw new RuntimeException("Product image saving failed",e);
			}
		}
		productService.editProduct(product);
		return "redirect:/admin/productInventory";
	}
	
	// Delete product functionality
	@RequestMapping("/product/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, Model mod, HttpServletRequest request) {
		
		Path path = Paths.get("C:\\Users\\vidhi\\Documents\\workspace-sts-3.9.12.RELEASE\\TestApp\\src\\main\\webapp\\resources\\images\\"
				+ id + ".jpg");
		
		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Product prod = productService.getProductById(id);
		productService.deleteProduct(prod);
		
		return "redirect:/admin/productInventory";
	}
}
