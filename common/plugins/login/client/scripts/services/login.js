'use strict';
/*jslint browser: true*/
/*global $, jQuery, angular, $snaphy , redirectOtherWise*/

var loginState        = $snaphy.loadSettings('login', "loginState");
var registerState     = $snaphy.loadSettings('login', "registerState");
var forgotPassState   = $snaphy.loadSettings('login', "forgotPassState");


angular.module($snaphy.getModuleName())
    //Define your services here..
    //Service for implementing login related functionality..
    .factory('LoginServices', ['Database', '$location', 'LoopBackAuth', '$injector',
        function(Database, $location, LoopBackAuth, $injector) {
            //Set redirect otherwise state name..
            //First use the value from the route/login global routeOtherWise value ....
            var redirectOtherWise_ = redirectOtherWise || 'dashboard';

            //get the user service..
            var UserService = Database.getDb('login', 'User'),
            //UserDetail is an object will contain the current logged user info.
            userDetail = null;

            /**
             * Method for checking if page is authenticated or not. Fetch the current user info if user is authenticated.
             * @param success
             * @param error
             */
            var authenticatePage = function(success, error) {
                if (!UserService.isAuthenticated()) {
                    //Calling the promise error..
                    //$location.nextAfterLogin = $location.path();
                    error();
                } else {
                    success();
                    console.log("Checking for logged confirmation.");
                    //Will send an 401  error..already..
                    getLoggedDetails();
                }

            };

            /**
             * Method to check if the user is admin or not
             * @param success
             * @param error
             */
            var isAdmin = function(success, error){
                UserService.isAdmin(function(value){
                    if(value.isAdmin){
                        //Current user is admin user..
                        success();
                    }else{
                        //Current user is not admin user..
                        error();
                    }
                }, function(){
                    console.log("Error checking isAdmin method");
                    error();
                });
            };


            var addUserDetail = function(user){
                userDetail = user;
            };



            //For adding an employee..
            var register = function(username, email, password, success, faliure){
                UserService.create({}, {username: username, email: email, password: password}, function(value){
                    success(value);
                }, function(RespHeader){
                    faliure(RespHeader);
                });
            };


            /**
             * For getting the current logged user details from the server.
             * @param success
             * @param error
             */
            var getLoggedDetails = function() {
                UserService.getCurrent(function(user){
                    //Adding user detail to userService..
                    userDetail = user;
                }, function(){
                    console.error("401 error occured. User login expired!");
                });
            };



            /**
             * For logging out
             */
            var logout = function() {
                UserService.logout(
                    //Successs
                    function() {
                        var $state = $injector.get("$state");
                        $state.go(loginState);
                    },

                    //Error..
                    function() {
                        //Now clearing the loopback auth values..
                        LoopBackAuth.clearUser();
                        LoopBackAuth.clearStorage();
                    });
            };



            return {
                authenticatePage: authenticatePage,
                getLoggedDetails: getLoggedDetails,
                logout: logout,
                userDetail: userDetail,
                redirectOtherWise: redirectOtherWise_,
                isAdmin: isAdmin,
                addUserDetail: addUserDetail,
                register: register
            };
        }//LoginServices
    ]);

