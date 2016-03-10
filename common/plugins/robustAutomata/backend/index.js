'use strict';
module.exports = function( server, databaseObj, helper, packageObj) {
	/**
	 * Here server is the main app object
	 * databaseObj is the mapped database from the package.json file
	 * helper object contains all the helpers methods.
	 * packegeObj contains the packageObj file of your plugin.
	 */

	/**
	 * Initialize the plugin at time of server start.
	 * init method should never have any argument
	 * It is a constructor and is populated once the server starts.
	 * @return {[type]} [description]
	 */
	var init = function(){
		/*server.models.Cuisines.find({
            where: {"recipes_.5698e49c53196bcc07fd7db7": true}
        }, function(err, data){
			if(err){
				console.log(err);
			}else{
				console.log("================CHECKING DUMMY CUISINES CLAUSE==========5698e49c53196bcc07fd7db7=============");
				console.log(data);
			}
		});*/
	};



	//return all the methods that you wish to provide user to extend this plugin.
	return {
		init: init
	};
}; //module.exports
