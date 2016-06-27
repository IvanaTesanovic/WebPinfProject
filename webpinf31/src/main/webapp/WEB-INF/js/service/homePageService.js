app.factory("HomePageService", function($http) {
	return {
	    /*getDrzave: function(callback) {
			$http.get('api/homepage/drzave').success(callback);
	    },
	    getBanke: function(callback) {
			$http.get('api/homepage/banke').success(callback);
	    },
	    getNaseljenaMesta: function(callback) {
	    	$http.get('api/homepage/naseljenaMesta').success(callback);
	    },*/
	    openTable: function(tableName, callback) {
	    	$http.get('api/homepage/' + tableName).success(callback);
	    },
	    getColumnNames: function(tableName, callback) {
	    	$http.get('api/homepage/' + tableName + "/kolone").success(callback);
	    },
	    izvrsiAkciju: function(rez, nt, data) {
	    	var akcijaDTO = {rezim:rez, nazivTabele: nt, data: data};
	    	$http({
	    		method: 'POST',
	    		url: 'api/actions/' + nt,
	    		data: akcijaDTO,
	    		headers: {
                    "Content-Type": "application/json",
                    "Accept": "text/plain, application/json"
                }
	    	}).then(function(callback) {
	    		
	    	});
	    },	    
	    deleteRow: function(tableName, rowId) {
			$http({
				method: 'DELETE',
                url: 'api/homepage/drzave/obrisi/' + rowId,
                headers: {
                    "Content-Type": "application/json",
                    "Accept": "text/plain, application/json"
                }
			}).then(function(callbackSuccess) {
				}
			);
		}
    };       
});

//}).then(function(callbackSuccess) {
//}
//);
//}
