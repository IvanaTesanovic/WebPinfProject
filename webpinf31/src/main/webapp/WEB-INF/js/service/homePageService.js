app.factory("HomePageService", function($http) {
	return {
	    getDrzave: function(callback) {
			$http.get('api/homepage/drzave').success(callback);
	    },
	    getBanke: function(callback) {
			$http.get('api/homepage/banke').success(callback);
	    },
	    getNaseljenaMesta: function(callback) {
	    	$http.get('api/homepage/naseljenaMesta').success(callback);
	    }
    };       
});