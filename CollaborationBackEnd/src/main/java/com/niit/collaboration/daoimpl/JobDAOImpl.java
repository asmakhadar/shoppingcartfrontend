package com.niit.collaboration.daoimpl;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.dao.JobDAO;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.Job;




@SuppressWarnings("deprecation")
@Repository("jobDAO")
@EnableTransactionManagement

public class JobDAOImpl implements JobDAO
{
	Logger log = LoggerFactory.getLogger(JobDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory)
	{
		try{
			this.sessionFactory=sessionFactory;
		}catch(Exception e){
			log.error("Unable to connect to database");
			e.printStackTrace();
		}
	}
	
	@Transactional
		public boolean add(Job job) 
	{
			sessionFactory.getCurrentSession().save(job);
			return false;
		}

		@Transactional
		public boolean delete(Job job) 
		{
			
			sessionFactory.getCurrentSession().delete(job);
			return true;
		}

		@Transactional
		public Job getJob(long id) 
		{
			return (Job) sessionFactory.getCurrentSession().get(Job.class, id);
			
		}

		@Transactional
		@SuppressWarnings("unchecked")
		public List<Job> Joblist() {
			log.debug("->->Starting of the method list");
			 String hql="from Job";
			 @SuppressWarnings("rawtypes")
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			 return query.list();
		}

		@Transactional
		public void update(Job job) 
		{
			sessionFactory.getCurrentSession().update(job);			
		}


}
