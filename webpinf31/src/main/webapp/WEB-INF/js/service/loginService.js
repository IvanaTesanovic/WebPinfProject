app.factory("LoginService", function($http) {
	return {
	    getString: function(callback) {
			$http.get('api/login').success(callback);
	    },
		submitUser: function(korisnickoIme, lozinka) {
			var korisnikDTO = {korisnickoIme:korisnickoIme, lozinka:lozinka};
			$http({
				method: 'POST',
                url: 'api/login',
                data: korisnikDTO,
                headers: {
                    "Content-Type": "application/json",
                    "Accept": "text/plain, application/json"
                }
			}).then(function (response) {
				
			}, function(errorResponse) {
				
			});
		}
    };       
});