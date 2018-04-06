(function(){
    'use strict'

    var app = angular.module('myArticles', ['ngRoute', 'ngResource']);

    app.config(function($routeProvider){
        $routeProvider.when('/',{
        	templateURL: '/template/home.html',
        	controller: 'HomeController'
        }).otherwise({
            redirectTo: '/'
        })
    });

})();