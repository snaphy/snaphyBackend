(function(){'use strict';})();
/*global angular, $snaphy, $*/

angular.module($snaphy.getModuleName())

/**
 Defigning custom templates for angular-formly.
 */
.run(['formlyConfig', '$timeout', function (formlyConfig, $timeout)  {

    formlyConfig.setType({
        name: 'belongsTo',
        templateUrl: '/formlyTemplate/views/autocomplete.html',
        link: function(scope, element, attrs) {


        },//link function..
        controller: function($scope) {
            $scope.resetCreate   = resetCreate;
            $scope.showCreate = function(){
                //model has value then put create == true
                var containValue = $.isEmptyObject($scope.model[$scope.options.key]);
                if(containValue){
                    //put $scope.create == false;
                    $scope.create = false;
                }
                else{
                    $scope.create = true;
                }
                return $scope.create;
            };

            function resetCreate(){
                $timeout(function(){
                    $scope.model[$scope.options.key] = {};
                },0);
            }

            $scope.forceDisplay = function(){
                //Just add a dummy property.
                if($scope.to.fields.length){
                    $timeout(function(){
                        $scope.model[$scope.options.key] = {};
                        $scope.model[$scope.options.key][$scope.to.fields[0].key] = "";
                    },0);

                }
            };

        }
    });


}]);
