package com.niit.shoppingcart.handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;



@Component
public class RegistrationHandler {

	@Autowired
	UserDAO userDAO;


	public User initFlow(){
		return new User();
	}

	public String validateDetails(User user,MessageContext messageContext){
		String status = "success";
		
		if(user.getFirst_name().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source("first_name").defaultText("First_name cannt be empty").build());
			status="failure";
		}
		if(user.getLast_name().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source("Last_name").defaultText("Last_name cannot be Empty").build());
			status = "failure";
		}
		
		if(user.getPassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source("password").defaultText("Password cannot be Empty").build());
			status = "failure";
		}
	
		if(user.getEmail_id().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source("email_id").defaultText("Email_id cannot be Empty").build());
			status = "failure";
		}
		if(user.getMobile_number().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source("mobile_number").defaultText("Mobile_number cannot be Empty").build());
			status = "failure";
		}

		return status;
	}
	
	public String saveDetails(User user){
		userDAO.save(user);
		return "success";
	}
}
