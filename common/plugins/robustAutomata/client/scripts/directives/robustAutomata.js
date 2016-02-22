(function() {
    'use strict';
})();
/*global angular, $snaphy, jQuery, $,  BaseTableDatatables, browser, console*/


angular.module($snaphy.getModuleName())

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
.directive('robustFilterDate', ['$timeout', function($timeout) {

        return {
            restrict: 'E',
            scope: {
                "modelSettings": "=modelSettings",
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
                    //Now add a Reset method to the filter..
                    scope.$parent.addResetMethod(function() {
                        $($(iElement).find('input')).val('');
                    });

                    var prevFrom = "",
                        prevTo = "";

                    //Now applying date change event of the table..
                    $($(iElement).find('.input-daterange')).datepicker().on("changeDate", function() {
                        $timeout(function() {
                            var valuesList = $(iElement).find("input");
                            var from = $(valuesList[0]).val();
                            var to = $(valuesList[1]).val();
                            //Add this value to scope..
                            //scope.$parent.filterObj = scope.$parent.filterObj || {};
                            //scope.$parent.where = scope.$parent.where || {};
                            //scope.$parent.filterObj.where[scope.columnName] = scope.$parent.filterObj.where[scope.columnName]  || {};
                            //TODO REMOVE THE DIRECT CLEAR OF AND METHOD AND FIND SOME ALTERNATE SOLUTION..
                            scope.$parent.where.and = [];
                            //{"where": {and: [{"epoch_time": {"gte":1450717674}},{"epoch_time": {"lte":1459407675}}]} }
                            //Now push value to the  table..
                            //first clear previous data..
                            clear(scope.columnName);

                            if (from) {
                                var fromDate = {};
                                fromDate[scope.columnName] = {
                                    "gte": new Date(from)
                                };
                                scope.$parent.where.and.push(fromDate);
                                //prevFrom = from;
                            }

                            if (to) {
                                var toDate = {};
                                toDate[scope.columnName] = {
                                    "lte": new Date(to)
                                };
                                scope.$parent.where.and.push(toDate);
                                //prevTo = to;
                            }
                            //Now redraw the table...
                            scope.$parent.refreshData();
                        });
                    });



                    //Clear previous value of column data..
                    var clear = function(column) {
                        var delIndex = []
                        scope.$parent.where.and.forEach(function(and, index) {
                            prepareDeleteIndex(and, column, delIndex, index);
                        });

                        delIndex.forEach(function(index) {
                            scope.$parent.where.and.splice(index, 1);
                        })
                    }


                    var prepareDeleteIndex = function(and, column, delIndex, index) {
                        for (var key in and) {
                            if (and.hasOwnProperty(key)) {
                                if (key === column) {
                                    delIndex.push(index);
                                }
                            }
                        }
                    }
                } //link function..
        }; //return
    }]) //filterDate directive





/**
 *Directive for defining filters $select
 * */
.directive('robustFilterSelect', ['$http', '$timeout', function($http, $timeout) {
        //TODO table header data initialization bugs.. this filter must not proceed before table header initialization..
        return {
            restrict: 'E',
            scope: {
                "modelSettings": "=modelSettings",
                "columnName": "@columnName",
                "label": "@label",
                "data": "=data",
                "getOptions": "@get",
                "staticOptions": "@options",
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
                    scope.data = {};
                    //initializing options..
                    scope.data.options = [];

                    //Now applying date change event of the table..
                    $($(iElement).find('.js-select2')).change(function() {
                        if (scope.data.value) {
                            $timeout(function() {
                                //scope.$parent.where = scope.$parent.where || {};
                                scope.$parent.where[scope.columnName] = scope.data.value;
                                //Now redraw the table...
                                scope.$parent.refreshData();

                            });
                        }
                    });


                    if (scope.staticOptions !== undefined) {
                        if (scope.staticOptions.length) {
                            $timeout(function() {
                                scope.data.options = JSON.parse(scope.staticOptions);
                            });
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


                            //TODO LOAD THE TABLE..
                        }, function errorCallback(response) {
                            // called asynchronously if an error occurs
                            // or server returns response with an error status.
                            console.error(response);
                        });
                    }

                    if (scope.filterOptions.getOptionsFromColumn) {
                        //Fetch data from column..
                        //RIGHT NOW ITS SUPPORTING ONLY STATIC FIELDS
                        //TODO ADD SUPPORT FOR DISTINCT QUERY TO BE ACCEPTED FROM COLUMN.

                    }

                    //Now add a Reset method to the filter..
                    scope.$parent.addResetMethod(function() {
                        scope.data.value = "";
                        //Now reinitialize the
                        setTimeout(function() {
                            $($(iElement).find('select')).select2('val', 'All');
                        }, 0);
                    });

                } //link function..
        }; //return
    }]) //filterDate directive




/**
 *Directive for defining filters $multiSelect
 * */
