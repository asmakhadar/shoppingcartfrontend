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

    import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;



	@SuppressWarnings("deprecation")
	@Repository("blogDAO")
	@EnableTransactionManagement
	public class BlogDAOImpl implements BlogDAO
	{
		Logger log = LoggerFactory.getLogger(BlogDAOImpl.class);
		
	@Autowired
	SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory)
	{
		try{
			this.sessionFactory=sessionFactory;
		}catch(Exception e){
			log.error("Unable to connect to database");
			e.printStackTrace();
		}
	}
	

	@Transactional
		public boolean add(Blog blog) 
	{
			sessionFactory.getCurrentSession().save(blog);
	
			return false;
		}

		@Transactional
		public boolean delete(Blog blog) 
		{
			
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}

		@Transactional
		public Blog getBlog(long id) 
		{
			return (Blog) sessionFactory.getCurrentSession().get(Blog.class, id);
			
		}

		@Transactional
		@SuppressWarnings("unchecked")
		public List<Blog> Bloglist() {
			log.debug("->->Starting of the method list");
			 String hql="from Blog";
			 @SuppressWarnings("rawtypes")
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			 return query.list();
		}

		@Transactional
		public void update(Blog blog) 
		{
			sessionFactory.getCurrentSession().update(blog);			
		}

	
}
