app.controller("HomePageController", function($scope, HomePageService) {
	
	$scope.rezim = "Trenutno nije odabran nijedan rezim.";
	$scope.table = {};
	$scope.nameTable = "";
	$scope.kolone = {};
	$scope.koloneZaPrikaz = {};
	
	$scope.idIzmene = "";
	
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
			else if (klasa == 'dp') {
				var val = inputs[i].value;
				if (inputs[i].type == "checkbox") {
					//stalno vraca on; zasto??
					console.log(val);
	                if (val == "on")
	                    val = true;
	                if (val == "off")
	                    val = false;
	            }
	            if (val == "")
	                val = null;
		        data[id] = val;
			}
		}
		//naci ga u listi, obrisati, izmeniti i dodati na isto mesto
		//array.splice(index,howmany,item1,.....,itemX); if howmany == 0, no item will be removed; index - tamo gde zelim da dodam
		if(rez == 'izmena') {
			HomePageService.izvrsiAkciju(rez, nt, dataIzm).then(function(response) {
				var obj = response.data;
				for(var i = 0; i < $scope.table.length; i++) {
					var item = $scope.table[i];
					if($scope.getValue(item, "id") == $scope.idIzmene) {
						$scope.table.splice(i, 1);
						$scope.table.splice(i, 0, obj);
						break;
					}
				}
			});
		}
		else if(rez == 'dodavanje') {
			HomePageService.izvrsiAkciju(rez, nt, data).then(function(response) {
				var obj = response.data;
				$scope.table.push(obj);
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
		HomePageService.deleteRow($scope.nameTable, tIndex);
		$scope.table.splice(tIndex - 1, 1);

	};
	
	$scope.izmeni = function(obj) {
		$scope.rezim = 'izmena';
		$scope.promeniRezim($scope.rezim);
		$scope.idIzmene = obj.id;
		$scope.objIzm = obj;
//		HomePageService.findById(id, $scope.nameTable, function(data) {
//			if(angular.isObject(data)) {
//				$scope.objIzm = data;
//				console.log($scope.objIzm);
//			}
//		});
	};
	
	//pokupi dobar objIzm, ali nece da promeni vrednost.... KAKO JE TO MOGUCE UOPSTE
	$scope.getIzmValue = function(kol) {
		var obj = $scope.objIzm;
		return $scope.objIzm[kol];
	};
	
});