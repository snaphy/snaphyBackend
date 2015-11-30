'use strict';

angular.module($snaphy.getModuleName())
//Controller for dashboardControl ..
.controller('dashboardControl', ['$scope', '$stateParams','Database',
    function($scope, $stateParams, Database) {
        //Set snaphy default template value to true..
        $snaphy.template = true;
        //var employeeService = Database.getDb('login', 'User');
        //console.log(employeeService);
    }//controller function..
]);