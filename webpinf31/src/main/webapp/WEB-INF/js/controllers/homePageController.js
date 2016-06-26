app.controller("HomePageController", function($scope, HomePageService) {
	
	$scope.rezim = "Trenutno nema rezima";
	$scope.table = {};
	$scope.nameTable = "";

	$scope.izvrsiAkciju = function() {
		var rez = $scope.rezim;
		HomePageService.izvrsiAkciju(rez);
	};
	
	$scope.openTable = function(tableName) {
		$scope.nameTable = tableName;
		HomePageService.openTable(tableName, function(data) {
			if(angular.isObject(data))
				$scope.table = data;
		});
	};
	
	$scope.deleteRow = function(tIndex) {
		HomePageService.deleteRow(tIndex);
//		openTable(nameTable);
		$scope.table.splice(tIndex - 1, 1);
	};
	
});