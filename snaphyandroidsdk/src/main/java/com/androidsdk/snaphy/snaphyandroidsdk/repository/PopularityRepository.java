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
import com.androidsdk.snaphy.snaphyandroidsdk.models.Popularity;

//Now import model of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Chef;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.ChefRepository;
            
        
    





public class PopularityRepository extends ModelRepository<Popularity> {


    public PopularityRepository(){
        super("Popularity", null, Popularity.class);
    }





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:popularityId/chefs", "GET"), "Popularity.prototype.__get__chefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:popularityId/chefs", "POST"), "Popularity.prototype.__create__chefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:popularityId/chefs", "PUT"), "Popularity.prototype.__update__chefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:popularityId/chefs", "DELETE"), "Popularity.prototype.__destroy__chefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "Popularity.create");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "Popularity.create");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "PUT"), "Popularity.upsert");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/exists", "GET"), "Popularity.exists");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "GET"), "Popularity.findById");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "GET"), "Popularity.find");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/findOne", "GET"), "Popularity.findOne");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/update", "POST"), "Popularity.updateAll");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "DELETE"), "Popularity.deleteById");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/count", "GET"), "Popularity.count");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:popularityId", "PUT"), "Popularity.prototype.updateAttributes");
                

            
        
            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/getSchema", "POST"), "Popularity.getSchema");
                

            
        
            
        
            
        
            
        
            
        
            
        
            
        
        return contract;
    }



    




    
        
            //Method get__chefs definition
            public void get__chefs(  String popularityId,  Boolean refresh, final ObjectCallback<Chef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__get__chefs", ImmutableMap.of("popularityId", popularityId, "refresh", refresh), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    ChefRepository chefRepo = getRestAdapter().createRepository(ChefRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Chef chef = chefRepo.createObject(result);
                                    callback.onSuccess(chef);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method get__chefs definition ends here..

            

        
    
        
            //Method create__chefs definition
            public void create__chefs(  String popularityId,  HashMap<String, Object> data, final ObjectCallback<Chef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__chefs", ImmutableMap.of("popularityId", popularityId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    ChefRepository chefRepo = getRestAdapter().createRepository(ChefRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Chef chef = chefRepo.createObject(result);
                                    callback.onSuccess(chef);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__chefs definition ends here..

            

        
    
        
            //Method update__chefs definition
            public void update__chefs(  String popularityId,  HashMap<String, Object> data, final ObjectCallback<Chef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__update__chefs", ImmutableMap.of("popularityId", popularityId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    ChefRepository chefRepo = getRestAdapter().createRepository(ChefRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Chef chef = chefRepo.createObject(result);
                                    callback.onSuccess(chef);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method update__chefs definition ends here..

            

        
    
        
            //Method destroy__chefs definition
            public void destroy__chefs(  String popularityId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroy__chefs", ImmutableMap.of("popularityId", popularityId), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroy__chefs definition ends here..

            

        
    
        
            //Method create definition
            public void create(  HashMap<String, Object> data, final ObjectCallback<Popularity> callback){
                


                
                    
                    
                    invokeStaticMethod("create", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    PopularityRepository popularityRepo = getRestAdapter().createRepository(PopularityRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Popularity popularity = popularityRepo.createObject(result);
                                    callback.onSuccess(popularity);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create definition ends here..

            

        
    
        
            //Method createMany definition
            public void createMany(  HashMap<String, Object> data, final ObjectCallback<Popularity> callback){
                


                
                    
                    
                    invokeStaticMethod("createMany", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    PopularityRepository popularityRepo = getRestAdapter().createRepository(PopularityRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Popularity popularity = popularityRepo.createObject(result);
                                    callback.onSuccess(popularity);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method createMany definition ends here..

            

        
    
        
            //Method upsert definition
            public void upsert(  HashMap<String, Object> data, final ObjectCallback<Popularity> callback){
                


                
                    
                    
                    invokeStaticMethod("upsert", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    PopularityRepository popularityRepo = getRestAdapter().createRepository(PopularityRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Popularity popularity = popularityRepo.createObject(result);
                                    callback.onSuccess(popularity);

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
            public void findById(  String id,  HashMap<String, Object> filter, final ObjectCallback<Popularity> callback){
                


                
                    
                    
                    invokeStaticMethod("findById", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    PopularityRepository popularityRepo = getRestAdapter().createRepository(PopularityRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Popularity popularity = popularityRepo.createObject(result);
                                    callback.onSuccess(popularity);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findById definition ends here..

            

        
    
        
            //Method find definition
            public void find(  HashMap<String, Object> filter, final ListCallback<Popularity> callback){
                


                

                
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
                                    List<Popularity> popularityList = new ArrayList<Popularity>();
                                    PopularityRepository popularityRepo = getRestAdapter().createRepository(PopularityRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        Popularity popularity = popularityRepo.createObject(obj);
                                        popularityList.add(popularity);
                                    }
                                    callback.onSuccess(popularityList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method find definition ends here..

            

        
    
        
            //Method findOne definition
            public void findOne(  HashMap<String, Object> filter, final ObjectCallback<Popularity> callback){
                


                
                    
                    
                    invokeStaticMethod("findOne", ImmutableMap.of("filter", filter), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    PopularityRepository popularityRepo = getRestAdapter().createRepository(PopularityRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Popularity popularity = popularityRepo.createObject(result);
                                    callback.onSuccess(popularity);

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
            public void updateAttributes(  String popularityId,  HashMap<String, Object> data, final ObjectCallback<Popularity> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.updateAttributes", ImmutableMap.of("popularityId", popularityId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    PopularityRepository popularityRepo = getRestAdapter().createRepository(PopularityRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Popularity popularity = popularityRepo.createObject(result);
                                    callback.onSuccess(popularity);

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
