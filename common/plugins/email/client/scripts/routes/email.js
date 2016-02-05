'use strict';
/*global angular, $snaphy, $*/
angular.module($snaphy.getModuleName())
    // //Routes are defined using ui.routes
    // .config(['$locationProvider', '$stateProvider', '$urlRouterProvider',
    //     function($locationProvider, $stateProvider, $urlRouterProvider) {
    //         $locationProvider.html5Mode(false);
    //         //$urlRouterProvider.otherwise('/');
    //         //get the email state name
    //         var emailState  = $snaphy.loadSettings('email', "emailState");
    //         $stateProvider
    //         //Provide routes in this way..
    //             .state(emailState, {
    //             url: '/email',
    //             templateUrl: '/email/views/email.html',
    //             controller: 'emailControl'
    //         });
    //
    //     }
    // ]) //config



    //Create state to generate at runTime..
    .run(['runtimeStates', function(runtimeStates) {
        var employeeRole = $snaphy.loadSettings('login', "employeeRole");
        var redirectOtherWise = $snaphy.loadSettings('login', 'onLoginRedirectState');

        var emailModelList = $snaphy.loadSettings('email', "loadEmails");
        emailModelList.forEach(function(emailModel){
            var databasesList = emailModel.assosiatedUsers;

            //Loading states at run time.
            databasesList.forEach(function(stateObj) {
                //Add states at run time..
                runtimeStates.addState(emailModel.model + "__" + stateObj,  {
                    url: '/:emailModel/'  +  stateObj.toLowerCase().trim(),
                    templateUrl: '/email/views/email.html',
                    controller: 'emailControl',

                    //Only allow authenticated users here
                    data: {
                        permissions: {
                            only: [employeeRole],
                            redirectTo: redirectOtherWise
                        }
                    }
                });
            });
        });
    }]);
