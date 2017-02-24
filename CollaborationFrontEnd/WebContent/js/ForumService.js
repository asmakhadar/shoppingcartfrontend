app.factory('ForumService' ,function($http,$q){
	console.log('entering ForumService')
	var BASE_URL = "http://localhost:8081/CollaborationController/"
		
		return{
		addForum: function(forum){
			return $http.post(BASE_URL+'addForum/',forum)
			.then(function(response){
				return response.data;
				},
			function(errResponse)	{
					console.error('Error while creating forum');
					//return errResponse.data;
					return $q.reject(errResponse);
				}
				);
			
		},
		
		
		
		getAllForum:function(){
			console.log('entering getAllForum in forum service')
		return $http.get(BASE_URL +"getAllForum")
	}
		
		
	}
		
});