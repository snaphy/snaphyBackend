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
import com.androidsdk.snaphy.snaphyandroidsdk.models.EmployeeDetails;

//Now import model of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Employee;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.EmployeeRepository;
            
        
    





public class EmployeeDetailsRepository extends ModelRepository<EmployeeDetails> {


    public EmployeeDetailsRepository(){
        super("EmployeeDetails", null, EmployeeDetails.class);
    }





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/employees", "GET"), "EmployeeDetails.prototype.__get__employees");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/employees", "POST"), "EmployeeDetails.prototype.__create__employees");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/employees", "PUT"), "EmployeeDetails.prototype.__update__employees");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/employees", "DELETE"), "EmployeeDetails.prototype.__destroy__employees");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "EmployeeDetails.create");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "EmployeeDetails.create");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "PUT"), "EmployeeDetails.upsert");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/exists", "GET"), "EmployeeDetails.exists");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "GET"), "EmployeeDetails.findById");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "GET"), "EmployeeDetails.find");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/findOne", "GET"), "EmployeeDetails.findOne");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/update", "POST"), "EmployeeDetails.updateAll");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "DELETE"), "EmployeeDetails.deleteById");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/count", "GET"), "EmployeeDetails.count");
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "PUT"), "EmployeeDetails.prototype.updateAttributes");
            
        
            
        
            
                contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/getSchema", "POST"), "EmployeeDetails.getSchema");
            
        
            
        
            
        
            
        
            
        
            
        
            
        
        return contract;
    }



    




    
        
            //Method get__employees definition
            public void get__employees(  String id,  Boolean refresh, final ObjectCallback<Employee> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__get__employees", ImmutableMap.of("id", id, "refresh", refresh), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                EmployeeRepository employeeRepo = getRestAdapter().createRepository(EmployeeRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Employee employee = employeeRepo.createObject(result);
                                callback.onSuccess(employee);
                            
                        }
                    });
                

                

            }//Method get__employees definition ends here..

            

        
    
        
            //Method create__employees definition
            public void create__employees(  String id,  Employee data, final ObjectCallback<Employee> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__employees", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                EmployeeRepository employeeRepo = getRestAdapter().createRepository(EmployeeRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Employee employee = employeeRepo.createObject(result);
                                callback.onSuccess(employee);
                            
                        }
                    });
                

                

            }//Method create__employees definition ends here..

            

        
    
        
            //Method update__employees definition
            public void update__employees(  String id,  Employee data, final ObjectCallback<Employee> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__update__employees", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                EmployeeRepository employeeRepo = getRestAdapter().createRepository(EmployeeRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                Employee employee = employeeRepo.createObject(result);
                                callback.onSuccess(employee);
                            
                        }
                    });
                

                

            }//Method update__employees definition ends here..

            

        
    
        
            //Method destroy__employees definition
            public void destroy__employees(  String id, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroy__employees", ImmutableMap.of("id", id), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroy__employees definition ends here..

            

        
    
        
            //Method create definition
            public void create(  HashMap<String, Object> data, final ObjectCallback<EmployeeDetails> callback){
                


                
                    
                    
                    invokeStaticMethod("create", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                EmployeeDetailsRepository employeeDetailsRepo = getRestAdapter().createRepository(EmployeeDetailsRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                EmployeeDetails employeeDetails = employeeDetailsRepo.createObject(result);
                                callback.onSuccess(employeeDetails);
                            
                        }
                    });
                

                

            }//Method create definition ends here..

            

        
    
        
            //Method createMany definition
            public void createMany(  HashMap<String, Object> data, final ObjectCallback<EmployeeDetails> callback){
                


                
                    
                    
                    invokeStaticMethod("createMany", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                EmployeeDetailsRepository employeeDetailsRepo = getRestAdapter().createRepository(EmployeeDetailsRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                EmployeeDetails employeeDetails = employeeDetailsRepo.createObject(result);
                                callback.onSuccess(employeeDetails);
                            
                        }
                    });
                

                

            }//Method createMany definition ends here..

            

        
    
        
            //Method upsert definition
            public void upsert(  HashMap<String, Object> data, final ObjectCallback<EmployeeDetails> callback){
                


                
                    
                    
                    invokeStaticMethod("upsert", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                EmployeeDetailsRepository employeeDetailsRepo = getRestAdapter().createRepository(EmployeeDetailsRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                EmployeeDetails employeeDetails = employeeDetailsRepo.createObject(result);
                                callback.onSuccess(employeeDetails);
                            
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
            public void findById(  String id,  HashMap<String, Object> filter, final ObjectCallback<EmployeeDetails> callback){
                


                
                    
                    
                    invokeStaticMethod("findById", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                EmployeeDetailsRepository employeeDetailsRepo = getRestAdapter().createRepository(EmployeeDetailsRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                EmployeeDetails employeeDetails = employeeDetailsRepo.createObject(result);
                                callback.onSuccess(employeeDetails);
                            
                        }
                    });
                

                

            }//Method findById definition ends here..

            

        
    
        
            //Method find definition
            public void find(  HashMap<String, Object> filter, final ListCallback<EmployeeDetails> callback){
                


                

                
                    invokeStaticMethod("find", ImmutableMap.of("filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            

                                //Now converting jsonObject to list
                                List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                List<EmployeeDetails> employeeDetailsList = new ArrayList<EmployeeDetails>();
                                EmployeeDetailsRepository employeeDetailsRepo = getRestAdapter().createRepository(EmployeeDetailsRepository.class);

                                for (Map<String, Object> obj : result) {
                                    EmployeeDetails employeeDetails = employeeDetailsRepo.createObject(obj);
                                    employeeDetailsList.add(employeeDetails);
                                }
                                callback.onSuccess(employeeDetailsList);
                            
                        }
                    });
                

            }//Method find definition ends here..

            

        
    
        
            //Method findOne definition
            public void findOne(  HashMap<String, Object> filter, final ObjectCallback<EmployeeDetails> callback){
                


                
                    
                    
                    invokeStaticMethod("findOne", ImmutableMap.of("filter", filter), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                EmployeeDetailsRepository employeeDetailsRepo = getRestAdapter().createRepository(EmployeeDetailsRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                EmployeeDetails employeeDetails = employeeDetailsRepo.createObject(result);
                                callback.onSuccess(employeeDetails);
                            
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
            public void updateAttributes(  String id,  HashMap<String, Object> data, final ObjectCallback<EmployeeDetails> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.updateAttributes", ImmutableMap.of("id", id, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                EmployeeDetailsRepository employeeDetailsRepo = getRestAdapter().createRepository(EmployeeDetailsRepository.class);
                                Map<String, Object> result = JsonUtil.fromJson(response);
                                EmployeeDetails employeeDetails = employeeDetailsRepo.createObject(result);
                                callback.onSuccess(employeeDetails);
                            
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
