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
    	console.log("Updating comment");
        console.log(data);
    	if (data === undefined) {
            callback('Error: model data or model cannot be empty');
            return false;
        }
  
        var app = this.app;
        Comments.findById(data.id, {}, function(err, commentObj){
        	if(err){
        		return callback(err);
        	}else{
        		console.log("inside Updating comment");
        		console.log(commentObj);
        		commentObj.updateAttributes({
        			comment: commentObj.comment,
        			rating: commentObj.rating
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
