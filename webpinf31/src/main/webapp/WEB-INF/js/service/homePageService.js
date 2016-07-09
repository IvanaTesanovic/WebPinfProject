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
	    importNaloga: function() {
	    	$http({
	    		method: 'POST',
	    		url: 'api/homepage/import',
	    		data: data,
	    		headers: {
                    "Content-Type": "multipart/form-data",
                }
	    	});
	    },
	    izvrsiAkciju: function(rez, nt, data) {
	    	return $http({
	    		method: 'POST',
	    		url: 'api/actions/' + nt + '/' + rez,
	    		data: data,
	    		headers: {
                    "Content-Type": "application/json",
                    "Accept": "text/plain, application/json"
                }
	    	});
	    },
	    deleteRow: function(tableName, rowId) {
			return $http({
				method: 'DELETE',
                url: 'api/homepage/' + tableName + '/obrisi/' + rowId,
                headers: {
                    "Content-Type": "application/json",
                    "Accept": "text/plain, application/json"
                }
			});
		}
    };       
});

