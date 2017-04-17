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

import com.niit.collaboration.dao.ForumDAO;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.Forum;



@SuppressWarnings("deprecation")
@Repository("forumDAO")
@EnableTransactionManagement
public class ForumDAOImpl implements ForumDAO
{
	Logger log = LoggerFactory.getLogger(ForumDAOImpl.class);
	
@Autowired
SessionFactory sessionFactory;

public ForumDAOImpl(SessionFactory sessionFactory)
{
	try{
		this.sessionFactory=sessionFactory;
	}catch(Exception e){
		log.error("Unable to connect to database");
		e.printStackTrace();
	}
}

@Transactional
public boolean add(Forum forum) 
	{
		sessionFactory.getCurrentSession().save(forum);
		return false;
	}
@Transactional
public boolean delete(Forum forum) 
	{
		sessionFactory.getCurrentSession().delete(forum);
		return false;
	}

@Transactional
public Forum getForum(long id) {
	return (Forum) sessionFactory.getCurrentSession().get(Forum.class, id);
}

@Transactional
@SuppressWarnings("unchecked")
public List<Forum> Forumlist() {
	log.debug("->->Starting of the method list");
	 String hql="from Forum";
	 @SuppressWarnings("rawtypes")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	 return query.list();
}

@Transactional
public void update(Forum forum) 
{
	sessionFactory.getCurrentSession().update(forum);			
}

 
}
