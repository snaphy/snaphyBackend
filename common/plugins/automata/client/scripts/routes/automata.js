/*jslint browser: true*/
/*global $, jQuery, $snaphy, angular*/
'use strict';
angular.module($snaphy.getModuleName())


//Create state to generate at runTime..
.run(['runtimeStates', function(runtimeStates) {
  var employeeRole = $snaphy.loadSettings('login', "employeeRole");
  var redirectOtherWise = $snaphy.loadSettings('login', 'onLoginRedirectState');
  var databasesList = $snaphy.loadSettings('automata', "loadDatabases");

  //Loading states at run time.
  databasesList.forEach(function(stateName, index){
    //Add states at run time..
    runtimeStates.addState(stateName,{
        url: '/' + stateName.toLowerCase().trim(),
        templateUrl: '/automata/views/automata.html',
        controller: 'automataControl',

        //Only allow authenticated users here
        data: {
          permissions: {
            only: [employeeRole],
            redirectTo: redirectOtherWise
          }
        }
    });
  });
    
}])
