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
                        // Initialize when page loads
                        jQuery(function(){ BaseTableDatatables.init(); });
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
                var datePickerObj = $($(iElement).find('.input-daterange')).datepicker();
                $.datepicker._clearDate(datePickerObj);
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
                            console.log("Value found true");
                            return true; //Show that row..

                        }
                        console.log("Value found false");
                        return false;

                    }
                    else{
                        console.log("Value found true...");
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