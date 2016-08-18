module.exports = function(Recipe) {
    Recipe.observe('before save', function(ctx, next) {
        //console.log("Recipe is getting saved: " + ctx.instance);
        if (ctx.isNewInstance){
            //Add default status value..
            if (ctx.instance) {
                //console.log(" i am here inside");
                ctx.instance.added = new Date();
                if (ctx.instance.status === undefined || ctx.instance.status === null) {
                    ctx.instance.status = "onhold";
                }
            }
            next();
        } else {

            next();
        }
    });


    Recipe.beforeRemote("find", function(ctx, user, next) {
        if (ctx.args) {
            if (ctx.args.filter) {
                if (ctx.args.filter.where) {
                    try{
                        if (typeof ctx.args.filter.where === "string") {
                            ctx.args.filter.where = JSON.parse(ctx.args.filter.where);
                        }
                    }catch(err){
                        console.log(err);
                    }

                }
            }
        }
        next();
    });

    Recipe.beforeRemote("**", function(ctx, user, next) {
        console.log(ctx.req);
        console.log("\n\n\t\t\tUser data", user);
        next();
    });





};
