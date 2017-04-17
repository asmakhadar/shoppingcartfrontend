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

import com.niit.collaboration.dao.User_DetailDAO;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.User_Detail;



@SuppressWarnings("deprecation")
@Repository("user_DetailDAO")
@EnableTransactionManagement
public class User_DetailDAOImpl implements User_DetailDAO
{
	 Logger log = LoggerFactory.getLogger(User_DetailDAOImpl.class);
@Autowired
SessionFactory sessionFactory;

public User_DetailDAOImpl(SessionFactory sessionFactory) 
{
	this.sessionFactory = sessionFactory;
}

@Transactional
	public boolean add(User_Detail user_Detail) 
{
		sessionFactory.getCurrentSession().saveOrUpdate(user_Detail);
		return false;
	}

	@Transactional
	public boolean delete(User_Detail user_Detail) 
	{
		sessionFactory.getCurrentSession().delete(user_Detail);
		return true;
	}

	@Transactional
	public User_Detail getUser(String id) 
	{
		return (User_Detail) sessionFactory.getCurrentSession().get(User_Detail.class, id);
	}

	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<User_Detail> Userlist()
	{
		log.debug("Starting method : List");
		String hql_string = "FROM User_Detail";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql_string);
		log.debug("Ending method : List");
		return query.list();
	}
	
	@Transactional
	public User_Detail validate(String id, String password)
	{
		String hql_string="FROM User_Detail where id = '"+id+"'AND password='"+password+"'";
		@SuppressWarnings("rawtypes")
		Query query=sessionFactory.getCurrentSession().createQuery(hql_string);
		return ( User_Detail) query.uniqueResult();
	}

	@Transactional
	public void update(User_Detail user_Detail) 
	{
		sessionFactory.getCurrentSession().update(user_Detail);			
	}
	
	}


