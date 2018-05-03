(function(){
	'use strict'
	
	angular.module("myArticles").controller("ArticleListController", ArticleListController);
	
	ArticleListController.$inject = ['$scope', '$location', 'ArticleService'];
	
	function ArticleListController($scope, $location, ArticleService){
		
		$scope.add = function(){
			$location.path('/article');
		}
		
		function init(){
			ArticleService.listAll().then(function(response){
				$scope.articles = response.data;
			}, function(error){
				console.log(error);
			});
		}
		
		$scope.remove = function(article){
			ArticleService.remove(article.id).then(function(response){
				init();
			},function(error){
				console.log(error);
			});
		}
		
		init();
		
	}
	
})();