'use strict';
/*global angular, $snaphy, jQuery, $,  BaseTableDatatables*/

angular.module($snaphy.getModuleName())

//Define a service for fetching database..
.factory('SnaphyTemplate', [function(){

    //Contain plugin UI related templated..
    /**
     * Bootstrap notify plugin http://bootstrap-notify.remabledesigns.com/
     * {
     * 	message:'test message', type:"info", icon="fa fa-info-circle", align="left"
     * }
     */
    var notify = function(options){
    	var $notify         = jQuery(this);
        var $notifyMsg      = options.message;
        var $notifyType     = options.type ? options.type : 'info';
        var $notifyFrom     = options.from ? options.from : 'bottom';
        var $notifyAlign    = options.align ? options.align : 'right';
        var $notifyIcon     = options.icon ? options.icon : '';
        var $notifyUrl      = options.url ? options.url : '';

        jQuery.notify({
                icon: $notifyIcon,
                message: $notifyMsg,
                url: $notifyUrl
            },
            {
                element: 'body',
                type: $notifyType,
                allow_dismiss: true,
                newest_on_top: true,
                showProgressbar: false,
                placement: {
                    from: $notifyFrom,
                    align: $notifyAlign
                },
                offset: 20,
                spacing: 10,
                z_index: 1031,
                delay: 5000,
                timer: 1000,
                animate: {
                    enter: 'animated fadeIn',
                    exit: 'animated fadeOutDown'
                }
        });
    };//notify

    return{
       notify: notify
    };
}]);//factory database..
