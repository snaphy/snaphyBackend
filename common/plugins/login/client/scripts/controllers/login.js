'use strict';
/*global angular, $snaphy, $scope, $stateParams */

angular.module($snaphy.getModuleName())

.controller('loginControl', ['$scope', 'Database', '$location', 'LoginServices', '$injector',
    function($scope, Database, $location, LoginServices, $injector) {
        //Adding title and name..
        $scope.name = $snaphy.loadSettings('login', 'loginName');
        $scope.title = $snaphy.loadSettings('login', 'loginTitle');
        $scope.loginState        = $snaphy.loadSettings('login', "loginState");
        $scope.registerState     = $snaphy.loadSettings('login', "registerState");
        $scope.forgotPassState   = $snaphy.loadSettings('login', "forgotPassState");

        var defaultTemplate = $snaphy.loadSettings('login', "defaultTemplate");
        $snaphy.setDefaultTemplate(defaultTemplate);

        var UserService = Database.getDb('login', 'User');
        $scope.credentials = {};
        $scope.loginError = false;

        function disableButton(){
            $scope.isClickEnabled = false;
        }

        function enableButton(){
            $scope.isClickEnabled = true;
        }
        //Enable the login button at first..
        enableButton();
        $scope.login = function(loginForm){
            if(loginForm.$valid){
                disableButton();
                //Now login to the employee ..
                UserService.login($scope.credentials, function(userDetail){
                    enableButton();
                    $scope.loginError = false;
                    console.log(userDetail.user);
                    //Add user detail to the database..
                    LoginServices.addUserDetail(userDetail.user);
                    //If redirected from 401 error..
                    if($location.nextAfterLogin){
                        $location.path($location.nextAfterLogin);
                        $location.nextAfterLogin = null;
                    }else{
                        var $state = $injector.get('$state');
                        //Redirect to the default State..
                        $state.go(LoginServices.redirectOtherWise);
                    }
                },function(){
                    enableButton();
                    $scope.errorMsg = "Please login by providing correct username and password.";
                    //Display login error..
                    $scope.loginError = true;
                    console.error("Error getting logged in.");
                });

            }//if valid

        }; //login function

    }//controller function..
]);