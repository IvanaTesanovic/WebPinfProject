app.factory("LoginService", function($http) {
	return {
	    getString: function(callback) {
			$http.get('api/login').success(callback);
	    }
    };       
});