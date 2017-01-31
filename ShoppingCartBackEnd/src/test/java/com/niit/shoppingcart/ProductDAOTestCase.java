//package com.niit.shoppingcart;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.niit.shoppingcart.dao.ProductDAO;
//import com.niit.shoppingcart.model.Product;
//
//import junit.framework.Assert;
//
//public class ProductDAOTestCase 
//{
//	@Autowired
//	static ProductDAO productDAO;
//	
//	@Autowired
//	static Product product;
//	
//	@Autowired
//	static AnnotationConfigApplicationContext context;
//	
//	                     //previously we written constructor
//	                     //but in juint we need to write a method
//	
//	@BeforeClass          //we can write @beforeclass only for the static methods
//	
//	public static void init()
//	{
//		context=new AnnotationConfigApplicationContext();
//		context.scan("com.niit.shoppingcart");
//	    context.refresh();
//	    product =(Product) context.getBean("product");
//	
//	    productDAO=(ProductDAO)context.getBean("productDAO");
//	}
//	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void getProductTestCase()
//	{
//		product=productDAO.get(234);
//		//assert statements
//	Assert.assertNotNull("getproductTestCase", product);	
//	}
//	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void getAllProductTestCase()
//	{
//		int size=productDAO.list().size();
//		Assert.assertEquals("length check", 2, size);	
//	}
//
//	@SuppressWarnings("deprecation")
//	@Test
//	public void saveTestCase()
//	{
//		product.setCategory_id("234");	
//		product.setDescription("famous");
//		product.setId("2");
//		product.setName("fastrack");
//		product.setPrice(5999);
//		product.setStock(5);
//		product.setSupplier_id("123");
//		
//	Assert.assertEquals("saveTestCase",true ,productDAO.save(product));
//		}
//	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void updateTestCase()
//	{
//		product.setId("2");
//		product.setName("casio");
//		product.setDescription("famous");
//		product.setPrice(5999);
//		product.setStock(5);
//		product.setSupplier_id("123");
//		product.setCategory_id("234");
//	   Assert.assertEquals("updateTestCase",true ,productDAO.update(product));
//}
//	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void DeleteTestCase()
//	{
//	    Assert.assertEquals("Delete Function", true, productDAO.delete(2));
//	}
//}
