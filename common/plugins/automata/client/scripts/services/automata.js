'use strict';

angular.module($snaphy.getModuleName())
//Define your services here..
//

//Provider for adding runtime states..
//http://stackoverflow.com/questions/25866387/angular-ui-router-programmatically-add-states
// config-time dependencies can be injected here at .provider() declaration
.provider('runtimeStates', function runtimeStates($stateProvider) {
  // runtime dependencies for the service can be injected here, at the provider.$get() function.
  this.$get = function($q, $timeout, $state) { // for example
    return { 
      addState: function(name, state) { 
        $stateProvider.state(name, state);
      }
    }
  }
});