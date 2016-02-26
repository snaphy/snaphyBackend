'use strict';
var speakeasy = require("speakeasy");
var sendMessage = require("./otpMessage");
var init = function(server, databaseObj, helper, packageObj) {
    requestOtp(server, databaseObj, helper, packageObj);
    orderValidation(server, databaseObj, helper, packageObj);
};


var requestOtp = function(server, databaseObj, helper, packageObj) {
    var Order = databaseObj.Order;
    Order.requestCode = function(number, fn) {
            //matching the number..
            var patt = /\+\d{12,12}/;
            var match = number.match(patt);
            if (!match) {
                number = "+91" + number;
            }

            // Note that you’ll want to change the secret to something a lot more secure!
            var code = speakeasy.totp({
                key: packageObj.SECRET_CODE + number,
                length: 4,
                step: 120
            });
            console.log('Sending code for verification process : ' + code);
            var message = "Verification code for Gruberr application is : " + code;
            // [TODO] hook into your favorite SMS API and send your user their code!
            //Now sending the verification code to the app

            sendMessage.send(message, number, function(err, data) {
                if (err) {
                    fn(err);
                }
                console.log("Successfully send verification message to customer at " + number);
            });
            //Calling the callback.. function..
            fn(null, []);
        } //requestCode function..


    Order.remoteMethod(
        'requestOtp', {
            accepts: {
                arg: 'number',
                type: 'string',
                required:true
            },
            returns: {
                arg: 'code',
                type: 'string'
            },
            description: "Request code for OTP verification of  Gruberr App",
        }
    );
}




var orderValidation = function(server, databaseObj, helper, packageObj) {
    var Order = databaseObj.Order;
    Order.orderWithOTP = function(order, code, callback) {
        var err = new Error('Sorry, but that verification code does not work!');
        err.statusCode = 401;
        err.code = 'LOGIN_FAILED';
        if (order) {
            if (order.phoneNumber) {
                var number = order.phoneNumber;
                var patt = /\+\d{12,12}/;
                var match = number.match(patt);
                if (!match) {
                    number = "+91" + number;
                }
                var actualCode = speakeasy.totp({
                    key: packageObj.SECRET_CODE + number,
                    length: 4,
                    step: 120
                });
                console.log("Actual code " + actualCode);
                console.log("Given code " + code);
                //If Actual code doesn't matches the provoded code..
                if (actualCode !== code) {
                    callback(err);
                } else {
                    //Now save the order..
                    Order.create()
                    .then(function(orderInstance) {
                        callback(null, orderInstance);
                    })
                    .catch(function(error) {
                        callback(error);
                    });
                }
            } else {
                callback(err)
            }
        } else {
            callback(err);
        }

    } //registerWithOTP

    Order.remoteMethod(
       'orderWithOTP',
       {
           accepts:[
               {arg:'order', type:'object', required:true},
                {arg:'code', type:'string', required:true},
           ],
           description: "Order by OTP verification of  Gruberr App",
           returns: {arg: 'order', type: 'object'}
       }
   )//remoteMethod
}



module.exports = {
    init: init
}
