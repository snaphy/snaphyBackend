/**
 * Created by robins on 3/12/15.
 */
/*global angular, $snaphy, jQuery, $*/
'use strict';
var registerState     = $snaphy.loadSettings('login', "registerState");

angular.module($snaphy.getModuleName())



    .directive('snaphyLogout', ['LoginServices', function (LoginServices) {
        return {
            restrict: 'E',
            replace: true,
            template:'<a tabindex="-1" href="#" ng-click="logout()"> <i class="si si-logout pull-right"></i>Log out</a>',
            link: function (scope, iElement, iAttrs) {
                scope.logout = function(){
                    LoginServices.logout();
                };
            }//End of Link function...
        }; // End of return
    }])


    /*Add user to backend*/
    .directive('snaphyRegister', ['LoginServices', function (LoginServices) {
        return {
            restrict: 'E',
            replace: true,
            template: '<a ui-sref="' + registerState + '" tabindex="-1"> <i class="si si-user-follow pull-right"></i>Add Employee</a>',
            link: function (scope, iElement, iAttrs) {

            }//End of Link function...
        }; // End of return
    }]);
