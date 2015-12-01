'use strict';
/*global angular, $snaphy, $scope, $stateParams */

angular.module($snaphy.getModuleName())
.controller('loginControl', ['$scope', 'Database',
    function($scope, Database) {
        //Controller defined here..
        $snaphy.template = false;
        var userService = Database.getDb('login', 'User');
        

    }//controller function..
]);