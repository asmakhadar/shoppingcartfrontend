package com.niit.shoppingcart.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.daoimpl.UserDAOImpl;

                 //this class we hve to convert into a controller(mvc)
                 //we hve to simple annotation(help compiler or jre to generate the code on behalf of u)
@Controller      //(class becomes controller)  //all the neccesary files will be loaded.

public class HomeController {

	
	             // want to navigate to landing page or home page.
               	//http://localhost:ipaddress/application name
	           //http://localhost:ipaddress8080/Shoppingcart/
	
	@RequestMapping("/")  //for the landing page
	public String getlanding()
	{
		System.out.println("landing page is loading...");
		return "index";
	}
	
	@RequestMapping("/home")
	public String homepage()
	{
		System.out.println("homepage is loading...");
		return "home";
	}	
	
	@RequestMapping("/login")
	public ModelAndView showLoginPage()
	{
		     //model and view=to specify which page to navigate
		    // wat data  i need to be carry.
		   // navigate to login.jsp
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("msg", "you clicked login link");
		mv.addObject("showLoginPage","true");
	       
	      //in login.jsp-${msg}
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView showRegistrationPage()
	{
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("msg","you clicked registration link");
		mv.addObject("showRegistrationPage","true");
		return mv;
	}
	
		@RequestMapping("/validate")
		public ModelAndView validate(@RequestParam("username")String id ,@RequestParam("password")String pswd)
		{
			System.out.println("in validate method");
			System.out.println("id:"+id);
			System.out.println("pswd:"+pswd);
			ModelAndView mv = new ModelAndView("home");
			
	     UserDAO userDAO = new UserDAOImpl(); //will remove new later
			
			if(userDAO.isValidCredentials(id,pswd)==true)
            {
	        mv.addObject("successMsg","You logged in successfully");
            }
            else
            {
	        mv.addObject("errorMsg", "Invalid Credentials..please try again");
            }	
			
			return mv;
			
		}
}	
	        //need to validate - actually-need to write DAO-get values from tables
			//temporarily-assuming that id:niit and pswd:niit@123 are valid credentials
			//if the credentials are valid->show message "welcome to shopping cart"
		    //else show message invalid credentials+login page=both shld be displayed in homepage
			
		
			
		    
		