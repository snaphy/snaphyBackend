'use strict';
/*jslint browser: true*/
/*global $, jQuery, $snaphy, angular*/
angular.module($snaphy.getModuleName())
  //Routes are defined using ui.routes 
  .config(['$locationProvider', '$stateProvider',
    function ($locationProvider, $stateProvider) {
      $locationProvider.html5Mode(false);
        //Adding the login state from the login plugins..
        var loginState    = $snaphy.loadSettings('login', "loginState"),
        homeState         = $snaphy.loadSettings('dashboard', "homeState"),
        adminRole         = $snaphy.loadSettings('login', "adminRole"),
        employeeRole      = $snaphy.loadSettings('login', "employeeRole");

        $stateProvider
        //Provide routes in this way..
        .state(homeState, {
          url: '/',
          templateUrl: '/dashboard/views/dashboard.html',
          controller: 'dashboardControl',
            data: {
                permissions: {
                    only: [employeeRole],
                    redirectTo: loginState
                }
            }
        });

    }]); //config
