(function(){
    'use strict';
})();

/*global angular, $snaphy, $*/
angular.module($snaphy.getModuleName())

//Controller for emailControl ..
.controller('emailControl', ['$scope', '$stateParams', 'Database', 'SnaphyTemplate',
    function($scope, $stateParams, Database, SnaphyTemplate) {
        //Controller defined here..
        $snaphy.setDefaultTemplate(true);

        $scope.emailState  = $snaphy.loadSettings('email', "emailState");
        $scope.userLabel   = $snaphy.loadSettings('email', "userLabel");
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
            SnaphyTemplate.notify({
                message: "Unable to fetching data from the server.Check netwok connection!!",
                type: 'danger',
                icon: 'fa fa-times',
                align: 'right'
            });
            console.log("Error fetching data from the server");
        });


        //sendMail() function to send mail..
        $scope.sendMail = function(){
            if($scope.users){
                if($scope.users.length){
                    //Now check if values has been checked or not..
                    var selectedUsers =  [];
                    $scope.users.forEach(function(user){
                        if(user.selected){
                            selectedUsers.push(user);
                        }
                    });

                    if(selectedUsers.length === 0 ){
                        SnaphyTemplate.notify({
                            message: "You must select atleast one user before sending them email.",
                            type: 'danger',
                            icon: 'fa fa-times',
                            align: 'right'
                        });
                        return null;
                    }else{
                        //Now send mail to the users..
                        ////TODO Add email method to send mail to selected users...

                    }
                }
            }
        };

        //Select all users to send email..
        $scope.selectAllUser = function(users){
            if(!users){
                return false;
            }
            users.forEach(function(user){
                user.selected = true;
            });
        }


    } //controller function..
]);
