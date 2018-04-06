(function(){
	'use strict'
	
	var app = angular.module('myArticles');
	app.controller('HomeController', function ($scope){
		$scope.msg = 'Wellcome to My Articles';
		console.log($scope.msg);
	});
	
	/*HomeController.$inject = ['$scope'];
	function HomeController($scope){
		$scope.msg = 'Wellcome to My Articles';
		console.log($scope.msg);
	}*/
	
})();