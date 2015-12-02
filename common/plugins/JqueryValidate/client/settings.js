/**
 * Created by robins on 2/12/15.
 */
'use strict';
/*jslint browser: true*/
/*$snaphy*/
//This is the setting file of the plugin..TO be configured according to the user needs..
//For more rules check jqueryValidation docs.
var settings = {
   //Validation Class name of the forms
   "formClass" : 'js-validation-login',
    rules: {
        'login-username': {
            required: true,
            minlength: 3
        },
        'login-password': {
            required: true,
            minlength: 5
        }
    },
    messages: {
        'login-username': {
            required: 'Please enter a username',
            minlength: 'Your username must consist of at least 3 characters'
        },
        'login-password': {
            required: 'Please provide a password',
            minlength: 'Your password must be at least 5 characters long'
        }
    }

};


//Now adding settings to the main index file..
$snaphy.addSettings('JqueryValidate', settings);
