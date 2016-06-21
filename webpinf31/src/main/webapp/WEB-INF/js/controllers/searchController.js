/**
 * Search controller.
 */
app.controller("SearchController", function($scope, $location, $http, TolkvertalerService){
	
	$scope.isAdvanced = false;
	$scope.search = {};
	$scope.master = {};
	$scope.resources = {};
	$scope.errorMessages = {};
	$scope.statuses = [{code:'tolk', label: 'Tolk'},{code:'vertaler', label: 'Vertaler'}];
	$scope.searchInTypes = [{code:'register', label: 'Rbtv'},{code:'uitwijklijst', label: 'Uitwijklijst'}];
	$scope.search.language = {};
	$scope.search.status = null;
	$scope.showItem = false;
	$scope.isDisabled = true;
	
	$scope.patterns = {
			alphaNumeric: /^[a-zA-Z0-9 -]*$/,
			onlyCharacters: /^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð -]*$/,
			zipCodePattern: /^[1-9][0-9]{3} ?[a-z]{2}$/i
	};
	
	
	$scope.loadResources = function(){
		var locale = document.getElementById('localeCode');
		var version = document.getElementById('version');
		$http.get(version.value+'/messages/search_'+locale.value+'.json').success(function(response) {
			$scope.resources = angular.fromJson(response);
		});
		$http.get(version.value+'/messages/errors_'+locale.value+'.json').success(function(response) {
			$scope.errorMessages = angular.fromJson(response);
		});
	};
	
	/** Load select input field data */
	$scope.loadLivingExperienceCountries = function() {
		TolkvertalerService.loadLivingExperienceCountries(function(data){
			if(angular.isObject(data)) {
				$scope.livingExperienceCountry = data;
			}
		});
	};
	
	$scope.loadLanguages = function() {
		TolkvertalerService.loadLanguages(function(data){
			if(angular.isObject(data)) {
				$scope.languages = data;
			}
		});
	};
	
	$scope.loadCountries = function() {
		TolkvertalerService.loadCountries(function(data){
			if(angular.isObject(data)) {
				$scope.countries = data;
			}
		});
	};
	
	$scope.loadSpecializations = function() {
		if(angular.isUndefined($scope.search.status)){
			$scope.search.status = "";
		}
		TolkvertalerService.loadSpecializations($scope.search.status, function(data){
			if(angular.isObject(data)) {
				$scope.specializations = data;
			}
		});
	};
	
	$scope.loadSearchInType = function() {
		if(angular.isUndefined($scope.search.status)){
			$scope.search.searchInType = "";
		}
		
		$scope.search.searchInType = $scope.searchInTypes[0].code;
	};
	
	/**
	 * Initializes search criteria.
	 */
	$scope.init = function(){
		$scope.search = {};
//		$scope.master = angular.copy($scope.search);
//		$scope.loadResources();
//		$scope.loadLivingExperienceCountries();
//		$scope.loadLanguages();
//		$scope.loadCountries();
//		$scope.loadSpecializations();
//		$scope.loadSearchInType();
		
	};
	
	$scope.init();
	
	$scope.validateForm = function() {
		if (($scope.search.searchInType != null && $scope.search.status != null && $scope.search.sourceLanguage != null && $scope.search.targetLanguage != null)
		|| $scope.search.wbtvNumber != null 
		|| (($scope.search.searchInType != null && $scope.search.firstName != null && $scope.search.firstName != '') || ($scope.search.lastName != null && $scope.search.lastName != ''))) {
			return true;
		} else {
			return false;
		}
	};
		
	$scope.submitForm = function() {
		$scope.search.page = 0;
		TolkvertalerService.saveSearchForm($scope.search);
		$location.path('/results');
	 };
	 
	 
	$scope.isUnchanged = function(search) {
		return angular.equals(search, $scope.master);
	};
	
	$scope.resetForm = function() {
		$scope.form.$setPristine();
		$scope.search = {};
		$scope.master = angular.copy($scope.search);
	};
	
	$scope.initTolkStatus = function() {
		for (var i = 0; i < $scope.languages.length;  i++) {
			if(angular.equals($scope.languages[i].name, "Nederlands")){
				$scope.search.sourceLanguage = $scope.languages[i];
				break;
			}
		}
	};	
	
});