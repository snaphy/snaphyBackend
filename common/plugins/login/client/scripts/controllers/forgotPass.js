'use strict';

angular.module($snaphy.getModuleName())

//Controller for forgotPass ..
.controller('forgotPassControl', ['$scope', '$stateParams', 'Database',
    function($scope, $stateParams, Database) {
        //Controller defined here..
        $snaphy.setDefaultTemplate(false);
        $scope.loginState        = $snaphy.loadSettings('login', "loginState");
        $scope.registerState     = $snaphy.loadSettings('login', "registerState");
        $scope.forgotPassState   = $snaphy.loadSettings('login', "forgotPassState");
        $scope.name              = $snaphy.loadSettings('login', 'loginName');
        $scope.title             = $snaphy.loadSettings('login', 'forgotPasswordTitle');
    }//controller function..
]);