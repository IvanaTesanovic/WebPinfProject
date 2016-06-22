var app = angular.module('WebPinf31',['ngRoute', 'ui.bootstrap'])
	.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
		$routeProvider
			.when('/', {
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
			.otherwise('/');
	}]);
