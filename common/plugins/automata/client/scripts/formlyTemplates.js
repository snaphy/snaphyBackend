(function(){'use strict';})();
/*global angular, $snaphy, $*/

angular.module($snaphy.getModuleName())

/**
 * Defigning templates for automata plugin by angular formly.
 * @param  {[type]} ['formlyConfig' [description]
 * @param  {[type]} function        (formlyConfig [description]
 * @return {[type]}                 [description]
 */
.run(['formlyConfig', function (formlyConfig)  {
    formlyConfig.setType({
        name: 'thead',
        template:
        '<tr>'+
            '<th  ng-repeat="header in model[options.key]">{{header}}</th>'+
            '<th class="text-center" style="width: 10%;">Actions</th>'+
        '</tr>'
    });

    formlyConfig.setType({
      name: 'stringRow',
      templateUrl: '/automata/views/tableBody.html'
    });
}]);
