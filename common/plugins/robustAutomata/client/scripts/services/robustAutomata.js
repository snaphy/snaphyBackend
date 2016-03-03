'use strict';

angular.module($snaphy.getModuleName())
    //Define your services here..
    //
    //
    .factory('Resource', ['$q', '$filter', '$timeout', 'Database', function($q, $filter, $timeout, Database) {

        //---------------------------------------------STORE GLOBAL VARIABLE-------------------------------------------------------
        var schema = {};

        //-------------------------------------------------------------------------------------------------------------------------

        //Copying one object to another..
        var extend = function(original, context, key) {
            for (key in context) {
                if (context.hasOwnProperty(key)) {
                    if (Object.prototype.toString.call(context[key]) === '[object Object]') {
                        original[key] = extend(original[key] || {}, context[key]);
                    } else {
                        original[key] = context[key];
                    }
                }
            }
            return original;
        };

        /**
         * Get absolute schema with two callback success and error also populate schema global variable..
         * @param  {[type]} databaseName [description]
         * @param  {[type]} success      [description]
         * @param  {[type]} error        [description]
         * @return {[type]}              [description]
         */
        var getSchema = function(databaseName, success, error) {
            var dbService = Database.loadDb(databaseName);
            //if ($.isEmptyObject(schema)) {
                dbService.getAbsoluteSchema({}, {}, function(values) {
                    schema = {};
                    extend(schema, values.schema);
                    if (success) {
                        success(schema);
                    }
                }, function(httpResp) {
                    if (error) {
                        error(httpResp);
                    }
                });
            //} else {
            //    success(schema);
            //}
        };




        var fetchHasManyThrough = function(element, hasManyThrough) {
            if (hasManyThrough) {
                hasManyThrough.forEach(function(relationObj) {
                    //Fetch the data from the server..
                    var throughModelName = relationObj.through;
                    var throughModelService = Database.loadDb(throughModelName);
                    var filter = {};

                    filter.include = filter.include || [];
                    filter.include.push(relationObj.throughModelRelation);
                    filter.where = {};
                    filter.where[relationObj.whereId] = element.id;

                    //Now fetch..
                    throughModelService.find({
                        filter: filter
                    }, function(relatedDataValue) {
                        console.log("Related hasManyThrough data fetched successfully.");
                        element[relationObj.relationName] = relatedDataValue;
                    }, function() {
                        console.error("error fetching hasManyThrough data");
                    });
                });
            }
        };



        var getFilterObj = function(dataSchema, dbService, filterObj) {
            //var filterObj = {};
            /*
                Multiple include syntax..
                visit for more info.. https://github.com/strongloop/loopback/issues/735
                [
                  {
                    relation: 'owner', // include the owner object
                    scope: { // further filter the owner object
                      fields: ['username', 'email'], // only show two fields
                      include: { // include orders for the owner
                        relation: 'orders',
                        where: {orderId: 5} // only select order with id 5
                      }
                    }
                  },
                  {
                    relation: 'thanks', // include the thank object
                    scope: { // further filter the owner object
                      fields: ['username']
                    }
                  }
                ]

             */
            //Clear the include filter first..
            filterObj.include = [];
            if (dataSchema.relations.belongsTo) {
                if (dataSchema.relations.belongsTo.length) {
                    dataSchema.relations.belongsTo.forEach(function(relationName) {
                        var includeObj = {
                            "relation": relationName
                        };
                        filterObj.include.push(includeObj);
                    });
                }
            }

            if (dataSchema.relations.hasAndBelongsToMany) {
                if (dataSchema.relations.hasAndBelongsToMany.length) {
                    dataSchema.relations.hasAndBelongsToMany.forEach(function(relationName) {
                        var includeObj = {
                            "relation": relationName
                        };
                        filterObj.include.push(includeObj);
                    });
                }
            }

            if (dataSchema.relations.hasMany) {
                if (dataSchema.relations.hasMany.length) {
                    dataSchema.relations.hasMany.forEach(function(relationName) {
                        var includeObj = {
                            "relation": relationName
                        };
                        filterObj.include.push(includeObj);
                    });
                }
            }


            if (dataSchema.relations.hasOne) {
                if (dataSchema.relations.hasOne.length) {
                    dataSchema.relations.hasOne.forEach(function(relationName) {
                        var includeObj = {
                            "relation": relationName
                        };
                        filterObj.include.push(includeObj);
                    });
                }
            }
            return filterObj;
        };



        //{where: {or: [{title: 'My Post'}, {content: 'Hello'}]}}
        var getPage = function(start, number, params, database, schema,  whereFilter) {
            console.log("Printing whereFilter ", whereFilter);
            var dbService = Database.loadDb(database);
            var object = {};
            var filter = {};
            var where = {};
            if(whereFilter){
                //Now just add new where properties..
                for(var key in whereFilter){
                    if(whereFilter.hasOwnProperty(key)){
                        where[key] = whereFilter[key];
                    }
                }
            }

            //where.or = []
            //Prepare filter..
            var skip = start;
            var limit = number;
            var orderBy = [];
            var deferred = $q.defer();
            //track which related model has where filter ..
            var relatedModelWhereFilter = [];

            //Add the necessary include in the filter..
            getFilterObj(schema, dbService, filter);

            //Now  prepare the sort and filter and orderBy function..
            if (params.sort) {
                if (params.sort.predicate) {
                    var sort = params.sort.predicate;
                    var reverse = params.sort.reverse;
                    reverse = reverse ? "DESC" : "ASC";
                    orderBy.push("" + sort + " " + reverse);
                }
            }

            filter.order = orderBy;
            if (params.search) {

                if (params.search.predicateObject) {
                    for (var property in params.search.predicateObject) {
                        if (params.search.predicateObject.hasOwnProperty(property)) {
                            if (typeof params.search.predicateObject[property] != 'object') {
                                var like = params.search.predicateObject[property];
                                //add to where property..
                                //where: {title: {like: 'M.+st'}}}
                                where[property] = {
                                    "like": like
                                };
                                //where.or.push({property: {"like" : like} });
                            }else{
                                //add to realted data..
                                //{ customer: {email: "robins"} }
                                if(filter.include === undefined){
                                    filter.include = [];
                                }
                                if(filter.include.length){
                                    for(var i=0; i<filter.include.length; i++){
                                        var includeProp = filter.include[i];
                                        if(includeProp.relation === property){
                                            //Add relation name for tracking..
                                            relatedModelWhereFilter.push(property);
                                            //Now insert the where...
                                            var relationObj = params.search.predicateObject[property];
                                            //var like = params.search.predicateObject[property];
                                            for(var prop in relationObj){
                                                if(relationObj.hasOwnProperty(prop)){
                                                    var likeValue = relationObj[prop];

                                                    includeProp.scope = includeProp.scope || {};
                                                    includeProp.scope.where = includeProp.scope.where || {};
                                                    // includeProp.scope.where[prop] = {
                                                    //     "like": likeValue
                                                    // };
                                                    includeProp.scope.where[prop] = {
                                                        "like": likeValue
                                                    };
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }


                            }

                        }
                    }
                }
            }

            filter.skip = skip;
            filter.limit = limit;
            filter.where = where;
            object.filter = filter;

            console.log(object);


            //predicateObject

            dbService.find(object, function(values, respHeader) {
                dbService.count(filter, function(count, respHeader) {
                     console.log(count);
                    // //Value retrived..
                    // console.log(values);
                    //prepare another collection for the given element..
                    var dataValues = [];
                    //fetch hasManyThrough for the data..
                    values.forEach(function(element) {
                        if (schema.relations) {
                            if (!$.isEmptyObject(schema.relations.hasManyThrough)) {
                                //TODO CHECK AND VERIFY IF hasManyThrough relation is actually working or not..
                                //Now fetch the data of hasManyThrough from server..
                                fetchHasManyThrough(element, schema.relations.hasManyThrough);
                            }
                        }

                        if(relatedModelWhereFilter.length){
                            var found = true;
                            relatedModelWhereFilter.forEach(function(relationName){
                                if(element[relationName] === undefined){
                                    found = false;
                                }
                            }); //END loop

                            //TODO COUNT IN CASE OF RELATED MODE DATA FILTER NOT IMPLEMENTED..

                            //Only add element if data is found..
                            if(found){
                                dataValues.push(element);
                            }
                        }else{
                            //setting the value of the data successfully fetched..
                            dataValues.push(element);
                        }

                    });

                    //Now resolve the promise..
                    deferred.resolve({
                        data: dataValues,
                        numberOfPages: Math.ceil(count.count / number),
                        count: count.count
                    });
                }, function(httpResponse) {
                    deferred.reject( httpResponse );
                    //Error counting values
                    console.error(httpResponse);
                });

            }, function(httpResponse) {
                deferred.reject( httpResponse );
                //Error occured..in fetching data..
                console.error(httpResponse);
            });




            return deferred.promise;
        }

        return {
            getPage: getPage,
            getSchema: getSchema
        };

    }]);
