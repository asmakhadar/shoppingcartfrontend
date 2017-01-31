//package com.niit.shoppingcart;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.niit.shoppingcart.dao.SupplierDAO;
//import com.niit.shoppingcart.model.Supplier;
//
//import junit.framework.Assert;
//
//public class SupplierDAOTestCase 
//{
//	@Autowired
//	static SupplierDAO supplierDAO;
//	
//	@Autowired
//	static Supplier supplier;
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
//	    supplier =(Supplier) context.getBean("supplier");
//	
//	    supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
//	}
//	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void getSupplierTestCase()
//	{
//		supplier=supplierDAO.get("1");
//		//assert statements
//	Assert.assertNotNull("getsupplierTestCase", supplier);	
//	}
//	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void getAllSupplierTestCase()
//	{
//		int size=supplierDAO.list().size();
//		Assert.assertEquals("length check", 7, size);	
//	}
//
//	@SuppressWarnings("deprecation")
//	@Test
//	public void saveTestCase()
//	{
//		supplier.setId("2");	
//		supplier.setName("sumana");
//		supplier.setAddress("malleshwaram");	
//	Assert.assertEquals("saveTestCase",true ,supplierDAO.save(supplier));
//		}
//	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void updateTestCase()
//	{
//		supplier.setId("2");
//		supplier.setName("sumana");
//		supplier.setAddress("rr nagar");
//	   Assert.assertEquals("updateTestCase",true ,supplierDAO.update(supplier));
//}
//	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void DeleteTestCase()
//	{
//	    Assert.assertEquals("Delete Function", true, supplierDAO.delete("2"));
//	}
//}
//
//
