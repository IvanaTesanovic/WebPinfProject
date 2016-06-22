app.controller("DefaultController", function($scope, $http, HomePageService) {
	
	$scope.drzave = "bla";
	
	$scope.init = function() {
		$scope.drzave = "truc";
	}
	
	$scope.init();
	
});