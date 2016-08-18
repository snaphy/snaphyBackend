module.exports = function(Customer) {
    Customer.observe('before save', function(ctx, next){
        if(ctx.isNewInstance){
          ctx.instance.date = new Date();
          next();
        }
        else{
          next();
        }
    });



    Customer.beforeRemote("prototype.__get__recipes", function(ctx, user, next) {
        if (ctx.args) {
            if (ctx.args.filter) {
                if (ctx.args.filter.include) {
                    try{
                        if (typeof ctx.args.filter.include === "string") {
                            //console.log(ctx.args.filter.include);
                            ctx.args.filter.include = JSON.parse(ctx.args.filter.include);

                        }
                    }catch(err){
                        console.error(err);
                    }
                }
            }
        }
        next();
    });




};
