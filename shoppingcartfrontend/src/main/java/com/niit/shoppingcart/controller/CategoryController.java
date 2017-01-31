package com.niit.shoppingcart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.util.Util;


@Controller
public class CategoryController 
{	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	
	@Transactional
	@RequestMapping("/category")
	public ModelAndView showRegistrationPage(Model m)
	{
		m.addAttribute("category", new Category());
		ModelAndView mv = new ModelAndView("category");
		mv.addObject("categoryList", categoryDAO.list());
//		mv.addObject("msg","you clicked registration link");
//		mv.addObject("showRegistrationPage","true");
		return mv;
	}	
	
	@Transactional
	@RequestMapping(value="add_category", method = RequestMethod.POST)
	public String addcategory(Model model, @Valid @ModelAttribute("category") Category category)
	{
		Util util = new Util();
		String category_id = util.removeComma(category.getId());
		category.setId(category_id);
		categoryDAO.save(category);
		System.out.println("Category added.");
		return "redirect:/category";
	}
	
@Transactional
	@RequestMapping("category_delete-{id}")
	public String deletecategory (@PathVariable("id")String id)
	{
		categoryDAO.delete(id);
		System.out.println("category deleted");
		return "redirect:/category";
	}

	@Transactional
	@RequestMapping("category_edit-{id}")
	public String editcategory (@PathVariable("id") String id,Model model)
	{
		model.addAttribute("category", this.categoryDAO.get(id));
		model.addAttribute("categoryList", categoryDAO.list());
		System.out.println("category edited");
	    return "category";
	}
}
