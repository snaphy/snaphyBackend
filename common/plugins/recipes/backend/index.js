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
           // where: {"recipes_.5698e49c53196bcc07fd7db7": true}
            var filter;
            if(recipeFilter){
                filter = recipeFilter || {};
            }

            filter.where = filter.where || {};

            if(categoryId){
                filter.where["category_." + categoryId] = true;
            }

            //console.log(cuisinesId);

            if(cuisinesId){
                if(cuisinesId.length){
                    cuisinesId.forEach(function(id){
                        //console.log("I am here");
                        filter.where["cuisines_." + id] = true;
                    });
                }
            }

            //console.log(filter);

            Recipe.find(filter)
                .then(function(recipeList){
                    /*console.log("============================");
                    console.log(recipeList);*/
                    callback(null, recipeList);
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
