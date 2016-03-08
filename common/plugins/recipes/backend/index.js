'use strict';
module.exports = function(server, databaseObj, helper, packageObj) {
    var recipeAnalytics = require('./addRecipeAnalytics');
    //var addSecurity  = require('./addSecurity');
    //var async = require('async');
    var _ = require("lodash");
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

        Recipe.findCategoryRecipes = function(categoryId, recipeFilter, cuisinesId, callback){
            //console.log(myfilter.where.cuisines_);
            //first fetch the category..

            console.log(categoryId, recipeFilter, cuisinesId);

            Category.findById(categoryId, {})
                .then(function(categoryInstance){
                    categoryInstance.recipes({
                        include: "cuisines"
                    })
                        .then(function(recipesList){
                            if(recipesList){
                                if(recipesList.length){
                                    if(cuisinesId) {
                                        if(cuisinesId.length){
                                            var filterValue = _.filter(recipesList, function (recipe) {
                                                var JSONRecipe = recipe.toJSON();

                                                if (JSONRecipe.cuisines){
                                                    var JSONCuisines = JSONRecipe.cuisines.toJSON();
                                                    console.log("i ammm");
                                                    if (JSONCuisines.length) {
                                                        var found = false;

                                                        for (var i = 0; i < JSONRecipe.cuisines.length; i++) {
                                                            var cuisineObj = JSONRecipe.cuisines[i];
                                                            console.log("i am hereee", recipe.cuisines);
                                                            if(cuisineObj){
                                                                for (var j = 0; j < cuisinesId.length; j++) {
                                                                    var targetId = cuisinesId[j];
                                                                    //console.log(targetId, cuisineObj.id);
                                                                    if (targetId.toString() === cuisineObj.id.toString()) {
                                                                        found = true;
                                                                        break;
                                                                    }
                                                                }
                                                            }

                                                            if (found) {
                                                                break;
                                                            }
                                                        }
                                                        return found;
                                                    } else {
                                                        return false;
                                                    }

                                                } else {
                                                    return false;
                                                }
                                            });

                                            console.log("Now returnning\n");
                                            callback(null, filterValue);
                                        }else{
                                            return callback(null, recipesList);
                                        }
                                    }else{
                                        return callback(null, recipesList);
                                    }
                                }else{
                                    callback(null, []);
                                }
                            }else{
                                callback(null, []);
                            }
                        })
                        .catch(function(err){
                            console.error(err);
                        });
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
                    type: 'string'

                },
                {
                    arg: 'recipeFilter',
                    type: 'object'

                },
                {
                    arg: 'cuisinesId',
                    type: 'array'

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
