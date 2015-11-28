'use strict';

/**
 * @ngdoc function
 * @name templateAdminApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the templateAdminApp
 */
angular.module($snaphy.getModuleName())
  .controller('bodyCtrl', ['$scope', '$window', function($scope, $window){
    //Set the default true value..
    $scope.defaultTemplate = true;

    $scope.templateEnabled = function(){
    	$scope.defaultTemplate = $window.$snaphy.template;
    	return $scope.defaultTemplate ;
    }

  }]); //controller..