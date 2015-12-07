'use strict';
/*global angular, $snaphy, jQuery, BaseTableDatatables*/

angular.module($snaphy.getModuleName())


    .directive('snaphyLoadDatatable', ['$timeout', function ($timeout) {
        return {
            restrict: 'A',
            link: function () {
               $timeout(function(){
                   // Initialize when page loads
                   jQuery(function(){ BaseTableDatatables.init(); });
               }); //timeout method..
            }//End of Link function...
        }; // End of return
    }]);