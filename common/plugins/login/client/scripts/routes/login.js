(function(){'use strict';})();
/*jslint browser: true*/
/*global $, jQuery, $snaphy, angular, browser, console*/

/**
 * JUST CHANGE THIS REDIRECT TO CHANGE THE DEFAULT REDIRECT.
 * @type {string}
 */
var redirectOtherWise = $snaphy.loadSettings('login', 'onLoginRedirectState');
var notPermittedState = $snaphy.loadSettings('login', '403ErrorPageState');
var loginState        = $snaphy.loadSettings('login', "loginState");
var registerState     = $snaphy.loadSettings('login', "registerState");
var forgotPassState   = $snaphy.loadSettings('login', "forgotPassState");
var adminRole         = $snaphy.loadSettings('login', "adminRole");
var employeeRole      = $snaphy.loadSettings('login', "employeeRole");

angular.module($snaphy.getModuleName())

    /**
     Employee Role
     */
    .run(['Permission', 'LoginServices', '$q', '$rootScope', function (Permission, LoginServices,  $q, $rootScope)  {
        //Define admin role with promise..
        //For more info https://github.com/Narzerus/angular-permission
        Permission.defineRole(employeeRole, function (stateParams) {
            //using promise..
            var deferred = $q.defer();
            LoginServices.authenticatePage(function(){
                deferred.resolve();
            },function(){
                console.log('Failure getting authorization');
                deferred.reject();
            });
            return deferred.promise;
        }); // END Permission

        //TODO Add admin role later..
        Permission.defineRole(adminRole, function (stateParams) {
            //using promise..
            var deferred = $q.defer();
            LoginServices.isAdmin(function(){
                deferred.resolve();
            },function(){
                console.log('Failure getting authorization');
                deferred.reject();
            });
            return deferred.promise;
        }); // END Permission


        //Now storing previous state parameters..
        $rootScope.$on('$stateChangeSuccess', function (ev, to, toParams, from, fromParams) {
            //assign the "from" parameter to something
            console.log("Changing state from " + from.name);
            //Now storing the previously accesed paths..
            $rootScope.previousState = from;
            $rootScope.currentState = to;
        });

    }]) //End Run



    //Routes are defined using ui.routes
    .config(['$locationProvider', '$stateProvider', '$urlRouterProvider', '$injector', '$httpProvider',
        function ($locationProvider, $stateProvider, $urlRouterProvider, $injector, $httpProvider) {
        $locationProvider.html5Mode(false);



        //https://github.com/Narzerus/angular-permission
        $urlRouterProvider.otherwise( function($injector) {
            var $state = $injector.get("$state");
            $state.go(redirectOtherWise);
        });



        $stateProvider
            //Provide routes in this way..
            .state(loginState, {
                url: '/login',
                templateUrl: '/login/views/login.html',
                controller: 'loginControl',
                //Only allow anonym users here
                data: {
                    permissions: {
                        except: [employeeRole],
                        redirectTo: redirectOtherWise
                    }
                }
            })


            //Provide routes in this way..
            .state(registerState, {
                url: '/register',
                templateUrl: '/login/views/register.html',
                controller: 'registerControl',
                //Only allow anonym users here
                data: {
                    permissions: {
                        only: [adminRole],
                        redirectTo: notPermittedState
                    }
                }
            })


            //Provide routes in this way..
            .state(forgotPassState, {
                url: '/forgotPass',
                templateUrl: '/login/views/forgotPass.html',
                controller: 'forgotPassControl',
                //Only allow anonym users here
                data: {
                    permissions: {
                        except: [employeeRole],
                        redirectTo: redirectOtherWise
                    }
                }
            });


        //interceptors area..
        //http://stackoverflow.com/questions/25876559/loopback-protected-routes-ensure-login
        $httpProvider.interceptors.push(['$q', 'LoopBackAuth', '$injector',
            function ($q, LoopBackAuth, $injector) {
                return {
                    responseError: function (rejection) {
                        if (rejection.status === 401) {
                            console.log("Got 401 error");
                            //Now clearing the loopback values..
                            LoopBackAuth.clearUser();
                            LoopBackAuth.clearStorage();
                            //$location.nextAfterLogin = $location.path();
                            //Storing the state..

                            var $state = $injector.get("$state");
                            $state.go(loginState);
                        }
                        return $q.reject(rejection);
                    }
                };
            }]);


    }]); //config
