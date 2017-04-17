package com.niit.collaboration;

	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.ForumDAO;
import com.niit.collaboration.model.Forum;

	

	public class TestForum {

		public static void main(String[] args)
		{
			@SuppressWarnings("resource")
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("com.niit");
			context.refresh();
			
			Forum forum = (Forum) context.getBean("forum");
			ForumDAO forumDAO = (ForumDAO) context.getBean("forumDAO");
			
			forum.setId(455);
			forum.setName("werrdd1");
			forum.setDateTime("24/02/2017");
			forum.setDescription("cfdf");
			forum.setStatus("sdfg");
			forum.setUserID("78");
		    System.out.println("Add - "+forum.getId());
		    forumDAO.add(forum);
			
			/*forum.setId(12);
			forum.setName("werrdd1");
			forum.setDateTime("24/02/2017");
			forum.setDescription("cfdf");
			forum.setStatus("sdfg");
			forum.setUserID("78");
			forumDAO.delete(forum);*/
			
		    System.out.println("Success");
		}
			
		
	}

