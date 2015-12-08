'use strict';
/*jslint browser: true*/
/*global $, jQuery, $snaphy, angular*/
var employeeRole      = $snaphy.loadSettings('login', "employeeRole");
var redirectOtherWise = $snaphy.loadSettings('login', 'onLoginRedirectState');
angular.module($snaphy.getModuleName())


  //Routes are defined using ui.routes 
  .config(['$locationProvider', '$stateProvider', '$urlRouterProvider',
    function ($locationProvider, $stateProvider, $urlRouterProvider) {
      $locationProvider.html5Mode(false);

      $stateProvider
        //Provide routes in this way..
        .state('automata', {
          url: '/automata',
          templateUrl: '/automata/views/automata.html',
          controller: 'automataControl',
            //Only allow anonym users here
            data: {
                permissions: {
                    only: [employeeRole],
                    redirectTo: redirectOtherWise
                }
            }
        });

    }]); //config

