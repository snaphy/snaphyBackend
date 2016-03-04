module.exports = function(Category) {
    Category.validatesUniquenessOf('name');
 /*   Category.beforeRemote("prototype.__get__recipes", function(ctx, user, next) {
        if(ctx){
            console.log(ctx);
            /!*if(ctx.args){
                if(ctx.args.filter){
                    if(ctx.args.filter.where){
                        if(ctx.args.filter.where.or){
                            if(typeof ctx.args.filter.where.or === "string"){
                                try{
                                    console.log("===================BEFORE========================");
                                    console.log(ctx.args.filter.where.or);
                                    ctx.args.filter.where.or = JSON.parse(ctx.args.filter.where.or);
                                    console.log("===================AFTER========================");
                                    console.log(ctx.args.filter.where.or);
                                }catch (err){
                                    //Do nothing..
                                    console.error(err);
                                }
                            }
                        }

                        try{
                            if (ctx.args.filter.where.recipeType) {
                                if(ctx.args.filter.where.recipeType.inq){
                                    if(typeof ctx.args.filter.where.recipeType.inq === "string"){
                                        try{
                                            console.log("===================BEFORE========================");
                                            console.log(ctx.args.filter.where);
                                            ctx.args.filter.where.recipeType.inq = JSON.parse(ctx.args.filter.where.recipeType.inq);
                                            console.log("===================AFTER========================");
                                            console.log(ctx.args.filter.where);
                                        }catch (err){
                                            //Do nothing..
                                        }
                                    }
                                }


                            }
                        }catch(err){

                        }

                    }
                }
            }*!/
        }
        next();
    });*/
};
