app.controller('BlogController', function($scope,$location,BlogService){
	
	console.log("Entered to Blog Controller..");
		
	   $scope.blogs;

	   $scope.blog={id:'',name:'',userID:'',dateTime:'',status:'',reason:'',description:'',}
		
	   $scope.msg;
	   
	   $scope.registerBlog=function()
	   {
		   console.log('entering function save in blog controller')
		   BlogService.registerBlog($scope.blog)
		   .then(
			function(response)	{
				console.log('adding success')
				$location.path("/home");
				},
				function(errResponse){
					console.log('adding failed' +errResponse.status)
					console.log(errResponse.data)
					
					$scope.errorMessage="adding failed..."
					$location.path("/blog")
					});
		      
	   }
	   
	  
		
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
  
	})
	
	
	