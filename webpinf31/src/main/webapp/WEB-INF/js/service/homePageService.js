app.factory("HomePageService", function($http) {
	return {
		findById: function(id, tableName, callback) {
			$http.get('api/homepage/' + tableName + '/' + id).success(callback);
		},
	    openTable: function(tableName, callback) {
	    	$http.get('api/homepage/' + tableName).success(callback);
	    },
	    getColumnNames: function(tableName, callback) {
	    	$http.get('api/homepage/' + tableName + "/kolone").success(callback);
	    },
	    izvrsiAkciju: function(rez, nt, data) {
	    	$http({
	    		method: 'POST',
	    		url: 'api/actions/' + nt + '/' + rez,
	    		data: data,
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
