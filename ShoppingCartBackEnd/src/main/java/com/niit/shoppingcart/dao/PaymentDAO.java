package com.niit.shoppingcart.dao;

import com.niit.shoppingcart.model.Payment;

public interface PaymentDAO {

public boolean addpayment(Payment payment);
	
public Payment getpayment(String email_id);

public boolean savepayment(Payment payment);
    
	                              
	
}
