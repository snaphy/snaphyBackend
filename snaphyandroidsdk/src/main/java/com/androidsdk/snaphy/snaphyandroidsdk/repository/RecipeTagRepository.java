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
import com.androidsdk.snaphy.snaphyandroidsdk.models.RecipeTag;

//Now import model of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Recipe;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;
            
        
    





public class RecipeTagRepository extends ModelRepository<RecipeTag> {


    public RecipeTagRepository(){
        super("RecipeTag", null, RecipeTag.class);
    }





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeTagId/recipes/:fk", "GET"), "RecipeTag.prototype.__findById__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeTagId/recipes/:fk", "DELETE"), "RecipeTag.prototype.__destroyById__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeTagId/recipes/:fk", "PUT"), "RecipeTag.prototype.__updateById__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeTagId/recipes/rel/:fk", "PUT"), "RecipeTag.prototype.__link__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeTagId/recipes/rel/:fk", "DELETE"), "RecipeTag.prototype.__unlink__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeTagId/recipes/rel/:fk", "HEAD"), "RecipeTag.prototype.__exists__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeTagId/recipes", "GET"), "RecipeTag.prototype.__get__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeTagId/recipes", "POST"), "RecipeTag.prototype.__create__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeTagId/recipes", "DELETE"), "RecipeTag.prototype.__delete__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeTagId/recipes/count", "GET"), "RecipeTag.prototype.__count__recipes");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "RecipeTag.create");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "RecipeTag.create");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "PUT"), "RecipeTag.upsert");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/exists", "GET"), "RecipeTag.exists");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "GET"), "RecipeTag.findById");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "GET"), "RecipeTag.find");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/findOne", "GET"), "RecipeTag.findOne");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/update", "POST"), "RecipeTag.updateAll");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "DELETE"), "RecipeTag.deleteById");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/count", "GET"), "RecipeTag.count");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:recipeTagId", "PUT"), "RecipeTag.prototype.updateAttributes");
                

            
        
            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/getSchema", "POST"), "RecipeTag.getSchema");
                

            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
        return contract;
    }



    




    
        
            //Method findById__recipes definition
            public void findById__recipes(  String recipeTagId,  String fk, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__recipes", ImmutableMap.of("recipeTagId", recipeTagId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
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
            public void destroyById__recipes(  String recipeTagId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__recipes", ImmutableMap.of("recipeTagId", recipeTagId, "fk", fk), new Adapter.Callback() {
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
            public void updateById__recipes(  String recipeTagId,  String fk,  HashMap<String, Object> data, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__recipes", ImmutableMap.of("recipeTagId", recipeTagId, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void link__recipes(  String recipeTagId,  String fk, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__link__recipes", ImmutableMap.of("recipeTagId", recipeTagId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method link__recipes definition ends here..

            

        
    
        
            //Method unlink__recipes definition
            public void unlink__recipes(  String recipeTagId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__unlink__recipes", ImmutableMap.of("recipeTagId", recipeTagId, "fk", fk), new Adapter.Callback() {
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
            public void exists__recipes(  String recipeTagId,  String fk, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__exists__recipes", ImmutableMap.of("recipeTagId", recipeTagId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                    
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
            public void get__recipes(  String recipeTagId,  HashMap<String, Object> filter, final ListCallback<Recipe> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__recipes", ImmutableMap.of("recipeTagId", recipeTagId, "filter", filter), new Adapter.JsonArrayCallback() {
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
            public void create__recipes(  String recipeTagId,  HashMap<String, Object> data, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__recipes", ImmutableMap.of("recipeTagId", recipeTagId, "data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void delete__recipes(  String recipeTagId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__recipes", ImmutableMap.of("recipeTagId", recipeTagId), new Adapter.Callback() {
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
            public void count__recipes(  String recipeTagId,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__recipes", ImmutableMap.of("recipeTagId", recipeTagId, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
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
            public void create(  HashMap<String, Object> data, final ObjectCallback<RecipeTag> callback){
                


                
                    
                    
                    invokeStaticMethod("create", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method create definition ends here..

            

        
    
        
            //Method createMany definition
            public void createMany(  HashMap<String, Object> data, final ObjectCallback<RecipeTag> callback){
                


                
                    
                    
                    invokeStaticMethod("createMany", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method createMany definition ends here..

            

        
    
        
            //Method upsert definition
            public void upsert(  HashMap<String, Object> data, final ObjectCallback<RecipeTag> callback){
                


                
                    
                    
                    invokeStaticMethod("upsert", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void findById(  String id,  HashMap<String, Object> filter, final ObjectCallback<RecipeTag> callback){
                


                
                    
                    
                    invokeStaticMethod("findById", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method findById definition ends here..

            

        
    
        
            //Method find definition
            public void find(  HashMap<String, Object> filter, final ListCallback<RecipeTag> callback){
                


                

                
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
                

            }//Method find definition ends here..

            

        
    
        
            //Method findOne definition
            public void findOne(  HashMap<String, Object> filter, final ObjectCallback<RecipeTag> callback){
                


                
                    
                    
                    invokeStaticMethod("findOne", ImmutableMap.of("filter", filter), new Adapter.JsonObjectCallback() {
                    
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
            public void updateAttributes(  String recipeTagId,  HashMap<String, Object> data, final ObjectCallback<RecipeTag> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.updateAttributes", ImmutableMap.of("recipeTagId", recipeTagId, "data", data), new Adapter.JsonObjectCallback() {
                    
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
