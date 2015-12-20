(function(){'use strict';})();

var Promise = require('bluebird');
var _       = require('lodash');

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
            hasAndBelongToMany:{},
            hasOne:{}
        };

        var include = addRelation(data, schema.relation, relations);

        //Now save/update the data..
        modelObj.upsert(data)
        .then(function(dataInstance){

            console.log("Main data successfully updated");
            saveDataRelations(app, dataInstance, relations, modelRelationSchema, modelName, include,  callback);
        })
        .catch(function(err){
            console.log("Error saving data");
            callback(err);
        });



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
                //console.log(relationName);
                if(dataObj[relationName]){
                    include.push(relationName);
                    localRelationObj[property][relationName] = dataObj[relationName];
                    delete dataObj[relationName];
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
var saveDataRelations = function(app, dataInstance, relations, modelRelationSchema, modelName, include, callback){
    var promises = [];
    //Now run a loop of the model schema..
    for(var relationsType in relations){
        if(relations.hasOwnProperty(relationsType)){
            var relationData = relations[relationsType];
            //Now check if the modelData is empty or not.
            if(!_.isEmpty(relationData)){
                //Now save/update the current relation type.
                saveOrUpdate(app, dataInstance, relationsType, relationData, modelRelationSchema, promises, callback);
            }
        }//if
    }//for loop..

    /**
     * Return promise after all the callback has finished.
     */
    Promise.all(promises).then(function(){
        var modelObj = app.models[modelName];
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
var saveOrUpdate = function(app, dataInstance, relationsType, relationDataObj, modelRelationSchema, promises, callback){
    for(var relationName in relationDataObj ){
        if(relationDataObj.hasOwnProperty(relationName)){
            var relationData = relationDataObj[relationName];
            var relatedModelName = modelRelationSchema[relationName].model;
            //Now just upsert the relation..
            var modelObj = app.models[relatedModelName];

            //get the foriegnKey.
            var foriegnKey = modelRelationSchema[relationName].foriegnKey;
            //TODO FOREIGN KEY MAY BE DIFFERENT..
            if(!foriegnKey){
                foriegnKey = relationName + 'Id';
            }

            if(relationsType === 'belongsTo'){
                //Upsert belongs to relations and attach the relation to the
                promises.push(upsertBelongsTo (modelObj, relationData, dataInstance, relationName, foriegnKey, callback) );
            }//if
            else if(relationsType === 'hasOne'){
                //Upsert belongs to relations and attach the relation to the
                promises.push(upsertHasOne (modelObj, relationData, dataInstance, relationName, callback) );
            }//if
            else if (relationsType === 'hasMany') {
                console.log(relationData);
                promises.push( upsertTypeMany(modelObj, relationData, dataInstance, relationName, foriegnKey, 'hasMany', callback));
            }//else if
            else if('hasAndBelongToMany'){
                promises.push(upsertTypeMany(modelObj, relationData, dataInstance, relationName, foriegnKey, 'hasAndBelongToMany', callback) );
            }else{
                //Do nothing
                console.log('I am inside do nothing case. I dont know what to do.');
            }
        } //if
    }//for in loop.



};




var upsertHasOne = function(modelObj, relationData, dataInstance, relationName, callback){
    var mainModel = dataInstance[relationName].build(relationData);
    modelObj.upsert(mainModel)
    .then(function(result){
        //Now add the result to the dataInstance
        console.log("Successfully saved hasOne data");
    })
    .catch(function(err){
        console.log("Error saving data");
        callback(err);
    });
};


var upsertBelongsTo = function(modelObj, relationData, dataInstance, relationName, foriegnKey, callback){
    //TODO ADD TWO WAY COMMUNICATION FOR BELONGS TO METHOD HERE..
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
};





//Upsert for hasMany and hasAndBelongToMany common preprocess steps..
var upsertTypeMany = function(relatedModelClass, relationDataArr, dataInstance, relationName, foriegnKey, manyType, callback){
    try{
        //first get the old data and check if any old data is deleted from new data..
        dataInstance[relationName]({}, function(err, oldDataArr){
            var deletedDataId = [];
            oldDataArr.forEach(function(dataObj, index){
                var idFound = false;
                //Now loop over relationDataArr
                for(var i=0; i< relationDataArr.length; i++){
                    if(dataObj.id === relationDataArr[i].id){
                        idFound = true;
                    }
                }
                if(!idFound){
                    destroyHasManyRel(dataInstance, relationName, dataObj, callback);
                }
            });

            //add foriegnKey
            relationDataArr.forEach(function(relationData, index){
                if(manyType === 'hasMany'){
                    //relationData[foriegnKey] = dataInstance.id;
                    upsertHasManyFinal(relatedModelClass, relationData, dataInstance, relationName,  callback);
                }
                if(manyType === 'hasAndBelongToMany'){
                    upsertHasAndBelongToManyFinal(dataInstance, relationName, relationData, relatedModelClass, callback);
                }
            });
        });
    }
    catch(err){
        callback(err);
    }

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


var upsertHasAndBelongToManyFinal = function(dataInstance, relationName, relationData, relatedModelClass, callback){
    relatedModelClass.upsert(relationData, function(err, data){
        if (err) throw err;

        dataInstance[relationName].add(data)
        .then(function(){
            console.log("Link successfully added to hasAndBelongToMany relationship.");
        })
        .catch(function(err){
            callback(err);
        });

    });
};



//For destroying hasMany relation link ..
var destroyHasManyRel = function(dataInstance, relationName, dataObj, callback){
    //destroy that data..
    dataInstance[relationName].destroy(dataObj.id)
    .then(function(){
        console.log('unused hasMany link data destroyed');
    })
    .catch(function(){
          callback(err);
    });
};




//Return all the methods defined here..
module.exports =  {
    addSaveMethod: addSaveMethod
};
