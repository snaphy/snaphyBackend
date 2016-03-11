(function(){
    'use strict';
})();
/*global require, console, module*/
var speakeasy = require("speakeasy");
var sendMessage = require("./otpMessage");
var async = require("async");

var init = function(server, databaseObj, helper, packageObj) {
    requestOtp(server, databaseObj, helper, packageObj);
    orderValidation(server, databaseObj, helper, packageObj);
};


var requestOtp = function(server, databaseObj, helper, packageObj) {
    var Order = databaseObj.Order;
    Order.requestOtp = function(number, fn) {
            //matching the number..
            var patt = /\+\d{12,12}/,
            match = number.match(patt);

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
    };//requestCode function..


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
            description: "Request code for OTP verification of  Gruberr App"
        }
    );
},




orderValidation = function(server, databaseObj, helper, packageObj) {
    var Order = databaseObj.Order;
    //var mail = helper.loadPlugin('email');

    Order.orderWithOTP = function(order, orderDetails, code, callback) {
            var err = new Error('Sorry, but that verification code does not work!');
            err.statusCode = 401;
            err.code = 'LOGIN_FAILED';
            if (order) {
                if (order.phoneNumber) {
                    var number = order.phoneNumber.toString(),
                    patt = /\+\d{12,12}/,
                    match = number.match(patt);

                    if (!match) {
                        number = "+91" + number;
                    }

                    var actualCode = speakeasy.totp({
                        key: packageObj.SECRET_CODE + number.toString(),
                        length: 4,
                        step: 300
                    });


                    //If Actual code doesn't matches the provoded code..
                    if (actualCode.toString() !== code.toString()) {
                        console.error("Error matching");
                        callback(err);
                    } else {
                        //Now save the order..
                        Order.create(order)
                        .then(function(orderInstance) {
                            console.log("Now saving order details..");

                            //Now add orderId to each orders..
                            for (var i = 0; i < orderDetails.length; i++) {
                                //Add id property to each order..
                                var orderDetailObj = orderDetails[i];
                                orderDetailObj.orderId = orderInstance.id;
                                if(orderDetailObj.id){
                                    delete orderDetailObj.id;
                                }
                            }




                            var newOrderDetailObj = [];

                            //Now save orderDetails finally..
                            orderInstance.orderDetails.create(orderDetails, function(err, savedOrderDetails) {
                                if (err) {
                                    console.error(err);
                                    callback(err);
                                } else {
                                    callback(null, []);
                                    console.log("Order saved successfully\n");


                                    //Send new order message..
                                    var phoneNumber = packageObj.phoneNumber;
                                    var message = "A new order has arrived \n order id: " + orderInstance.id;
                                    sendMessage.send(message, phoneNumber, function(err, data) {
                                        if (err) {
                                            console.error(err);
                                        }

                                    });


                                    //Now fetch the ingredients from recipeIngredients...
                                    var RecipeIngredients = server.models.RecipeIngredients;

                                    var recipeIngredientsId = [];
                                    savedOrderDetails.forEach(function(orderDetail){
                                        if(orderDetail.recipeIngredientsId){
                                            recipeIngredientsId.push(orderDetail.recipeIngredientsId);
                                        }
                                    });


                                    order.orderDetails = savedOrderDetails;
                                    RecipeIngredients.find({
                                        where:{
                                            id:{
                                                inq: recipeIngredientsId
                                            }
                                        },
                                        include:["ingredients"]
                                    })
                                    .then(function(values){
                                        //console.log(values);
                                        //Now add recipeIngredients value to the orderDetails.
                                        if(values){
                                            for(var j=0; j< values.length; j++){
                                                var ingredientsObj = values[j];
                                                for(var i= 0; i < savedOrderDetails.length; i++ ){
                                                    var orderDetail = savedOrderDetails[i];
                                                    if(orderDetail.id && orderDetail.recipeIngredientsId ){
                                                        if(ingredientsObj.id.toString().trim() === orderDetail.recipeIngredientsId.toString().trim()){
                                                            //order.orderDetails[i].recipeIngredient = ingredientsObj;
                                                            var orderDetailObj = order.orderDetails[i];
                                                            //orderDetailObj.recipeIngredient  = ingredientsObj;
                                                            newOrderDetailObj.push({
                                                                id: orderDetailObj.id,
                                                                requiredQuantity: orderDetailObj.requiredQuantity,
                                                                recipeIngredientsId: orderDetailObj.recipeIngredientsId,
                                                                orderId: orderDetailObj.orderId,
                                                                recipeIngredients: ingredientsObj
                                                            });

                                                            break;
                                                        }
                                                    }
                                                }
                                            }




                                            //Now find the customer for order..
                                            var Customer = server.models.Customer;
                                            Customer.findById(order.customerId, function(err, customer){
                                                if(err){
                                                    console.error(err);
                                                }else{
                                                    if(customer){
                                                        //Now attach customer to the order..
                                                        order.customer = customer;
                                                        order.id = orderInstance.id;
                                                        //Warning dont import email module..
                                                        //Now send email.. to server..
                                                        server.models.adminEmail.sendOrder(packageObj.newOrderMail, "A new order has arrived.",
                                                            {
                                                                'title': 'Gruberr Ingredients',
                                                                'order': order,
                                                                'orderDetails': newOrderDetailObj
                                                            }, function(err, send){
                                                                if(err){

                                                                    console.error(err);
                                                                }else{

                                                                    console.log(send);
                                                                }

                                                            });

                                                    }

                                                }

                                            });
                                        }
                                    })
                                    .catch(function(err){
                                        console.error(err);
                                    });
                                }
                            });
                        }).catch(function(error) {
                            console.log(error);
                            callback(error);
                        });
                    }
                } else {
                    callback(err);
                }
            } else {
                callback(err);
            }

        }; //registerWithOTP

    Order.remoteMethod(
            'orderWithOTP', {
                accepts: [{
                    arg: 'order',
                    type: 'object',
                    required: true
                }, {
                    arg: 'orderDetails',
                    type: ["object"],
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
};







module.exports = {
    init: init
};
