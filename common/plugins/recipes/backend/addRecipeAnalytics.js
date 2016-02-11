'use strict';
var init = function(server, databaseObj, helper, packageObj) {
    //When a recipe is created add a analytics with recipe..
    databaseObj.Recipe.observe('after save', function(ctx, next) {
        if (ctx.isNewInstance) {
            var RecipeAnalytic = databaseObj.RecipeAnalytic;
            if (ctx.instance) {
                //Create a RecipeAnalytics..
                ctx.instance.recipeAnalytics.create({
                    totalViews: 0,
                    averageRating: 0,
                    totalComment: 0
                }, function(err, analyticsObj) {
                    if (err) {
                        console.error(err);
                        return false;
                    }
                    //Analytics successfully added to recipe..
                });
            }
            next();
        } else {
            next();
        }
    });


    //When a RecipeIngredients is fetched increase the views. in recipe.
    databaseObj.RecipeIngredients.observe('loaded', function(ctx, next) {
        if (ctx.data === undefined) {
            console.error("Error recipe data is not present");
            return next();
        }
        var RecipeId = ctx.data.recipeId;
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
                recipeAnalyticObj.totalViews = parseInt(recipeAnalyticObj.totalViews) + 1;
                //Now save the ingredients..
                recipeAnalyticObj.save({}, function(err, object) {
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
    databaseObj.Comments.observe('after save', function(ctx, next) {
        if (ctx.isNewInstance) {
            if(ctx.instance){
                //Now increment comment and ratings value..
                databaseObj.RecipeAnalytic.find({
                    where:{
                        recipeId: ctx.instance.recipeId
                    }
                }, function(err, recipeAnalyticObj){
                    if(err){
                        console.error("Error finding recipeIngredients data from database..");
                        next();
                        return false;
                    }

                    //Now calculate the average ratings..
                    var totalRating = (parseInt(recipeAnalyticObj.totalComment) * parseInt(recipeAnalyticObj.averageRating) )
                    //now increment comment..
                    recipeAnalyticObj.totalComment  =  parseInt(recipeAnalyticObj.totalComment) + 1;
                    //Now add this comment rating..
                    if(ctx.instance.rating !== undefined){
                        totalRating = totalRating + parseInt(ctx.instance.rating);
                        //Now calculate average. rating..
                        var avgRating = totalRating / recipeAnalyticObj.totalComment;
                        recipeAnalyticObj.averageRating = avgRating;
                    }//if

                    //Now save the data..
                    recipeAnalyticObj.save({}, function(err, obj){
                        if(err){
                            console.error("Error in Recipe analytics total comment and rating incrementing..");

                        }else{
                            //done incrementing value..
                            //
                        }
                    });

                    //Now call the next middleware..
                    next();
                });// find RecipeAnalytic

            }else{
                next();
            }
        }else{
            next();
        }
    });


}



module.exports = {
    init: init
}
