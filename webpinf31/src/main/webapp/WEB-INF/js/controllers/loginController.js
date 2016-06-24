app.controller("LoginController", function($scope, $http, LoginService) {
	
	$scope.retVal = {};
	
	$scope.submitUser = function() {
		
		var korisnickoIme = $scope.korisnickoIme;
		var lozinka = $scope.lozinka;
		
		LoginService.submitUser(korisnickoIme, lozinka, function(response) {
			retVal = reponse;
		});
	};
	
});