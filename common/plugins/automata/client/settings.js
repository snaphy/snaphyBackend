/**
 * Created by robins on 2/12/15.
 */
(function(){
    'use strict';
})();
/*global jslint browser: true, $snaphy*/
//This is the setting file of the plugin..TO be configured according to the user needs..
var settings = {
   "defaultTemplate": true,
   loadDatabases:["Employee", "EmployeeDetails"]
};


//Now adding settings to the main index file..
$snaphy.addSettings('automata', settings);
