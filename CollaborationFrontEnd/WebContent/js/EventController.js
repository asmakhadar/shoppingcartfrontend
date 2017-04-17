app.controller('EventController', function($scope,$location,EventService){
	
	console.log("Entered to Event Controller..");
		
	   $scope.events;

	   $scope.event={id:'',name:'',date_time:'',location:'',}
		
	   $scope.msg;

	   $scope.registerEvent=function()
	   {
		   console.log('entering function save in event controller')
		   EventService.addEvent($scope.event)
		   .then(
			function(response)	{
				console.log('adding success')
				$location.path("/home");
				},
				function(errResponse){
					console.log('adding failed' +errResponse.status)
					console.log(errResponse.data)
					
					$scope.errorMessage="adding failed..."
					$location.path("/event")
					});
		      
	   }
		
	   function getAllEvent(){
	   console.log('entering get all event')
	   EventService.getAllEvent()
		   .then(function(response){
			   console.log(response.status)
		   console.log(response.data)
		   $scope.events=response.data
	   }
	   )
   }
   getAllEvent()
  
	})
	 