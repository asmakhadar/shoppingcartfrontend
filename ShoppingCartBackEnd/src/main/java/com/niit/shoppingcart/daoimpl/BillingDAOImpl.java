package com.niit.shoppingcart.daoimpl;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.BillingDAO;
import com.niit.shoppingcart.model.Billing;


@Repository("billingDAO")
@EnableTransactionManagement

 public class BillingDAOImpl implements BillingDAO
 {
	
	Logger log = LoggerFactory.getLogger(BillingDAOImpl.class);
	@Autowired
	public SessionFactory sessionFactory;     //to do operations in database we need sessionfactory
	
	public BillingDAOImpl(SessionFactory sessionfactory)
	{
	this.sessionFactory=sessionfactory;  
	log.debug("Successfully estblished connection");
	}

		 	@Transactional
		 	public boolean addBilling(Billing billing) 
		 	{
		 		log.debug("Add billing method initiated");
		 		try 
		 		{
		 			sessionFactory.getCurrentSession().saveOrUpdate(billing);
		 			log.debug("Add billing method success");
		 		}
		 		catch (HibernateException e) 
		 		{	
		 			e.printStackTrace();
		 			log.error("Add billing method error");
		 			return false;
		 		}
		 		return true;
		 	}

		 	@Transactional
		 	public Billing getBilling(String email_id)
		 	{
		 		log.debug("Get billing method initiated");
		 		try 
		 		{
		 			log.debug("Get billing method success");
		 			return (Billing) sessionFactory.getCurrentSession().get(Billing.class, email_id);
		 		}
		 		catch (HibernateException e) 
		 		{
		 			e.printStackTrace();
		 			log.debug("Get billing method error");
		 			return null;
		 		}
		 	}

		 
			}
		 
	
             
 

