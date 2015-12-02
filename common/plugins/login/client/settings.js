/**
 * Created by robins on 2/12/15.
 */
'use strict';
/*jslint browser: true*/
/*global $, jQuery, angular, $snaphy*/
//This is the setting file of the plugin..TO be configured according to the user needs..
var settings = {
    onLoginRedirectState: 'dashboard'
};


//Now adding settings to the main index file..
$snaphy.addSettings('login', settings);
