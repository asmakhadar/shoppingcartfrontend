package com.niit.shoppingcart.controller;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

                 //this class we have to convert into a controller(modelviewcontroller)
         //we hve to simple annotation(help compiler or jre to generate the code on behalf of u)
         //(class becomes controller)  //all the neccesary files will be loaded.

@Controller     
public class HomeController
{
Logger log = LoggerFactory.getLogger(HomeController.class);

@Autowired
User user;

@Autowired
private CategoryDAO categoryDAO;

@Autowired
private Category category;

@Autowired
private SupplierDAO supplierDAO;

@Autowired
private Supplier supplier;

@Autowired
private Product product;

	             // want to navigate to landing page or home page.
               	//http://localhost:ipaddress/application name
	           //http://localhost:ipaddress8080/Shoppingcart/
	
	@RequestMapping("/")  //for the landing page
	public ModelAndView onLoad(HttpSession session){
		log.debug("Starting of the method onLoad");
		ModelAndView mv = new ModelAndView("home");
		session.setAttribute("category",category);
		session.setAttribute("product",product);
		session.setAttribute("supplier",supplier);
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("supplierList", supplierDAO.list());
		log.debug("Ending of the method onLoad");
		return mv;	
	}	
	
	@RequestMapping(value="/login")
	public String  login(@RequestParam(value="error",required=false)String error,@RequestParam(value="logout",required=false) String logout,Model model)
	{
		if(error!=null)
		{
			System.out.println("Error..");
			model.addAttribute("loginerror","...Invalid username and password");
		}
		
		if(logout!=null)
		{
			System.out.println("logout called..");
			model.addAttribute("loginmsg","...you have been logged out");
		}
		
		return "login";
	}
	
	@RequestMapping("/register")
	public ModelAndView signup(Model m)
	{
		
		ModelAndView mv = new ModelAndView("/home");
		m.addAttribute("user",user);
		return mv;
	}	
	
	@RequestMapping(value="/admin")
	public String showAdminPage(Model m)
	{
		return "admin";
	}
	
	@RequestMapping("/home")  //for the landing page
	public ModelAndView onHome(HttpSession session){
		log.debug("Starting of the method onLoad");
		ModelAndView mv = new ModelAndView("home");
		session.setAttribute("category",category);
		session.setAttribute("product",product);
		session.setAttribute("supplier",supplier);
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("supplierList", supplierDAO.list());
		log.debug("Ending of the method onLoad");
		return mv;	
	}	
	
	@RequestMapping(value="/contactus")
	public String contactuspage()
	{
		return "contactus";
	}
}