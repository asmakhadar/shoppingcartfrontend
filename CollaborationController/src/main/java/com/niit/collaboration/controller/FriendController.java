package com.niit.collaboration.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.dao.User_DetailDAO;
import com.niit.collaboration.model.Friend;


@RestController
public class FriendController
{
	
	Logger log = LoggerFactory.getLogger(FriendController.class);  
	
	@Autowired
	FriendDAO friendDAO;

	@Autowired
	Friend friend;
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	User_DetailDAO user_DetailDAO;

	@RequestMapping(value = "/getMyFriendlist", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getMyFriends() {
		log.debug("->->->->calling method getMyFriends");
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		List<String> myFriends = new ArrayList<String>();
		if(loggedInUserID == null)
		{
			friend.setErrorCode("404");
			friend.setErrorMsg("Please login to know your friends");
			return null;
		}
		log.debug("getting friends of : " + loggedInUserID);
		 myFriends = friendDAO.getMyFriendlist(loggedInUserID);

		if (myFriends.isEmpty()) {
			log.debug("Friends does not exist for the user : " + loggedInUserID);
			friend.setErrorCode("404");
			friend.setErrorMsg("You does not have any friends");
			return null;
		}
		log.debug("Send the friend list ");
		return new ResponseEntity<List<String>>(myFriends, HttpStatus.OK);
	}

	@RequestMapping(value = "/addFriend-{id}", method = RequestMethod.GET)
	public ResponseEntity<Friend> sendFriendRequest(@PathVariable("id") String friendID) {
		log.debug("->->->->calling method sendFriendRequest");
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		friend.setUserID(loggedInUserID);
		friend.setFriendID(friendID);
		friend.setStatus("N");               // N - New, R->Rejected, A->Accepted
		if(isUserExist(friendID)==false)
		{
			friend.setErrorCode("404");
			friend.setErrorMsg("No user exist with the id :" + friendID);
		}
		
		else
		if (friendDAO.get(loggedInUserID, friendID) != null) {
			friend.setErrorCode("404");
			friend.setErrorMsg("You have already sent the friend request to " + friendID);
			friend = friendDAO.get(loggedInUserID, friendID);
			friend.setStatus("N");
			friendDAO.update(friend);

		} else {
			friendDAO.save(friend);

			friend.setErrorCode("200");
			friend.setErrorMsg("Friend request sent successfully.." + friendID);
		}

		return new ResponseEntity<Friend>(friend, HttpStatus.OK);

	}
	
	
	
	private boolean isUserExist(String id)
	{
		if(user_DetailDAO.getUser(id)==null)
			return false;
		else
			return true;
	}
	

	@GetMapping(value = "/unFriend-{id}")
	public ResponseEntity<Friend> unFriend(@PathVariable("id") String friendID) {
		log.debug("->->->->calling method unFriend");
		String userID = httpSession.getAttribute("loggedInUserID").toString();
		friend = friendDAO.get(userID, friendID);
		friend.setStatus("U");
		friendDAO.update(friend);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);

	}

	@GetMapping(value = "/rejectFriend-{id}")
	public ResponseEntity<Friend> rejectFriendRequest(@PathVariable("id") String friendID) {
		log.debug("->->->->calling method rejectFriendRequest");
		String userID = httpSession.getAttribute("loggedInUserID").toString();
		friend = friendDAO.get(userID, friendID);
		friend.setStatus("R");
		friendDAO.update(friend);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);

	}

	
	@GetMapping(value="/acceptFriend-{id}")
	public ResponseEntity<Friend> acceptFriendRequest(@PathVariable("id") String friendID) {
		log.debug("->->->->calling method acceptFriendRequest");
		String userID = httpSession.getAttribute("loggedInUserID").toString();
		System.out.println("UserID is : "+userID);
		Friend friends = new Friend();
		
		friends = friendDAO.get(userID, friendID);
		System.out.println(friends);
		friends.setStatus("A");
		friendDAO.update(friends);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);
	}

	@GetMapping(value="/cancelSentRequest-{id}")
	public ResponseEntity<Friend> cancelSentRequest(@PathVariable("id") String friendID) {
		log.debug("->->->->calling method cancelSentRequest");
		String userID = httpSession.getAttribute("loggedInUserID").toString();
		friend = friendDAO.get(userID, friendID);
		friend.setStatus("R");
		friendDAO.update(friend);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/getMyFriendRequests/", method = RequestMethod.GET)
	public ResponseEntity<List<Friend>> getMyFriendRequests() {
		log.debug("->->->->calling method getMyFriendRequests");
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		List<Friend> myFriendRequests = friendDAO.getMyFriendRequests(loggedInUserID);
		return new ResponseEntity<List<Friend>>(myFriendRequests, HttpStatus.OK);

	}
	
	
	@RequestMapping("/getRequestsSendByMe")
	public ResponseEntity<List<Friend>>  getRequestsSendByMe()
	{
		log.debug("->->->->calling method getRequestsSendByMe");
		
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		List<Friend> requestSendByMe = friendDAO.getRequestsSendByMe(loggedInUserID);
		
		log.debug("->->->->Ending method getRequestsSendByMe");
		
		return new ResponseEntity<List<Friend>>(requestSendByMe, HttpStatus.OK);
		
	}
	
	

}
