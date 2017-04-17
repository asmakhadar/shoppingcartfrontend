var app=angular.module('myApp',['ngRoute','ngCookies']);   //angular.module for routing

app.config(function($routeProvider)
{
	
	$routeProvider
	
	.when('/',{
		templateUrl : 'view/home.html',
			controller : 'HomeController'
	 })
	
	 .when('/admin',{
		templateUrl : 'view/admin.html',
			controller : 'AdminController'
	 })
	 
	  .when('/manageBlog',{
		templateUrl : 'view/manageBlog.html',
			controller : 'AdminController'
	 })
	 
	 /*.when('/viewBlog',{
		templateUrl : 'view/viewBlog.html',
			controller : 'AdminController'
	 })
	 
	 .when('/postBlog',{
		templateUrl : 'view/postBlog.html',
			controller : 'BlogController'
	 })*/
	 
	  .when('/manageEvent',{
		templateUrl : 'view/manageEvent.html',
			controller : 'AdminController'
	 })
	 
	  /*.when('/viewEvent',{
		templateUrl : 'view/viewEvent.html',
			controller : 'AdminController'
	 })
	 
	 .when('/postEvent',{
		templateUrl : 'view/postEvent.html',
			controller : 'EventController'
	 })*/
	 
	  .when('/manageJob',{
		templateUrl : 'view/manageJob.html',
			controller : 'AdminController'
	 })
	 
	/*  .when('/viewJob',{
		templateUrl : 'view/viewJob.html',
			controller : 'AdminController'
	 })*/
	 
	 .when('/postJob',{
		templateUrl : 'view/postJob.html',
			controller : 'JobController'
	 })
	 
	  .when('/manageForum',{
		templateUrl : 'view/manageForum.html',
			controller : 'AdminController'
	 })
	 
	/*  .when('/viewForum',{
		templateUrl : 'view/viewForum.html',
			controller : 'AdminController'
	 })
	 
	 .when('/postForum',{
		templateUrl : 'view/postForum.html',
			controller : 'ForumController'
	 })*/
	 
	  .when('/manageUser',{
		templateUrl : 'view/manageUser.html',
			controller : 'AdminController'
	 })
	 
	 /*  .when('/viewUser',{
		templateUrl : 'view/viewUser.html',
			controller : 'AdminController'
	 })*/
	 
	 .when('/postUser',{
		templateUrl : 'view/postUser.html',
			controller : 'UserController'
	 })
	 
	 .when('/fileUpload',{
		templateUrl : 'view/fileUpload.html'
	 })
	 
	.when('/friend',{
		templateUrl : 'view/friend.html',
			controller : 'FriendController'
	 })
	 
	 .when('/pendingRequest',{
		templateUrl : 'view/pendingRequest.html',
			controller : 'FriendController'
	 })
	 
	 .when('/unFriend',{
		templateUrl : 'view/unFriend.html',
			controller : 'FriendController'
	 })
	
	  .when('/cancelSentRequest',{
		templateUrl : 'view/cancelSentRequest.html',
			controller : 'FriendController'
	 })
	 
	.when('/job',{
		templateUrl : 'view/job.html',
		controller : 'JobController'
	 })
	 
	 .when('/chat',{
		templateUrl : 'view/chat.html',
		controller : 'ChatCtrl'
	 })
	 
	 
	 .when('/forum',{
		templateUrl : 'view/forum.html',
		controller : 'ForumController'
	 })
	 
	
	 
	 .when('/register',{
		 templateUrl: 'view/login.html',
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
	  .when('/event',{
		 templateUrl: 'view/event.html',
		 controller : 'EventController'
	 })
	 
	 .when('/eventList',{
		templateUrl : 'view/eventList.html',
		controller : 'EventController'
	 })
	 
	  .when('/friendList',{
		templateUrl : 'view/friendList.html',
		controller : 'FriendController'
	 })
	
	 
	  .when('/login',{
		templateUrl : 'view/login.html',
		controller : 'UserController'
	 })
	 
	  .when('/logout',{
		templateUrl : 'view/login.html',
		controller : 'UserController'
	 })
	 
	  .when('/profile',{
		templateUrl : 'view/profile.html',
	 })
	 
	 .otherwise({redirectTo:'/'});
	
	});

app.run( function ($rootScope, $location, $cookieStore, $http) 
		{
			 $rootScope.$on('$locationChangeStart', function (event, next, current) 
			 {
				 console.log("$locationChangeStart")
				    
				 var userPages = ['/profile', '/friendList','/blogList','/jobList','/eventList','/forumList','/blog','/forum','/friend','/friendList','/listUser','/pendingRequest','/cancelSentRequest'];
				 var adminPages = ['/admin','/manageBlog','/manageEvent','/mangeJob','/manageForum','/manageUser','/job','/event'];
				 
				 var currentPage = $location.path();
				 
				 var isUserPage = $.inArray(currentPage, userPages);
				 var isAdminPage = $.inArray(currentPage, adminPages);
				 
				 var isLoggedIn = $rootScope.currentUser.id;
			        
			     console.log("isLoggedIn:" +isLoggedIn)
			     console.log("isUserPage:" +isUserPage)
			     console.log("isAdminPage:" +isAdminPage)
			        
			        if(!isLoggedIn)
			        	{
			        	
			        		if(isUserPage!=-1 || isAdminPage!=-1)  
			        	 	{
				        	  console.log("Navigating to login page:")
				        	  alert("You need to Login first!")
				        	  $location.path('/login');
				         	}
			        	}
			        
					 else //logged in
			        	{
			        	
						 var role = $rootScope.currentUser.role;
						 if(isAdminPage!=-1 && role!='admin' )
							 {
							  alert("You cannot view this page as a " + role )
							  $location.path('/');
							 }
			        	}
			 });
			 
	 // keep user logged in after page refresh
   $rootScope.currentUser = $cookieStore.get('currentUser') || {};
   if ($rootScope.currentUser) {
       $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.currentUser; 
   }

});

