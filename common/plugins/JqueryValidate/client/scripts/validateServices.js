/**
 * Created by robins on 3/12/15.
 */
 (function(){'use strict';})();
/*jslint browser: true*/
/*global $, jQuery, angular, $snaphy , redirectOtherWise*/

angular.module($snaphy.getModuleName())


    .factory('SnaphyValidate', [
        function() {
            //Defining the options used in validating forms
            var options = {
                errorClass: 'help-block text-right animated fadeInDown',
                errorElement: 'div',
                errorPlacement: function(error, e) {
                    jQuery(e).parents('.form-group .form-material').append(error);
                },
                highlight: function(e) {
                    jQuery(e).closest('.form-group').removeClass('has-error').addClass('has-error');
                    jQuery(e).closest('.help-block').remove();
                },
                success: function(e) {
                    jQuery(e).closest('.form-group').removeClass('has-error');
                    jQuery(e).closest('.help-block').remove();
                }
            };

            return {
                options: options
            };
        }//LoginServices
    ]);
