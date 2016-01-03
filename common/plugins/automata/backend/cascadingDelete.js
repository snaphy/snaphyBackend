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



//HasMany still not implemented fully..
var handleHasManyThrough = function(){
    console.log("Inside hasManyThrough remove");
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
