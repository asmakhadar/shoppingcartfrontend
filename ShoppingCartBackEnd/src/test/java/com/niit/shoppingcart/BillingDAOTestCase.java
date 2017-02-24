package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.BillingDAO;
import com.niit.shoppingcart.model.Billing;



	public class BillingDAOTestCase
	{
		
			@Autowired
			BillingDAO billingDAO;
			
			@Autowired
			Billing billing;
		
			
			@Autowired
			AnnotationConfigApplicationContext context;
			
			public BillingDAOTestCase()
			{
				context = new AnnotationConfigApplicationContext();
				context.scan("com.niit");
				context.refresh();
				billingDAO = (BillingDAO) context.getBean("billingDAO");
				billing = (Billing) context.getBean("billing");
				
			}
			
			public void add()
			{
				billing.setEmail_id("ayesha@gmail.com");	
				billing.setDebit_card_number("1234567894125");
				billing.setCard_cvv("278");
				billing.setExpiration_month("02");
				billing.setExpiration_year("2018");
				billingDAO.addBilling(billing);
				System.out.println("data added");
			}
		
			public static void main(String[] args) 
			{
				BillingDAOTestCase n = new BillingDAOTestCase();
			    n.add();

			}
		}


