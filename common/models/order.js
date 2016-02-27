module.exports = function(Order) {
    Order.observe('before save', function(ctx, next) {
        var app = ctx.Model.app;
        //Apply this hooks for save operation only..
        if (ctx.isNewInstance) {
            var mongoDb = app.dataSources.mongodb;
            var mongoConnector = app.dataSources.mongodb.connector;
            mongoConnector.collection('counters').findAndModify({
                collection: 'Order'
            }, [
                ['_id', 'asc']
            ], {
                $inc: {
                    value: 1
                }
            }, {
                new: true
            }, function(err, sequence) {
                if (err) {
                    console.error(err);
                    next(err);
                } else {
                    // Do what I need to do with new incremented value sequence.value
                    ctx.instance.id = sequence.value.value;
                } //else
                next();
            });
        } //ctx.isNewInstance or retailer added from backend..
        else {
            next();
        }

    }); //Observe before save..

};
