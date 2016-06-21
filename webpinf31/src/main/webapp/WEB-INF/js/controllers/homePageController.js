app.controller("HomePageController", function($scope, $http, HomePageService) {
	
	$scope.drzave = {};
	$scope.banke = {};
	
	/** Load data */
	$scope.getDrzave = function() {
		HomePageService.getDrzave(function(data){
			if(angular.isObject(data)) {
				$scope.drzave = data;
			}
		});
	};
	
	$scope.getBanke = function() {
		HomePageService.getBanke(function(data){
			if(angular.isObject(data)) {
				$scope.banke = data;
			}
		});
	};
	
	$scope.init = function(){
		$scope.getDrzave();
		$scope.getBanke();
	};
	
	$scope.init();
	
});