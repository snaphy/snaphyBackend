'use strict';
module.exports = function( server, databaseObj, helper, packageObj) {
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
		//For loading the raw properties..
		//console.log(server.models.Employee.definition.rawProperties);
		//For loading the settings..
		//console.log(server.models.Employee.definition.settings);
		//Just Introduce a remote method in all the given method..
		var loadModelList = packageObj["loadModels"];
		//run each models in the loop and add a remote method to it.
		loadModelList.forEach(function(modelName, index){

		});
	};


	/**
	 * Add remote methods to the models..
	 * @param app
	 * @param modelname
	 * @param index
     */
	var addRemoteMethod = function(app, modelname, index){
			var modelObj = app.models[modelname];
			modelObj.getSchema = function(callback) {
				//Now form the schema and send it to the client..
				var modelProperties = modelObj.definition.rawProperties;
				var relations = model.definition.settings.relations;
				var filters = model.definition.settings.filters;
				var tables = model.definition.settings.tables;
				var hiddenProperties = model.definition.settings.hidden;

				/**
				 * Now form the desired schema and return it.
				 */
				var schema = {};



				callback(null, schema);
			};

			//Now registering the method
			modelObj.remoteMethod(
					'getSchema',
					{
						returns: {arg: 'schema', type: 'object'},
						description: "Send the schema of the model requested."
					}
			);

	};



	//return all the methods that you wish to provide user to extend this plugin.
	return {
		init: init
	};
}; //module.exports
