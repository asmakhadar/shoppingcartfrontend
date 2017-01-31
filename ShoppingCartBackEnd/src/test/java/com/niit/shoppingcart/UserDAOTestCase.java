//package com.niit.shoppingcart;
//
//import static org.junit.Assert.*;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.niit.shoppingcart.dao.UserDAO;
//import com.niit.shoppingcart.model.User;
//
//import junit.framework.Assert;
//
//public class UserDAOTestCase 
//{
//                              //Autowired-DAO,DO,context
//	@Autowired
//	static UserDAO userDAO;
//	
//	@Autowired
//	static User user;
//	
//	@Autowired
//	static AnnotationConfigApplicationContext context;
//	
//	                     //previously we written constructor
//	                     //but in juint we need to write a method
//	
//	@BeforeClass          //we can write @beforeclass only for the static methods
//	
//	public static void init()
//	{
//		context=new AnnotationConfigApplicationContext();
//		context.scan("com.niit.shoppingcart");
//	    context.refresh();
//	    user =(User) context.getBean("user");
//	
//	    userDAO=(UserDAO)context.getBean("userDAO");
//	}
//	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void getUserTestCase()
//	{
//		user=userDAO.get("asma786@gmail.com");
//		//assert statements
//	Assert.assertNotNull("getUserTestCase", user);	
//	}
//	
//	@SuppressWarnings("deprecation")
//	
//	@Test
//	public void validateCredentials()
//	{
//		user=userDAO.validate("asma786@gmail.com","786");
//      Assert.assertNotNull("validateCredentials", user);
//	}
//	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void InvalidateCredentials()
//	{
//		user=userDAO.validate("sowmya@gmail.com", "user");
//      Assert.assertNull("InvalidateCredentials", user); 
//	}
//	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void getAllUsersTestCase()
//	{
//		int size=userDAO.list().size();
//		Assert.assertEquals("length check", 10, size);	
//	}
//
//	@SuppressWarnings("deprecation")
//	@Test
//	public void saveTestCase()
//	{
//	    user.setEmail_id("chiruta@gmail.com");	
//		user.setFirst_name("chirutha");
//		user.setLast_name("chiru");
//		user.setMobile_number("5545454485");
//		user.setPassword("user");
//		user.setRole("customer");
//		
//	Assert.assertEquals("saveTestCase",true ,userDAO.save(user));
//		}
//	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void updateTestCase()
//	{
//	   user.setEmail_id("asma786@gmail.com");
//	   user.setFirst_name("asma");
//	   user.setLast_name("khadar");
//	   user.setMobile_number("123554698");
//	   user.setPassword("786");
//	   user.setRole("admin");
//	
//	   Assert.assertEquals("updateTestCase",true ,userDAO.update(user));
//}
//	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void DeleteTestCase()
//	{
//	    Assert.assertEquals("Delete Function", true, userDAO.delete("chiruta@gmail.com"));
//	}
//}
//
//
//
//
//


















