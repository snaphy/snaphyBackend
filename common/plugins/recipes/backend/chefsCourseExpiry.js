(function(){
    'use strict';
})();

/*global require, console*/
var schedule = require('node-schedule');
var moment = require('moment');
//Expired status..
var EXPIRED = "expired";

//Add chefs validation
var init = function(server, databaseObj, helper, packageObj) {
    checkExpiryRecurrenceRule(server, databaseObj, helper, packageObj);
};


//add RecurrenceRule
//Will run at every 12
var checkExpiryRecurrenceRule = function(server, databaseObj, helper, packageObj) {
    var rule = new schedule.RecurrenceRule();
    rule.hour = 0;
    rule.minute = 0;

    //Run job every this hour..
    var job = schedule.scheduleJob(rule, function() {
        console.info("waking up at 12 am to check expiry dates");

        var yesturday = moment(moment()).subtract(1, 'days');
        //Found all those allowed events which gonna happen tomorrow. and send an push message to those users..
        var Chef = databaseObj.Chef;
        var where = {
            "status": "allow",
            "expiryDate": {
                lt: new Date(yesturday)
            }
        };



        //First send expiry mail to users..
        Chef.find({
            include: "customer",
            where: where
        })
            .then(function(chefs){
                //Now get the chefs list and send mail to all the users

            })
            .catch(function(err){
                console.error(err);
            });

        /*
         Employee.updateAll({managerId: 'x001'}, {managerId: 'x002'}, function(err, info) {
         ...
         });
         */
        //Now check if any chefs is expired..
        Chef.updateAll(where, {
            status: EXPIRED
        }, function(err, info) {
            if (err) {
                //log error..
                console.error(err);
            } else {
                console.info(info);
            }
        });
    });

};

//Send expiry mail to the users..
var sendMail = function(chefList){

};



module.exports = {
    init: init
};