app.controller("HomePageController", function($scope, HomePageService) {
	
	$scope.rezim = "Trenutno nije odabran nijedan rezim.";
	$scope.table = {};
	$scope.nameTable = "";
	$scope.kolone = {};

	$scope.izvrsiAkciju = function() {
		var rez = $scope.rezim.toLowerCase();
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
		});
	};
	
	$scope.getValue = function(obj, kol) {
		return obj[kol];
	};
	
	$scope.koloneZaPrikaz = function() {
		$scope.noveKolone = angular.copy($scope.kolone);
		angular.forEach($scope.noveKolone, function(value, key) {
			console.log(value);
	         if(value.naziv == "id")
	        	 $scope.noveKolone.splice(0, 1);
	         });
	};
	
	$scope.promeniRezim = function(rez) {
		if(rez == "nema") {
			$scope.rezim = "Trenutno nije odabran nijedan rezim.";
//			angular.element(document.getElementById('izmena'))[0].disabled = true;
//			angular.element(document.getElementById('dodavanje'))[0].disabled = true;
//			angular.element(document.getElementById('pretraga'))[0].disabled = true;
		}
		else {
			$scope.rezim = rez.toUpperCase();
			$scope.noveKolone = angular.copy($scope.kolone);
			angular.forEach($scope.noveKolone, function(value, key) {
				console.log(value);
		         if(value.naziv == "id")
		        	 $scope.noveKolone.splice(0, 1);
		         });
		}
	};
	
	$scope.deleteRow = function(tIndex) {
		HomePageService.deleteRow(tIndex);
//		openTable(nameTable);
		$scope.table.splice(tIndex - 1, 1);
	};
	
});