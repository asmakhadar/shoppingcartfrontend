app.factory('UserService' ,function($http,$q){
	console.log('entering UserService')
	var BASE_URL = "http://localhost:8081/CollaborationController/"
		
		return{
		registerUser: function(user){
			return $http.post(BASE_URL+'addUser/',user)
			.then(function(response){
				return response.data;
				},
			function(errResponse)	{
					console.error('Error while creating user');
					//return errResponse.data;
					return $q.reject(errResponse);
				}
				);
			
		},
		
		
		
		getAllUsers:function(){
			console.log('entering getAllusers in user service')
			return $http.get(BASE_URL +"getAllUsers/")
		}
		
		
		
		
		
	}
		
});