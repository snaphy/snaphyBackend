/**
 * Created by robins on 2/12/15.
 */
'use strict';
/*jslint browser: true*/
/*global $, jQuery, angular, $snaphy*/
//This is the setting file of the plugin..TO be configured according to the user needs..
var settings = {
    "loginName": "Snaphy",
    "loginTitle": "Welcome, please login.",
    "registerTitle":"Please fill the following details to create an employee.",
    "onLoginRedirectState": 'dashboard',
    "403ErrorRouteState": "403Error",
    "apiRootBase" : "/api"
};


//Now adding settings to the main index file..
$snaphy.addSettings('login', settings);
