'use strict';
/*global angular, $snaphy, $scope, $stateParams */

angular.module($snaphy.getModuleName())
.controller('loginControl', ['$scope', 'Database', '$location', 'LoginServices', '$injector',
    function($scope, Database, $location, LoginServices, $injector) {
        //Controller defined here..
        $snaphy.setDefaultTemplate(false);
        var UserService = Database.getDb('login', 'User');
        $scope.credentials = {};
        $scope.loginError = false;

        $scope.login = function(loginForm){
            if(loginForm.$valid){
                //Now login to the employee ..
                UserService.login($scope.credentials, function(){
                    $scope.loginError = false;
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
                    //Display login error..
                    $scope.loginError = true;
                    console.error("Error getting logged in.");
                });
            }//if valid

        }; //login function

    }//controller function..
]);