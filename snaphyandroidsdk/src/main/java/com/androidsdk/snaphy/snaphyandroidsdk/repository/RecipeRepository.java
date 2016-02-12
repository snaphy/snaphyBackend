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
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.RecipeAnalytic;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeAnalyticRepository;
            
        
    





public class RecipeRepository extends ModelRepository<Recipe> {


    public RecipeRepository(){
        super("Recipe", null, Recipe.class);
    }





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/customer", "GET"), "Recipe.prototype.__get__customer");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/cuisines/:fk", "GET"), "Recipe.prototype.__findById__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/cuisines/:fk", "DELETE"), "Recipe.prototype.__destroyById__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/cuisines/:fk", "PUT"), "Recipe.prototype.__updateById__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/cuisines/rel/:fk", "PUT"), "Recipe.prototype.__link__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/cuisines/rel/:fk", "DELETE"), "Recipe.prototype.__unlink__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/cuisines/rel/:fk", "HEAD"), "Recipe.prototype.__exists__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/category/:fk", "GET"), "Recipe.prototype.__findById__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/category/:fk", "DELETE"), "Recipe.prototype.__destroyById__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/category/:fk", "PUT"), "Recipe.prototype.__updateById__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/category/rel/:fk", "PUT"), "Recipe.prototype.__link__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/category/rel/:fk", "DELETE"), "Recipe.prototype.__unlink__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/category/rel/:fk", "HEAD"), "Recipe.prototype.__exists__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/comments/:fk", "GET"), "Recipe.prototype.__findById__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/comments/:fk", "DELETE"), "Recipe.prototype.__destroyById__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/comments/:fk", "PUT"), "Recipe.prototype.__updateById__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/recipeTags/:fk", "GET"), "Recipe.prototype.__findById__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/recipeTags/:fk", "DELETE"), "Recipe.prototype.__destroyById__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/recipeTags/:fk", "PUT"), "Recipe.prototype.__updateById__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/recipeTags/rel/:fk", "PUT"), "Recipe.prototype.__link__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/recipeTags/rel/:fk", "DELETE"), "Recipe.prototype.__unlink__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/recipeTags/rel/:fk", "HEAD"), "Recipe.prototype.__exists__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/ingredients/:fk", "GET"), "Recipe.prototype.__findById__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/ingredients/:fk", "DELETE"), "Recipe.prototype.__destroyById__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/ingredients/:fk", "PUT"), "Recipe.prototype.__updateById__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/ingredients/rel/:fk", "PUT"), "Recipe.prototype.__link__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/ingredients/rel/:fk", "DELETE"), "Recipe.prototype.__unlink__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/ingredients/rel/:fk", "HEAD"), "Recipe.prototype.__exists__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/wishlists/:fk", "GET"), "Recipe.prototype.__findById__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/wishlists/:fk", "DELETE"), "Recipe.prototype.__destroyById__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/wishlists/:fk", "PUT"), "Recipe.prototype.__updateById__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/wishlists/rel/:fk", "PUT"), "Recipe.prototype.__link__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/wishlists/rel/:fk", "DELETE"), "Recipe.prototype.__unlink__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/wishlists/rel/:fk", "HEAD"), "Recipe.prototype.__exists__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/recipeAnalytics", "GET"), "Recipe.prototype.__get__recipeAnalytics");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/recipeAnalytics", "POST"), "Recipe.prototype.__create__recipeAnalytics");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/recipeAnalytics", "PUT"), "Recipe.prototype.__update__recipeAnalytics");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/recipeAnalytics", "DELETE"), "Recipe.prototype.__destroy__recipeAnalytics");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/cuisines", "GET"), "Recipe.prototype.__get__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/cuisines", "POST"), "Recipe.prototype.__create__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/cuisines", "DELETE"), "Recipe.prototype.__delete__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/cuisines/count", "GET"), "Recipe.prototype.__count__cuisines");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/category", "GET"), "Recipe.prototype.__get__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/category", "POST"), "Recipe.prototype.__create__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/category", "DELETE"), "Recipe.prototype.__delete__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/category/count", "GET"), "Recipe.prototype.__count__category");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/comments", "GET"), "Recipe.prototype.__get__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/comments", "POST"), "Recipe.prototype.__create__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/comments", "DELETE"), "Recipe.prototype.__delete__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/comments/count", "GET"), "Recipe.prototype.__count__comments");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/recipeTags", "GET"), "Recipe.prototype.__get__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/recipeTags", "POST"), "Recipe.prototype.__create__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/recipeTags", "DELETE"), "Recipe.prototype.__delete__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/recipeTags/count", "GET"), "Recipe.prototype.__count__recipeTags");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/ingredients", "GET"), "Recipe.prototype.__get__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/ingredients", "POST"), "Recipe.prototype.__create__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/ingredients", "DELETE"), "Recipe.prototype.__delete__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/ingredients/count", "GET"), "Recipe.prototype.__count__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/wishlists", "GET"), "Recipe.prototype.__get__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/wishlists", "POST"), "Recipe.prototype.__create__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/wishlists", "DELETE"), "Recipe.prototype.__delete__wishlists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId/wishlists/count", "GET"), "Recipe.prototype.__count__wishlists");
            
        
            
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
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeId", "PUT"), "Recipe.prototype.updateAttributes");
            
        
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/getSchema", "POST"), "Recipe.getSchema");
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
        return contract;
    }



    




    
        
            //Method get__customer definition
            public void get__customer(  String recipeId,  Boolean refresh, final ObjectCallback<Customer> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__get__customer", ImmutableMap.of("recipeId", recipeId, "refresh", refresh), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method get__customer definition ends here..

            

        
    
        
            //Method findById__cuisines definition
            public void findById__cuisines(  String recipeId,  String fk, final ObjectCallback<Cuisines> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__cuisines", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CuisinesRepository cuisinesRepo = getRestAdapter().createRepository(CuisinesRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Cuisines cuisines = cuisinesRepo.createObject(result);
                                    callback.onSuccess(cuisines);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findById__cuisines definition ends here..

            

        
    
        
            //Method destroyById__cuisines definition
            public void destroyById__cuisines(  String recipeId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__cuisines", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.Callback() {
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
            public void updateById__cuisines(  String recipeId,  String fk,  HashMap<String, Object> data, final ObjectCallback<Cuisines> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__cuisines", ImmutableMap.of("recipeId", recipeId, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CuisinesRepository cuisinesRepo = getRestAdapter().createRepository(CuisinesRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Cuisines cuisines = cuisinesRepo.createObject(result);
                                    callback.onSuccess(cuisines);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method updateById__cuisines definition ends here..

            

        
    
        
            //Method link__cuisines definition
            public void link__cuisines(  String recipeId,  String fk, final ObjectCallback<Cuisines> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__link__cuisines", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CuisinesRepository cuisinesRepo = getRestAdapter().createRepository(CuisinesRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Cuisines cuisines = cuisinesRepo.createObject(result);
                                    callback.onSuccess(cuisines);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method link__cuisines definition ends here..

            

        
    
        
            //Method unlink__cuisines definition
            public void unlink__cuisines(  String recipeId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__unlink__cuisines", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.Callback() {
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
            public void exists__cuisines(  String recipeId,  String fk, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__exists__cuisines", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                    
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

            

        
    
        
            //Method findById__category definition
            public void findById__category(  String recipeId,  String fk, final ObjectCallback<Category> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__category", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CategoryRepository categoryRepo = getRestAdapter().createRepository(CategoryRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Category category = categoryRepo.createObject(result);
                                    callback.onSuccess(category);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findById__category definition ends here..

            

        
    
        
            //Method destroyById__category definition
            public void destroyById__category(  String recipeId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__category", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.Callback() {
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
            public void updateById__category(  String recipeId,  String fk,  HashMap<String, Object> data, final ObjectCallback<Category> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__category", ImmutableMap.of("recipeId", recipeId, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CategoryRepository categoryRepo = getRestAdapter().createRepository(CategoryRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Category category = categoryRepo.createObject(result);
                                    callback.onSuccess(category);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method updateById__category definition ends here..

            

        
    
        
            //Method link__category definition
            public void link__category(  String recipeId,  String fk, final ObjectCallback<Category> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__link__category", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CategoryRepository categoryRepo = getRestAdapter().createRepository(CategoryRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Category category = categoryRepo.createObject(result);
                                    callback.onSuccess(category);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method link__category definition ends here..

            

        
    
        
            //Method unlink__category definition
            public void unlink__category(  String recipeId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__unlink__category", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.Callback() {
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
            public void exists__category(  String recipeId,  String fk, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__exists__category", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                    
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
            public void findById__comments(  String recipeId,  String fk, final ObjectCallback<Comments> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__comments", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
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
            public void destroyById__comments(  String recipeId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__comments", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.Callback() {
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
            public void updateById__comments(  String recipeId,  String fk,  HashMap<String, Object> data, final ObjectCallback<Comments> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__comments", ImmutableMap.of("recipeId", recipeId, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
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

            

        
    
        
            //Method findById__recipeTags definition
            public void findById__recipeTags(  String recipeId,  String fk, final ObjectCallback<RecipeTag> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__recipeTags", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    RecipeTagRepository recipeTagRepo = getRestAdapter().createRepository(RecipeTagRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    RecipeTag recipeTag = recipeTagRepo.createObject(result);
                                    callback.onSuccess(recipeTag);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findById__recipeTags definition ends here..

            

        
    
        
            //Method destroyById__recipeTags definition
            public void destroyById__recipeTags(  String recipeId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__recipeTags", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.Callback() {
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
            public void updateById__recipeTags(  String recipeId,  String fk,  HashMap<String, Object> data, final ObjectCallback<RecipeTag> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__recipeTags", ImmutableMap.of("recipeId", recipeId, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    RecipeTagRepository recipeTagRepo = getRestAdapter().createRepository(RecipeTagRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    RecipeTag recipeTag = recipeTagRepo.createObject(result);
                                    callback.onSuccess(recipeTag);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method updateById__recipeTags definition ends here..

            

        
    
        
            //Method link__recipeTags definition
            public void link__recipeTags(  String recipeId,  String fk, final ObjectCallback<RecipeTag> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__link__recipeTags", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    RecipeTagRepository recipeTagRepo = getRestAdapter().createRepository(RecipeTagRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    RecipeTag recipeTag = recipeTagRepo.createObject(result);
                                    callback.onSuccess(recipeTag);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method link__recipeTags definition ends here..

            

        
    
        
            //Method unlink__recipeTags definition
            public void unlink__recipeTags(  String recipeId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__unlink__recipeTags", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.Callback() {
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
            public void exists__recipeTags(  String recipeId,  String fk, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__exists__recipeTags", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                    
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
            public void findById__ingredients(  String recipeId,  String fk, final ObjectCallback<Ingredients> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__ingredients", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    IngredientsRepository ingredientsRepo = getRestAdapter().createRepository(IngredientsRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Ingredients ingredients = ingredientsRepo.createObject(result);
                                    callback.onSuccess(ingredients);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findById__ingredients definition ends here..

            

        
    
        
            //Method destroyById__ingredients definition
            public void destroyById__ingredients(  String recipeId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__ingredients", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.Callback() {
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
            public void updateById__ingredients(  String recipeId,  String fk,  HashMap<String, Object> data, final ObjectCallback<Ingredients> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__ingredients", ImmutableMap.of("recipeId", recipeId, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    IngredientsRepository ingredientsRepo = getRestAdapter().createRepository(IngredientsRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Ingredients ingredients = ingredientsRepo.createObject(result);
                                    callback.onSuccess(ingredients);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method updateById__ingredients definition ends here..

            

        
    
        
            //Method link__ingredients definition
            public void link__ingredients(  String recipeId,  String fk,  HashMap<String, Object> data, final ObjectCallback<RecipeIngredients> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__link__ingredients", ImmutableMap.of("recipeId", recipeId, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    RecipeIngredientsRepository recipeIngredientsRepo = getRestAdapter().createRepository(RecipeIngredientsRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    RecipeIngredients recipeIngredients = recipeIngredientsRepo.createObject(result);
                                    callback.onSuccess(recipeIngredients);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method link__ingredients definition ends here..

            

        
    
        
            //Method unlink__ingredients definition
            public void unlink__ingredients(  String recipeId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__unlink__ingredients", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.Callback() {
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
            public void exists__ingredients(  String recipeId,  String fk, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__exists__ingredients", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                    
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
            public void findById__wishlists(  String recipeId,  String fk, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__wishlists", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method findById__wishlists definition ends here..

            

        
    
        
            //Method destroyById__wishlists definition
            public void destroyById__wishlists(  String recipeId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__wishlists", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.Callback() {
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
            public void updateById__wishlists(  String recipeId,  String fk,  HashMap<String, Object> data, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__wishlists", ImmutableMap.of("recipeId", recipeId, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method updateById__wishlists definition ends here..

            

        
    
        
            //Method link__wishlists definition
            public void link__wishlists(  String recipeId,  String fk, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__link__wishlists", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method link__wishlists definition ends here..

            

        
    
        
            //Method unlink__wishlists definition
            public void unlink__wishlists(  String recipeId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__unlink__wishlists", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.Callback() {
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
            public void exists__wishlists(  String recipeId,  String fk, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__exists__wishlists", ImmutableMap.of("recipeId", recipeId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                    
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

            

        
    
        
            //Method get__recipeAnalytics definition
            public void get__recipeAnalytics(  String recipeId,  Boolean refresh, final ObjectCallback<RecipeAnalytic> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__get__recipeAnalytics", ImmutableMap.of("recipeId", recipeId, "refresh", refresh), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method get__recipeAnalytics definition ends here..

            

        
    
        
            //Method create__recipeAnalytics definition
            public void create__recipeAnalytics(  String recipeId,  HashMap<String, Object> data, final ObjectCallback<RecipeAnalytic> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__recipeAnalytics", ImmutableMap.of("recipeId", recipeId, "data", data), new Adapter.JsonObjectCallback() {
                    
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

            

        
    
        
            //Method update__recipeAnalytics definition
            public void update__recipeAnalytics(  String recipeId,  HashMap<String, Object> data, final ObjectCallback<RecipeAnalytic> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__update__recipeAnalytics", ImmutableMap.of("recipeId", recipeId, "data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method update__recipeAnalytics definition ends here..

            

        
    
        
            //Method destroy__recipeAnalytics definition
            public void destroy__recipeAnalytics(  String recipeId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroy__recipeAnalytics", ImmutableMap.of("recipeId", recipeId), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroy__recipeAnalytics definition ends here..

            

        
    
        
            //Method get__cuisines definition
            public void get__cuisines(  String recipeId,  HashMap<String, Object> filter, final ListCallback<Cuisines> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__cuisines", ImmutableMap.of("recipeId", recipeId, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            
                                if(response != null){
                                    //Now converting jsonObject to list
                                    List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                    List<Cuisines> cuisinesList = new ArrayList<Cuisines>();
                                    CuisinesRepository cuisinesRepo = getRestAdapter().createRepository(CuisinesRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        Cuisines cuisines = cuisinesRepo.createObject(obj);
                                        cuisinesList.add(cuisines);
                                    }
                                    callback.onSuccess(cuisinesList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method get__cuisines definition ends here..

            

        
    
        
            //Method create__cuisines definition
            public void create__cuisines(  String recipeId,  HashMap<String, Object> data, final ObjectCallback<Cuisines> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__cuisines", ImmutableMap.of("recipeId", recipeId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CuisinesRepository cuisinesRepo = getRestAdapter().createRepository(CuisinesRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Cuisines cuisines = cuisinesRepo.createObject(result);
                                    callback.onSuccess(cuisines);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__cuisines definition ends here..

            

        
    
        
            //Method delete__cuisines definition
            public void delete__cuisines(  String recipeId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__cuisines", ImmutableMap.of("recipeId", recipeId), new Adapter.Callback() {
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
            public void count__cuisines(  String recipeId,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__cuisines", ImmutableMap.of("recipeId", recipeId, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
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
            public void get__category(  String recipeId,  HashMap<String, Object> filter, final ListCallback<Category> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__category", ImmutableMap.of("recipeId", recipeId, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            
                                if(response != null){
                                    //Now converting jsonObject to list
                                    List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                    List<Category> categoryList = new ArrayList<Category>();
                                    CategoryRepository categoryRepo = getRestAdapter().createRepository(CategoryRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        Category category = categoryRepo.createObject(obj);
                                        categoryList.add(category);
                                    }
                                    callback.onSuccess(categoryList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method get__category definition ends here..

            

        
    
        
            //Method create__category definition
            public void create__category(  String recipeId,  HashMap<String, Object> data, final ObjectCallback<Category> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__category", ImmutableMap.of("recipeId", recipeId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CategoryRepository categoryRepo = getRestAdapter().createRepository(CategoryRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Category category = categoryRepo.createObject(result);
                                    callback.onSuccess(category);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__category definition ends here..

            

        
    
        
            //Method delete__category definition
            public void delete__category(  String recipeId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__category", ImmutableMap.of("recipeId", recipeId), new Adapter.Callback() {
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
            public void count__category(  String recipeId,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__category", ImmutableMap.of("recipeId", recipeId, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
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
            public void get__comments(  String recipeId,  HashMap<String, Object> filter, final ListCallback<Comments> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__comments", ImmutableMap.of("recipeId", recipeId, "filter", filter), new Adapter.JsonArrayCallback() {
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
            public void create__comments(  String recipeId,  HashMap<String, Object> data, final ObjectCallback<Comments> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__comments", ImmutableMap.of("recipeId", recipeId, "data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void delete__comments(  String recipeId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__comments", ImmutableMap.of("recipeId", recipeId), new Adapter.Callback() {
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
            public void count__comments(  String recipeId,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__comments", ImmutableMap.of("recipeId", recipeId, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
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
            public void get__recipeTags(  String recipeId,  HashMap<String, Object> filter, final ListCallback<RecipeTag> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__recipeTags", ImmutableMap.of("recipeId", recipeId, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            
                                if(response != null){
                                    //Now converting jsonObject to list
                                    List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                    List<RecipeTag> recipeTagList = new ArrayList<RecipeTag>();
                                    RecipeTagRepository recipeTagRepo = getRestAdapter().createRepository(RecipeTagRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        RecipeTag recipeTag = recipeTagRepo.createObject(obj);
                                        recipeTagList.add(recipeTag);
                                    }
                                    callback.onSuccess(recipeTagList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method get__recipeTags definition ends here..

            

        
    
        
            //Method create__recipeTags definition
            public void create__recipeTags(  String recipeId,  HashMap<String, Object> data, final ObjectCallback<RecipeTag> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__recipeTags", ImmutableMap.of("recipeId", recipeId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    RecipeTagRepository recipeTagRepo = getRestAdapter().createRepository(RecipeTagRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    RecipeTag recipeTag = recipeTagRepo.createObject(result);
                                    callback.onSuccess(recipeTag);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__recipeTags definition ends here..

            

        
    
        
            //Method delete__recipeTags definition
            public void delete__recipeTags(  String recipeId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__recipeTags", ImmutableMap.of("recipeId", recipeId), new Adapter.Callback() {
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
            public void count__recipeTags(  String recipeId,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__recipeTags", ImmutableMap.of("recipeId", recipeId, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
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
            public void get__ingredients(  String recipeId,  HashMap<String, Object> filter, final ListCallback<Ingredients> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__ingredients", ImmutableMap.of("recipeId", recipeId, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            
                                if(response != null){
                                    //Now converting jsonObject to list
                                    List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                    List<Ingredients> ingredientsList = new ArrayList<Ingredients>();
                                    IngredientsRepository ingredientsRepo = getRestAdapter().createRepository(IngredientsRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        Ingredients ingredients = ingredientsRepo.createObject(obj);
                                        ingredientsList.add(ingredients);
                                    }
                                    callback.onSuccess(ingredientsList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method get__ingredients definition ends here..

            

        
    
        
            //Method create__ingredients definition
            public void create__ingredients(  String recipeId,  HashMap<String, Object> data, final ObjectCallback<Ingredients> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__ingredients", ImmutableMap.of("recipeId", recipeId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    IngredientsRepository ingredientsRepo = getRestAdapter().createRepository(IngredientsRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Ingredients ingredients = ingredientsRepo.createObject(result);
                                    callback.onSuccess(ingredients);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__ingredients definition ends here..

            

        
    
        
            //Method delete__ingredients definition
            public void delete__ingredients(  String recipeId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__ingredients", ImmutableMap.of("recipeId", recipeId), new Adapter.Callback() {
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
            public void count__ingredients(  String recipeId,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__ingredients", ImmutableMap.of("recipeId", recipeId, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
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
            public void get__wishlists(  String recipeId,  HashMap<String, Object> filter, final ListCallback<Wishlist> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__wishlists", ImmutableMap.of("recipeId", recipeId, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            
                                if(response != null){
                                    //Now converting jsonObject to list
                                    List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                    List<Wishlist> wishlistList = new ArrayList<Wishlist>();
                                    WishlistRepository wishlistRepo = getRestAdapter().createRepository(WishlistRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        Wishlist wishlist = wishlistRepo.createObject(obj);
                                        wishlistList.add(wishlist);
                                    }
                                    callback.onSuccess(wishlistList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method get__wishlists definition ends here..

            

        
    
        
            //Method create__wishlists definition
            public void create__wishlists(  String recipeId,  HashMap<String, Object> data, final ObjectCallback<Wishlist> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__wishlists", ImmutableMap.of("recipeId", recipeId, "data", data), new Adapter.JsonObjectCallback() {
                    
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

            

        
    
        
            //Method delete__wishlists definition
            public void delete__wishlists(  String recipeId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__wishlists", ImmutableMap.of("recipeId", recipeId), new Adapter.Callback() {
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
            public void count__wishlists(  String recipeId,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__wishlists", ImmutableMap.of("recipeId", recipeId, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
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
            public void updateAttributes(  String recipeId,  HashMap<String, Object> data, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.updateAttributes", ImmutableMap.of("recipeId", recipeId, "data", data), new Adapter.JsonObjectCallback() {
                    
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
