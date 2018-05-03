(function(){
	'use strict'
	
	angular.module("myArticles").factory('AuthInterceptor',  AuthInterceptor);
	
	AuthInterceptor.$inject = [];
	
	function AuthInterceptor() {
		var interceptor = {};
		interceptor.request = function(config) {
			config.headers = config.headers || {};
			var encodedString = btoa("user:password");
			config.headers.Authorization = 'Basic ' + encodedString;
			return config;
		}
		
		return interceptor;
	}
})();


