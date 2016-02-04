(function(){
    'use strict';
})();

/*global angular, $, CKEDITOR, App */
angular.module($snaphy.getModuleName())



.directive('snaphyCkEditor', ['$timeout', function($timeout) {
    return {
        restrict: 'A',
        link: function(scope, iElement, iAttrs) {

                scope.getHtmlData = function(){
                    return CKEDITOR.instances[iAttrs.id].getData();
                };

                $timeout(function(){
                    CKEDITOR.disableAutoInline = true;
                    CKEDITOR.replace(iAttrs.id);

                }); //timeout method..

            } //End of Link function...
    }; // End of return
}])


.directive('snaphyCheckedList', ['$timeout', function($timeout){
    return {
        restrict: 'A',
        link: function(scope, iElement, iAttrs){
            $timeout(function(){
                // Init page helpers (Table Tools helper)
                App.initHelpers('table-tools');
            });
        }//End of the link function..
    };
}]);
