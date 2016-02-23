(function() {
    'use strict';
})();
/*global angular, $snaphy, $*/

angular.module($snaphy.getModuleName())

/**
 Defigning templated for angular-formly.
 */
.run(['formlyConfig', function(formlyConfig, SnaphyValidate) {
    formlyConfig.setType({
        name: 'input',
        template: '<div  class="form-group">' +
            '<div  ng-class="[options.templateOptions.colSize, options.templateOptions.color]">' +
            '<div class="form-material" ng-class="options.templateOptions.color">' +
            '<input  class="form-control" type="{{options.templateOptions.type}}"  ng-class="options.templateOptions.class" name="{{options.templateOptions.id}}" id="{{options.templateOptions.id}}" ng-model="model[options.key]">' +
            '<label for="{{options.templateOptions.id}}">{{options.templateOptions.label}}</label>' +
            '</div>' +
            '</div>' +
            '</div>',

        link: function(scope, element, attrs) {
                // ID PROPERTY IS NEEDED FOR VALIDATE TO WORK
                if (scope.options.templateOptions) {
                    if (!scope.options.templateOptions.colSize) {
                        scope.options.templateOptions.colSize = 'col-xs-12';
                    }
                } //if
            } //link function..
    });



    formlyConfig.setType({
        name: 'textarea',
        template: '<div class="form-group">' +
            '<div ng-class="options.templateOptions.colSize">' +
            '<div class="form-material" ng-class="options.templateOptions.color">' +
            '<textarea type="{{options.templateOptions.type}}" name="{{options.templateOptions.id}}" id="{{options.templateOptions.id}}" ng-class="options.templateOptions.class" class="form-control" ng-model="model[options.key]" rows="{{options.templateOptions.row}}"></textarea>' +
            '<label for="{{options.templateOptions.id}}">{{options.templateOptions.label}}</label>' +
            '</div>' +
            '</div>' +
            '</div>',
        controller: function($scope) {
            //Set default value for label..
            if ($scope.options.templateOptions.row === undefined) {
                $scope.options.templateOptions.row = 3;
            }

            if ($scope.options.templateOptions.colSize === undefined) {
                $scope.options.templateOptions.colSize = "col-sm-12";
            }
        }
    });




    formlyConfig.setType({
        name: 'select',
        template: '<div class="form-group">' +
            '<div ng-class="options.templateOptions.colSize">' +
            '<div class="form-material" ng-class="options.templateOptions.color">' +
            '<select type="{{options.templateOptions.type}}" name="{{options.templateOptions.id}}" ng-class="options.templateOptions.class" id="{{options.templateOptions.id}}" ng-change="convertToString(model[options.key])" ng-model="model[options.key]" class="form-control"  size="{{options.templateOptions.size}}">' +
            '<option value=""></option>' +
            '<option value="{{option.id}}" ng-repeat="option in options.templateOptions.options">{{option.name}}</option>' +
            '</select>' +
            '<label for="{{options.templateOptions.id}}">{{options.templateOptions.label}}</label>' +
            '</div>' +
            '</div>' +
            '</div>',
        controller: function($scope, $http) {
            //Set default value for label..
            if ($scope.options.templateOptions.size === undefined) {
                $scope.options.templateOptions.size = 1;
            }

            if ($scope.options.templateOptions.colSize === undefined) {
                $scope.options.templateOptions.colSize = "col-sm-12";
            }


            if ($scope.options.templateOptions.get !== undefined) {
                //Run http to check the value..
                $http({
                    method: 'GET',
                    url: $scope.options.templateOptions.get
                }).then(function successCallback(response) {
                    //Select options downloaded successfully..
                    //Loading options..
                    $scope.options.templateOptions.options = response;
                }, function errorCallback(response) {
                    // called asynchronously if an error occurs
                    // or server returns response with an error status.
                    console.error(response);
                });
            }


            $scope.$watch("model[options.key]",
                function() {
                    if($scope.model[$scope.options.key] !== undefined){
                        //console.log($scope.model);
                        $scope.model[$scope.options.key] = $scope.model[$scope.options.key].toString();
                    }
                }
            );
        }
    });



    //For selecting string only .. previous for selecting object..
    formlyConfig.setType({
        name: 'selectString',
        template: '<div class="form-group">' +
            '<div ng-class="options.templateOptions.colSize">' +
            '<div class="form-material" ng-class="options.templateOptions.color">' +
            '<select type="{{options.templateOptions.type}}" name="{{options.templateOptions.id}}" ng-class="options.templateOptions.class" id="{{options.templateOptions.id}}"   ng-model="model[options.key]" class="form-control"  size="{{options.templateOptions.size}}">' +
            '<option value=""></option>' +
            '<option value="{{option}}" ng-repeat="option in options.templateOptions.options">{{option | uppercase}}</option>' +
            '</select>' +
            '<label for="{{options.templateOptions.id}}">{{options.templateOptions.label}}</label>' +
            '</div>' +
            '</div>' +
            '</div>',
        controller: function($scope, $http) {
            //Set default value for label..
            if ($scope.options.templateOptions.size === undefined) {
                $scope.options.templateOptions.size = 1;
            }

            if ($scope.options.templateOptions.colSize === undefined) {
                $scope.options.templateOptions.colSize = "col-sm-12";
            }


            if ($scope.options.templateOptions.get !== undefined) {
                //Run http to check the value..
                $http({
                    method: 'GET',
                    url: $scope.options.templateOptions.get
                }).then(function successCallback(response) {
                    //Select options downloaded successfully..
                    //Loading options..
                    $scope.options.templateOptions.options = response;
                }, function errorCallback(response) {
                    // called asynchronously if an error occurs
                    // or server returns response with an error status.
                    //console.error(response);
                });
            }

            $scope.$watch("model[options.key]",
                function() {
                    if($scope.model[$scope.options.key] !== undefined){
                        //console.log($scope.model);
                        $scope.model[$scope.options.key] = $scope.model[$scope.options.key].toString();
                    }
                }
            );
        }

    });

}]); //End Run
