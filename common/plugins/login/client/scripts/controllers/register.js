'use strict';

angular.module($snaphy.getModuleName())

//Controller for registerControl ..
.controller('registerControl', ['$scope', '$stateParams',
    function($scope, $stateParams) {
        //Controller defined here..
        $snaphy.setDefaultTemplate(false);
        //Adding title and name..
        $scope.name = $snaphy.loadSettings('login', 'loginName');
        $scope.title = $snaphy.loadSettings('login', 'registerTitle');

    }//controller function..
]);