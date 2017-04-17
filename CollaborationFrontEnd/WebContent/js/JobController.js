app.controller('JobController', function($scope,$location,JobService){
	
	console.log("Entered to Job Controller..");
	
		 $scope.jobs;

	   $scope.job={id:'',title:'',description:'',userID:'',dateTime:'',qualification:'',status:'',job_id:'',date1:'',}
		
	   $scope.msg;

	   $scope.addJob=function()
	   {
		   console.log('entering function save in job controller')
		   JobService.addJob($scope.job)
		   .then(
			function(response)	{
				console.log('adding success')
				$location.path("/home");
				},
				function(errResponse){
					console.log('adding failed' +errResponse.status)
					console.log(errResponse.data)
					
					$scope.errorMessage="adding failed..."
					$location.path("/job")
					});
		      
	   }
		
	   function getAllJob(){
	   console.log('entering get all job')
	   JobService.getAllJob()
		   .then(function(response){
			   console.log(response.status)
		   console.log(response.data)
		   $scope.jobs=response.data
	   }
	   )
}
getAllJob()

	})
	 
