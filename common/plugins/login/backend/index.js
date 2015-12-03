'use strict';
module.exports = function( server, databaseObj, helper, packageObj) {

    var adminUserModel = packageObj.adminUser,
    User = databaseObj.User,
    Role = server.models.Role,
    RoleMapping = server.models.RoleMapping,
    loopback = helper.getLoopbackObj(),

    //Create an init method to be executed when the plugin get run for the first time..in memory..
    init = function(){

        /**
         * Permission levels
         * ADMIN -> STATIC ROLE DECLARATION.
         * STAFF -> DYNAMIC ROLE DECLARATION.
         */
        //Now adding user to the method..
        User.create(adminUserModel, function(err, users){
            if(err) throw err;
            var i;
            console.log('\n\nCreated users:', users);

            //create the admin role
            Role.create({
                name: 'admin'
            }, function(err, role) {
                if (err) throw err;
                for(i=0; i< users.length; i++){
                    //Making this user an admin.
                    addUserAdmin(role, users[i].id);
                }//for loop..
            });

        });


        //TODO MODIFY THIS METHOD TO PROVIDE RUNTIME ACCESS AND MODIFICATION TO USER.
        addStaffResolver();
        hideRestMethods();

        User.isAdmin = function(cb){
            var currentContext = loopback.getCurrentContext();
            //bad documentation loopback..
            //http://stackoverflow.com/questions/28194961/is-it-possible-to-get-the-current-user-s-roles-accessible-in-a-remote-method-in
            //https://github.com/strongloop/loopback/issues/332
            var context;
            try{
                 context = {principalType: RoleMapping.USER, principalId: currentContext.active.accessToken.userId};
            }catch (err){
                console.error("Error >> User not logged in. ");
                context = {principalType: RoleMapping.USER, principalId: null};
            }

            //Now check the role if the context is admin.
            Role.isInRole('admin', context, function(err, InRole){
                if(err) throw err;
                var result = InRole;
                //Now return the boolean value..
                cb(null, result);
            });
        };


        //Now defigning a method for checking if the user exist in the role.
        User.remoteMethod(
            'isAdmin',
            {
                returns: {arg: 'isAdmin', type: 'boolean'}
            }
        );

    }, //Init..






    //TODO ADD GUEST AND CUSTOMER ROLE RESOLVER AND PROVIDE IT FOR CUSTOMER.
    //Method for resolving staff role by user..
    addStaffResolver = function(){
        //Now registering an dynamic role for the user..
        //All user of the employee model  belong to the staff role.
        /**
         * Default User  ACLs.
         DENY EVERYONE *
         ALLOW admin create
         ALLOW OWNER deleteById
         ALLOW EVERYONE login
         ALLOW EVERYONE logout
         ALLOW staff findById
         ALLOW OWNER updateAttributes

         */
        Role.registerResolver('staff', function(role, context, cb) {
            function reject(err) {
                if(err) {
                    return cb(err);
                }
                cb(null, false);
            }
            if (context.modelName !== packageObj.databases.User) {
                // the target model is not project
                return reject();
            }
            var userId = context.accessToken.userId;
            if (!userId) {
                return reject(); // do not allow anonymous users
            }

            //TODO Add further checks to check if the given user is employee or not.

        });

    },



    /**
     * Method for adding static admin role to an user
     * @param adminRoleInstance
     * @param userInstanceId
     */
    addUserAdmin = function(adminRoleInstance, userInstanceId ){
        //make users an admin
        adminRoleInstance.principals.create({
            principalType: RoleMapping.USER,
            principalId: userInstanceId
        }, function(err, principal) {
            if (err) throw err;
            console.log('Created principal:', principal);
        });
    },





    //TODO MODIFY THIS METHOD TO CHANGE IT FROM THIS FUNCTION DYNAMICALLY
    hideRestMethods = function(){
        //Hiding all the rest endpoints except login/logout/create

        //User.disableRemoteMethod("create", true);
        //User.disableRemoteMethod("upsert", true);
        User.disableRemoteMethod("updateAll", true);
        User.disableRemoteMethod("updateAttributes", false);

        User.disableRemoteMethod("find", true);
        //User.disableRemoteMethod("findById", true);
        //User.disableRemoteMethod("findOne", true);

        User.disableRemoteMethod("deleteById", true);

        //User.disableRemoteMethod("confirm", true);
        User.disableRemoteMethod("count", true);
        //User.disableRemoteMethod("exists", true);
        //User.disableRemoteMethod("resetPassword", true);

        User.disableRemoteMethod('__count__accessTokens', false);
        User.disableRemoteMethod('__create__accessTokens', false);
        User.disableRemoteMethod('__delete__accessTokens', false);
        User.disableRemoteMethod('__destroyById__accessTokens', false);
        User.disableRemoteMethod('__findById__accessTokens', false);
        User.disableRemoteMethod('__get__accessTokens', false);
        User.disableRemoteMethod('__updateById__accessTokens', false);
    };


    //Now return the methods that you want other plugins to use
    return  {
        init: init,
        hideRestMethods: hideRestMethods,
        addUserAdmin: addUserAdmin
    };



};
