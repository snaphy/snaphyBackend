'use strict';
/*jslint browser: true*/
/*global $, jQuery, angular, $snaphy*/

angular.module($snaphy.getModuleName())
//Define your services here..
    //Service for implementing login related functionality..
    .factory('LoginServices', ['Database', '$location', 'LoopBackAuth',
        function(Database, $location, LoopBackAuth) {

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
                    $location.nextAfterLogin = $location.path();
                    error();
                    //Store path info to Redirect back to it...
                    //$location.nextAfterLogin = globalServices.getNextAfterLoginPath();
                } else {
                    //Will send an 401  error..already..
                    getLoggedDetails(success, error);
                }

            };


            /**
             * For getting the current logged user details from the server.
             * @param success
             * @param error
             */
            var getLoggedDetails = function(success, error) {
                UserService.getCurrent(success, error);
            };

            /**
             * For logging out
             */
            var logout = function() {
                UserService.logout(
                    //Successs
                    function() {
                        //Now redirect to login page..
                        $location.path('/login');
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
                userDetail: userDetail
            };
        }//LoginServices
    ]);

