'use strict';
/*global angular, $snaphy, jQuery, BaseTableDatatables*/

angular.module($snaphy.getModuleName())


.directive('snaphyLoadDatatable', ['$timeout', function ($timeout) {
    return {
        restrict: 'A',
        compile: function(){
            // Compile code goes here.
            return {
                post: function postLink( ) {
                    // Post-link code goes here
                    $timeout(function(){
                        // Initialize when page loads
                        jQuery(function(){ BaseTableDatatables.init(); });
                    }); //timeout method..
                }
            };
        },
        link: function () {
            /*Methods moved to compile for one time call only..*/
        }//End of Link function...
    }; // End of return
}])




.directive('snaphyLoadFilters', ['$timeout', function ($timeout) {
    return {
        restrict: 'A',
        link: function () {

            $timeout(function(){
                $(function () {
                    // Init page helpers (BS Datepicker + BS Colorpicker + Select2 + Masked Input + Tags Inputs plugins)
                    App.initHelpers(['datepicker',  'select2']);
                });
            }); //timeout method..
        }//End of Link function...
    }; // End of return
}]);