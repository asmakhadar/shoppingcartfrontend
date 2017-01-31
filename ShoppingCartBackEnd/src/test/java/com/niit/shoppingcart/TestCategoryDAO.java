package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class TestCategoryDAO 
{
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Category category;

	@Autowired
	AnnotationConfigApplicationContext context;

	public TestCategoryDAO() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");
	}

	public void add() 
	{
		category.setId("001");
		category.setName("nehal");
		category.setDescription("my bestfriend");
		categoryDAO.save(category);
		System.out.println("saved successfully");
	}

	public void update() 
	{
		category.setId("001");
		category.setName("nehal");
		category.setDescription("bestfriend");
		categoryDAO.save(category);
		System.out.println("updated successfully");
	}

	
	public void getCategory() 
	{
		category = categoryDAO.get("001");
		System.out.println(category.getName());
	}

	public static void main(String[] args) 
	{
		TestCategoryDAO tc = new TestCategoryDAO();
		 tc.add();
	 	// tc.update();
		// tc.getCategory();
	}
}