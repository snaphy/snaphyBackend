'use strict';
module.exports = function( server, databaseObj, helper, packageObj) {
	var fs  = require('fs');
	var ejs = require('ejs');


	//Main method for adding and sending the mail to the clients..
	//Self calling the mail function
	/**
	 *
	 * @return {object} Object with the mail method with send and templateName method attached.
     */
	var mail = (function(){
		//Object tht will get return by the main function..
		var returnObj = {};
		//Get the mailConfig object..
		var mailConfigArr = packageObj.mailConfig;
		if(!mailConfigArr){
			console.error("Error >> You must set the `mailConfig` property in the package.json for the mail to work.");
			if(mailConfigArr.length === 0){
				console.error("Error >> You must provide atleast one mailConfig value for mail to work. ");
				return {};
			}
		}
		//Now iterate the config file..
		mailConfigArr.forEach(function(mailConfig) {
			//Now creating a method for each model.
			//Need to be returned here ..
			var emailModel = mailConfig.emailModel;
			//Protected method..
			returnObj[emailModel] = (function(mailConfig, emailModel){
				//Defining some protected variable here..
				var templatesObj = mailConfig.templates,
				//Now get the database object for the mailModel..
				emailModelInstance  = server.models[emailModel],
				//Object method to be defined in..
				methodObj = {};

				if(!emailModelInstance){
					throw "Error >> Given EmailModel "  + emailModel +  " is not valid."  + "Please provide a valid email model in the mailConfig";
				}
				//define a send method.
				var send = function(options, callback){
					emailModelInstance.send(options, function(err, result){
						if(err) {
							return callback(err);
						}
						callback(null, result);
					});
				};

				//Now iterate each template method..
				for (var templateName in templatesObj) {
					if (templatesObj.hasOwnProperty(templateName)) {
						var pluginRootPath = helper.getPluginRootDir(packageObj.name);
						var templatePath   = pluginRootPath + '/' + templatesObj[templateName];
						//Now iterate and add templateName methods to the object..
						methodObj[templateName] = (function(templateName, templatePath){
							//Now return the function..
							/**
							 * Method for sendind template email.
							 * @param from sender's address
							 * @param to receivers address
                             * @param subject subject of the mail
                             * @param templateOptions {} object of the template data EJS
                             * @param callback function(err, success) callback.
                             */
							var compileAndSend =  function(from, to, subject,  templateOptions, callback ){
								//First compile the template and get its string html form..
								//Now send the email..
								var templateString = null;
								templateString = fs.readFileSync(templatePath, 'utf-8');

								var htmlBody = ejs.render(templateString, templateOptions);
								//Now send the mail..with send function..
								send({
									from:from,
									to:to,
									subject: subject,
									html: htmlBody
								}, function(err, success){
									if(err){
										return callback(err);
									}
									callback(null, success);
								})
							};
							//Now return the function..
							return compileAndSend;
						})(templateName, templatePath);
					}
				}//for loop..

				//Attach the send method...
				methodObj.send = send;

				//Now return the method obj.
				return methodObj;
			})(mailConfig, emailModel); //returnObj[emailModel] anonymous method..
		});// foreach loop..
		//Now return the last obj..
		return returnObj;
	})(); //mail function ends..


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
	 * @return {object} [description]
	 */
	var init = function(){
		/*
		//DEMO SHOWING USAGE..
		var mailModel = packageObj.mailConfig[0].emailModel;
		var adminModel = mail[mailModel];
		adminModel.send(
				{
					from: " 'Rohit' <rohitbasu2050@gmail.com>",
					to: 'robinskumar73@gmail.com',
					subject: "hey this is a test",
					text: "This is a body"},
				function(err, send){
					if (err) throw err;
						console.log(send);
				}
		);

		//Send the template message..
		adminModel.sendNotice(
				"'Rohit' <rohitbasu2050@gmail.com>",
				'robinskumar73@gmail.com',
				"hey this is a test",
				{title:'title'},
				function(err, send){
					if (err) throw err;
					console.log(send);
				}
		);*/
	};


	//ADD THE THE DEFINED METHOD TO THE MAIL OBJECT.
	//Now add init method to the mail method..
	mail.init = init;

	console.log(mail);

	//return all the methods that you wish to provide user to extend this plugin.
	return mail;

	/**
	 * TO SEND ANY MAIL JUST LOAD THIS PLUGIN by helper.loadPlugin('pluginName') method AND call
	 * emailModel.send({from, to, subject, message}, callback) to send any message
	 * emailModel.TemplateName(from, to, subject, {}, callback) to send any templated message..
	 */
}; //module.exports
