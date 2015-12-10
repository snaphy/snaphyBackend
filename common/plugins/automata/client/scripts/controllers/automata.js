'use strict';
/*global $snaphy, angular*/
angular.module($snaphy.getModuleName())

//Controller for automataControl ..
.controller('automataControl', ['$scope', '$stateParams', 'Database',
    function($scope, $stateParams, Database) {
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
         * INITIALIZING SOME DUMMY DATA..
         */

        $scope.tableTitle = "Testing";
        $scope.currentState = "automata";
        $scope.title = "Automata Plugin";
        $scope.description = "Automata Plugin for auto generating CRUD methods.";

        //Its a model properties for customer..
        $scope.customerModelSettings = {
            "header":['name', 'email', 'access_level', 'access_name',  'phoneNumber'],
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
                email:{
                    tag:{
                        "robinskumar73@gmail.com": "label-warning"
                    }
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
                "phoneNumber": 9953242338
            },
            {
                name:"Ravi Gupta",
                email:"ravikumar73@gmail.com",
                access:{
                    level:{
                        type:2,
                        height:0
                    }
                },
                "phoneNumber": 9953242338
            }
        ];



    }//controller function..
]);