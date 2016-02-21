(function() {
    'use strict';
})();
/*global angular, $snaphy, jQuery, $,  BaseTableDatatables, browser, console*/

angular.module($snaphy.getModuleName())


.directive('snaphyLoadDatatable', ['$timeout', function($timeout) {
    return {
        restrict: 'A',
        compile: function() {
            // Compile code goes here.
            return {
                post: function postLink() {
                    // Post-link code goes here
                    $timeout(function() {
                        try {
                            // Initialize when page loads
                            jQuery(function() {
                                BaseTableDatatables.init();
                            });
                        } catch (err) {
                            /*Do nothing error occured due to multiple table initialization.. */
                        }

                    }); //timeout method..
                }
            };
        },
        link: function() {
                /*Methods moved to compile for one time call only..*/
            } //End of Link function...
    }; // End of return
}])




//On save modal close..reset the form..
.directive('onModalClose', ['$timeout', function($timeout) {
    return {
        restrict: 'A',
        link: function(scope, iElement, iAttrs) {
                $(iElement).on('hidden.bs.modal', function() {
                    //Reset the data..
                    if (scope.resetSavedForm) {
                        $timeout(function() {
                            scope.resetSavedForm(scope.schema.form);
                        }, 10);
                    }
                });
            } //End of Link function...
    }; // End of return
}])



/**
 *Directive for defining filters $date
 * */
