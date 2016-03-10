(function(){'use strict';})();
var async = require('async');
var _ = require('lodash');

//Modify mongodb relation addition for adding data to hasAndBelongToMany..
/**
 * Modifying mongo db relations for providing better search and filter in varoius advanced cases.
 * @param app
 * @param modelName
 */
var modifyRelation = function(app, modelName){
    var modelObj  = app.models[modelName];
    var relations = modelObj.definition.settings.relations;
    for(var relationName in relations){
        if(relations.hasOwnProperty(relationName)){
            var relationProp = relations[relationName];
            var foreignKey   = relationProp.foreignKey;
            if(foreignKey === ""){
                var lowercaseModelName = deCapitalizeFirstLetter(relationProp.model);
                foreignKey = lowercaseModelName + "Id";
            }
            //Handle various relations types..
            handleRelation(app, modelObj, foreignKey, relationProp, relationName, modelName);
        }
    }
};


var handleRelation = function(app, modelObj, foreignKey, relationProp, relationName, modelName){
    var relationType = relationProp.type;
    if(relationType === "hasOne"){

    }
    else if(relationType === "belongsTo"){

    }
    else if(relationType === "hasMany"){

    }
    else if(relationType === "hasManyThrough"){

    }
    else if(relationType === "hasAndBelongsToMany"){
        //We are concerned with hasManyThrough relation only ...
        //Now create a new method.. connect and disconnect
        connect (app, modelObj, foreignKey, relationProp, relationName, modelName);
        disconnect (app, modelObj, foreignKey, relationProp, relationName, modelName);
    }
    else{
        // Do nothing..
    }
};


/**
 * Connect various has many relationship
 * @param app
 * @param modelObj
 * @param foreignKey
 * @param relationProp
 * @param relationName
 * @param modelName
 */
var connect = function(app, modelObj, foreignKey, relationProp, relationName, modelName){

    /**
     dataInstance[relationName].add(data)
     .then(function(savedData) {
          //Now save the instance of data in the dataInstance
          console.log("Link successfully added to hasAndBelongsToMany relationship.");
     })
     .catch(function(err) {
                callback(err);
     });
     */

    //HERE fk is the list of foreign keys..
    /**
     *
     * @param id
     * @param fk ["String"] array of related data id that is about to be attached.
     * @param callback
     */
    modelObj.prototype["__connect__" + relationName] = function(id, fk, callback){

        modelObj.findById(id, {})
            .then(function(mainModelInstance){
                //Now adding main model instance..
                var relatedModel = app.models[relationProp.model];
                //Find the list of related models..
                relatedModel.find({
                    where:{
                        id: {
                            inq: fk
                        }
                    }
                })
                    .then(function(relatedModelInstanceArr){
                        var series = [];
                        //Now prepare a series function..
                        relatedModelInstanceArr.forEach(function(relatedModelInstance){
                            series.push(function(callback){
                                connectEachData (app, modelObj, foreignKey, relationProp, relationName, modelName, mainModelInstance, relatedModelInstance, callback);
                            });
                        });


                        //Now save the data in series..
                        async.series(series, function(err){
                            if(err){
                                callback(err);
                            }else{
                                //Now send the callback
                                callback(null, {});
                            }
                            console.log("data saved successfully..");
                        });
                    })
                    .catch(function(err){
                        console.error(err);
                        return callback(err);
                    });
            })
            .catch(function(err){
                console.error(err);
                return callback(err);
            });
    };


    modelObj["__connect__" + relationName] = modelObj.prototype["__connect__" + relationName];

    //Now registering the method `getSchema`
    modelObj.remoteMethod(
        '__connect__' + relationName,
        {
            "accepts": [{
                "arg": "id",
                "type": "any",
                "required": true,
                "http": {
                    "source": "path"
                },
                "description": "PersistedModel id"
            }, {
                "arg": "fk",
                "type": "array",
                "description": "Foreign key for cuisines",
                "required": true,
                "http": {
                    "source": "path"
                }
            }],
            "returns": [{
                "arg": relationName.toLowerCase(),
                "type": "object",
                "root": true
            }],
            "routes": [{
                "path": "/:id/connect/" +  relationName.toLowerCase()  + "/rel/:fk",
                "verb": "put"
            }],
            description: "Connect two hasAndBelongMany Data together..."
        }
    );
};


