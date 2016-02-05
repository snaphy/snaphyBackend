(function(){
    'use strict';
})();

/*global angular, $snaphy, $*/
angular.module($snaphy.getModuleName())

//Controller for emailControl ..
.controller('emailControl', ['$scope', 'Database', 'SnaphyTemplate', '$state', '$stateParams',
    function($scope, Database, SnaphyTemplate, $state, $stateParams) {
        //Controller defined here..
        var defaultTemplate  = $snaphy.loadSettings('email', "defaultTemplate");
        $scope.userLabel   = $snaphy.loadSettings('email', "userLabel");


        //Init function..
        var init  = function(){
            //get the current statename..
            var stateName = $state.current.name;
            //Now get the customerModel name and email model name..
            var stateData = stateName.split("__");
            if(stateData.length !== 2){
                SnaphyTemplate.notify({
                    message: "Invalid Url.",
                    type: 'danger',
                    icon: 'fa fa-times',
                    align: 'right'
                });
                return false;
            }

            //Get the emailModel from the url params...
            var emailModelName = stateData[0];
            var userModelName  = stateData[1];



            //load the email Database model..
            var userModel  = Database.loadDb(userModelName);
            var emailModel = Database.loadDb(emailModelName);

            //Default Template
            $snaphy.setDefaultTemplate(defaultTemplate);

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
            $scope.sendMail = function(sendMethodName){
                if($scope.users){
                    if($scope.users.length){
                        //Now check if values has been checked or not..
                        var selectedUsers =  [];
                        $scope.users.forEach(function(user){
                            if(user.selected){
                                if(user.email){
                                    selectedUsers.push(user.email);
                                }
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
                            emailModel[sendMethodName]({}, {
                                "to": selectedUsers,
                                "subject":"this is a static subject",
                                "templateOptions":{title: "ttt", subject: 'sdasd'}
                            },
                            function(values){
                                //email send successfully..
                                SnaphyTemplate.notify({
                                    message: "Email send successfully.",
                                    type: 'success',
                                    icon: 'fa fa-times',
                                    align: 'right'
                                });
                            }, function(httpResponse){
                                console.error(httpResponse);
                                console.error("Error sending email.");
                            });
                        }//else
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


            var fetchEmailSchema = function(){
                //get the email user model

                //Now call the getschema method..
                emailModel.getMailSchema({}, {}, function(value){
                    console.log(value);
                }, function(httpResponse){
                    //error
                    console.error("Error fetching mail schema from server.");
                    console.error(httpResponse);
                });
            };

            //Now fetch the schema
            fetchEmailSchema();
        }//init method..


        //Only run init if state is not undefined.
        if($state.current.name){
            //Now call the init method...
            init();
        }else{
            //In case if sidebar hook load add several scope params..
            var emailModelList = $snaphy.loadSettings('email', "loadEmails");
            $scope.emailModelList = emailModelList;
            //Get the state name for route
            $scope.getStateName = function(emailModel, userModel){
                //send state name in form of.. home({foo: true, bar: 1})
                var obj = {
                    emailModel: emailModel
                }
                return emailModel + "__" + userModel + '('+  JSON.stringify(obj) + ')';
            }
        }



    } //controller function..
]);
