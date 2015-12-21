(function(){'use strict';})();
/*global angular, $snaphy, $*/

angular.module($snaphy.getModuleName())

/**
 Defigning custom templates for angular-formly.
 */
.run(['formlyConfig', function (formlyConfig)  {

    formlyConfig.setType({
        name: 'belongsTo',
        templateUrl: '/formlyTemplate/views/autocomplete.html',
        link: function(scope, element, attrs) {
            // ID PROPERTY IS NEEDED FOR VALIDATE TO WORK
            if(scope.options.templateOptions){
                if(!scope.options.templateOptions.colSize){
                    scope.options.templateOptions.colSize = 'col-xs-12';
                }
            }//if

        

        }//link function..
    });


}]);
