'use strict';
/*global angular, $snaphy, $*/
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
    }])


  /*To hide the tooltip if somebody clickes it.*/
    .directive('snaphyOnClickHideToolTip', [function(){
        return{
          link: function(scope, iElement, iAttrs){
            //On click hide the  toolbar..
            $(iElement).click(function(){
                $(this).tooltip('hide');
            });
          }
        };
    }]);
