'use strict';
var init = function(server, databaseObj, helper, packageObj) {
    //Load login plugin..
    var login = helper.loadPlugin('login');
    //Now load plugin role checking method..
    var verifyRole = login.verifyRole;
    addModelSecurity(server, databaseObj, helper, packageObj, verifyRole);

};


//add recipe
/*
onLoad{
 addWhere:{
    where:{
        "status":"onhold"
    }
    except: 'admin'
 },
 propertyEdit:{
  //property must not be array or object TODO ADD CHECK FOR OBJECT AND OBJECT LATER
  propertyName: "status",
  except: "admin"
 }

}
 */
var addModelSecurity = function(server, databaseObj, helper, packageObj, verifyRole) {
    var app = server;
    var models = app.models();
    //Now checking the models definition..
    models.forEach(function(Model) {
        //adding security..
        addOnLoadSecurity(server, Model.modelName, verifyRole);
    });
}

var addOnLoadSecurity = function(app, modelName, verifyRole) {
    var modelObj = app.models[modelName];
    var modelProperties = modelObj.definition.rawProperties;
    var onLoadProp = modelObj.definition.settings.onLoad;
    if (onLoadProp) {
        //Add access
        addProperty(modelObj, onLoadProp, verifyRole);
        //TODO IMPLEMENT THIS IN FUTURE..
        // if(onLoadProp.propertyEdit){
        //     addEditSecurity(modelObj, onLoadProp, verifyRole);
        // }
    }
};


var addProperty = function(modelObj, onLoadProp, verifyRole) {
    modelObj.observe('access', function addDefaultWhere(ctx, next){
        //ctx.query.where.tenantId = loopback.getCurrentContext().tenantId;
        if(onLoadProp){
            if(onLoadProp.addWhere.where){
                var where = onLoadProp.addWhere.where;
                if(onLoadProp.addWhere.except){
                    //Check if current user isin given role.
                    verifyRole(onLoadProp.addWhere.except, function(err, inRole){
                        if(err){
                            return next(err);
                        }else{
                            if(inRole){
                                next();
                            }else{
                                addWhere(where, ctx, next);
                            }
                        }
                    });
                }else{
                    //Add where statement..
                    addWhere(where, ctx, next);
                }
            }else{
                next();
            }
        }else{
            next();
        }
    });
}

//TODO ADD CHECK FOR OBJECT AND OBJECT LATER
//Add security for editing any property..
var addEditSecurity = function(modelObj, onLoadProp, verifyRole){
    modelObj.observe('before save', function addEditSecutity(ctx, next){
        if(onLoadProp){
            if(onLoadProp.propertyEdit){

                if(ctx.instance){
                    checkRestrictedProp(
                        modelObj,
                        onLoadProp.propertyEdit.propertyName,
                        onLoadProp.propertyEdit.except,
                        ctx,
                        ctx.isNewInstance,
                        verifyRole,
                        next
                    );
                }else{
                    //console.log(ctx.instance);
                    //console.log(ctx.data);
                    checkRestrictedProp(
                        modelObj,
                        onLoadProp.propertyEdit.propertyName,
                        onLoadProp.propertyEdit.except,
                        ctx,
                        ctx.isNewInstance,
                        verifyRole,
                        next
                    );
                    //next();
                }
            }else{

                next();
            }
        }else{

            next();
        }
    });
};


//TODO IMPLEMENT THIS IN FUTURE..
var checkRestrictedProp = function(modelObj, propName,  exceptRole, ctx, isNew, verifyRole,  next){
    next();
};






var addWhere = function(where, ctx, next){
    if(ctx.query.where === undefined){
        ctx.query.where = {};
    }
    //console.log(where);
    for(var whereProp in where){
        if(where.hasOwnProperty(whereProp)){
            //Add where prop..
            ctx.query.where[whereProp] = where[whereProp];
        }
    }
    //console.log(ctx.query.where);
    //console.log("================WHERE================");
    next();
}




module.exports = {
    init: init
}
