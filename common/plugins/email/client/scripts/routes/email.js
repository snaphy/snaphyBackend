'use strict';
/*global angular, $snaphy, $*/
angular.module($snaphy.getModuleName())
    //Routes are defined using ui.routes
    .config(['$locationProvider', '$stateProvider', '$urlRouterProvider',
        function($locationProvider, $stateProvider, $urlRouterProvider) {
            $locationProvider.html5Mode(false);
            //$urlRouterProvider.otherwise('/');
            //get the email state name
            var emailState  = $snaphy.loadSettings('email', "emailState");
            $stateProvider
            //Provide routes in this way..
                .state(emailState, {
                url: '/email',
                templateUrl: '/email/views/email.html',
                controller: 'emailControl'
            });

        }
    ]); //config
