package com.niit.collaboration.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.model.Friend;

@SuppressWarnings("deprecation")
@Repository("friendDAO")
@EnableTransactionManagement
public class FriendDAOImpl implements FriendDAO
{
Logger log = LoggerFactory.getLogger(FriendDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	public FriendDAOImpl(SessionFactory sessionFactory)
	{
		try{
			this.sessionFactory=sessionFactory;
		}catch(Exception e){
			log.error("Unable to connect to database");
			e.printStackTrace();
		}
	}

	@Transactional
	public boolean save(Friend friend)
	{
		try{
			friend.setId(getMaxId()+1);
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}catch (HibernateException e){
		e.printStackTrace();
		return false;
		}
	}

	@Transactional
	public boolean update(Friend friend)
	{
		try {
			log.debug("starting of the method update");
			log.debug("userID:" +friend.getUserID() + "Friend id :"+ friend.getFriendID());
			sessionFactory.getCurrentSession().update(friend);
			log.debug("Successfully updated");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("unable to update the status");
			return false;
		}
	}

	@Transactional
	public Friend get(String userID, String friendID) 
	{
		try
		{
			String sql  = "FROM Friend WHERE userID= '"+userID+"' and friendID = '"+friendID+"'";
			@SuppressWarnings("rawtypes")
			Query query = sessionFactory.getCurrentSession().createQuery(sql);
			List<Friend> list = (List<Friend>) query.list();
			System.out.println("This - "+query.list());
				if(query.list().isEmpty())
				{
					String sql2  = "FROM Friend WHERE friendID= '"+userID+"' and userID = '"+friendID+"'";
					@SuppressWarnings("rawtypes")
					Query query2 = sessionFactory.getCurrentSession().createQuery(sql2);
					list = (List<Friend>) query2.list();
					if(!list.isEmpty())
					{	
						log.info("Friend Column is not available......");
						return list.get(0);
					}
					return null;
				}
			log.info("Friend column found");
			return list.get(0);
		}	
		catch(Exception e)
		{
			log.error("Friend Column is not available.");
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	private long getMaxId()
	{
		log.info("->->starting of the method getMaxId");
		String hql="select max(id) from Friend";
		@SuppressWarnings("rawtypes")
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		Long maxID;
		try{
			maxID= (Long) query.uniqueResult();
			if(maxID==null)
			{
				maxID=10000L;
			}
		}catch(Exception e)
		{
			log.error("Error getting Max ID");
			e.printStackTrace();
			return 10000L;
		}
		log.info("max id :"+ maxID);
		return maxID;
		}
	

	@Transactional
	public void delete(String userID, String friendID)
	{
		Friend friend = new Friend();
		friend.setFriendID(friendID);
		friend.setUserID(userID);
		sessionFactory.getCurrentSession().delete(friend);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<String> getMyFriendlist(String userID)
	{
		String hql1 = "select friendID from Friend where userID ='" +userID + "'  and status ='A' ";
		String hql2 = "select userID from Friend where friendID ='" +userID + "'  and status ='A' ";
		log.debug("getMyFriends hql1: "+hql1);
		log.debug("getMyFriends hql2: "+hql2);
		
		List<String>list1=sessionFactory.getCurrentSession().createQuery(hql1).list();
	    List<String>list2=sessionFactory.getCurrentSession().createQuery(hql2).list();
	    list1.addAll(list2);
	    return list1;
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public List<Friend> getMyFriendRequests(String userID)
	{
		String hql = "select userID from Friend where friendID =" + "'" + userID + "' and status = '" + "N'";
		log.debug(hql);
		Query query= sessionFactory.getCurrentSession().createQuery(hql);
	    List<Friend>list=(List<Friend>)query.list();
	    return list;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Friend> getRequestsSendByMe(String userID)
	{
		String hql = "select friendID from Friend where userID =" + "'" + userID + "' and status = 'N'";
		log.debug(hql);
		return sessionFactory.getCurrentSession().createQuery(hql).list(); 
	}

}
	