package com.niit.collaboration.controller;

	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;

    import com.niit.collaboration.dao.BlogDAO;
    import com.niit.collaboration.model.Blog;

	

	@RestController
	public class BlogController 
	{
		@Autowired
		Blog blog;
		
		@Autowired
		BlogDAO blogDAO;
		
		@PostMapping("/addBlog/")
		public ResponseEntity<Blog> createBlog(@RequestBody Blog blog)
		{
			blogDAO.add(blog);
			blog.setErrorCode("200");
			blog.setErrorMsg("Success....");
			
			return new ResponseEntity<Blog> (blog,HttpStatus.OK) ;
		}
		

		@GetMapping("/deleteBlog-{id}")
		public ResponseEntity<Blog> deleteBlog(@PathVariable("id") long id)
		{
			blog = blogDAO.getBlog(id);
			System.out.println("NAME "+blog.getName());
			blogDAO.delete(blog);
			blog = new Blog();
			blog.setErrorCode("200");
			blog.setErrorMsg("Success....");
			System.out.println(" deleted");
			return new ResponseEntity<Blog> (blog,HttpStatus.OK);
		}

		@GetMapping("/getAllBlog")
		public ResponseEntity<List<Blog>> getAllBlog()
		{
			List<Blog> blogs= blogDAO.Bloglist();
			if(blogs.isEmpty())
					{
				 blog.setErrorCode("100");
					blog.setErrorMsg("No blogs are available");
					blogs.add(blog);
					return new ResponseEntity< List<Blog>>(blogs,HttpStatus.OK);
					}
			 blog.setErrorCode("200");
				blog.setErrorMsg("Successfully fetched the blog");

			return new ResponseEntity< List<Blog>>(blogs,HttpStatus.OK);
		}
	}


