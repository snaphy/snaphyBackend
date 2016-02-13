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
import com.androidsdk.snaphy.snaphyandroidsdk.models.Ingredients;

//Now import model of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.IngredientCategory;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.IngredientCategoryRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Recipe;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;
            
                import com.androidsdk.snaphy.snaphyandroidsdk.models.RecipeIngredients;
                import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeIngredientsRepository;
            
        
    





public class IngredientsRepository extends ModelRepository<Ingredients> {


    public IngredientsRepository(){
        super("Ingredients", null, Ingredients.class);
    }





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/:ingredientsId/ingredientCategory", "GET"), "Ingredients.prototype.__get__ingredientCategory");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/:ingredientsId/recipes/:fk", "GET"), "Ingredients.prototype.__findById__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/:ingredientsId/recipes/:fk", "DELETE"), "Ingredients.prototype.__destroyById__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/:ingredientsId/recipes/:fk", "PUT"), "Ingredients.prototype.__updateById__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/:ingredientsId/recipes/rel/:fk", "PUT"), "Ingredients.prototype.__link__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/:ingredientsId/recipes/rel/:fk", "DELETE"), "Ingredients.prototype.__unlink__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/:ingredientsId/recipes/rel/:fk", "HEAD"), "Ingredients.prototype.__exists__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/:ingredientsId/recipes", "GET"), "Ingredients.prototype.__get__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/:ingredientsId/recipes", "POST"), "Ingredients.prototype.__create__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/:ingredientsId/recipes", "DELETE"), "Ingredients.prototype.__delete__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/:ingredientsId/recipes/count", "GET"), "Ingredients.prototype.__count__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/", "POST"), "Ingredients.create");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/", "POST"), "Ingredients.create");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/", "PUT"), "Ingredients.upsert");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/:id/exists", "GET"), "Ingredients.exists");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/:id", "GET"), "Ingredients.findById");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/", "GET"), "Ingredients.find");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/findOne", "GET"), "Ingredients.findOne");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/update", "POST"), "Ingredients.updateAll");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/:id", "DELETE"), "Ingredients.deleteById");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/count", "GET"), "Ingredients.count");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/:ingredientsId", "PUT"), "Ingredients.prototype.updateAttributes");
                

            
        
            
        
            

                
                    contract.addItem(new RestContractItem("/" + "Ingredients"  + "/getSchema", "POST"), "Ingredients.getSchema");
                

            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
        return contract;
    }



    




    
        
            //Method get__ingredientCategory definition
            public void get__ingredientCategory(  String ingredientsId,  Boolean refresh, final ObjectCallback<IngredientCategory> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__get__ingredientCategory", ImmutableMap.of("ingredientsId", ingredientsId, "refresh", refresh), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    IngredientCategoryRepository ingredientCategoryRepo = getRestAdapter().createRepository(IngredientCategoryRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    IngredientCategory ingredientCategory = ingredientCategoryRepo.createObject(result);
                                    callback.onSuccess(ingredientCategory);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method get__ingredientCategory definition ends here..

            

        
    
        
            //Method findById__recipes definition
            public void findById__recipes(  String ingredientsId,  String fk, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__recipes", ImmutableMap.of("ingredientsId", ingredientsId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
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
            public void destroyById__recipes(  String ingredientsId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__recipes", ImmutableMap.of("ingredientsId", ingredientsId, "fk", fk), new Adapter.Callback() {
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
            public void updateById__recipes(  String ingredientsId,  String fk,  HashMap<String, Object> data, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__recipes", ImmutableMap.of("ingredientsId", ingredientsId, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
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

            

        
    
        
            //Method link__recipes definition
            public void link__recipes(  String ingredientsId,  String fk,  HashMap<String, Object> data, final ObjectCallback<RecipeIngredients> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__link__recipes", ImmutableMap.of("ingredientsId", ingredientsId, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method link__recipes definition ends here..

            

        
    
        
            //Method unlink__recipes definition
            public void unlink__recipes(  String ingredientsId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__unlink__recipes", ImmutableMap.of("ingredientsId", ingredientsId, "fk", fk), new Adapter.Callback() {
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
            public void exists__recipes(  String ingredientsId,  String fk, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__exists__recipes", ImmutableMap.of("ingredientsId", ingredientsId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                    
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
            public void get__recipes(  String ingredientsId,  HashMap<String, Object> filter, final ListCallback<Recipe> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__recipes", ImmutableMap.of("ingredientsId", ingredientsId, "filter", filter), new Adapter.JsonArrayCallback() {
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
            public void create__recipes(  String ingredientsId,  HashMap<String, Object> data, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__recipes", ImmutableMap.of("ingredientsId", ingredientsId, "data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void delete__recipes(  String ingredientsId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__recipes", ImmutableMap.of("ingredientsId", ingredientsId), new Adapter.Callback() {
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
            public void count__recipes(  String ingredientsId,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__recipes", ImmutableMap.of("ingredientsId", ingredientsId, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
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
            public void create(  HashMap<String, Object> data, final ObjectCallback<Ingredients> callback){
                


                
                    
                    
                    invokeStaticMethod("create", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method create definition ends here..

            

        
    
        
            //Method createMany definition
            public void createMany(  HashMap<String, Object> data, final ObjectCallback<Ingredients> callback){
                


                
                    
                    
                    invokeStaticMethod("createMany", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method createMany definition ends here..

            

        
    
        
            //Method upsert definition
            public void upsert(  HashMap<String, Object> data, final ObjectCallback<Ingredients> callback){
                


                
                    
                    
                    invokeStaticMethod("upsert", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void findById(  String id,  HashMap<String, Object> filter, final ObjectCallback<Ingredients> callback){
                


                
                    
                    
                    invokeStaticMethod("findById", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method findById definition ends here..

            

        
    
        
            //Method find definition
            public void find(  HashMap<String, Object> filter, final ListCallback<Ingredients> callback){
                


                

                
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
                

            }//Method find definition ends here..

            

        
    
        
            //Method findOne definition
            public void findOne(  HashMap<String, Object> filter, final ObjectCallback<Ingredients> callback){
                


                
                    
                    
                    invokeStaticMethod("findOne", ImmutableMap.of("filter", filter), new Adapter.JsonObjectCallback() {
                    
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
            public void updateAttributes(  String ingredientsId,  HashMap<String, Object> data, final ObjectCallback<Ingredients> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.updateAttributes", ImmutableMap.of("ingredientsId", ingredientsId, "data", data), new Adapter.JsonObjectCallback() {
                    
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
