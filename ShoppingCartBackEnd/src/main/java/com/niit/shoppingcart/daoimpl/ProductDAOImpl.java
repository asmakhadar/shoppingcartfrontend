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

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

@Repository("productDAO")
@EnableTransactionManagement
public class ProductDAOImpl implements ProductDAO
{
	 Logger log = LoggerFactory.getLogger(CategoryDAOImpl.class);
		
	@Autowired
	SessionFactory sessionFactory;
		
		public ProductDAOImpl(SessionFactory sessionfactory) 
		{
			this.sessionFactory = sessionfactory;
			log.debug("Successfully estblished connection");
		}

	@Transactional
	public List<Product> list()
	{
			log.debug("Starting method : List");
			String hql_string = "FROM Product";
			Query query = sessionFactory.getCurrentSession().createQuery(hql_string);
			log.debug("Ending method : List");
			return query.list();
	}
		
	@Transactional
	 public Product get(String id)
	 {
		log.debug("Starting method : Get");
		String hql= "FROM Product where id='"+id+"'";
		Query query= sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list=query.list();
		return list.get(0);
	 }
		
	@Transactional
	 public boolean save(Product product)
	 {
		 try 
			{
				sessionFactory.getCurrentSession().saveOrUpdate(product);
			}
			catch (HibernateException e) 
			{
				e.printStackTrace();
				return false;
			}
			return true;
	 }
		
	@Transactional
	 public boolean update(Product product)
	 {
			try 
			{
				sessionFactory.getCurrentSession().update(product);
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
				String sql = "DELETE FROM Product where id = '" + id + "'";
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

