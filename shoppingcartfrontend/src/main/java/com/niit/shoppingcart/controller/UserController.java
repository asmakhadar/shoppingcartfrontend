package com.niit.shoppingcart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

@Controller
public class UserController 
{

	@Autowired
	UserDAO userDAO;

	@Autowired
	User user;
	
	
//	@RequestMapping(value="/validateUser", method = RequestMethod.POST)
//	public String valid(@RequestParam(value="username") String email_id, @RequestParam(value="password") String password)
//	{
//		//ModelAndView mv = new ModelAndView("");
//		user = userDAO.validate(email_id, password);
//		if(user != null)
//		{
//			System.out.println("HI");
//		}
//		else
//		{
//			System.out.println("Fail");
//		}
//		return "redirect:/home";
//	}
	
	@RequestMapping(value="add_user", method = RequestMethod.POST)
	public String adduser(Model model, @Valid @ModelAttribute("user") User user)
	{
		user.setRole("user");
		userDAO.save(user);
		System.out.println("User added.");
		return "redirect:/";
	}
}
