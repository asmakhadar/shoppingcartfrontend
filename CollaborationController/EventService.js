app.factory('EventService' ,function($http,$q){
	console.log('entering EventService')
	var BASE_URL = "http://localhost:8081/CollaborationController/"
		
		return{
		registerEvent: function(event){
			return $http.post(BASE_URL+'addEvent/',event)
			.then(function(response){
				return response.data;
				},
			function(errResponse)	{
					console.error('Error while creating event');
					//return errResponse.data;
					return $q.reject(errResponse);
				}
				);
			
		},
		
		
		
		getAllEvent:function(){
			console.log('entering getAllEvent in event service')
		return $http.get(BASE_URL +"getAllEvent")
	}
		
		
		
		
		
	}
		
});