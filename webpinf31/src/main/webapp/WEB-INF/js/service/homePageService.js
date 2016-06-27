app.factory("HomePageService", function($http) {
	return {
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
	    deleteRow: function(rowId) {
			$http({
				method: 'DELETE',
                url: 'api/homepage/drzave/obrisi/' + rowId,
                data: rowId,
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