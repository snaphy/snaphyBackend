'use strict';
/*global $snaphy, angular*/
angular.module($snaphy.getModuleName())

//Controller for automataControl ..
.controller('automataControl', ['$scope', '$stateParams', 'Database', '$timeout',
    function($scope, $stateParams, Database, $timeout) {
        //Checking if default templating feature is enabled..
        var defaultTemplate = $snaphy.loadSettings('automata', "defaultTemplate");
        $snaphy.setDefaultTemplate(defaultTemplate);




        $scope.checkType = function(rowObject, columnHeader){
            var colValue = $scope.getColValue(rowObject, columnHeader);
            return Object.prototype.toString.call(colValue);
        };


        $scope.getColValue  = function(rowObject, columnHeader){
            var key = $scope.getKey(rowObject, columnHeader);
            return rowObject[key];
        };

        /**
         * change prop like access_level to access only
         * Get the key or the relationship name.
         * @param rowObject
         * @param columnHeader
         * @returns {*}
         */
        $scope.getKey = function(rowObject, columnHeader){
            var keyName;
            if(rowObject[columnHeader] !== undefined){
                keyName = columnHeader;
            }else{
                //Its a relational header properties name... map the header.. replace `customer_name` to name
                var patt = /\_[A-Z0-9a-z]+$/;
                keyName = columnHeader.replace(patt, '');
            }
            return keyName;
        };

        /**
         * change prop like access-level to level only
         * Get the model properties name on the case of belongsTo or hasOne relationships..
         * @param columnHeader
         */
        $scope.getColumnKey = function(columnHeader){
            var keyName;
            var patt = /^[A-Z0-9a-z-]+\_/;
            return columnHeader.replace(patt, '');
        };






        /**
         * Find model property for the table configuration from the config file
         */
        $scope.findModelPropertyTableConfig = function(configModelTableObj, propertyName){
            //get the property parameters..
            var ModalpropertyObj = configModelTableObj;
            if(ModalpropertyObj === undefined){
                return null;
            }
            if(ModalpropertyObj[propertyName] !== undefined){
                return ModalpropertyObj[propertyName];
            }
            return null;
        };


        /**
         * Return the params for ui-sref for onClick
         * @param params
         * @param rowObject
         * @returns {*}
         */
        $scope.getParams = function(params, rowObject){
            for(var key in params){
                if(params.hasOwnProperty(key)){
                    params[key] = rowObject[key];
                }
            }
            return params;
        };


        /**
         * Event listener for adding reset button to the filters. To be called when reset button is called..
         */
        var resetFilterList = [];
        $scope.addResetMethod = function(func){
            resetFilterList.push(func);
        };



        /**
         * For resetting all filter on reset button click..
         */
        $scope.resetAll = function(tableId){
            //Removing the # tag from id if placed. to avoid duplicity of #
            var tableId  = tableId.replace(/^\#/, '');
            tableId      = '#' + tableId;
            for(var i=0; i<resetFilterList.length; i++){
                //Now call each method..
                resetFilterList[i]();
            }

            //Now redraw the table..
            //Getting the instance of the table..
            var table = $(tableId).DataTable();
            //Now redraw the tables..
            table.draw();
        };




        /**
         * Model for storing the model structure..
         * @param formStructure
         * @param formModel
         */
        $scope.saveForm =  function(formStructure, formModel){
            /**
             * Validate the model here..
             */
            //Now save the model..
            var baseDatabase = Database.loadDb(formStructure.model);
            var relatedData = {
                hasMany:[]
                //belongsTo:[],
                //hasManyThrough:[],
                //hasAndBelongToMany:[]
            };



            //Now first prepare object..
            formStructure.relations.hasMany.forEach(function(relationName, index){
                if(formModel[relationName]){
                    relatedData.hasMany.push(formModel[relationName]);
                    //Now removing the relation from the model.
                    delete formModel[relationName];
                }
            });




            //Now save the base model..
            /**
             * Creting baseModel..
             */
            baseDatabase.create({}, formModel, function(baseModel){
                //Now save the related model..
                formStructure.relations.hasMany.forEach(function(relationName, index){
                    addRelatedModel(baseDatabase, relationName, relatedData, index , baseModel.id  );
                });
            }, function(respHeader){
                console.error(respHeader);
            });


            /**
             * Local method for adding related model..
             * @param baseDatabase
             * @param relationName
             * @param relatedData
             * @param index
             */
            var addRelatedModel= function(baseDatabase, relationName, relatedData, index, parentId ){
                baseDatabase[relationName].createMany({id:parentId}, relatedData.hasMany[index], function(modelArr){
                    console.log("Successfully saved related model data");
                }, function(respHeader){
                    console.error(respHeader);
                });
            };




            /**
             * Other related model to be implemented later.
             */


        };




        $scope.addFormJSON = {
            model: "Employee",
            relations:{
                hasMany:['recipes'],
                belongsTo:[],
                hasManyThrough:[],
                hasAndBelongToMany:[]
            },
            fields:[
                {
                    key: 'email',
                    type: 'input',
                    templateOptions: {
                        type: 'email',
                        label: 'Email address'
                    }
                },
                {
                    key: 'password',
                    type: 'input',
                    templateOptions: {
                        type: 'password',
                        label: 'Enter Password'
                    }
                },
                {
                    key: 'username',
                    type: 'input',
                    templateOptions: {
                        label: 'Enter username',
                        type:'text'
                    }
                },
                {
                    type: 'repeatSection',
                    key: 'recipes',
                    templateOptions: {
                        btnText:'Add Recipes',
                        fields:[
                            {
                                key: 'name',
                                type: 'input',
                                templateOptions: {
                                    type: 'text',
                                    label: 'Enter Recipe'
                                }
                            },
                            {
                                key: 'description',
                                type: 'input',
                                templateOptions: {
                                    type: 'text',
                                    label: 'Enter Description'
                                }
                            },
                            {
                                type: 'repeatSection',
                                key: 'stepsImage',
                                templateOptions: {
                                    btnText:'Upload another image steps',
                                    fields: [
                                        {
                                            className: 'row',
                                            fieldGroup: [
                                                {
                                                    key: 'imageId',
                                                    type: 'input',
                                                    templateOptions: {
                                                        type: 'text',
                                                        label: 'Enter Image Id'
                                                    }
                                                },
                                                {
                                                    key: 'containerId',
                                                    type: 'input',
                                                    templateOptions: {
                                                        type: 'text',
                                                        label: 'Enter Container Id'
                                                    }
                                                }
                                            ]
                                        }
                                    ]
                                }
                            },
                            {
                                key: 'recipeType',
                                type: 'input',
                                templateOptions: {
                                    type: 'text',
                                    label: 'Enter Recipe Type'
                                }
                            },
                            {
                                key: 'servings',
                                type: 'input',
                                templateOptions: {
                                    type: 'number',
                                    label: 'Enter Servings'
                                }
                            },
                            {
                                key: 'mainImage',
                                type: 'input',
                                templateOptions: {
                                    type: 'text',
                                    label: 'Enter Main Image Id'
                                }
                            }
                        ]
                    }
                }
            ]



        };


        $scope.vm = {};

        $scope.vm.user = {};

        // note, these field types will need to be
        // pre-defined. See the pre-built and custom templates
        // http://docs.angular-formly.com/v6.4.0/docs/custom-templates
        $scope.vm.userFields = [
            {
                key: 'email',
                type: 'input',
                templateOptions: {
                    type: 'email',
                    label: 'Email address'
                }
            },
            {
                key: 'password',
                type: 'input',
                templateOptions: {
                    type: 'password',
                    label: 'Enter Password'
                }
            },
            {
                key: 'text',
                type: 'textarea',
                templateOptions: {
                    label: 'Enter value',
                    id:"test"
                }
            },
            {
                key: 'select',
                type: 'select',
                templateOptions: {
                    label: 'Enter value',
                    options: [
                        {id:1, name:"Robins Gupta"}
                    ]
                }
            },
            {
                type: 'repeatSection',
                key: 'investments',
                templateOptions: {
                    btnText:'Add another investment',
                    fields: [
                        {
                            className: 'row',
                            fieldGroup: [
                                {
                                    key: 'email',
                                    type: 'input',
                                    templateOptions: {
                                        type: 'email',
                                        label: 'Email address'
                                    }
                                },
                                {
                                    key: 'sel',
                                    type: 'select',
                                    templateOptions: {
                                        label: 'Enter inline',
                                        options: [
                                            {id:1, name:"Robins"}
                                        ]
                                    }
                                }
                            ]
                        },
                        {
                            key: 'select',
                            type: 'select',
                            templateOptions: {
                                label: 'Enter value',
                                options: [
                                    {id:1, name:"Robins Gupta"}
                                ]
                            }
                        }
                    ]
                }
            }
        ];





        /**
         * INITIALIZING SOME DUMMY DATA..
         */

        $scope.tableTitle = "Testing";
        $scope.currentState = "automata";
        $scope.title = "Automata Plugin";
        $scope.description = "Automata Plugin for auto generating CRUD methods.";

        //Its a model properties for customer..
        $scope.customerModelSettings = {
            "header":['name', 'email', 'access_level', 'access_name',  'phoneNumber', "date", "status", "chef_name"],
            "properties":{
                "name":{
                    type:"string",
                    required: true
                },
                "email":{
                    type:"string",
                    required: true
                },
                "access":{
                    "level":{
                        type:"object",
                        required: true
                    }
                },
                "date":{
                    type:"date",
                    required: true
                },
                "status":{
                    type:"string",
                    "required":true
                },
                "chef":{
                    "name":{
                        type:"string",
                        required:true
                    }
                }
            },
            "tables":{
                name:{
                    onClick:{
                        state:"dashboard",
                        params:{
                            name:"name"
                        }
                    }

                },
                "status":{
                    tag:{
                        "Pending": "label-warning"
                    }
                }

            },
            "filters":{
              "date":{
                  "type":"$date",
                  "default":{
                      "from":"",
                      "to":""
                  },
                  "label": "Recipe added between"
              },
              "email":{
                  "type"  : "$multiSelect",
                  "get"   : "/api/email",
                  "label" : "Select multiple columns",
                  "options":[
                      {
                          id:1,
                          name:"robinskumar73@gmail.com"
                      },
                      {
                          id:2,
                          name:"ravigupta9363@gmail.com"
                      }
                  ]
              },

              "chef_name":{
                  "type": "$select",
                  "get" : "/api/chefs",
                  "options":[
                      {
                          id:1,
                          name:"Sanjeev Kapoor"
                      },
                      {
                          id:2,
                          name:"Tarla Dalal"
                      }
                  ],
                  "label": "Select chefs"
              },
              "status":{
                  "type":"$typeSelect",
                  "options":[
                      {
                        name: "Pending",
                        checked: false
                      },
                      {
                        name: "Approved",
                        checked: true
                      },
                      {
                          name:"Rejected",
                          checked: false
                      }
                  ],
                  "label": "Choose types.."
              }
            }
        };


        $scope.rowListValues = [
            {
                name:"Robins Gupta",
                email:"robinskumar73@gmail.com",
                access:{
                    level:{
                        type:1,
                        height:1
                    },
                    others:{
                        email:"rohitbasu2030@gmail.com",
                        height:1
                    },
                    "name": "Robins"

                },
                "phoneNumber": 9953242338,
                "date": "Thu Dec 10 2015 17:34:50 GMT+0530 (IST)",
                "status": "Pending",
                "chef_name": "Sanjeev Kapoor"
            },
            {
                name:"Ravi Gupta",
                email:"ravikumar73@gmail.com",
                access:{
                    level:{
                        type:2,
                        height:0
                    },
                    "name": "Ravi"
                },
                "phoneNumber": 9953242338,
                "date": "Thu Dec 11 2015 17:34:50 GMT+0530 (IST)",
                "status": "Approved",
                "chef_name": "Tarla Dalal"
            }
        ];



    }//controller function..
]);