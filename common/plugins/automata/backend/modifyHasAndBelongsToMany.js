(function(){'use strict';})();


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
        //We are concerned with hasManyThrough relation only ...
        //Now create a new method.. connect and disconnect

    }
    else if(relationType === "hasAndBelongsToMany"){

    }
    else{
        // Do nothing..
    }
};



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

    modelObj.prototype["__connect__" + relationName.toLowerCase()] = function(id, fk, callback){
        modelObj.findById(id, {})
            .then(function(mainModelInstance){
                //Now adding main model instance..
                var relatedModel = app.models[relationProp.model];
                relatedModel.findById(fk, {})
                    .then(function(relatedModelInstance){
                        //Now add data..
                        mainModelInstance[relationName].add(relatedModelInstance)
                            .then(function(savedData){
                                //Now save the instance of data in the dataInstance
                                console.log("Link successfully added to hasAndBelongsToMany relationship.");
                                /**
                                 * NOW DO SOMETHING HERE TOO...
                                 *
                                 */


                            })
                            .catch(function(err){
                                return callback(err);
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


        //Now registering the method `getSchema`
    modelObj.remoteMethod(
        'prototype.__connect__' + relationName.toLowerCase(),
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
                "type": "any",
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