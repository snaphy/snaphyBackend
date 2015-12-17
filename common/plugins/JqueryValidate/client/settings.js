/**
 * Created by robins on 2/12/15.
 */
(function(){'use strict';})();
/*jslint browser: true*/
/**
 * Now just use angular jqueryValidation instead
 * https://github.com/jpkleemans/angular-validate
 */
//This is the setting file of the plugin..TO be configured according to the user needs..
//For more rules check jqueryValidation docs.
var settings = {
   //Validation Class name of the forms
    rules: {
        'login-username': {
            required: true,
            minlength: 3
        },
        'login-password': {
            required: true,
            minlength: 5
        },
        'register-username': {
            required: true,
            minlength: 3
        },
        'register-password': {
            required: true,
            minlength: 5
        },
        'register-password2': {
            required: true,
            equalTo: '#register-password'
        },
        'register-email': {
            required: true,
            email: true
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
        },
        'register-email': 'Please enter a valid email address',
        'register-password2': {
            required: 'Please provide a password',
            minlength: 'Your password must be at least 5 characters long',
            equalTo: 'Please enter the same password as above'
        }
    }

};


//Now adding settings to the main index file..
$snaphy.addSettings('JqueryValidate', settings);
