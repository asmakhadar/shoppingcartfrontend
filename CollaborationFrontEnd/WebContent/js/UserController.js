app.controller('UserController',function($scope,$location,UserService,$rootScope,$cookieStore,$http)
{
console.log('entering the user controller')
   var self=this;
   $scope.users;
   $scope.user={id:'',name:'',address:'',email:'',password:'',date_of_birth:'',gender:'',status:'',role:'',phone_number:'',is_online:'',ErrorCode:'',Errormsg:'',skills:'',company:'',address:'',aboutu:''}
   $scope.msg;
   self.registerUser=function()
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
				alert("Regiseration Failed")
				$scope.errorMessage="Registration failed..."
				$location.path("/")
				});
	      
   }
   
   self.authenticate=function(user)
   {
	   console.log("Auhenticate Function");
	   UserService.authenticate(user)
	   .then
	   (
			   function(d)
			   {
				   $scope.user=d;
				   console.log("User ErrorCode - "+$scope.user.errorCode)
				   if($scope.user.status=='R')
					   {
					   alert("Your Registration is Rejected.please contact ADMIN")
					   user.serErrorCode("404");
					   user.setErrormsg("Your Registration is Rejected");
					   }
				   if($scope.user.status=='N')
					   {
					   alert("Your Registration is not Approved..")
					   user.serErrorCode("404");
					   user.setErrormsg("Your Registration is not Approved");
					   }
				   if($scope.user.id==null)
				   {
				   alert("invalid id or password")
				   console.log("invalid id or password");
				   $location.path("/login");
				   }
				   
				   else
					   {
					   console.log("validate Credentials, Navigating to home page +$scope.user.status")
					   $scope.msg="successfully logged in as";
					   alert("logged in succesfully..")
					   $rootScope.currentUser=
						   {
							    id: $scope.user.id,
						        name: $scope.user.name,
						        email: $scope.user.email,
						        date_of_birth: $scope.user.date_of_birth,
						        gender: $scope.user.gender,
						        status: $scope.user.status,
						        role:$scope.user.role,
						        is_online: $scope.user.is_online  
						   };
					   $http.defaults.headers.common["Authorization"]='Basic'+$rootScope.currentUser;
					   $cookieStore.put('currentUser',$rootScope.currentUser)
					   $location.path("/");
					   }
			   },  function(errResponse)
				   {
				   console.error("Error Aunthenticating User");
				   $scope.message="Invalid id or password..";
				   $location.path("/login");
				   }	  
);
   };
   self.login= function()
	{
		console.log("Validating Login "+$scope.user);
		self.authenticate($scope.user);
	};
	
	self.logout= function()
	{
		console.log("Entering Logout Function");
		$rootScope.currentUser = {};
		$cookieStore.remove('currentUser');
		
		console.log("Calling Session Logout");
		UserService.logout()
		alert("you logged out")
		$location.path('/login');
	}

	
	$scope.friendRequest=function(name){
		alert('friendRequest in userController')
		console.log('friendrequest function')
		UserService.friendRequest(name)
		.then(function(response){
			console.log(response.status);
			alert('friend request sent')
			getAllUsers();
			$location.path('/listUser')	
		},
		function(response){
			console.log(response.status);
		}
		)
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