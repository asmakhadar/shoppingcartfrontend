package com.niit.collaboration.controller;

	import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
	    import org.springframework.http.HttpStatus;
		import org.springframework.http.ResponseEntity;
		import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
		import org.springframework.web.bind.annotation.RequestBody;
		import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.ForumDAO;
import com.niit.collaboration.model.Date_Time;
import com.niit.collaboration.model.Forum;

	   
		@RestController
		public class ForumController 
		{
			@Autowired
			Forum forum;
			
			@Autowired
			ForumDAO forumDAO;
			
			@Autowired
			HttpSession httpSession;
			
			@PostMapping("/addForum/")
			public ResponseEntity<Forum> createForum(@RequestBody Forum forum)
			{
				forum.setUserID(httpSession.getAttribute("loggedInUserID").toString());
				Date_Time dt = new Date_Time();
				forum.setDateTime(dt.getDateTime());
				forum.setStatus("P");
				forumDAO.add(forum);
				forum.setErrorCode("200");
				forum.setErrorMsg("Success....");
				
				return new ResponseEntity<Forum> (forum,HttpStatus.OK) ;
			}
			

			@GetMapping("/deleteForum-{id}")
			public ResponseEntity<Forum> deleteForum(@PathVariable("id") long id)
			{
				forum = forumDAO.getForum(id);
				System.out.println("NAME "+forum.getName());
				forumDAO.delete(forum);
				forum = new Forum();
				forum.setErrorCode("200");
				forum.setErrorMsg("Success....");
				System.out.println(" deleted");
				return new ResponseEntity<Forum> (forum,HttpStatus.OK);
			}

			@GetMapping("/getAllForum")
			public ResponseEntity<List<Forum>> getAllForum()
			{
				List<Forum> forums= forumDAO.Forumlist();
				if(forums.isEmpty())
						{
					forum.setErrorCode("100");
					forum.setErrorMsg("No forums are available");
					forums.add(forum);
						return new ResponseEntity< List<Forum>>(forums,HttpStatus.OK);
						}
				forum.setErrorCode("200");
				forum.setErrorMsg("Successfully fetched the forum");

				return new ResponseEntity< List<Forum>>(forums,HttpStatus.OK);
			}
			@PostMapping("/updateForum")
			public ResponseEntity<Forum> editForum(@RequestBody Forum forum)
			{
				forumDAO.update(forum);
				forum.setErrorCode("200");
				forum.setErrorMsg("Success....");
				
				return new ResponseEntity<Forum> (forum,HttpStatus.OK) ;
			}
}
