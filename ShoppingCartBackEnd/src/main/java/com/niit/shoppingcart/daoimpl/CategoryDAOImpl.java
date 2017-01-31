package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@SuppressWarnings("deprecation")
@Repository("categoryDAO")
@EnableTransactionManagement
public class CategoryDAOImpl implements CategoryDAO 
{
	Logger log = LoggerFactory.getLogger(CategoryDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory; // to do operations in database we need
									// sessionfactory

	public CategoryDAOImpl(SessionFactory sessionfactory) 
	{
		this.sessionFactory = sessionfactory;
		log.debug("Successfully estblished connection");
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	@Transactional
	public List<Category> list() 
	{
		log.debug("Starting method : List");
		String hql = "FROM Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending method : List");
		return query.list();
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	@Transactional
	public Category get(String id) 
	{
		log.debug("Starting method : Get");
		String hql= "FROM Category where id='"+id+"'";
		Query query= sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> list=query.list();
		return list.get(0);
	}

	@Transactional
	public boolean save(Category category) 
	{
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(category);
		}
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean update(Category category) 
	{
		try 
		{
			sessionFactory.getCurrentSession().update(category);
		}
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Transactional
	public boolean delete(String id) {
		try 
		{
			String sql = "DELETE FROM Category where id = '" + id + "'";
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

	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	@Transactional
	public Category getByName(String name) 
	{
		try
		{
			log.debug("GetByName method Started");
			String sql="FROM Category where name = '" + name + "'";
			Query query=sessionFactory.getCurrentSession().createQuery(sql);
			List<Category>list=query.list();
			return list.get(0);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			log.debug("GetByName error");
			return null;
		}
	}
}