//Connect each data in series..
var connectEachData = function(app, modelObj, foreignKey, relationProp, relationName, modelName, mainModelInstance, relatedModelInstance, callback){
    var relatedModel = app.models[relationProp.model];
    //console.log(relatedModelInstance.name);
    //Now add data..
    mainModelInstance[relationName].add(relatedModelInstance)
        .then(function(savedData){

            //Now save the instance of data in the dataInstance
            /**
             * NOW DO SOMETHING HERE TOO...
             * Now add this values to each models..
             *by inserting a _ character as suffix..
             */
            var relatedModelRelationName;
            var relatedModelRelationProp;

            //console.log("Related model name", relationName+"_", mainModelInstance[relationName+"_"]);
            if(mainModelInstance[relationName+"_"] instanceof Array){
                mainModelInstance[relationName+"_"] =  {};
            }
            mainModelInstance[relationName+"_"] = mainModelInstance[relationName+"_"] || {};
            //first check if related data is already not present..
            //store data like object..
            /**
             * {
             *      id342: true,
             *      id232: true
             * }
             * @type {boolean}
             */
            mainModelInstance[relationName + "_"][relatedModelInstance.id] = true;
            //Now just updating the given relation attribute in the model..
            //persistedModel.updateAttribute(name, value, callback)
            mainModelInstance.updateAttribute(relationName + "_", mainModelInstance[relationName + "_"], function(err, updatedData){
                if(err){
                    callback(err);
                }else{
                    //Now the related model name..relation name
                    var relatedModelRelationObj = relatedModel.definition.settings.relations;
                    for(var relatedRelationName in relatedModelRelationObj){
                        if(relatedModelRelationObj.hasOwnProperty(relatedRelationName)){
                            var relatedRelationProp = relatedModelRelationObj[relatedRelationName];
                            if(relatedRelationProp.model === modelName){
                                relatedModelRelationName = relatedRelationName;
                                relatedModelRelationProp = relatedRelationProp;
                                break;
                            }
                        }
                    }

                    if(relatedModelRelationName){
                        //If relation value is in instance of array the change it to object..
                        if(relatedModelRelationName[relatedModelRelationName+"_"] instanceof Array){
                            relatedModelRelationName[relatedModelRelationName+"_"] =  {};
                        }

                        relatedModelInstance[relatedModelRelationName + "_"] = relatedModelInstance[relatedModelRelationName + "_"] || {};
                        //Now add data to this model too..
                        relatedModelInstance[relatedModelRelationName + "_"][mainModelInstance.id] = true;

                        //Now updating the property.. of the related value..
                        relatedModelInstance.updateAttribute(relatedModelRelationName + "_", relatedModelInstance[relatedModelRelationName + "_"], function(err, value){
                            if(err){
                                console.error(err);
                                callback(err);
                            }else{
                                console.info("saving related value", value);
                                //Do nothing.. return async callback..success..
                                callback();
                            }
                        });
                    }else{
                        callback(new Error("Bad data"));
                    }
                }
            });
        })
        .catch(function(err){
            return callback(err);
        });
};


