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
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.OrderDetail;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.OrderDetailRepository;
            
        
    





public class RecipeIngredientsRepository extends ModelRepository<RecipeIngredients> {


    public RecipeIngredientsRepository(){
        super("RecipeIngredients", null, RecipeIngredients.class);
    }


    





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/:recipeIngredientsId/recipe", "GET"), "RecipeIngredients.prototype.__get__recipe");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/:recipeIngredientsId/ingredients", "GET"), "RecipeIngredients.prototype.__get__ingredients");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/:recipeIngredientsId/orderDetails", "GET"), "RecipeIngredients.prototype.__get__orderDetails");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/:recipeIngredientsId/orderDetails", "POST"), "RecipeIngredients.prototype.__create__orderDetails");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/:recipeIngredientsId/orderDetails", "PUT"), "RecipeIngredients.prototype.__update__orderDetails");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/:recipeIngredientsId/orderDetails", "DELETE"), "RecipeIngredients.prototype.__destroy__orderDetails");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/", "POST"), "RecipeIngredients.create");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/", "POST"), "RecipeIngredients.create");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/", "PUT"), "RecipeIngredients.upsert");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/:id/exists", "GET"), "RecipeIngredients.exists");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/:id", "GET"), "RecipeIngredients.findById");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/", "GET"), "RecipeIngredients.find");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/findOne", "GET"), "RecipeIngredients.findOne");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/update", "POST"), "RecipeIngredients.updateAll");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/:id", "DELETE"), "RecipeIngredients.deleteById");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/count", "GET"), "RecipeIngredients.count");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/:recipeIngredientsId", "PUT"), "RecipeIngredients.prototype.updateAttributes");
                

            
        
            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/getSchema", "POST"), "RecipeIngredients.getSchema");
                

            
        
            

                

                    contract.addItem(new RestContractItem("/" + "RecipeIngredients"  + "/getAbsoluteSchema", "POST"), "RecipeIngredients.getAbsoluteSchema");
                

            
        
            
        
            
        
            
        
            
        
            
        
            
        
        return contract;
    }


    //override getNameForRestUrlMethod
    public String  getNameForRestUrl() {
        
            return "RecipeIngredients";
        
    }



    




    
        
            //Method get__recipe definition
            public void get__recipe(  String recipeIngredientsId,  Boolean refresh, final ObjectCallback<Recipe> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("recipeIngredientsId", recipeIngredientsId);
                
                        hashMapObject.put("refresh", refresh);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.__get__recipe", hashMapObject, new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method get__recipe definition ends here..

            

        
    
        
            //Method get__ingredients definition
            public void get__ingredients(  String recipeIngredientsId,  Boolean refresh, final ObjectCallback<Ingredients> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("recipeIngredientsId", recipeIngredientsId);
                
                        hashMapObject.put("refresh", refresh);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.__get__ingredients", hashMapObject, new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method get__ingredients definition ends here..

            

        
    
        
            //Method get__orderDetails definition
            public void get__orderDetails(  String recipeIngredientsId,  Boolean refresh, final ObjectCallback<OrderDetail> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("recipeIngredientsId", recipeIngredientsId);
                
                        hashMapObject.put("refresh", refresh);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.__get__orderDetails", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    OrderDetailRepository orderDetailRepo = getRestAdapter().createRepository(OrderDetailRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    OrderDetail orderDetail = orderDetailRepo.createObject(result);
                                    callback.onSuccess(orderDetail);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method get__orderDetails definition ends here..

            

        
    
        
            //Method create__orderDetails definition
            public void create__orderDetails(  String recipeIngredientsId,  Map<String,  ? extends Object> data, final ObjectCallback<OrderDetail> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("recipeIngredientsId", recipeIngredientsId);
                
                        hashMapObject.putAll(data);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.__create__orderDetails", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    OrderDetailRepository orderDetailRepo = getRestAdapter().createRepository(OrderDetailRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    OrderDetail orderDetail = orderDetailRepo.createObject(result);
                                    callback.onSuccess(orderDetail);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__orderDetails definition ends here..

            

        
    
        
            //Method update__orderDetails definition
            public void update__orderDetails(  String recipeIngredientsId,  Map<String,  ? extends Object> data, final ObjectCallback<OrderDetail> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("recipeIngredientsId", recipeIngredientsId);
                
                        hashMapObject.putAll(data);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.__update__orderDetails", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    OrderDetailRepository orderDetailRepo = getRestAdapter().createRepository(OrderDetailRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    OrderDetail orderDetail = orderDetailRepo.createObject(result);
                                    callback.onSuccess(orderDetail);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method update__orderDetails definition ends here..

            

        
    
        
            //Method destroy__orderDetails definition
            public void destroy__orderDetails(  String recipeIngredientsId, final VoidCallback callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("recipeIngredientsId", recipeIngredientsId);
                

                
                    invokeStaticMethod("prototype.__destroy__orderDetails", hashMapObject, new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroy__orderDetails definition ends here..

            

        
    
        
            //Method create definition
            public void create(  Map<String,  ? extends Object> data, final ObjectCallback<RecipeIngredients> callback){

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
                                    RecipeIngredientsRepository recipeIngredientsRepo = getRestAdapter().createRepository(RecipeIngredientsRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    RecipeIngredients recipeIngredients = recipeIngredientsRepo.createObject(result);
                                    callback.onSuccess(recipeIngredients);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create definition ends here..

            

        
    
        
        
            //Method upsert definition
            public void upsert(  Map<String,  ? extends Object> data, final ObjectCallback<RecipeIngredients> callback){

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
                                    RecipeIngredientsRepository recipeIngredientsRepo = getRestAdapter().createRepository(RecipeIngredientsRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    RecipeIngredients recipeIngredients = recipeIngredientsRepo.createObject(result);
                                    callback.onSuccess(recipeIngredients);

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
            public void findById(  String id,  Map<String,  ? extends Object> filter, final ObjectCallback<RecipeIngredients> callback){

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
                                    RecipeIngredientsRepository recipeIngredientsRepo = getRestAdapter().createRepository(RecipeIngredientsRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    RecipeIngredients recipeIngredients = recipeIngredientsRepo.createObject(result);
                                    callback.onSuccess(recipeIngredients);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findById definition ends here..

            

        
    
        
            //Method find definition
            public void find(  Map<String,  ? extends Object> filter, final ListCallback<RecipeIngredients> callback){

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
                                    List<RecipeIngredients> recipeIngredientsList = new ArrayList<RecipeIngredients>();
                                    RecipeIngredientsRepository recipeIngredientsRepo = getRestAdapter().createRepository(RecipeIngredientsRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        RecipeIngredients recipeIngredients = recipeIngredientsRepo.createObject(obj);
                                        recipeIngredientsList.add(recipeIngredients);
                                    }
                                    callback.onSuccess(recipeIngredientsList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method find definition ends here..

            

        
    
        
            //Method findOne definition
            public void findOne(  Map<String,  ? extends Object> filter, final ObjectCallback<RecipeIngredients> callback){

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
                                    RecipeIngredientsRepository recipeIngredientsRepo = getRestAdapter().createRepository(RecipeIngredientsRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    RecipeIngredients recipeIngredients = recipeIngredientsRepo.createObject(result);
                                    callback.onSuccess(recipeIngredients);

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
            public void updateAttributes(  String recipeIngredientsId,  Map<String,  ? extends Object> data, final ObjectCallback<RecipeIngredients> callback){

                //Definging hashMap for data conversion
                Map<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("recipeIngredientsId", recipeIngredientsId);
                
                        hashMapObject.putAll(data);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.updateAttributes", hashMapObject, new Adapter.JsonObjectCallback() {
                    
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

            

        
    
        
    
        
    
        
    
        
    
        
    
        
    



}