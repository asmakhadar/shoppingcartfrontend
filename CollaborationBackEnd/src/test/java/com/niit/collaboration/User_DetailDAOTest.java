package com.niit.collaboration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.User_DetailDAO;
import com.niit.collaboration.model.User_Detail;

public class User_DetailDAOTest
{
public static void main(String[] args)
{
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	User_Detail user_Detail = (User_Detail) context.getBean("user_Detail");
	User_DetailDAO user_DetailDAO = (User_DetailDAO) context.getBean("user_DetailDAO");
	
user_Detail.setId("002");
user_Detail.setName("sanu");
user_Detail.setEmail("sanu@gmail.com");
user_Detail.setPassword("sanu");
user_Detail.setGender("female");
user_Detail.setRole("user");
user_Detail.setStatus("stefd");
user_Detail.setIs_online("no");
System.out.println("Add - "+user_Detail.getId());
user_DetailDAO.add(user_Detail);


user_Detail.setId("002");
user_Detail.setName("sanu");
user_Detail.setEmail("sanu@gmail.com");
user_Detail.setPassword("sanu");
user_Detail.setGender("female");
user_Detail.setRole("user");
user_Detail.setStatus("stefd");
user_Detail.setIs_online("no");
user_DetailDAO.delete(user_Detail);

System.out.println("Success");
}
}