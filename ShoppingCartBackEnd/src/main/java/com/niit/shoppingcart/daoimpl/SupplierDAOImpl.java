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

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;

	@Repository("supplierDAO")
	@EnableTransactionManagement

	public class SupplierDAOImpl implements SupplierDAO
	{
		Logger log = LoggerFactory.getLogger(CategoryDAOImpl.class);
		@Autowired
		public SessionFactory sessionFactory;     //to do operations in database we need sessionfactory
		
		public SupplierDAOImpl(SessionFactory sessionfactory)
		{
		this.sessionFactory=sessionfactory;  
		log.debug("Successfully estblished connection");
		}
		
		@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
		@Transactional
		public List<Supplier> list() 
		{
			log.debug("Starting method : List");
			String hql_string="FROM Supplier";
			Query query=sessionFactory.getCurrentSession().createQuery(hql_string);
			return query.list();
		}
		
		 @SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
		@Transactional
		public Supplier get(String id)
		 {
			 log.debug("Starting method : Get");
				String hql= "FROM Supplier where id='"+id+"'";
				Query query= sessionFactory.getCurrentSession().createQuery(hql);
				List<Supplier> list=query.list();
				return list.get(0);
		}
		 
		 @Transactional
		public boolean save(Supplier supplier)
		 {
			 try
				{
				sessionFactory.getCurrentSession().saveOrUpdate(supplier);
				}catch(HibernateException e){
					e.printStackTrace();
				return false;
			}
		        return true;
		}
		 
		 @Transactional
		public boolean update(Supplier supplier)
		 {
			 try 
				{
					sessionFactory.getCurrentSession().update(supplier);
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
		public boolean delete(String id)
		 {
			 try 
				{
					String sql = "DELETE FROM Supplier where id = '"+id+"'";
					Query query = sessionFactory.getCurrentSession().createQuery(sql);
					query.executeUpdate();
				}
				catch (HibernateException e) 
				{
				e.printStackTrace();
					return false;
				}
				return true;
		}

		
		@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
		@Transactional
		public Supplier getByName(String name)
			{
				try
				{
					log.debug("GetByName method Started");
					String sql="FROM Supplier where name = '" + name + "'";
					Query query=sessionFactory.getCurrentSession().createQuery(sql);
					List<Supplier>list=query.list();
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