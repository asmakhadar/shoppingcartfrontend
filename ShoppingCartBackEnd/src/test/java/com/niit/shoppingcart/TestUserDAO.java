package com.niit.shoppingcart;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

public class TestUserDAO 
{
@Autowired
UserDAO userDAO;

@Autowired
User user;

@Autowired
AnnotationConfigApplicationContext context;

public TestUserDAO()
{
	        context = new AnnotationConfigApplicationContext();
	        context.scan("com.niit.shoppingcart");
	        context.refresh();
                                          //context-> bean factory	
	        userDAO=(UserDAO) context.getBean("userDAO");
			user= (User)context.getBean("user");
	
}
public void add()
{
	user.setEmail_id("asma786@gmail.com");
	user.setFirst_name("asma");
	user.setLast_name("khadar");
	user.setMobile_number("2578965412");
	user.setPassword("786");
	user.setRole("admin");
	userDAO.save(user);
	System.out.println("saved successfully");
}

public void update()
{
	user.setEmail_id("nafiya@gmail.com.com");
	user.setFirst_name("nafiya");
	user.setLast_name("nafiya");
	user.setMobile_number("8545965546");
	user.setPassword("user");
	user.setRole("admin");
    userDAO.update(user);
	System.out.println("successfully updated");	
}

 public void delete()
 {
	@SuppressWarnings("resource")
	Scanner sc=new Scanner(System.in);   // instead of scanner class we can use
	System.out.println("enter ID");      //user=userDAO.getuser();
	String id=sc.next();                 //
    userDAO.delete(id);
    System.out.println("deleted successfully");
}

public void getUser ()
{
	user=userDAO.get("asma@gmail.com");
	System.out.println(user.getFirst_name()+" "+user.getLast_name());
}

public void list()
{
	List<User>u=userDAO.list();
	for(User test:u)
	{
		System.out.println(test.getFirst_name());
	}
}

public static void main(String[] args) 
{
TestUserDAO tu =new TestUserDAO();
 tu.add();
//tu.delete();
//tu.update();
//tu.getUser();
//tu.list();
}	
}
