'use strict';
/*global module, require, return, console */
module.exports = function( server, databaseObj, helper, packageObj) {
    var FB = require('fb');
    var util = require("./utils");
    var https = require('https');

    /**
	 * Here server is the main app object
	 * databaseObj is the mapped database from the package.json file
	 * helper object contains all the helpers methods.
	 * packegeObj contains the packageObj file of your plugin. 
	 */

	/**
	 * Initialize the plugin at time of server start.
	 * init method should never have any argument
	 * It is a constructor and is populated once the server starts.
	 * @return {[type]} [description]
	 */
	var init = function(){
        //Add google login..
        addUserGoogleLogin(server, databaseObj, helper, packageObj);
        //Add facebook login..
        loginWithFb(server, databaseObj, helper, packageObj);
	};


    //Visit this link for more info. https://developers.google.com/identity/sign-in/web/backend-auth
    var addUserGoogleLogin = function(server, databaseObj, helper, packageObj){
        var User = databaseObj.User;
        User.loginWithAccessToken = function(accessToken, callback){
            if(accessToken){
                var url = "https://www.googleapis.com/oauth2/v3/tokeninfo?id_token=" + accessToken;

                https.get(
                    url,
                    function(res) {
                        res.on('data', function(data) {
                            if(data){
                                console.log("Printing the User info obtained from google..\n")
                                console.log(data);
                                //Now create user and login..
                                createUserOrLogin(res, packageObj, User, databaseObj, accessToken, "google",  callback);
                            }
                        });
                    }
                ).on('error', function(err) {
                    console.error("Error getting data from the google plus server.");
                    // Send error
                    callback(err, null);
                });
            }
        };

        User.remoteMethod(
            'loginWithGoogle',
            {
                description: 'Logins a user by authenticating it with google',
                accepts: [
                    { arg: 'accessToken', type: 'string', required: true, http: { source:'form'} }
                ],
                returns: {
                    arg: 'accessToken', type: 'object', root: true,
                    description:
                    'The response body contains properties of the AccessToken created on login.\n' +
                    'Depending on the value of `include` parameter, the body may contain ' +
                    'additional properties:\n\n' +
                    '  - `user` - `{User}` - Data of the currently logged in user. (`include=user`)\n\n'
                },
                http: {verb: 'post'}
            }

        );
    };




	var loginWithFb = function(server, databaseObj, helper, packageObj){
        var User = databaseObj.User;


        //Now defining a method login with access token
		User.loginWithFb = function (accessToken, cb) {
            console.log("received access tokens " , accessToken);
			FB.setAccessToken(accessToken);
			FB.api('me', { fields: ['id', 'name', "email", "last_name", "first_name"]}, function (res) {
				if(!res || res.error) {
					console.log(!res ? 'error occurred' : res.error);
					var err = new Error('Invalid Access Token');
					err.statusCode = 401;
					cb(err);
					return;
				}

				console.log("Printing the User info obtained from facebook..\n")
				console.log(res);
                var FacebookAccessToken = databaseObj.FacebookAccessToken;
                //Now create user and login..
                createUserOrLogin(res, packageObj, User, databaseObj, accessToken, "facebook", FacebookAccessToken,  cb);
            });
		};


		User.remoteMethod(
			'loginWithFb',
			{
				description: 'Logins a user by authenticating it with an external entity',
				accepts: [
					{ arg: 'external_access_token', type: 'string', required: true, http: { source:'form'} }
				],
				returns: {
					arg: 'accessToken', type: 'object', root: true,
					description:
					'The response body contains properties of the AccessToken created on login.\n' +
					'Depending on the value of `include` parameter, the body may contain ' +
					'additional properties:\n\n' +
					'  - `user` - `{User}` - Data of the currently logged in user. (`include=user`)\n\n'
				},
				http: {verb: 'post'}
			}
		);
	};



    //Create user or login user.....
    /**
     * Create a user if not availaible and then login user finally.
     */
    var createUserOrLogin = function(data, packageObj, User, databaseObj, token, type, TokenStoreModel,  callback){
        //
        // accessToken is valid, so
        var query = { email : data.email},
        password = packageObj.secretKey;

        User.findOne({where: query}, function (err,user){
            var defaultError = new Error('login failed');
            defaultError.statusCode = 401;
            defaultError.code = 'LOGIN_FAILED';

            if(err){
                callback(defaultError);
            }else if(!user){
                var userData = {email: query.email, password: password, "firstName": data.first_name, "lastName": data.last_name};
                console.log(userData);
                // User email not found in the db case, create a new profile and then log him in
                User.create(userData, function(err, user) {
                    if(err){
                        console.error(err);
                        callback(defaultError);
                    }else{
                        User.login({ email: query.email, password: password}, function(err, accessToken){
                            if(err){
                                console.error("Error login to user");
                                callback(err);
                            }
                            else{
                                console.log("Successfully logged in", accessToken);
                                callback(null, accessToken);

                                var facebookData = {
                                    FbUserId: data.id,
                                    token: token,
                                    userId: user.id,
                                    expires: accessToken.ttl,
                                    type: type
                                };

                                //Now saving access tokens..
                                var filter = {
                                    where: {
                                        id: data.id
                                    }
                                };

                                TokenStoreModel.findOrCreate(filter, facebookData)
                                    .then(function(data){
                                        console.log("Facebook/google access token saved..");
                                    })
                                    .catch(function(err){
                                        console.error("Error saving Facebook/google access tokens");
                                        console.error(err);
                                    });
                            }

                        });


                    }



                });
            }
            else{
                
                // User found in the database, so just log him in
                User.login({ email: query.email, password: password}, function(err, accessToken){
                    if(err){
                        console.log(err);
                        callback(defaultError);
                    }else{
                        callback(null,accessToken);
                    }
                });
            }
        });
    };




	//return all the methods that you wish to provide user to extend this plugin.
	return {
		init: init
	};
}; //module.exports
