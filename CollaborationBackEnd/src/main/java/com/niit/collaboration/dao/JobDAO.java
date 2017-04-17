package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Job;


public interface JobDAO 
{
	
	  public boolean add(Job job);
		
		public boolean delete(Job job);
		
		public Job getJob(long id);
		
		public List<Job> Joblist();
		
      public void update(Job job);

}
