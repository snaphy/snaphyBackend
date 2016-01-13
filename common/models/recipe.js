module.exports = function(Recipe) {
    Recipe.observe('before save', function(ctx, next){
        if(ctx.isNewInstance){
          ctx.instance.added = new Date();
          next();
        }
        else{
          next();
        }
    });
};
