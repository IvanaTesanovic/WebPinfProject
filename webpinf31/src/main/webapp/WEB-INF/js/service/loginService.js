app.factory("LoginService", function($http) {
	return {
	    getString: function(callback) {
			$http.get('/login').success(callback);
	    }
    };       
});