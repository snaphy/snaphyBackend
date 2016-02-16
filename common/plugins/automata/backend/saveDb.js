(function(){'use strict';})();

var Promise = require('bluebird');
var _       = require('lodash');
var async = require('async');

/**
 * Method for adding save method
 * @param  {[type]} app       [description]
 * @param  {[type]} modelName [description]
 * @return {[type]}           [description]
 */
var addSaveMethod = function(app, modelName){
    var modelObj            = app.models[modelName];
    var modelRelationSchema = modelObj.definition.settings.relations;
    /**
     * Remote method for saving data with its depedencies
     * @param  {array} data   Adding data object containing model data.
     * @example
     * data:
     * 	{
     * 		name: '1',
     * 		age: '19',
     * 		recipes:[{name : kabab}],
     * 		details:{
     * 			address: '169 west Avenue'
     * 		}
     *  }
     *
     * @param  {object} schema Schema object containg relationship information for the data.
     * @example  schema:{
     *           'relation': {
     *           	'hasMany':['recipes'],
     *           	'belongsTo':['details']
     *           	 }
     *           	}
     * @return {[type]}        [return the object of data with id property attached with it.]
     */
    modelObj.save = function(data, schema, callback){
        if(data === undefined || schema === undefined){
            callback('Error: model data or model schema cannot be empty');
            return false;
        }


        var app = this.app;
        //remove the relation its different category and save the data first.
        var relations={
            hasMany:{},
            belongsTo:{},
            hasAndBelongsToMany:{},
            hasOne:{},
            hasManyThrough:{}
        };

        var include = addRelation(data, schema.relation, relations);
        if(data.password !== undefined){
            data.password = data.password.toString().trim();
        }
        if(data.id === undefined){
            //Now save/update the data..

            modelObj.create(data)
            .then(function(dataInstance){
                console.log("Main data successfully updated");
                saveDataRelations(app, dataInstance, relations, modelRelationSchema, modelName, include, schema.relation,  callback);
            })
            .catch(function(err){
                console.log("Error saving data");
                callback(err);
            });
        }else{
            //console.log("I am updatting");

            //Now save/update the data..
            modelObj.upsert(data)
            .then(function(dataInstance){
                //console.log(dataInstance);
                //console.log("\n\n\n");
                //console.log("Main data successfully updated");
                saveDataRelations(app, dataInstance, relations, modelRelationSchema, modelName, include, schema.relation,  callback);
            })
            .catch(function(err){
                console.log("Error saving data");
                callback(err);
            });

        }




    };
    //Now registering the method `getSchema`
    modelObj.remoteMethod(
            'save',
            {
                accepts: [
                    {arg: 'data',  type: 'object'},
                    {arg:'schema', type: 'object'}
                ],
                returns: {arg: 'data', type: 'object'},
                description: "Remote method for saving data with its depedencies",
                http: {status: 201}
            }
    );
}; //addSaveMethod



//And remove those relation obj from the data obj..
//Also return the include filter
var addRelation = function(dataObj, relationSchema, localRelationObj){
    var include = [];
    for(var property in relationSchema){
        if(relationSchema.hasOwnProperty(property)){
            var objValue = relationSchema[property];
            for(var i=0; i< objValue.length; i++){
                var relationName = objValue[i];

                if(Object.prototype.toString.call(relationName) === "[object Object]"){
                    //relation type is hasManyThrough
                    if(dataObj[relationName.relationName]){
                        //include.push(relationName.relationName);
                        localRelationObj[property][relationName.relationName] = dataObj[relationName.relationName];
                        delete dataObj[relationName.relationName];
                    }
                }else{
                    if(dataObj[relationName]){
                        include.push(relationName);
                        localRelationObj[property][relationName] = dataObj[relationName];
                        delete dataObj[relationName];
                    }
                }
            }//for loop..

        }//if
    }//for in loop.
    return include;
}; //addRelation method




/**
 * Method for saving Data Relations
 * @param  {object} dataInstance        Containts the Instance of save model data.
 * @param  {object} relations           Contains the relations object.
 * @param  {object} modelRelationSchema Containts the schema relation object.
 * @return {[type]}                     [description]
 */
