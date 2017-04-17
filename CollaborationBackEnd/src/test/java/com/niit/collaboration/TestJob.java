package com.niit.collaboration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.JobDAO;
import com.niit.collaboration.model.Job;



public class TestJob {
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		Job job = (Job) context.getBean("job");
		JobDAO jobDAO = (JobDAO) context.getBean("jobDAO");
		job.setId(8522);
		job.setDateTime("24/02/2017");
		job.setDescription("cfdf");
		job.setQualification("wehgg");
		job.setStatus("sdfg");
		job.setUserID("78");
		job.setTitle("fff");;
	    System.out.println("Add - "+job.getId());
	    jobDAO.add(job);
		
		/*job.setId(12);
	    job.setDateTime("24/02/2017");
		job.setDescription("cfdf");
		job.setQualification("wehgg");
		job.setStatus("sdfg");
		job.setUserID("78");
		job.setTitle("fff");;
		jobDAO.delete(job);*/
		
	    System.out.println("Success");
	}
		
}
