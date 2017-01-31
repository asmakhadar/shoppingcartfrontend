//package com.niit.shoppingcart;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.niit.shoppingcart.dao.CategoryDAO;
//import com.niit.shoppingcart.model.Category;
//
//import junit.framework.Assert;
//
//public class CategoryDAOTestCase 
//{
//
//	@Autowired
//	static CategoryDAO categoryDAO;
//	
//	@Autowired
//	static Category category;
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
//	    category =(Category) context.getBean("category");
//	
//	    categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
//	}
//	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void getCategoryTestCase()
//	{
//		category=categoryDAO.get("123");
//		//assert statements
//	Assert.assertNotNull("getcategoryTestCase", category);	
//	}
//	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void getAllCategoryTestCase()
//	{
//		int size=categoryDAO.list().size();
//		Assert.assertEquals("length check", 1, size);	
//	}
//
//	@SuppressWarnings("deprecation")
//	@Test
//	public void saveTestCase()
//	{
//		category.setDescription("xsgfxc");	
//		category.setId("003");
//		category.setName("asi");
//		
//	Assert.assertEquals("saveTestCase",true ,categoryDAO.save(category));
//		}
//	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void updateTestCase()
//	{
//     category.setId("123");
//		category.setName("kaju");
//	   category.setDescription("fghj");
//	   Assert.assertEquals("updateTestCase",true ,categoryDAO.update(category));
//}
//	
//	@SuppressWarnings("deprecation")
//	
//	@Test
//	public void DeleteTestCase()
//	{
//	    Assert.assertEquals("Delete Function", true, categoryDAO.delete("003"));
//	}
//}
//
//	
//	
