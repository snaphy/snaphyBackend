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
import com.androidsdk.snaphy.snaphyandroidsdk.models.EmailInfo;

//Now import model of related models..





public class EmailInfoRepository extends ModelRepository<EmailInfo> {


    public EmailInfoRepository(){
        super("EmailInfo", null, EmailInfo.class);
    }





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "EmailInfo.create");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "EmailInfo.create");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "PUT"), "EmailInfo.upsert");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/exists", "GET"), "EmailInfo.exists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "GET"), "EmailInfo.findById");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "GET"), "EmailInfo.find");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/findOne", "GET"), "EmailInfo.findOne");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/update", "POST"), "EmailInfo.updateAll");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "DELETE"), "EmailInfo.deleteById");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/count", "GET"), "EmailInfo.count");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "PUT"), "EmailInfo.prototype.updateAttributes");
            
        
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/getSchema", "POST"), "EmailInfo.getSchema");
            
        
            
        
        return contract;
    }



    




    
        
            //Method create definition
            public void create(  HashMap<String, Object> data, final ObjectCallback<EmailInfo> callback){
                


                
                    
                    
                    invokeStaticMethod("create", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                EmailInfoRepository emailInfoRepo = getRestAdapter().createRepository(EmailInfoRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                EmailInfo emailInfo = emailInfoRepo.createObject(result);
                                callback.onSuccess(emailInfo);
                            
                        }
                    });
                

                

            }//Method create definition ends here..

            

        
    
        
            //Method createMany definition
            public void createMany(  HashMap<String, Object> data, final ObjectCallback<EmailInfo> callback){
                


                
                    
                    
                    invokeStaticMethod("createMany", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                EmailInfoRepository emailInfoRepo = getRestAdapter().createRepository(EmailInfoRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                EmailInfo emailInfo = emailInfoRepo.createObject(result);
                                callback.onSuccess(emailInfo);
                            
                        }
                    });
                

                

            }//Method createMany definition ends here..

            

        
    
        
            //Method upsert definition
            public void upsert(  HashMap<String, Object> data, final ObjectCallback<EmailInfo> callback){
                


                
                    
                    
                    invokeStaticMethod("upsert", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                EmailInfoRepository emailInfoRepo = getRestAdapter().createRepository(EmailInfoRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                EmailInfo emailInfo = emailInfoRepo.createObject(result);
                                callback.onSuccess(emailInfo);
                            
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
            public void findById(  String id,  HashMap<String, Object> filter, final ObjectCallback<EmailInfo> callback){
                


                
                    
                    
                    invokeStaticMethod("findById", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                EmailInfoRepository emailInfoRepo = getRestAdapter().createRepository(EmailInfoRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                EmailInfo emailInfo = emailInfoRepo.createObject(result);
                                callback.onSuccess(emailInfo);
                            
                        }
                    });
                

                

            }//Method findById definition ends here..

            

        
    
        
            //Method find definition
            public void find(  HashMap<String, Object> filter, final ListCallback<EmailInfo> callback){
                


                

                
                    invokeStaticMethod("find", ImmutableMap.of("filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            

                                //Now converting jsonObject to list
                                List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                List<EmailInfo> emailInfoList = new ArrayList<EmailInfo>();
                                EmailInfoRepository emailInfoRepo = getRestAdapter().createRepository(EmailInfoRepository.class);

                                for (Map<String, Object> obj : result) {
                                    EmailInfo emailInfo = emailInfoRepo.createObject(obj);
                                    emailInfoList.add(emailInfo);
                                }
                                callback.onSuccess(emailInfoList);
                            
                        }
                    });
                

            }//Method find definition ends here..

            

        
    
        
            //Method findOne definition
            public void findOne(  HashMap<String, Object> filter, final ObjectCallback<EmailInfo> callback){
                


                
                    
                    
                    invokeStaticMethod("findOne", ImmutableMap.of("filter", filter), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                EmailInfoRepository emailInfoRepo = getRestAdapter().createRepository(EmailInfoRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                EmailInfo emailInfo = emailInfoRepo.createObject(result);
                                callback.onSuccess(emailInfo);
                            
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
            public void updateAttributes(  String id,  HashMap<String, Object> data, final ObjectCallback<EmailInfo> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.updateAttributes", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                EmailInfoRepository emailInfoRepo = getRestAdapter().createRepository(EmailInfoRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                EmailInfo emailInfo = emailInfoRepo.createObject(result);
                                callback.onSuccess(emailInfo);
                            
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
