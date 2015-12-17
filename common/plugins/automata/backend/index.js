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
		//For loading the raw properties..
		//console.log(server.models.Employee.definition.rawProperties);
		//For loading the settings..
		//console.log(server.models.Employee.definition.settings);
		//Just Introduce a remote method in all the given method..
		//run each models in the loop and add a remote method to it.
		var models = server.models();

		models.forEach(function(Model) {
			//refer to https://apidocs.strongloop.com/loopback/#app-models
			addRemoteMethod(server, Model.modelName);
		});

	};


	/**
	 * Add remote methods to the models..
	 * @param app
	 * @param modelname
	 * @param index
     */
	var addRemoteMethod = function(app, modelName){
		var modelObj = app.models[modelName];
		/**
		 * ModelObj getSchema remote method..
		 * @param callback
         */
		modelObj.getSchema = function(callback) {
			//Now form the schema and send it to the client..
			var relations = modelObj.definition.settings.relations;
			var filters   = modelObj.definition.settings.filters;
			var tables    = modelObj.definition.settings.tables;
			var widgets   = modelObj.definition.settings.widgets;
			var validations   = modelObj.definition.settings.validations;

			/**
			 * Now form the desired schema and return it.
			 */
			var header = addPropToHeader(app, modelName, ''),
			//Get template structure..
			schema = generateTemplateStr(app, modelName);
			//Now recursively add relations to the models...
			addNestedModelRelation(app, header, schema, relations);

			//Now add filters and tables and headers to the model
			schema.header  = header;
			schema.filters = filters;
			schema.tables  = tables;
			schema.widgets  = widgets;
			schema.validations  = validations;

			callback(null, schema);
		};

		//Now registering the method `getSchema`
		modelObj.remoteMethod(
				'getSchema',
				{
					returns: {arg: 'schema', type: 'object'},
					description: "Send the schema of the model requested."
				}
		);
	};



	//TODO ADD ENTRY FOR NESTED DATA RELATED MODELS NOT DONE AT CLIENT SIDE IN ANGULAR FORMLY.
	/**
	 * Recursive function for generating models schema. and header.
	 * @param app
	 * @param header
	 * @param schema
	 * @param relations
     */
	var addNestedModelRelation = function(app, header, schema, relations){
		//Now adding  prop of belongTo and hasMany method to the header and schema respectfully...
		for(var relationName in relations){
			if(relations.hasOwnProperty(relationName)){
				var relationObj = relations[relationName];
				var modelName       = relationObj.model;
				//Only add relation if template option in the template option is present..
				if(relationObj.type === 'hasMany' && relationObj.templateOptions !== undefined){
					var nestedSchema = {};
					nestedSchema.type = 'repeatSection';
					nestedSchema.key = relationName;
					nestedSchema.templateOptions = relationObj.templateOptions;
					//console.log(nestedSchema);
					//Now get nested schema str for the relational models..
					generateTemplateStr(app, relationObj.model, nestedSchema.templateOptions);

					//Now add nestedSchema to the schema object.
					schema.relations.hasMany.push(relationName);
					schema.fields.push(nestedSchema);
				}
				if(relationObj.type === 'hasOne' || relationObj.type === 'belongsTo'){
					//Now add its properties to the header..
					header = addPropToHeader(app, relationObj.model, relationName,  header);
					//Add this relation to the schema..
					schema.relations.belongsTo.push(relationName);
				}

			}
		}//for in loop..
	};


	/**
	 * Checks if the model has any relations property..
	 * @param app
	 * @param modelName
	 * @returns {boolean}
	 * //TODO THIS METHOD IS NOT NEEDED AND SHOULD BE REMOVED
     */
	var checkModelRelation = function(app, modelName){
		var modelObj = app.models[modelName];
		var relationFound = false;
		for(var relationName in modelObj.definition.settings.relations){
			if(modelObj.definition.settings.relations.hasOwnProperty(relationName)){
				relationFound = true;
				break;
			}
		}
		return relationFound;
	};


	/**
	 * Generate header by adding properties key names.
	 * @param app
	 * @param modelName
	 * @param prefix
	 * @param header
     * @returns {*|Array}
     */
	var addPropToHeader = function(app, modelName, prefix,  header){
		header = header || [];
		var modelObj = app.models[modelName],
		modelProperties = modelObj.definition.rawProperties,
		hiddenProperties = modelObj.definition.settings.hidden;
		for(var key in modelProperties){
			if(modelProperties.hasOwnProperty(key)){
				//Add only if template is defined.
				if(modelProperties[key].template !== undefined){
					var propIsHidden = false;
					//Now checkingif the value is a hidden prop.
					for(var i=0; i<hiddenProperties.length; i++){
						var prop = hiddenProperties[i];
						if(prop ===  key){
							propIsHidden = true;
							break;
						}
					}
					if(!propIsHidden){
						if(prefix === ''){
							//Add key to the header..
							header.push(key);
						}else{
							header.push(prefix + '_' + key);
						}

					}
				}//if
			}
		}
		return header;
	};


	/**
	 * Generate template structure for data entry schema.
	 * @param app
	 * @param modelName
	 * @param schema
     * @returns {*}
     */
	var generateTemplateStr = function(app, modelName, schema){
		if(schema === undefined){
			schema = {};
			schema.model = modelName;
			schema.relations = {
				hasMany:[]
				//belongsTo:[],
				//hasManyThrough:[],
				//hasAndBelongToMany:[]
			};
		}
		schema.fields   = [];
		var modelObj    = app.models[modelName],
		modelProperties = modelObj.definition.rawProperties,
		validationObj  = modelObj.definition.settings.validations;
		for(var propertyName in modelProperties){
			if(modelProperties.hasOwnProperty(propertyName)){
				var propObj = modelProperties[propertyName].template;

				if(propObj !== undefined){
					propObj.key = propertyName;
					//also add the validation to the object..
					var validationRules = validationObj[propertyName];
/*
					if(validationRules){
						if(propObj.templateOptions){
							propObj.templateOptions.validation = validationRules;
						}
					}
					*/
					schema.fields.push(propObj);
				}
			}
		}//for-in
		return schema;
	};




	//return all the methods that you wish to provide user to extend this plugin.
	return {
		init: init
	};
}; //module.exports
