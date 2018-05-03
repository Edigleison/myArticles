(function(){
	'use strict'
	
	angular.module('myArticles').controller('UserRegisterController', UserRegisterController);
	
	UserRegisterController.$inject = ['$scope'];
	function UserRegisterController($scope){
		$scope.msg = 'User register';
		console.log($scope.msg);
	}
	
})();