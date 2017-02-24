app.factory('JobService' ,function($http,$q){
	console.log('entering JobService')
	var BASE_URL = "http://localhost:8081/CollaborationController/"
		
		return{
		addJob: function(job){
			return $http.post(BASE_URL+'addJob/',job)
			.then(function(response){
				return response.data;
				},
			function(errResponse)	{
					console.error('Error while creating job');
					//return errResponse.data;
					return $q.reject(errResponse);
				}
				);
			
		},
		
		
		
		getAllJob:function(){
			console.log('entering getAllJob in job service')
		return $http.get(BASE_URL +"getAllJob")
	}
		
		
	}
		
});