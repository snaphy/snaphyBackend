(function(){'use strict';})();
/*jslint browser: true*/
/*global $, jQuery, $snaphy, angular*/
angular.module($snaphy.getModuleName())

//Autocomplete for selectize search medicine..
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

        } //LInk  function
    }; //END Return
}]);
