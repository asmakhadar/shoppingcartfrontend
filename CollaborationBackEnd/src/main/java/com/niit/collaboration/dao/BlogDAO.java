package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Blog;


public interface BlogDAO
{

	
    public boolean add(Blog blog);
	
	public boolean delete(Blog blog);
	
	public Blog getBlog(long id);
	
	public List<Blog> Bloglist();

	public void update(Blog blog);


}
