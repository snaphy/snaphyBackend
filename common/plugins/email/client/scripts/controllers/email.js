'use strict';
/*global angular, $snaphy, $*/
angular.module($snaphy.getModuleName())

//Controller for emailControl ..
.controller('emailControl', ['$scope', '$stateParams', 'Database',
    function($scope, $stateParams, Database) {
        //Controller defined here..

        $snaphy.setDefaultTemplate(true);

        $scope.emailState  = $snaphy.loadSettings('email', "emailState");

        //Use Database.getDb(pluginName, PluginDatabaseName) to get the Database Resource.
        //
    } //controller function..
]);
