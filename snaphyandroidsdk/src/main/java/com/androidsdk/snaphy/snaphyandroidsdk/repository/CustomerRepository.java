package com.androidsdk.snaphy.snaphyandroidsdk.repository;



import com.google.common.collect.ImmutableMap;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.JsonUtil;
import com.strongloop.android.remoting.adapters.Adapter;
import com.strongloop.android.remoting.adapters.RestContract;
import com.strongloop.android.remoting.adapters.RestContractItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;



import com.strongloop.android.loopback.UserRepository;
import com.strongloop.android.loopback.AccessTokenRepository;
import com.strongloop.android.loopback.AccessToken;



import org.json.JSONArray;
import org.json.JSONObject;

//Import its models too.
import com.androidsdk.snaphy.snaphyandroidsdk.models.Customer;

//Now import model of related models..

    
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Recipe;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Comments;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CommentsRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Wishlist;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.WishlistRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Chef;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.ChefRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.ContactChef;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.ContactChefRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Order;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.OrderRepository;
            
        
    





public class CustomerRepository extends com.strongloop.android.loopback.UserRepository<Customer> {


    public CustomerRepository(){
        super("Customer", null, Customer.class);
    }





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/accessTokens/:fk", "GET"), "Customer.prototype.__findById__accessTokens");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/accessTokens/:fk", "DELETE"), "Customer.prototype.__destroyById__accessTokens");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/accessTokens/:fk", "PUT"), "Customer.prototype.__updateById__accessTokens");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/recipes/:fk", "GET"), "Customer.prototype.__findById__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/recipes/:fk", "DELETE"), "Customer.prototype.__destroyById__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/recipes/:fk", "PUT"), "Customer.prototype.__updateById__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/comments/:fk", "GET"), "Customer.prototype.__findById__comments");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/comments/:fk", "DELETE"), "Customer.prototype.__destroyById__comments");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/comments/:fk", "PUT"), "Customer.prototype.__updateById__comments");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/wishlists", "GET"), "Customer.prototype.__get__wishlists");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/wishlists", "POST"), "Customer.prototype.__create__wishlists");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/wishlists", "PUT"), "Customer.prototype.__update__wishlists");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/wishlists", "DELETE"), "Customer.prototype.__destroy__wishlists");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/chefs", "GET"), "Customer.prototype.__get__chefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/chefs", "POST"), "Customer.prototype.__create__chefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/chefs", "PUT"), "Customer.prototype.__update__chefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/chefs", "DELETE"), "Customer.prototype.__destroy__chefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/contactChefs/:fk", "GET"), "Customer.prototype.__findById__contactChefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/contactChefs/:fk", "DELETE"), "Customer.prototype.__destroyById__contactChefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/contactChefs/:fk", "PUT"), "Customer.prototype.__updateById__contactChefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/orders/:fk", "GET"), "Customer.prototype.__findById__orders");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/orders/:fk", "DELETE"), "Customer.prototype.__destroyById__orders");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/orders/:fk", "PUT"), "Customer.prototype.__updateById__orders");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/accessTokens", "GET"), "Customer.prototype.__get__accessTokens");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/accessTokens", "POST"), "Customer.prototype.__create__accessTokens");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/accessTokens", "DELETE"), "Customer.prototype.__delete__accessTokens");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/accessTokens/count", "GET"), "Customer.prototype.__count__accessTokens");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/recipes", "GET"), "Customer.prototype.__get__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/recipes", "POST"), "Customer.prototype.__create__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/recipes", "DELETE"), "Customer.prototype.__delete__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/recipes/count", "GET"), "Customer.prototype.__count__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/comments", "GET"), "Customer.prototype.__get__comments");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/comments", "POST"), "Customer.prototype.__create__comments");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/comments", "DELETE"), "Customer.prototype.__delete__comments");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/comments/count", "GET"), "Customer.prototype.__count__comments");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/contactChefs", "GET"), "Customer.prototype.__get__contactChefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/contactChefs", "POST"), "Customer.prototype.__create__contactChefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/contactChefs", "DELETE"), "Customer.prototype.__delete__contactChefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/contactChefs/count", "GET"), "Customer.prototype.__count__contactChefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/orders", "GET"), "Customer.prototype.__get__orders");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/orders", "POST"), "Customer.prototype.__create__orders");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/orders", "DELETE"), "Customer.prototype.__delete__orders");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId/orders/count", "GET"), "Customer.prototype.__count__orders");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "Customer.create");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "Customer.create");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "PUT"), "Customer.upsert");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/exists", "GET"), "Customer.exists");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "GET"), "Customer.findById");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "GET"), "Customer.find");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/findOne", "GET"), "Customer.findOne");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/update", "POST"), "Customer.updateAll");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "DELETE"), "Customer.deleteById");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/count", "GET"), "Customer.count");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:customerId", "PUT"), "Customer.prototype.updateAttributes");
                

            
        
            
        
            
        
            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/confirm", "GET"), "Customer.confirm");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/reset", "POST"), "Customer.resetPassword");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/getSchema", "POST"), "Customer.getSchema");
                

            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
        return contract;
    }



    




    
        
            //Method findById__accessTokens definition
            public void findById__accessTokens(  String customerId,  String fk, final ObjectCallback<AccessToken> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__accessTokens", ImmutableMap.of("customerId", customerId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    AccessTokenRepository accessTokenRepo = getRestAdapter().createRepository(AccessTokenRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    AccessToken accessToken = accessTokenRepo.createObject(result);
                                    callback.onSuccess(accessToken);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findById__accessTokens definition ends here..

            

        
    
        
            //Method destroyById__accessTokens definition
            public void destroyById__accessTokens(  String customerId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__accessTokens", ImmutableMap.of("customerId", customerId, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroyById__accessTokens definition ends here..

            

        
    
        
            //Method updateById__accessTokens definition
            public void updateById__accessTokens(  String customerId,  String fk,  HashMap<String, Object> data, final ObjectCallback<AccessToken> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__accessTokens", ImmutableMap.of("customerId", customerId, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    AccessTokenRepository accessTokenRepo = getRestAdapter().createRepository(AccessTokenRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    AccessToken accessToken = accessTokenRepo.createObject(result);
                                    callback.onSuccess(accessToken);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method updateById__accessTokens definition ends here..

            

        
    
        
            //Method findById__recipes definition
            public void findById__recipes(  String customerId,  String fk, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__recipes", ImmutableMap.of("customerId", customerId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    RecipeRepository recipeRepo = getRestAdapter().createRepository(RecipeRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Recipe recipe = recipeRepo.createObject(result);
                                    callback.onSuccess(recipe);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findById__recipes definition ends here..

            

        
    
        
            //Method destroyById__recipes definition
            public void destroyById__recipes(  String customerId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__recipes", ImmutableMap.of("customerId", customerId, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroyById__recipes definition ends here..

            

        
    
        
            //Method updateById__recipes definition
            public void updateById__recipes(  String customerId,  String fk,  HashMap<String, Object> data, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__recipes", ImmutableMap.of("customerId", customerId, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    RecipeRepository recipeRepo = getRestAdapter().createRepository(RecipeRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Recipe recipe = recipeRepo.createObject(result);
                                    callback.onSuccess(recipe);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method updateById__recipes definition ends here..

            

        
    
        
            //Method findById__comments definition
            public void findById__comments(  String customerId,  String fk, final ObjectCallback<Comments> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__comments", ImmutableMap.of("customerId", customerId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CommentsRepository commentsRepo = getRestAdapter().createRepository(CommentsRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Comments comments = commentsRepo.createObject(result);
                                    callback.onSuccess(comments);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findById__comments definition ends here..

            

        
    
        
            //Method destroyById__comments definition
            public void destroyById__comments(  String customerId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__comments", ImmutableMap.of("customerId", customerId, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroyById__comments definition ends here..

            

        
    
        
            //Method updateById__comments definition
            public void updateById__comments(  String customerId,  String fk,  HashMap<String, Object> data, final ObjectCallback<Comments> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__comments", ImmutableMap.of("customerId", customerId, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CommentsRepository commentsRepo = getRestAdapter().createRepository(CommentsRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Comments comments = commentsRepo.createObject(result);
                                    callback.onSuccess(comments);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method updateById__comments definition ends here..

            

        
    
        
            //Method get__wishlists definition
            public void get__wishlists(  String customerId,  Boolean refresh, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__get__wishlists", ImmutableMap.of("customerId", customerId, "refresh", refresh), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    WishlistRepository wishlistRepo = getRestAdapter().createRepository(WishlistRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Wishlist wishlist = wishlistRepo.createObject(result);
                                    callback.onSuccess(wishlist);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method get__wishlists definition ends here..

            

        
    
        
            //Method create__wishlists definition
            public void create__wishlists(  String customerId,  HashMap<String, Object> data, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__wishlists", ImmutableMap.of("customerId", customerId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    WishlistRepository wishlistRepo = getRestAdapter().createRepository(WishlistRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Wishlist wishlist = wishlistRepo.createObject(result);
                                    callback.onSuccess(wishlist);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__wishlists definition ends here..

            

        
    
        
            //Method update__wishlists definition
            public void update__wishlists(  String customerId,  HashMap<String, Object> data, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__update__wishlists", ImmutableMap.of("customerId", customerId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    WishlistRepository wishlistRepo = getRestAdapter().createRepository(WishlistRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Wishlist wishlist = wishlistRepo.createObject(result);
                                    callback.onSuccess(wishlist);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method update__wishlists definition ends here..

            

        
    
        
            //Method destroy__wishlists definition
            public void destroy__wishlists(  String customerId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroy__wishlists", ImmutableMap.of("customerId", customerId), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroy__wishlists definition ends here..

            

        
    
        
            //Method get__chefs definition
            public void get__chefs(  String customerId,  Boolean refresh, final ObjectCallback<Chef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__get__chefs", ImmutableMap.of("customerId", customerId, "refresh", refresh), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    ChefRepository chefRepo = getRestAdapter().createRepository(ChefRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Chef chef = chefRepo.createObject(result);
                                    callback.onSuccess(chef);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method get__chefs definition ends here..

            

        
    
        
            //Method create__chefs definition
            public void create__chefs(  String customerId,  HashMap<String, Object> data, final ObjectCallback<Chef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__chefs", ImmutableMap.of("customerId", customerId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    ChefRepository chefRepo = getRestAdapter().createRepository(ChefRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Chef chef = chefRepo.createObject(result);
                                    callback.onSuccess(chef);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__chefs definition ends here..

            

        
    
        
            //Method update__chefs definition
            public void update__chefs(  String customerId,  HashMap<String, Object> data, final ObjectCallback<Chef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__update__chefs", ImmutableMap.of("customerId", customerId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    ChefRepository chefRepo = getRestAdapter().createRepository(ChefRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Chef chef = chefRepo.createObject(result);
                                    callback.onSuccess(chef);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method update__chefs definition ends here..

            

        
    
        
            //Method destroy__chefs definition
            public void destroy__chefs(  String customerId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroy__chefs", ImmutableMap.of("customerId", customerId), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroy__chefs definition ends here..

            

        
    
        
            //Method findById__contactChefs definition
            public void findById__contactChefs(  String customerId,  String fk, final ObjectCallback<ContactChef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__contactChefs", ImmutableMap.of("customerId", customerId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    ContactChefRepository contactChefRepo = getRestAdapter().createRepository(ContactChefRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    ContactChef contactChef = contactChefRepo.createObject(result);
                                    callback.onSuccess(contactChef);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findById__contactChefs definition ends here..

            

        
    
        
            //Method destroyById__contactChefs definition
            public void destroyById__contactChefs(  String customerId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__contactChefs", ImmutableMap.of("customerId", customerId, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroyById__contactChefs definition ends here..

            

        
    
        
            //Method updateById__contactChefs definition
            public void updateById__contactChefs(  String customerId,  String fk,  HashMap<String, Object> data, final ObjectCallback<ContactChef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__contactChefs", ImmutableMap.of("customerId", customerId, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    ContactChefRepository contactChefRepo = getRestAdapter().createRepository(ContactChefRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    ContactChef contactChef = contactChefRepo.createObject(result);
                                    callback.onSuccess(contactChef);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method updateById__contactChefs definition ends here..

            

        
    
        
            //Method findById__orders definition
            public void findById__orders(  String customerId,  String fk, final ObjectCallback<Order> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__orders", ImmutableMap.of("customerId", customerId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    OrderRepository orderRepo = getRestAdapter().createRepository(OrderRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Order order = orderRepo.createObject(result);
                                    callback.onSuccess(order);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findById__orders definition ends here..

            

        
    
        
            //Method destroyById__orders definition
            public void destroyById__orders(  String customerId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__orders", ImmutableMap.of("customerId", customerId, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroyById__orders definition ends here..

            

        
    
        
            //Method updateById__orders definition
            public void updateById__orders(  String customerId,  String fk,  HashMap<String, Object> data, final ObjectCallback<Order> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__orders", ImmutableMap.of("customerId", customerId, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    OrderRepository orderRepo = getRestAdapter().createRepository(OrderRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Order order = orderRepo.createObject(result);
                                    callback.onSuccess(order);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method updateById__orders definition ends here..

            

        
    
        
            //Method get__accessTokens definition
            public void get__accessTokens(  String customerId,  HashMap<String, Object> filter, final ListCallback<AccessToken> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__accessTokens", ImmutableMap.of("customerId", customerId, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            
                                if(response != null){
                                    //Now converting jsonObject to list
                                    List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                    List<AccessToken> accessTokenList = new ArrayList<AccessToken>();
                                    AccessTokenRepository accessTokenRepo = getRestAdapter().createRepository(AccessTokenRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        AccessToken accessToken = accessTokenRepo.createObject(obj);
                                        accessTokenList.add(accessToken);
                                    }
                                    callback.onSuccess(accessTokenList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method get__accessTokens definition ends here..

            

        
    
        
            //Method create__accessTokens definition
            public void create__accessTokens(  String customerId,  HashMap<String, Object> data, final ObjectCallback<AccessToken> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__accessTokens", ImmutableMap.of("customerId", customerId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    AccessTokenRepository accessTokenRepo = getRestAdapter().createRepository(AccessTokenRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    AccessToken accessToken = accessTokenRepo.createObject(result);
                                    callback.onSuccess(accessToken);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__accessTokens definition ends here..

            

        
    
        
            //Method delete__accessTokens definition
            public void delete__accessTokens(  String customerId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__accessTokens", ImmutableMap.of("customerId", customerId), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method delete__accessTokens definition ends here..

            

        
    
        
            //Method count__accessTokens definition
            public void count__accessTokens(  String customerId,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__accessTokens", ImmutableMap.of("customerId", customerId, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method count__accessTokens definition ends here..

            

        
    
        
            //Method get__recipes definition
            public void get__recipes(  String customerId,  HashMap<String, Object> filter, final ListCallback<Recipe> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__recipes", ImmutableMap.of("customerId", customerId, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            
                                if(response != null){
                                    //Now converting jsonObject to list
                                    List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                    List<Recipe> recipeList = new ArrayList<Recipe>();
                                    RecipeRepository recipeRepo = getRestAdapter().createRepository(RecipeRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        Recipe recipe = recipeRepo.createObject(obj);
                                        recipeList.add(recipe);
                                    }
                                    callback.onSuccess(recipeList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method get__recipes definition ends here..

            

        
    
        
            //Method create__recipes definition
            public void create__recipes(  String customerId,  HashMap<String, Object> data, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__recipes", ImmutableMap.of("customerId", customerId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    RecipeRepository recipeRepo = getRestAdapter().createRepository(RecipeRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Recipe recipe = recipeRepo.createObject(result);
                                    callback.onSuccess(recipe);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__recipes definition ends here..

            

        
    
        
            //Method delete__recipes definition
            public void delete__recipes(  String customerId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__recipes", ImmutableMap.of("customerId", customerId), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method delete__recipes definition ends here..

            

        
    
        
            //Method count__recipes definition
            public void count__recipes(  String customerId,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__recipes", ImmutableMap.of("customerId", customerId, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method count__recipes definition ends here..

            

        
    
        
            //Method get__comments definition
            public void get__comments(  String customerId,  HashMap<String, Object> filter, final ListCallback<Comments> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__comments", ImmutableMap.of("customerId", customerId, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            
                                if(response != null){
                                    //Now converting jsonObject to list
                                    List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                    List<Comments> commentsList = new ArrayList<Comments>();
                                    CommentsRepository commentsRepo = getRestAdapter().createRepository(CommentsRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        Comments comments = commentsRepo.createObject(obj);
                                        commentsList.add(comments);
                                    }
                                    callback.onSuccess(commentsList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method get__comments definition ends here..

            

        
    
        
            //Method create__comments definition
            public void create__comments(  String customerId,  HashMap<String, Object> data, final ObjectCallback<Comments> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__comments", ImmutableMap.of("customerId", customerId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CommentsRepository commentsRepo = getRestAdapter().createRepository(CommentsRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Comments comments = commentsRepo.createObject(result);
                                    callback.onSuccess(comments);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__comments definition ends here..

            

        
    
        
            //Method delete__comments definition
            public void delete__comments(  String customerId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__comments", ImmutableMap.of("customerId", customerId), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method delete__comments definition ends here..

            

        
    
        
            //Method count__comments definition
            public void count__comments(  String customerId,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__comments", ImmutableMap.of("customerId", customerId, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method count__comments definition ends here..

            

        
    
        
            //Method get__contactChefs definition
            public void get__contactChefs(  String customerId,  HashMap<String, Object> filter, final ListCallback<ContactChef> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__contactChefs", ImmutableMap.of("customerId", customerId, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            
                                if(response != null){
                                    //Now converting jsonObject to list
                                    List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                    List<ContactChef> contactChefList = new ArrayList<ContactChef>();
                                    ContactChefRepository contactChefRepo = getRestAdapter().createRepository(ContactChefRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        ContactChef contactChef = contactChefRepo.createObject(obj);
                                        contactChefList.add(contactChef);
                                    }
                                    callback.onSuccess(contactChefList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method get__contactChefs definition ends here..

            

        
    
        
            //Method create__contactChefs definition
            public void create__contactChefs(  String customerId,  HashMap<String, Object> data, final ObjectCallback<ContactChef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__contactChefs", ImmutableMap.of("customerId", customerId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    ContactChefRepository contactChefRepo = getRestAdapter().createRepository(ContactChefRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    ContactChef contactChef = contactChefRepo.createObject(result);
                                    callback.onSuccess(contactChef);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__contactChefs definition ends here..

            

        
    
        
            //Method delete__contactChefs definition
            public void delete__contactChefs(  String customerId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__contactChefs", ImmutableMap.of("customerId", customerId), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method delete__contactChefs definition ends here..

            

        
    
        
            //Method count__contactChefs definition
            public void count__contactChefs(  String customerId,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__contactChefs", ImmutableMap.of("customerId", customerId, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method count__contactChefs definition ends here..

            

        
    
        
            //Method get__orders definition
            public void get__orders(  String customerId,  HashMap<String, Object> filter, final ListCallback<Order> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__orders", ImmutableMap.of("customerId", customerId, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            
                                if(response != null){
                                    //Now converting jsonObject to list
                                    List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                    List<Order> orderList = new ArrayList<Order>();
                                    OrderRepository orderRepo = getRestAdapter().createRepository(OrderRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        Order order = orderRepo.createObject(obj);
                                        orderList.add(order);
                                    }
                                    callback.onSuccess(orderList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method get__orders definition ends here..

            

        
    
        
            //Method create__orders definition
            public void create__orders(  String customerId,  HashMap<String, Object> data, final ObjectCallback<Order> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__orders", ImmutableMap.of("customerId", customerId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    OrderRepository orderRepo = getRestAdapter().createRepository(OrderRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Order order = orderRepo.createObject(result);
                                    callback.onSuccess(order);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__orders definition ends here..

            

        
    
        
            //Method delete__orders definition
            public void delete__orders(  String customerId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__orders", ImmutableMap.of("customerId", customerId), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method delete__orders definition ends here..

            

        
    
        
            //Method count__orders definition
            public void count__orders(  String customerId,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__orders", ImmutableMap.of("customerId", customerId, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method count__orders definition ends here..

            

        
    
        
            //Method create definition
            public void create(  HashMap<String, Object> data, final ObjectCallback<Customer> callback){
                


                
                    
                    
                    invokeStaticMethod("create", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CustomerRepository customerRepo = getRestAdapter().createRepository(CustomerRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Customer customer = customerRepo.createObject(result);
                                    callback.onSuccess(customer);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create definition ends here..

            

        
    
        
            //Method createMany definition
            public void createMany(  HashMap<String, Object> data, final ObjectCallback<Customer> callback){
                


                
                    
                    
                    invokeStaticMethod("createMany", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CustomerRepository customerRepo = getRestAdapter().createRepository(CustomerRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Customer customer = customerRepo.createObject(result);
                                    callback.onSuccess(customer);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method createMany definition ends here..

            

        
    
        
            //Method upsert definition
            public void upsert(  HashMap<String, Object> data, final ObjectCallback<Customer> callback){
                


                
                    
                    
                    invokeStaticMethod("upsert", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CustomerRepository customerRepo = getRestAdapter().createRepository(CustomerRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Customer customer = customerRepo.createObject(result);
                                    callback.onSuccess(customer);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method upsert definition ends here..

            

        
    
        
            //Method exists definition
            public void exists(  String id, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("exists", ImmutableMap.of("id", id), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method exists definition ends here..

            

        
    
        
            //Method findById definition
            public void findById(  String id,  HashMap<String, Object> filter, final ObjectCallback<Customer> callback){
                


                
                    
                    
                    invokeStaticMethod("findById", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CustomerRepository customerRepo = getRestAdapter().createRepository(CustomerRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Customer customer = customerRepo.createObject(result);
                                    callback.onSuccess(customer);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findById definition ends here..

            

        
    
        
            //Method find definition
            public void find(  HashMap<String, Object> filter, final ListCallback<Customer> callback){
                


                

                
                    invokeStaticMethod("find", ImmutableMap.of("filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            
                                if(response != null){
                                    //Now converting jsonObject to list
                                    List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                    List<Customer> customerList = new ArrayList<Customer>();
                                    CustomerRepository customerRepo = getRestAdapter().createRepository(CustomerRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        Customer customer = customerRepo.createObject(obj);
                                        customerList.add(customer);
                                    }
                                    callback.onSuccess(customerList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method find definition ends here..

            

        
    
        
            //Method findOne definition
            public void findOne(  HashMap<String, Object> filter, final ObjectCallback<Customer> callback){
                


                
                    
                    
                    invokeStaticMethod("findOne", ImmutableMap.of("filter", filter), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CustomerRepository customerRepo = getRestAdapter().createRepository(CustomerRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Customer customer = customerRepo.createObject(result);
                                    callback.onSuccess(customer);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findOne definition ends here..

            

        
    
        
            //Method updateAll definition
            public void updateAll(  HashMap<String, Object> where,  HashMap<String, Object> data, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("updateAll", ImmutableMap.of("where", where, "data", data), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method updateAll definition ends here..

            

        
    
        
            //Method deleteById definition
            public void deleteById(  String id, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("deleteById", ImmutableMap.of("id", id), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method deleteById definition ends here..

            

        
    
        
            //Method count definition
            public void count(  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("count", ImmutableMap.of("where", where), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method count definition ends here..

            

        
    
        
            //Method updateAttributes definition
            public void updateAttributes(  String customerId,  HashMap<String, Object> data, final ObjectCallback<Customer> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.updateAttributes", ImmutableMap.of("customerId", customerId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CustomerRepository customerRepo = getRestAdapter().createRepository(CustomerRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Customer customer = customerRepo.createObject(result);
                                    callback.onSuccess(customer);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method updateAttributes definition ends here..

            

        
    
        
    
        
    
        
    
        
            //Method confirm definition
            public void confirm(  String uid,  String token,  String redirect, final VoidCallback callback){
                
                    invokeStaticMethod("confirm", ImmutableMap.of("uid", uid, "token", token, "redirect", redirect), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method confirm definition ends here..

            

        
    
        
            //Method resetPassword definition
            public void resetPassword(  HashMap<String, Object> options, final VoidCallback callback){
                
                    invokeStaticMethod("resetPassword", ImmutableMap.of("options", options), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method resetPassword definition ends here..

            

        
    
        
            //Method getSchema definition
            public void getSchema( final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("getSchema", null, new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method getSchema definition ends here..

            

        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    



}
