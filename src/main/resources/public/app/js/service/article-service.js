(function(){
	'use strict'
	
	angular.module("myArticles").service("ArticleService", ArticleService);
	
	ArticleService.$inject = ['$http']
	
	function ArticleService($http){
		const baseUrl = '/api/article/'
		
		this.add = function(article){
			return $http.post(baseUrl, article);
		}
		
		this.edit = function(article){
			return $http.put(baseUrl+article.id, article);
		}
		
		this.listAll = function(){
			return $http.get(baseUrl);
		}
		
		this.get = function(id){
			return $http.get(baseUrl+id);
		}
		
		this.remove = function(id){
			return $http.delete(baseUrl+id);
		}
	}
	
})();