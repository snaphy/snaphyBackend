module.exports = function(Recipe) {
    Recipe.observe('before save', function(ctx, next){
        if(ctx.isNewInstance){
            //console.log(ctx);
          ctx.instance.added = new Date();
          next();
        }
        else{
          next();
        }
    });




    Recipe.beforeRemote("find", function(ctx, user, next){
        if(ctx.args){
            if(ctx.args.filter){
                if(ctx.args.filter.where){
                    if(typeof ctx.args.filter.where === "string"){
                        ctx.args.filter.where = JSON.parse(ctx.args.filter.where);
                    }
                }
            }
        }
        next();
    });

};
