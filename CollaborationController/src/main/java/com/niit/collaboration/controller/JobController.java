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

import com.niit.collaboration.dao.JobDAO;
import com.niit.collaboration.model.Date_Time;
import com.niit.collaboration.model.Job;

    
	@RestController
	public class JobController 
	{
		@Autowired
		Job job;
		
		@Autowired
		JobDAO jobDAO;
		
		@Autowired
		HttpSession httpSession;
		
		@PostMapping("/addJob/")
		public ResponseEntity<Job> createJob(@RequestBody Job job)
		{
			job.setUserID(httpSession.getAttribute("loggedInUserID").toString());
			Date_Time dt = new Date_Time();
			job.setDateTime(dt.getDateTime());
			job.setStatus("P");
			jobDAO.add(job);
			job.setErrorCode("200");
			job.setErrorMsg("Success....");
			
			return new ResponseEntity<Job> (job,HttpStatus.OK) ;
		}
		

		@GetMapping("/deleteJob-{id}")
		public ResponseEntity<Job> deleteJob(@PathVariable("id") long id)
		{
			job = jobDAO.getJob(id);
			System.out.println("EMAIL "+job.getUserID());
			jobDAO.delete(job);
			job = new Job();
			job.setErrorCode("200");
			job.setErrorMsg("Success....");
			System.out.println(" deleted");
			return new ResponseEntity<Job> (job,HttpStatus.OK);
		}

		@GetMapping("/getAllJob")
		public ResponseEntity<List<Job>> getAllJob()
		{
			List<Job> jobs= jobDAO.Joblist();
			
					if(jobs.isEmpty())
					{
				 job.setErrorCode("100");
					job.setErrorMsg("No jobs are available");
					jobs.add(job);
					return new ResponseEntity< List<Job>>(jobs,HttpStatus.OK);
					}
			 job.setErrorCode("200");
				job.setErrorMsg("Successfully fetched the job");

			return new ResponseEntity< List<Job>>(jobs,HttpStatus.OK);
		}
		
		@PostMapping("/updateJob")
		public ResponseEntity<Job> editJob(@RequestBody Job job)
		{
			jobDAO.update(job);
			job.setErrorCode("200");
			job.setErrorMsg("Success....");
			
			return new ResponseEntity<Job> (job,HttpStatus.OK) ;
		}
		
	}

