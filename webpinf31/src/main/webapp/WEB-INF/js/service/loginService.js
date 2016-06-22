app.factory("HomePageService", function($http) {
	return {
	    getDrzave: function(callback) {
			$http.get('login').success(callback);
	    }
    };       
});