var randomBeer = angular.module('randomBeer', ['ngRoute', 'angularControllers']);

randomBeer.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when("/beers", {
            templateUrl: 'templates/beers.html',
            controller: 'BeersController'
        }).
        when('/beers/new', {
            templateUrl: 'templates/newbeer.html'
        }).
        when('/', {
            templateUrl: 'templates/random.html'
        }).
        otherwise({
            redirectTo: '/'
        });
}]);