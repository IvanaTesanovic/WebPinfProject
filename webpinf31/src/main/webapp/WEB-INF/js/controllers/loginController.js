app.controller("LoginController", function($scope, $http, $location, LoginService) {
	
	$scope.login = "sonja";
	
	$scope.submitUser = function() {
		
		var korisnickoIme = $scope.korisnickoIme;
		var lozinka = $scope.lozinka;
		
		LoginService.submitUser(korisnickoIme, lozinka);
	};
	
});