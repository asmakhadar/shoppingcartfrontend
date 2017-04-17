package com.niit.collaboration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.BlogCommentDAO;
import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.BlogComment;

public class TestCommentBlog {

	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		BlogComment blogComment = (BlogComment) context.getBean("blogComment");
		BlogCommentDAO blogCommentDAO = (BlogCommentDAO) context.getBean("blogCommentDAO");
		blogComment.setId(10);
		blogComment.setBlogID(5);
		blogComment.setBcomment("gsydcs");
		blogComment.setUserID("fdfuy");
		blogComment.setDateTime("23/5/2017");
		blogComment.setRating("5");
		
	    System.out.println("Add - "+blogComment.getId());
	    blogCommentDAO.save(blogComment);
		
		
	    System.out.println("Success");
	}
		
	
}
