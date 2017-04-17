app.controller('FriendController', function($scope,$location,FriendService){
	
	console.log("Entered to Friend Controller..");
	
	   $scope.friends;
	   
	   $scope.sentfriends;
	   

	   $scope.friend={id:'',userID:'',friendID:'',status:''}
		
	   $scope.msg;

	   $scope.addFriend=function()
	   {
		   console.log('entering function save in friend controller')
		   FriendService.addFriend($scope.friendID)
		   .then(
			function(response)	{
				console.log('ADDING SUCCESS')
				$location.path("/home");
				},
				function(errResponse){
					console.log('adding failed' +errResponse.status)
					console.log(errResponse.data)
					
					$scope.errorMessage="adding failed..."
					$location.path("/friend")
					});
		      
	   }
	   
	   $scope.pendingRequest=
		   FriendService.pendingRequest()
		   .then(function(response){
			   console.log('PENDING REQUEST')
			   console.log(response.status);
			   $scope.pendingRequest=response.data
			   console.log($scope.pendingRequest)
//			   alert($scope.pendingRequest);
			    },function(response){
			    	console.log(response.status)
			    })
				  
			    
			    $scope.acceptFriend=function(friendID){
		    FriendService.acceptFriend(friendID)
			   .then
			   (function(response){
			   console.log('FRIEND REQUEST ACCEPTED')
			   console.log(response.status);
			   alert("FRIEND REQUEST ACCEPTED");
			   $location.path("/pendingRequest")
			    },function(errresponse){
			    	console.log(errresponse.data)
			    	$location.path("/pendingRequest")
			    	})
	                }
	   
	   $scope.rejectFriend=function(friendID){
		    FriendService.rejectFriend(friendID)
			   .then
			   (function(response){
			   console.log('REJECT FRIEND')
			   console.log(response.status);
			   alert("FRIEND REQUEST REJECTED");
			   $location.path("/pendingRequest")
			    },function(errresponse){
			    	console.log(errresponse.data)
			    	$location.path("/pendingRequest")
			    	})
	   }
	   
	   $scope.unFriend=function(friendID){
		    FriendService.unFriend(friendID)
			   .then
			   (function(response){
			   console.log('UNFRIEND')
			   console.log(response.status);
			   alert("UNFRIEND");
			   $location.path("/friendList")
			    },function(errresponse){
			    	console.log(errresponse.data)
			    	$location.path("/friendList")
			    	})
	   }
	   $scope.cancelSentRequest=function(friendID){
		    FriendService.cancelSentRequest(friendID)
			   .then
			   (function(response){
			   console.log('FRIEND REQUEST CANCELLED')
			   console.log(response.status);
			   alert("FRIEND REQUEST CANCELLED");
			   $location.path("/cancelSentRequest")
			    },function(errresponse){
			    	console.log(errresponse.data)
			    	$location.path("/cancelSentRequest")
			    	})
	   }
	   
	   function requestSendByMe(){
		   console.log('ENTERING REQUEST SENT BY ME')
		   FriendService.requestSendByMe()
			   .then(function(response){
				   console.log(response.status)
			   console.log(response.data)
			   $scope.sentfriends=response.data
		   }
		   )
	}
	   requestSendByMe()

		
	   function getMyFriendlist(){
	   console.log('ENTERING LIST OF FRIENDS')
	   FriendService.getMyFriendlist()
		   .then(function(response){
			   console.log(response.status)
		   console.log(response.data)
		   $scope.friends=response.data
	   }
	   )
}
	   getMyFriendlist()

	})
	 

	
	