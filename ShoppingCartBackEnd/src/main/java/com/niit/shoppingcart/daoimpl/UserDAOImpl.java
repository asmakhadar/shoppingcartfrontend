package com.niit.shoppingcart.daoimpl;

import java.util.List;       //deprecated means in later versions dey will remove it


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;


@Repository("userDAO")
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO
{
	Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	    //you required session factory=its there in application context config
		
		
		@Autowired
		public SessionFactory sessionFactory;     //to do operations in database we need sessionfactory
		
		public UserDAOImpl(SessionFactory sessionfactory)
		{
		this.sessionFactory=sessionfactory;           
		}
		@Transactional
		public List<User> list()
		{
			log.debug("HI");
			String hql_string="FROM User";
			Query query=sessionFactory.getCurrentSession().createQuery(hql_string);
			return query.list();
		}
		
	    @Transactional
		public User get(String id) 
		{
			return (User)sessionFactory.getCurrentSession().get(User.class,id);
		}
	    
        @Transactional
		public User validate(String id, String password)
        {
        	String hql_string="FROM User where email_id = '"+id+"'AND password='"+password+"'";
			Query query=sessionFactory.getCurrentSession().createQuery(hql_string);
			return (User) query.uniqueResult();
		}

        
        @Transactional
		public boolean save(User user) {
			
			try
			{
			sessionFactory.getCurrentSession().save(user);
			}catch(HibernateException e){
				e.printStackTrace();
			return false;
		}
	        return true;
		}
        
		@Transactional
		public boolean update(User user)
		{
			try 
			{
				sessionFactory.getCurrentSession().update(user);
			} 
			catch (HibernateException e) 
			{
				e.printStackTrace();
			return false;
		}
		    return true;
	}
		@Transactional
		public boolean delete(String id) 
		{
			try 
			{
				String sql = "DELETE FROM User where email_id = '"+id+"'";
				Query query = sessionFactory.getCurrentSession().createQuery(sql);
				query.executeUpdate();
			}
			catch (HibernateException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			return true;
		}
}	
	
		

	
	
