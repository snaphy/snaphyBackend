'use strict';
/*global angular, $snaphy */

angular.module($snaphy.getModuleName())

/**
 * Filter for capitalizing the first word.
 */
.filter('capitalize', function() {
    return function(input) {
        return (!!input) ? input.charAt(0).toUpperCase() + input.substr(1).toLowerCase() : '';
    };
});