module.exports = function(Recipe) {
    Recipe.observe('before save', function(ctx, next) {
        if (ctx.isNewInstance) {
            //Add default status value..
            //console.log(" i am here too");
            if (ctx.instance) {
                //console.log(" i am here inside");
                ctx.instance.added = new Date();
                if (ctx.instance.status === undefined || ctx.instance.status === null) {
                    ctx.instance.status = "onhold";
                }
            }

            //console.log(ctx.instance);
            next();
        } else {
            //console.log(ctx.instance);
            next();
        }
    /*    console.log(ctx.instance);
        console.log("=======================BEFORE SAVE===============================");*/

    });

    Recipe.observe('after save', function(ctx, next) {
        /*console.log(ctx.instance);
        console.log("=========================AFTER SAVE=======================================");
        next();*/
    });



    // Recipe.beforeRemote("*", function(ctx, user, next) {
    //     console.log(ctx);
    //     console.log("========================BEFORE UPLOAD=============================\n");
    //     next();
    // });
    //
    //
    // Recipe.afterRemote("*", function(ctx, user, next) {
    //     console.log(ctx);
    //     console.log("========================AFTER UPLOAD=============================\n");
    //     next();
    // });




    Recipe.beforeRemote("find", function(ctx, user, next) {
        if (ctx.args) {
            if (ctx.args.filter) {
                if (ctx.args.filter.where) {
                    if (typeof ctx.args.filter.where === "string") {
                        ctx.args.filter.where = JSON.parse(ctx.args.filter.where);
                    }
                }
            }
        }
        next();
    });
};
