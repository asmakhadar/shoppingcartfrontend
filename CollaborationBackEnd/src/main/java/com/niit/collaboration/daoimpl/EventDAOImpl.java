package com.niit.collaboration.daoimpl;

	import java.util.List;
	import org.hibernate.Query;
	import org.hibernate.SessionFactory;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
    import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.EnableTransactionManagement;
	import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.dao.EventDAO;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.Event;

    



	@SuppressWarnings("deprecation")
	@Repository("eventDAO")
	@EnableTransactionManagement
	public class EventDAOImpl implements EventDAO
	{
		Logger log = LoggerFactory.getLogger(EventDAOImpl.class);
		
	@Autowired
	SessionFactory sessionFactory;

	public EventDAOImpl(SessionFactory sessionFactory)
	{
		try{
			this.sessionFactory=sessionFactory;
		}catch(Exception e){
			log.error("Unable to connect to database");
			e.printStackTrace();
		}
	}
	
	@Transactional
		public boolean add(Event event) 
	{
			sessionFactory.getCurrentSession().save(event);
			return false;
		}

		@Transactional
		public boolean delete(Event event) 
		{
			
			sessionFactory.getCurrentSession().delete(event);
			return true;
		}

		@Transactional
		public Event getEvent(long id) 
		{
			return (Event) sessionFactory.getCurrentSession().get(Event.class, id);
			
		}

		@Transactional
		@SuppressWarnings("unchecked")
		public List<Event> Eventlist() {
			log.debug("->->Starting of the method list");
			 String hql="from Event";
			 @SuppressWarnings("rawtypes")
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			 return query.list();
		}

		@Transactional
		public void update(Event event) 
		{
			sessionFactory.getCurrentSession().update(event);			
		}


}


