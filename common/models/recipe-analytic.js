module.exports = function(RecipeAnalytic) {
    RecipeAnalytic.observe('before save', function(ctx, next) {
        if (ctx.isNewInstance) {
            ctx.instance.added = new Date();
            ctx.instance.lastModified = new Date();
            next();
        } else {
            if(ctx.instance){
                ctx.instance.lastModified = new Date();
            }
            next();
        }
    });


    RecipeAnalytic.beforeRemote("**", function(ctx, user, next){
        if(ctx.args){
            if(ctx.args.filter){
                if(ctx.args.filter.order){
                    try{
                        ctx.args.filter.order = JSON.parse(ctx.args.filter.order);

                    }catch(error){
                        //Do nothing..
                        console.log(error);
                    }
                }
                /*if(ctx.args.filter.include){
                    //include recipe with only publish recipe..
                    ctx.args.filter.include = {
                        relation: "recipes",
                        scope: {
                            where:{
                                status:"publish"
                            }
                        }
                    };
                    console.log(ctx.args.filter.include);
                }*/

            }
        }
        next();
    });



};
