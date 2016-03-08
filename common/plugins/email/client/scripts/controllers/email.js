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
                    icon: 'fa fa-check',
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
                    icon: 'fa fa-check',
                    align: 'right'
                });
                console.log("Error fetching data from the server");
            });

            var showError = function(msg){
                SnaphyTemplate.notify({
                    message: msg,
                    type: 'danger',
                    icon: 'fa fa-check',
                    align: 'right'
                });
            };


            //sendMail() function to send mail..
            $scope.sendMail = function(sendMethodName, subject, templateValues){

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


                        try{
                            if(sendMethodName === null && $scope.getHtmlData().trim().length === 0){
                                showError("You must type atleast some message before sending mail");
                                return null;
                            }
                        }
                        catch(err){
                            showError("You must type atleast some message before sending mail");
                            return null;
                        }


                        try{
                            if(subject.length === 0){
                                showError("Write some subject before sending mail.");
                                return null;
                            }
                        }
                        catch(err){
                            showError("Write some subject before sending mail.");
                            return null;
                        }


                        try{
                            if(selectedUsers.length === 0 ){
                                showError("You must select atleast one user before sending them email.");
                                return null;
                            }
                        }
                        catch(err){
                            showError("You must select atleast one user before sending them email.");
                            return null;
                        }

                        $scope.dialog = {
                            message: "Do you want to send mail?",
                            title: "Confirm mail send",
                            onCancel: function() {
                                /*Do nothing..*/
                                //Reset the disloag bar..
                                $scope.dialog.show = false;
                            },
                            onConfirm: function() {
                                //Reset the dialog bar..
                                $scope.dialog.show = false;
                                //Now send the mail..
                                if(sendMethodName){
                                    //Now send mail to the users..
                                    emailModel[sendMethodName]({}, {
                                        "to": selectedUsers,
                                        "subject": subject,
                                        "templateOptions": templateValues
                                    },
                                    function(values){
                                        //email send successfully..
                                        SnaphyTemplate.notify({
                                            message: "Email send successfully.",
                                            type: 'success',
                                            icon: 'fa fa-check',
                                            align: 'right'
                                        });
                                    }, function(httpResponse){
                                        console.error(httpResponse);
                                        console.error("Error sending email.");
                                    });
                                }else{
                                    //Now send mail to the users..
                                    emailModel.sendMail({}, {
                                        "to": selectedUsers,
                                        "subject": subject,
                                        "html": $scope.getHtmlData()
                                    },
                                    function(values){
                                        //email send successfully..
                                        SnaphyTemplate.notify({
                                            message: "Email send successfully.",
                                            type: 'success',
                                            icon: 'fa fa-check',
                                            align: 'right'
                                        });
                                    }, function(httpResponse){
                                        console.error(httpResponse);
                                        console.error("Error sending email.");
                                    });
                                }
                            },
                            show: true
                        };
                    }
                }
            };

            //Select all users to send email..
            $scope.selectAllUser = function(users){
                //Toggle values..
                $scope.selectAll  = !$scope.selectAll;

                if(!users){
                    return false;
                }

                if($scope.selectAll)
                {
                    //if user is checked..
                    users.forEach(function(user){
                        user.selected = true;
                    });
                }else{
                    //if user is checked..
                    users.forEach(function(user){
                        user.selected = false;
                    });
                }
            }

            //Checkbox onclick box method..
            $scope.toggleChecked = function(user){
                if(user.selected === undefined){
                    user.selected = true;
                    return null;
                }
                user.selected = !user.selected;
            };


            var fetchEmailSchema = function(){
                //get the email user model

                //Now call the getschema method..
                emailModel.getMailSchema({}, {}, function(value){
                    //console.log(value);
                    $scope.mailSchema = value.schema;
                }, function(httpResponse){
                    //error
                    console.error("Error fetching mail schema from server.");
                    console.error(httpResponse);
                });
            };

            //Now fetch the schema
            fetchEmailSchema();
        };//init method..

        var stateName = $state.current.name;
        var patt = /\_\_/;

        //Only run init if state is not undefined.
        if(patt.test(stateName)){
            $scope.schema = {};
            $scope.selectAll = false;
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
                };
                return emailModel + "__" + userModel + '('+  JSON.stringify(obj) + ')';
            };
        }



    } //controller function..
]);
