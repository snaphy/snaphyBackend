(function(){'use strict';})();
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
		var models = server.models();
		//
		// models.forEach(function(Model) {
		// 	//console.log(Model);
		// 	addHooksToModel(server,  Model.modelName);
		// });
	};


	//define various hooks ..
	var beforeDelete = [];
	var afterDelete  = [];
	var beforeSave   = [];
	var afterSave    = [];



	// var addHooksToModel = function(server,  modelName){
	// 	var modelObj        = server.models[modelName];
	// 	var settings        = modelObj.definition.settings;
	// 	var modelProperties = modelObj.definition.rawProperties;
	// 	var addHooksToModel = (function(server, modelObj, settings, modelProperties){
	// 		if(beforeDelete.length){
	// 			modelObj.observe
	// 		}
	//
	// 	})();
	// };

	//return all the methods that you wish to provide user to extend this plugin.
	return {
		init: init
	};
}; //module.exports
