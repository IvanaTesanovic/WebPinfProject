app.controller("HomePageController", function($scope, HomePageService) {
	
	$scope.rezim = "Trenutno nije odabran nijedan rezim.";
	$scope.table = {};
	$scope.nameTable = "";
	$scope.kolone = {};
	$scope.koloneCopy = {};

	$scope.izvrsiAkciju = function() {
		var rez = $scope.rezim;
		var nt = $scope.nameTable;
		var data = {};
		var inputs = document.getElementsByTagName('input');
		for(var i = 0; i < inputs.length; i++) {
			var id = inputs[i].getAttribute('id');
            var val = inputs[i].value;
            data[id] = val;
		}
		HomePageService.izvrsiAkciju(rez, nt, data);
	};
	
	$scope.openTable = function(tableName) {
		$scope.nameTable = tableName;
		HomePageService.openTable(tableName, function(data) {
			if(angular.isObject(data))
				$scope.table = data;
		});
		HomePageService.getColumnNames(tableName, function(data) {
			if(angular.isObject(data))
				$scope.kolone = data;
			console.log("kolone:"+ $scope.kolone);
				$scope.koloneCopy = angular.copy($scope.kolone);
		});
	};
	
	$scope.getValue = function(obj, kol) {
		console.log(obj + kol);
		return obj[kol];
	};
	
//	$scope.getColumns = function() {
//		HomePageService.getColumns(function(data) {
//			$scope.kolone = data.data;
//			console.log(data.data);
//		})
//	};
//	
//	$scope.init = function() {
//		$scope.getColumns();
//	}
//	
//	$scope.init();
	
});