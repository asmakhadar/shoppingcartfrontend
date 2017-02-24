var app=angular.module('myApp',['ngRoute']);   //angular.module for routing

app.config(function($routeProvider)
{
	
	$routeProvider
	
	.when('/',{
		templateUrl : 'view/home.html'
	 })
	
	.when('/friend',{
		templateUrl : 'view/friend.html'
	 })
	 
	.when('/job',{
		templateUrl : 'view/job.html',
		controller : 'JobController'
	 })
	 
	 .when('/forum',{
		templateUrl : 'view/forum.html',
		controller : 'ForumController'
	 })
	 
	 .when('/register',{
		 templateUrl: 'view/register.html',
			 controller : 'UserController'
	 })
	 
	 .when('/listUser',{
		 templateUrl: 'view/listUser.html',
		 controller : 'UserController'
	 })
	 
	  .when('/blog',{
		 templateUrl: 'view/blog.html',
		 controller : 'BlogController'
	 })
	 
	 .when('/blogList',{
		 templateUrl: 'view/blogList.html',
		 controller : 'BlogController'
	 })
	 
	 .when('/jobList',{
		 templateUrl: 'view/jobList.html',
		 controller : 'JobController'
	 })
	 
	 .when('/forumList',{
		templateUrl : 'view/forumList.html',
		controller : 'ForumController'
	 })
	 .otherwise({redirectTo:'/'});
	
	});