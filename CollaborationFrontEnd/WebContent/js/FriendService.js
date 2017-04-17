app.factory('FriendService' ,function($http,$q){
	console.log('entering FriendService')
	var BASE_URL = "http://localhost:8081/CollaborationController/"
		
		return{
		addFriend: function(friendID){
			return $http.post(BASE_URL+"addFriend-",friendID)
			.then(function(response){
				return response.data;
				},
			function(errResponse)	{
					console.error('Error while creating friend');
					//return errResponse.data;
					return $q.reject(errResponse);
				}
				);
			
		},
		
		pendingRequest:function(){
			console.log('PENDING REQUEST')
			return $http.get(BASE_URL +"getMyFriendRequests/")
		},
		
		acceptFriend:function(friendID){
			console.log('ACCEPT FRIEND '+friendID)
			return $http.get(BASE_URL +"acceptFriend-"+friendID)
		},
		
		rejectFriend:function(friendID){
			console.log('REJECT FRIEND '+friendID)
			return $http.get(BASE_URL +"rejectFriend-"+friendID)
		},
		
		unFriend:function(friendID){
			console.log('UNFRIEND '+friendID)
			return $http.get(BASE_URL +"unFriend-"+friendID)
		},
		
		cancelSentRequest:function(friendID){
			console.log('CANCEL SENT REQUEST '+friendID)
			return $http.get(BASE_URL +"cancelSentRequest-"+friendID)
		},
		
		requestSendByMe:function(){
			console.log('REQUEST SENT MY ME ')
			return $http.get(BASE_URL +"getRequestsSendByMe")
		},
		
		
		
		 getMyFriendlist:function(){
			console.log('entering getMyFriendlist in friend service')
		return $http.get(BASE_URL +"getMyFriendlist")
	}
		
		
	}
		
});