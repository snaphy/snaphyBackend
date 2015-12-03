'use strict';
/*global angular, $snaphy, $scope, $stateParams */

angular.module($snaphy.getModuleName())
.controller('loginControl', ['$scope', 'Database', '$location', 'LoginServices', '$injector',
    function($scope, Database, $location, LoginServices, $injector) {
        //Adding title and name..
        $scope.name = $snaphy.loadSettings('login', 'loginName');
        $scope.title = $snaphy.loadSettings('login', 'loginTitle');

        //Controller defined here..
        $snaphy.setDefaultTemplate(false);
        var UserService = Database.getDb('login', 'User');
        $scope.credentials = {};
        $scope.loginError = false;

        $scope.login = function(loginForm){
            if(loginForm.$valid){
                //Now login to the employee ..
                UserService.login($scope.credentials, function(userDetail){
                    $scope.loginError = false;
                    console.log(userDetail.user);
                    //Add user detail to the database..
                    LoginServices.addUserDetail(userDetail.user);
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