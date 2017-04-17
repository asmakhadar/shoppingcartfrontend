package com.niit.collaboration;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;
/*import com.niit.collaboration.model.BlogComment;
import com.niit.collaboration.model.BlogPost;
import com.niit.collaboration.model.User_Detail;*/

public class TestBlog {



	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		Blog blog = (Blog) context.getBean("blog");
		BlogDAO blogDAO = (BlogDAO) context.getBean("blogDAO");
		blog.setName("werrdd1");
		blog.setDateTime("24/02/2017");
		blog.setDescription("cfdf");
		blog.setStatus("sdfg");
		blog.setUserID("78");
	    System.out.println("Add - "+blog.getId());
	    blogDAO.add(blog);
		
		blog.setId(12);
		blog.setName("werrdd1");
		blog.setDateTime("24/02/2017");
		blog.setDescription("cfdf");
		blog.setStatus("sdfg");
		blog.setUserID("78");
		blogDAO.delete(blog);
		
	    System.out.println("Success");
	}
		
	
}
