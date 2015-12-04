'use strict';

angular.module($snaphy.getModuleName())

//Controller for registerControl ..
.controller('registerControl', ['$scope', 'LoginServices', '$state',
    function($scope, LoginServices, $state) {
        //Controller defined here..
        $snaphy.setDefaultTemplate(false);
        //LOADING THE SETTINGS..
        $scope.name              = $snaphy.loadSettings('login', 'loginName');
        $scope.title             = $snaphy.loadSettings('login', 'registerTitle');
        $scope.homeState         = $snaphy.loadSettings('login', 'onLoginRedirectState');
        $scope.loginState        = $snaphy.loadSettings('login', "loginState");
        $scope.registerState     = $snaphy.loadSettings('login', "registerState");
        $scope.forgotPassState   = $snaphy.loadSettings('login', "forgotPassState");


        //Go back to home state..
        $scope.home = function(){
            $state.go($scope.homeState);
        };

        $scope.registerError = false;
        $scope.register =function(registerForm){
            if(registerForm.$valid) {
                LoginServices.register($scope.username, $scope.email, $scope.password, function (values) {
                    $scope.registerError = false;
                    console.log("User created successfully");
                }, function (respHeader) {
                    //Show the error message..
                    $scope.errorMsg = 'Oops, please register by providing valid username and email!';
                    //Show error dialog..
                    $scope.registerError = true;
                    console.error(respHeader);
                });

            }//if
        };


    }//controller function..
]);