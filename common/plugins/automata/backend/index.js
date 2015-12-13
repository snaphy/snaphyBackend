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
	var addRemoteMethod = function(app, modelName, index){
			var modelObj = app.models[modelName];
			modelObj.getSchema = function(callback) {
				//Now form the schema and send it to the client..
				var relations = modelObj.definition.settings.relations;
				var filters = modelObj.definition.settings.filters;
				var tables = modelObj.definition.settings.tables;
				var hiddenProperties = modelObj.definition.settings.hidden;
				/**
				 * Now form the desired schema and return it.
				 */
				var schema = {};
				/**
				 * get the header array
				 * get the properties for table.
				 * get the properties for filter.
				 * and finally get the properties for template.
				 */
				var header = addPropToHeader(app, modelName, '');
				//Get template structure..
				schema = generateTemplateStr(app, modelName, schema);

				//Now adding  prop of belongTo method to the header..
				for(var relationName in relations){
					if(relations.hasOwnProperty(relationName)){
						var relationObj = relations[relationName];

						//Only add relation if template option in the template option is present..
						if(relationObj.type === 'hasMany' && relationObj.templateOptions !== undefined){
							var nestedSchema = {};
							nestedSchema.type = 'repeatSection';
							nestedSchema.key = relationName;
							nestedSchema.templateOptions = relationObj.templateOptions;
							//Now get nested schema str for the relational models..
							nestedSchema = generateTemplateStr(app, relationObj.model, nestedSchema);
							//Now add nestedSchema to the schema object.
							schema.relations.hasMany.push(relationName);
							schema.fields.push(nestedSchema);
						}
						if(relationObj.type === 'hasOne' || relationObj.type === 'belongsTo'){
							//Now add its properties to the header..
							header = addPropToHeader(app, relationObj.model, relationName,  header);
						}
					}
				}//for in loop..



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
				var propIsHidden = false;
				//Now checkingif the value is a hidden prop.
				hiddenProperties.forEach(function(prop, index){
					if(prop ===  key){
						propIsHidden = true;
					}
				});
				if(!propIsHidden){
					if(prefix === ''){
						//Add key to the header..
						header.push(key);
					}else{
						header.push(prefix + '_' + key);
					}

				}
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
		schema.fields = schema.fields || [];
		var modelObj    = app.models[modelName],
		modelProperties = modelObj.definition.rawProperties;
		for(var propertyName in modelProperties){
			if(modelProperties.hasOwnProperty(propertyName)){
				var propObj = modelProperties[propertyName].template;
				propObj.key = propertyName;
				schema.fields.push(propObj);
			}
		}//for-in
		return schema;
	};




	//return all the methods that you wish to provide user to extend this plugin.
	return {
		init: init
	};
}; //module.exports
