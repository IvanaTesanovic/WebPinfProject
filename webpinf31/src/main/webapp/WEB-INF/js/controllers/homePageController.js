app.controller("HomePageController", function($scope, HomePageService) {
	
	$scope.rezim = "Trenutno nije odabran nijedan rezim.";
	$scope.table = {};
	$scope.nameTable = "";
	$scope.kolone = {};
	
	$scope.objIzm = {};
	$scope.valIzm = {};

	$scope.izvrsiAkciju = function() {
		var rez = $scope.rezim.toLowerCase();
		var nt = $scope.nameTable;
		var data = {};
		var dataIzm = {};
		var inputs = document.getElementsByTagName('input');
		
		for(var i = 0; i < inputs.length; i++) {
			var id = inputs[i].getAttribute('id');
			var klasa = inputs[i].getAttribute('class');
			if(klasa == 'izm') {
				var val = inputs[i].value;
				dataIzm[id] = val;
			}
			else if (klasa == 'dp'){
				var val = inputs[i].value;
		        data[id] = val;
			}
		}
		if(rez == 'izmena')
			HomePageService.izvrsiAkciju(rez, nt, dataIzm);
		else
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
		         if(value.naziv == "id")
		        	 $scope.noveKolone.splice(0, 1);
		         });
		}
	};
	
	$scope.deleteRow = function(tIndex) {
		HomePageService.deleteRow($scope.nameTable, tIndex);
		$scope.table.splice(tIndex - 1, 1);

	};
	
	$scope.izmeni = function(id) {
		$scope.rezim = 'izmena';
		$scope.promeniRezim($scope.rezim);
		HomePageService.findById(id, $scope.nameTable, function(data) {
			if(angular.isObject(data))
				$scope.objIzm = data;
		});
		//treba da vratim onu torku u tabeli ciji je id ovaj prosledjeni
	};
	
	$scope.getIzmValue = function(kol) {
		var obj = $scope.objIzm;
		return obj[kol];
	};
	
});

