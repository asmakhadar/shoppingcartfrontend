package com.niit.shoppingcart.dao;


import com.niit.shoppingcart.model.Billing;

public interface BillingDAO

{

	public boolean addBilling(Billing billing);     
	                              
	 public Billing getBilling(String email_id);
		
	
}
