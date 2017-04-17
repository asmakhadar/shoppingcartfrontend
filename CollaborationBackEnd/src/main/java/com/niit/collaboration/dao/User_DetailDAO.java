package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.User_Detail;

public interface User_DetailDAO 
{
	
	public boolean add(User_Detail user_Detail);
	
	public boolean delete(User_Detail user_Detail);
	
	public User_Detail getUser(String id);
	
	public List<User_Detail> Userlist();
	
	public User_Detail validate(String id, String password);

	public void update(User_Detail user_Detail);

}
