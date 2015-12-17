/**
 * Created by robins on 2/12/15.
 */
/*global angular, $snaphy, jQuery, setTimeout*/
 (function(){'use strict';})();

angular.module($snaphy.getModuleName())

    .config(function ($validatorProvider) {
        $validatorProvider.setDefaults({
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
        });
    })

    .config(function ($validatorProvider) {
        $validatorProvider.addMethod("regex", function (value, element) {
            return regexpr.test(value);
        }, "Please enter a valid data.");
    });
