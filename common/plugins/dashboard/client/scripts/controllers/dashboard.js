'use strict';

angular.module($snaphy.getModuleName())
//Controller for dashboardControl ..
.controller('dashboardControl', ['$scope', '$stateParams','Database', 'Resource',
    function($scope, $stateParams, Database, Resource) {
        //Set snaphy default template value to true..
        $snaphy.setDefaultTemplate(true);
        //Adding the login state from the login plugins..
        $scope.loginState  = $snaphy.loadSettings('login', "loginState");
        $scope.homeState   = $snaphy.loadSettings('dashboard', "homeState");
        //Load all the databases list..
        $scope.databasesList = $snaphy.loadSettings('robustAutomata', "loadDatabases");

        $scope.schemaArray = [];
        var dataFetched = false;
        //Load the constructor ...for dashboard..
        var init = function(){

        };


        var getDatabase = function(databaseName) {
            $scope.isLoading = true;
            //First get the schema..
            Resource.getSchema(databaseName,function (schema) {
                //Populate the schema..
                $scope.schemaArray.push(schema);
            }, function (httpResp) {
                console.error(httpResp);
            });
        };


    }//controller function..
]);