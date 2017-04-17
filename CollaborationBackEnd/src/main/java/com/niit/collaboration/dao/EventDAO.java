package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Event;

public interface EventDAO {
	  public boolean add(Event event);
		
		public boolean delete(Event event);
		
		public Event getEvent(long id);
		
		public List<Event> Eventlist();

		public void update(Event event);
}
