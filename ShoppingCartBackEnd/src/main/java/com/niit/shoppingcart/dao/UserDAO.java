
package com.niit.shoppingcart.dao;

import java.util.List;
import com.niit.shoppingcart.model.User;


public interface UserDAO 
{
	                                 //jst nly declare wat to do
	                                   	//crud operations+validation
		
		
	 public List<User> list();         //list of users..list means collection

	 public User get(String id);       //employee=boolean
	                               //checking whether the credentials are valid or not

	                              //if it is valid it will return employee,else will return null
	 
	 public User validate(String id,String password);

		                           //save
	 
	 public boolean save(User user);  //boolean=successfully saved(true) or not(false)
		
	 
	 public boolean update(User user);
		
	 
	 public boolean delete(String id);

		
	}












