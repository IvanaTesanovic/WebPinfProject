var app = angular.module('WebPinf31',['ngRoute', 'ui.bootstrap'])
	.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
		
		$routeProvider
			.when('/default', {
				templateUrl: 'pages/default.html',
				controller: 'DefaultController'
			})
			.when('/login', {
				templateUrl: 'pages/login.html',
				controller: 'LoginController'
			})
			.when('/homepage', {
				templateUrl: 'pages/homepage.html',
				controller: 'HomePageController'
			})
			.when('/drzave', {
				templateUrl: 'pages/drzave.html',
				controller: 'DrzaveController'
			})
			.when('/drzave/:id', {
				templateUrl: 'pages/drzava.html',
				controller: 'DrzaveController'
			}) 
			.otherwise({
				redirectTo: '/homepage'
			});
		
		$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
		
	}]);