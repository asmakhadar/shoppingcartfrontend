package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.PaymentDAO;
import com.niit.shoppingcart.model.Payment;


@Repository("paymentDAO")
@EnableTransactionManagement
public class PaymentDAOImpl implements PaymentDAO
{
	Logger log = LoggerFactory.getLogger(PaymentDAOImpl.class);
	@Autowired
	public SessionFactory sessionFactory;     //to do operations in database we need sessionfactory
	
	public PaymentDAOImpl(SessionFactory sessionfactory)
	{
	this.sessionFactory=sessionfactory;  
	log.debug("Successfully estblished connection");
	}

	@Transactional
	public boolean addpayment(Payment payment)
	{
		log.debug("addpayment method initiated");
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(payment);
			log.debug("addpayment method success");
		}
		catch (HibernateException e) 
		{	
			e.printStackTrace();
			log.error("addpayment method error");
			return false;
		}
		return true;
	}

	@Transactional
	 public Payment getpayment(String email_id)
	{
		log.debug("Get method initiated");
		try 
		{
			log.debug("Get method success");
			return (Payment) sessionFactory.getCurrentSession().get(Payment.class, email_id);
		}
		catch (HibernateException e) 
		{ 
			e.printStackTrace();
			log.debug("Get method error");
			return null;
		}
	}

	public boolean savepayment(Payment payment) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
