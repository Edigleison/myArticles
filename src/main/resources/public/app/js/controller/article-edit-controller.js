(function(){
	'use strict'
	
	angular.module("myArticles").controller("ArticleEditController", ArticleAddController);
	
	ArticleAddController.$inject = ['$scope', '$location', '$routeParams', 'ArticleService'];
	
	function ArticleAddController($scope, $location, $routeParams, ArticleService){
		
		$scope.cancel = function(){
			$scope.article = {};
			$location.path('/article');
		}
		
		$scope.submit = function(){
			if($scope.edit){
				ArticleService.edit($scope.article).then(
						function(resp){
							$scope.article = {};
							$location.path('/article');
						},function(error){
							console.log(error);
						});
			}else{
				ArticleService.add($scope.article).then(
						function(resp){
							$scope.article = {};
							$location.path('/article');
						},function(error){
							console.log(error);
						});
				
			}
		}
		
		function init(){
			$scope.edit = false;
			$scope.article = {};
			
			if($routeParams.id){
				$scope.edit = true;
				ArticleService.get($routeParams.id).then(
						function(response){
							$scope.article = response.data;
						}, function(error){
							console.log(error);
							$location.path('/article');
						});
			}
		}
		
		init();
		
	}
	
})();