'use strict';
/*global angular, $snaphy, jQuery, $,  BaseTableDatatables*/

angular.module($snaphy.getModuleName())


.directive('snaphyLoadDatatable', ['$timeout', function ($timeout) {
    return {
        restrict: 'A',
        compile: function(){
            // Compile code goes here.
            return {
                post: function postLink( ) {
                    // Post-link code goes here
                    $timeout(function(){
                        try{
                            // Initialize when page loads
                            jQuery(function(){ BaseTableDatatables.init(); });
                        }catch (err){
                            /*Do nothing error occured due to multiple table initialization.. */
                        }

                    }); //timeout method..
                }
            };
        },
        link: function () {
            /*Methods moved to compile for one time call only..*/
        }//End of Link function...
    }; // End of return
}])



/**
 *Directive for defining filters $date
 * */
.directive('filterDate', [function(){
    //TODO table header data initialization bugs.. this filter must not proceed before table header initialization..
    return {
        restrict:'E',
        scope:{
            "modelSettings"  : "=modelSettings",
            "id"             : "@tableId",
            "columnName"     : "@columnName",
            "label"          : "@label"
        },
        replace: true,
        template:
            '<div class="form-group">'+
                '<label class="col-md-4 control-label" for="example-daterange1">{{label}}</label>'+
                 '<div class="col-md-8">' +
                    '<div class="input-daterange input-group" data-date-format="mm/dd/yyyy">'+
                        '<input class="form-control" type="text"  name="daterange1" placeholder="From">'+
                        '<span class="input-group-addon"><i class="fa fa-chevron-right"></i></span>'+
                        '<input class="form-control" type="text"  name="daterange2" placeholder="To">'+
                    '</div>'+
                '</div>'+
            '</div>',
        link: function(scope, iElement, iAttrs){
            //First get the table id.
            if(scope.id === ""){
                console.error("An table Id value is needed for filters to operate.");
                return null;
            }


            //Removing the # tag from id if placed. to avoid duplicity of #
            scope.id  = scope.id.replace(/^\#/, '');
            scope.tableId  = '#' + scope.id;


            //Now applying date change event of the table..
            $($(iElement).find('.input-daterange')).datepicker().on("changeDate", function(){
                //Now just
                //Getting the instance of the table..
                var table = $(scope.tableId).DataTable();
                //Now redraw the tables..
                table.draw();
            });



            //Now add a Reset method to the filter..
            scope.$parent.addResetMethod(function(){
                $($(iElement).find('input')).val('');
            });



            var allowFilter = [scope.id];

            //Now run the daterange filter..
            //Now setting the retailer added filter...
            $.fn.DataTable.ext.search.push(
                function( settings, data, dataIndex ) {
                    // check if current table is part of the allow list
                    if ( $.inArray( settings.nTable.getAttribute('id'), allowFilter ) == -1 )
                    {
                        // if not table should be ignored
                        return true;
                    }

                    var columnDataId;
                    //Now get the column id where the wanted data is placed..
                    for(var i=0; i<scope.modelSettings.header.length; i++){
                        if(scope.modelSettings.header[i] === scope.columnName){
                            columnDataId = i;
                            break;
                        }
                    }

                    var valuesList = $(iElement).find("input");
                    var from = $(valuesList[0]).val();
                    var to   = $(valuesList[1]).val();

                    //Getting the orderMin value..
                    if( from && to){
                        var from =  new Date( from );
                        var to   =  new Date( to );

                        //Convert to format mm/dd/yyyy
                        var convertDateFormat = function(date){
                            var givenDate = new Date(date);
                            var dd = givenDate.getDate();
                            var mm = givenDate.getMonth()+1; //January is 0!

                            var yyyy = givenDate.getFullYear();
                            if(dd<10){
                                dd='0'+dd
                            }
                            if(mm<10){
                                mm='0'+mm
                            }
                            var formatDate = mm+'/'+dd+'/'+yyyy;
                            return new Date(formatDate);
                        };

                        //Parsing value for column Retailers added date..
                        var columnDate = convertDateFormat(data[columnDataId]) ;

                        if ( from <= columnDate   && columnDate <= to )
                        {
                            return true; //Show that row..

                        }
                        return false;

                    }
                    else{
                        return true; //Show all rows..
                    }
                }
            );//End of dataTable function for retailer added filter.....

        }//link function..
    }; //return
}]) //filterDate directive







/**
 *Directive for defining filters $date
 * */
    .directive('filterSelect', ['$http', function($http){
        //TODO table header data initialization bugs.. this filter must not proceed before table header initialization..
        return {
            restrict:'E',
            scope:{
                "modelSettings"     : "=modelSettings",
                "id"                : "@tableId",
                "columnName"        : "@columnName",
                "label"             : "@label",
                "data"              : "=data",
                "getOptions"        : "@get",
                "staticOptions"     : "@options",
            },
            replace: true,
            template:
            '<div class="form-group">'+
                '<label class="col-md-4 control-label" for="example-select2">{{label}}</label>'+
                '<div class="col-md-8">'+
                    '<select class="js-select2 form-control" ng-model="data.value" style="width: 100%;" data-placeholder="Choose one..">'+
                        '<option value="" >All</option>'+
                        '<option ng-repeat="option in data.options" value="{{option.id}}">{{option.name}}</option>'+
                    '</select>'+
                '</div>'+
            '</div>',
            link: function(scope, iElement, iAttrs){
                //First get the table id.
                if(scope.id === ""){
                    console.error("An table Id value is needed for filters to operate.");
                    return null;
                }


                scope.data = {};
                //initializing options..


                //Removing the # tag from id if placed. to avoid duplicity of #
                scope.id  = scope.id.replace(/^\#/, '');
                scope.tableId  = '#' + scope.id;


                //Now applying date change event of the table..
                $($(iElement).find('.js-select2')).change(function(){
                    var table = $(scope.tableId).DataTable();
                    //Now redraw the tables..
                    table.draw();
                });


                if(scope.staticOptions != undefined){
                    //Load static options..
                    scope.data.options = JSON.parse(scope.staticOptions);
                    //scope.data.options = scope.staticOptions;
                }


                //Now load options..
                if(scope.getOptions != undefined){
                    $http({
                        method: 'GET',
                        url: scope.getOptions
                    }).then(function successCallback(response) {
                        //Select options downloaded successfully..
                        //Loading options..
                        scope.data.options = response;
                    }, function errorCallback(response) {
                        // called asynchronously if an error occurs
                        // or server returns response with an error status.
                        console.error(response);
                    });
                }



                //Now add a Reset method to the filter..
                scope.$parent.addResetMethod(function(){
                    scope.data.value = "";
                    //Now reinitialize the
                    setTimeout(function(){
                        $($(iElement).find('select')).select2('val', 'All');
                    },0);
                });


                //Now load search filters..
                var allowFilter = [scope.id];

                //Now setting the retailer added filter...
                $.fn.DataTable.ext.search.push(
                    function( settings, data, dataIndex ) {
                        // check if current table is part of the allow list
                        if ( $.inArray( settings.nTable.getAttribute('id'), allowFilter ) == -1 )
                        {
                            // if not table should be ignored
                            return true;
                        }
                        var columnDataId;
                        var selectValue = "";
                        //Now get the column id where the wanted data is placed..
                        for(var i=0; i<scope.modelSettings.header.length; i++){
                            if(scope.modelSettings.header[i] === scope.columnName){
                                columnDataId = i;
                                break;
                            }
                        }
                        //Getting the orderMin value..
                        if(scope.data.value){
                            //Parsing value for column Retailers added date..
                            var columnValue = data[columnDataId];
                            for(var j=0; j<scope.data.options.length; j++){
                                if(scope.data.options[j].name.toLowerCase().trim() === columnValue.toLowerCase().trim()){
                                    //Gettting the id of the table value..
                                    selectValue = scope.data.options[j].id;
                                }
                            }


                            if ( parseInt(scope.data.value) === parseInt(selectValue) )
                            {
                                return true; //Show that row..
                            }
                            return false;
                        }
                        else{
                            return true; //Show all rows..
                        }
                    }
                );//End of dataTable function for retailer added filter.....
            }//link function..
        }; //return
    }]) //filterDate directive



    /**
     *Directive for defining filters $date
     * */
    .directive('filterMultiSelect', ['$http', function($http){
        //TODO table header data initialization bugs.. this filter must not proceed before table header initialization..
        return {
            restrict:'E',
            scope:{
                "modelSettings"     : "=modelSettings",
                "id"                : "@tableId",
                "columnName"        : "@columnName",
                "label"             : "@label",
                "data"              : "=data",
                "getOptions"        : "@get",
                "staticOptions"     : "@options",
            },
            replace: true,
            template:
            '<div class="form-group">'+
            '<label class="col-md-4 control-label" for="example-select2">{{label}}</label>'+
            '<div class="col-md-8">'+
            '<select data-allow-clear="true" class="js-select2 form-control" ng-model="data.value" style="width: 100%;" data-placeholder="Choose many.." multiple>'+
            '<option ng-repeat="option in data.options" value="{{option.id}}">{{option.name}}</option>'+
            '</select>'+
            '</div>'+
            '</div>',
            link: function(scope, iElement, iAttrs){
                //First get the table id.
                if(scope.id === ""){
                    console.error("An table Id value is needed for filters to operate.");
                    return null;
                }


                scope.data = {};
                //initializing options..


                //Removing the # tag from id if placed. to avoid duplicity of #
                scope.id  = scope.id.replace(/^\#/, '');
                scope.tableId  = '#' + scope.id;


                //Now applying date change event of the table..
                $($(iElement).find('.js-select2')).change(function(){
                    var table = $(scope.tableId).DataTable();

                    //only draw if value is legitimate..
                    if(scope.data.value){
                        if(scope.data.value.length){
                            //Now redraw the tables..
                            table.draw();
                        }
                        else{
                            scope.data.value = null;
                            table.draw();
                        }
                    }
                });


                if(scope.staticOptions != undefined){
                    //Load static options..
                    scope.data.options = JSON.parse(scope.staticOptions);
                    //scope.data.options = scope.staticOptions;
                }


                //Now load options..
                if(scope.getOptions != undefined){
                    $http({
                        method: 'GET',
                        url: scope.getOptions
                    }).then(function successCallback(response) {
                        //Select options downloaded successfully..
                        //Loading options..
                        scope.data.options = response;
                    }, function errorCallback(response) {
                        // called asynchronously if an error occurs
                        // or server returns response with an error status.
                        console.error(response);
                    });
                }



                //Now add a Reset method to the filter..
                scope.$parent.addResetMethod(function(){
                    scope.data.value = null;
                    //Now reinitialize the
                    setTimeout(function(){
                       $($(iElement).find('select')).select2();
                    },0);
                });


                //Now load search filters..
                var allowFilter = [scope.id];

                //Now setting the retailer added filter...
                $.fn.DataTable.ext.search.push(
                    function( settings, data, dataIndex ) {
                        // check if current table is part of the allow list
                        if ( $.inArray( settings.nTable.getAttribute('id'), allowFilter ) == -1 )
                        {
                            // if not table should be ignored
                            return true;
                        }
                        var columnDataId;
                        var selectValue = "";
                        //Now get the column id where the wanted data is placed..
                        for(var i=0; i<scope.modelSettings.header.length; i++){
                            if(scope.modelSettings.header[i] === scope.columnName){
                                columnDataId = i;
                                break;
                            }
                        }

                        //Getting the orderMin value..
                        if(scope.data.value){
                            //Parsing value for column Retailers added date..
                            var columnValue = data[columnDataId];

                            //Gettting the id of the table column first..
                            for(var j=0; j<scope.data.options.length; j++){
                                if(scope.data.options[j].name.toLowerCase().trim() === columnValue.toLowerCase().trim()){
                                    //Gettting the id of the table value..
                                    selectValue = scope.data.options[j].id;
                                }
                            }

                            var matchFound = false;
                            //If the value is present in the multi select then return true else false..
                            scope.data.value.forEach(function(data){
                                if ( parseInt(data) === parseInt(selectValue) )
                                {
                                    matchFound = true;
                                    return false;
                                }
                            });

                            return matchFound;

                        }
                        else{
                            return true; //Show all rows..
                        }
                    }
                );//End of dataTable function for retailer added filter.....
            }//link function..
        }; //return
    }]) //filterDate directive




    /**
     *Directive for defining filters $date
     * */
    .directive('filterRadio', [function(){
        //TODO table header data initialization bugs.. this filter must not proceed before table header initialization..
        return {
            restrict:'E',
            scope:{
                "id"                : "@tableId",
                "columnName"        : "@columnName",
                "label"             : "@label",
                "data"              : "=data",
                "options"           : "@options",
                "modelSettings"     : "=modelSettings"
            },
            replace: true,
            template:
            '<div class="form-group">'+
                '<label class="col-md-4 control-label" for="radio-group12">{{label}}</label>'+
                '<div class="col-xs-8">'+
                    '<label ng-repeat="option in data.options" class="css-input css-radio css-radio-lg css-radio-primary push-10-r">'+
                        '<input class="radio-filter" ng-change="valueChanged()" type="radio" name="radio-group" ng-model="data.value" ng-value="option.name" ng-checked="option.checked" ><span></span>{{option.name}}'+
                    '</label>'+
                '</div>'+
            '</div>',
            link: function(scope, iElement, iAttrs){
                //First get the table id.
                if(scope.id === ""){
                    console.error("An table Id value is needed for filters to operate.");
                    return null;
                }

                scope.data = {};
                scope.data.options = JSON.parse(scope.options);

                //initializing options..
                //Removing the # tag from id if placed. to avoid duplicity of #
                scope.id  = scope.id.replace(/^\#/, '');
                scope.tableId  = '#' + scope.id;


                scope.valueChanged = function(){
                    var table = $(scope.tableId).DataTable();
                    //only draw if value is legitimate..
                    if(scope.data.value){
                        table.draw();
                    }
                };


                //Now add a Reset method to the filter..
                scope.$parent.addResetMethod(function(){
                    scope.data.value = null;
                });


                //Now load search filters..
                var allowFilter = [scope.id];

                //Now setting the retailer added filter...
                $.fn.DataTable.ext.search.push(
                    function( settings, data, dataIndex ) {
                        // check if current table is part of the allow list
                        if ( $.inArray( settings.nTable.getAttribute('id'), allowFilter ) == -1 )
                        {
                            // if not table should be ignored
                            return true;
                        }
                        var columnDataId;
                        //Now get the column id where the wanted data is placed..
                        for(var i=0; i<scope.modelSettings.header.length; i++){
                            if(scope.modelSettings.header[i] === scope.columnName){
                                columnDataId = i;
                                break;
                            }
                        }


                        //Getting the orderMin value..
                        if(scope.data.value){
                            //Parsing value for column Retailers added date..
                            var columnValue = data[columnDataId];
                            if(scope.data.value.toLowerCase().trim() === columnValue.toLowerCase().trim()){
                                return true;
                            }else{
                                return false;
                            }
                        }
                        else{
                            return true; //Show all rows..
                        }
                    }
                );//End of dataTable function for retailer added filter.....
            }//link function..
        }; //return
    }]) //filterDate directive



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