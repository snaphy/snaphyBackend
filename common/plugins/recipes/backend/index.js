'use strict';
module.exports = function(server, databaseObj, helper, packageObj) {
    var recipeAnalytics = require('./addRecipeAnalytics');
    //var addSecurity  = require('./addSecurity');
    //var async = require('async');
    //var _ = require("lodash");
    var orderManagement = require("./orderManagement");
    /**
     * Here server is the main app object
     * databaseObj is the mapped database from the package.json file
     * helper object contains all the helpers methods.
     * packegeObj contains the packageObj file of your plugin.
     */

    /**
     * Initialize the plugin at time of server start.
     * init method should never have any argument
     * It is a constructor and is populated once the server starts.
     * @return {[type]} [description]
     */
    var init = function() {
        //Initialize the analytics..
        recipeAnalytics.init(server, databaseObj, helper, packageObj);
        orderManagement.init(server, databaseObj, helper, packageObj);
        addRecipeFilter();
    };



    var addRecipeFilter = function(){
        var Recipe = databaseObj.Recipe;
        var Category = databaseObj.Category;

        Recipe.findCategoryRecipes = function(categoryId, myfilter, callback){
            //console.log(myfilter.where.cuisines_);
            //first fetch the category..
            Category.findById(categoryId, {})
                .then(function(categoryInstance){

                    if(categoryInstance){
                        if(myfilter.where === undefined){
                            myfilter.where  = {};
                        }

                        //Add category ref in my filter..
                        myfilter.where["category_"] = categoryInstance.id.toString();
                        if(myfilter.where){
                            if(myfilter.where["cuisines_"]){
                                if(myfilter.where["cuisines_"].inq){
                                    if(myfilter.where["cuisines_"].inq.length){
                                        var cuisinesIds = myfilter.where["cuisines_"].inq;
                                        var cuisinesIdList = [];
                                        cuisinesIds.forEach(function(cuisinesId){
                                            cuisinesIdList.push(cuisinesId.toString());
                                        });
                                        myfilter.where["cuisines_"].inq = cuisinesIdList;
                                    }
                                }
                            }
                        }

                        //console.log(myfilter.where.cuisines_);

                        Recipe.find(myfilter)
                            .then(function(recipes){
                                //console.log(myfilter);
                                //console.log(recipes);
                                callback(null, recipes);
                            })
                            .catch(function(err){
                                console.error(err);
                                callback(err);
                            });
                    }else{
                        callback(new Error("No category found"));
                        console.error("Category not found");
                    }
                })
                .catch(function(err){

                    console.error(err);
                    callback(err);
                });
        };


        Recipe.remoteMethod(
            'findCategoryRecipes', {
                accepts:[ {
                    arg: 'categoryId',
                    type: 'string',

                },
                {
                    arg: 'filter',
                    type: 'object',

                }],
                returns: {
                    arg: 'data',
                    type: ['Recipe'],
                    root: true
                },
                description: "Find recipes by category wise.."
            }
        );
    };





    //init();

    //return all the methods that you wish to provide user to extend this plugin.
    return {
        init: init
    };
}; //module.exports
