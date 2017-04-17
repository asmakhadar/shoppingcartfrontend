package com.niit.collaboration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.EventDAO;
import com.niit.collaboration.model.Event;

public class TestEvent {

	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		Event event = (Event) context.getBean("event");
		EventDAO eventDAO = (EventDAO) context.getBean("eventDAO");
		
		/*event.setName("werrdd1");
		event.setDate_time("24/02/2017");
		event.setLocation("cfdf");
	    System.out.println("Add - "+event.getId());
	    eventDAO.add(event);*/
		
		
		event.setId(31);
		event.setName("asma");
		event.setDate_time(" ");
		event.setLocation("cvvbvb");
		eventDAO.delete(event);
		
	    System.out.println("Success");
	}
		

	
}
