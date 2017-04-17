app.factory('UserService' ,function($http,$q,$rootScope){
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
		authenticate: function(user)
		{
			console.log("Entering Function Validate User")
			return $http.post(BASE_URL + "ValidateUser", user)
			.then(
					function(response)
					{
						if(response.data.errorMessage == "Success")
							{
								$rootScope.currentUser = 
									{
										    id: response.data.id,
									        name: response.data.name,
									        email: response.data.email,
									        date_of_birth: response.data.date_of_birth,
									        gender: response.data.gender,
									        status: response.data.status,
									        role: response.data.role,
									        is_online: response.data. is_online  
									};
							}
						return response.data;
					},
					function(errResponse)
					{
						$rootScope.userLoggedIn = false;
						console.error(errResponse.status);
						console.error("Error while validating");
						return $q.reject(errResponse);
					});
		},
		
		logout: function()
		{
			console.log("Entering Logout")
			return $http.get(BASE_URL + "logout")
			.then
			(
				function(response)
				{
					return response.data;
				},
				function (errResponse)
				{
					console.log("Error Logging out");
					return $q.reject(errResponse);
				}
			);
		},
		
		friendRequest:function(id){
			console.log('service--friendRequest '+id);
			console.log(BASE_URL+ "addFriend-"+id)
			return $http.get(BASE_URL+ "addFriend-"+id);
		},
		
		
		
		getAllUsers:function(){
			console.log('entering getAllUsers in user service')
			return $http.get(BASE_URL +"getAllUsers/")
		}
		
		
		
		
		
	}
		
});