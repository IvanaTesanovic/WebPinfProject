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
	    getForeignKeys: function(tableName, callback) {
	    	$http.get('api/homepage/' + tableName + "/foreignKey").success(callback);
	    },
	    importNaloga: function(file) {
	    	var fd = new FormData();
	        fd.append('file', file);
	    	$http({
	    		method: 'POST',
	    		url: 'api/homepage/import',
	    		data: fd,
	    		transformRequest: angular.identity,
	    		headers: {
                    "Content-Type": undefined,
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

