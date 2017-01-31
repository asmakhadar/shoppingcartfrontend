package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;


public class TestProductDAO
{
	@Autowired
	ProductDAO productDAO;

	@Autowired
	Product product;

	@Autowired
	AnnotationConfigApplicationContext context;

	public TestProductDAO()
	{
		        context = new AnnotationConfigApplicationContext();
		        context.scan("com.niit.shoppingcart");
		        context.refresh();
		        productDAO=(ProductDAO)context.getBean("productDAO");
		        product=(Product)context.getBean("product");
		
	}
	public void add()
	{
		product.setId("5645");
		product.setCategory_id("233");
		product.setDescription("famous product");
		product.setName("fastrack");
		product.setPrice(5999);
		product.setStock(5);
		product.setSupplier_id("123");
		productDAO.save(product);
		System.out.println("saved successfully");
	}

	public void update()
	{
		product.setId("1");
		product.setCategory_id("233");
		product.setDescription("popular");
		product.setName("casio");
		product.setPrice(5999);
		product.setStock(5);
		product.setSupplier_id("123");
		productDAO.update(product);
		System.out.println("successfully updated");	
	}

	public void getProduct()
	{
		product=productDAO.get("1");
		System.out.println(product.getSupplier_id());
	}

	public static void main(String[] args) 
	{
	TestProductDAO tp =new TestProductDAO();
	
	tp.add();
	//tp.update();
	//tp.getProduct();
	}		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
