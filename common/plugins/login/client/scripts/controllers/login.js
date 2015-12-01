'use strict';
/*global angular, $snaphy, $scope, $stateParams */

angular.module($snaphy.getModuleName())
.controller('loginControl', ['$scope', 'Database', '$location',
    function($scope, Database, $location) {
        //Controller defined here..
        $snaphy.template = false;
        var UserService = Database.getDb('login', 'User');

        $scope.credentials = {};

        $scope.login = function(credentials){
            //Now login to the employee ..
            UserService.login($scope.credentials, function(values){
                console.log("Loggenin Redirecting");
                //Redirect to dashboard otherwise..
                var redirect = $location.nextAfterLogin || '/';
                console.log()
                $location.path(redirect);
                console.log("Successfully Logged in.");
            },function(respHeader){
                //TODO SHOW LOGIN FALIURE ON CONSOLE..
                console.error("Error getting logged in.");
            });
        };

        

    }//controller function..
]);