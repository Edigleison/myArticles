(function(){
	'use strict'
	
	angular.module('myArticles').controller('HomeController', HomeController);
	
	HomeController.$inject = ['$scope'];
	function HomeController($scope){
		$scope.msg = 'Wellcome to My Articles';
		console.log($scope.msg);
	}
	
})();