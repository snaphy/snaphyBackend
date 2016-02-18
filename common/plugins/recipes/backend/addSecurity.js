'use strict';
var init = function(server, databaseObj, helper, packageObj) {
    //Load login plugin..
    var login = helper.loadPlugin('login');
    //Now load plugin role checking method..
    var verifyRole = login.verifyRole;

};


//add recipe
/*
onLoad{
 addWhere:{
    "status":"onhold"
 },
 propertyEdit:{
  "status": ["admin"]
 }

}
 */
var addModelSecurity = function(server, databaseObj, helper, packageObj, verifyRole){
    var app = server;

}




module.exports = {
    init:init
}
