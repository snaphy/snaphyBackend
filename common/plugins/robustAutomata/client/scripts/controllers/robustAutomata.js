'use strict';

angular.module($snaphy.getModuleName())

//Controller for robustAutomataControl ..
.controller('robustAutomataControl', ['$scope', '$stateParams', 'Database', 'Resource',
    function($scope, $stateParams, Database, Resource) {
        //Checking if default templating feature is enabled..
        var defaultTemplate = $snaphy.loadSettings('robustAutomata', "defaultTemplate");
        $snaphy.setDefaultTemplate(defaultTemplate);
        //Use Database.getDb(pluginName, PluginDatabaseName) to get the Database Resource.

        var ctrl = $scope;

        $scope.displayed = [];

        $scope.callServer = function callServer(tableState) {

            $scope.isLoading = true;

            var pagination = tableState.pagination;

            var start = pagination.start || 0; // This is NOT the page number, but the index of item in the list that you want to use to display the table.
            var number = pagination.number || 10; // Number of entries showed per page.

            Resource.getPage(start, number, tableState).then(function(result) {
                
                $scope.displayed = result.data;
                tableState.pagination.numberOfPages = result.numberOfPages; //set the number of pages so the pagination can update
                $scope.isLoading = false;
            });
        };
    } //controller function..
]);
