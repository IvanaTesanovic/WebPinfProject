app.factory("HomePageService", function($http) {
	return {
	    getDrzave: function(callback) {
			$http.get('homepage/drzave').success(callback);
	    },
	    getBanke: function(callback) {
			$http.get('homepage/banke').success(callback);
	    },
	    getNaseljenaMesta: function(callback) {
	    	$http.get('homepage/naseljenaMesta').success(callback);
	    }
    };       
});