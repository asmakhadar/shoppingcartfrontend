package com.niit.collaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.User_DetailDAO;
import com.niit.collaboration.model.User_Detail;

@RestController
public class User_DetailController 
{
	@Autowired
	User_Detail user_Detail;
	
	@Autowired
	User_DetailDAO user_DetailDAO;
	
	@PostMapping("/addUser/")
	public ResponseEntity<User_Detail> createUser(@RequestBody User_Detail user_Detail)
	{
		user_Detail.setIs_online("N");
		user_Detail.setStatus("P");
		user_Detail.setRole("Student");
		user_Detail.setReason("N");
		user_DetailDAO.add(user_Detail);
		user_Detail.setErrorCode("200");
		user_Detail.setErrorMsg("Success....");
		
		return new ResponseEntity<User_Detail> (user_Detail,HttpStatus.OK) ;
	}
	
//	@DeleteMapping("/deleteUser/")
//	public ResponseEntity<User_Detail> deleteUser(@RequestBody User_Detail user_Detail)
//	{
//		user_DetailDAO.delete(user_Detail);
//		user_Detail.setErrorCode("200");
//		user_Detail.setErrorMsg("Success....");
//		
//		return new ResponseEntity<User_Detail> (user_Detail,HttpStatus.OK) ;
//	}
	
	@GetMapping("/deleteUser-{id}")
	public ResponseEntity<User_Detail> deleteUser(@PathVariable("id") String id)
	{
		user_Detail = user_DetailDAO.getUser(id);
		System.out.println("USERNAME "+user_Detail.getName());
	    user_DetailDAO.delete(user_Detail);
	    user_Detail = new User_Detail();
	    user_Detail.setErrorCode("200");
		user_Detail.setErrorMsg("Success....");
		System.out.println(" deleted");
		return new ResponseEntity<User_Detail> (user_Detail,HttpStatus.OK);
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User_Detail>> getAllUser()
	{
		List<User_Detail> users= user_DetailDAO.Userlist();
		if(users.isEmpty())
				{
			 user_Detail.setErrorCode("100");
				user_Detail.setErrorMsg("No users are available");
				users.add(user_Detail);
				return new ResponseEntity< List<User_Detail>>(users,HttpStatus.OK);
				}
		 user_Detail.setErrorCode("200");
			user_Detail.setErrorMsg("Successfully fetched the user");

		return new ResponseEntity< List<User_Detail>>(users,HttpStatus.OK);
	}
		
}
