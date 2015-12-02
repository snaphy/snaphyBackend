'use strict';
/*global angular, $snaphy, $scope, $stateParams */

angular.module($snaphy.getModuleName())
.controller('loginControl', ['$scope', 'Database', '$location', 'LoginServices', '$injector',
    function($scope, Database, $location, LoginServices, $injector) {
        //Controller defined here..
        $snaphy.setDefaultTemplate(false);
        var UserService = Database.getDb('login', 'User');
        $scope.credentials = {};

        $scope.login = function(){
            //Now login to the employee ..
            UserService.login($scope.credentials, function(){
                //If redirected from 401 error..
                if($location.nextAfterLogin){
                    $location.path('/');
                    $location.nextAfterLogin = null;
                }else{
                    var $state = $injector.get('$state');
                    //Redirect to the default State..
                    $state.go(LoginServices.redirectOtherWise);
                }
            },function(){
                //TODO SHOW LOGIN FAILURE ON CONSOLE..
                console.error("Error getting logged in.");
            });
        };

    }//controller function..
]);