var disconnectEachData = function(app, modelObj, foreignKey, relationProp, relationName, modelName, mainModelInstance, relatedModelInstance, callback) {
    var relatedModel = app.models[relationProp.model];

    /**
     * dataInstance[relationName].remove(dataObj)
     .then(function() {
            console.log('unused hasAndBelongsToMany link data removed');
            callback();
        })
    .catch(function(err) {
            callback(err);
        });
     */
    mainModelInstance[relationName].remove(relatedModelInstance)
        .then(function(){
            //Now remove the related data too from each models..
            if(mainModelInstance[relationName + "_"]){
                //Now remove the related data refrence from mainModel
                console.log("===========BEFORE DELETE========", mainModelInstance[relationName + "_"]);
                //remove the given instance..
                delete mainModelInstance[relationName + "_"][relatedModelInstance.id];
                //_.omit(mainModelInstance[relationName + "_"], [relatedModelInstance.id]);
                console.log("===========AFTER DELETE========", mainModelInstance[relationName + "_"]);

                //persistedModel.updateAttribute(name, value, callback)
                mainModelInstance.updateAttribute(relationName + "_", mainModelInstance[relationName + "_"], function(err, value){
                    if(err){
                        console.error(err);
                    }else{
                        console.log("Successfully remove ref of hasAndBelongsToMany from main model");
                    }
                });


                //Now also remove the main model id reference from related model ..
                var relatedModelRelationName;
                var relatedModelRelationProp;
                //Now also add data to related data..
                //Now the related model name..relation name
                var relatedModelRelationObj = relatedModel.definition.settings.relations;
                for(var relatedRelationName in relatedModelRelationObj){
                    if(relatedModelRelationObj.hasOwnProperty(relatedRelationName)){
                        var relatedRelationProp = relatedModelRelationObj[relatedRelationName];
                        if(relatedRelationProp.model === modelName){
                            relatedModelRelationName = relatedRelationName;
                            relatedModelRelationProp = relatedRelationProp;
                            break;
                        }
                    }
                }

                if(relatedModelRelationName){
                    //Now also remove the ref of main model..
                    if(relatedModelInstance[relatedModelRelationName + "_"]){
                        //Remove the related data.....
                        delete relatedModelInstance[relatedModelRelationName + "_"][mainModelInstance.id];
                        //persistedModel.updateAttribute(name, value, callback)
                        relatedModelInstance.updateAttribute(relatedModelRelationName + "_", relatedModelInstance[relatedModelRelationName + "_"], function(err, value){
                            if(err){
                                console.error(err);
                            }else{
                                console.log("Successfully remove ref of hasAndBelongsToMany from related model too");
                            }
                        });
                    }
                }
            }

            //finally return the callback..
            callback(null, {});

        })
        .catch(function(err){
            callback(err);
        });

};




var disconnect = function(app, modelObj, foreignKey, relationProp, relationName, modelName){

    modelObj.prototype["__disconnect__" + relationName] = function(id, fk, callback) {
        modelObj.findById(id, {})
            .then(function(mainModelInstance){
                //Now adding main model instance..
                var relatedModel = app.models[relationProp.model];
                //Find the list of related models..
                relatedModel.find({
                        where:{
                            id: {
                                inq: fk
                            }
                        }
                    })
                    .then(function(relatedModelInstanceArr){
                        var series = [];
                        //Now prepare a series function..
                        relatedModelInstanceArr.forEach(function(relatedModelInstance){
                            series.push(function(callback){
                                //Now remove the data and also remove the data from each other model..
                                disconnectEachData(app, modelObj, foreignKey, relationProp, relationName, modelName, mainModelInstance, relatedModelInstance, callback);
                            });
                        });

                        //Now save the data in series..
                        async.series(series, function(err){
                            if(err){
                                callback(err);
                            }else{
                                //Now send the callback
                                callback(null, {});
                            }
                            console.log("data deleted successfully..");
                        });

                    })
                    .catch(function(err){
                        console.error(err);
                        return callback(err);
                    });
            })
            .catch(function(err){
                console.error(err);
                return callback(err);
            });
    };

    modelObj["__disconnect__" + relationName] = modelObj.prototype["__disconnect__" + relationName];

    //Now registering the method `getSchema`
    modelObj.remoteMethod(
        '__disconnect__' + relationName,
        {
            "accepts": [{
                "arg": "id",
                "type": "any",
                "required": true,
                "http": {
                    "source": "path"
                },
                "description": "PersistedModel id"
            }, {
                "arg": "fk",
                "type": "array",
                "description": "Foreign key for cuisines",
                "required": true,
                "http": {
                    "source": "path"
                }
            }],
            "returns": [{
                "arg": relationName.toLowerCase(),
                "type": "object",
                "root": true
            }],
            "routes": [{
                "path": "/:id/connect/" +  relationName.toLowerCase()  + "/rel/:fk",
                "verb": "put"
            }],
            description: "Connect two hasAndBelongMany Data together..."
        }
    );
};




function deCapitalizeFirstLetter(string) {
    return string.charAt(0).toLowerCase() + string.slice(1);
}


module.exports = {
    modifyRelation: modifyRelation
};