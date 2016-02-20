'use strict';

angular.module($snaphy.getModuleName())

//Define your filter specific for this plugin.
//
//rob.bins => "rob bins"
.filter('removeDot', function () {
  return function (input) {
      return input.replace(/\./g, ' ');
  };
})
