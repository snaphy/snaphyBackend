'use strict';
/*jslint browser: true*/
/*global $, jQuery, $snaphy, angular*/
angular.module($snaphy.getModuleName())

    /*Defining Employee Role */
    .run(['Permission', 'LoginServices', '$q', function (Permission, LoginServices,  $q)  {
        //Define admin role with promise..
        //For more info https://github.com/Narzerus/angular-permission
        Permission.defineRole('employee', function (stateParams) {
            //using promise..
            var deferred = $q.defer();
            LoginServices.authenticatePage(function(userValues){
                //Adding userValues..
                LoginServices.userDetail = userValues;
                console.log('Welcome authenticated successfully\n');
                deferred.resolve();
            },function(){
                console.log('Faliure getting authorization in Employee role resolve');
                deferred.reject();
            });
            return deferred.promise;
        }); // END Permission


        //Defining Admin role..
        Permission.defineRole('admin', function (stateParams) {
            //using promise..
            var deferred = $q.defer();
            LoginServices.authenticatePage(function(userValues){
                if(userValues.admin){
                    console.log('Welcome Admin authenticated successfully\n');
                    deferred.resolve();
                }
                else{
                    deferred.reject();
                }
            },function(){
                console.log('Faliure getting authorization');
                deferred.reject();
            });
            return deferred.promise;
        }); // END Permission
    }]) //End Run



    //Routes are defined using ui.routes
    .config(['$locationProvider', '$stateProvider', '$urlRouterProvider', '$injector', '$httpProvider',
        function ($locationProvider, $stateProvider, $urlRouterProvider, $injector, $httpProvider) {
        $locationProvider.html5Mode(false);
        //https://github.com/Narzerus/angular-permission
        $urlRouterProvider.otherwise( function($injector) {
            var $state = $injector.get("$state");
            $state.go('/');
        });


        $stateProvider
            //Provide routes in this way..
            .state('login', {
                url: '/login',
                templateUrl: '/login/views/login.html',
                controller: 'loginControl',
                //Only allow anonym users here
                data: {
                    permissions: {
                        except: ['employee'],
                        redirectTo: '/'
                    }
                }
            })


            //Provide routes in this way..
            .state('register', {
                url: '/register',
                templateUrl: '/login/views/register.html',
                controller: 'registerControl',
                //Only allow anonym users here
                data: {
                    permissions: {
                        except: ['employee'],
                        redirectTo: '/'
                    }
                }
            })


            //Provide routes in this way..
            .state('forgotPass', {
                url: '/forgotPass',
                templateUrl: '/login/views/forgotPass.html',
                controller: 'forgotPassControl',
                //Only allow anonym users here
                data: {
                    permissions: {
                        except: ['employee'],
                        redirectTo: '/'
                    }
                }
            });


        //interceptors area..
        //http://stackoverflow.com/questions/25876559/loopback-protected-routes-ensure-login
        $httpProvider.interceptors.push(['$q', '$location', 'LoopBackAuth',
            function ($q, $location, LoopBackAuth) {
                return {
                    responseError: function (rejection) {
                        if (rejection.status === 401) {
                            //Now clearing the loopback values..
                            LoopBackAuth.clearUser();
                            LoopBackAuth.clearStorage();
                            $location.nextAfterLogin = $location.path();
                            $location.path('/login');
                        }
                        return $q.reject(rejection);
                    }
                };
            }]);


    }]); //config
