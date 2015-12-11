/**
 * Created by robins on 12/12/15.
 */
angular.module($snaphy.getModuleName())

    /**
     Defigning templated for angular-formly.
     */
    .run(['formlyConfig', function (formlyConfig)  {
        formlyConfig.setType({
            name: 'input',
            template:
                    '<div class="form-material floating" ng-class="options.templateOptions.color">'+
                        '<input class="form-control"   ng-model="model[options.key]">'+
                            '<label>{{options.templateOptions.label}}</label>'+
                    '</div>'
        });

        formlyConfig.setType({
            name: 'textarea',
            template:
            '<div class="form-material floating" ng-class="options.templateOptions.color">'+
                '<textarea class="form-control" rows="{{options.templateOptions.row}}"></textarea>'+
                '<label for="material-textarea-small2">{{options.templateOptions.label}}</label>'+
            '</div>',
            controller: function($scope) {
                //Set default value for label..
                if($scope.options.templateOptions.row === undefined){
                    $scope.options.templateOptions.row = 3;
                }
            }
        });


        formlyConfig.setType({
            name: 'select',
            template:
            '<div class="form-material floating">'+
                '<select ng-model="model[options.key]" class="form-control"  size="{{options.templateOptions.size}}">'+
                    '<option value="{{option.id}}" ng-repeat="option in options.templateOptions.options">{{option.name}}</option>'+
                '</select>'+
                '<label>{{options.templateOptions.label}}</label>'+
            '</div>',
            controller: function($scope, $http) {
                //Set default value for label..
                if($scope.options.templateOptions.size === undefined){
                    $scope.options.templateOptions.size = 1;
                }


                if($scope.options.templateOptions.get !== undefined){
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

            }
        });

    }]);//End Run