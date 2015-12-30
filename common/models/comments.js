module.exports = function(Comments) {
    Comments.observe('before save', function(ctx, next){
        if(ctx.isNewInstance){
          ctx.instance.date = new Date();
          next();
        }
        else{
          next();
        }
    });
};
