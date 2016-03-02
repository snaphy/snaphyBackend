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


        //Now registering the method `getSchema`
    modelObj.remoteMethod(
        'connect',
        {
            returns: {arg: 'data', type: 'object'},
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