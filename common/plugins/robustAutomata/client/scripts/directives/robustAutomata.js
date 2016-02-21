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
.directive('robustFilterDate', [function() {

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
                        //clear(scope.columnName);
                        //scope.$parent.filterObj.where.and = [];
                    });

                    var prevFrom = "",
                        prevTo = "";

                    //Now applying date change event of the table..
                    $($(iElement).find('.input-daterange')).datepicker().on("changeDate", function() {
                        var valuesList = $(iElement).find("input");
                        var from = $(valuesList[0]).val();
                        var to = $(valuesList[1]).val();
                        //Add this value to scope..
                        scope.$parent.filterObj = scope.$parent.filterObj || {};
                        scope.$parent.filterObj.where = scope.$parent.filterObj.where || {};
                        //scope.$parent.filterObj.where[scope.columnName] = scope.$parent.filterObj.where[scope.columnName]  || {};
                        //TODO REMOVE THE DIRECT CLEAR OF AND METHOD AND FIND SOME ALTERNATE SOLUTION..
                        scope.$parent.filterObj.where.and = [];
                        //{"where": {and: [{"epoch_time": {"gte":1450717674}},{"epoch_time": {"lte":1459407675}}]} }
                        //Now push value to the  table..
                        //first clear previous data..
                        clear(scope.columnName);

                        if (from) {
                            var fromDate = {};
                            fromDate[scope.columnName] = {
                                "gte": new Date(from)
                            };
                            scope.$parent.filterObj.where.and.push(fromDate);
                            //prevFrom = from;
                        }

                        if (to) {
                            var toDate = {};
                            toDate[scope.columnName] = {
                                "lte": new Date(to)
                            };
                            scope.$parent.filterObj.where.and.push(toDate);
                            //prevTo = to;
                        }




                        //Now redraw the table...
                        scope.$parent.refreshData();
                    });

                    //Clear previous value of column data..
                    var clear = function(column) {
                        var delIndex = []
                        scope.$parent.filterObj.where.and.forEach(function(and, index) {
                            prepareDeleteIndex(and, column, delIndex, index);
                        });

                        delIndex.forEach(function(index) {
                            scope.$parent.filterObj.where.and.splice(index, 1);
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
    .directive('robustFilterSelect', ['$http', function($http) {
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
                            if(scope.data.value){
                                //In this case add exact where query..
                                scope.$parent.filterObj = scope.$parent.filterObj || {};
                                scope.$parent.filterObj.where = scope.$parent.filterObj.where || {};
                                scope.$parent.filterObj.where[scope.columnName] = scope.data.value;
                                console.log(scope.$parent.filterObj.where);
                                //Now redraw the table...
                                scope.$parent.refreshData();
                            }
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
