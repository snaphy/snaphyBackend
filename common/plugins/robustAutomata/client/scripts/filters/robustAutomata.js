'use strict';

angular.module($snaphy.getModuleName())

//Define your filter specific for this plugin.
//
//rob.bins => "rob bins"
.filter('removeDot', function() {
    return function(input) {
        return input.replace(/\./g, ' ');
    };
})


.filter('myStrictFilter', function($filter) {
    return function(input, predicate) {
        return $filter('filter')(input, predicate, true);
    }
})

.filter('unique', function() {
    return function(arr, field) {
        var o = {},
            i, l = arr.length,
            r = [];
        for (i = 0; i < l; i += 1) {
            o[arr[i][field]] = arr[i];
        }
        for (i in o) {
            r.push(o[i]);
        }
        return r;
    };
})
