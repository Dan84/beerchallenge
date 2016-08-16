var angularControllers = angular.module('angularControllers', []);

angularControllers.controller('BeersController', function($scope, $http, $location) {
    $scope.beers = [];

    $http.get('/beers').success(function (data, status, headers, config) {
        $scope.beers = data;
        
    	//console.log($scope.beers.length);
    }).error(function (data, status, headers, config) {
        $scope.errorMessage = "Beers not found";
    });

    $scope.deleteBeer = function(id) {
    	console.log("hello delete called");
    	if (confirm("Are you sure you want to delete this Beer?")) {
	        $http.delete('beers/' + id)
	        .success(function (data, status, headers, config) {
	            $scope.beers = $scope.beers.filter(function(beer) {
	                    return beer.id != id;
	                }
	            );
	        }).error(function (data, status, headers, config) {
	            $scope.errorMessage = "Can't delete beer!";
	        });
    	}
    };

    $scope.addBeer = function() {
    	//console.log("hello addbeer called");
        var beer = $scope.beer;
        //var params = JSON.stringify(beer);
        $http.post('/beers', beer, {
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (data, status, headers, config) {
            
            	console.log(data);
            	$location.path('/beers')
                $scope.errorMessage = null;
           
        }).error(function (data, status, headers, config) {
        	console.log('Error: ' + data);
        });
    };
    
    
    $scope.randomBeer = function(){
    	
    	
    	//console.log($scope.beers.length);
    	var randomId = $scope.beers[Math.floor(Math.random()*$scope.beers.length)];
    	
    	$http.get('/beers/'+ randomId.id).success(function (data, status, headers, config) {
            $scope.beer = data;            
        	
        }).error(function (data, status, headers, config) {
            $scope.errorMessage = "Beer not found";
        });        
    	
    	
    };
});