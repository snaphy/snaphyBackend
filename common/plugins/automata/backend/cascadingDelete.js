(function(){'use strict';})();


var onCascadeDelete = function(server, modelName){
    var app       = server;
    var modelObj  = app.models[modelName];
    var relations = modelObj.definition.settings.relations;
    for(var relationName in relations){
        if(relations.hasOwnProperty(relationName)){
            var cascadeDelete = relations[relationName].onCascadeDelete;
            if(cascadeDelete !== undefined){
                if(cascadeDelete){
                    var relationProp = relations[relationName];
                    var foreignKey   = relationProp.foreignKey;
                    if(foreignKey === ""){
                        foreignKey = relationName + "Id";
                    }
                    deleteRelations (app, modelObj, foreignKey, relationProp, relationName);

                }
            }
        }
    }
};



var deleteRelations = function(app, modelObj, foreignKey, relationProp, relationName){
    var relationType = relationProp.type;
    if(relationType === "hasOne"){
        handleHasOne(app, modelObj, foreignKey, relationProp, relationName);
    }
    else if(relationType === "belongsTo"){
        handleBelongsTo(app, modelObj, foreignKey, relationProp, relationName);
    }
    else if(relationType === "hasMany"){
        handleHasMany(app, modelObj, foreignKey, relationProp, relationName);
    }
    else if(relationType === "hasManyThrough"){
        //handleHasManyThrough();
        //TODO NOT FULLY implemented though
        handleHasMany(app, modelObj, foreignKey, relationProp, relationName);
    }
    else if(relationType === "hasAndBelongsToMany"){
        handleHasAndBelongsToMany(app, modelObj, foreignKey, relationProp, relationName);
    }
    else{
        // Do nothing..
    }
};




var handleHasOne = function(app, modelObj, foreignKey, relationProp, relationName){
    return (function(app, modelObj, foreignKey, relationProp, relationName){
        modelObj.observe("before delete", function(ctx, next){
            var where = ctx.where;
            modelObj.find({
                where: where
            })
            .then(function(modelInstanceArr){
                modelInstanceArr.forEach(function(modelInstance){
                    modelInstance[relationName].destroy(function(err) {
                        if(err) {
                            throw err;
                        }
                        console.log("related data hasOne" + relationName + " deleted too");
                    });
                });
                //Move to next middleware
                next();
            })
            .catch(function(err){
                console.error(err);
                next();
                return false;
            });
        });
    })(app, modelObj, foreignKey, relationProp, relationName);
};


var handleBelongsTo = function(app, modelObj, foreignKey, relationProp, relationName){
    return (function(app, modelObj, foreignKey, relationProp, relationName){
        modelObj.observe("before delete", function(ctx, next){
            var where = ctx.where;
            modelObj.find({
                where: where
            })
            .then(function(modelInstanceArr){
                modelInstanceArr.forEach(function(modelInstance){
                    var relatedDataId = modelInstance[foreignKey];
                    if(relatedDataId){
                        var relatedModel = relationProp.model;
                        var relatedModelObj = app.models[relatedModel];
                        relatedModelObj.destroyById(relatedDataId, function(err){
                            if(err){
                                throw err;
                            }
                            console.log("belongsTo cascadeDelete removed successfully");
                        });
                    }
                });
                //Move to next middleware
                next();
            })
            .catch(function(err){
                console.error(err);
                next();
                return false;
            });
        });
    })(app, modelObj, foreignKey, relationProp, relationName);
};

var handleHasMany = function(app, modelObj, foreignKey, relationProp, relationName){
    return (function(app, modelObj, foreignKey, relationProp, relationName){
        modelObj.observe("before delete", function(ctx, next){
            var where = ctx.where;
            modelObj.find({
                where: where
            })
            .then(function(modelInstanceArr){
                modelInstanceArr.forEach(function(modelInstance){
                    modelInstance[relationName].destroyAll(function(err) {
                        if(err){
                            throw err;
                        }
                    });
                });
                next();
            })
            .catch(function(err){
                console.error(err);
                next();
                return false;
            });
        });
    })(app, modelObj, foreignKey, relationProp, relationName);
};

//HasMany still not implemented fully..
var handleHasManyThrough = function(){

};


var handleHasAndBelongsToMany = function(app, modelObj, foreignKey, relationProp, relationName){
    return (function(app, modelObj, foreignKey, relationProp, relationName){
        modelObj.observe("before delete", function(ctx, next){
            var where = ctx.where;
            modelObj.find({
                where: where
            })
            .then(function(modelInstanceArr){
                modelInstanceArr.forEach(function(modelInstance){
                    //Find all related data of the modelInstance..
                    modelInstance[relationName](function(err, relatedDataArr){
                        if(err){
                            console.error("cannot find related data parts for hasAndBelongToMany before delete");
                            throw err;
                        }
                        relatedDataArr.forEach(function(relatedDataInstance){
                            removeRelated(modelInstance, relationName, relatedDataInstance);
                        });
                    });
                });
                next();
            })
            .catch(function(err){
                console.error(err);
                next();
                return false;
            });
        });
    })(app, modelObj, foreignKey, relationProp, relationName);
};


var removeRelated = function(modelInstance, relationName, relatedDataInstance){
    modelInstance[relationName].destroy(relatedDataInstance.id, function(err){
        console.log("Related cascadeDelete hasAndBelongToMany data successfully removed");
    });
};





//Return all the methods defined here..
module.exports =  {
    onCascadeDelete: onCascadeDelete
};
