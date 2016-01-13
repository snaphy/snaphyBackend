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
                        var lowercaseModelName = deCapitalizeFirstLetter(relationProp.model);
                        foreignKey = lowercaseModelName + "Id";
                    }
                    deleteRelations (app, modelObj, foreignKey, relationProp, relationName);

                }
            }
        }
    }
};



var deleteRelations = function(app, modelObj, foreignKey, relationProp, relationName, modelName){
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
        handleHasManyThrough(app, modelObj, foreignKey, relationProp, relationName, modelName);
    }
    else if(relationType === "hasAndBelongsToMany"){
        handleHasAndBelongsToMany(app, modelObj, foreignKey, relationProp, relationName);
    }
    else{
        // Do nothing..
    }
};


function deCapitalizeFirstLetter(string) {
    return string.charAt(0).toLowerCase() + string.slice(1);
}



var handleHasOne = function(app, modelObj, foreignKey, relationProp, relationName){
    return (function(app, modelObj, foreignKey, relationProp){
        var relatedModel = relationProp.model;
        var relatedModelObj = app.models[relatedModel];
        modelObj.observe("before delete", function(ctx, next){
            var where = ctx.where;
            modelObj.find({
                where: where
            })
            .then(function(modelInstanceArr){
                //console.log(modelInstanceArr);
                //console.log(foreignKey);
                modelInstanceArr.forEach(function(modelInstance){
                    //Remove the related model..

                    deleteHasOneFinally(modelInstance, foreignKey, relatedModelObj, next);
                    // modelInstance[relationName].destroy(function(err) {
                    //     if(err) {
                    //         throw err;
                    //     }
                    //     console.log("related data hasOne " + relationName + " deleted too");
                    // });
                });

            })
            .catch(function(err){
                console.error(err);
                next();
                return false;
            });
        });
    })(app, modelObj, foreignKey, relationProp, relationName);
};



var deleteHasOneFinally = function(modelInstance, foreignKey, relatedModelObj, next){
    if(modelInstance){
        //Find the element..
        relatedModelObj.findById(modelInstance[foreignKey], {}, function(err, instance){
            if(instance){
                instance.destroy(function(err){
                    if(err){
                        console.error(err);
                        next(err);
                    }
                    console.log("hasOne data successfully destroyed");
                    next();
                });
            }
            else{
                next();
            }
        });
    }


};


var handleBelongsTo = function(app, modelObj, foreignKey, relationProp, relationName){
    return (function(app, modelObj, foreignKey, relationProp, relationName){
        console.log("Inside belongsTo remove");
        modelObj.observe("before delete", function(ctx, next){
            var where = ctx.where;
            modelObj.find({
                where: where
            })
            .then(function(modelInstanceArr){
                modelInstanceArr.forEach(function(modelInstance){
                    removeBelongsToFinally(app, modelInstance, relationProp, foreignKey);
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


var removeBelongsToFinally = function(app, modelInstance, relationProp, foreignKey){
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
};


var handleHasManyThrough = function(app, modelObj, foreignKey, relationProp, relationName, modelName){
    return (function(app, modelObj, foreignKey, relationProp, relationName, modelName){
        modelObj.observe("before delete", function(ctx, next){
            var where = ctx.where;
            modelObj.find({
                where: where
            })
            .then(function(modelInstanceArr){
                modelInstanceArr.forEach(function(modelInstance){
                    removeHasManyThroughFinally(app, modelInstance, relationName, relationProp, modelName);
                });
                next();
            })
            .catch(function(err){
                console.error(err);
                next();
                return false;
            });
        });
    })(app, modelObj, foreignKey, relationProp, relationName, modelName);
};


var removeHasManyThroughFinally = function(app, modelInstance, relationName, relationProp, modelName){
    var throughModel    = relationProp.through;
    var throughModelObj = app.models[throughModel];
    var throughModelRelations = throughModelObj.definition.settings.relations;
    var foreignKey;
    //getting the foreignkey..
    for(var throughRelationName in throughModelRelations){
        if(throughModelRelations.hasOwnProperty(throughRelationName)){
            var throughRelationProp = throughModelRelations[throughRelationName];
            if(throughRelationProp.model === modelName){
                if(throughRelationProp.foreignKey !== ""){
                    foreignKey = throughRelationProp.model.toLowerCase() + "Id";
                }else{
                    foreignKey = throughRelationProp.foreignKey;
                }
                break;
            }
        }
    }

    if(!foreignKey || modelInstance.id === undefined ){
        return false;
    }

    var where = {};
    where[foreignKey] = modelInstance.id;
    console.log("I am  deleting hasManyThrough");

    //Now destroy the related data..
    //PersistedModel.destroyAll([where], callback)
    throughModelObj.destroyAll(where, function(err){
        if(err){
            console.error(err);
            return false;
        }
        console.log("hasManyThrough data destroyed successfully");
    });
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
                    removeHasManyFinally(modelInstance, relationName);
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



var removeHasManyFinally = function(modelInstance, relationName){
    modelInstance[relationName].destroyAll(function(err) {
        if(err){
            throw err;
        }
        console.log("HasMany data successfully deleted");
    });
};



var handleHasAndBelongsToMany = function(app, modelObj, foreignKey, relationProp, relationName){
    return (function(app, modelObj, foreignKey, relationProp, relationName){
        console.log("Inside hasAndBelongsToMany remove");
        modelObj.observe("before delete", function(ctx, next){
            var where = ctx.where;
            modelObj.find({
                where: where
            })
            .then(function(modelInstanceArr){
                modelInstanceArr.forEach(function(modelInstance){
                    removeHasAndBelongToFinally (modelInstance, relationName);
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


var removeHasAndBelongToFinally = function(modelInstance, relationName){
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
