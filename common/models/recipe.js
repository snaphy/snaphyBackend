module.exports = function(Recipe) {
    Recipe.observe('before save', function(ctx, next) {
        if (ctx.isNewInstance) {
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
            //console.log(ctx.instance);
            next();
        }
    });


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
