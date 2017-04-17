package com.niit.collaboration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.model.Friend;

public class TestFriend {

	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		Friend friend = (Friend) context.getBean("friend");
		FriendDAO friendDAO = (FriendDAO) context.getBean("friendDAO");
		
		/*friend.setFriendID("45");
		friend.setStatus("sggdh");
		friend.setUserID("924");
	    System.out.println("Add - "+friend.getId());
	    friendDAO.save(friend);*/
	
		
		
	    /*friend.setUserID("924");      //not working
		friend.setFriendID("45");
		friend.setStatus("sggdh");
		friendDAO.delete("924", "45");*/
		
	    //System.out.println("Success");
		
		System.out.println(friendDAO.get("001", "002"));
	}
		
}

