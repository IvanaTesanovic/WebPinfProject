app.controller("HomePageController", function($scope, $location, $sce, $http, HomePageService) {
	
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
	$scope.importError = "";
	
	$scope.zoomFlag = 0;
	$scope.ukidanjeVal = false;
	$scope.racunZaUkidanje = {};
	$scope.rezimUkidanja = "";
	$scope.brojRacunaZaPrebacivanje = "";
	$scope.errorPrebacivanje = "";
	$scope.errorUkidanje = "";
	
	$scope.izvestajHtml = {};
	$scope.postojiIzvestaj = false;
	$scope.klijentiIzvestaj = {};
	$scope.prikazAnalitike = false;
	$scope.errorAnalitikaIzvestaj = "";
	$scope.errorPrikazIzvestaja = "";
	
	$scope.dataIzvestaj = {};
	$scope.prethodnaTabela = "";
	$scope.prethodniRezim = "";
	
	$scope.init = function() {
		//$scope.objIzm = { id: 54, naziv: "rrr", ptt_oznaka: "rrrr", id_drzave: {id: 3, naziv: "Srbija"} };
		
	};
	
	$scope.init();

	$scope.openTable = function(tableName) {
		$scope.otkaziUkidanje();
		$scope.myFile = null;
		$scope.error = "";
		$scope.importError = "";
		$scope.promeniRezim('nema');
		$scope.nameTable = tableName;
		HomePageService.openTable(tableName, function(data) {
			if(angular.isObject(data))
				$scope.table = data;
		});
		HomePageService.getColumnNames(tableName, function(data) {
			if(angular.isObject(data)) {
				$scope.kolone = data;
				getComboVrednosti();
				console.log("vrednosti");
				console.log($scope.comboVrednosti);
			}
		});
		$scope.foreignKeys = [];
		HomePageService.getForeignKeys(tableName, function(data){
			if(angular.isObject(data))
				$scope.foreignKeys = data;
		});
	};
	
	function getComboVrednosti() {
		$scope.comboVrednosti = {};
		for (var i = 0; i < $scope.kolone.length; i++) {
			var kol = $scope.kolone[i].naziv;
			if (kol.startsWith("id_")) {
				console.log("kol");
				console.log(kol);
				
				if (kol == "id_banke") {
					HomePageService.openTable("banke", function(data) {
						if(angular.isObject(data))
							$scope.comboVrednosti[kol] = data;
					});
				}
				else if (kol == "id_drzave") {
					HomePageService.openTable("drzave", function(data) {
						if(angular.isObject(data))
							$scope.comboVrednosti[kol] = data;
					});
				} else if (kol == "id_naseljenog_mesta") {
					HomePageService.openTable("naseljenaMesta", function(data) {
						if(angular.isObject(data))
							$scope.comboVrednosti[kol] = data;
					});
				} else if (kol == "id_delatnosti") {
					$scope.comboVrednosti[kol] = [{id: "6002", naziv: "aaa"}, {id: "6003", naziv: "bbbb"}, {id: "6004", naziv: "cccc"}];
				} 
				else if (kol == "id_racuna") {
					HomePageService.openTable("racuni", function(data) {
						if(angular.isObject(data))
							$scope.comboVrednosti[kol] = data;
					});
				} else if (kol == "id_klijenta") {
					HomePageService.openTable("klijenta", function(data) {
						if(angular.isObject(data))
							$scope.comboVrednosti[kol] = data;
					});
				} else if (kol == "id_valute") {
					$scope.comboVrednosti[kol] = [{id: "RSD", naziv: "Dinar"}, {id: "EUR", naziv: "Euro"}, {id: "USD", naziv: "Dolar"}];
				}
				
				
				else {
					$scope.comboVrednosti[kol] = [{id: "3453", label: "24321"}, {id: "35345", label: "sfgb"}, {id: "23411", label: "aaa"}];
				}
			}
		}
	}
	
	$scope.zoom = function(nameTable, prosliRezim, tableName) {
		console.log("tabela back");
		console.log(nameTable);
		
		console.log("rezim back");
		console.log(prosliRezim);
		
		$scope.prethodnaTabela = nameTable;
		$scope.prethodniRezim = prosliRezim;
		$scope.zoomFlag = 1;
		$scope.rezim = "ZOOM";
		
		$scope.openTable(tableName);
//		HomePageService.openTable(tableName, function(data) {
//			if(angular.isObject(data))
//				$scope.drzaveCombo = data;
//		});
	}
	
	$scope.vratiZoomRezim = function() {
		$scope.zoomFlag = 0;
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
		else if(kol === "id_poruke")
			return obj[kol];
		else if(kol === "id_delatnosti")
			return obj[kol];
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
		$scope.importError = "";
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
		if(kol === "id_poruke")
			return obj[kol];
		else if(kol === "id_delatnosti")
			return obj[kol];
		else if(kol.includes("id_"))
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
		var combos = document.getElementsByTagName('select');

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
		console.log(combos.length);
		
		for (var i=0; i<combos.length; i++) {
			
			var id = combos[i].getAttribute('id');
			var val = combos[i].value;
			data[id] = val;
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
        HomePageService.importNaloga(file).then(function(response) {
        	$scope.importError = response.data;
        });
    };

    
    $scope.exportNaloga = function(nalog) {
    	HomePageService.exportNaloga(nalog, $scope.nameTable);
    };
    
    /** UKIDANJE RACUNA **/
    
    $scope.ukidanjeForma = function(racun) {
    	$scope.otkaziUkidanje();
    	$scope.racunZaUkidanje = racun;
    	$scope.ukidanjeVal = true;
    };
    
    $scope.ukidanjeSaPrebacivanjem = function() {
    	$scope.errorPrebacivanje = "";
    	$scope.errorUkidanje = "";
    	$scope.rezimUkidanja = "sa";
    };
    
    $scope.ukidanjeBezPrebacivanja = function() {
    	$scope.errorPrebacivanje = "";
    	$scope.errorUkidanje = "";
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
    		HomePageService.ukidanje($scope.racunZaUkidanje.id, $scope.brojRacunaZaPrebacivanje, $scope.rezimUkidanja).then(function(response) {
            	$scope.errorUkidanje = response.data;
            });
    	}
    	$scope.otkaziUkidanje();
    	$scope.nameTable = "";
    };
    
    $scope.otkaziUkidanje = function() {
    	$scope.errorUkidanje = "";
    	$scope.errorPrebacivanje = "";
    	$scope.brojRacunaZaPrebacivanje = "";
    	$scope.rezimUkidanja = "";
    	$scope.racunZaUkidanje = null;
    	$scope.ukidanjeVal = false;
    };
    
    /** IZVESTAJI **/
    
    $scope.zatvoriIzvestaj = function() {
    	$scope.postojiIzvestaj = false;
    };
    
    $scope.izvestajRacuni = function(sifra) {
    	HomePageService.jasperKonekcija().then(function (response) {
            console.log("uspesno logovanje");
            $http.get("http://localhost:8080/jasperserver/rest_v2/reports/reports/racuni.html?sifra_banke=" + sifra)
                .then(function (response) {
                	$scope.errorPrikazIzvestaja = "";
                	$scope.postojiIzvestaj = true;
                    console.log("uspesno ucitan izvestaj");
                    $scope.izvestajHtml = $sce.trustAsHtml(response.data);
                    console.log(response.data);
                }, function (error) {
                    console.log(error);
                });
        }, function (error) {
            console.log(error);
            $scope.errorPrikazIzvestaja = "Nije moguce prikazati izvestaj!";
        });
    };
    
    $scope.klijentiIzvestaj = function() {
    	HomePageService.openTable('klijenti', function(data) {
			if(angular.isObject(data))
				$scope.klijentiIzvestaj = data;
		});
    };
    
    $scope.prikaziAnalitikuIzvestaj = function() {
    	$scope.prikazAnalitike = true;
    	$scope.klijentiIzvestaj();
    };
    
    $scope.zatvoriPrikazAnalitike = function() {
    	$scope.prikazAnalitike = false;
    };
    
    $scope.izvestajAnalitika = function(isValid) {
    	console.log($scope.dataIzvestaj);
    	var dod = $scope.dataIzvestaj.datum_od;
    	var ddo = $scope.dataIzvestaj.datum_do;
    	var iki = $scope.dataIzvestaj.id_klijenta_izvestaj;
    	if (isValid) {
    		$scope.errorAnalitikaIzvestaj = "";
	    	HomePageService.jasperKonekcija().then(function (response) {
	            console.log("uspesno logovanje");
	            $http.get("http://localhost:8080/jasperserver/rest_v2/reports/reports/analitika.html?datumod=" + dod + "&datumdo=" + ddo + "&idklijenta=" + iki)
	                .then(function (response) {
	                	$scope.errorPrikazIzvestaja = "";
	                	$scope.postojiIzvestaj = true;
	                    console.log("uspesno ucitan izvestaj");
	                    $scope.izvestajHtml = $sce.trustAsHtml(response.data);
	                    console.log(response.data);
	                }, function (error) {
	                    console.log(error);
	                });
	        }, function (error) {
	            console.log(error);
	            $scope.errorPrikazIzvestaja = "Nije moguce prikazati izvestaj!";
	        });
    	}
    	else
    		$scope.errorAnalitikaIzvestaj = "Morate popuniti sva polja!";
    };
    
    $scope.getOptions = function(nazivKolone) {
    	var retVal = [];
    	var comboLabelColumn;
    	var comboVrednosti = $scope.comboVrednosti[nazivKolone];
    	console.log(comboVrednosti);
    	
    	for(var i=0; i<comboVrednosti.length; i++) {
    		console.log("usao u for");
    		console.log(comboVrednosti[i]);
    		if (nazivKolone == "id_drzave") {
    			var obj = {
        				id: comboVrednosti[i].id,
        				label : comboVrednosti[i].naziv
        		}
//    			retVal.push(obj);
    		} else if (nazivKolone == "id_delatnosti") {
    			var obj = {
        				id: comboVrednosti[i].id,
        				label : comboVrednosti[i].naziv
        		}
//    			retVal.push(obj);
    		} else if (nazivKolone == "id_naseljenog_mesta") {
    			var obj = {
        				id: comboVrednosti[i].id,
        				label : comboVrednosti[i].naziv
        		}
//    			retVal.push(obj);
    		} else if (nazivKolone == "id_racuna") {
    			var obj = {
        				id: comboVrednosti[i].id,
        				label : comboVrednosti[i].broj_racuna
        		}
//    			retVal.push(obj);
    		}  else if (nazivKolone == "id_klijenta") {
    			var obj = {
        				id: comboVrednosti[i].id,
        				label : comboVrednosti[i].jmbg
        		}
//    			retVal.push(obj);
    		} else if (nazivKolone == "id_poruke") {
    			var obj = {
        				id: comboVrednosti[i].id,
        				label : comboVrednosti[i].label
        		}
//    			retVal.push(obj);
    		} else if (nazivKolone == "id_banke") {
    			var obj = {
        				id: comboVrednosti[i].id,
        				label : comboVrednosti[i].naziv
        		}
    		}
    		
    		
    		retVal.push(obj);
    	}
    	console.log("retVal");
    	console.log(retVal);
    	return retVal;
    };
    
  //NEXT 
    $scope.update = function(tIndex){
 	   var val = "";
 	   if (($('#nextSelect :selected').text() != ""))
 			 val = $('#nextSelect :selected').text();
 	   var childTable = "";
 	   if (val == "Naseljeno mesto")
 		   childTable = "naseljenaMesta";
 	   
 	   else if (val == "Kursna lista")
 		   childTable = "kursnaLista";
 	   
 	   else if (val == "Banka")
 		   childTable = "banke";
 	   
 	   else if (val == "Racun")
 		   childTable = "racuni";
 	   
 	   else if (val == "Drzava")
 		   childTable = "drzave";
 	   
 	   else if (val == "Kurs u valuti")
 		   childTable = "kursevi";
 	   
 	   else if (val == "Klijent")
 		   childTable = "klijenti";
 	   
 	   else if (val == "Dnevno stanje racuna")
 		   childTable = "dnevnaStanja";
 	   
 	   else if ("Analitika izvoda")
 		   childTable = "analitikeIzvoda";
 		   
 	   console.log(val);
 	   HomePageService.next($scope.nameTable, tIndex).then(function(response){
 			HomePageService.getColumnNames(childTable, function(data) {
 				if(angular.isObject(data))
 					$scope.kolone = data;
 			});
 			$scope.foreignKeys = [];
 			HomePageService.getForeignKeys(childTable, function(data){
 				if(angular.isObject(data))
 					$scope.foreignKeys = data;
 			});
 		   $scope.table = response.data;
 		   console.log(response.data);
 	   });
 		};
	
});
