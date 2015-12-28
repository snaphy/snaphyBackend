/*  global  $snaphy, angular, console */
(function(){"use strict";})();
angular.module($snaphy.getModuleName())

.run(['Permission', '$q', '$rootScope', function (Permission, $q, $rootScope)  {

    var databasesList = $snaphy.loadSettings('automata', "loadDatabases");

    Permission.defineRole('parentState', function () {
        //using promise..
        var deferred = $q.defer();
        var stateFound = false;
        if($rootScope.currentState){
            for(var i=0; i<databasesList.length; i++){
                var stateName = databasesList[i];
                if($rootScope.currentState.name === stateName ){
                    console.log("getting accepted");
                    deferred.resolve();
                    stateFound = true;
                    break;
                }
            }
        }

        if(!stateFound){
            console.log("I am rejecting");
            deferred.reject();
        }
        return deferred.promise;
    }); // END Permission

}]) //End Run



//Create state to generate at runTime..
.run(['runtimeStates', function(runtimeStates) {
    var employeeRole = $snaphy.loadSettings('login', "employeeRole");
    var redirectOtherWise = $snaphy.loadSettings('login', 'onLoginRedirectState');
    var databasesList = $snaphy.loadSettings('automata', "loadDatabases");


    //Loading states at run time.
    databasesList.forEach(function(stateName) {
        //Add states at run time..
        runtimeStates.addState(stateName,  {
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



        //Add another state for saving users..
        //Add states at run time..
        runtimeStates.addState(stateName + '.save', {
            url         : '/' + stateName.toLowerCase().trim() + '/saveData',
            templateUrl : '/automata/views/saveData.html',
            controller  : 'automataControl',
            parent      : stateName,

            //Only allow authenticated users here
            data        : {
                permissions: {
                    only: ['parentState'],
                    redirectTo: stateName
                }
            }
        });


    });


}]);
