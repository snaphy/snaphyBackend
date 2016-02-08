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
import com.androidsdk.snaphy.snaphyandroidsdk.models.Wishlist;

//Now import model of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Customer;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CustomerRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Recipe;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;
            
        
    





public class WishlistRepository extends ModelRepository<Wishlist> {


    public WishlistRepository(){
        super("Wishlist", null, Wishlist.class);
    }





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/customers", "GET"), "Wishlist.prototype.__get__customers");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/customers", "POST"), "Wishlist.prototype.__create__customers");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/customers", "PUT"), "Wishlist.prototype.__update__customers");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/customers", "DELETE"), "Wishlist.prototype.__destroy__customers");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes/:fk", "GET"), "Wishlist.prototype.__findById__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes/:fk", "DELETE"), "Wishlist.prototype.__destroyById__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes/:fk", "PUT"), "Wishlist.prototype.__updateById__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes/rel/:fk", "PUT"), "Wishlist.prototype.__link__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes/rel/:fk", "DELETE"), "Wishlist.prototype.__unlink__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes/rel/:fk", "HEAD"), "Wishlist.prototype.__exists__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes", "GET"), "Wishlist.prototype.__get__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes", "POST"), "Wishlist.prototype.__create__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes", "DELETE"), "Wishlist.prototype.__delete__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes/count", "GET"), "Wishlist.prototype.__count__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "Wishlist.create");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "Wishlist.create");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "PUT"), "Wishlist.upsert");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/exists", "GET"), "Wishlist.exists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "GET"), "Wishlist.findById");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "GET"), "Wishlist.find");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/findOne", "GET"), "Wishlist.findOne");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/update", "POST"), "Wishlist.updateAll");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "DELETE"), "Wishlist.deleteById");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/count", "GET"), "Wishlist.count");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "PUT"), "Wishlist.prototype.updateAttributes");
            
        
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/getSchema", "POST"), "Wishlist.getSchema");
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
        return contract;
    }



    




    
        
            //Method get__customers definition
            public void get__customers(  String id,  Boolean refresh, final ObjectCallback<Customer> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__get__customers", ImmutableMap.of("id", id, "refresh", refresh), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method get__customers definition ends here..

            

        
    
        
            //Method create__customers definition
            public void create__customers(  String id,  Customer data, final ObjectCallback<Customer> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__customers", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method create__customers definition ends here..

            

        
    
        
            //Method update__customers definition
            public void update__customers(  String id,  Customer data, final ObjectCallback<Customer> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__update__customers", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method update__customers definition ends here..

            

        
    
        
            //Method destroy__customers definition
            public void destroy__customers(  String id, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroy__customers", ImmutableMap.of("id", id), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroy__customers definition ends here..

            

        
    
        
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

            

        
    
        
            //Method link__recipes definition
            public void link__recipes(  String id,  String fk,  Recipe data, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__link__recipes", ImmutableMap.of("id", id, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method link__recipes definition ends here..

            

        
    
        
            //Method unlink__recipes definition
            public void unlink__recipes(  String id,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__unlink__recipes", ImmutableMap.of("id", id, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method unlink__recipes definition ends here..

            

        
    
        
            //Method exists__recipes definition
            public void exists__recipes(  String id,  String fk, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__exists__recipes", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method exists__recipes definition ends here..

            

        
    
        
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

            

        
    
        
            //Method create definition
            public void create(  HashMap<String, Object> data, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("create", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method create definition ends here..

            

        
    
        
            //Method createMany definition
            public void createMany(  HashMap<String, Object> data, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("createMany", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method createMany definition ends here..

            

        
    
        
            //Method upsert definition
            public void upsert(  HashMap<String, Object> data, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("upsert", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void findById(  String id,  HashMap<String, Object> filter, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("findById", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method findById definition ends here..

            

        
    
        
            //Method find definition
            public void find(  HashMap<String, Object> filter, final ListCallback<Wishlist> callback){
                


                

                
                    invokeStaticMethod("find", ImmutableMap.of("filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            

                                //Now converting jsonObject to list
                                List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                List<Wishlist> wishlistList = new ArrayList<Wishlist>();
                                WishlistRepository wishlistRepo = getRestAdapter().createRepository(WishlistRepository.class);

                                for (Map<String, Object> obj : result) {
                                    Wishlist wishlist = wishlistRepo.createObject(obj);
                                    wishlistList.add(wishlist);
                                }
                                callback.onSuccess(wishlistList);
                            
                        }
                    });
                

            }//Method find definition ends here..

            

        
    
        
            //Method findOne definition
            public void findOne(  HashMap<String, Object> filter, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("findOne", ImmutableMap.of("filter", filter), new Adapter.JsonObjectCallback() {
                    
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
            public void updateAttributes(  String id,  HashMap<String, Object> data, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.updateAttributes", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
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
