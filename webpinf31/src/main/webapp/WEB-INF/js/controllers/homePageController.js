app.controller("HomePageController", function($scope, $location, HomePageService) {
	
	$scope.rezim = "Trenutno nije odabran nijedan rezim.";
	$scope.table = {};
	$scope.nameTable = "";
	$scope.kolone = {};
	$scope.koloneZaPrikaz = {};
	
	$scope.idIzmene = "";
	
	$scope.objIzm = {};
	$scope.valIzm = "";
	
	$scope.init = function() {
		//$scope.objIzm = { id: 54, naziv: "rrr", ptt_oznaka: "rrrr", id_drzave: {id: 3, naziv: "Srbija"} };
	};
	
	$scope.init();

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
		//$scope.objIzm = obj;
		if(kol.includes("id_"))
			return obj[kol].id;
		if(obj[kol] == true)
			return "DA";
		else if(obj[kol] == false)
			return "NE";
		else
			return obj[kol];
	};
	
	$scope.promeniRezim = function(rez) {
		if(rez == "nema")
			$scope.rezim = "Trenutno nije odabran nijedan rezim.";
		else 
			$scope.rezim = rez.toUpperCase();
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
	
	$scope.izmeni = function(obj) {
		console.log(obj);
		$scope.rezim = 'izmena';
		$scope.promeniRezim($scope.rezim);
		$scope.idIzmene = obj.id;
		$scope.objIzm = obj;
		console.log($scope.objIzm);
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
		console.log("izmvalue" + obj);
		if(kol.includes("id_"))
			return obj[kol].id;
		else if(obj[kol] == true)
			return "DA";
		else if(obj[kol] == false)
			return "NE";
		else 
			return obj[kol];
	};
	
	$scope.izvrsiAkciju = function() {
		//ovde treba vratiti objekat na scope?
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
			else if (klasa == 'dp' || klasa == 'dpbl') {
				var val = inputs[i].value;
				if(klasa == 'dpbl') {
					console.log(val);
					var newVal = val.toLowerCase();
					console.log(newVal);
					if(newVal == "ne")
						val = "false";
					else if(newVal == "da")
						val = "true";
					console.log(val);
				}
	            if (val == "")
	                val = null;
		        data[id] = val;
			}
		}
		//u zavisnosti od rezima, handle-ujemo prikaz na homepage.html
		if(rez == 'izmena') {
			console.log("izmena");
			console.log("izmena" + dataIzm);
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
		
		$scope.promeniRezim('nema');
		//$scope.objIzm = {};
		//vratiti sve inpute na null
//		for(var i = 0; i < inputs.length; i++) {
//			inputs[i].value = null;
//		}
	};
	
});
