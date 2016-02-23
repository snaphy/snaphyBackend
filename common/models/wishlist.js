module.exports = function(Wishlist) {
    // Wishlist.beforeRemote("**", function(ctx, user, next){
    //     console.log("===============================BEFORE=========================================");
    //     console.log(ctx);
    //     //console.log(user);
    //     console.log("===============================BEFORE END====================================");
    //     next();
    // });

    Wishlist.afterRemote("**", function(ctx, user, next){
        console.log("===============================AFTER====================================");
        console.log(ctx);
        console.log("===============================AFTER END====================================");
        next();
    });

    Wishlist.observe('before save', function(ctx, next){
        console.log("========================before save=====================================");
        console.log(ctx);
        console.log("========================before save end=====================================");
        next();
    });
};
