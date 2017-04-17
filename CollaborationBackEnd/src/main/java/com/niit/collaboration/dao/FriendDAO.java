package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Friend;

public interface FriendDAO 
{
	 public boolean save(Friend friend);
		
		public boolean update(Friend friend);
		
		public Friend get(String userID, String friendID);
		
		public void delete(String userID, String friendID);
		
		public List<String> getMyFriendlist(String userID);
		
		public List<Friend> getMyFriendRequests(String userID);     //pending
		
		public List<Friend> getRequestsSendByMe(String userID);
		
	 
}
