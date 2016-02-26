module.exports = function(Category) {
    Category.validatesUniquenessOf('name');


    Category.beforeRemote("prototype.__get__recipes", function(ctx, user, next) {
        if(ctx){
            console.log(ctx.args);
            if(ctx.args){
                if(ctx.args.filter){
                    if(ctx.args.filter.where){
                        //console.log(ctx);
                        console.log(ctx.args.filter.where);
                    }
                }
            }
        }
        next();
    });
};
