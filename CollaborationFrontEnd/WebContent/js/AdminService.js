app.factory('AdminService' ,function($http,$q)
{
	console.log('entering AdminService')
	var BASE_URL = "http://localhost:8081/CollaborationController/"
	return {
		
	updateBlog : function(blog)
	{
		console.log("Updating Blog to "+blog.status)
		return $http.post(BASE_URL + "updateBlog", blog)
		.then
		(
			function(response)
			{
				console.log("Updated Blog - Admin")
			}
		)
	},
	
	updateUser : function(user)
	{
		console.log("Updating User to "+user.status)
		return $http.post(BASE_URL + "updateUser_Detail", user)
		.then
		(
			function(response)
			{
				console.log("Updated User - Admin")	
	          }
			)
	},
	
	updateForum : function(forum)
	{
		console.log("Updating Forum to "+forum.status)
		return $http.post(BASE_URL + "updateForum", forum)
		.then
		(
			function(response)
			{
				console.log("Updated Forum - Admin")	
	          }
			)
	},
	
	updateJob : function(job)
	{
		console.log("Updating Job to "+job.status)
		return $http.post(BASE_URL + "updateJob", job)
		.then
		(
			function(response)
			{
				console.log("Updated Job - Admin")	
	          }
			)
	},
	
	updateEvent : function(event)
	{
		console.log("Updating Event to "+event.status)
		return $http.post(BASE_URL + "updateEvent", event)
		.then
		(
			function(response)
			{
				console.log("Updated Event - Admin")	
	          }
			)
	}
}
}
)