var saveDataRelations = function(app, dataInstance, relations, modelRelationSchema, modelName, include, relationSchema, callback){
    var promises = [];
    //console.log(relations.hasManyThrough.ingredients);
    //console.log("=====================ABOVE WAS RELATION DATA=========================");
    //Now run a loop of the model schema..
    for(var relationsType in relations){
        if(relations.hasOwnProperty(relationsType)){
            var relationData = relations[relationsType];
            //Now check if the modelData is empty or not.
            if(!_.isEmpty(relationData)){

                //Now save/update the current relation type.
                saveOrUpdate(app, dataInstance, relationsType, relationData, modelRelationSchema, promises, modelName, relationSchema,  callback);
            }
        }//if
    }//for loop..



    /**
     * Return promise after all the callback has finished.
     */
    //TODO PROMISE NOT CALLING AFTER THE RELATED DATA SAVED IS CALLING BEFORE RELATED DATA SAVED.
    //TODO HasManyThrough data not fetched during promise. Must be fetched.
    Promise.all(promises).then(function(){
        var modelObj = app.models[modelName];
        //console.log("All done");
        modelObj.findById(dataInstance.id, {include:include}, function(err, value){
            //Return callback.
            callback(null, value);
        });
    }).catch(function(err){
        callback(err);
    });

};





/**
 * Save belongsTo relations
 * Data format
 * {
 * 		`employeeDetails`: {
 * 			'address': 'mumbai',
 *    		'contact': 9953242833
 * 		},
 * 		employeeOtherDetails:{
 * 			alternateNumber: '9953242337'
 * 		}
 * }
 * @param  {[type]} dataInstance        [description]
 * @param  {[type]} relationsType        [description]
 * @param  {[type]} relationDataObj     [description]
 * @param  {[type]} modelRelationSchema [description]
 * @return {[type]}                     [description]
 */
var saveOrUpdate = function(app, dataInstance, relationsType, relationDataObj, modelRelationSchema, promises, modelName, relationSchema,  callback){
    for(var relationName in relationDataObj ){
        if(relationDataObj.hasOwnProperty(relationName)){
            var relationData = relationDataObj[relationName];
            var relatedModelName = modelRelationSchema[relationName].model;
            //console.log(modelRelationSchema[relationName]);
            //Now just upsert the relation..
            var modelObj = app.models[relatedModelName];

            //get the foriegnKey.
            var foriegnKey = modelRelationSchema[relationName].foriegnKey;
            if(!foriegnKey){
                foriegnKey = modelRelationSchema[relationName].model.toLowerCase() + 'Id';
            }

            if(relationsType === 'belongsTo'){
                //console.log(relationData);
                //Upsert belongs to relations and attach the relation to the
                promises.push(upsertBelongsTo (modelObj, relationData, dataInstance, relationName, foriegnKey, callback) );
            }//if
            else if(relationsType === 'hasOne'){
                //Upsert belongs to relations and attach the relation to the
                promises.push(upsertHasOne (app, modelObj, relationData, dataInstance, relationName, modelName,  callback) );
            }//if
            else if (relationsType === 'hasMany') {
                //relatedModelClass, relationDataArr, dataInstance, relationName, foriegnKey, manyType, callback
                promises.push( upsertTypeMany(modelObj, relationData, dataInstance, relationName, foriegnKey, 'hasMany', callback));
            }//else if
            else if(relationsType === 'hasAndBelongsToMany'){
                promises.push(upsertTypeMany(modelObj, relationData, dataInstance, relationName, foriegnKey, 'hasAndBelongsToMany', callback) );
            }
            else if(relationsType === 'hasManyThrough'){

                //console.log("========================BEFORE SENDING TO HASMANYTHROUGH===========================");
                //console.log(relationData);
                promises.push(upsertManyThrough(app, modelObj, relationData, dataInstance, relationName, foriegnKey, relationSchema,  callback) );
            }else{
                //Do nothing
                //console.log('I am inside do nothing case. I dont know what to do.');
            }
        } //if
    }//for in loop.
};




var upsertHasOne = function(app, modelObj, relationData, dataInstance, relationName, parentModel, callback){
    //Adding two way communication ..
    //Now get the relataion name at parent model.
    var childRelationsObj = modelObj.definition.settings.relations;
    var parentObj         = app.models[parentModel];
    var parentRelationName;
    for(var relationObj in childRelationsObj){
        if(childRelationsObj.hasOwnProperty(relationObj)){
            var modelName = childRelationsObj[relationObj].model;
            if(modelName === parentModel && childRelationsObj[relationObj].type === "hasOne"){
                parentRelationName = relationObj;
            }
        }
    }



    if(!_.isEmpty(relationData)){
        var mainModel = dataInstance[relationName].build(relationData);
        modelObj.upsert(mainModel)
        .then(function(result){
            //Now add the result to the dataInstance
            //Now add this relation to the parent as well..
            if(result){
                var parentData = result[parentRelationName].build(dataInstance);
                //Now update the parent data..
                parentObj.upsert(parentData)
                .then(function(){
                    console.log("Data Successfully updated in parent hasOne");
                })
                .catch(function(err){
                    console.log("error occured in hasOne parent upsert");
                    console.error(err);
                });
            }
        })
        .catch(function(err){
            console.log("Error saving data");
            callback(err);
        });
    }
};




