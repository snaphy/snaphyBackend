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



import com.strongloop.android.loopback.UserRepository;
import com.strongloop.android.loopback.AccessTokenRepository;
import com.strongloop.android.loopback.AccessToken;



import org.json.JSONArray;
import org.json.JSONObject;

//Import its models too.
import com.androidsdk.snaphy.snaphyandroidsdk.models.Employee;

//Now import model of related models..

    
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.EmployeeDetails;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.EmployeeDetailsRepository;
            
        
    





public class EmployeeRepository extends com.strongloop.android.loopback.UserRepository<Employee> {


    public EmployeeRepository(){
        super("Employee", null, Employee.class);
    }





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:employeeId/accessTokens/:fk", "GET"), "Employee.prototype.__findById__accessTokens");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:employeeId/accessTokens/:fk", "DELETE"), "Employee.prototype.__destroyById__accessTokens");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:employeeId/accessTokens/:fk", "PUT"), "Employee.prototype.__updateById__accessTokens");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:employeeId/employeeDetails", "GET"), "Employee.prototype.__get__employeeDetails");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:employeeId/employeeDetails", "POST"), "Employee.prototype.__create__employeeDetails");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:employeeId/employeeDetails", "PUT"), "Employee.prototype.__update__employeeDetails");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:employeeId/employeeDetails", "DELETE"), "Employee.prototype.__destroy__employeeDetails");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:employeeId/accessTokens", "GET"), "Employee.prototype.__get__accessTokens");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:employeeId/accessTokens", "POST"), "Employee.prototype.__create__accessTokens");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:employeeId/accessTokens", "DELETE"), "Employee.prototype.__delete__accessTokens");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:employeeId/accessTokens/count", "GET"), "Employee.prototype.__count__accessTokens");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "Employee.create");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "Employee.create");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "PUT"), "Employee.upsert");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/exists", "GET"), "Employee.exists");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "GET"), "Employee.findById");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "GET"), "Employee.find");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/findOne", "GET"), "Employee.findOne");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/update", "POST"), "Employee.updateAll");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "DELETE"), "Employee.deleteById");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/count", "GET"), "Employee.count");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:employeeId", "PUT"), "Employee.prototype.updateAttributes");
                

            
        
            
        
            
        
            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/confirm", "GET"), "Employee.confirm");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/reset", "POST"), "Employee.resetPassword");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/getSchema", "POST"), "Employee.getSchema");
                

            
        
            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/isAdmin", "POST"), "Employee.isAdmin");
                

            
        
            
        
            
        
            
        
            
        
            
        
        return contract;
    }


    //override getNameForRestUrlMethod
    public String  getNameForRestUrl() {
        
            //call super method instead..
            return super.getNameForRestUrl();
        
    }



    




    
        
            //Method findById__accessTokens definition
            public void findById__accessTokens(  String employeeId,  String fk, final ObjectCallback<AccessToken> callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("employeeId", employeeId);
                
                        hashMapObject.put("fk", fk);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__accessTokens", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    AccessTokenRepository accessTokenRepo = getRestAdapter().createRepository(AccessTokenRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    AccessToken accessToken = accessTokenRepo.createObject(result);
                                    callback.onSuccess(accessToken);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findById__accessTokens definition ends here..

            

        
    
        
            //Method destroyById__accessTokens definition
            public void destroyById__accessTokens(  String employeeId,  String fk, final VoidCallback callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("employeeId", employeeId);
                
                        hashMapObject.put("fk", fk);
                

                
                    invokeStaticMethod("prototype.__destroyById__accessTokens", hashMapObject, new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroyById__accessTokens definition ends here..

            

        
    
        
            //Method updateById__accessTokens definition
            public void updateById__accessTokens(  String employeeId,  String fk,  HashMap<String, Object> data, final ObjectCallback<AccessToken> callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("employeeId", employeeId);
                
                        hashMapObject.put("fk", fk);
                
                        hashMapObject.putAll(data);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__accessTokens", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    AccessTokenRepository accessTokenRepo = getRestAdapter().createRepository(AccessTokenRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    AccessToken accessToken = accessTokenRepo.createObject(result);
                                    callback.onSuccess(accessToken);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method updateById__accessTokens definition ends here..

            

        
    
        
            //Method get__employeeDetails definition
            public void get__employeeDetails(  String employeeId,  Boolean refresh, final ObjectCallback<EmployeeDetails> callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("employeeId", employeeId);
                
                        hashMapObject.put("refresh", refresh);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.__get__employeeDetails", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    EmployeeDetailsRepository employeeDetailsRepo = getRestAdapter().createRepository(EmployeeDetailsRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    EmployeeDetails employeeDetails = employeeDetailsRepo.createObject(result);
                                    callback.onSuccess(employeeDetails);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method get__employeeDetails definition ends here..

            

        
    
        
            //Method create__employeeDetails definition
            public void create__employeeDetails(  String employeeId,  HashMap<String, Object> data, final ObjectCallback<EmployeeDetails> callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("employeeId", employeeId);
                
                        hashMapObject.putAll(data);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.__create__employeeDetails", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    EmployeeDetailsRepository employeeDetailsRepo = getRestAdapter().createRepository(EmployeeDetailsRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    EmployeeDetails employeeDetails = employeeDetailsRepo.createObject(result);
                                    callback.onSuccess(employeeDetails);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__employeeDetails definition ends here..

            

        
    
        
            //Method update__employeeDetails definition
            public void update__employeeDetails(  String employeeId,  HashMap<String, Object> data, final ObjectCallback<EmployeeDetails> callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("employeeId", employeeId);
                
                        hashMapObject.putAll(data);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.__update__employeeDetails", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    EmployeeDetailsRepository employeeDetailsRepo = getRestAdapter().createRepository(EmployeeDetailsRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    EmployeeDetails employeeDetails = employeeDetailsRepo.createObject(result);
                                    callback.onSuccess(employeeDetails);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method update__employeeDetails definition ends here..

            

        
    
        
            //Method destroy__employeeDetails definition
            public void destroy__employeeDetails(  String employeeId, final VoidCallback callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("employeeId", employeeId);
                

                
                    invokeStaticMethod("prototype.__destroy__employeeDetails", hashMapObject, new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroy__employeeDetails definition ends here..

            

        
    
        
            //Method get__accessTokens definition
            public void get__accessTokens(  String employeeId,  HashMap<String, Object> filter, final ListCallback<AccessToken> callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("employeeId", employeeId);
                
                        hashMapObject.put("filter", filter);
                

                


                

                
                    invokeStaticMethod("prototype.__get__accessTokens", hashMapObject, new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            
                                if(response != null){
                                    //Now converting jsonObject to list
                                    List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                    List<AccessToken> accessTokenList = new ArrayList<AccessToken>();
                                    AccessTokenRepository accessTokenRepo = getRestAdapter().createRepository(AccessTokenRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        AccessToken accessToken = accessTokenRepo.createObject(obj);
                                        accessTokenList.add(accessToken);
                                    }
                                    callback.onSuccess(accessTokenList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method get__accessTokens definition ends here..

            

        
    
        
            //Method create__accessTokens definition
            public void create__accessTokens(  String employeeId,  HashMap<String, Object> data, final ObjectCallback<AccessToken> callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("employeeId", employeeId);
                
                        hashMapObject.putAll(data);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.__create__accessTokens", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    AccessTokenRepository accessTokenRepo = getRestAdapter().createRepository(AccessTokenRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    AccessToken accessToken = accessTokenRepo.createObject(result);
                                    callback.onSuccess(accessToken);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__accessTokens definition ends here..

            

        
    
        
            //Method delete__accessTokens definition
            public void delete__accessTokens(  String employeeId, final VoidCallback callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("employeeId", employeeId);
                

                
                    invokeStaticMethod("prototype.__delete__accessTokens", hashMapObject, new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method delete__accessTokens definition ends here..

            

        
    
        
            //Method count__accessTokens definition
            public void count__accessTokens(  String employeeId,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("employeeId", employeeId);
                
                        hashMapObject.put("where", where);
                

                


                
                    
                    invokeStaticMethod("prototype.__count__accessTokens", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method count__accessTokens definition ends here..

            

        
    
        
            //Method create definition
            public void create(  HashMap<String, Object> data, final ObjectCallback<Employee> callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
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
                                    EmployeeRepository employeeRepo = getRestAdapter().createRepository(EmployeeRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Employee employee = employeeRepo.createObject(result);
                                    callback.onSuccess(employee);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create definition ends here..

            

        
    
        
            //Method createMany definition
            public void createMany(  HashMap<String, Object> data, final ObjectCallback<Employee> callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
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
                                    EmployeeRepository employeeRepo = getRestAdapter().createRepository(EmployeeRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Employee employee = employeeRepo.createObject(result);
                                    callback.onSuccess(employee);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method createMany definition ends here..

            

        
    
        
            //Method upsert definition
            public void upsert(  HashMap<String, Object> data, final ObjectCallback<Employee> callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
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
                                    EmployeeRepository employeeRepo = getRestAdapter().createRepository(EmployeeRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Employee employee = employeeRepo.createObject(result);
                                    callback.onSuccess(employee);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method upsert definition ends here..

            

        
    
        
            //Method exists definition
            public void exists(  String id, final Adapter.JsonObjectCallback  callback ){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
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
            public void findById(  String id,  HashMap<String, Object> filter, final ObjectCallback<Employee> callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
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
                                    EmployeeRepository employeeRepo = getRestAdapter().createRepository(EmployeeRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Employee employee = employeeRepo.createObject(result);
                                    callback.onSuccess(employee);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findById definition ends here..

            

        
    
        
            //Method find definition
            public void find(  HashMap<String, Object> filter, final ListCallback<Employee> callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
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
                                    List<Employee> employeeList = new ArrayList<Employee>();
                                    EmployeeRepository employeeRepo = getRestAdapter().createRepository(EmployeeRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        Employee employee = employeeRepo.createObject(obj);
                                        employeeList.add(employee);
                                    }
                                    callback.onSuccess(employeeList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method find definition ends here..

            

        
    
        
            //Method findOne definition
            public void findOne(  HashMap<String, Object> filter, final ObjectCallback<Employee> callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
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
                                    EmployeeRepository employeeRepo = getRestAdapter().createRepository(EmployeeRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Employee employee = employeeRepo.createObject(result);
                                    callback.onSuccess(employee);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findOne definition ends here..

            

        
    
        
            //Method updateAll definition
            public void updateAll(  HashMap<String, Object> where,  HashMap<String, Object> data, final Adapter.JsonObjectCallback  callback ){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
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
                HashMap<String, Object> hashMapObject = new HashMap<>();
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
            public void count(  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
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
            public void updateAttributes(  String employeeId,  HashMap<String, Object> data, final ObjectCallback<Employee> callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("employeeId", employeeId);
                
                        hashMapObject.putAll(data);
                

                


                
                    
                    
                    invokeStaticMethod("prototype.updateAttributes", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    EmployeeRepository employeeRepo = getRestAdapter().createRepository(EmployeeRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Employee employee = employeeRepo.createObject(result);
                                    callback.onSuccess(employee);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method updateAttributes definition ends here..

            

        
    
        
    
        
    
        
    
        
            //Method confirm definition
            public void confirm(  String uid,  String token,  String redirect, final VoidCallback callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("uid", uid);
                
                        hashMapObject.put("token", token);
                
                        hashMapObject.put("redirect", redirect);
                

                
                    invokeStaticMethod("confirm", hashMapObject, new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method confirm definition ends here..

            

        
    
        
            //Method resetPassword definition
            public void resetPassword(  HashMap<String, Object> options, final VoidCallback callback){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                
                        hashMapObject.put("options", options);
                

                
                    invokeStaticMethod("resetPassword", hashMapObject, new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method resetPassword definition ends here..

            

        
    
        
            //Method getSchema definition
            public void getSchema( final Adapter.JsonObjectCallback  callback ){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
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

            

        
    
        
    
        
            //Method isAdmin definition
            public void isAdmin( final Adapter.JsonObjectCallback  callback ){

                //Definging hashMap for data conversion
                HashMap<String, Object> hashMapObject = new HashMap<>();
                //Now add the arguments...
                

                


                
                    
                    invokeStaticMethod("isAdmin", hashMapObject, new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method isAdmin definition ends here..

            

        
    
        
    
        
    
        
    
        
    
        
    



}
