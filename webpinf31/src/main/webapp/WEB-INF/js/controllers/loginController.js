app.controller("LoginController", function($scope, $http, LoginService) {
	
	$scope.string = {};
	
	$scope.getString = function() {
		LoginService.getString(function(data){
			if(angular.isObject(data)) {
				$scope.string = data;
			}
		});
	};
	
	$scope.init = function() {
		$scope.getString();
	};
	
	$scope.init();
	
});