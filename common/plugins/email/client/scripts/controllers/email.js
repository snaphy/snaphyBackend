(function(){
    'use strict';
})();

/*global angular, $snaphy, $*/
angular.module($snaphy.getModuleName())

//Controller for emailControl ..
.controller('emailControl', ['$scope', '$stateParams', 'Database',
    function($scope, $stateParams, Database) {
        //Controller defined here..
        $snaphy.setDefaultTemplate(true);

        $scope.emailState  = $snaphy.loadSettings('email', "emailState");
        //get the email user model
        var userModel = Database.getDb('email', "EmailUsersModel");

        //Now fetch the users along with email address..
        userModel.find({
            filter:{
                fields: {
                    id: true,
                    firstName: true,
                    lastName: true,
                    email: true,
                    date: false,
                    phoneNumber: false,
                    profilePic: false
                }
            }
        }, function(values){
            $scope.users = values;
        }, function(respHeader){
            console.log("Error fetching data from the server");
        });
    } //controller function..
]);
