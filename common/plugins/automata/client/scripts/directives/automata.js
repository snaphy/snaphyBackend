'use strict';
/*global angular, $snaphy, jQuery, BaseTableDatatables*/

angular.module($snaphy.getModuleName())


.directive('snaphyLoadDatatable', ['$timeout', function ($timeout) {
    return {
        restrict: 'A',
        link: function () {
           $timeout(function(){
               // Initialize when page loads
               jQuery(function(){ BaseTableDatatables.init(); });
           }); //timeout method..
        }//End of Link function...
    }; // End of return
}])

/**
 * For mapping the table values..with desired property.
 */
    .directive('automataMapValue', [function () {
    return {
        restrict: 'A',
        scope:{
            modelProp    : "=modelProp",
            rowObject    : "=rowObject",
            columnHeader : "=columnHeader",
            rowId        : "=rowId"
        },
        link: function (scope, element, attrs) {

            var processData = function(propConfig, rowObject, propertyName, rootTag, value){
                //Getting the root tag..
                rootTag = $(rootTag);
                //For tracking current assosiated tags..
                var currentTag = $(rootTag);

                //If table info not present..
                if(!propConfig){
                    console.log(value);
                    console.log(rootTag);
                    return rootTag.html(value);
                }

                if(propConfig.onClick !== undefined){
                    //get the params values..
                    var params = {},
                        definedParams = propConfig.onClick.params;
                    if(definedParams !== undefined){
                        for (var key_ in definedParams) {
                            if (definedParams.hasOwnProperty(key_)) {
                                var value_ = definedParams[key_];
                                //Now create a params object..
                                params[key_] = rowObject[value_];
                            }
                        }
                    }//if

                    //Now exposing the state and params over scope
                    scope.propConfig = {};
                    scope.propConfig.onClick = {};
                    scope.propConfig.onClick.state = propConfig.onClick.state;
                    //Now adding params to the scope..
                    scope.propConfig.onClick[scope.rowId] = params;

                    //manage onclick here..
                    //Add the anchor tag
                    currentTag = $('<a></a>');
                    var attrValue = propConfig.onClick.state + '(' + JSON.stringify(params) + ')';
                    console.log(attrValue);
                    currentTag.attr("ui-sref", attrValue);
                    //Now add rootTag to currentTag
                    rootTag.append(currentTag);
                }
                else if(propConfig.tag !== undefined){
                    var value = rowObject[propertyName];
                    //Then add tag to the properties..
                    //Now get the label type tag to be used by the value used..
                    var labelType = propConfig.tag[value];
                    currentTag = $('<span class="label" ></span>');
                    currentTag.addClass(labelType);
                    //Now add rootTag to currentTag
                    rootTag.append(currentTag);
                }
                else{
                    /*Do nothing*/
                }

                //Now add value to the current tag
                currentTag.html(value);
                console.log(rootTag);
                return rootTag;
            }; //processOnClick


            /**
             * Find model property from the config file
             */
            var findModelPropertyConfig = function(configModelObj, propertyName){
                //get the property parameters..
                var ModalpropertyObj = configModelObj.properties;
                if(ModalpropertyObj === undefined){
                    return null;
                }
                if(ModalpropertyObj[propertyName] !== undefined){
                    return ModalpropertyObj[propertyName];
                }
                return null;
            };




        }//End of Link function...
    }; // End of return
}])


.directive('snaphyLoadFilters', ['$timeout', function ($timeout) {
    return {
        restrict: 'A',
        link: function () {

            $timeout(function(){
                $(function () {
                    // Init page helpers (BS Datepicker + BS Colorpicker + Select2 + Masked Input + Tags Inputs plugins)
                    App.initHelpers(['datepicker',  'select2']);
                });
            }); //timeout method..
        }//End of Link function...
    }; // End of return
}]);