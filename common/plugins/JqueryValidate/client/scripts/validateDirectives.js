/**
 * Created by robins on 2/12/15.
 */
/*global angular, $snaphy, jQuery, setTimeout*/
 (function(){'use strict';})();

angular.module($snaphy.getModuleName())

    //Add a regex method to the jquery validate method.
    .run([function(){
        $.validator.addMethod("regex", function(value, element, regexpr) {
            return regexpr.test(value);
        }, "Please enter a valid data.");
    }])


    /**
     * General form of directive to be used for validating the forms..
     * Just provide the rules and message in the settings.js file and you are good to go.
     * Use it in the forms.
     */
    .directive('snaphyValidateAll', ['SnaphyValidate', function (SnaphyValidate) {
        return {
            restrict: 'A',

            link: function (scope, iElement, iAttrs) {
                var options = SnaphyValidate.options;
                options.rules = $snaphy.loadSettings('JqueryValidate', 'rules');
                options.messages = $snaphy.loadSettings('JqueryValidate', 'messages');

                setTimeout(function(){
                    jQuery(iElement).validate(options);
                }, 0);
            }//End of Link function...
        }; // End of return
    }])




    //SOME BASIC VALIDATE FUNCTION FOR USING NORMALLY..
    .directive('snaphyValidateUsername', ['SnaphyValidate', function (SnaphyValidate) {
        return {
            restrict: 'A',

            link: function (scope, iElement, iAttrs) {
                var formClassName = '.' + $snaphy.loadSettings('JqueryValidate', 'formClass'),
                formName = iAttrs.name,
                options = SnaphyValidate.options;
                options.rules = {};
                options.rules[formName] = {
                    required: true,
                    minlength: 3
                };


                options.messages = {};
                options.messages[formName] =  {
                    required: 'Please enter a username',
                    minlength: 'Your username must consist of at least 3 characters'
                };
                //console.log(formClassName);
                setTimeout(function(){
                    jQuery(formClassName).validate(options);
                }, 0);
            }//End of Link function...
        }; // End of return
    }])


    .directive('snaphyValidateEmail', ['SnaphyValidate', function (SnaphyValidate) {
        return {
            restrict: 'A',

            link: function (scope, iElement, iAttrs) {
                var formClassName = '.' + $snaphy.loadSettings('JqueryValidate', 'formClass'),
                    formName = iAttrs.name,
                    options = SnaphyValidate.options;
                options.rules = {};
                options.rules[formName] = {
                    required: true,
                    email: true
                };

                options.messages = {};
                options.messages[formName] = 'Please enter a valid email address';


                setTimeout(function(){
                    jQuery(formClassName).validate(options);
                }, 0);
            }//End of Link function...
        }; // End of return
    }])



    .directive('snaphyValidatePassword', ['SnaphyValidate', function (SnaphyValidate) {
        return {
            restrict: 'A',

            link: function (scope, iElement, iAttrs) {
                var formClassName = '.' + $snaphy.loadSettings('JqueryValidate', 'formClass'),
                    formName = iAttrs.name,
                    options = SnaphyValidate.options;
                options.rules = {};
                options.rules[formName] = {
                    required: true,
                    minlength: 5
                };

                options.messages = {};
                options.messages[formName] =  {
                    required: 'Please provide a password',
                    minlength: 'Your password must be at least 5 characters long'
                };

                setTimeout(function(){
                    jQuery(formClassName).validate(options);
                }, 0);
            }//End of Link function...
        }; // End of return
    }])



    .directive('snaphyConfirmPassword', ['SnaphyValidate', function (SnaphyValidate) {
        return {
            restrict: 'A',
            //Passed as argument
            scope:{
                oriPasswordId: '@snaphyPasswordId'
            },
            link: function (scope, iElement, iAttrs) {
                var formClassName = '.' + $snaphy.loadSettings('JqueryValidate', 'formClass'),
                formName = iAttrs.name,
                options = SnaphyValidate.options;
                options.rules = {};
                options.rules[formName] = {
                    required: true,
                    equalTo: scope.oriPasswordId
                };

                options.messages = {};
                options.messages[formName] =  {
                    required: 'Please provide a password',
                    minlength: 'Your password must be at least 5 characters long',
                    equalTo: 'Please enter the same password as above'
                };

                setTimeout(function(){
                    jQuery(formClassName).validate(options);
                }, 0);

            }//End of Link function...
        }; // End of return
    }]);
