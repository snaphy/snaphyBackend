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
import com.androidsdk.snaphy.snaphyandroidsdk.models.Priority;

//Now import model of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Recipe;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;
            
        
    





public class PriorityRepository extends ModelRepository<Priority> {


    public PriorityRepository(){
        super("Priority", null, Priority.class);
    }





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes", "GET"), "Priority.prototype.__get__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes", "POST"), "Priority.prototype.__create__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes", "PUT"), "Priority.prototype.__update__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/recipes", "DELETE"), "Priority.prototype.__destroy__recipes");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "Priority.create");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "Priority.create");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "PUT"), "Priority.upsert");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/exists", "GET"), "Priority.exists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "GET"), "Priority.findById");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "GET"), "Priority.find");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/findOne", "GET"), "Priority.findOne");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/update", "POST"), "Priority.updateAll");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "DELETE"), "Priority.deleteById");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/count", "GET"), "Priority.count");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "PUT"), "Priority.prototype.updateAttributes");
            
        
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/getSchema", "POST"), "Priority.getSchema");
            
        
            
        
            
        
            
        
            
        
            
        
            
        
        return contract;
    }



    




    
        
            //Method get__recipes definition
            public void get__recipes(  String id,  Boolean refresh, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__get__recipes", ImmutableMap.of("id", id, "refresh", refresh), new Adapter.JsonObjectCallback() {
                    
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

            

        
    
        
            //Method update__recipes definition
            public void update__recipes(  String id,  Recipe data, final ObjectCallback<Recipe> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__update__recipes", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method update__recipes definition ends here..

            

        
    
        
            //Method destroy__recipes definition
            public void destroy__recipes(  String id, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroy__recipes", ImmutableMap.of("id", id), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroy__recipes definition ends here..

            

        
    
        
            //Method create definition
            public void create(  HashMap<String, Object> data, final ObjectCallback<Priority> callback){
                


                
                    
                    
                    invokeStaticMethod("create", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method create definition ends here..

            

        
    
        
            //Method createMany definition
            public void createMany(  HashMap<String, Object> data, final ObjectCallback<Priority> callback){
                


                
                    
                    
                    invokeStaticMethod("createMany", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method createMany definition ends here..

            

        
    
        
            //Method upsert definition
            public void upsert(  HashMap<String, Object> data, final ObjectCallback<Priority> callback){
                


                
                    
                    
                    invokeStaticMethod("upsert", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void findById(  String id,  HashMap<String, Object> filter, final ObjectCallback<Priority> callback){
                


                
                    
                    
                    invokeStaticMethod("findById", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method findById definition ends here..

            

        
    
        
            //Method find definition
            public void find(  HashMap<String, Object> filter, final ListCallback<Priority> callback){
                


                

                
                    invokeStaticMethod("find", ImmutableMap.of("filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            

                                //Now converting jsonObject to list
                                List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                List<Priority> priorityList = new ArrayList<Priority>();
                                PriorityRepository priorityRepo = getRestAdapter().createRepository(PriorityRepository.class);

                                for (Map<String, Object> obj : result) {
                                    Priority priority = priorityRepo.createObject(obj);
                                    priorityList.add(priority);
                                }
                                callback.onSuccess(priorityList);
                            
                        }
                    });
                

            }//Method find definition ends here..

            

        
    
        
            //Method findOne definition
            public void findOne(  HashMap<String, Object> filter, final ObjectCallback<Priority> callback){
                


                
                    
                    
                    invokeStaticMethod("findOne", ImmutableMap.of("filter", filter), new Adapter.JsonObjectCallback() {
                    
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
            public void updateAttributes(  String id,  HashMap<String, Object> data, final ObjectCallback<Priority> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.updateAttributes", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
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
