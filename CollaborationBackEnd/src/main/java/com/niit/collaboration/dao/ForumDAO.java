package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Forum;


public interface ForumDAO {

	 public boolean add(Forum forum);
		
		public boolean delete(Forum forum);
		
		public Forum getForum(long id);
		
		public List<Forum> Forumlist();

		public void update(Forum forum);

}
