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
	    deleteRow: function(tableName, rowId) {
			$http({
				method: 'DELETE',
                url: 'api/homepage/' + tableName + '/obrisi/' + rowId,
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