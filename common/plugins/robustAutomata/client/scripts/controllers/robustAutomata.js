'use strict';

angular.module($snaphy.getModuleName())

//Controller for robustAutomataControl ..
.controller('robustAutomataControl', ['$scope', '$stateParams', 'Database', 'Resource', '$timeout', 'SnaphyTemplate', '$state', 'ImageUploadingTracker',
    function($scope, $stateParams, Database, Resource, $timeout, SnaphyTemplate, $state, ImageUploadingTracker) {
        //Checking if default templating feature is enabled..
        //



        //------------------------------------------------------GLOBAL VARIABLE SPACE----------------------------------------------------------
        var ctrl = $scope;
        //Storing an instance of table values..
        $scope.rowListValues = $scope.rowListValues || [];
        //Schema of the database
        $scope.schema = $scope.schema  || {};
        /*Data for save form modal*/
        $scope.saveFormData = $scope.saveFormData || {};
        //Initializing scope //for array..
        //$scope.displayed = $scope.displayed || [];
        //contains backup of the data..
        var backupData = backupData || {};
        var dataFetched = dataFetched || false;
        //get the current state name..
        var currentState = $state.current.name;
        $scope.currentState = currentState;
        var defaultTemplate = $snaphy.loadSettings('robustAutomata', "defaultTemplate");
        $scope.databasesList = $snaphy.loadSettings('robustAutomata', "loadDatabases");
        var ignoreList = $snaphy.loadSettings('robustAutomata', "ignore");
        var errorList = $snaphy.loadSettings('robustAutomata', "failedSaveStatus");
        //Id for tablePanel
        var tablePanelId = $snaphy.loadSettings('robustAutomata', "tablePanelId");
        $snaphy.setDefaultTemplate(defaultTemplate);
        $scope.displayed = [];
        $scope.pagesReturned = null ;
        //Inline search data object
        $scope.inlineSearch = {};
        //$scope.ImageUploadingTracker = ImageUploadingTracker;
        //--------------------------------------------------------------------------------------------------------------------------------------




        $scope.toJsDate = function(str) {
            if (!str) {
                return null;
            }
            return new Date(str);
        };

        $scope.ifRecipeState = function(){
            return $scope.getCurrentState() === "Recipe";
        };


        $scope.getCurrentState = function() {
            return $state.current.name;
        };


        $scope.scroll = function(){
            //Scroll
            $timeout(function(){
                App.layout('side_scroll_off');
            }, 10);
        };


        $scope.isIgnoreState = function(state){
            //Check if routes dont belongs in the main list
            if(ignoreList){
                if(ignoreList.length){
                    var ignore = false;
                    for(var i=0; i<ignoreList.length; i++){
                        var ignoreState = ignoreList[i];
                        if(ignoreState === state){
                            ignore = true;
                            break;
                        }
                    }
                    return ignore;
                }else{
                    return false;
                }
            }else{
                return false;
            }

        };



        $scope.goToParentState = function() {
            if ($scope.$parent.currentState) {
                $state.go($scope.$parent.currentState);
            }
        };


        $scope.checkIfParentState = function() {
            if ($scope.databasesList) {
                for (var i = 0; i < $scope.databasesList.length; i++) {
                    var state = $scope.databasesList[i];
                    if (state.toLowerCase().trim() === $state.current.name.toLowerCase().trim()) {
                        return true;
                    }
                }
            }
            return false;
        };


        $scope.checkType = function(rowObject, columnHeader) {
            var colValue = $scope.getColValue(rowObject, columnHeader);
            return Object.prototype.toString.call(colValue);
        };

        $scope.getColValue = function(rowObject, columnHeader) {
            var key = $scope.getKey(rowObject, columnHeader);

            return key !== undefined ? rowObject[key] : null;
        };


        $scope.dateInSeconds = function(rowObject, columnHeader) {
            var val = $scope.getColValue(rowObject, columnHeader);
            var date = new Date(val);
            return date.getTime();
        };


        //Method for getting branch.io key..details..
        $scope.getBranchIOKey = function(model){
            //console.log(model);
            var imageUrl;
            if(model.mainImage){
                if(model.mainImage.url){
                    if(model.mainImage.url.unSignedUrl){
                        imageUrl = model.mainImage.url.unSignedUrl;
                    }
                }
            }
            var link = {};
            link.id =  model.id;

            if(imageUrl){
                link.url = imageUrl;
            }



            $scope.info = {
                title: "Branch.IO link generation.",
                onCancel: function() {
                    /*Do nothing..*/
                    //Reset the disloag bar..
                    $scope.info.show = false;
                },
                show: true,
                link: link
            };
        };


        $scope.addWhereQuery = function(model, columnName, filterType, schema){
            $scope.where = $scope.where  || {};
            if(filterType === "select"){
                //console.log("select", columnName, model);
                if(model){
                    $scope.where[columnName] = model;
                }
                //Now redraw the table..
                $scope.refreshData();
            }else if (filterType === "number") {
                //console.log("select", columnName, model);
                if(model){
                    $scope.where[columnName] = model;
                }
                //Now redraw the table..
                $scope.refreshData();
            }
            else if (filterType === "date") {
                //console.log("select", columnName, model);
                if(model){
                    //TODO CHANGE HERE TO NOT RESET EVERYTIME..
                    $scope.where.and = [];
                    var obj = {};
                    obj[columnName] = {"gte" : new Date(model) };
                    $scope.where.and.push(obj);
                }
                //Now redraw the table..
                $scope.refreshData();
            }else if(filterType === "related"){
                if(model){
                    //First find the data....
                    if(schema.tables){
                        var keyName = columnName.replace(/\./, "_");
                        if(schema.tables[keyName]){
                            var tableProp = schema.tables[keyName];
                            var modelName = tableProp.relatedModel;
                            var foreignKey = tableProp.foreignKey;
                            var searchProp = tableProp.propertyName;
                            //Now first find the related values then add where query..
                            var dbService = Database.loadDb(modelName);
                            var filter = {};
                            filter.where = {};
                            filter.limit = 7;
                            filter.where[searchProp] = {
                                like : model
                            };

                            dbService.find({
                                filter: filter
                            }, function(values){
                                //console.log(values);
                                //get the ids list..
                                if(values){
                                    if(values.length){
                                        var idList = [];
                                        for(var i=0; i<values.length; i++){
                                            //Collect the ids
                                            var data = values[i];
                                            idList.push(data.id);
                                        }

                                        //now prepare the where query..
                                        if(idList.length){
                                            //PREPARE THE WHERE QUERY..
                                            $scope.where[foreignKey] = {
                                                inq: idList
                                            };

                                            //Now redraw the table..
                                            $scope.refreshData();
                                        }


                                    }
                                }
                            }, function(err){
                                console.error(err);
                            });

                        }
                    }

                }

            }else{

            }

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
            if (rowObject) {
                if (rowObject[columnHeader] !== undefined) {
                    keyName = columnHeader;
                } else {
                    //Its a relational header properties name... map the header.. replace `customer_name` to name
                    var patt = /\.[A-Z0-9a-z]+$/;
                    keyName = columnHeader.replace(patt, '');
                }
            }
            return keyName;
        };



        //Check if to show the text filter..
        $scope.showFilterType = function(header, schema){
            if(schema.tables){
                var keyName = header.replace(/\./, "_");
                if(schema.tables[keyName]){
                    var tableProp = schema.tables[keyName];
                    if(tableProp.search){
                        return tableProp.search;
                    }
                }
            }

            return null;
        };


        $scope.getOptions = function(header, schema){
            if(schema.tables){
                var keyName = header.replace(/\./, "_");
                if(schema.tables[keyName]){
                    var tableProp = schema.tables[keyName];
                    if(tableProp.search === "select"){
                        if(tableProp.options){
                            return tableProp.options;
                        }
                    }
                }
            }

            return null;
        };

        //Example addInlineFilterResetMethod('#automataTable', 'number', inlineSearch, header)
        $scope.addInlineFilterResetMethod = function(tableId, type, modelObj, columnName){
            if(type === "select"){
                var element = $(tableId);
                //Now add a Reset method to the filter..
                $scope.addResetMethod(function(){
                    //console.log("Resetting select");
                    if(modelObj[columnName]){
                        modelObj[columnName] = null;
                    }
                    //Now reinitialize the
                    setTimeout(function() {
                        $($(element).find('select')).select2('val', 'All');
                    }, 0);
                });
            }else if (type === "text" || type === "number" || type === "date" || type === 'related') {
                $scope.addResetMethod(function(){
                    $timeout(function(){
                        //$($(element).find('input')).val("");
                        //console.log("Resetting ", type);
                        if(modelObj[columnName]){
                            modelObj[columnName] = null;
                        }
                    });
                });
            }else{
                //Do nothing..
            }
        };


        /**
         * change prop like access-level to level only
         * Get the model properties name on the case of belongsTo or hasOne relationships..
         * @param columnHeader
         */
        $scope.getColumnKey = function(columnHeader) {
            //var keyName;
            var patt = /^[A-Z0-9a-z-$]+\./;
            return columnHeader.replace(patt, '');
        };



        //TO be used in tables..
        $scope.getRelationColumnValue = function(rowObject, header, colKey) {
            var colValue = $scope.getColValue(rowObject, header);
            var isBelongToRelation = header !== colKey;
            var hasOneRelationPropName = $scope.getColumnKey(header);
            return (isBelongToRelation) ? colValue[hasOneRelationPropName] : colValue;
        };




        $scope.getRelationColumnType = function(rowObject, header, colKey, initialColumnType) {
            var colValue = $scope.getRelationColumnValue(rowObject, header, colKey);
            var hasOneRelationPropName = $scope.getColumnKey(header);
            var isBelongToRelation = header !== colKey;
            return (isBelongToRelation) ? $scope.checkType(colValue, hasOneRelationPropName) : initialColumnType;
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





        var resetSavedForm = function(form) {
            //TODO POSSIBILITY FOR ERROR
            //reset the tracking bar..
            ImageUploadingTracker.resetTracker();
            $scope.saveFormData = {};
            if (form) {
                form.$setPristine();
            }
            //Now clear the form object..



            //Also reset the validator..
            //var validator = form.validate();
            //console.log(form);
            //console.log(form.resetForm());
            //validator.resetForm();
            //var validator = $(form).validate();
        };



        $scope.resetSavedForm = resetSavedForm;


        $scope.enableButton = function(form) {
            try {
                if (form.$dirty) {
                    if ($.isEmptyObject(form.$error)) {
                        return true;
                    }
                } else {
                    return false;
                }
            } catch (err) {
                //disable button
                return true;
            }
        };



        /**
         * For resetting all filter on reset button click..
         */
        $scope.resetAll = function() {
            //TODO POSSIBILITY FOR ERROR
            //reset the tracking bar..
            ImageUploadingTracker.resetTracker();

            for (var i = 0; i < resetFilterList.length; i++) {
                //Now call each method..
                resetFilterList[i]();
            }

            $scope.resetTable();
            //$scope.refreshData();
        };




        /**
         * Initialize the edit form data from editing the form.
         * @param  {[type]} data [description]
         * @return {[type]}           [description]
         */
        $scope.prepareDataForEdit = function(data, form) {
            //console.log(form);
            //First reset the previous data..
            resetSavedForm(form);

            //Firsst create a backup of the the data in case of rollback changes/cancel
            backupData = angular.copy(data);
            $scope.saveFormData = data;
        };


        /**
         * Method for deleting data from database..
         * @param  {[type]} rowObject [description]
         * @return {[type]}           [description]
         */
        $scope.deleteData = function(formStructure, data) {
            //get the model service..
            var baseDatabase = Database.loadDb(formStructure.model);
            $scope.dialog = {
                message: "Do you want to delete the data?",
                title: "Confirm Delete",
                onCancel: function() {
                    /*Do nothing..*/
                    //Reset the disloag bar..
                    $scope.dialog.show = false;
                },
                onConfirm: function() {
                    var mainArrayIndex = getArrayIndex($scope.displayed, data.id);
                    var oldDeletedData = $scope.displayed[mainArrayIndex];
                    //console.log(data);

                    //Reset the disloag bar..
                    $scope.dialog.show = false;
                    baseDatabase.deleteById({
                        id: data.id
                    }, function() {
                        /*Delete the data from the database..*/
                        SnaphyTemplate.notify({
                            message: "Data successfully deleted.",
                            type: 'success',
                            icon: 'fa fa-check',
                            align: 'right'
                        });
                    }, function() {
                        $timeout(function() {
                            //Attach the data again..
                            $scope.displayed.push(oldDeletedData);
                        }, 10);

                        //console.error(respHeader);
                        SnaphyTemplate.notify({
                            message: "Error deleting data.",
                            type: 'danger',
                            icon: 'fa fa-times',
                            align: 'right'
                        });
                    });
                    //Now delete the data..
                    $scope.displayed.splice(mainArrayIndex, 1);

                },
                show: true
            };

        };



        /**
         * For finding array index of the data of array of objects with properties id..
         * @return {[type]} [description]
         */
        var getArrayIndex = function(arrayData, id) {
            for (var i = 0; i < arrayData.length; i++) {
                var element = arrayData[i];
                if (element.id.toString().trim() === id.toString().trim()) {
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
        $scope.isValid = function(form) {
            try {
                //TODO Removing find alternate for  form.$dirty
                if (form.validate()) {
                    if ($.isEmptyObject(form.$error)) {
                        return true;
                    }
                }
            } catch (err) {
                return false;
            }

            return false;
        };



        //Method for rollbackchanges is error occured..
        $scope.rollBackChanges = function() {
            if (!$.isEmptyObject(backupData)) {
                $scope.displayed.forEach(function(data, index) {
                    if (data.id === backupData.id && !$.isEmptyObject(backupData)) {
                        //rollback changes..
                        $scope.displayed[index] = backupData;
                        //Reset backup data..
                        backupData = {};
                        return false;
                    }
                });
            }
        };




        /**
         * Check if to display the properties of the table or not.
         * schema {
         * 	tables:{
         * 		username:{
         * 			"display": false
         * 		}
         * 	}
         * }
         */
        $scope.displayProperties = function(schema, header) {
            //First convert the header to optimal type..
            header = header.replace(/\./, "_");
            if (schema.tables) {
                if (schema.tables[header]) {
                    if (schema.tables[header].display !== undefined) {
                        if (!schema.tables[header].display) {
                            return false;
                        }
                    }
                }
            }
            return true;
        };



        $scope.resetBackup = function() {
            backupData = {};
            $scope.saveFormData = {};
        };




        /**
         * Model for storing the model structure..
         * @param formStructure
         * @param formModel
         * @param formID refrencing to the id attribute of the  form.
         */
        $scope.saveForm = function(formStructure, formData, formModel, goBack, modelInstance) {
            if(ImageUploadingTracker.isUploadInProgress()){
                SnaphyTemplate.notify({
                    message: "Wait!! Image uploading is in progress. Please wait till the image is uploaded.",
                    type: 'danger',
                    icon: 'fa fa-times',
                    align: 'right'
                });
                return false;
            }

            if (!$scope.isValid(formData)) {
                SnaphyTemplate.notify({
                    message: "Error data is Invalid.",
                    type: 'danger',
                    icon: 'fa fa-times',
                    align: 'right'
                });

                //If edit was going on revert back..
                if (formModel.id) {
                    $scope.rollBackChanges();
                }
            } else {
                //Now save the model..
                var baseDatabase = Database.loadDb(formStructure.model);

                var schema = {
                    "relation": $scope.schema.relations
                };

                var requestData = {
                    data: formModel,
                    schema: schema
                };

                //create a copy of the data..
                var savedData = angular.copy(formModel);
                var positionNewData;
                var update;
                if (formModel.id) {
                    update = true;

                } else {
                    positionNewData = $scope.displayed.length;
                    //First add to the table..
                    $scope.displayed.push(savedData);
                    update = false;
                }


                //Now save||update the database with baseDatabase method.
                baseDatabase.save({}, requestData, function(baseModel) {
                    if (!update) {
                        //Now update the form with id.
                        $scope.displayed[positionNewData].id = baseModel.data.id;
                    }
                    SnaphyTemplate.notify({
                        message: "Data successfully saved.",
                        type: 'success',
                        icon: 'fa fa-check',
                        align: 'right'
                    });
                }, function(err) {
                    //console.log("Error saving data to server");
                    //console.error(respHeader);
                    if (update) {
                        $scope.rollBackChanges();
                    } else {
                        //remove the form added data..
                        if (positionNewData > -1) {
                            $scope.displayed.splice(positionNewData, 1);
                        }
                    }

                    //THen show error with respect to error list..
                    if(errorList){
                        var foundObj;
                        if(errorList.length){
                            errorList.forEach(function(statusObj){
                                //console.log(statusObj);
                                if(statusObj.code.toString() === err.status.toString()){
                                    foundObj = statusObj;
                                }
                            });
                            if(foundObj){
                                //console.error(respHeader);
                                SnaphyTemplate.notify({
                                    message: foundObj.message,
                                    type: 'danger',
                                    icon: 'fa fa-times',
                                    align: 'right'
                                });
                            }else{
                                //console.error(respHeader);
                                SnaphyTemplate.notify({
                                    message: "Error saving data.",
                                    type: 'danger',
                                    icon: 'fa fa-times',
                                    align: 'right'
                                });
                            }
                        }else{
                            //console.error(respHeader);
                            SnaphyTemplate.notify({
                                message: "Error saving data.",
                                type: 'danger',
                                icon: 'fa fa-times',
                                align: 'right'
                            });
                        }
                    }else{
                        //console.error(respHeader);
                        SnaphyTemplate.notify({
                            message: "Error saving data.",
                            type: 'danger',
                            icon: 'fa fa-times',
                            align: 'right'
                        });
                    }
                });

                //Now reset the form..
                resetSavedForm(formData);
                closeModel(goBack, modelInstance);

            }
        }; //saveForm


        // Used in  the automata to get the table values..
        $scope.getTagInfo = function(tableSchema, colKey, rowObject, header) {
            var tableConfig = $scope.findModelPropertyTableConfig(tableSchema, colKey);
            var colValue = $scope.getColValue(rowObject, header);
            return tableConfig.tag[colValue];
        };



        //Goback or close the model..
        var closeModel = function(goBack, modelInstance) {
            //Reset the image upload if any...
            ImageUploadingTracker.resetTracker();

            if (goBack) {
                if (modelInstance) {
                    //close the model..
                    $(modelInstance).modal('hide');
                } else {
                    //go back to parent state..
                    $scope.goToParentState();
                }
            }
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


        var addRelationDummyValue = function(relationArr, element, value) {
            relationArr.forEach(function(rel) {
                //if relationtype is hasManyThrough
                if (Object.prototype.toString.call(rel) === "[object Object]") {
                    if (rel.relationName) {
                        element[rel.relationName] = value;
                    }
                } else {
                    if (!element[rel]) {
                        element[rel] = value;
                    }
                }
            });
            return element;
        };



        //Initialize default names of the current state..
        var init = function() {
            for (var i = 0; i < $scope.databasesList.length; i++) {
                if (currentState.toLowerCase().trim() === $scope.databasesList[i].toLowerCase().trim()) {
                    $scope.tableTitle = currentState + ' ' + 'Data';
                    $scope.currentState = currentState;
                    $scope.title = currentState + ' Console';
                    $scope.description = "Data management console.";
                    break;
                }
            }
        };



        var getDatabase = function(databaseName, tableState, ctrl){
            if (!$scope.stCtrl && ctrl) {
                $scope.stCtrl = ctrl;
            }
            if (!tableState && $scope.stCtrl) {
                $scope.stCtrl.pipe();
                return;
            }

            $scope.isLoading = true;
            var pagination = tableState.pagination;
            var start = pagination.start || 0; // This is NOT the page number, but the index of item in the list that you want to use to display the table.
            var number = pagination.number || 10; // Number of entries showed per page.
            //Add the loading bar..
            if (tablePanelId) {
                $timeout(function() {
                    //Now hide remove the refresh widget..
                    $(tablePanelId).addClass('block-opt-refresh');
                }, 200);
            }
            if ($.isEmptyObject($scope.schema )) {

                //First get the schema..
                Resource.getSchema(databaseName, function(schema) {
                    //Populate the schema..
                    $scope.schema = schema;
                    //console.log(schema);
                    $scope.where = $scope.where || {};

                    Resource.getPage(start, number, tableState, databaseName, schema, $scope.where).then(function(result) {
                        $scope.displayed = result.data;
                        tableState.pagination.numberOfPages = result.numberOfPages; //set the number of pages so the pagination can update
                        $scope.pagesReturned = result.numberOfPages;
                        $scope.totalResults = result.count;
                        $scope.isLoading = false;
                        dataFetched = true;
                        if (tablePanelId) {
                            $timeout(function() {
                                //Now hide remove the refresh widget..
                                $(tablePanelId).removeClass('block-opt-refresh');
                            }, 200);
                        }
                    });
                }, function(httpResp){
                    console.error(httpResp);
                    if (tablePanelId) {
                        $timeout(function() {
                            //Now hide remove the refresh widget..
                            $(tablePanelId).removeClass('block-opt-refresh');
                        }, 200);
                    }
                });
            }else{
                Resource.getPage(start, number, tableState, databaseName, $scope.schema, $scope.where).then(function(result) {
                    $scope.displayed = result.data;
                    tableState.pagination.numberOfPages = result.numberOfPages; //set the number of pages so the pagination can update
                    $scope.pagesReturned = result.numberOfPages;
                    $scope.totalResults = result.count;
                    $scope.isLoading = false;
                    dataFetched = true;
                    if (tablePanelId) {
                        $timeout(function() {
                            //Now hide remove the refresh widget..
                            $(tablePanelId).removeClass('block-opt-refresh');
                        }, 200);
                    }
                },function(httpResp){
                    console.error(httpResp);
                    if (tablePanelId) {
                        $timeout(function() {
                            //Now hide remove the refresh widget..
                            $(tablePanelId).removeClass('block-opt-refresh');
                        }, 200);
                    }

                    //console.error(respHeader);
                    SnaphyTemplate.notify({
                        message: "Error occured. Please click on the reset button to go back to normal.",
                        type: 'danger',
                        icon: 'fa fa-times',
                        align: 'right'
                    });
                });
            }
        };

        $scope.refreshData = function(tableState, ctrl) {
            for (var i = 0; i < $scope.databasesList.length; i++) {
                if (currentState.toLowerCase().trim() === $scope.databasesList[i].toLowerCase().trim()) {
                    getDatabase($scope.databasesList[i], tableState, ctrl);
                    break;
                }
            }
        };

        $scope.resetTable = function(){

            //reset the table filters
            $scope.where = {};
            $scope.refreshData();
        };


        //Only load if the current scope is automata
        init();


    } //controller function..
]);
