(function(){"use strict";})();
/*global  $snaphy, angular, console */
angular.module($snaphy.getModuleName())

.run(['Permission', '$q', '$rootScope', function (Permission, $q, $rootScope)  {

    var databasesList = $snaphy.loadSettings('robustAutomata', "loadDatabases");

    Permission.defineRole('parentState', function () {
        //using promise..
        var deferred = $q.defer();
        var stateFound = false;
        if($rootScope.currentState){
            for(var i=0; i<databasesList.length; i++){
                var stateName = databasesList[i];
                if($rootScope.currentState.name === stateName ){
                    deferred.resolve();
                    stateFound = true;
                    break;
                }
            }
        }

        if(!stateFound){
            deferred.reject();
        }
        return deferred.promise;
    }); // END Permission

}]) //End Run



//Create state to generate at runTime..
.run(['runtimeStates', function(runtimeStates) {
    var employeeRole = $snaphy.loadSettings('login', "employeeRole");
    var redirectOtherWise = $snaphy.loadSettings('login', 'onLoginRedirectState');
    var databasesList = $snaphy.loadSettings('robustAutomata', "loadDatabases");
    var ignoreList = $snaphy.loadSettings('robustAutomata', "ignore");


    //Loading states at run time.
    databasesList.forEach(function(stateName) {
        //Check if routes dont belongs in the main list
        if(ignoreList){
            if(ignoreList.length){
                var ignore = false;
                for(var i=0; i<ignoreList.length; i++){
                    var ignoreState = ignoreList[i];
                    if(ignoreState === stateName){
                        ignore = true;
                        break;
                    }
                }

                if(ignore === false){
                    addState(stateName, runtimeStates, redirectOtherWise, employeeRole);
                }
            }else{
                addState(stateName, runtimeStates, redirectOtherWise, employeeRole);
            }
        }else{
            addState(stateName, runtimeStates, redirectOtherWise, employeeRole);
        }


    });


}]);


//Method for adding runtime states..
var addState = function(stateName, runtimeStates, redirectOtherWise, employeeRole){
    //Add states at run time..
    runtimeStates.addState(stateName,  {
        url: '/' + stateName.toLowerCase().trim(),
        templateUrl: '/robustAutomata/views/robustAutomata.html',
        controller: 'robustAutomataControl',

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
        templateUrl : '/robustAutomata/views/saveData.html',
        controller  : 'robustAutomataControl',
        parent      : stateName,

        //Only allow authenticated users here
        data        : {
            permissions: {
                only: ['parentState'],
                redirectTo: stateName
            }
        }
    });

};
