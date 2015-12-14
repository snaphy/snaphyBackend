'use strict';
/*global $snaphy, angular*/
angular.module($snaphy.getModuleName())

//Controller for automataControl ..
.controller('automataControl', ['$scope', '$state', 'Database',
    function($scope, $state, Database) {
        //Checking if default templating feature is enabled..
        var defaultTemplate = $snaphy.loadSettings('automata', "defaultTemplate");
        $scope.databasesList = $snaphy.loadSettings('automata', "loadDatabases");
        $snaphy.setDefaultTemplate(defaultTemplate);

        //get the current state name..
        var currentState = $state.current.name; 
        //Storing an instance of table values..
        $scope.rowListValues = [];
        //Schema of the database
        $scope.schema = {};
        

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
            console.log(formStructure);
            
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



        var populateData = function(databaseName){
            var dbService = Database.loadDb(databaseName);

            dbService.getSchema({}, {}, function(values){
                $scope.schema = values.schema;
                fetchDataSever($scope.schema, dbService);    
            }, function(respHeader){
                console.error(respHeader);
            });
        };



        var fetchDataSever = function(dataSchema, dbService){
                var filterObj = {};
                if(dataSchema.relations.belongsTo){
                    filterObj.include = dataSchema.relations.belongsTo;
                }
                dbService.find({ filter: filterObj}, function(values){
                    console.log(values);
                    $scope.dataValues = values;
                }, function(respHeader){
                    console.log(respHeader);
                });
        }


        //Constructor for automata cuntroller..
        $scope.init = function(){
            for(var i=0; i< $scope.databasesList.length; i++){
                if(currentState.toLowerCase().trim() === $scope.databasesList[i].toLowerCase().trim())
                //Now populate the database one by one..
                populateData( $scope.databasesList[i]);
                $scope.tableTitle = currentState + ' ' + 'Data';
                $scope.currentState = currentState;
                $scope.title = currentState + ' Console';
                $scope.description = " data management console.";
                break;
            }
        }

        $scope.init();
            

    }//controller function..
]);