var upsertBelongsTo = function(modelObj, relationData, dataInstance, relationName, foriegnKey, callback){
    if(!_.isEmpty(relationData)){
        modelObj.upsert(relationData)
        .then(function(data){
            //Now attach data to the parent dataInstance..
            dataInstance[relationName](data);
            dataInstance[foriegnKey] = data.id;

            dataInstance.save()
            .then(function(value){
                console.log("Successfully saved belongsTo data.");
            })
            .catch(function(err){
                console.log("Error saving belongsTo data relationship.");
                callback(err);
            });
        })
        .catch(function(err){
            console.log("Error updating belongsTo data relationship.");
            callback(err);
        });
    }
};




var upsertManyThrough = function(app, modelObj, relationData, dataInstance, relationName, foriegnKey, relationSchema, callback){
    //now find the current relation schema..
    var hasManyThrough = relationSchema.hasManyThrough;
    var index = null;
    for(var i=0; i< hasManyThrough.length; i++){
        var relation = hasManyThrough[i];
        if(relation.relationName === relationName){
            index = i;
            break;
        }
    }

    var throughModelName;
    var throughModelForeignKey;
    var throughModelSchema;
    var throughModelObj;
    var dataInstanceForeignKey;

    if(index === null){
        return false;
    }
    else{
        throughModelSchema = hasManyThrough[index];
        //console.log(throughModelSchema);
        throughModelName   = throughModelSchema.through;
        throughModelObj    = app.models[throughModelName];
        dataInstanceForeignKey = throughModelSchema.whereId;
        var relationObj    = throughModelObj.definition.settings.relations;
        var relationData_   = relationObj[throughModelSchema.throughModelRelation];
        if(relationData_.foreignKey === ""){
            throughModelForeignKey = relationData_.model.toLowerCase() + "Id";
        }else{
            throughModelForeignKey = relationData_.foreignKey;
        }
    }

    var throughObj = {
        throughModelForeignKey: throughModelForeignKey,
        dataInstanceForeignKey: dataInstanceForeignKey,
        throughModelObj       : throughModelObj
    };

    deleteRepeatedData(app,
         throughModelObj,
         dataInstanceForeignKey,
         dataInstance,
         relationData,
         modelObj,
         relationName,
         foriegnKey,
         relationSchema,
         throughObj,
         callback);
};



/**
 * Delete repeated data of hasManyThrough
 * @param  {[type]}   throughModelObj        [description]
 * @param  {[type]}   dataInstanceForeignKey [description]
 * @param  {[type]}   dataInstance           [description]
 * @param  {Function} callback               [description]
 * @return {[type]}                          [description]
 */
var deleteRepeatedData = function(
    app,
    throughModelObj,
    dataInstanceForeignKey,
    dataInstance,
    relationData,
    modelObj,
    relationName,
    foriegnKey,
    relationSchema,
    throughObj,
    callback){
    var filter = {};
    filter.where = {};
    filter.where[dataInstanceForeignKey] = dataInstance.id;

    async.series([
        function(){
            //Now check for any repeated data.. and remove it..
            throughModelObj.find(filter)
            .then(function(values){
                values.forEach(function(element){
                    var matchFound = false;
                    //Now loop through relationData as well..
                    for(var i=0; i<relationData.length; i++){
                        var relatedDataObj = relationData[i];
                        if(relatedDataObj.id){
                            if(relatedDataObj.id.toString().trim( ) === element.id.toString().trim()){
                                matchFound = true;
                                break;
                            }
                        }
                    }

                    if(!matchFound){
                        //destroy data..
                        element.destroy(function(err){
                            if(err){
                                callback(err);
                                return null;
                            }
                            console.log("unused hasManyThrough data destroyed.");
                        });
                    }
                });

                relationData.forEach(function(relationDataObj){
                    upsertHasManyThroughFinal(
                        app,
                        modelObj,
                        relationDataObj,
                        dataInstance,
                        relationName,
                        foriegnKey,
                        relationSchema,
                        throughObj,
                        callback);
                });
            })
            .catch(function(err){
                callback(err);
            });
        }
    ]);
};



