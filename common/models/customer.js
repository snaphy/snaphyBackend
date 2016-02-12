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

    // Customer.beforeRemote("**", function(ctx, user, next){
    //     console.log(ctx);
    //     console.log("========================================================================");
    //     next();
    // });
    //
    //
    // Customer.afterRemote("**", function(ctx, user, next){
    //     console.log(ctx);
    //     console.log("========================================================================");
    //     next();
    // });
};
