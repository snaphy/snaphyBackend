( function( ){'use strict';} )( );
/* global $snaphy, angular, $*/
angular.module($snaphy.getModuleName())

// Controller for automataControl ..
.controller('automataControl', ['$scope', '$state', 'Database', 'SnaphyTemplate',
    function($scope, $state, Database, SnaphyTemplate) {

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
        /*Data for save form modal*/
        $scope.saveFormData = {};
        //Initializing scope //for array..
        $scope.dataValues = [];
        //contains backup of the data..
        var backupData = {};
        var dataFetched = false;


        $scope.checkType = function(rowObject, columnHeader) {
            var colValue = $scope.getColValue(rowObject, columnHeader);
            return Object.prototype.toString.call(colValue);
        };


        $scope.getColValue = function(rowObject, columnHeader) {
            var key = $scope.getKey(rowObject, columnHeader);
            return key? rowObject[key]: null ;
        };



        /**
         * change prop like access_level to access only
         * Get the key or the relationship name.
         * @param rowObject
         * @param columnHeader
         * @returns {*}
         */
        $scope.getKey = function(rowObject, columnHeader) {
            var keyName;
            if(rowObject){
                if (rowObject[columnHeader] !== undefined) {
                    keyName = columnHeader;
                } else {
                    //Its a relational header properties name... map the header.. replace `customer_name` to name
                    var patt = /\_[A-Z0-9a-z]+$/;
                    keyName = columnHeader.replace(patt, '');
                }
            }
            return keyName;
        };

        /**
         * change prop like access-level to level only
         * Get the model properties name on the case of belongsTo or hasOne relationships..
         * @param columnHeader
         */
        $scope.getColumnKey = function(columnHeader) {
            var keyName;
            var patt = /^[A-Z0-9a-z-]+\_/;
            return columnHeader.replace(patt, '');
        };

        //TO be used in tables..
        $scope.getRelationColumnValue = function(rowObject, header, colKey){
            var colValue                = $scope.getColValue(rowObject, header);
            var isBelongToRelation      = header !== colKey;
            var hasOneRelationPropName  = $scope.getColumnKey(header);
            return (isBelongToRelation)? colValue[hasOneRelationPropName] : colValue;
        };

        $scope.getRelationColumnType = function(rowObject, header, colKey, initialColumnType){
            var colValue                = $scope.getRelationColumnValue(rowObject, header, colKey);
            var hasOneRelationPropName  = $scope.getColumnKey(header);
            var isBelongToRelation      = header !== colKey;
            return (isBelongToRelation)? $scope.checkType(colValue, hasOneRelationPropName): initialColumnType;
        };


        /**
         * Find model property for the table configuration from the config file
         * @param  {object} configModelTableObj [description]
         * @param  {string} propertyName        [description]
         * @return {object}                     [description]
         */
        $scope.findModelPropertyTableConfig = function(configModelTableObj, propertyName) {
            //get the property parameters..
            var ModalpropertyObj = configModelTableObj;
            if (ModalpropertyObj === undefined) {
                return null;
            }
            if (ModalpropertyObj[propertyName] !== undefined) {
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
        $scope.getParams = function(params, rowObject) {
            for (var key in params) {
                if (params.hasOwnProperty(key)) {
                    params[key] = rowObject[key];
                }
            }
            return params;
        };


        /**
         * Event listener for adding reset button to the filters. To be called when reset button is called..
         */
        var resetFilterList = [];
        $scope.addResetMethod = function(func) {
            resetFilterList.push(func);
        };


        var resetSavedForm = function(form){
            $scope.saveFormData = {};
            form.$setPristine();
        };


        $scope.enableButton = function(form){
            try{
                if(form.$dirty){
                    if($.isEmptyObject(form.$error) ){
                        return true;
                    }
                }else{
                    return false;
                }
            }catch(err){
                //disable button
                return true;
            }
        };



        /**
         * For resetting all filter on reset button click..
         */
        $scope.resetAll = function(tableId) {
            //Removing the # tag from id if placed. to avoid duplicity of #
            tableId = tableId.replace(/^\#/, '');
            tableId = '#' + tableId;
            for (var i = 0; i < resetFilterList.length; i++) {
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
         * Initialize the edit form data from editing the form.
         * @param  {[type]} data [description]
         * @return {[type]}           [description]
         */
        $scope.prepareDataForEdit = function(data) {
            //Firsst create a backup of the the data in case of rollback changes/cancel
            backupData = angular.copy(data);
            $scope.saveFormData = data;
        };


        /**
         * Method for deleting data from database..
         * @param  {[type]} rowObject [description]
         * @return {[type]}           [description]
         */
        $scope.deleteData = function(formStructure, data){
            //get the model service..
            var baseDatabase = Database.loadDb(formStructure.model);
            $scope.dialog = {
                message: "Do you want to delete the data?",
                title: "Confirm Delete",
                onCancel: function(){
                    /*Do nothing..*/
                    //Reset the disloag bar..
                    $scope.dialog.show = false;
                    console.log("Go clicked");
                },
                onConfirm: function(){
                    var mainArrayIndex = getArrayIndex($scope.dataValues, data.id);
                    var oldDeletedData = $scope.dataValues[mainArrayIndex];


                    //Reset the disloag bar..
                    $scope.dialog.show = false;
                    baseDatabase.deleteById({
                        id: data.id
                    }, function(value){
                        /*Delete the data from the database..*/
                        SnaphyTemplate.notify({
                            message: "Data successfully deleted.",
                            type: 'success',
                            icon: 'fa fa-check',
                            align: 'right'
                        });
                    }, function(respHeader){
                        //Attach the data again..
                        // $scope.dataValues.push(oldDeletedData);

                        console.error(respHeader);
                        SnaphyTemplate.notify({
                            message: "Error deleting data.",
                            type: 'danger',
                            icon: 'fa fa-times',
                            align: 'right'
                        });
                    });
                    //Now delete the data..
                    $scope.dataValues.splice(mainArrayIndex, 1);
                    //Now delete the data..
                    console.log($scope.dataValues);

                },
                show:true
            };

        };

        /**
         * For finding array index of the data of array of objects with properties id..
         * @return {[type]} [description]
         */
        var getArrayIndex = function(arrayData, id){
            for(var i=0; i<arrayData.length; i++){
                var element= arrayData[i];
                if(parseInt(element.id) === parseInt(id) ){
                    return i;
                }
            }
            return null;
        };

        /**
         * Method  for checking if the automata form is valid.
         * @param  {[type]} schema template schema object with property fields showing all the fields.
         * @return {[type]}        [description]
         */
        $scope.isValid = function(form){
            try{

                if(form.validate() && form.$dirty){
                    if($.isEmptyObject(form.$error) ){
                        return true;
                    }
                }
            }catch(err){
                return false;
            }

            return false;
        };

        //Method for rollbackchanges is eror occured..
        $scope.rollBackChanges = function(){
            if(!$.isEmptyObject(backupData)){
                $scope.dataValues.forEach(function(data, index){
                    if(data.id === backupData.id && !$.isEmptyObject(backupData)){
                        //rollback changes..
                        $scope.dataValues[index] = backupData;
                        //Reset backup data..
                        backupData = {};
                        return false;
                    }
                });
            }
        };


        $scope.resetBackup = function(){
            backupData = {};
            $scope.saveFormData = {};
        };




        /**
         * Model for storing the model structure..
         * @param formStructure
         * @param formModel
         * @param formID refrencing to the id attribute of the  form.
         */
        $scope.saveForm = function(formStructure, formModel) {
            if(!$scope.isValid(formStructure.form)){
                SnaphyTemplate.notify({
                    message: "Error data is Invalid.",
                    type: 'danger',
                    icon: 'fa fa-times',
                    align: 'right'
                });

                //If edit was going on revert back..
                if(formModel.id){
                    $scope.rollBackChanges();
                }
            }
            else{
                //Now save the model..
                var baseDatabase = Database.loadDb(formStructure.model);
                var relatedData = {
                    hasOne:[],
                    hasMany: [],
                    belongsTo: [],
                    hasManyThrough:[],
                    hasAndBelongToMany:[]
                };

                var schema = {
                    "relation": $scope.schema.relations
                };

                var requestData = {
                    data: formModel,
                    schema: schema
                };

                //create a copy of the data..
                var savedData = angular.copy(formModel);
                var update;
                if(formModel.id){
                    update = true;

                }
                else{
                    var positionNewData = $scope.dataValues.length;
                    //First add to the table..
                    $scope.dataValues.push(savedData);
                    update = false;
                }


                //Now save||update the database with baseDatabase method.
                baseDatabase.save({}, requestData, function(baseModel){
                    console.log(baseModel);
                    if(!update){
                        //Now update the form with id.
                        $scope.dataValues[positionNewData].id = baseModel.id;
                    }
                    SnaphyTemplate.notify({
                        message: "Data successfully saved.",
                        type: 'success',
                        icon: 'fa fa-check',
                        align: 'right'
                    });
                }, function(respHeader){
                    console.log("Error saving data to server");
                    console.error(respHeader);
                    if(update){
                        $scope.rollBackChanges();
                    }
                    else{
                        //remove the form added data..
                        if (positionNewData > -1) {
                            $scope.dataValues.splice(positionNewData, 1);
                        }
                    }

                    console.error(respHeader);
                    SnaphyTemplate.notify({
                        message: "Error saving data.",
                        type: 'danger',
                        icon: 'fa fa-times',
                        align: 'right'
                    });
                });

                //Now reset the form..
                resetSavedForm(formStructure.form);
            }
        }; //saveForm


        //Copying one object to another..
        var extend = function (original, context, key) {
          for (key in context)
            if (context.hasOwnProperty(key))
              if (Object.prototype.toString.call(context[key]) === '[object Object]')
                original[key] = extend(original[key] || {}, context[key]);
              else
                original[key] = context[key];
          return original;
        };




        var populateData = function(databaseName) {
            var dbService = Database.loadDb(databaseName);
            dbService.getSchema({}, {}, function(values) {
                extend($scope.schema, values.schema);
                //$scope.schema = values.schema;
                fetchDataSever($scope.schema, dbService);
            }, function(respHeader) {
                console.error(respHeader);
            });
        };



        /**
         * Checking if the data is fetched return a boolean
         * @return {Boolean} [description]
         */
        $scope.isDataFetched = function() {
            if (dataFetched && $scope.schema.header) {
                return true;
            }
            return false;
        };


        //checking if the filters is present in the data..
        $scope.isFilterPresent = function() {
            if ($scope.schema.filters) {
                for (var filterName in $scope.schema.filters) {
                    if ($scope.schema.filters.hasOwnProperty(filterName)) {
                        return true;
                    }
                }
            }
            return false;
        };




        var fetchDataSever = function(dataSchema, dbService) {
            var filterObj = {};
            filterObj.include = [];
            if (dataSchema.relations.belongsTo) {
                if(dataSchema.relations.belongsTo.length){
                    dataSchema.relations.belongsTo.forEach(function(relationName){
                        filterObj.include.push(relationName);
                    });
                }
            }

            if(dataSchema.relations.hasAndBelongToMany) {
                if(dataSchema.relations.hasAndBelongToMany.length){
                    dataSchema.relations.hasAndBelongToMany.forEach(function(relationName){
                        filterObj.include.push(relationName);
                    });
                }
            }

            if(dataSchema.relations.hasMany) {
                if(dataSchema.relations.hasMany.length){
                    dataSchema.relations.hasMany.forEach(function(relationName){
                        filterObj.include.push(relationName);
                    });
                }
            }

            if(dataSchema.relations.hasOne) {
                if(dataSchema.relations.hasOne.length){
                    dataSchema.relations.hasOne.forEach(function(relationName){
                        filterObj.include.push(relationName);
                    });
                }
            }

            dbService.find({
                filter: filterObj
            }, function(values) {
                dataFetched = true;
                //$scope.dataValues.length = 0;
                values.forEach(function(element, index){
                    //Set element value initial relationship value for two way COMMUNICATION..
                    for(var relationType in dataSchema.relations){
                        if(dataSchema.relations.hasOwnProperty(relationType)){
                            var value;
                            if(relationType === "belongsTo" || relationType === "hasOne"){
                                value = {};
                            }
                            else{
                                value = [];
                            }

                            var relationArr = dataSchema.relations[relationType];
                            element = addRelationDummyValue (relationArr, element, value);
                        }
                    }
                    //setting the value of the data successfully fetched..
                    $scope.dataValues.push(element);
                });

                console.log($scope.dataValues);

            }, function(respHeader) {
                console.log(respHeader);
            });
        };

        var addRelationDummyValue = function(relationArr, element, value){
            relationArr.forEach(function(rel, index){
                if(!element[rel]){
                    element[rel] = value;
                }
            });
            return element;
        };



        //Constructor for automata cuntroller..
        $scope.init = function() {
            for (var i = 0; i < $scope.databasesList.length; i++) {
                if (currentState.toLowerCase().trim() === $scope.databasesList[i].toLowerCase().trim()){
                    //Now populate the database one by one..
                    populateData($scope.databasesList[i]);
                    $scope.tableTitle = currentState + ' ' + 'Data';
                    $scope.currentState = currentState;
                    $scope.title = currentState + ' Console';
                    $scope.description = "Data management console.";
                    break;
                }
            }
        };



        //Only load if the current scope is
        $scope.init();


    } //controller function..
]);