var upsertHasManyThroughFinal = function(app, modelObj, relationDataObj, dataInstance, relationName, foriegnKey, relationSchema, throughObj, callback){
    var relatedData = relationDataObj[relationName];


    if(relatedData){
        modelObj.upsert(relatedData)
        .then(function(savedRelatedData){
            //Now save the related through data..
            delete relationDataObj[relationName];
            var relatedHasManyThroughData = relationDataObj;
            relatedHasManyThroughData[throughObj.throughModelForeignKey] = savedRelatedData.id;
            //Add main datainstance id..
            relatedHasManyThroughData[throughObj.dataInstanceForeignKey] = dataInstance.id;
            //Now save hasManyThrough Data...
            throughObj.throughModelObj.upsert(relatedHasManyThroughData)
            .then(function(savedData){
                console.log("HasMany through Data saved..");
                //console.log(savedData);
            })
            .catch(function(err){
                callback(err);
            });
        })
        .catch(function(err){
            callback(err);
        });
    }
};




//Upsert for hasMany and hasAndBelongsToMany common preprocess steps..
var upsertTypeMany = function(relatedModelClass, relationDataArr, dataInstance, relationName, foriegnKey, manyType, callback){
    try{
        //first get the old data and check if any old data is deleted from new data..
        dataInstance[relationName]({}, function(err, oldDataArr){
            var deletedDataId = [];
            oldDataArr.forEach(function(dataObj, index){
                var idFound = false;
                //Now loop over relationDataArr
                for(var i=0; i< relationDataArr.length; i++){
                    if(relationDataArr[i].id){
                        if(dataObj.id.toString().trim() === relationDataArr[i].id.toString().trim()){
                            idFound = true;
                            break;
                        }
                    }
                }
                if(!idFound){
                    destroyHasManyRel(
                        dataInstance,
                        relationName,
                        dataObj,
                        manyType,
                        relationDataArr,
                        relatedModelClass,
                        callback);
                }
            });


        });
    }
    catch(err){
        callback(err);
    }

};


//For destroying hasMany relation link ..
var destroyHasManyRel = function(
    dataInstance,
    relationName,
    dataObj,
    manyType,
    relationDataArr,
    relatedModelClass,
    callback
){
    async.series([
        function(){
            if(manyType === "hasMany"){
                //destroy that data..
                dataInstance[relationName].destroy(dataObj.id)
                .then(function(){
                    console.log('unused hasMany link data destroyed');
                })
                .catch(function(err){
                      callback(err);
                });
            }else{

                //Dont delete just remove.. the data..
                dataInstance[relationName].remove(dataObj)
                .then(function(){
                    console.log('unused hasAndBelongsToMany link data removed');
                })
                .catch(function(err){
                    callback(err);
                });


            }

        }, function(){
            //add foriegnKey
            relationDataArr.forEach(function(relationData){

                if(manyType === 'hasMany'){
                    //relationData[foriegnKey] = dataInstance.id;
                    upsertHasManyFinal(relatedModelClass, relationData, dataInstance, relationName,  callback);
                }
                if(manyType === 'hasAndBelongsToMany'){
                    upserthasAndBelongsToManyFinal(dataInstance, relationName, relationData, relatedModelClass, callback);
                }
            });
        }
    ]);
};



var upsertHasManyFinal = function(relatedModelClass, relationData, dataInstance, relationName,  callback){
    //Now update the data and add the data to the main data instance..
    var data = dataInstance[relationName].build(relationData);
    relatedModelClass.upsert(data)
    .then(function(data_){
        console.log("Has many data added to server.");
    })
    .catch(function(err){
        callback(err);
    });
};


var upserthasAndBelongsToManyFinal = function(dataInstance, relationName, relationData, relatedModelClass, callback){
    relatedModelClass.upsert(relationData, function(err, data){
        if (err) {
            console.log("\n\n\nGot error");
            throw err;
        }

        dataInstance[relationName].add(data)
        .then(function(){
            console.log("Link successfully added to hasAndBelongsToMany relationship.");
        })
        .catch(function(err){
            callback(err);
        });

    });
};








//Return all the methods defined here..
module.exports =  {
    addSaveMethod: addSaveMethod
};
