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
import com.androidsdk.snaphy.snaphyandroidsdk.models.Cuisines;

//Now import model of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Recipe;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;
            
        
    





public class CuisinesRepository extends ModelRepository<Cuisines> {


    public CuisinesRepository(){
        super("Cuisines", null, Cuisines.class);
    }


    





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/:cuisinesId/recipes/:fk", "GET"), "Cuisines.prototype.__findById__recipes");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/:cuisinesId/recipes/:fk", "DELETE"), "Cuisines.prototype.__destroyById__recipes");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/:cuisinesId/recipes/:fk", "PUT"), "Cuisines.prototype.__updateById__recipes");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/:cuisinesId/recipes/rel/:fk", "PUT"), "Cuisines.prototype.__link__recipes");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/:cuisinesId/recipes/rel/:fk", "DELETE"), "Cuisines.prototype.__unlink__recipes");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/:cuisinesId/recipes/rel/:fk", "HEAD"), "Cuisines.prototype.__exists__recipes");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/:cuisinesId/recipes", "GET"), "Cuisines.prototype.__get__recipes");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/:cuisinesId/recipes", "POST"), "Cuisines.prototype.__create__recipes");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/:cuisinesId/recipes", "DELETE"), "Cuisines.prototype.__delete__recipes");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/:cuisinesId/recipes/count", "GET"), "Cuisines.prototype.__count__recipes");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/", "POST"), "Cuisines.create");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/", "POST"), "Cuisines.create");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/", "PUT"), "Cuisines.upsert");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/:id/exists", "GET"), "Cuisines.exists");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/:id", "GET"), "Cuisines.findById");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/", "GET"), "Cuisines.find");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/findOne", "GET"), "Cuisines.findOne");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/update", "POST"), "Cuisines.updateAll");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/:id", "DELETE"), "Cuisines.deleteById");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/count", "GET"), "Cuisines.count");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/:cuisinesId", "PUT"), "Cuisines.prototype.updateAttributes");
                

            
        
            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/getSchema", "POST"), "Cuisines.getSchema");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/getAbsoluteSchema", "POST"), "Cuisines.getAbsoluteSchema");
                

            
        
            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/__connect__recipes", "POST"), "Cuisines.__connect__recipes");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "Cuisines"  + "/__disconnect__recipes", "POST"), "Cuisines.__disconnect__recipes");
                

            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
        return contract;
    }


    //override getNameForRestUrlMethod
    public String  getNameForRestUrl() {
        
            return "Cuisines";
        
    }



    




    
        
            //Method findById__recipes definition
            public void findById__recipes(  String cuisinesId,  String fk, final ObjectCallback<Recipe> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("cuisinesId", cuisinesId);
                
                        hashMapObject.put("fk", fk);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__recipes", hashMapObject, new Adapter.JsonObjectCallback() {
                    
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
            public void destroyById__recipes(  String cuisinesId,  String fk, final VoidCallback callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("cuisinesId", cuisinesId);
                
                        hashMapObject.put("fk", fk);
                

                
                    invokeStaticMethod("prototype.__destroyById__recipes", hashMapObject, new Adapter.Callback() {
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
            public void updateById__recipes(  String cuisinesId,  String fk,  Map<String,  ? extends Object> data, final ObjectCallback<Recipe> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("cuisinesId", cuisinesId);
                
                        hashMapObject.put("fk", fk);
                
                        hashMapObject.putAll(data);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__recipes", hashMapObject, new Adapter.JsonObjectCallback() {
                    
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
            public void link__recipes(  String cuisinesId,  String fk, final ObjectCallback<Recipe> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("cuisinesId", cuisinesId);
                
                        hashMapObject.put("fk", fk);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.__link__recipes", hashMapObject, new Adapter.JsonObjectCallback() {
                    
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
            public void unlink__recipes(  String cuisinesId,  String fk, final VoidCallback callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("cuisinesId", cuisinesId);
                
                        hashMapObject.put("fk", fk);
                

                
                    invokeStaticMethod("prototype.__unlink__recipes", hashMapObject, new Adapter.Callback() {
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
            public void exists__recipes(  String cuisinesId,  String fk, final Adapter.JsonObjectCallback  callback ){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("cuisinesId", cuisinesId);
                
                        hashMapObject.put("fk", fk);
                

                


                
                    
                    invokeStaticMethod("prototype.__exists__recipes", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                    
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
            public void get__recipes(  String cuisinesId,  Map<String,  ? extends Object> filter, final ListCallback<Recipe> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("cuisinesId", cuisinesId);
                
                        hashMapObject.put("filter", filter);
                

                


                

                
                    invokeStaticMethod("prototype.__get__recipes", hashMapObject, new Adapter.JsonArrayCallback() {
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
            public void create__recipes(  String cuisinesId,  Map<String,  ? extends Object> data, final ObjectCallback<Recipe> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("cuisinesId", cuisinesId);
                
                        hashMapObject.putAll(data);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.__create__recipes", hashMapObject, new Adapter.JsonObjectCallback() {
                    
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
            public void delete__recipes(  String cuisinesId, final VoidCallback callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("cuisinesId", cuisinesId);
                

                
                    invokeStaticMethod("prototype.__delete__recipes", hashMapObject, new Adapter.Callback() {
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
            public void count__recipes(  String cuisinesId,  Map<String,  ? extends Object> where, final Adapter.JsonObjectCallback  callback ){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("cuisinesId", cuisinesId);
                
                        hashMapObject.put("where", where);
                

                


                
                    
                    invokeStaticMethod("prototype.__count__recipes", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                    
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
            public void create(  Map<String,  ? extends Object> data, final ObjectCallback<Cuisines> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.putAll(data);
                

                


                
                    
                    
                    invokeStaticMethod("create", hashMapObject, new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method create definition ends here..

            

        
    
        
            //Method createMany definition
            public void createMany(  Map<String,  ? extends Object> data, final ObjectCallback<Cuisines> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.putAll(data);
                

                


                
                    
                    
                    invokeStaticMethod("createMany", hashMapObject, new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method createMany definition ends here..

            

        
    
        
            //Method upsert definition
            public void upsert(  Map<String,  ? extends Object> data, final ObjectCallback<Cuisines> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.putAll(data);
                

                


                
                    
                    
                    invokeStaticMethod("upsert", hashMapObject, new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method upsert definition ends here..

            

        
    
        
            //Method exists definition
            public void exists(  String id, final Adapter.JsonObjectCallback  callback ){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("id", id);
                

                


                
                    
                    invokeStaticMethod("exists", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                    
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
            public void findById(  String id,  Map<String,  ? extends Object> filter, final ObjectCallback<Cuisines> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("id", id);
                
                        hashMapObject.put("filter", filter);
                

                


                
                    
                    
                    invokeStaticMethod("findById", hashMapObject, new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method findById definition ends here..

            

        
    
        
            //Method find definition
            public void find(  Map<String,  ? extends Object> filter, final ListCallback<Cuisines> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("filter", filter);
                

                


                

                
                    invokeStaticMethod("find", hashMapObject, new Adapter.JsonArrayCallback() {
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
                

            }//Method find definition ends here..

            

        
    
        
            //Method findOne definition
            public void findOne(  Map<String,  ? extends Object> filter, final ObjectCallback<Cuisines> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("filter", filter);
                

                


                
                    
                    
                    invokeStaticMethod("findOne", hashMapObject, new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method findOne definition ends here..

            

        
    
        
            //Method updateAll definition
            public void updateAll(  Map<String,  ? extends Object> where,  Map<String,  ? extends Object> data, final Adapter.JsonObjectCallback  callback ){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("where", where);
                
                        hashMapObject.putAll(data);
                

                


                
                    
                    invokeStaticMethod("updateAll", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                    
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

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("id", id);
                

                


                
                    
                    invokeStaticMethod("deleteById", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                    
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
            public void count(  Map<String,  ? extends Object> where, final Adapter.JsonObjectCallback  callback ){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("where", where);
                

                


                
                    
                    invokeStaticMethod("count", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                    
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
            public void updateAttributes(  String cuisinesId,  Map<String,  ? extends Object> data, final ObjectCallback<Cuisines> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("cuisinesId", cuisinesId);
                
                        hashMapObject.putAll(data);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.updateAttributes", hashMapObject, new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method updateAttributes definition ends here..

            

        
    
        
    
        
            //Method getSchema definition
            public void getSchema( final Adapter.JsonObjectCallback  callback ){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                

                


                
                    
                    invokeStaticMethod("getSchema", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                    
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

            

        
    
        
            //Method getAbsoluteSchema definition
            public void getAbsoluteSchema( final Adapter.JsonObjectCallback  callback ){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                

                


                
                    
                    invokeStaticMethod("getAbsoluteSchema", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method getAbsoluteSchema definition ends here..

            

        
    
        
    
        
            //Method __connect__recipes definition
            public void __connect__recipes(  String id,  List<String> fk, final Adapter.JsonObjectCallback  callback ){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("id", id);
                
                        hashMapObject.put("fk", fk);
                

                


                
                    
                    invokeStaticMethod("__connect__recipes", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method __connect__recipes definition ends here..

            

        
    
        
            //Method __disconnect__recipes definition
            public void __disconnect__recipes(  String id,  List<String> fk, final Adapter.JsonObjectCallback  callback ){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("id", id);
                
                        hashMapObject.put("fk", fk);
                

                


                
                    
                    invokeStaticMethod("__disconnect__recipes", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method __disconnect__recipes definition ends here..

            

        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    
        
    



}
