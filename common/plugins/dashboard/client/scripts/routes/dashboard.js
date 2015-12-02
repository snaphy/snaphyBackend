'use strict';
/*jslint browser: true*/
/*global $, jQuery, $snaphy, angular*/
angular.module($snaphy.getModuleName())
  //Routes are defined using ui.routes 
  .config(['$locationProvider', '$stateProvider',
    function ($locationProvider, $stateProvider) {
      $locationProvider.html5Mode(false);

      $stateProvider
        //Provide routes in this way..
        .state('dashboard', {
          url: '/',
          templateUrl: '/dashboard/views/dashboard.html',
          controller: 'dashboardControl',
            data: {
                permissions: {
                    only: ['employee'],
                    redirectTo: 'login'
                }
            }
        });

    }]); //config
