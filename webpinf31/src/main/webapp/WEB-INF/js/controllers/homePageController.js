app.controller("HomePageController", function($scope, HomePageService) {
	
	$scope.rezim = "Trenutno nije odabran nijedan rezim.";
	$scope.table = {};
	$scope.nameTable = "";
	$scope.kolone = {};
	$scope.koloneZaPrikaz = {};
	
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
		//naci ga u listi, obrisati, izmeniti i dodati na isto mesto
		if(rez == 'izmena') {
			HomePageService.izvrsiAkciju(rez, nt, dataIzm);
		}
		//kada se radi dodavanje, treba da se push-uje u listu
		else if(rez == 'dodavanje') {
			HomePageService.izvrsiAkciju(rez, nt, data).then(function(response) {
				var drz = response.data;
				$scope.table.push(drz);
			});
		}
		else if(rez == 'pretraga')
			HomePageService.izvrsiAkciju(rez, nt, data);
	};
	
	$scope.openTable = function(tableName) {
		$scope.promeniRezim('nema');
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
	
	$scope.promeniRezim = function(rez) {
		if(rez == "nema")
			$scope.rezim = "Trenutno nije odabran nijedan rezim.";
//			angular.element(document.getElementById('pretraga'))[0].disabled = true;
		else {
			$scope.rezim = rez.toUpperCase();
		}
	};
	
	$scope.deleteRow = function(tIndex) {
		HomePageService.deleteRow($scope.nameTable, tIndex).
		then(function(response) {
			for (var i = 0; i < $scope.table.length; i++) {
				var item = $scope.table[i];
				if ($scope.getValue(item, "id") == tIndex) {
					$scope.table.splice(i, 1);
					break;
				}
			}
		});
	};
	
	$scope.izmeni = function(id) {
		$scope.rezim = 'izmena';
		$scope.promeniRezim($scope.rezim);
		HomePageService.findById(id, $scope.nameTable, function(data) {
			if(angular.isObject(data))
				$scope.objIzm = data;
		});
	};
	
	$scope.getIzmValue = function(kol) {
		var obj = $scope.objIzm;
		return obj[kol];
	};
	
});
