( function( ){'use strict';} )( );
/* global $snaphy, angular, */
angular.module($snaphy.getModuleName())

// Controller for saveDataControl ..
.controller('saveDataControl', [
    function() {
        //Checking if default templating feature is enabled..
        var defaultTemplate = $snaphy.loadSettings('automata', "defaultTemplate");
        $snaphy.setDefaultTemplate(defaultTemplate);
}]);
