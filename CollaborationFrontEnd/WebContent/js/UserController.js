app.controller('UserController',function($scope,$location,UserService)
{
console.log('entering the user controller')

   $scope.users;

   $scope.user={id:'',name:'',address:'',email:'',password:'',date_of_birth:'',mobile_number:'',status:'',reason:'',role:'',is_online:'',}
	
   $scope.msg;

   $scope.registerUser=function()
   {
	   console.log('entering function save in user controller')
	   UserService.registerUser($scope.user)
	   .then(
		function(response)	{
			console.log('registration success'+ response.status)
			$location.path("/home");
			},
			function(errResponse){
				console.log('registration failed' +errResponse.status)
				console.log(errResponse.data)
				
				$scope.errorMessage="Registration failed..."
				$location.path("/register")
				});
	      
   }
	
   function getAllUsers(){
	   console.log('entering get all users')
	   UserService.getAllUsers()
	   .then(function(response){
		   console.log(response.status)
		   console.log(response.data)
		   $scope.users=response.data
	   }
	   )
   }
   getAllUsers()
   
})