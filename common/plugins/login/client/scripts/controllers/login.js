'use strict';
/*global angular, $snaphy, $scope, $stateParams */

angular.module($snaphy.getModuleName())

.controller('loginControl', ['$scope', 'Database', '$rootScope', 'LoginServices', '$injector',
    function($scope, Database, $rootScope, LoginServices, $injector) {
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
            if(!loginForm.validate()){
                $scope.errorMsg = "Please login by providing the correct data.";
                //Display login error..
                $scope.loginError = true;
                return null;
            }
            if(loginForm.$valid){
                disableButton();
                //Now login to the employee ..
                UserService.login($scope.credentials, function(userDetail){
                    enableButton();
                    $scope.loginError = false;
                    //Add user detail to the database..
                    LoginServices.addUserDetail(userDetail.user);
                    var $state = $injector.get('$state'),
                    redirectTo =  $rootScope.previousState.name ?  $rootScope.previousState.name :  LoginServices.redirectOtherWise;
                    //Redirect to the default State..
                    $state.go(redirectTo);

                },function(){
                    enableButton();
                    $scope.errorMsg = "Please login by providing correct username and password.";
                    //Display login error..
                    $scope.loginError = true;
                });

            }//if valid

        }; //login function


        $scope.validateForm = {
              "rules":{
                  'login-username': {
                      required: true,
                      minlength: 3
                  },
                  'login-password': {
                      required: true,
                      minlength: 5
                  }
              },
              "messages":{
                  'login-username': {
                      required: 'Please enter a username',
                      minlength: 'Your username must consist of at least 3 characters'
                  },
                  'login-password': {
                      required: 'Please provide a password',
                      minlength: 'Your password must be at least 5 characters long'
                  }
              }
          };

    }//controller function..
]);
