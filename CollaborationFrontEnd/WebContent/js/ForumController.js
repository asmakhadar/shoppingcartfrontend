app.controller('ForumController', function($scope,$location,ForumService){
	
	console.log("Entered to Forum Controller..");
	
		 $scope.forums;

	   $scope.forum={id:'',name:'',description:'',userID:'',dateTime:'',status:'',}
		
	   $scope.msg;

	   $scope.addForum=function()
	   {
		   console.log('entering function save in forum controller')
		   ForumService.addForum($scope.forum)
		   .then(
			function(response)	{
				console.log('adding success')
				$location.path("/home");
				},
				function(errResponse){
					console.log('adding failed' +errResponse.status)
					console.log(errResponse.data)
					
					$scope.errorMessage="adding failed..."
					$location.path("/forum")
					});
		      
	   }
		
	   function getAllForum(){
	   console.log('entering get all forum')
	   ForumService.getAllForum()
		   .then(function(response){
			   console.log(response.status)
		   console.log(response.data)
		   $scope.forums=response.data
	   }
	   )
}
getAllForum()

	})
	 
