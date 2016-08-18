(function(){
    'use strict';
})();

/*global, __dirname */
module.exports = function(server) {

	var User = server.models["User"];
	User.beforeRemote("**", function(ctx, user, next) {
        console.log("Login request.");
        console.log(ctx.body);
        next();
    });


}