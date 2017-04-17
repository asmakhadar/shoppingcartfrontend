package com.niit.collaboration.daoimpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.dao.FileuploadDAO;
import com.niit.collaboration.model.Fileupload;


@Repository("fileuploadDao")
@EnableTransactionManagement
public class FileuploadDAOImpl implements FileuploadDAO
{
	
		@Autowired
		private SessionFactory sessionFactory;
		public FileuploadDAOImpl(SessionFactory sessionFactory) 
		{
			this.sessionFactory = sessionFactory;
		}

		
		@Transactional
		public void save(Fileupload fileupload)
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(fileupload);
			/*session.flush();
			session.close();*/
		}

		
		@Transactional
		public Fileupload getFile(String username)
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Fileupload where username=?");
			query.setParameter(0, username);
	        Fileupload fileupload=(Fileupload)query.setMaxResults(1).uniqueResult();
			//session.close();
			return fileupload;
		}

	}
