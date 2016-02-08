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



import com.strongloop.android.loopback.ModelRepository;



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
            
        
    





public class CustomerRepository extends ModelRepository<Customer> {


    public CustomerRepository(){
        super("Customer", null, Customer.class);
    }





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            
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
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes", "GET"), "Customer.prototype.__get__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes", "POST"), "Customer.prototype.__create__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes", "DELETE"), "Customer.prototype.__delete__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes/count", "GET"), "Customer.prototype.__count__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments", "GET"), "Customer.prototype.__get__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments", "POST"), "Customer.prototype.__create__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments", "DELETE"), "Customer.prototype.__delete__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments/count", "GET"), "Customer.prototype.__count__comments");
            
        
            
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
            
        
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/getSchema", "POST"), "Customer.getSchema");
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
        return contract;
    }



    




    
        
            //Method findById__recipes definition
            public void findById__recipes(  String id,  String fk, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__recipes", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                RecipeRepository recipeRepo = getRestAdapter().createRepository(RecipeRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Recipe recipe = recipeRepo.createObject(result);
                                callback.onSuccess(recipe);
                            
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
                            
                                RecipeRepository recipeRepo = getRestAdapter().createRepository(RecipeRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Recipe recipe = recipeRepo.createObject(result);
                                callback.onSuccess(recipe);
                            
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
                            
                                CommentsRepository commentsRepo = getRestAdapter().createRepository(CommentsRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Comments comments = commentsRepo.createObject(result);
                                callback.onSuccess(comments);
                            
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
                            
                                CommentsRepository commentsRepo = getRestAdapter().createRepository(CommentsRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Comments comments = commentsRepo.createObject(result);
                                callback.onSuccess(comments);
                            
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
                            
                                WishlistRepository wishlistRepo = getRestAdapter().createRepository(WishlistRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Wishlist wishlist = wishlistRepo.createObject(result);
                                callback.onSuccess(wishlist);
                            
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
                            
                                WishlistRepository wishlistRepo = getRestAdapter().createRepository(WishlistRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Wishlist wishlist = wishlistRepo.createObject(result);
                                callback.onSuccess(wishlist);
                            
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
                            
                                WishlistRepository wishlistRepo = getRestAdapter().createRepository(WishlistRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Wishlist wishlist = wishlistRepo.createObject(result);
                                callback.onSuccess(wishlist);
                            
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

            

        
    
        
            //Method get__recipes definition
            public void get__recipes(  String id,  HashMap<String, Object> filter, final ListCallback<Recipe> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__recipes", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            

                                //Now converting jsonObject to list
                                List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                List<Recipe> recipeList = new ArrayList<Recipe>();
                                RecipeRepository recipeRepo = getRestAdapter().createRepository(RecipeRepository.class);

                                for (Map<String, Object> obj : result) {
                                    Recipe recipe = recipeRepo.createObject(obj);
                                    recipeList.add(recipe);
                                }
                                callback.onSuccess(recipeList);
                            
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
                            
                                RecipeRepository recipeRepo = getRestAdapter().createRepository(RecipeRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Recipe recipe = recipeRepo.createObject(result);
                                callback.onSuccess(recipe);
                            
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
                            

                                //Now converting jsonObject to list
                                List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                List<Comments> commentsList = new ArrayList<Comments>();
                                CommentsRepository commentsRepo = getRestAdapter().createRepository(CommentsRepository.class);

                                for (Map<String, Object> obj : result) {
                                    Comments comments = commentsRepo.createObject(obj);
                                    commentsList.add(comments);
                                }
                                callback.onSuccess(commentsList);
                            
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
                            
                                CommentsRepository commentsRepo = getRestAdapter().createRepository(CommentsRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Comments comments = commentsRepo.createObject(result);
                                callback.onSuccess(comments);
                            
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

            

        
    
        
            //Method create definition
            public void create(  HashMap<String, Object> data, final ObjectCallback<Customer> callback){
                


                
                    
                    
                    invokeStaticMethod("create", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                CustomerRepository customerRepo = getRestAdapter().createRepository(CustomerRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Customer customer = customerRepo.createObject(result);
                                callback.onSuccess(customer);
                            
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
                            
                                CustomerRepository customerRepo = getRestAdapter().createRepository(CustomerRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Customer customer = customerRepo.createObject(result);
                                callback.onSuccess(customer);
                            
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
                            
                                CustomerRepository customerRepo = getRestAdapter().createRepository(CustomerRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Customer customer = customerRepo.createObject(result);
                                callback.onSuccess(customer);
                            
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
                            
                                CustomerRepository customerRepo = getRestAdapter().createRepository(CustomerRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Customer customer = customerRepo.createObject(result);
                                callback.onSuccess(customer);
                            
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
                            

                                //Now converting jsonObject to list
                                List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                List<Customer> customerList = new ArrayList<Customer>();
                                CustomerRepository customerRepo = getRestAdapter().createRepository(CustomerRepository.class);

                                for (Map<String, Object> obj : result) {
                                    Customer customer = customerRepo.createObject(obj);
                                    customerList.add(customer);
                                }
                                callback.onSuccess(customerList);
                            
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
                            
                                CustomerRepository customerRepo = getRestAdapter().createRepository(CustomerRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Customer customer = customerRepo.createObject(result);
                                callback.onSuccess(customer);
                            
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
                            
                                CustomerRepository customerRepo = getRestAdapter().createRepository(CustomerRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Customer customer = customerRepo.createObject(result);
                                callback.onSuccess(customer);
                            
                        }
                    });
                

                

            }//Method updateAttributes definition ends here..

            

        
    
        
    
        
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
