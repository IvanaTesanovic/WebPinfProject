app.controller("LoginController", function($scope, $http, $location, LoginService) {
	
	$scope.login = "Dobrodosli. Molimo Vas da se ulogujete da biste nastavili.";
	
	$scope.submitUser = function() {
		
		var korisnickoIme = $scope.korisnickoIme;
		var lozinka = $scope.lozinka;
		
		LoginService.submitUser(korisnickoIme, lozinka);
	};
	
});