/**
 * Created by robins on 2/12/15.
 */
'use strict';
/*jslint browser: true*/
/*$snaphy*/
//This is the setting file of the plugin..TO be configured according to the user needs..
var settings = {
   //Name of the users whom we are seding an email this is just a label..
   "userLabel" : "Users",
   "defaultTemplate": true,
   //Email model list that need to be populated..
   loadEmails: [
       {
            "model": "AdminEmail",
            "label": "Users",
            "assosiatedUsers": ["Customer"]
       }

   ]

};


//Now adding settings to the main index file..
$snaphy.addSettings('email', settings);
