/**
 * Created by robins on 2/12/15.
 */
'use strict';
/*jslint browser: true*/
/*global $, jQuery, angular, $snaphy*/
//This is the setting file of the plugin..TO be configured according to the user needs..
var settings = {
    "defaultTemplate": false,
    "loginName": "Gruberr",
    "loginTitle": "Welcome, please login.",
    "registerTitle":"Please fill the following details to create an employee.",
    "forgotPasswordTitle": "Please provide your account’s email and we will send you your password.",
    "onLoginRedirectState": 'dashboard',
    "403ErrorRouteState": "403Error",
    "loginState": "login",
    "registerState": "register",
    "forgotPassState": "forgotPass",
    "adminRole": 'admin',
    "employeeRole": "employee"

};


//Now adding settings to the main index file..
$snaphy.addSettings('login', settings);