//$date
.directive('filterDate', [function() {

        return {
            restrict: 'E',
            scope: {
                "modelSettings": "=modelSettings",
                "id": "@tableId",
                "columnName": "@columnName",
                "label": "@label"
            },
            replace: true,
            template: '<div class="form-group">' +
                '<label class="col-md-4 control-label" for="example-daterange1">{{label}}</label>' +
                '<div class="col-md-8">' +
                '<div class="input-daterange input-group" data-date-format="mm/dd/yyyy">' +
                '<input class="form-control" type="text"  name="daterange1" placeholder="From">' +
                '<span class="input-group-addon"><i class="fa fa-chevron-right"></i></span>' +
                '<input class="form-control" type="text"  name="daterange2" placeholder="To">' +
                '</div>' +
                '</div>' +
                '</div>',
            link: function(scope, iElement, iAttrs) {
                    //First get the table id.
                    if (scope.id === "") {
                        console.error("An table Id value is needed for filters to operate.");
                        return null;
                    }


                    //Removing the # tag from id if placed. to avoid duplicity of #
                    scope.id = scope.id.replace(/^\#/, '');
                    scope.tableId = '#' + scope.id;


                    //Now applying date change event of the table..
                    $($(iElement).find('.input-daterange')).datepicker().on("changeDate", function() {
                        //Now just
                        //Getting the instance of the table..
                        var table = $(scope.tableId).DataTable();
                        //Now redraw the tables..
                        table.draw();
                    });



                    //Now add a Reset method to the filter..
                    scope.$parent.addResetMethod(function() {
                        $($(iElement).find('input')).val('');
                    });



                    var allowFilter = [scope.id];

                    //Now run the daterange filter..
                    //Now setting the retailer added filter...
                    $.fn.DataTable.ext.search.push(
                        function(settings, data, dataIndex) {
                            // check if current table is part of the allow list
                            if ($.inArray(settings.nTable.getAttribute('id'), allowFilter) == -1) {
                                // if not table should be ignored
                                return true;
                            }

                            var columnDataId;

                            var index = 0;
                            //Now get the column id where the wanted data is placed..
                            for (var i = 0; i < scope.modelSettings.header.length; i++) {

                                var skip = false;
                                //Skip the column where table display == false..
                                if (scope.modelSettings.tables) {
                                    var tableProperties = scope.modelSettings.tables;
                                    var header = scope.modelSettings.header[i];
                                    if (tableProperties[header]) {
                                        var tableProp = tableProperties[header];

                                        if (tableProp) {
                                            if(tableProp.display !== undefined){
                                                if (tableProp.display) {
                                                    skip = false;
                                                } else {
                                                    skip = true;
                                                }
                                            }
                                            else{
                                                skip = false;
                                            }

                                        }
                                    }
                                }

                                if (skip) {
                                    //Do nothing here..
                                } else {
                                    if (scope.modelSettings.header[i] === scope.columnName) {
                                        columnDataId = index;
                                        break;
                                    }
                                    index++;
                                }

                            } //for loop.

                            if(columnDataId === undefined){
                                return true;
                            }



                            var valuesList = $(iElement).find("input");
                            var from = $(valuesList[0]).val();
                            var to = $(valuesList[1]).val();

                            //Getting the orderMin value..
                            if (from && to) {
                                from = new Date(from);
                                to = new Date(to);

                                //Convert to format mm/dd/yyyy
                                var convertDateFormat = function(date) {
                                    var givenDate = new Date(date);
                                    var dd = givenDate.getDate();
                                    var mm = givenDate.getMonth() + 1; //January is 0!

                                    var yyyy = givenDate.getFullYear();
                                    if (dd < 10) {
                                        dd = '0' + dd;
                                    }
                                    if (mm < 10) {
                                        mm = '0' + mm;
                                    }
                                    var formatDate = mm + '/' + dd + '/' + yyyy;
                                    return new Date(formatDate);
                                };

                                if(data[columnDataId] === undefined){
                                    return true;
                                }

                                //Parsing value for column Retailers added date..
                                var columnDate = convertDateFormat(data[columnDataId].trim());
                                if (from <= columnDate && columnDate <= to) {
                                    return true; //Show that row..

                                }
                                return false;

                            } else {
                                return true; //Show all rows..
                            }
                        }
                    ); //End of dataTable function for retailer added filter.....

                } //link function..
        }; //return
    }]) //filterDate directive



/**
 *Directive for defining filters $select
 * */
.directive('filterSelect', ['$http', function($http) {
        //TODO table header data initialization bugs.. this filter must not proceed before table header initialization..
        return {
            restrict: 'E',
            scope: {
                "modelSettings": "=modelSettings",
                "id": "@tableId",
                "columnName": "@columnName",
                "label": "@label",
                "data": "=data",
                "getOptions": "@get",
                "staticOptions": "@options",
                "tableData": "=tableData",
                "dataType": "=dataType",
                "filterOptions": "=filterOptions"
            },
            replace: true,
            template: '<div class="form-group">' +
                '<label class="col-md-4 control-label" for="example-select2">{{label}}</label>' +
                '<div class="col-md-8">' +
                '<select class="js-select2 form-control" ng-model="data.value" style="width: 100%;" data-placeholder="Choose one..">' +
                '<option value="" >All</option>' +
                '<option ng-repeat="option in data.options" value="{{option.name}}">{{option.name}}</option>' +
                '</select>' +
                '</div>' +
                '</div>',
            link: function(scope, iElement) {
                    //First get the table id.
                    if (scope.id === "") {
                        console.error("An table Id value is needed for filters to operate.");
                        return null;
                    }

                    console.log(scope.filterOptions);

                    scope.data = {};
                    //initializing options..
                    scope.data.options = [];

                    //Removing the # tag from id if placed. to avoid duplicity of #
                    scope.id = scope.id.replace(/^\#/, '');
                    scope.tableId = '#' + scope.id;


                    //Now applying date change event of the table..
                    $($(iElement).find('.js-select2')).change(function() {
                        var table = $(scope.tableId).DataTable();
                        //Now redraw the tables..
                        table.draw();
                    });


                    if (scope.staticOptions !== undefined) {
                        if (scope.staticOptions.length) {
                            //console.log(JSON.parse(scope.staticOptions));
                            scope.data.options = JSON.parse(scope.staticOptions);
                            //scope.data.options = scope.staticOptions;
                        }
                    }


                    //Now load options..
                    if (scope.getOptions) {
                        $http({
                            method: 'GET',
                            url: scope.getOptions
                        }).then(function successCallback(response) {
                            //Select options downloaded successfully..
                            scope.data.options = response;
                        }, function errorCallback(response) {
                            // called asynchronously if an error occurs
                            // or server returns response with an error status.
                            console.error(response);
                        });
                    }


                    //If data is to be fetched from some table column.
                    if (scope.filterOptions.getOptionsFromColumn) {
                        var relatedColumnName;
                        //If the column is a key name from a related model.
                        var isRelationModel;

                        console.log(scope.tableData);
                        console.log(scope.$parent.dataValues);
                        //ForEach loop for each table object..
                        scope.tableData.forEach(function(rowObject, index) {
                            var rowKey = scope.$parent.getKey(rowObject, scope.columnName);

                            if (rowObject[rowKey] === undefined) {
                                isRelationModel = true;
                            } else {
                                isRelationModel = false;
                            }

                            //options format will be {id:1, name: foo}
                            var rowValue = rowObject[rowKey];

                            //The the column is a related column..
                            if (isRelationModel) {
                                relatedColumnName = scope.$parent.getColumnKey(scope.columnName);
                                rowValue = rowObject[relatedColumnName];
                            }
                            var searchProp;
                            //If the column is of object type
                            var dataType = scope.filterOptions.dataType;
                            if(dataType){
                                if(dataType.type === "object"){
                                    searchProp = dataType.searchProp;
                                    rowValue = rowValue[searchProp];
                                }
                            }

                            if(rowValue === undefined){
                                return true;
                            }

                            //Now prepare the object..
                            var option = {
                                id: rowObject.id,
                                name: rowValue
                            };
                            scope.data.options = scope.data.options || [];
                            //Now push the options to populate finally...
                            scope.data.options.push(option);
                        });
                    } //if



                    //Now add a Reset method to the filter..
                    scope.$parent.addResetMethod(function() {
                        scope.data.value = "";
                        //Now reinitialize the
                        setTimeout(function() {
                            $($(iElement).find('select')).select2('val', 'All');
                        }, 0);
                    });


                    //Now load search filters..
                    var allowFilter = [scope.id];

                    //Now setting the retailer added filter...
                    $.fn.DataTable.ext.search.push(
                        function(settings, data, dataIndex) {
                            // check if current table is part of the allow list
                            if ($.inArray(settings.nTable.getAttribute('id'), allowFilter) === -1) {
                                // if not table should be ignored
                                return true;
                            }
                            var columnDataId;
                            var selectValue = "";

                            var index = 0;
                            //Now get the column id where the wanted data is placed..
                            for (var i = 0; i < scope.modelSettings.header.length; i++) {

                                var skip = false;
                                //Skip the column where table display == false..
                                if (scope.modelSettings.tables) {
                                    var tableProperties = scope.modelSettings.tables;
                                    var header = scope.modelSettings.header[i];
                                    if (tableProperties[header]) {
                                        var tableProp = tableProperties[header];

                                        if (tableProp) {
                                            if (tableProp.display === undefined || tableProp.display === true) {

                                                skip = false;
                                            } else {

                                                skip = true;
                                            }
                                        }
                                    }
                                }

                                if (skip) {
                                    //Do nothing here..
                                } else {
                                    if (scope.modelSettings.header[i] === scope.columnName) {
                                        columnDataId = index;
                                        break;
                                    }
                                    index++;
                                }

                            } //for loop.
                            if(!columnDataId){
                                return true;
                            }

                            var columnValue = data[columnDataId];
                            //Getting the orderMin value..
                            if (scope.data.value && columnValue) {
                                if (scope.data.value.toString().toLowerCase().trim()  === columnValue.toString().toLowerCase().trim()) {
                                    return true; //Show that row..
                                }
                                return false;
                            } else {
                                return true; //Show all rows..
                            }
                        }
                    ); //End of dataTable function for retailer added filter.....
                } //link function..
        }; //return
    }]) //filterDate directive



/**
 *Directive for defining filters $multiSelect
 * */
.directive('filterMultiSelect', ['$http', function($http) {
        //TODO table header data initialization bugs.. this filter must not proceed before table header initialization..
        return {
            restrict: 'E',
            scope: {
                "modelSettings": "=modelSettings",
                "id": "@tableId",
                "columnName": "@columnName",
                "label": "@label",
                "data": "=data",
                "getOptions": "@get",
                "staticOptions": "@options",
                "tableData": "=tableData",
                "dataType": "=dataType",
                "filterOptions": "=filterOptions"
            },
            replace: true,
            template: '<div class="form-group">' +
                '<label class="col-md-4 control-label" for="example-select2">{{label}}</label>' +
                '<div class="col-md-8">' +
                '<select data-allow-clear="true" class="js-select2 form-control" ng-model="data.value" style="width: 100%;" data-placeholder="Choose many.." multiple>' +
                '<option ng-repeat="option in data.options | unique:\'id\'" value="{{option.name}}">{{option.name}}</option>' +
                '</select>' +
                '</div>' +
                '</div>',
            link: function(scope, iElement, iAttrs) {
                    //First get the table id.
                    if (scope.id === "") {
                        console.error("An table Id value is needed for filters to operate.");
                        return null;
                    }


                    scope.data = {};
                    //initializing options..


                    //Removing the # tag from id if placed. to avoid duplicity of #
                    scope.id = scope.id.replace(/^\#/, '');
                    scope.tableId = '#' + scope.id;


                    //Now applying date change event of the table..
                    $($(iElement).find('.js-select2')).change(function() {
                        var table = $(scope.tableId).DataTable();

                        //only draw if value is legitimate..
                        if (scope.data.value) {
                            if (scope.data.value.length) {
                                //Now redraw the tables..
                                table.draw();
                            } else {
                                scope.data.value = null;
                                table.draw();
                            }
                        }
                    });


                    if (scope.staticOptions) {
                        if (scope.staticOptions.length) {

                            //Load static options..
                            scope.data.options = JSON.parse(scope.staticOptions);
                        }
                        //scope.data.options = scope.staticOptions;
                    }


                    //Now load options..
                    if (scope.getOptions) {
                        $http({
                            method: 'GET',
                            url: scope.getOptions
                        }).then(function successCallback(response) {
                            //Select options downloaded successfully..
                            //Loading options..
                            response.forEach(function(element, index) {
                                scope.data.options.push(element);
                            });

                        }, function errorCallback(response) {
                            // called asynchronously if an error occurs
                            // or server returns response with an error status.
                            console.error(response);
                        });
                    }

                    //If data is to be fetched from some table column.
                    if (scope.filterOptions.getOptionsFromColumn) {
                        var relatedColumnName;
                        //If the column is a key name from a related model.
                        var isRelationModel;


                        //ForEach loop for each table object..
                        scope.tableData.forEach(function(rowObject, index) {
                            var rowKey = scope.$parent.getKey(rowObject, scope.columnName);

                            if (rowObject[rowKey] === undefined) {
                                isRelationModel = true;
                            } else {
                                isRelationModel = false;
                            }

                            //options format will be {id:1, name: foo}
                            var rowValue = rowObject[rowKey];

                            //The the column is a related column..
                            if (isRelationModel) {
                                relatedColumnName = scope.$parent.getColumnKey(scope.columnName);
                                rowValue = rowObject[relatedColumnName];
                            }

                            var searchProp;
                            //If the column is of object type
                            var dataType = scope.filterOptions.dataType;
                            if(dataType){
                                if(dataType.type === "object"){
                                    searchProp = dataType.searchProp;
                                    rowValue = rowValue[searchProp];
                                }
                            }


                            if(rowValue === undefined){
                                return true;
                            }

                            //Now prepare the object..
                            var option = {
                                id: rowObject.id,
                                name: rowValue
                            };
                            if(rowValue){
                                scope.data.options = scope.data.options || [];
                                //Now push the options to populate finally...
                                scope.data.options.push(option);
                            }
                        });
                    } //if

                    //Now add a Reset method to the filter..
                    scope.$parent.addResetMethod(function() {
                        scope.data.value = null;
                        //Now reinitialize the
                        setTimeout(function() {
                            $($(iElement).find('select')).select2();
                        }, 0);
                    });


                    //Now load search filters..
                    var allowFilter = [scope.id];

                    //Now setting the retailer added filter...
                    $.fn.DataTable.ext.search.push(
                        function(settings, data, dataIndex) {
                            // check if current table is part of the allow list
                            if ($.inArray(settings.nTable.getAttribute('id'), allowFilter) == -1) {
                                // if not table should be ignored
                                return true;
                            }
                            var columnDataId;
                            var selectValue = "";

                            var index = 0;
                            //Now get the column id where the wanted data is placed..
                            for (var i = 0; i < scope.modelSettings.header.length; i++) {

                                var skip = false;
                                //Skip the column where table display == false..
                                if (scope.modelSettings.tables) {
                                    var tableProperties = scope.modelSettings.tables;
                                    var header = scope.modelSettings.header[i];
                                    if (tableProperties[header]) {
                                        var tableProp = tableProperties[header];

                                        if (tableProp) {
                                            if (tableProp.display === undefined || tableProp.display === true) {

                                                skip = false;
                                            } else {

                                                skip = true;
                                            }
                                        }
                                    }
                                }

                                if (skip) {
                                    //Do nothing here..
                                } else {
                                    if (scope.modelSettings.header[i] === scope.columnName) {
                                        columnDataId = index;
                                        break;
                                    }
                                    index++;
                                }

                            } //for loop.

                            //Parsing value for column Retailers added date..
                            var columnValue = data[columnDataId];

                            //Getting the orderMin value..
                            if (scope.data.value && columnValue) {
                                var matchFound = false;
                                console.log(selectValue, scope.data.value);
                                //If the value is present in the multi select then return true else false..
                                scope.data.value.forEach(function(data) {

                                    if (data.toString().toLowerCase().trim() === columnValue.toString().toLowerCase().trim()) {
                                        matchFound = true;
                                        return false;
                                    }
                                });

                                return matchFound;

                            } else {
                                return true; //Show all rows..
                            }
                        }
                    ); //End of dataTable function for retailer added filter.....
                } //link function..
        }; //return
    }]) //filterDate directive




    /**
     *Directive for defining filters $multiSelect
     * */
    .directive('filterArrayObjects', ['$http', function($http) {
            //TODO table header data initialization bugs.. this filter must not proceed before table header initialization..
            return {
                restrict: 'E',
                scope: {
                    "modelSettings" : "=modelSettings",
                    "id"            : "@tableId",
                    "columnName"    : "@columnName",
                    "label"         : "@label",
                    "data"          : "=data",
                    "getOptions"    : "@get",
                    "staticOptions" : "@options",
                    "tableData"     : "=tableData",
                    "filterOptions" : "=filterOptions",
                    "searchProp"    : "@searchProp"
                },
                replace: true,
                template: '<div class="form-group">' +
                    '<label class="col-md-4 control-label" for="example-select2">{{label}}</label>' +
                    '<div class="col-md-8">' +
                    '<select data-allow-clear="true" class="js-select2 form-control" ng-model="data.value" style="width: 100%;" data-placeholder="Choose many.." multiple>' +
                    '<option ng-repeat="option in data.options | unique:\'name\'" value="{{option.name}}">{{option.name}}</option>' +
                    '</select>' +
                    '</div>' +
                    '</div>',
                link: function(scope, iElement, iAttrs) {
                        //First get the table id.
                        if (scope.id === "") {
                            console.error("An table Id value is needed for filters to operate.");
                            return null;
                        }

                        scope.data = {};

                        //Removing the # tag from id if placed. to avoid duplicity of #
                        scope.id = scope.id.replace(/^\#/, '');
                        scope.tableId = '#' + scope.id;

                        //Now applying date change event of the table..
                        $($(iElement).find('.js-select2')).change(function() {
                            var table = $(scope.tableId).DataTable();

                            //only draw if value is legitimate..
                            if (scope.data.value) {
                                if (scope.data.value.length) {
                                    //Now redraw the tables..
                                    table.draw();
                                } else {
                                    scope.data.value = null;
                                    table.draw();
                                }
                            }
                        });

                        if (scope.staticOptions) {
                            if (scope.staticOptions.length) {
                                //Load static options..
                                scope.data.options = JSON.parse(scope.staticOptions);
                            }
                        }


                        //Now load options..
                        if (scope.getOptions) {
                            $http({
                                method: 'GET',
                                url: scope.getOptions
                            }).then(function successCallback(response) {
                                //Select options downloaded successfully..
                                //Loading options..
                                response.forEach(function(element, index) {
                                    scope.data.options.push(element);
                                });

                            }, function errorCallback(response) {
                                // called asynchronously if an error occurs
                                // or server returns response with an error status.
                                console.error(response);
                            });
                        }

                        //If data is to be fetched from some table column.
                        if (scope.filterOptions.getOptionsFromColumn) {
                            var relatedColumnName;
                            //If the column is a key name from a related model.
                            var isRelationModel;

                            //ForEach loop for each table object..
                            scope.tableData.forEach(function(rowObject, index) {
                                var rowKey = scope.$parent.getKey(rowObject, scope.columnName);

                                if (rowObject[rowKey] === undefined) {
                                    isRelationModel = true;
                                } else {
                                    isRelationModel = false;
                                }

                                //options format will be {id:1, name: foo}
                                var rowValue = rowObject[rowKey];

                                //The the column is a related column..
                                if (isRelationModel) {
                                    relatedColumnName = scope.$parent.getColumnKey(scope.columnName);
                                    rowValue = rowObject[relatedColumnName];
                                }

                                if(rowValue !== undefined){
                                    //Since rowValue is array of objects.
                                    rowValue.forEach(function(element){
                                        if(!element){
                                            return false;
                                        }

                                        var value = element[scope.searchProp];
                                        //Now prepare the object..
                                        var option = {
                                            name: value
                                        };
                                        if(rowValue){
                                            scope.data.options = scope.data.options || [];
                                            //Now push the options to populate finally...
                                            scope.data.options.push(option);
                                        }
                                    });
                                }


                            });
                        } //if

                        //Now add a Reset method to the filter..
                        scope.$parent.addResetMethod(function() {
                            scope.data.value = null;
                            //Now reinitialize the
                            setTimeout(function() {
                                $($(iElement).find('select')).select2();
                            }, 0);
                        });


                        //Now load search filters..
                        var allowFilter = [scope.id];

                        //Now setting the retailer added filter...
                        $.fn.DataTable.ext.search.push(
                            function(settings, data, dataIndex) {
                                // check if current table is part of the allow list
                                if ($.inArray(settings.nTable.getAttribute('id'), allowFilter) == -1) {
                                    // if not table should be ignored
                                    return true;
                                }
                                var columnDataId;

                                var index = 0;
                                //Now get the column id where the wanted data is placed..
                                for (var i = 0; i < scope.modelSettings.header.length; i++) {

                                    var skip = false;
                                    //Skip the column where table display == false..
                                    if (scope.modelSettings.tables) {
                                        var tableProperties = scope.modelSettings.tables;
                                        var header = scope.modelSettings.header[i];
                                        if (tableProperties[header]) {
                                            var tableProp = tableProperties[header];

                                            if (tableProp) {
                                                if (tableProp.display === undefined || tableProp.display === true) {

                                                    skip = false;
                                                } else {

                                                    skip = true;
                                                }
                                            }
                                        }
                                    }

                                    if (skip) {
                                        //Do nothing here..
                                    } else {
                                        if (scope.modelSettings.header[i] === scope.columnName) {
                                            columnDataId = index;
                                            break;
                                        }
                                        index++;
                                    }

                                } //for loop.

                                //Parsing value for column Retailers added date..
                                var columnValue = data[columnDataId];

                                try{
                                    //columnValue = JSON.parse(columnValue);
                                    if(columnValue === undefined){
                                        return true; //return all rows..
                                    }
                                }
                                catch(err){
                                    console.error("Bad column datatype");
                                }

                                //The value are in the form of strings like " palak   saag paneer "
                                columnValue = columnValue.trim();
                                columnValue = columnValue.split(/\s+/);

                                //Getting the orderMin value..
                                if (scope.data.value && columnValue) {
                                    var matchFound = false;

                                    for(var j=0; j<scope.data.value.length; j++ ){
                                        var selectedData = scope.data.value[j];

                                        //Now run a loop getting column array value of objects..
                                        for(var x = 0; x< columnValue.length; x++){
                                            var searchObj = columnValue[x];
                                            if(searchObj){
                                                //var searchVal = searchObj[scope.searchProp];
                                                if(selectedData.toString().toLowerCase().trim() === searchObj.toString().toLowerCase().trim()){
                                                    matchFound = true;
                                                    break;
                                                }
                                            }

                                        }

                                        if(matchFound){
                                            break;
                                        }
                                    }

                                    return matchFound;

                                } else {
                                    return true; //Show all rows..
                                }
                            }
                        ); //End of dataTable function for retailer added filter.....
                    } //link function..
            }; //return
        }]) //filterDate directive





/**
 *Directive for defining filters $radio
 * */
.directive('filterRadio', [function() {
        //TODO table header data initialization bugs.. this filter must not proceed before table header initialization..
        return {
            restrict: 'E',
            scope: {
                "id": "@tableId",
                "columnName": "@columnName",
                "label": "@label",
                "data": "=data",
                "options": "@options",
                "modelSettings": "=modelSettings"
            },
            replace: true,
            template: '<div class="form-group">' +
                '<label class="col-md-4 control-label" for="radio-group12">{{label}}</label>' +
                '<div class="col-xs-8">' +
                '<label ng-repeat="option in data.options" class="css-input css-radio css-radio-lg css-radio-primary push-10-r">' +
                '<input class="radio-filter" ng-change="valueChanged()" type="radio" name="radio-group" ng-model="data.value" ng-value="option.name" ng-checked="option.checked" ><span></span>{{option.name}}' +
                '</label>' +
                '</div>' +
                '</div>',
            link: function(scope, iElement, iAttrs) {
                    //First get the table id.
                    if (scope.id === "") {
                        console.error("An table Id value is needed for filters to operate.");
                        return null;
                    }


                    scope.data = {};
                    scope.data.options = JSON.parse(scope.options);

                    //initializing options..
                    //Removing the # tag from id if placed. to avoid duplicity of #
                    scope.id = scope.id.replace(/^\#/, '');
                    scope.tableId = '#' + scope.id;


                    scope.valueChanged = function() {
                        var table = $(scope.tableId).DataTable();
                        //only draw if value is legitimate..
                        if (scope.data.value) {
                            table.draw();
                        }
                    };


                    //Now add a Reset method to the filter..
                    scope.$parent.addResetMethod(function() {
                        scope.data.value = null;
                    });


                    //Now load search filters..
                    var allowFilter = [scope.id];

                    //Now setting the retailer added filter...
                    $.fn.DataTable.ext.search.push(
                        function(settings, data, dataIndex) {
                            // check if current table is part of the allow list
                            if ($.inArray(settings.nTable.getAttribute('id'), allowFilter) == -1) {
                                // if not table should be ignored
                                return true;
                            }
                            var columnDataId;
                            var index = 0;
                            //Now get the column id where the wanted data is placed..
                            for (var i = 0; i < scope.modelSettings.header.length; i++) {

                                var skip = false;
                                //Skip the column where table display == false..
                                if (scope.modelSettings.tables) {
                                    var tableProperties = scope.modelSettings.tables;
                                    var header = scope.modelSettings.header[i];
                                    if (tableProperties[header]) {
                                        var tableProp = tableProperties[header];

                                        if (tableProp) {
                                            if (tableProp.display) {
                                                skip = false;
                                            } else {
                                                skip = true;
                                            }
                                        }
                                    }
                                }

                                if (skip) {
                                    //Do nothing here..
                                } else {
                                    if (scope.modelSettings.header[i] === scope.columnName) {
                                        columnDataId = index;
                                        break;
                                    }
                                    index++;
                                }

                            }

                            //Getting the orderMin value..
                            if (scope.data.value) {
                                //Parsing value for column Retailers added date..
                                var columnValue = data[columnDataId];
                                if (scope.data.value.toLowerCase().trim() === columnValue.toLowerCase().trim()) {
                                    return true;
                                } else {
                                    return false;
                                }
                            } else {
                                return true; //Show all rows..
                            }
                        }
                    ); //End of dataTable function for retailer added filter.....
                } //link function..
        }; //return
    }]) //filterDate directive



.directive('snaphyWidgetAdded', ['Database', function(Database) {
    return {
        restrict: 'E',
        replace: true,
        scope: {
            'label': '@label',
            'model': '@model',
            'icon': '@icon',
            'propObj': '=propObj',
            'modelValues': '=modelValues',
            'fetchLocally': '=fetchLocally'
        },
        template: '<div>' +
            '<a class="block block-bordered block-link-hover3" style="cursor:pointer" >' +
            '<table class="block-table text-center">' +
            '<tbody>' +
            '<tr>' +
            '<td class="bg-gray-lighter border-r" style="width: 50%;">' +
            '<div class="push-30 push-30-t">' +
            '<i ng-class="icon" class="fa-3x text-black-op si"></i>' +
            '</div>' +
            '</td>' +
            '<td style="width: 50%;">' +
            '<div class="h1 font-w700"><span class="h2 text-muted">+</span> {{value}}</div>' +
            '<div class="h5 text-muted text-uppercase push-5-t">{{label}}</div>' +
            '</td>' +
            '</tr>' +
            '</tbody>' +
            '</table>' +
            '</a>' +
            '</div>',
        link: function(scope, iElement, iAttrs) {
                /**
                 * Format of the propObj should be
                 * {
                 * 		type: '$today'|| '$week' || '$allTime',
                 * 		where:{
                 * 			'email': 'robinskumar73'
                 * 		},
                 * 		dateProp: 'date'
                 * }
                 */
                var loadWidgets = (function() {
                    var prepareWhereObj = function(propObj) {
                        var today, tomorrow, weekStartDate;
                        today = moment().startOf('day');
                        if (propObj.type.trim() === "$today") {
                            tomorrow = moment(today).add(1, 'days');
                            if (propObj.dateProp) {
                                propObj.where[propObj.dateProp] = {
                                    between: [today, tomorrow]
                                };
                            } //if
                            else {
                                console.error("Error:  `dateProp` property name is needed in  the widget filter.");
                            }
                        } else if (propObj.type.trim() === "$week") {
                            weekStartDate = today.subtract(7, 'days');
                            if (propObj.dateProp) {
                                propObj.where[propObj.dateProp] = {
                                    between: [today, weekStartDate]
                                };
                            } //if
                            else {
                                console.error("Error:  `dateProp` property name is needed in  the widget filter.");
                            }
                        } //else if
                        else {
                            //  Do nothing
                        }
                        console.log(propObj.where);
                        return propObj.where;
                    };


                    var performDataLocally = function() {
                        var startDate, endDate;
                        startDate = moment().startOf('day');
                        //type: '$today'|| '$week' || '$allTime'
                        if (scope.propObj.type === '$today') {
                            endDate = moment(startDate).add(1, 'days');
                        } else if (scope.propObj.type === '$week') {
                            endDate = moment(startDate).add(1, 'days');
                            startDate = moment(startDate).subtract(7, 'days');
                        } else {
                            //do nothing..
                        }

                        var dateFilterGiven = false;
                        if (endDate) {
                            dateFilterGiven = true;
                        }

                        var totalCount = 0;

                        //Now run loop for the values ..
                        scope.modelValues.forEach(function(element, index) {
                            if (dateFilterGiven) {
                                var dateValue = element[scope.propObj.dateProp];
                                var range = moment().range(startDate, endDate);
                                var checkValue = range.contains(moment(new Date(dateValue)));
                                if (checkValue) {
                                    totalCount = countData(totalCount);
                                } //if checkValue
                            } else {
                                totalCount = countData(totalCount, element);
                            }
                        }); //scope.modelValues loop

                        //populate the value..
                        scope.value = totalCount;
                    }; //performDataLocally function

                    var countData = function(totalCount, element) {
                        //if the date properties is not given
                        if (scope.propObj.where) {
                            var wherePropertyPresent = false;
                            //Now check for the where prop.
                            for (var key in scope.propObj.where) {
                                if(element[key]){
                                    if (scope.propObj.where.hasOwnProperty(key)) {
                                        wherePropertyPresent = true;
                                        //Checking the value of the where object..
                                        if (scope.propObj.where[key].toString().trim() === element[key].toString().trim()) {
                                            //increment the value..
                                            totalCount++;

                                        }
                                    }
                                }
                            } //for
                            if (!wherePropertyPresent) {
                                totalCount++;
                            }
                        } //if
                        else {
                            totalCount++;
                        }
                        return totalCount;
                    };


                    var fetchDataFromServer = function() {
                        var where = prepareWhereObj(scope.propObj);
                        var modelService = Database.loadDb(model);
                        //Now fetch the data from the server..
                        modelService.count({
                            where: where
                        }, function(value, responseHeaders) {
                            //Now populate the value..
                            scope.value = value.number;
                        }, function(respHeader) {
                            console.error("Error fetching widget data from the server.");
                        }); //modelService
                    };

                    //Now initialize the directive..
                    var init = function() {
                        if (scope.fetchLocally) {
                            // watch for local data change..
                            scope.$watch('modelValues.length', function() {
                                performDataLocally();
                            });
                        } else {
                            fetchDataFromServer();
                        } //else

                    };
                    //Now finally return the init method.
                    return init;
                })();


                //Now finally load the widgets..
                loadWidgets();

            } //link..
    }; //return ..
}])



.directive('snaphyLoadFilters', ['$timeout', function($timeout) {
    return {
        restrict: 'A',
        link: function() {

                $timeout(function() {
                    $(function() {
                        // Init page helpers (BS Datepicker + BS Colorpicker + Select2 + Masked Input + Tags Inputs plugins)
                        App.initHelpers(['datepicker', 'select2']);
                    });
                }); //timeout method..
            } //End of Link function...
    }; // End of return
}]);
