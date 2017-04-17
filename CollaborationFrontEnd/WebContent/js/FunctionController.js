app.controller('FunctionController', function($scope,$location,AdminService)
{
	console.log("Admin Controller")
	var self = this;
	
	self.acceptBlog = function(blog)
	{
		console.log("Entering Approve Blog")
		blog.status = 'A'
		AdminService.updateBlog(blog)
		.then(
			function(response)
			{
				console.log("Blog Accepted "+response)
				$location.path("/manageBlog")
			}
		)
	}
	
	self.rejectBlog = function(blog)
	{
		console.log("Entering Reject Blog")
		blog.status = 'R'
		AdminService.updateBlog(blog)
		.then(
			function(response)
			{
				console.log("Blog Rejected "+response)
				$location.path("/manageBlog")
			}
		)
	}
	
	/*self.acceptEvent = function(event)
	{
		console.log("Entering Approve Event")
		event.status = 'A'
		AdminService.updateEvent(event)
		.then(
			function(response)
			{
				console.log("Event Accepted "+response)
				$location.path("/manageEvent")
			}
		)
	}
	
	self.rejectEvent = function(event)
	{
		console.log("Entering Reject Event")
		event.status = 'R'
		AdminService.updateEvent(event)
		.then(
			function(response)
			{
				console.log("Event Rejected "+response)
				$location.path("/manageEvent")
			}
		)
	}
	*/
	self.acceptForum = function(forum)
	{
		console.log("Entering Approve Forum")
		forum.status = 'A'
		AdminService.updateForum(forum)
		.then(
			function(response)
			{
				console.log("Forum Accepted "+response)
				$location.path("/manageForum")
			}
		)
	}
	
	self.rejectForum = function(forum)
	{
		console.log("Entering Reject Forum")
		forum.status = 'R'
		AdminService.updateForum(forum)
		.then(
			function(response)
			{
				console.log("Forum Rejected "+response)
				$location.path("/manageForum")
			}
		)
	}
	/*
	self.acceptJob = function(job)
	{
		console.log("Entering Approve Job")
		job.status = 'A'
		AdminService.updateJob(job)
		.then(
			function(response)
			{
				console.log("Job Accepted "+response)
				$location.path("/manageJob")
			}
		)
	}
	
	self.rejectJob = function(job)
	{
		console.log("Entering Reject Job")
		job.status = 'R'
		AdminService.updateJob(job)
		.then(
			function(response)
			{
				console.log("Job Rejected "+response)
				$location.path("/manageJob")
			}
		)
	}
	*/
	self.acceptUser = function(user)
	{
		console.log("Entering Approve User")
		user.status = 'A'
		AdminService.updateUser(user)
		.then(
			function(response)
			{
				console.log("User Accepted "+response)
				$location.path("/manageUser")
			}
		)
	}
	
	self.rejectUser = function(user)
	{
		console.log("Entering Reject User")
		user.status = 'R'
		AdminService.updateUser(user)
		.then(
			function(response)
			{
				console.log("User Rejected "+response)
				$location.path("/manageUser")
			}
		)
	}
});