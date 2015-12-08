'use strict';
/*global $snaphy, angular*/
angular.module($snaphy.getModuleName())

//Controller for automataControl ..
.controller('automataControl', ['$scope', '$stateParams', 'Database',
    function($scope, $stateParams, Database) {
        //Checking if default templating feature is enabled..
        var defaultTemplate = $snaphy.loadSettings('automata', "defaultTemplate");
        $snaphy.setDefaultTemplate(defaultTemplate);


    }//controller function..
]);