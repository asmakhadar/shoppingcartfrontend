app.factory('BlogService' ,function($http,$q){
	console.log('entering BlogService')
	var BASE_URL = "http://localhost:8081/CollaborationController/"
		
		return{
		registerBlog: function(blog){
			return $http.post(BASE_URL+'addBlog/',blog)
			.then(function(response){
				return response.data;
				},
			function(errResponse)	{
					console.error('Error while creating blog');
					//return errResponse.data;
					return $q.reject(errResponse);
				}
				);
		},
		
		

		
		getAllBlog:function(){
			console.log('entering getAllBlog in blog service')
		return $http.get(BASE_URL +"getAllBlog")
	}
		
		
	
	}
		
});


