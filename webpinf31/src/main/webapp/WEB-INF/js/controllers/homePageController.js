app.controller("HomePageController", function($scope, $location, HomePageService) {
	
	$scope.rezim = "Trenutno nije odabran nijedan rezim.";
	$scope.table = {};
	$scope.nameTable = "";
	$scope.kolone = {};
	$scope.koloneZaPrikaz = {};
	$scope.foreignKeys = {};
	
	
	$scope.idIzmene = "";
	
	$scope.objIzm = {};
	$scope.valIzm = "";
	
	$scope.error = "";
	
	$scope.zoomFlag = 0;
	$scope.ukidanjeVal = false;
	$scope.racunZaUkidanje = {};
	$scope.rezimUkidanja = "";
	$scope.brojRacunaZaPrebacivanje = "";
	$scope.errorPrebacivanje = "";
	
	$scope.init = function() {
		//$scope.objIzm = { id: 54, naziv: "rrr", ptt_oznaka: "rrrr", id_drzave: {id: 3, naziv: "Srbija"} };
		
	};
	
	$scope.init();

	$scope.openTable = function(tableName) {
		$scope.otkaziUkidanje();
		$scope.myFile = null;
		$scope.error = "";
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
		$scope.foreignKeys = [];
		HomePageService.getForeignKeys(tableName, function(data){
			if(angular.isObject(data))
				$scope.foreignKeys = data;
			
		});
		
	};
	
	$scope.zoom = function(tableName) {
		$scope.zoomFlag = 1;
		HomePageService.openTable(tableName, function(data) {
			if(angular.isObject(data))
				$scope.zoomVrednosti = data;
		});
	}

	$scope.getValue = function(obj, kol, tip) {
		//$scope.objIzm = obj;
		if(tip == "date") {
			var val = obj[kol];
			var god = val.split("-")[0];
			var mes = val.split("-")[1];
			var dan = val.split("-")[2];
			return dan+"-"+mes+"-"+god;
		}
		else if(kol.includes("id_"))
			return obj[kol].id;
		else if(obj[kol] === true)
			return "DA";
		else if(obj[kol] === false)
			return "NE";
		else
			return obj[kol];
	};
	
	$scope.promeniRezim = function(rez) {
		$scope.otkaziUkidanje();
		$scope.error = "";
		$scope.myFile = null;
		if(rez == "nema")
			$scope.rezim = "Trenutno nije odabran nijedan rezim.";
		else 
			$scope.rezim = rez.toUpperCase();
	};
	

	
	$scope.deleteRow = function(tIndex) {
		$scope.otkaziUkidanje();
		HomePageService.deleteRow($scope.nameTable, tIndex).
		then(function(response) {
			$scope.error = "";
			for (var i = 0; i < $scope.table.length; i++) {
				var item = $scope.table[i];
				if ($scope.getValue(item, "id", "int") == tIndex) {
					$scope.table.splice(i, 1);
					break;
				}
			}
		}, function(error) {
			$scope.error = "Nije moguce obrisati ovaj objekat!";
		});
	};
	
	$scope.izmeni = function(obj) {
		$scope.otkaziUkidanje();
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
		else if(obj[kol] === true)
			return "DA";
		else if(obj[kol] === false)
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
		var combo = document.getElementsByTagName('option');
		
		for(var i = 0; i < inputs.length; i++) {
			var id = inputs[i].getAttribute('id');
			var klasa = inputs[i].getAttribute('class');
			if(klasa == 'izm') {
				var val = inputs[i].value;
				dataIzm[id] = val;
			}
			else if (klasa == 'dp' || klasa == 'dpbl') {
				if (($('#zoomSelect :selected').text() != "") && (id.includes("id_"))) {
					var val = $('#zoomSelect :selected').text().split(' ')[0];
				} else {
					val = inputs[i].value;
				}
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
				$scope.error = "";
				var obj = response.data;
				for(var i = 0; i < $scope.table.length; i++) {
					var item = $scope.table[i];
					if($scope.getValue(item, "id", "int") == $scope.idIzmene) {
						$scope.table.splice(i, 1);
						$scope.table.splice(i, 0, obj);
						break;
					}
				}
			}, function(error) {
				$scope.error = "Nije moguce izmeniti ovaj objekat!";
			});
		}
		else if(rez == 'dodavanje') {
			HomePageService.izvrsiAkciju(rez, nt, data).then(function(response) {
				$scope.error = "";
				var obj = response.data;
				$scope.table.push(obj);
			}, function(error) {
				$scope.error = "Nije moguce dodati ovaj objekat!";
			});  
		} 
		else if(rez == 'pretraga') {
			HomePageService.izvrsiAkciju(rez, nt, data).then(function(response) {
				$scope.error = "";
				var obj = response.data;
				$scope.table = obj;
			}, function(error) {
				$scope.error = "Nije moguce izvrsiti pretragu po ovom kriterijumu!";
			});
		}
		
		$scope.promeniRezim('nema');
	};
	
	$scope.importNaloga = function() {
        var file = $scope.myFile;
        HomePageService.importNaloga(file);
    };
   
/*	
  //next	
  	$scope.child = function(nameTable) {
  		HomePageService.getForeignKeys(nameTable, function(data) {
  						if(angular.isObject(data))
  							$scope.foreignKeys = data;
  						
  					}); 
  			for( var i = 1; i < scope.foreignKeys.length; i++){
  				 if ($scope.foreignKeys[i] == nameTable){ 
  					 $scope.openTable(nameTable);
  			 }
  			
  		} 
  		return $scope.openTable("drzave");
  		
  	};
  	*/
    
    
    /* UKIDANJE RACUNA */
    
    $scope.ukidanjeForma = function(racun) {
    	$scope.otkaziUkidanje();
    	$scope.racunZaUkidanje = racun;
    	$scope.ukidanjeVal = true;
    };
    
    $scope.ukidanjeSaPrebacivanjem = function() {
    	$scope.errorPrebacivanje = "";
    	$scope.rezimUkidanja = "sa";
    };
    
    $scope.ukidanjeBezPrebacivanja = function() {
    	$scope.errorPrebacivanje = "";
    	$scope.rezimUkidanja = "bez";
    };
    
    $scope.ukidanje = function() {
    	$scope.brojRacunaZaPrebacivanje = $('#ukidanjeSelect :selected').text();
    	if($scope.brojRacunaZaPrebacivanje == "Odaberite racun na koji zelite da prebacite novac") {
    		$scope.errorPrebacivanje = "Morate odabrati racun!";
    	}
    	else if($scope.rezimUkidanja == "bez") {
    		$scope.errorPrebacivanje = "";
    		HomePageService.ukidanje($scope.racunZaUkidanje.id, "nema", $scope.rezimUkidanja);
    	}
    	else if($scope.rezimUkidanja == "sa") {
    		$scope.errorPrebacivanje = "";
    		HomePageService.ukidanje($scope.racunZaUkidanje.id, $scope.brojRacunaZaPrebacivanje, $scope.rezimUkidanja);
    	}
    	$scope.otkaziUkidanje();
    	$scope.nameTable = "";
    };
    
    $scope.otkaziUkidanje = function() {
    	$scope.errorPrebacivanje = "";
    	$scope.brojRacunaZaPrebacivanje = "";
    	$scope.rezimUkidanja = "";
    	$scope.racunZaUkidanje = null;
    	$scope.ukidanjeVal = false;
    };
    
});
