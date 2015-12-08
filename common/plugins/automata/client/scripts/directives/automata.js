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
}])

/**
 * For mapping the table values..with desired property.
 */
    .directive('automataMapValue', [function () {
    return {
        restrict: 'A',
        scope:{
            modelProp    : "=modelProp",
            rowObject    : "=rowObject",
            columnHeader : "=columnHeader"
        },
        link: function (scope, element, attrs) {
            var colValue, keyName;
            if(scope.rowObject[scope.columnHeader] !== undefined){
                keyName = scope.columnHeader;
            }else{
                //Its a relational header properties name... map the header.. replace `customer_name` to name
                var patt = /^[A-Z0-9a-z]*\_/;
                keyName = scope.columnHeader.replace(patt, '');
            }
            colValue = scope.rowObject[keyName];

            //Now checking cheking the type of the value and returning the value according to it..
            var type = Object.prototype.toString.call(colValue);

            if(type === '[object String]'){
                //Do the string processing..
            }
            else if(type === '[object Number]'){
                //Do the number processing..
            }
            else if(type === '[object Array]'){
                //Do the number processing..
            }
            else {
                //The value is object..
            }

            var htmlFormat = function(){

            };



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