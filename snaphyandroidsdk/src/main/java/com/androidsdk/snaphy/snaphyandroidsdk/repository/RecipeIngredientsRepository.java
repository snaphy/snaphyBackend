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
import com.androidsdk.snaphy.snaphyandroidsdk.models.RecipeIngredients;

//Now import model of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Recipe;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Ingredients;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.IngredientsRepository;
            
        
    





public class RecipeIngredientsRepository extends ModelRepository<RecipeIngredients> {


    public RecipeIngredientsRepository(){
        super("RecipeIngredients", null, RecipeIngredients.class);
    }





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipe", "GET"), "RecipeIngredients.prototype.__get__recipe");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients", "GET"), "RecipeIngredients.prototype.__get__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "RecipeIngredients.create");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "RecipeIngredients.create");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "PUT"), "RecipeIngredients.upsert");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/exists", "GET"), "RecipeIngredients.exists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "GET"), "RecipeIngredients.findById");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "GET"), "RecipeIngredients.find");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/findOne", "GET"), "RecipeIngredients.findOne");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/update", "POST"), "RecipeIngredients.updateAll");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "DELETE"), "RecipeIngredients.deleteById");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/count", "GET"), "RecipeIngredients.count");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "PUT"), "RecipeIngredients.prototype.updateAttributes");
            
        
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/getSchema", "POST"), "RecipeIngredients.getSchema");
            
        
            
        
        return contract;
    }



    




    
        
            //Method get__recipe definition
            public void get__recipe(  String id,  Boolean refresh, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__get__recipe", ImmutableMap.of("id", id, "refresh", refresh), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method get__recipe definition ends here..

            

        
    
        
            //Method get__ingredients definition
            public void get__ingredients(  String id,  Boolean refresh, final ObjectCallback<Ingredients> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__get__ingredients", ImmutableMap.of("id", id, "refresh", refresh), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method get__ingredients definition ends here..

            

        
    
        
            //Method create definition
            public void create(  HashMap<String, Object> data, final ObjectCallback<RecipeIngredients> callback){
                


                
                    
                    
                    invokeStaticMethod("create", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method create definition ends here..

            

        
    
        
            //Method createMany definition
            public void createMany(  HashMap<String, Object> data, final ObjectCallback<RecipeIngredients> callback){
                


                
                    
                    
                    invokeStaticMethod("createMany", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method createMany definition ends here..

            

        
    
        
            //Method upsert definition
            public void upsert(  HashMap<String, Object> data, final ObjectCallback<RecipeIngredients> callback){
                


                
                    
                    
                    invokeStaticMethod("upsert", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void findById(  String id,  HashMap<String, Object> filter, final ObjectCallback<RecipeIngredients> callback){
                


                
                    
                    
                    invokeStaticMethod("findById", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method findById definition ends here..

            

        
    
        
            //Method find definition
            public void find(  HashMap<String, Object> filter, final ListCallback<RecipeIngredients> callback){
                


                

                
                    invokeStaticMethod("find", ImmutableMap.of("filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            

                                //Now converting jsonObject to list
                                List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                List<RecipeIngredients> recipeIngredientsList = new ArrayList<RecipeIngredients>();
                                RecipeIngredientsRepository recipeIngredientsRepo = getRestAdapter().createRepository(RecipeIngredientsRepository.class);

                                for (Map<String, Object> obj : result) {
                                    RecipeIngredients recipeIngredients = recipeIngredientsRepo.createObject(obj);
                                    recipeIngredientsList.add(recipeIngredients);
                                }
                                callback.onSuccess(recipeIngredientsList);
                            
                        }
                    });
                

            }//Method find definition ends here..

            

        
    
        
            //Method findOne definition
            public void findOne(  HashMap<String, Object> filter, final ObjectCallback<RecipeIngredients> callback){
                


                
                    
                    
                    invokeStaticMethod("findOne", ImmutableMap.of("filter", filter), new Adapter.JsonObjectCallback() {
                    
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
            public void updateAttributes(  String id,  HashMap<String, Object> data, final ObjectCallback<RecipeIngredients> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.updateAttributes", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
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
