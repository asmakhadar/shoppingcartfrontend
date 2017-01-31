package com.niit.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.Category;

@Controller

public class AdminController 
{
	
@Autowired
Product product;

@Autowired
Category category;

@Autowired
Supplier supplier;


	@RequestMapping("add_product")
	public ModelAndView Product(Model m)
	{
		m.addAttribute("Product", new Product());
		ModelAndView mv=new ModelAndView("product");
		return mv;
	}
	
	@RequestMapping("add_category")
	public ModelAndView Category(Model m)
	{
		m.addAttribute("category", new Category());
	ModelAndView mv=new ModelAndView("category");
	return mv;
	}
	
	@RequestMapping("add_supplier")
	public ModelAndView supplier(Model m)
	{
		m.addAttribute("supplier", new Supplier());
		ModelAndView mv= new ModelAndView("supplier");
		return mv;
	}
}
