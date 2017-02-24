package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.PaymentDAO;
import com.niit.shoppingcart.model.Payment;


public class PaymentDAOTestCase {
	
	@Autowired
	PaymentDAO paymentDAO;
	
	@Autowired
	Payment payment;

	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public PaymentDAOTestCase()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		paymentDAO = (PaymentDAO) context.getBean("paymentDAO");
		payment = (Payment) context.getBean("payment");
		
	}
	
	public void add()
	{
		payment.setEmail_id("ayesha@gmail.com");	
		payment.setFirst_name("ayesha");
		payment.setLast_name("278");
		payment.setMobile_number("8254445442");
		payment.setPostal_code("560026");
		payment.setAddress("mathikere");
		payment.setCity("bangalore");
		payment.setState("karnataka");
		paymentDAO.addpayment(payment);
		System.out.println("data added");
	}

	public static void main(String[] args) 
	{
		PaymentDAOTestCase n = new PaymentDAOTestCase();
	    n.add();

	}
}
