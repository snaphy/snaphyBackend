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
import com.androidsdk.snaphy.snaphyandroidsdk.models.Recipe;

//Now import model of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Customer;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CustomerRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Cuisines;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CuisinesRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Priority;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.PriorityRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Category;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CategoryRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Comments;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CommentsRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.RecipeTag;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeTagRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Ingredients;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.IngredientsRepository;
            
                import com.androidsdk.snaphy.snaphyandroidsdk.models.RecipeIngredients;
                import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeIngredientsRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Wishlist;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.WishlistRepository;
            
        
    





public class RecipeRepository extends ModelRepository<Recipe> {


    public RecipeRepository(){
        super("Recipe", null, Recipe.class);
    }





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/customer", "GET"), "Recipe.prototype.__get__customer");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/cuisines/:fk", "GET"), "Recipe.prototype.__findById__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/cuisines/:fk", "DELETE"), "Recipe.prototype.__destroyById__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/cuisines/:fk", "PUT"), "Recipe.prototype.__updateById__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/cuisines/rel/:fk", "PUT"), "Recipe.prototype.__link__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/cuisines/rel/:fk", "DELETE"), "Recipe.prototype.__unlink__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/cuisines/rel/:fk", "HEAD"), "Recipe.prototype.__exists__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/priorities", "GET"), "Recipe.prototype.__get__priorities");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/priorities", "POST"), "Recipe.prototype.__create__priorities");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/priorities", "PUT"), "Recipe.prototype.__update__priorities");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/priorities", "DELETE"), "Recipe.prototype.__destroy__priorities");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/category/:fk", "GET"), "Recipe.prototype.__findById__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/category/:fk", "DELETE"), "Recipe.prototype.__destroyById__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/category/:fk", "PUT"), "Recipe.prototype.__updateById__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/category/rel/:fk", "PUT"), "Recipe.prototype.__link__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/category/rel/:fk", "DELETE"), "Recipe.prototype.__unlink__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/category/rel/:fk", "HEAD"), "Recipe.prototype.__exists__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments/:fk", "GET"), "Recipe.prototype.__findById__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments/:fk", "DELETE"), "Recipe.prototype.__destroyById__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments/:fk", "PUT"), "Recipe.prototype.__updateById__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipeTags/:fk", "GET"), "Recipe.prototype.__findById__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipeTags/:fk", "DELETE"), "Recipe.prototype.__destroyById__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipeTags/:fk", "PUT"), "Recipe.prototype.__updateById__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipeTags/rel/:fk", "PUT"), "Recipe.prototype.__link__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipeTags/rel/:fk", "DELETE"), "Recipe.prototype.__unlink__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipeTags/rel/:fk", "HEAD"), "Recipe.prototype.__exists__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients/:fk", "GET"), "Recipe.prototype.__findById__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients/:fk", "DELETE"), "Recipe.prototype.__destroyById__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients/:fk", "PUT"), "Recipe.prototype.__updateById__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients/rel/:fk", "PUT"), "Recipe.prototype.__link__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients/rel/:fk", "DELETE"), "Recipe.prototype.__unlink__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients/rel/:fk", "HEAD"), "Recipe.prototype.__exists__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/wishlists/:fk", "GET"), "Recipe.prototype.__findById__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/wishlists/:fk", "DELETE"), "Recipe.prototype.__destroyById__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/wishlists/:fk", "PUT"), "Recipe.prototype.__updateById__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/wishlists/rel/:fk", "PUT"), "Recipe.prototype.__link__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/wishlists/rel/:fk", "DELETE"), "Recipe.prototype.__unlink__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/wishlists/rel/:fk", "HEAD"), "Recipe.prototype.__exists__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/cuisines", "GET"), "Recipe.prototype.__get__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/cuisines", "POST"), "Recipe.prototype.__create__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/cuisines", "DELETE"), "Recipe.prototype.__delete__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/cuisines/count", "GET"), "Recipe.prototype.__count__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/category", "GET"), "Recipe.prototype.__get__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/category", "POST"), "Recipe.prototype.__create__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/category", "DELETE"), "Recipe.prototype.__delete__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/category/count", "GET"), "Recipe.prototype.__count__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments", "GET"), "Recipe.prototype.__get__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments", "POST"), "Recipe.prototype.__create__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments", "DELETE"), "Recipe.prototype.__delete__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/comments/count", "GET"), "Recipe.prototype.__count__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipeTags", "GET"), "Recipe.prototype.__get__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipeTags", "POST"), "Recipe.prototype.__create__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipeTags", "DELETE"), "Recipe.prototype.__delete__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipeTags/count", "GET"), "Recipe.prototype.__count__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients", "GET"), "Recipe.prototype.__get__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients", "POST"), "Recipe.prototype.__create__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients", "DELETE"), "Recipe.prototype.__delete__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients/count", "GET"), "Recipe.prototype.__count__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/wishlists", "GET"), "Recipe.prototype.__get__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/wishlists", "POST"), "Recipe.prototype.__create__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/wishlists", "DELETE"), "Recipe.prototype.__delete__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/wishlists/count", "GET"), "Recipe.prototype.__count__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "Recipe.create");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "Recipe.create");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "PUT"), "Recipe.upsert");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/exists", "GET"), "Recipe.exists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "GET"), "Recipe.findById");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "GET"), "Recipe.find");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/findOne", "GET"), "Recipe.findOne");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/update", "POST"), "Recipe.updateAll");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "DELETE"), "Recipe.deleteById");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/count", "GET"), "Recipe.count");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "PUT"), "Recipe.prototype.updateAttributes");
            
        
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/getSchema", "POST"), "Recipe.getSchema");
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
        return contract;
    }



    




    
        
            //Method get__customer definition
            public void get__customer(  String id,  Boolean refresh, final ObjectCallback<Customer> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__get__customer", ImmutableMap.of("id", id, "refresh", refresh), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method get__customer definition ends here..

            

        
    
        
            //Method findById__cuisines definition
            public void findById__cuisines(  String id,  String fk, final ObjectCallback<Cuisines> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__cuisines", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                CuisinesRepository cuisinesRepo = getRestAdapter().createRepository(CuisinesRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Cuisines cuisines = cuisinesRepo.createObject(result);
                                callback.onSuccess(cuisines);
                            
                        }
                    });
                

                

            }//Method findById__cuisines definition ends here..

            

        
    
        
            //Method destroyById__cuisines definition
            public void destroyById__cuisines(  String id,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__cuisines", ImmutableMap.of("id", id, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroyById__cuisines definition ends here..

            

        
    
        
            //Method updateById__cuisines definition
            public void updateById__cuisines(  String id,  String fk,  Cuisines data, final ObjectCallback<Cuisines> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__cuisines", ImmutableMap.of("id", id, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                CuisinesRepository cuisinesRepo = getRestAdapter().createRepository(CuisinesRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Cuisines cuisines = cuisinesRepo.createObject(result);
                                callback.onSuccess(cuisines);
                            
                        }
                    });
                

                

            }//Method updateById__cuisines definition ends here..

            

        
    
        
            //Method link__cuisines definition
            public void link__cuisines(  String id,  String fk,  Cuisines data, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__link__cuisines", ImmutableMap.of("id", id, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method link__cuisines definition ends here..

            

        
    
        
            //Method unlink__cuisines definition
            public void unlink__cuisines(  String id,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__unlink__cuisines", ImmutableMap.of("id", id, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method unlink__cuisines definition ends here..

            

        
    
        
            //Method exists__cuisines definition
            public void exists__cuisines(  String id,  String fk, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__exists__cuisines", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method exists__cuisines definition ends here..

            

        
    
        
            //Method get__priorities definition
            public void get__priorities(  String id,  Boolean refresh, final ObjectCallback<Priority> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__get__priorities", ImmutableMap.of("id", id, "refresh", refresh), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                PriorityRepository priorityRepo = getRestAdapter().createRepository(PriorityRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Priority priority = priorityRepo.createObject(result);
                                callback.onSuccess(priority);
                            
                        }
                    });
                

                

            }//Method get__priorities definition ends here..

            

        
    
        
            //Method create__priorities definition
            public void create__priorities(  String id,  Priority data, final ObjectCallback<Priority> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__priorities", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                PriorityRepository priorityRepo = getRestAdapter().createRepository(PriorityRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Priority priority = priorityRepo.createObject(result);
                                callback.onSuccess(priority);
                            
                        }
                    });
                

                

            }//Method create__priorities definition ends here..

            

        
    
        
            //Method update__priorities definition
            public void update__priorities(  String id,  Priority data, final ObjectCallback<Priority> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__update__priorities", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                PriorityRepository priorityRepo = getRestAdapter().createRepository(PriorityRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Priority priority = priorityRepo.createObject(result);
                                callback.onSuccess(priority);
                            
                        }
                    });
                

                

            }//Method update__priorities definition ends here..

            

        
    
        
            //Method destroy__priorities definition
            public void destroy__priorities(  String id, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroy__priorities", ImmutableMap.of("id", id), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroy__priorities definition ends here..

            

        
    
        
            //Method findById__category definition
            public void findById__category(  String id,  String fk, final ObjectCallback<Category> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__category", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                CategoryRepository categoryRepo = getRestAdapter().createRepository(CategoryRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Category category = categoryRepo.createObject(result);
                                callback.onSuccess(category);
                            
                        }
                    });
                

                

            }//Method findById__category definition ends here..

            

        
    
        
            //Method destroyById__category definition
            public void destroyById__category(  String id,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__category", ImmutableMap.of("id", id, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroyById__category definition ends here..

            

        
    
        
            //Method updateById__category definition
            public void updateById__category(  String id,  String fk,  Category data, final ObjectCallback<Category> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__category", ImmutableMap.of("id", id, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                CategoryRepository categoryRepo = getRestAdapter().createRepository(CategoryRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Category category = categoryRepo.createObject(result);
                                callback.onSuccess(category);
                            
                        }
                    });
                

                

            }//Method updateById__category definition ends here..

            

        
    
        
            //Method link__category definition
            public void link__category(  String id,  String fk,  Category data, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__link__category", ImmutableMap.of("id", id, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method link__category definition ends here..

            

        
    
        
            //Method unlink__category definition
            public void unlink__category(  String id,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__unlink__category", ImmutableMap.of("id", id, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method unlink__category definition ends here..

            

        
    
        
            //Method exists__category definition
            public void exists__category(  String id,  String fk, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__exists__category", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method exists__category definition ends here..

            

        
    
        
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

            

        
    
        
            //Method findById__recipeTags definition
            public void findById__recipeTags(  String id,  String fk, final ObjectCallback<RecipeTag> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__recipeTags", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                RecipeTagRepository recipeTagRepo = getRestAdapter().createRepository(RecipeTagRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                RecipeTag recipeTag = recipeTagRepo.createObject(result);
                                callback.onSuccess(recipeTag);
                            
                        }
                    });
                

                

            }//Method findById__recipeTags definition ends here..

            

        
    
        
            //Method destroyById__recipeTags definition
            public void destroyById__recipeTags(  String id,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__recipeTags", ImmutableMap.of("id", id, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroyById__recipeTags definition ends here..

            

        
    
        
            //Method updateById__recipeTags definition
            public void updateById__recipeTags(  String id,  String fk,  RecipeTag data, final ObjectCallback<RecipeTag> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__recipeTags", ImmutableMap.of("id", id, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                RecipeTagRepository recipeTagRepo = getRestAdapter().createRepository(RecipeTagRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                RecipeTag recipeTag = recipeTagRepo.createObject(result);
                                callback.onSuccess(recipeTag);
                            
                        }
                    });
                

                

            }//Method updateById__recipeTags definition ends here..

            

        
    
        
            //Method link__recipeTags definition
            public void link__recipeTags(  String id,  String fk,  RecipeTag data, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__link__recipeTags", ImmutableMap.of("id", id, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method link__recipeTags definition ends here..

            

        
    
        
            //Method unlink__recipeTags definition
            public void unlink__recipeTags(  String id,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__unlink__recipeTags", ImmutableMap.of("id", id, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method unlink__recipeTags definition ends here..

            

        
    
        
            //Method exists__recipeTags definition
            public void exists__recipeTags(  String id,  String fk, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__exists__recipeTags", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method exists__recipeTags definition ends here..

            

        
    
        
            //Method findById__ingredients definition
            public void findById__ingredients(  String id,  String fk, final ObjectCallback<Ingredients> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__ingredients", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                IngredientsRepository ingredientsRepo = getRestAdapter().createRepository(IngredientsRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Ingredients ingredients = ingredientsRepo.createObject(result);
                                callback.onSuccess(ingredients);
                            
                        }
                    });
                

                

            }//Method findById__ingredients definition ends here..

            

        
    
        
            //Method destroyById__ingredients definition
            public void destroyById__ingredients(  String id,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__ingredients", ImmutableMap.of("id", id, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroyById__ingredients definition ends here..

            

        
    
        
            //Method updateById__ingredients definition
            public void updateById__ingredients(  String id,  String fk,  Ingredients data, final ObjectCallback<Ingredients> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__ingredients", ImmutableMap.of("id", id, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                IngredientsRepository ingredientsRepo = getRestAdapter().createRepository(IngredientsRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Ingredients ingredients = ingredientsRepo.createObject(result);
                                callback.onSuccess(ingredients);
                            
                        }
                    });
                

                

            }//Method updateById__ingredients definition ends here..

            

        
    
        
            //Method link__ingredients definition
            public void link__ingredients(  String id,  String fk,  RecipeIngredients data, final ObjectCallback<RecipeIngredients> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__link__ingredients", ImmutableMap.of("id", id, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                RecipeIngredientsRepository recipeIngredientsRepo = getRestAdapter().createRepository(RecipeIngredientsRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                RecipeIngredients recipeIngredients = recipeIngredientsRepo.createObject(result);
                                callback.onSuccess(recipeIngredients);
                            
                        }
                    });
                

                

            }//Method link__ingredients definition ends here..

            

        
    
        
            //Method unlink__ingredients definition
            public void unlink__ingredients(  String id,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__unlink__ingredients", ImmutableMap.of("id", id, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method unlink__ingredients definition ends here..

            

        
    
        
            //Method exists__ingredients definition
            public void exists__ingredients(  String id,  String fk, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__exists__ingredients", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method exists__ingredients definition ends here..

            

        
    
        
            //Method findById__wishlists definition
            public void findById__wishlists(  String id,  String fk, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__wishlists", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method findById__wishlists definition ends here..

            

        
    
        
            //Method destroyById__wishlists definition
            public void destroyById__wishlists(  String id,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__wishlists", ImmutableMap.of("id", id, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroyById__wishlists definition ends here..

            

        
    
        
            //Method updateById__wishlists definition
            public void updateById__wishlists(  String id,  String fk,  Wishlist data, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__wishlists", ImmutableMap.of("id", id, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method updateById__wishlists definition ends here..

            

        
    
        
            //Method link__wishlists definition
            public void link__wishlists(  String id,  String fk,  Wishlist data, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__link__wishlists", ImmutableMap.of("id", id, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method link__wishlists definition ends here..

            

        
    
        
            //Method unlink__wishlists definition
            public void unlink__wishlists(  String id,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__unlink__wishlists", ImmutableMap.of("id", id, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method unlink__wishlists definition ends here..

            

        
    
        
            //Method exists__wishlists definition
            public void exists__wishlists(  String id,  String fk, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__exists__wishlists", ImmutableMap.of("id", id, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method exists__wishlists definition ends here..

            

        
    
        
            //Method get__cuisines definition
            public void get__cuisines(  String id,  HashMap<String, Object> filter, final ListCallback<Cuisines> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__cuisines", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            

                                //Now converting jsonObject to list
                                List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                List<Cuisines> cuisinesList = new ArrayList<Cuisines>();
                                CuisinesRepository cuisinesRepo = getRestAdapter().createRepository(CuisinesRepository.class);

                                for (Map<String, Object> obj : result) {
                                    Cuisines cuisines = cuisinesRepo.createObject(obj);
                                    cuisinesList.add(cuisines);
                                }
                                callback.onSuccess(cuisinesList);
                            
                        }
                    });
                

            }//Method get__cuisines definition ends here..

            

        
    
        
            //Method create__cuisines definition
            public void create__cuisines(  String id,  Cuisines data, final ObjectCallback<Cuisines> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__cuisines", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                CuisinesRepository cuisinesRepo = getRestAdapter().createRepository(CuisinesRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Cuisines cuisines = cuisinesRepo.createObject(result);
                                callback.onSuccess(cuisines);
                            
                        }
                    });
                

                

            }//Method create__cuisines definition ends here..

            

        
    
        
            //Method delete__cuisines definition
            public void delete__cuisines(  String id, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__cuisines", ImmutableMap.of("id", id), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method delete__cuisines definition ends here..

            

        
    
        
            //Method count__cuisines definition
            public void count__cuisines(  String id,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__cuisines", ImmutableMap.of("id", id, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method count__cuisines definition ends here..

            

        
    
        
            //Method get__category definition
            public void get__category(  String id,  HashMap<String, Object> filter, final ListCallback<Category> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__category", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            

                                //Now converting jsonObject to list
                                List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                List<Category> categoryList = new ArrayList<Category>();
                                CategoryRepository categoryRepo = getRestAdapter().createRepository(CategoryRepository.class);

                                for (Map<String, Object> obj : result) {
                                    Category category = categoryRepo.createObject(obj);
                                    categoryList.add(category);
                                }
                                callback.onSuccess(categoryList);
                            
                        }
                    });
                

            }//Method get__category definition ends here..

            

        
    
        
            //Method create__category definition
            public void create__category(  String id,  Category data, final ObjectCallback<Category> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__category", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                CategoryRepository categoryRepo = getRestAdapter().createRepository(CategoryRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Category category = categoryRepo.createObject(result);
                                callback.onSuccess(category);
                            
                        }
                    });
                

                

            }//Method create__category definition ends here..

            

        
    
        
            //Method delete__category definition
            public void delete__category(  String id, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__category", ImmutableMap.of("id", id), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method delete__category definition ends here..

            

        
    
        
            //Method count__category definition
            public void count__category(  String id,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__category", ImmutableMap.of("id", id, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method count__category definition ends here..

            

        
    
        
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

            

        
    
        
            //Method get__recipeTags definition
            public void get__recipeTags(  String id,  HashMap<String, Object> filter, final ListCallback<RecipeTag> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__recipeTags", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            

                                //Now converting jsonObject to list
                                List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                List<RecipeTag> recipeTagList = new ArrayList<RecipeTag>();
                                RecipeTagRepository recipeTagRepo = getRestAdapter().createRepository(RecipeTagRepository.class);

                                for (Map<String, Object> obj : result) {
                                    RecipeTag recipeTag = recipeTagRepo.createObject(obj);
                                    recipeTagList.add(recipeTag);
                                }
                                callback.onSuccess(recipeTagList);
                            
                        }
                    });
                

            }//Method get__recipeTags definition ends here..

            

        
    
        
            //Method create__recipeTags definition
            public void create__recipeTags(  String id,  RecipeTag data, final ObjectCallback<RecipeTag> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__recipeTags", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                RecipeTagRepository recipeTagRepo = getRestAdapter().createRepository(RecipeTagRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                RecipeTag recipeTag = recipeTagRepo.createObject(result);
                                callback.onSuccess(recipeTag);
                            
                        }
                    });
                

                

            }//Method create__recipeTags definition ends here..

            

        
    
        
            //Method delete__recipeTags definition
            public void delete__recipeTags(  String id, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__recipeTags", ImmutableMap.of("id", id), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method delete__recipeTags definition ends here..

            

        
    
        
            //Method count__recipeTags definition
            public void count__recipeTags(  String id,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__recipeTags", ImmutableMap.of("id", id, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method count__recipeTags definition ends here..

            

        
    
        
            //Method get__ingredients definition
            public void get__ingredients(  String id,  HashMap<String, Object> filter, final ListCallback<Ingredients> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__ingredients", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            

                                //Now converting jsonObject to list
                                List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                List<Ingredients> ingredientsList = new ArrayList<Ingredients>();
                                IngredientsRepository ingredientsRepo = getRestAdapter().createRepository(IngredientsRepository.class);

                                for (Map<String, Object> obj : result) {
                                    Ingredients ingredients = ingredientsRepo.createObject(obj);
                                    ingredientsList.add(ingredients);
                                }
                                callback.onSuccess(ingredientsList);
                            
                        }
                    });
                

            }//Method get__ingredients definition ends here..

            

        
    
        
            //Method create__ingredients definition
            public void create__ingredients(  String id,  Ingredients data, final ObjectCallback<Ingredients> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__ingredients", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                IngredientsRepository ingredientsRepo = getRestAdapter().createRepository(IngredientsRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Ingredients ingredients = ingredientsRepo.createObject(result);
                                callback.onSuccess(ingredients);
                            
                        }
                    });
                

                

            }//Method create__ingredients definition ends here..

            

        
    
        
            //Method delete__ingredients definition
            public void delete__ingredients(  String id, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__ingredients", ImmutableMap.of("id", id), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method delete__ingredients definition ends here..

            

        
    
        
            //Method count__ingredients definition
            public void count__ingredients(  String id,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__ingredients", ImmutableMap.of("id", id, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method count__ingredients definition ends here..

            

        
    
        
            //Method get__wishlists definition
            public void get__wishlists(  String id,  HashMap<String, Object> filter, final ListCallback<Wishlist> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__wishlists", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonArrayCallback() {
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

            

        
    
        
            //Method delete__wishlists definition
            public void delete__wishlists(  String id, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__wishlists", ImmutableMap.of("id", id), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method delete__wishlists definition ends here..

            

        
    
        
            //Method count__wishlists definition
            public void count__wishlists(  String id,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__wishlists", ImmutableMap.of("id", id, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method count__wishlists definition ends here..

            

        
    
        
            //Method create definition
            public void create(  HashMap<String, Object> data, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("create", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method create definition ends here..

            

        
    
        
            //Method createMany definition
            public void createMany(  HashMap<String, Object> data, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("createMany", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method createMany definition ends here..

            

        
    
        
            //Method upsert definition
            public void upsert(  HashMap<String, Object> data, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("upsert", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void findById(  String id,  HashMap<String, Object> filter, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("findById", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method findById definition ends here..

            

        
    
        
            //Method find definition
            public void find(  HashMap<String, Object> filter, final ListCallback<Recipe> callback){
                


                

                
                    invokeStaticMethod("find", ImmutableMap.of("filter", filter), new Adapter.JsonArrayCallback() {
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
                

            }//Method find definition ends here..

            

        
    
        
            //Method findOne definition
            public void findOne(  HashMap<String, Object> filter, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("findOne", ImmutableMap.of("filter", filter), new Adapter.JsonObjectCallback() {
                    
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
            public void updateAttributes(  String id,  HashMap<String, Object> data, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.updateAttributes", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
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
