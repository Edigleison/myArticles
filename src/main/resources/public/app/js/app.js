(function(){
    'use strict'

    var app = angular.module('myArticles', ['ngRoute', 'ngResource']);

    app.config(function($routeProvider, $locationProvider) {
        $routeProvider.when('/article',{
        	templateUrl: 'app/template/article-list.html',
        	controller: 'ArticleListController'
        })
        
        .when('/article/add',{
        	templateUrl: 'app/template/article-edit.html',
        	controller: 'ArticleEditController'
        })
        
        .when('/article/edit/:id',{
        	templateUrl: 'app/template/article-edit.html',
        	controller: 'ArticleEditController'
        })
        
        .when('/user/register',{
        	templateUrl: 'app/template/user-register.html',
        	controller: 'UserRegisterController'
        })
        
        .when('/user/password',{
        	templateUrl: 'app/template/user-register.html',
        	controller: 'UserRegisterController'
        })
        
        .when('/user/edit',{
        	templateUrl: 'app/template/user-register.html',
        	controller: 'UserRegisterController'
        })
        
        .when('/user/logoff',{
        	templateUrl: 'app/template/user-register.html',
        	controller: 'UserRegisterController'
        })
        
        .otherwise({
            redirectTo: '/article'
        });
        
        //$locationProvider.html5Mode(true);
    });
    
    app.config(['$httpProvider', function($httpProvider) {
    	$httpProvider.interceptors.push('AuthInterceptor'); 
    }]);

})();