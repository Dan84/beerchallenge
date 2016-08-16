var angularControllers = angular.module('angularControllers', []);

angularControllers.controller('BeersController', function($scope, $http, $location) {
    $scope.beers = [];
    
    //Get All Beers function
    $http.get('/beers').success(function (data, status, headers, config) {
        $scope.beers = data;        
    	//console.log($scope.beers.length);
    }).error(function (data, status, headers, config) {
        $scope.errorMessage = "Beers not found";
    });
    
    
    //DeleteBeer function
    $scope.deleteBeer = function(id) {
    	//console.log("delete called");
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

    
    // AddBeer function - add the beer from the form input
    $scope.addBeer = function() {
    	//console.log("addbeer called");
        var beer = $scope.beer;        
        $http.post('/beers', beer, {
            headers: {
                'Content-Type': 'application/json;'
            }
        }).success(function (data, status, headers, config) {            
            	console.log(data);
            	$location.path('/beers')
                $scope.errorMessage = null;
           
        }).error(function (data, status, headers, config) {
        	console.log('Error: ' + data);
        });
    };
    
    
    //Random beer function - get a random id from the current list of beer and retrieve the record using GET request
    $scope.randomBeer = function(){   	
    	//console.log($scope.beers.length);
    	var randomId = $scope.beers[Math.floor(Math.random()*$scope.beers.length)];
    	
    	$http.get('/beers/'+ randomId.id)
    	.success(function (data, status, headers, config) {
            $scope.beer = data;            
        	
        }).error(function (data, status, headers, config) {
            $scope.errorMessage = "Beer not found";
        });        
    	
    	
    };
});