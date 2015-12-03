'use strict';

angular.module($snaphy.getModuleName())


  .directive('snaphyLoadTemplate', [function () {
      return {
        restrict: 'A',
        link: function (scope, iElement, iAttrs) {
          setTimeout(function(){
              // Initialize app when page loads
              jQuery(function(){ App.init(); });
          },200);
        }
      };
    }]);
