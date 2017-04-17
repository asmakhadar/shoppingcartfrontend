app.controller('AdminController', function($scope,BlogService,UserService,ForumService,EventService,JobService,AdminService){
	
	console.log("Entered to Admin Page..");
	$scope.msg="msg from admin Page.."
	
		 function getAllBlog(){
		   console.log('entering get all blog')
		   BlogService.getAllBlog()
			   .then(function(response){
				   console.log(response.status)
			   console.log(response.data)
			   $scope.blogs=response.data
		   }
		   )
	   }
	   getAllBlog()
	  
},

 function getAllEvent(){
	   console.log('entering get all event')
	   EventService.getAllEvent()
		   .then(function(response){
			   console.log(response.status)
		   console.log(response.data)
		   $scope.events=response.data
	   }
	   )
   getAllEvent()
 
   },
   
   function getAllForum(){
	   console.log('entering get all forum')
	   ForumService.getAllForum()
		   .then(function(response){
			   console.log(response.status)
		   console.log(response.data)
		   $scope.forums=response.data
	   }
	   )
getAllForum()

	},
	
	 function getAllUsers(){
		   console.log('entering get all users')
		   UserService.getAllUsers()
		   .then(function(response){
			   console.log(response.status)
			   console.log(response.data)
			   $scope.users=response.data
		   }
		   )
	   getAllUsers()
	   
	   },
	
	  function getAllJob(){
	   console.log('entering get all job')
	   JobService.getAllJob()
		   .then(function(response){
			   console.log(response.status)
		   console.log(response.data)
		   $scope.jobs=response.data
	   }
	   )
getAllJob()
	
});