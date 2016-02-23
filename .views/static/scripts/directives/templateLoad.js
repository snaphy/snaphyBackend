'use strict';
/*global angular, $snaphy, $, setTimeout, jQuery, App*/
angular.module($snaphy.getModuleName())


.directive('snaphyLoadTemplate', [function() {
    return {
        restrict: 'A',
        link: function(scope, iElement, iAttrs) {
            setTimeout(function() {
                // Initialize app when page loads
                jQuery(function() {
                    App.init();
                    App.layout('side_scroll_on');
                });

            }, 200);
        }
    };
}])


/*To hide the tooltip if somebody clickes it.*/
.directive('snaphyOnClickHideToolTip', [function() {
    return {
        link: function(scope, iElement, iAttrs) {
            //On click hide the  toolbar..
            $(iElement).click(function() {
                $(this).tooltip('hide');
            });
        }
    };
}])




/**
 *Directive for defining filters $multiSelect
 * */
.directive('snaphyDialog', ['$timeout', function($timeout) {
    //TODO table header data initialization bugs.. this filter must not proceed before table header initialization..
    return {
        restrict: 'E',
        scope: {
            "message": "@message",
            "tableTitle": "@tableTitle",
            "onNo": "&onCancel",
            "onYes": "&onConfirm",
            "showDialog": "=showDialog"
        },
        replace: true,
        template: '<div  class="modal fade" tabindex="-1"  role="dialog" aria-hidden="true">' +
            '<div class="modal-dialog modal-sm">' +
            '<div class="modal-content">' +
            '<div class="block block-themed block-transparent remove-margin-b">' +
            '<div class="block-header bg-primary-dark">' +
            '<ul class="block-options">' +
            '<li>' +
            '<button data-dismiss="modal" type="button"><i class="si si-close"></i></button>' +
            '</li>' +
            '</ul>' +
            '<h3 class="block-title">{{tableTitle}}</h3>' +
            '</div>' +
            '<div class="block-content block-content-narrow">' +
            '{{message}}' +
            '</div>' +
            '</div>' +
            '<div class="modal-footer">' +
            '<button data-dismiss="modal" class="btn btn-sm btn-default" type="button" >Cancel</button>' +
            '<button ng-click="onYes()"  class="btn btn-sm btn-danger" type="button"><i class="fa fa-check"></i> Confirm</button>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>',
        link: function(scope, iElement, iAttrs) {
                scope.$watch('showDialog', function() {
                    if (scope.showDialog) {
                        $(iElement).modal('show');
                    } else {
                        $(iElement).modal('hide');
                    }


                    //call this on close..
                    $(iElement).on('hide.bs.modal', function() {
                        //TODO IMPROVE PERFORMANCE DOUBLE TIME REPEATING..
                        $timeout(function() {
                            scope.showDialog = false;
                        });
                        // do something…
                        scope.onNo();
                    });
                });

            } //link function..
    };
}]);
