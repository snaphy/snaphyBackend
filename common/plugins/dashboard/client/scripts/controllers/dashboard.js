'use strict';

angular.module($snaphy.getModuleName())
//Controller for dashboardControl ..
.controller('dashboardControl', ['$scope', '$stateParams','Database',
    function($scope, $stateParams, Database) {
        //Set snaphy default template value to true..
        $snaphy.setDefaultTemplate(true);
        //Adding the login state from the login plugins..
        $scope.loginState  = $snaphy.loadSettings('login', "loginState");
        $scope.homeState   = $snaphy.loadSettings('dashboard', "homeState");
    }//controller function..
]);