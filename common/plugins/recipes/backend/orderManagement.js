'use strict';
var speakeasy = require("speakeasy");
var sendMessage = require("./otpMessage");
var notp = require('notp');
var init = function(server, databaseObj, helper, packageObj) {
    requestOtp(server, databaseObj, helper, packageObj);
    orderValidation(server, databaseObj, helper, packageObj);
};


var requestOtp = function(server, databaseObj, helper, packageObj) {
    var Order = databaseObj.Order;
    Order.requestOtp = function(number, fn) {
            //matching the number..
            var patt = /\+\d{12,12}/;
            var match = number.match(patt);
            if (!match) {
                number = "+91" + number;
            }

            //var code = notp.totp.gen(key, opt)

            // Note that you’ll want to change the secret to something a lot more secure!
            var code = speakeasy.totp({
                key: packageObj.SECRET_CODE + number,
                length: 4,
                step: 300
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
            fn(null, "message send Successfully");
        } //requestCode function..


    Order.remoteMethod(
        'requestOtp', {
            accepts: {
                arg: 'number',
                type: 'string',
                required: true
            },
            returns: {
                arg: 'code',
                type: 'string',
                required: true
            },
            description: "Request code for OTP verification of  Gruberr App",
        }
    );
}




var orderValidation = function(server, databaseObj, helper, packageObj) {
    var Order = databaseObj.Order;
    Order.orderWithOTP = function(order, orderDetails, code, callback) {
            var err = new Error('Sorry, but that verification code does not work!');
            err.statusCode = 401;
            err.code = 'LOGIN_FAILED';
            if (order) {
                if (order.phoneNumber) {
                    var number = order.phoneNumber.toString();
                    var patt = /\+\d{12,12}/;
                    var match = number.match(patt);
                    if (!match) {
                        number = "+91" + number;
                    }

                    var actualCode = speakeasy.totp({
                        key: packageObj.SECRET_CODE + number.toString(),
                        length: 4,
                        step: 300
                    });


                    console.log("Actual code " + actualCode);
                    console.log("Given code " + code);
                    //If Actual code doesn't matches the provoded code..
                    if (actualCode.toString() !== code.toString()) {
                        console.log("Error matching");
                        callback(err);
                    } else {
                        //Now save the order..
                        Order.create(order)
                        .then(function(orderInstance) {
                            console.log("Now saving order details..");

                            //console.log(order);
                            //callback(null, orderInstance);
                            //Now save the orderDetails of the order..
                            //Now add orderId to each orders..
                            for (var i = 0; i < orderDetails.length; i++) {
                                //Add id property to each order..
                                var orderDetailObj = orderDetails[i];
                                orderDetailObj.orderId = orderInstance.id;
                                if(orderDetailObj.id){
                                    delete orderDetailObj.id;
                                }
                            }
                            //console.log(orderDetails);

                            //Now save orderDetails finally..
                            orderInstance.orderDetails.create(orderDetails, function(err, savedOrderDetails) {
                                if (err) {
                                    console.error(err);
                                    callback(err);
                                } else {
                                    //Now savedOrderDetails
                                    callback(null, savedOrderDetails);
                                    console.log(savedOrderDetails);
                                    console.log("Order details saved successfully..");
                                    //TODO SEND EMAIL TO USER...
                                    //
                                    //          SEND EMAIL HERE ONLY..
                                    //
                                    //
                                }
                            });
                        }).catch(function(error) {
                            console.log(error);
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
            'orderWithOTP', {
                accepts: [{
                    arg: 'order',
                    type: 'object',
                    required: true
                }, {
                    arg: 'orderDetails',
                    type: "array",
                    required: true
                }, {
                    arg: 'code',
                    type: 'string',
                    required: true
                }, ],
                description: "Order by OTP verification of  Gruberr App",
                returns: {
                    arg: 'order',
                    type: 'object'
                }
            }
        ); //remoteMethod
}



module.exports = {
    init: init
}
