(function(){'use strict';})();
/*jslint browser: true*/
/*global $, jQuery, $snaphy, angular*/
angular.module($snaphy.getModuleName())

//Autocomplete for selectize search..
.directive('autocomplete', ['Database', '$timeout', function(Database, $timeout) {
    // Runs during compile
    return {
        restrict: 'E',
        replace: true,
        transclude: true,
        scope:{
            "modelName"      : "@modelName",
            "searchProperty" : "@searchProperty",
            //Contains the value of the data.. that needs to be updated.
            "value"          : "=value"
        },
        template: '<select   ng-transclude></select>' ,
        link: function(scope, iElm, iAttrs, controller) {
            if(!scope.modelName || !scope.searchProperty){
                console.error("Error >>> searchProperty and modelName attributes are required");
                return false;
            }

            scope.placeholder = "Search ".toUpperCase() + scope.modelName.toUpperCase() + " " + scope.searchProperty.toUpperCase();
            $(iElm).attr("placeholder", scope.placeholder);

            var selectize_ = $(iElm).selectize({
                maxItems: 1,
                valueField: 'id',
                labelField: scope.searchProperty,
                searchField: scope.searchProperty,
                delimiter: ',',
                persist: false,
                create: false,
                render: {
                    option: function(item, escape) {
                        return '<div class="row">' +
                            (item[scope.searchProperty] ? '<span class="col-md-3 " ><strong>' + escape(item[scope.searchProperty]) + '</strong></span>' : '') +
                            '</div>';
                    }
                },
                load: function(query, callback) {
                    if (!query.length) return callback();
                    var that = this;
                    //Now fetch data from the database.
                    var dbService = Database.loadDb(scope.modelName);
                    var whereObj = {};
                    whereObj[scope.searchProperty] = {};
                    whereObj[scope.searchProperty].like = query;

                    dbService.find({
                        filter: {
                            limit: 10,
                            where: whereObj
                        }
                    }, function(values, headers) {
                        callback(values);
                    }, function(httpResp) {
                        console.log(httpResp);
                        callback();
                    });
                }, //load function..

                onItemAdd: function(value, $item){
                    var select = $(iElm).selectize();
                    var selectize = select[0].selectize;
                    //Add this value to the scope.
                    var val = $.map(selectize.items, function(value) {
                        return selectize.options[value];
                    });
                    $timeout(function () {
                        //remove the order attribute of selectize..
                        if(val[0].$order){
                            delete val[0].$order;
                        }
                        scope.value = val[0];
                    }, 0);

                }
            }); //END OF Selectize function..

            //adding items programatically..
            function addValue(item){
                var select = $(iElm).selectize();
                var selectize = select[0].selectize;
                var obj = {};
                obj.id = item.id;
                obj[scope.searchProperty] = item[scope.searchProperty];

                selectize.addOption(obj);
                selectize.addItem(item.id);
            }


            scope.$watch('value', function(){
                if(!$.isEmptyObject(scope.value)){
                    //check if the selectize has that value in options if not then load it..
                    var select = $(iElm).selectize();
                    var selectize = select[0].selectize;
                    //Add this value to the scope.
                    var val = $.map(selectize.items, function(value) {
                        return selectize.options[value];
                    });
                    if(val.length === 0){
                        //Now check if the model has value or not..
                        if(!$.isEmptyObject(scope.value)){
                            //Now add data
                            addValue(scope.value);
                        }
                    }
                }
                else{
                    $timeout(function(){
                        var select = $(iElm).selectize();
                        var selectize = select[0].selectize;
                        selectize.clear();
                    }, 0);
                }

            });

        } //LInk  function
    }; //END Return
}])




//Autocomplete for multi data add..
.directive('multiSearch', ['Database', '$timeout', function(Database, $timeout) {
    // Runs during compile
    return {
        restrict: 'E',
        replace: true,
        transclude: true,
        scope:{
            "modelName"      : "@modelName",
            "searchProperty" : "@searchProperty",
            //Contains the value of the data.. that needs to be updated.
            "value"          : "=value"
        },
        template: '<select class="selectize"  ng-transclude></select>' ,
        link: function(scope, iElm, iAttrs, controller) {
            if(!scope.modelName || !scope.searchProperty){
                console.error("Error >>> searchProperty and modelName attributes are required");
                return false;
            }

            scope.placeholder = "Search ".toUpperCase() + scope.modelName.toUpperCase() + " " + scope.searchProperty.toUpperCase();
            $(iElm).attr("placeholder", scope.placeholder);

            var selectize_ = $(iElm).selectize({
                maxItems: 10,
                valueField: 'id',
                labelField: scope.searchProperty,
                searchField: scope.searchProperty,
                delimiter: ',',
                persist: false,
                create: false,
                render: {
                    option: function(item, escape) {
                        return '<div class="row">' +
                            (item[scope.searchProperty] ? '<span class="col-md-3 " ><strong>' + escape(item[scope.searchProperty]) + '</strong></span>' : '') +
                            '</div>';
                    }
                },
                load: function(query, callback) {
                    if (!query.length) return callback();
                    var that = this;
                    //Now fetch data from the database.
                    var dbService = Database.loadDb(scope.modelName);
                    var whereObj = {};
                    whereObj[scope.searchProperty] = {};
                    whereObj[scope.searchProperty].like = query;

                    dbService.find({
                        filter: {
                            limit: 10,
                            where: whereObj
                        }
                    }, function(values, headers) {
                        callback(values);
                    }, function(httpResp) {
                        console.log(httpResp);
                        callback();
                    });
                }, //load function..

                onItemAdd: function(value){
                    var select = $(iElm).selectize();
                    var selectize = select[0].selectize;
                    //Add this value to the scope.
                    var val = $.map(selectize.items, function(value) {
                        return selectize.options[value];
                    });

                    if(scope.value === undefined){
                        scope.value = [];
                    }
                    var indexFound;
                    for(var i=0; i < val.length; i++){
                        if( parseInt(val[i].id) === parseInt(value)){
                            indexFound = i;
                            break;
                        }
                    }

                    //remove the order attribute of selectize..
                    $timeout(function () {
                        if(val[indexFound].$order){
                            delete val[indexFound].$order;
                        }
                        //first check if the data doesnot
                        scope.value.push(val[indexFound]);
                    }, 0);
                }
            }); //END OF Selectize function..


            //adding items programatically..
            function addValue(item){
                var select = $(iElm).selectize();
                var selectize = select[0].selectize;
                var obj = {};
                obj.id = item.id;
                obj[scope.searchProperty] = item[scope.searchProperty];

                selectize.addOption(obj);
                selectize.addItem(item.id);
            }


            scope.$watch('value', function(){
                var select = $(iElm).selectize();
                var selectize = select[0].selectize;
                //Add this value to the scope.
                var val = $.map(selectize.items, function(value) {
                    return selectize.options[value];
                });
                if(scope.value !== undefined){
                    if(scope.value.length && val.length === 0){
                        scope.value.forEach(function(columnValue){
                            //Now check if the model has value or not..
                            if(!$.isEmptyObject(columnValue)){
                                //Now add data
                                addValue(columnValue);
                            }
                        });
                    }else{
                        $timeout(function(){
                            var select = $(iElm).selectize();
                            var selectize = select[0].selectize;
                            selectize.clear();
                        }, 0);
                    }
                }
                else{
                    $timeout(function(){
                        var select = $(iElm).selectize();
                        var selectize = select[0].selectize;
                        selectize.clear();
                    }, 0);
                }

            });

        } //LInk  function
    }; //END Return
}]);
