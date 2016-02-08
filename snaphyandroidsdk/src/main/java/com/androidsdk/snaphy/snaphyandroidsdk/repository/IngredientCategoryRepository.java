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
import com.androidsdk.snaphy.snaphyandroidsdk.models.IngredientCategory;

//Now import model of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Ingredients;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.IngredientsRepository;
            
        
    





public class IngredientCategoryRepository extends ModelRepository<IngredientCategory> {


    public IngredientCategoryRepository(){
        super("IngredientCategory", null, IngredientCategory.class);
    }





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients/:fk", "GET"), "IngredientCategory.prototype.__findById__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients/:fk", "DELETE"), "IngredientCategory.prototype.__destroyById__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients/:fk", "PUT"), "IngredientCategory.prototype.__updateById__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients", "GET"), "IngredientCategory.prototype.__get__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients", "POST"), "IngredientCategory.prototype.__create__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients", "DELETE"), "IngredientCategory.prototype.__delete__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/ingredients/count", "GET"), "IngredientCategory.prototype.__count__ingredients");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "IngredientCategory.create");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "IngredientCategory.create");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "PUT"), "IngredientCategory.upsert");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/exists", "GET"), "IngredientCategory.exists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "GET"), "IngredientCategory.findById");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "GET"), "IngredientCategory.find");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/findOne", "GET"), "IngredientCategory.findOne");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/update", "POST"), "IngredientCategory.updateAll");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "DELETE"), "IngredientCategory.deleteById");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/count", "GET"), "IngredientCategory.count");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "PUT"), "IngredientCategory.prototype.updateAttributes");
            
        
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/getSchema", "POST"), "IngredientCategory.getSchema");
            
        
            
        
            
        
        return contract;
    }



    




    
        
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

            

        
    
        
            //Method create definition
            public void create(  HashMap<String, Object> data, final ObjectCallback<IngredientCategory> callback){
                


                
                    
                    
                    invokeStaticMethod("create", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                IngredientCategoryRepository ingredientCategoryRepo = getRestAdapter().createRepository(IngredientCategoryRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                IngredientCategory ingredientCategory = ingredientCategoryRepo.createObject(result);
                                callback.onSuccess(ingredientCategory);
                            
                        }
                    });
                

                

            }//Method create definition ends here..

            

        
    
        
            //Method createMany definition
            public void createMany(  HashMap<String, Object> data, final ObjectCallback<IngredientCategory> callback){
                


                
                    
                    
                    invokeStaticMethod("createMany", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                IngredientCategoryRepository ingredientCategoryRepo = getRestAdapter().createRepository(IngredientCategoryRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                IngredientCategory ingredientCategory = ingredientCategoryRepo.createObject(result);
                                callback.onSuccess(ingredientCategory);
                            
                        }
                    });
                

                

            }//Method createMany definition ends here..

            

        
    
        
            //Method upsert definition
            public void upsert(  HashMap<String, Object> data, final ObjectCallback<IngredientCategory> callback){
                


                
                    
                    
                    invokeStaticMethod("upsert", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                IngredientCategoryRepository ingredientCategoryRepo = getRestAdapter().createRepository(IngredientCategoryRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                IngredientCategory ingredientCategory = ingredientCategoryRepo.createObject(result);
                                callback.onSuccess(ingredientCategory);
                            
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
            public void findById(  String id,  HashMap<String, Object> filter, final ObjectCallback<IngredientCategory> callback){
                


                
                    
                    
                    invokeStaticMethod("findById", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                IngredientCategoryRepository ingredientCategoryRepo = getRestAdapter().createRepository(IngredientCategoryRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                IngredientCategory ingredientCategory = ingredientCategoryRepo.createObject(result);
                                callback.onSuccess(ingredientCategory);
                            
                        }
                    });
                

                

            }//Method findById definition ends here..

            

        
    
        
            //Method find definition
            public void find(  HashMap<String, Object> filter, final ListCallback<IngredientCategory> callback){
                


                

                
                    invokeStaticMethod("find", ImmutableMap.of("filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            

                                //Now converting jsonObject to list
                                List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                List<IngredientCategory> ingredientCategoryList = new ArrayList<IngredientCategory>();
                                IngredientCategoryRepository ingredientCategoryRepo = getRestAdapter().createRepository(IngredientCategoryRepository.class);

                                for (Map<String, Object> obj : result) {
                                    IngredientCategory ingredientCategory = ingredientCategoryRepo.createObject(obj);
                                    ingredientCategoryList.add(ingredientCategory);
                                }
                                callback.onSuccess(ingredientCategoryList);
                            
                        }
                    });
                

            }//Method find definition ends here..

            

        
    
        
            //Method findOne definition
            public void findOne(  HashMap<String, Object> filter, final ObjectCallback<IngredientCategory> callback){
                


                
                    
                    
                    invokeStaticMethod("findOne", ImmutableMap.of("filter", filter), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                IngredientCategoryRepository ingredientCategoryRepo = getRestAdapter().createRepository(IngredientCategoryRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                IngredientCategory ingredientCategory = ingredientCategoryRepo.createObject(result);
                                callback.onSuccess(ingredientCategory);
                            
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
            public void updateAttributes(  String id,  HashMap<String, Object> data, final ObjectCallback<IngredientCategory> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.updateAttributes", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                IngredientCategoryRepository ingredientCategoryRepo = getRestAdapter().createRepository(IngredientCategoryRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                IngredientCategory ingredientCategory = ingredientCategoryRepo.createObject(result);
                                callback.onSuccess(ingredientCategory);
                            
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
