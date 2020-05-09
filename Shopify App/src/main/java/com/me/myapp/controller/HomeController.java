package com.me.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.security.auth.login.Configuration;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.me.myapp.dao.ProductDao;
import com.me.myapp.model.Product;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "homePage";
		
}
	@RequestMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error,
						@RequestParam(value="logout", required=false)String logout, Model mod) {
		if(error!=null) {
			mod.addAttribute("error","Invalid username and password combination");
		}
		
		if(logout!=null) {
			mod.addAttribute("msg","Logout success!");
		}
		
		return "login";
	}
	// About us page
	@RequestMapping(value = "/aboutUs")
	public String aboutPage() {
		return "aboutUs";
		
}
}