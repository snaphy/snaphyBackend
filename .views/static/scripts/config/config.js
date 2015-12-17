(function(){'use strict';})();
/*global angular, $snaphy, $*/

angular.module($snaphy.getModuleName())

    /**
     Defigning templated for angular-formly.
     */
    .run(['formlyConfig',  'SnaphyValidate', function (formlyConfig, SnaphyValidate)  {
        formlyConfig.setType({
            name: 'input',
            template:
            '<div  class="form-group">'+
            '<div  ng-class="[options.templateOptions.colSize, options.templateOptions.color]">'+
            '<div class="form-material" ng-class="options.templateOptions.color">'+
            '<input  class="form-control" type="{{options.templateOptions.type}}"  ng-class="options.templateOptions.class"   name="{{options.templateOptions.id}}" id="{{options.templateOptions.id}}" ng-model="model[options.key]">'+
            '<label for="{{options.templateOptions.id}}">{{options.templateOptions.label}}</label>'+
            '</div>'+
            '</div>'+
            '</div>',

            link: function(scope, element, attrs) {
                if(scope.options.templateOptions){
                    /**
                     *
                     * Validation depends on the snaphy Validation plugin
                     * id of the element is needed.
                     * format of the validation element will be like.
                     * 'login-username': {
                         required: true,
                         minlength: 3
                     }

                     {
                       "type": "input",
                       "templateOptions": {
                         "type": "text",
                         "label": "Enter Username",
                         "validation":{
                            rules:{
                                required: true,
                                minlength:4
                            },
                            messages:{
                                required: 'Please enter a username',
                                minlength: 'Your username must consist of at least 3 characters'
                            }

                        }
                       },
                       "key": "username"
                     }
                     */
                     //Method for escaping string characters in the stringRegex
                    if(scope.options.templateOptions.validation){
                        if(!scope.options.templateOptions.id){
                            console.error("`id` property is required in templateOptions for the input type angular-formly for validation");
                        }
                        //First get the form element. class name.
                        var formElement =  $(element).parents('form');

                        if(!formElement){
                            console.error("Cannot find form element as parent of the element.\n Formly must be enclosed inside a form element for validation to be done.");
                        }
                        //Now get the name property of the input.
                        var name = scope.options.templateOptions.id;
                        var options = SnaphyValidate.options;
                        options.rules = {};
                        options.messages = {};
                        //If regex is defined then first convert regex to regexObject
                        if(scope.options.templateOptions.validation.rules.regex){
                            scope.options.templateOptions.validation.rules.regex = new RegExp(scope.options.templateOptions.validation.rules.regex);
                        }
                        options.rules[name] = scope.options.templateOptions.validation.rules;
                        options.messages[name] = scope.options.templateOptions.validation.messages;
                        //Validating event on focusout..
                        options.onfocusout = function(element, event){
                            this.element(element);
                        };
                        //validating of keyup..
                        options.onkeyup =  function (element, event) {
                            if (event.which === 9 && this.elementValue(element) === "") {
                                return;
                            } else {
                                this.element(element);
                            }
                        };

                        setTimeout(function(){
                            console.log(options);
                            try{

                            }
                            catch(err){
                                //If validation has not been called..
                                //Now load the result..
                                jQuery(formElement[0]).validate(options);
                            }
                        },0);


                    }

                    if(!scope.options.templateOptions.colSize){
                        scope.options.templateOptions.colSize = 'col-xs-12';
                    }
                }//if
            }//link function..
        });



        formlyConfig.setType({
            name: 'textarea',
            template:
            '<div class="form-group">'+
            '<div ng-class="options.templateOptions.colSize">'+
            '<div class="form-material" ng-class="options.templateOptions.color">'+
            '<textarea type="{{options.templateOptions.type}}" name="{{options.templateOptions.id}}" id="{{options.templateOptions.id}}" ng-class="options.templateOptions.class" class="form-control" rows="{{options.templateOptions.row}}"></textarea>'+
            '<label for="{{options.templateOptions.id}}">{{options.templateOptions.label}}</label>'+
            '</div>'+
            '</div>'+
            '</div>',
            controller: function($scope) {
                //Set default value for label..
                if($scope.options.templateOptions.row === undefined){
                    $scope.options.templateOptions.row = 3;
                }

                if($scope.options.templateOptions.colSize === undefined){
                    $scope.options.templateOptions.colSize = "col-sm-12";
                }
            }
        });


        formlyConfig.setType({
            name: 'select',
            template:
            '<div class="form-group">'+
            '<div ng-class="options.templateOptions.colSize">'+
            '<div class="form-material" ng-class="options.templateOptions.color">'+
            '<select type="{{options.templateOptions.type}}" name="{{options.templateOptions.id}}" ng-class="options.templateOptions.class" id="{{options.templateOptions.id}}" ng-model="model[options.key]" class="form-control"  size="{{options.templateOptions.size}}">'+
            '<option value="{{option.id}}" ng-repeat="option in options.templateOptions.options">{{option.name}}</option>'+
            '</select>'+
            '<label for="{{options.templateOptions.id}}">{{options.templateOptions.label}}</label>'+
            '</div>'+
            '</div>'+
            '</div>',
            controller: function($scope, $http) {
                //Set default value for label..
                if($scope.options.templateOptions.size === undefined){
                    $scope.options.templateOptions.size = 1;
                }

                if($scope.options.templateOptions.colSize === undefined){
                    $scope.options.templateOptions.colSize = "col-sm-12";
                }


                if($scope.options.templateOptions.get !== undefined){
                    //Run http to check the value..
                    $http({
                        method: 'GET',
                        url: $scope.options.templateOptions.get
                    }).then(function successCallback(response) {
                        //Select options downloaded successfully..
                        //Loading options..
                        $scope.options.templateOptions.options = response;
                    }, function errorCallback(response) {
                        // called asynchronously if an error occurs
                        // or server returns response with an error status.
                        console.error(response);
                    });
                }

            }
        });


        var unique = 1;
        formlyConfig.setType({
            name: 'repeatSection',
            templateUrl: 'repeatSection.html',
            controller: function($scope) {
                $scope.formOptions = {formState: $scope.formState};
                $scope.addNew = addNew;
                $scope.copyFields = copyFields;
                function copyFields(fields) {
                    fields = angular.copy(fields);
                    addRandomIds(fields);
                    return fields;
                }

                function addNew() {
                    $scope.model[$scope.options.key] = $scope.model[$scope.options.key] || [];
                    var repeatsection = $scope.model[$scope.options.key];
                    var lastSection = repeatsection[repeatsection.length - 1];
                    var newsection = {};
                    if (lastSection) {
                        newsection = angular.copy(lastSection);
                    }
                    repeatsection.push(newsection);
                }

                function addRandomIds(fields) {
                    unique++;
                    angular.forEach(fields, function(field, index) {
                        if (field.fieldGroup) {
                            addRandomIds(field.fieldGroup);
                            return; // fieldGroups don't need an ID
                        }
                        if (field.templateOptions && field.templateOptions.fields) {
                            addRandomIds(field.templateOptions.fields);
                        }
                        field.id = field.id || (field.key + '_' + index + '_' + unique + getRandomInt(0, 9999));
                    });
                }

                function getRandomInt(min, max) {
                    return Math.floor(Math.random() * (max - min)) + min;
                }
            }
        });



    }]);//End Run
