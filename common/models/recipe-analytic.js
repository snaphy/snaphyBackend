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
};
