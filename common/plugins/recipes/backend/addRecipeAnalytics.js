'use strict';
var init = function(server, databaseObj, helper, packageObj) {
    //When a recipe is created add a analytics with recipe..
    databaseObj.Recipe.observe('after save', function(ctx, next) {
        if (ctx.isNewInstance) {
            var RecipeAnalytic = databaseObj.RecipeAnalytic;
            var data = {
                totalViews: 0,
                averageRating: 0,
                totalComment: 0
            };
            if (ctx.instance) {
                //Create a RecipeAnalytics..
                ctx.instance.recipeAnalytics.create(data, function(err, analyticsObj) {
                    if (err) {
                        console.error(err);
                        return false;
                    }
                    //Analytics successfully added to recipe..
                    //Add analytic for two way communication..
                    //ctx.instance.recipeAnalyticId = analyticsObj.id;
                    //Resave it..
                    ctx.instance.updateAttribute('recipeAnalyticId', analyticsObj.id, function(err, val){
                        if(err){
                            console.error("Data cannot be saved..");
                            return false;
                        }
                    });
                });
            }
            next();
        } else {
            next();
        }
    });


    //When a RecipeIngredients is fetched increase the views. in recipe.
    databaseObj.RecipeIngredients.observe('loaded', function(ctx, next) {
        if (ctx.instance === undefined) {
            //console.error("Error recipe data is not present");
            return next();
        }

        var RecipeId = ctx.instance.recipeId;
        //Now increase a recipe views..
        databaseObj.RecipeAnalytic.find({
            where: {
                recipeId: RecipeId
            }
        }, function(err, recipeAnalyticObj) {
            if (err) {
                console.log("Error fetching recipe analytic data.");
                console.error(err);
                next();
            } else {
                if(recipeAnalyticObj.length){
                    recipeAnalyticObj = recipeAnalyticObj[0];
                }else{
                    console.error("No recipe analytics data model present");
                    return next();
                }
                recipeAnalyticObj.totalViews = parseInt(recipeAnalyticObj.totalViews) + 1;
                //Now save the ingredients..
                recipeAnalyticObj.updateAttribute('totalViews', recipeAnalyticObj.totalViews,  function(err, object) {
                    if (err) {
                        console.log("Error fetching recipe ingredients data.");
                        console.error(err);

                    }
                    //Successfully increased views..

                });
                next();
            }
        });
    }); //loaded


    //When a comment is created increment ratings and comment value..of analytics..
    databaseObj.Comments.observe('before save', function(ctx, next) {
        var instance = ctx.instance || ctx.data;
        if(instance){
            if(instance.recipeId){
                //Now increment comment and ratings value..
                databaseObj.RecipeAnalytic.find({
                    where:{
                        recipeId: instance.recipeId
                    }
                }, function(err, recipeAnalyticObj){

                    if(err){
                        console.error("Error finding recipeIngredients data from database..");
                        next();
                        return false;
                    }

                    if(recipeAnalyticObj.length){
                        recipeAnalyticObj = recipeAnalyticObj[0];
                    }else{
                        console.error("No recipe analytics data model present");
                        return next();
                    }
                    var averageRating;
                    var totalComment;
                    if(ctx.isNewInstance){
                        //Now calculate the average ratings..
                        var totalRating = (parseInt(recipeAnalyticObj.totalComment) * parseInt(recipeAnalyticObj.averageRating));
                        databaseObj.Comments.count({recipeId: instance.recipeId, status: "publish"})
                            .then(function(number){
                                //now increment comment..
                                totalComment  =  number + 1;
                                //Now add this comment rating..
                                if(instance.rating !== undefined){
                                    totalRating = totalRating + parseInt(instance.rating);
                                    //Now calculate average. rating..
                                    averageRating = totalRating / totalComment;
                                }//if
                                //updateAttributes({name: 'value'}, cb)
                                //Now save the data..
                                recipeAnalyticObj.updateAttributes({averageRating: averageRating, totalComment: totalComment}, function(err, obj){
                                    if(err){
                                        console.error("Error in Recipe analytics total comment and rating incrementing..");

                                    }else{
                                        //done incrementing value..
                                        console.log("Avg ratings updated for new .");
                                    }
                                });

                            })
                            .catch(function(err){
                                console.error(err);
                            });


                    }else{
                        //First find the previous value..
                        databaseObj.Comments.findById(instance.id, {})
                            .then(function(value){
                                if(value){
                                    if(value.status === "publish"){
                                        if(instance.rating !== undefined){
                                            //Count the total comments..
                                            databaseObj.Comments.count({recipeId: instance.recipeId, status: "publish"})
                                                .then(function(number){
                                                    var totalRating = parseInt(number) * parseInt(recipeAnalyticObj.averageRating);
                                                    //now increment comment..
                                                    totalComment  =  parseInt(number);
                                                    //remove its previous rating..
                                                    totalRating = totalRating - value.rating;
                                                    //Now add current rating..
                                                    totalRating = totalRating + parseInt(instance.rating);
                                                    //Now calculate average. rating..
                                                    averageRating = totalRating / totalComment;
                                                    //updateAttributes({name: 'value'}, cb)
                                                    //Now save the data..
                                                    recipeAnalyticObj.updateAttributes({averageRating: averageRating, totalComment: totalComment}, function(err, obj){
                                                        if(err){
                                                            console.error("Error in Recipe analytics total comment and rating incrementing..");

                                                        }else{
                                                            //done incrementing value..
                                                            console.log("Avg ratings updated.");
                                                        }
                                                    });
                                                })
                                                .catch(function(err){
                                                   console.error(err);
                                                });


                                        }//if
                                    }
                                }
                            })
                            .catch(function(err){
                                console.error(err);
                            });
                    }

                });// find RecipeAnalytic
            }

            //Now call the next middleware..
            next();
        }else{
            next();
        }
    });


}



module.exports = {
    init: init
};