(function(){'use strict';})();
/*jslint browser: true*/
/*global $, jQuery, $snaphy, angular*/
angular.module($snaphy.getModuleName())

    .factory('ImageUploadingTracker', [function() {
        var totalImageUpload = totalImageUpload || 0;

        var isUploadInProgress = function(){
            if(totalImageUpload === 0){
                return false;
            }else{
                return true;
            }
        };

        var getValue = function(){
            return totalImageUpload;
        };

        var incrementTracker = function(){
            totalImageUpload++;
            return totalImageUpload;
        };

        var decrementTracker = function(){
            totalImageUpload = totalImageUpload - 1;
            return totalImageUpload;
        };

        var resetTracker = function(){
            totalImageUpload = 0;
        };

        return {
            isUploadInProgress: isUploadInProgress,
            incrementTracker: incrementTracker,
            decrementTracker: decrementTracker,
            resetTracker: resetTracker,
            getValue: getValue
        };
    }]);
