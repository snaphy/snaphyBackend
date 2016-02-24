module.exports = function(RecipeIngredients) {
    RecipeIngredients.beforeRemote("**", function(ctx, user, next){

        if(ctx.args.filter){
            if(ctx.args.filter.where){
                if(ctx.args.filter.where.id){
                    if(ctx.args.filter.where.id.inq){
                        var idValue = ctx.args.filter.where.id.inq;
                        try{
                            ctx.args.filter.where.id.inq = JSON.parse(ctx.args.filter.where.id.inq);
                        }catch(err){
                            console.error(err);
                            ctx.args.filter.where.id.inq = idValue;
                        }
                    }
                }
            }
        }
        next();
    });
};
