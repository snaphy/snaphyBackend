(function(){ 'use strict'; }) ();
/*global module, require, return, console */
module.exports = function( server, databaseObj, helper, packageObj) {
    var FB = require('fb');
    var util = require("./utils");
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

	};



    var addUserGoogleLogin = function(server, databaseObj, helper, packageObj){
        var User = databaseObj.User;
        User.loginWithAccessToken = function(accesToken, callback){

        };
    };




	var addUserFbLogin = function(server, databaseObj, helper, packageObj){
        var User = databaseObj.User;
        var FacebookAccessToken = databaseObj.FacebookAccessToken;

        //Now defining a method login with access token
		User.loginWithAccessToken = function (accessToken, cb) {
			FB.setAccessToken(accessToken);
			FB.api('me', function (res) {
				if(!res || res.error) {
					console.log(!res ? 'error occurred' : res.error);
					var err = new Error('Invalid Access Token');
					err.statusCode = 401;
					cb(err);
					return;
				}

				console.log("Printing the User info obtained from facebook..\n")
				console.log(res);

				// accessToken is valid, so
				var query = { email : res.email};
				User.findOne({where:query}, function (err,user){
					var defaultError = new Error('login failed');
					defaultError.statusCode = 401;
					defaultError.code = 'LOGIN_FAILED';

					if(err){
						cb(defaultError);
					}else if(!user){
						// User email not found in the db case, create a new profile and then log him in
						User.create({email: query.email, password: generateKey(packageObj.secretKey, "sha1", "hex")}, function(err, user) {
							if(err){
								cb(defaultError);
							}else{
								User.login({ email: query.email, password: packageObj.secretKey}, function(err,accessToken){
									cb(null,accessToken);
								});
							}
                            //Also save the user credentials in the
                            //FIXME TODO
                            //TODO 
                            //ADD THE ACCESS TOKEN TO THIS USER DATA..
                            //ALSO DOWNLOAD THE PROFILE PICTURE FROM FACEBOOK AND INFO.
                            //ALSO STORE THE IMAGE IN AMAZON S3 ACCOUNT..
                            //AND THEN RETURN THE NEW PROFILE INFORMATION..

						});
					}
					else{
						// User found in the database, so just log him in
						User.login({ email: query.email, password: packageObj.secretKey}, function(err,accessToken){
							if(err){
								cb(defaultError);
							}else{
								cb(null,accessToken);
							}

						});
					}
				});
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


	//return all the methods that you wish to provide user to extend this plugin.
	return {
		init: init
	};
}; //module.exports
