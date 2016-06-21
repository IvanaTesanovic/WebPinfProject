app.controller("DrzaveController", function($scope, $http, HomePageService) {
	
	$scope.drzave = {};
	
	$scope.init = function() {
		$scope.getDrzave();
	}
	
	$scope.init();
	
});