.directive('robustFilterMultiSelect', ['$http', '$timeout', function($http, $timeout) {
        //TODO table header data initialization bugs.. this filter must not proceed before table header initialization..
        return {
            restrict: 'E',
            scope: {
                "modelSettings": "=modelSettings",
                "columnName": "@columnName",
                "label": "@label",
                "data": "=data",
                "getOptions": "@get",
                "staticOptions": "@options",
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

                    scope.data = {};

                    //Now applying date change event of the table..
                    $($(iElement).find('.js-select2')).change(function() {
                        //only draw if value is legitimate..
                        if (scope.data.value) {
                            if (scope.data.value.length) {
                                $timeout(function() {
                                    scope.$parent.where = scope.$parent.where || {};
                                    scope.$parent.where[scope.columnName] = scope.$parent.where[scope.columnName] || {};
                                    scope.$parent.where[scope.columnName].inq = scope.data.value;
                                    //Now redraw the table...
                                    scope.$parent.refreshData();
                                });
                            } else {
                                scope.data.value = null;
                                if (scope.$parent.where[scope.columnName]) {
                                    if (scope.$parent.where[scope.columnName].inq) {
                                        $timeout(function() {
                                            delete scope.$parent.where[scope.columnName];
                                            //Now redraw the table...
                                            scope.$parent.refreshData();
                                        });
                                    }
                                }
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
                    /*
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
                                                } //if*/

                    //Now add a Reset method to the filter..
                    scope.$parent.addResetMethod(function() {
                        scope.data.value = null;
                        //Now reinitialize the
                        setTimeout(function() {
                            $($(iElement).find('select')).select2();
                        }, 0);
                    });


                } //link function..
        }; //return
    }]) //filterDate directive




/**
 *Directive for defining filters $radio
 * */
.directive('robustFilterRadio', ['$timeout', function($timeout) {
        //TODO table header data initialization bugs.. this filter must not proceed before table header initialization..
        return {
            restrict: 'E',
            scope: {
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
                    scope.data = {};
                    scope.data.options = JSON.parse(scope.options);
                    scope.valueChanged = function() {
                        //only draw if value is legitimate..
                        if (scope.data.value) {
                            $timeout(function() {
                                scope.$parent.where = scope.$parent.where || {};
                                scope.$parent.where[scope.columnName] = scope.data.value;
                                //Now redraw the table...
                                scope.$parent.refreshData();
                            });
                        }
                    };
                    //Now add a Reset method to the filter..
                    scope.$parent.addResetMethod(function() {
                        scope.data.value = null;
                    });
                } //link function..
        }; //return
    }]) //filterDate directive

// TODO Array filter scheduled for later
//
//
//
.directive('robustWidgetAdded', ['Database', '$timeout', function(Database, $timeout) {
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
                        //{"where": {and: [{"epoch_time": {"gte":1450717674}},{"epoch_time": {"lte":1459407675}}]} }
                        today = moment().startOf('day');
                        var tmrwString =  moment(moment().startOf('day')).add(1, 'days').toISOString();
                        if (propObj.type.trim() === "$today") {
                            tomorrow = moment(today).add(1, 'days');
                            if (propObj.dateProp) {
                                propObj.where.and = [];
                                //between: [today, tomorrow]
                                //console.log("today count ", [today.toISOString(), tomorrow.toISOString()]);
                                var fromObj = {};
                                fromObj[propObj.dateProp] = {"gte": moment().startOf('day').toISOString()};
                                propObj.where.and.push(fromObj);
                                var toObj = {};
                                toObj[propObj.dateProp] = {"lte": tomorrow.toISOString()};
                                propObj.where.and.push(toObj);
                            } //if
                            else {
                                console.error("Error:  `dateProp` property name is needed in  the widget filter.");
                            }
                        } else if (propObj.type.trim() === "$week") {
                            weekStartDate = today.subtract(7, 'days');
                            if (propObj.dateProp) {
                                propObj.where.and = [];
                                var fromObj = {};
                                fromObj[propObj.dateProp] = {"gte": weekStartDate.toISOString()};
                                propObj.where.and.push(fromObj);
                                var toObj = {};
                                toObj[propObj.dateProp] = {"lte": tmrwString  };
                                propObj.where.and.push(toObj);
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

                    var fetchDataFromServer = function() {
                        var where = prepareWhereObj(scope.propObj);
                        var modelService = Database.loadDb(scope.model);
                        //Now fetch the data from the server..
                        modelService.count({
                            where: where
                        }, function(value, responseHeaders) {
                            $timeout(function(){
                                console.log(value);
                                //Now populate the value..
                                scope.value = value.count;
                            });

                        }, function(respHeader) {
                            console.error("Error fetching widget data from the server.");
                        }); //modelService
                    };

                    //Now initialize the directive..
                    var init = function() {
                            // watch for local data change..
                            scope.$watch('modelValues.length', function() {
                                fetchDataFromServer();
                            });
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
