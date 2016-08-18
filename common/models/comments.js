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


    Comments.updateComment = function(data, callback){
    
    	if (data === undefined) {
            callback('Error: model data or model cannot be empty');
            return false;
        }
  
        var app = this.app;
        Comments.findById(data.id, {}, function(err, commentObj){
        	if(err){
        		return callback(err);
        	}else{
        	
        		commentObj.updateAttributes({
        			comment: data.comment,
        			rating: data.rating
        		}, function(err, successObj){
        			if(err){
        				return callback(err);
        			}else{
        				//Data saved..
        			}
        		});
        	}
        });
    };


    //Now registering the method `getSchema`
    Comments.remoteMethod(
        'updateComment', {
            accepts: [{
                arg: 'data',
                type: 'object'
            }],
           
            description: "Remote method for updating comments"
        }
    );
};
