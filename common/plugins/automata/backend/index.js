(function(){'use strict';})();
module.exports = function( server, databaseObj, helper, packageObj) {
	var saveRemoteMethod = require('./saveDb');
	var onDelete = require('./cascadingDelete');
	var modifyHasAndBelongsToMany = require("./modifyHasAndBelongsToMany");
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
			//Also add save method to each models..
			saveRemoteMethod.addSaveMethod(server, Model.modelName);
			addCaseSensitiveSearch (server, Model.modelName);
			onDelete.onCascadeDelete(server, Model.modelName);
			modifyHasAndBelongsToMany.modifyRelation(server, Model.modelName);
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

			/**
			 * Now form the desired schema and return it.
			 */
			var header = addPropToHeader(app, modelName, ''),
			//Get template structure..
			schema = generateTemplateStr(app, modelName);
			//Now recursively add relations to the models...
			addNestedModelRelation(app, header, schema, relations, modelName);

			//Now add filters and tables and headers to the model
			schema.header  = header;
			schema.filters = filters;
			schema.tables  = tables;
			schema.widgets  = widgets;

			callback(null, schema);
		};


		modelObj.getAbsoluteSchema = function(callback) {
			//Now form the schema and send it to the client..
			var relations = modelObj.definition.settings.relations;
			var filters   = modelObj.definition.settings.filters;
			var tables    = modelObj.definition.settings.tables;
			var widgets   = modelObj.definition.settings.widgets;

			/**
			 * Now form the desired schema and return it.
			 */
			var header = addPropToHeader(app, modelName, ''),
			//Get template structure..
			schema = generateTemplateStr(app, modelName);
			//Now recursively add relations to the models...
			addNestedModelRelation(app, header, schema, relations, modelName, true);

			//Now add filters and tables and headers to the model
			schema.header  = header;
			schema.filters = filters;
			schema.tables  = tables;
			schema.widgets  = widgets;

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


		//Now registering the method `getAbsoluteSchema` required for robust automata plugin..
		modelObj.remoteMethod(
				'getAbsoluteSchema',
				{
					returns: {arg: 'schema', type: 'object'},
					description: "Send the absolute schema of the model requested."
				}
		);
	};


	var addCaseSensitiveSearch = function(server, modelName){
		var modelObj = server.models[modelName];
		modelObj.observe("access", function (ctx, next) {
			//console.log(ctx.query.where);
			if(ctx.query.where){
				for(var whereProp in ctx.query.where){
					//console.log("\n\n\n");
					//console.log(whereProp);
					if(ctx.query.where.hasOwnProperty(whereProp)){
						var like = ctx.query.where[whereProp].like;
						//console.log(like, whereProp);
						if(like){
							var patt= /\/.*\//;
							if(patt.test(like)){
								//Regex already present..
								//do nothing..

							}else{

								var pattern = new RegExp(''+like+'.*', "i"); /* case-insensitive RegExp search */
								//Now modifying the like property..
							//	console.log(pattern);
								ctx.query.where[whereProp].like = pattern;
							}


						}
					}
				}
				next();
			}else{
				next();
			}

			//console.log(ctx.query.where);


		});//observe..
	};


	//TODO ADD ENTRY FOR NESTED DATA RELATED MODELS NOT DONE AT CLIENT SIDE IN ANGULAR FORMLY.
	/**
	 * Recursive function for generating models schema. and header.
	 * @param app
	 * @param header
	 * @param schema
	 * @param relations
     */
	var addNestedModelRelation = function(app, header, schema, relations, rootModelName, absoluteSchema){
		//Now adding  prop of belongTo and hasMany method to the header and schema respectfully...
		for(var relationName in relations){
			if(relations.hasOwnProperty(relationName)){
				var relationObj = relations[relationName];
				var modelName       = relationObj.model;
				//Only add relation if template option in the template option is present..
				if((relationObj.type === 'hasMany' ||  relationObj.type === 'hasAndBelongsToMany' ) && relationObj.templateOptions !== undefined){
					var nestedSchema = {};

					if(relationObj.type === "hasMany"){
						if(relationObj.through){

							nestedSchema.type = 'arrayValue';
							nestedSchema.key = relationName;
							nestedSchema.templateOptions = {};
							nestedSchema.templateOptions.btnText = relationObj.templateOptions.btnText;
							if(relationObj.templateOptions.searchProp){
								nestedSchema.templateOptions.searchProp = relationObj.templateOptions.searchProp;
							}
							if(relationObj.templateOptions.create){
								nestedSchema.templateOptions.create = relationObj.templateOptions.create;
							}
							if(relationObj.templateOptions.hide){
								nestedSchema.templateOptions.hide = relationObj.templateOptions.hide;
							}
							if(relationObj.templateOptions.init){
								nestedSchema.templateOptions.init = relationObj.templateOptions.init;
							}

							nestedSchema.templateOptions.model = relationObj.through;

							var throughRelationName;
							var throughSearchId;
							var throughModelObj = app.models[relationObj.through];
							var relatedModelRelationObj = throughModelObj.definition.settings.relations;
							for(var relatedModelRelation in relatedModelRelationObj){
								if(relatedModelRelationObj.hasOwnProperty(relatedModelRelation)){
									var relatedModel = relatedModelRelationObj[relatedModelRelation];
									if(modelName === relatedModel.model){
										throughRelationName = relatedModelRelation;
									}
									else if(rootModelName === relatedModel.model){
										if(relatedModel.foreignKey){
											throughSearchId = relatedModel.foreignKey;
										}else{
											throughSearchId = rootModelName.toLowerCase() + "Id";
										}
									}
									else{
										// Do nothing..
									}
								}
							}


							//console.log(nestedSchema);
							//Now get nested schema str for the relational models..
							generateTemplateStr(app, relationObj.through, nestedSchema.templateOptions);

							var belongsToSchemaThrough = {
								type           : "belongsTo",
								key            : throughRelationName,
								templateOptions: relationObj.templateOptions
							};

							//Model name of relational data..
							belongsToSchemaThrough.templateOptions.model = relationObj.model;

							if(nestedSchema.templateOptions.fields === undefined){
								nestedSchema.templateOptions.fields = [];
							}

							nestedSchema.templateOptions.fields.push(belongsToSchemaThrough);

							//Also add templateStr for related model of HasManyThrough
							generateTemplateStr(app, relationObj.model, belongsToSchemaThrough.templateOptions);


							/**
							 * HasManyThrough structure
							 * {
							 * 		relation: 'ingredients',
							 * 		through: 'RecipeIngredient'
							 * }
							 */
							//Push data to hasManyThrough array..
							schema.relations.hasManyThrough.push({
								//Relation of related model in though Model property name
								throughModelRelation: throughRelationName,
								through: relationObj.through,
								whereId:  throughSearchId,
								relationName: relationName
							});
						}else{
							nestedSchema.type = 'repeatSection';
							nestedSchema.key = relationName;
							nestedSchema.templateOptions = relationObj.templateOptions;
							nestedSchema.templateOptions.model = relationObj.model;
							//console.log(nestedSchema);
							//Now get nested schema str for the relational models..
							generateTemplateStr(app, relationObj.model, nestedSchema.templateOptions);

							//Now add nestedSchema to the schema object.
							schema.relations.hasMany.push(relationName);

						}
					}
					else{
						nestedSchema.type = 'repeatSection';
						nestedSchema.key = relationName;
						nestedSchema.templateOptions = relationObj.templateOptions;
						nestedSchema.templateOptions.model = relationObj.model;
						//console.log(nestedSchema);
						//Now get nested schema str for the relational models..
						generateTemplateStr(app, relationObj.model, nestedSchema.templateOptions);

						//Now add nestedSchema to the schema object.
						schema.relations.hasAndBelongsToMany.push(relationName);
					}

					schema.fields.push(nestedSchema);
				}
				if((relationObj.type === 'hasOne' || relationObj.type === 'belongsTo') && relationObj.templateOptions !== undefined){
					if(absoluteSchema){
						//Now add its properties to the header..
						header = addPropToHeader(app, relationObj.model, relationName,  header, true);
					}else{
						//Now add its properties to the header..
						header = addPropToHeader(app, relationObj.model, relationName,  header);
					}

					if(relationObj.type === "hasOne"){
						schema.relations.hasOne.push(relationName);
					}else{
						//Add this relation to the schema..
						schema.relations.belongsTo.push(relationName);
					}

					var belongsToSchema = {
						type           : "belongsTo",
						key            : relationName,
						templateOptions: relationObj.templateOptions
					};
					belongsToSchema.templateOptions.model      = relationObj.model;
					belongsToSchema.templateOptions.foreignKey = relationObj.foreignKey === "" ? relationName + 'Id' : relationObj.foreignKey;
					//Now add nested schema to the relational model.
					generateTemplateStr(app, relationObj.model, belongsToSchema.templateOptions);

					if(belongsToSchema.templateOptions.includeRelatedModel){
						//Now if model-> related model -> related model (belongTo data is requested)
						//If some related mode of related model is requested too.. then in this case.. call this method..
						//TODO THIS CONDITION MAY LEADS TO INFINITE LOOP OF CYCLIC ERROR ..AVOID..
						//TODO ERROR PRONE USE IT CAUTIONLY....
						//console.log(relationObj.model);
						var relatedModelObj = app.models[relationObj.model];
						var relatedModelRelations = relatedModelObj.definition.settings.relations;
						var relatedHeader = addPropToHeader(app, relationObj.model, '');

						belongsToSchema.templateOptions.relations = belongsToSchema.templateOptions.relations || {
							hasMany:[],
							belongsTo:[],
							hasManyThrough:[],
							hasAndBelongsToMany:[],
							hasOne:[]
						};
						//add schema
						addNestedModelRelation(app, relatedHeader, belongsToSchema.templateOptions, relatedModelRelations, relationObj.model);
					}
					//console.log(belongsToSchema);
					//Now add this to the schema..
					schema.fields.push(belongsToSchema);
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
	var addPropToHeader = function(app, modelName, prefix,  header, absoluteSchema){
		header = header || [];
		var modelObj = app.models[modelName],
		modelProperties = modelObj.definition.rawProperties,
		hiddenProperties = modelObj.definition.settings.hidden;
		for(var key in modelProperties){
			if(modelProperties.hasOwnProperty(key)){
				//Add only if template is defined.
				if(modelProperties[key].template !== undefined){
					var propIsHidden = false;
					if(hiddenProperties){
						//Now checkingif the value is a hidden prop.
						for(var i=0; i<hiddenProperties.length; i++){
							var prop = hiddenProperties[i];
							if(prop ===  key){
								propIsHidden = true;
								break;
							}
						}
					}
					if(!propIsHidden){
						if(prefix === ''){
							//Add key to the header..
							header.push(key);
						}else{
							if(absoluteSchema){
								header.push(prefix + '.' + key);
							}else{
								header.push(prefix + '_' + key);
							}

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
				hasMany:[],
				belongsTo:[],
				hasManyThrough:[],
				hasAndBelongsToMany:[],
				hasOne:[]
			};
		}
		schema.fields   = [];
		var modelObj    = app.models[modelName],
		modelProperties = modelObj.definition.rawProperties,
		validationObj  = modelObj.definition.settings.validationsBackend;
		var newValidationObj = {
			rules:{},
			messages:{}
		};

		for(var propertyName in modelProperties){
			if(modelProperties.hasOwnProperty(propertyName)){
				var propObj = modelProperties[propertyName].template;
				if(propObj !== undefined){
					propObj.key = propertyName;
					//also add the validation to the object..
					try{
						var validationRules = validationObj.rules[propertyName];
						var validationMessages = validationObj.messages[propertyName];

						if(propObj.templateOptions && validationRules){
							if(propObj.templateOptions.id){
								var validationName = propObj.templateOptions.id;
								//Get the validation object..
								newValidationObj.rules[validationName] = validationRules;
								newValidationObj.messages[validationName] = validationMessages;
							}
						}
					}catch(err){
						// Do nothing
						// Validation is not defined in the model definition
					}

					schema.fields.push(propObj);
				}
			}
		}//for-in

        //This code is just for adding validation in schema..of relation properties..
        var modelRelation = modelObj.definition.settings.relations;
        for(var relationName in modelRelation){
			if(modelRelation.hasOwnProperty(relationName)){
				var relationObj = modelRelation[relationName].templateOptions;
				if(relationObj !== undefined){
					relationObj.key = relationName;
					//also add the validation to the object..
					try{
						var validationRules_ = validationObj.rules[relationName];
						var validationMessages_ = validationObj.messages[relationName];

						if(relationObj && validationRules_){
							if(relationObj.id){
								var validationName_ = relationObj.id;
								//Get the validation object..
								newValidationObj.rules[validationName_] = validationRules_;
								newValidationObj.messages[validationName_] = validationMessages_;
							}
						}

					}catch(err){
                        console.error(err);
						// Do nothing
						// Validation is not defined in the model definition
					}

				}
			}
		}//for-in
		//Now adding validation obj..
		schema.validations = newValidationObj;
		return schema;
	};




	//return all the methods that you wish to provide user to extend this plugin.
	return {
		init: init
	};
}; //module.exports
