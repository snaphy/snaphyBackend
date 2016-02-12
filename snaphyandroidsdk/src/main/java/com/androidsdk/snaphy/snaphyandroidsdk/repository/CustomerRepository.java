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
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.RecipeAnalytic;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeAnalyticRepository;
            
        
    





public class CustomerRepository extends com.strongloop.android.loopback.UserRepository<Customer> {


    public CustomerRepository(){
        super("Customer", null, Customer.class);
    }





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/accessTokens/:fk", "GET"), "Customer.prototype.__findById__accessTokens");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/accessTokens/:fk", "DELETE"), "Customer.prototype.__destroyById__accessTokens");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/accessTokens/:fk", "PUT"), "Customer.prototype.__updateById__accessTokens");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes/:fk", "GET"), "Customer.prototype.__findById__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes/:fk", "DELETE"), "Customer.prototype.__destroyById__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes/:fk", "PUT"), "Customer.prototype.__updateById__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments/:fk", "GET"), "Customer.prototype.__findById__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments/:fk", "DELETE"), "Customer.prototype.__destroyById__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments/:fk", "PUT"), "Customer.prototype.__updateById__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/wishlists", "GET"), "Customer.prototype.__get__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/wishlists", "POST"), "Customer.prototype.__create__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/wishlists", "PUT"), "Customer.prototype.__update__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/wishlists", "DELETE"), "Customer.prototype.__destroy__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/chefs", "GET"), "Customer.prototype.__get__chefs");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/chefs", "POST"), "Customer.prototype.__create__chefs");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/chefs", "PUT"), "Customer.prototype.__update__chefs");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/chefs", "DELETE"), "Customer.prototype.__destroy__chefs");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/contactChefs/:fk", "GET"), "Customer.prototype.__findById__contactChefs");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/contactChefs/:fk", "DELETE"), "Customer.prototype.__destroyById__contactChefs");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/contactChefs/:fk", "PUT"), "Customer.prototype.__updateById__contactChefs");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/orders/:fk", "GET"), "Customer.prototype.__findById__orders");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/orders/:fk", "DELETE"), "Customer.prototype.__destroyById__orders");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/orders/:fk", "PUT"), "Customer.prototype.__updateById__orders");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipeAnalytics/:fk", "GET"), "Customer.prototype.__findById__recipeAnalytics");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipeAnalytics/:fk", "DELETE"), "Customer.prototype.__destroyById__recipeAnalytics");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipeAnalytics/:fk", "PUT"), "Customer.prototype.__updateById__recipeAnalytics");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/accessTokens", "GET"), "Customer.prototype.__get__accessTokens");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/accessTokens", "POST"), "Customer.prototype.__create__accessTokens");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/accessTokens", "DELETE"), "Customer.prototype.__delete__accessTokens");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/accessTokens/count", "GET"), "Customer.prototype.__count__accessTokens");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes", "GET"), "Customer.prototype.__get__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes", "POST"), "Customer.prototype.__create__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes", "DELETE"), "Customer.prototype.__delete__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes/count", "GET"), "Customer.prototype.__count__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments", "GET"), "Customer.prototype.__get__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments", "POST"), "Customer.prototype.__create__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments", "DELETE"), "Customer.prototype.__delete__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments/count", "GET"), "Customer.prototype.__count__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/contactChefs", "GET"), "Customer.prototype.__get__contactChefs");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/contactChefs", "POST"), "Customer.prototype.__create__contactChefs");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/contactChefs", "DELETE"), "Customer.prototype.__delete__contactChefs");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/contactChefs/count", "GET"), "Customer.prototype.__count__contactChefs");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/orders", "GET"), "Customer.prototype.__get__orders");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/orders", "POST"), "Customer.prototype.__create__orders");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/orders", "DELETE"), "Customer.prototype.__delete__orders");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/orders/count", "GET"), "Customer.prototype.__count__orders");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipeAnalytics", "GET"), "Customer.prototype.__get__recipeAnalytics");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipeAnalytics", "POST"), "Customer.prototype.__create__recipeAnalytics");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipeAnalytics", "DELETE"), "Customer.prototype.__delete__recipeAnalytics");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipeAnalytics/count", "GET"), "Customer.prototype.__count__recipeAnalytics");
            
        
            
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
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "PUT"), "Customer.prototype.updateAttributes");
            
        
            
        
            
        
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/confirm", "GET"), "Customer.confirm");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/reset", "POST"), "Customer.resetPassword");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/getSchema", "POST"), "Customer.getSchema");
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
        return contract;
    }



    




    
        
            //Method findById__accessTokens definition
            public void findById__accessTokens(  String id,  String fk, final ObjectCallback<AccessToken> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__accessTokens", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
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
            public void destroyById__accessTokens(  String id,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__accessTokens", ImmutableMap.of("id", id, "fk", fk), new Adapter.Callback() {
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
            public void updateById__accessTokens(  String id,  String fk,  AccessToken data, final ObjectCallback<AccessToken> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__accessTokens", ImmutableMap.of("id", id, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void findById__recipes(  String id,  String fk, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__recipes", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
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
            public void destroyById__recipes(  String id,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__recipes", ImmutableMap.of("id", id, "fk", fk), new Adapter.Callback() {
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
            public void updateById__recipes(  String id,  String fk,  Recipe data, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__recipes", ImmutableMap.of("id", id, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void findById__comments(  String id,  String fk, final ObjectCallback<Comments> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__comments", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
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
            public void destroyById__comments(  String id,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__comments", ImmutableMap.of("id", id, "fk", fk), new Adapter.Callback() {
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
            public void updateById__comments(  String id,  String fk,  Comments data, final ObjectCallback<Comments> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__comments", ImmutableMap.of("id", id, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void get__wishlists(  String id,  Boolean refresh, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__get__wishlists", ImmutableMap.of("id", id, "refresh", refresh), new Adapter.JsonObjectCallback() {
                    
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
            public void create__wishlists(  String id,  Wishlist data, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__wishlists", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void update__wishlists(  String id,  Wishlist data, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__update__wishlists", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void destroy__wishlists(  String id, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroy__wishlists", ImmutableMap.of("id", id), new Adapter.Callback() {
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
            public void get__chefs(  String id,  Boolean refresh, final ObjectCallback<Chef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__get__chefs", ImmutableMap.of("id", id, "refresh", refresh), new Adapter.JsonObjectCallback() {
                    
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
            public void create__chefs(  String id,  Chef data, final ObjectCallback<Chef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__chefs", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void update__chefs(  String id,  Chef data, final ObjectCallback<Chef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__update__chefs", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void destroy__chefs(  String id, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroy__chefs", ImmutableMap.of("id", id), new Adapter.Callback() {
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
            public void findById__contactChefs(  String id,  String fk, final ObjectCallback<ContactChef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__contactChefs", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
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
            public void destroyById__contactChefs(  String id,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__contactChefs", ImmutableMap.of("id", id, "fk", fk), new Adapter.Callback() {
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
            public void updateById__contactChefs(  String id,  String fk,  ContactChef data, final ObjectCallback<ContactChef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__contactChefs", ImmutableMap.of("id", id, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void findById__orders(  String id,  String fk, final ObjectCallback<Order> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__orders", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
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
            public void destroyById__orders(  String id,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__orders", ImmutableMap.of("id", id, "fk", fk), new Adapter.Callback() {
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
            public void updateById__orders(  String id,  String fk,  Order data, final ObjectCallback<Order> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__orders", ImmutableMap.of("id", id, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
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

            

        
    
        
            //Method findById__recipeAnalytics definition
            public void findById__recipeAnalytics(  String id,  String fk, final ObjectCallback<RecipeAnalytic> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__recipeAnalytics", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    RecipeAnalyticRepository recipeAnalyticRepo = getRestAdapter().createRepository(RecipeAnalyticRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    RecipeAnalytic recipeAnalytic = recipeAnalyticRepo.createObject(result);
                                    callback.onSuccess(recipeAnalytic);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findById__recipeAnalytics definition ends here..

            

        
    
        
            //Method destroyById__recipeAnalytics definition
            public void destroyById__recipeAnalytics(  String id,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__recipeAnalytics", ImmutableMap.of("id", id, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroyById__recipeAnalytics definition ends here..

            

        
    
        
            //Method updateById__recipeAnalytics definition
            public void updateById__recipeAnalytics(  String id,  String fk,  RecipeAnalytic data, final ObjectCallback<RecipeAnalytic> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__recipeAnalytics", ImmutableMap.of("id", id, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    RecipeAnalyticRepository recipeAnalyticRepo = getRestAdapter().createRepository(RecipeAnalyticRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    RecipeAnalytic recipeAnalytic = recipeAnalyticRepo.createObject(result);
                                    callback.onSuccess(recipeAnalytic);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method updateById__recipeAnalytics definition ends here..

            

        
    
        
            //Method get__accessTokens definition
            public void get__accessTokens(  String id,  HashMap<String, Object> filter, final ListCallback<AccessToken> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__accessTokens", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonArrayCallback() {
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
            public void create__accessTokens(  String id,  AccessToken data, final ObjectCallback<AccessToken> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__accessTokens", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void delete__accessTokens(  String id, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__accessTokens", ImmutableMap.of("id", id), new Adapter.Callback() {
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
            public void count__accessTokens(  String id,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__accessTokens", ImmutableMap.of("id", id, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
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
            public void get__recipes(  String id,  HashMap<String, Object> filter, final ListCallback<Recipe> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__recipes", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonArrayCallback() {
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
            public void create__recipes(  String id,  Recipe data, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__recipes", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void delete__recipes(  String id, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__recipes", ImmutableMap.of("id", id), new Adapter.Callback() {
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
            public void count__recipes(  String id,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__recipes", ImmutableMap.of("id", id, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
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
            public void get__comments(  String id,  HashMap<String, Object> filter, final ListCallback<Comments> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__comments", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonArrayCallback() {
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
            public void create__comments(  String id,  Comments data, final ObjectCallback<Comments> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__comments", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void delete__comments(  String id, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__comments", ImmutableMap.of("id", id), new Adapter.Callback() {
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
            public void count__comments(  String id,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__comments", ImmutableMap.of("id", id, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
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
            public void get__contactChefs(  String id,  HashMap<String, Object> filter, final ListCallback<ContactChef> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__contactChefs", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonArrayCallback() {
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
            public void create__contactChefs(  String id,  ContactChef data, final ObjectCallback<ContactChef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__contactChefs", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void delete__contactChefs(  String id, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__contactChefs", ImmutableMap.of("id", id), new Adapter.Callback() {
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
            public void count__contactChefs(  String id,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__contactChefs", ImmutableMap.of("id", id, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
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
            public void get__orders(  String id,  HashMap<String, Object> filter, final ListCallback<Order> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__orders", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonArrayCallback() {
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
            public void create__orders(  String id,  Order data, final ObjectCallback<Order> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__orders", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void delete__orders(  String id, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__orders", ImmutableMap.of("id", id), new Adapter.Callback() {
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
            public void count__orders(  String id,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__orders", ImmutableMap.of("id", id, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
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

            

        
    
        
            //Method get__recipeAnalytics definition
            public void get__recipeAnalytics(  String id,  HashMap<String, Object> filter, final ListCallback<RecipeAnalytic> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__recipeAnalytics", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            
                                if(response != null){
                                    //Now converting jsonObject to list
                                    List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                    List<RecipeAnalytic> recipeAnalyticList = new ArrayList<RecipeAnalytic>();
                                    RecipeAnalyticRepository recipeAnalyticRepo = getRestAdapter().createRepository(RecipeAnalyticRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        RecipeAnalytic recipeAnalytic = recipeAnalyticRepo.createObject(obj);
                                        recipeAnalyticList.add(recipeAnalytic);
                                    }
                                    callback.onSuccess(recipeAnalyticList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method get__recipeAnalytics definition ends here..

            

        
    
        
            //Method create__recipeAnalytics definition
            public void create__recipeAnalytics(  String id,  RecipeAnalytic data, final ObjectCallback<RecipeAnalytic> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__recipeAnalytics", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    RecipeAnalyticRepository recipeAnalyticRepo = getRestAdapter().createRepository(RecipeAnalyticRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    RecipeAnalytic recipeAnalytic = recipeAnalyticRepo.createObject(result);
                                    callback.onSuccess(recipeAnalytic);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__recipeAnalytics definition ends here..

            

        
    
        
            //Method delete__recipeAnalytics definition
            public void delete__recipeAnalytics(  String id, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__recipeAnalytics", ImmutableMap.of("id", id), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method delete__recipeAnalytics definition ends here..

            

        
    
        
            //Method count__recipeAnalytics definition
            public void count__recipeAnalytics(  String id,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__recipeAnalytics", ImmutableMap.of("id", id, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method count__recipeAnalytics definition ends here..

            

        
    
        
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
            public void updateAttributes(  String id,  HashMap<String, Object> data, final ObjectCallback<Customer> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.updateAttributes", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
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
