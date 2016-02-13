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
import com.androidsdk.snaphy.snaphyandroidsdk.models.Chef;

//Now import model of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Customer;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CustomerRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Course;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CourseRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.ContactChef;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.ContactChefRepository;
            
        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.models.Popularity;
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.PopularityRepository;
            
        
    





public class ChefRepository extends ModelRepository<Chef> {


    public ChefRepository(){
        super("Chef", null, Chef.class);
    }





    public RestContract createContract() {
        RestContract contract = super.createContract();
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/customers", "GET"), "Chef.prototype.__get__customers");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/customers", "POST"), "Chef.prototype.__create__customers");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/customers", "PUT"), "Chef.prototype.__update__customers");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/customers", "DELETE"), "Chef.prototype.__destroy__customers");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/popularities", "GET"), "Chef.prototype.__get__popularities");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/popularities", "POST"), "Chef.prototype.__create__popularities");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/popularities", "PUT"), "Chef.prototype.__update__popularities");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/popularities", "DELETE"), "Chef.prototype.__destroy__popularities");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/courses/:fk", "GET"), "Chef.prototype.__findById__courses");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/courses/:fk", "DELETE"), "Chef.prototype.__destroyById__courses");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/courses/:fk", "PUT"), "Chef.prototype.__updateById__courses");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/contactChefs/:fk", "GET"), "Chef.prototype.__findById__contactChefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/contactChefs/:fk", "DELETE"), "Chef.prototype.__destroyById__contactChefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/contactChefs/:fk", "PUT"), "Chef.prototype.__updateById__contactChefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/courses", "GET"), "Chef.prototype.__get__courses");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/courses", "POST"), "Chef.prototype.__create__courses");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/courses", "DELETE"), "Chef.prototype.__delete__courses");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/courses/count", "GET"), "Chef.prototype.__count__courses");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/contactChefs", "GET"), "Chef.prototype.__get__contactChefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/contactChefs", "POST"), "Chef.prototype.__create__contactChefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/contactChefs", "DELETE"), "Chef.prototype.__delete__contactChefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId/contactChefs/count", "GET"), "Chef.prototype.__count__contactChefs");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "Chef.create");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "POST"), "Chef.create");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "PUT"), "Chef.upsert");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id/exists", "GET"), "Chef.exists");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "GET"), "Chef.findById");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/", "GET"), "Chef.find");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/findOne", "GET"), "Chef.findOne");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/update", "POST"), "Chef.updateAll");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:id", "DELETE"), "Chef.deleteById");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/count", "GET"), "Chef.count");
                

            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/:chefId", "PUT"), "Chef.prototype.updateAttributes");
                

            
        
            
        
            

                
                    contract.addItem(new RestContractItem("/" + getNameForRestUrl() + "/getSchema", "POST"), "Chef.getSchema");
                

            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
        return contract;
    }



    




    
        
            //Method get__customers definition
            public void get__customers(  String chefId,  Boolean refresh, final ObjectCallback<Customer> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__get__customers", ImmutableMap.of("chefId", chefId, "refresh", refresh), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CustomerRepository customerRepo = getRestAdapter().createRepository(CustomerRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Customer customer = customerRepo.createObject(result);
                                    callback.onSuccess(customer);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method get__customers definition ends here..

            

        
    
        
            //Method create__customers definition
            public void create__customers(  String chefId,  HashMap<String, Object> data, final ObjectCallback<Customer> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__customers", ImmutableMap.of("chefId", chefId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CustomerRepository customerRepo = getRestAdapter().createRepository(CustomerRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Customer customer = customerRepo.createObject(result);
                                    callback.onSuccess(customer);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__customers definition ends here..

            

        
    
        
            //Method update__customers definition
            public void update__customers(  String chefId,  HashMap<String, Object> data, final ObjectCallback<Customer> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__update__customers", ImmutableMap.of("chefId", chefId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CustomerRepository customerRepo = getRestAdapter().createRepository(CustomerRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Customer customer = customerRepo.createObject(result);
                                    callback.onSuccess(customer);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method update__customers definition ends here..

            

        
    
        
            //Method destroy__customers definition
            public void destroy__customers(  String chefId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroy__customers", ImmutableMap.of("chefId", chefId), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroy__customers definition ends here..

            

        
    
        
            //Method get__popularities definition
            public void get__popularities(  String chefId,  Boolean refresh, final ObjectCallback<Popularity> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__get__popularities", ImmutableMap.of("chefId", chefId, "refresh", refresh), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method get__popularities definition ends here..

            

        
    
        
            //Method create__popularities definition
            public void create__popularities(  String chefId,  HashMap<String, Object> data, final ObjectCallback<Popularity> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__popularities", ImmutableMap.of("chefId", chefId, "data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method create__popularities definition ends here..

            

        
    
        
            //Method update__popularities definition
            public void update__popularities(  String chefId,  HashMap<String, Object> data, final ObjectCallback<Popularity> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__update__popularities", ImmutableMap.of("chefId", chefId, "data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method update__popularities definition ends here..

            

        
    
        
            //Method destroy__popularities definition
            public void destroy__popularities(  String chefId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroy__popularities", ImmutableMap.of("chefId", chefId), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroy__popularities definition ends here..

            

        
    
        
            //Method findById__courses definition
            public void findById__courses(  String chefId,  String fk, final ObjectCallback<Course> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__courses", ImmutableMap.of("chefId", chefId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CourseRepository courseRepo = getRestAdapter().createRepository(CourseRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Course course = courseRepo.createObject(result);
                                    callback.onSuccess(course);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findById__courses definition ends here..

            

        
    
        
            //Method destroyById__courses definition
            public void destroyById__courses(  String chefId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__courses", ImmutableMap.of("chefId", chefId, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroyById__courses definition ends here..

            

        
    
        
            //Method updateById__courses definition
            public void updateById__courses(  String chefId,  String fk,  HashMap<String, Object> data, final ObjectCallback<Course> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__courses", ImmutableMap.of("chefId", chefId, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CourseRepository courseRepo = getRestAdapter().createRepository(CourseRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Course course = courseRepo.createObject(result);
                                    callback.onSuccess(course);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method updateById__courses definition ends here..

            

        
    
        
            //Method findById__contactChefs definition
            public void findById__contactChefs(  String chefId,  String fk, final ObjectCallback<ContactChef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__findById__contactChefs", ImmutableMap.of("chefId", chefId, "fk", fk), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    ContactChefRepository contactChefRepo = getRestAdapter().createRepository(ContactChefRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    ContactChef contactChef = contactChefRepo.createObject(result);
                                    callback.onSuccess(contactChef);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method findById__contactChefs definition ends here..

            

        
    
        
            //Method destroyById__contactChefs definition
            public void destroyById__contactChefs(  String chefId,  String fk, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__destroyById__contactChefs", ImmutableMap.of("chefId", chefId, "fk", fk), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method destroyById__contactChefs definition ends here..

            

        
    
        
            //Method updateById__contactChefs definition
            public void updateById__contactChefs(  String chefId,  String fk,  HashMap<String, Object> data, final ObjectCallback<ContactChef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__updateById__contactChefs", ImmutableMap.of("chefId", chefId, "fk", fk, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    ContactChefRepository contactChefRepo = getRestAdapter().createRepository(ContactChefRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    ContactChef contactChef = contactChefRepo.createObject(result);
                                    callback.onSuccess(contactChef);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method updateById__contactChefs definition ends here..

            

        
    
        
            //Method get__courses definition
            public void get__courses(  String chefId,  HashMap<String, Object> filter, final ListCallback<Course> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__courses", ImmutableMap.of("chefId", chefId, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            
                                if(response != null){
                                    //Now converting jsonObject to list
                                    List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                    List<Course> courseList = new ArrayList<Course>();
                                    CourseRepository courseRepo = getRestAdapter().createRepository(CourseRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        Course course = courseRepo.createObject(obj);
                                        courseList.add(course);
                                    }
                                    callback.onSuccess(courseList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method get__courses definition ends here..

            

        
    
        
            //Method create__courses definition
            public void create__courses(  String chefId,  HashMap<String, Object> data, final ObjectCallback<Course> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__courses", ImmutableMap.of("chefId", chefId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    CourseRepository courseRepo = getRestAdapter().createRepository(CourseRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    Course course = courseRepo.createObject(result);
                                    callback.onSuccess(course);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__courses definition ends here..

            

        
    
        
            //Method delete__courses definition
            public void delete__courses(  String chefId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__courses", ImmutableMap.of("chefId", chefId), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method delete__courses definition ends here..

            

        
    
        
            //Method count__courses definition
            public void count__courses(  String chefId,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__courses", ImmutableMap.of("chefId", chefId, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method count__courses definition ends here..

            

        
    
        
            //Method get__contactChefs definition
            public void get__contactChefs(  String chefId,  HashMap<String, Object> filter, final ListCallback<ContactChef> callback){
                


                

                
                    invokeStaticMethod("prototype.__get__contactChefs", ImmutableMap.of("chefId", chefId, "filter", filter), new Adapter.JsonArrayCallback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONArray response) {
                            
                                if(response != null){
                                    //Now converting jsonObject to list
                                    List<Map<String, Object>> result = (List) JsonUtil.fromJson(response);
                                    List<ContactChef> contactChefList = new ArrayList<ContactChef>();
                                    ContactChefRepository contactChefRepo = getRestAdapter().createRepository(ContactChefRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        ContactChef contactChef = contactChefRepo.createObject(obj);
                                        contactChefList.add(contactChef);
                                    }
                                    callback.onSuccess(contactChefList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method get__contactChefs definition ends here..

            

        
    
        
            //Method create__contactChefs definition
            public void create__contactChefs(  String chefId,  HashMap<String, Object> data, final ObjectCallback<ContactChef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.__create__contactChefs", ImmutableMap.of("chefId", chefId, "data", data), new Adapter.JsonObjectCallback() {
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                if(response != null){
                                    ContactChefRepository contactChefRepo = getRestAdapter().createRepository(ContactChefRepository.class);
                                    Map<String, Object> result = JsonUtil.fromJson(response);
                                    ContactChef contactChef = contactChefRepo.createObject(result);
                                    callback.onSuccess(contactChef);

                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

                

            }//Method create__contactChefs definition ends here..

            

        
    
        
            //Method delete__contactChefs definition
            public void delete__contactChefs(  String chefId, final VoidCallback callback){
                
                    invokeStaticMethod("prototype.__delete__contactChefs", ImmutableMap.of("chefId", chefId), new Adapter.Callback() {
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess();
                        }
                    });
                


                

                

            }//Method delete__contactChefs definition ends here..

            

        
    
        
            //Method count__contactChefs definition
            public void count__contactChefs(  String chefId,  HashMap<String, Object> where, final Adapter.JsonObjectCallback  callback ){
                


                
                    
                    invokeStaticMethod("prototype.__count__contactChefs", ImmutableMap.of("chefId", chefId, "where", where), new Adapter.JsonObjectCallback() {
                    
                    
                        @Override
                        public void onError(Throwable t) {
                            callback.onError(t);
                        }

                        @Override
                        public void onSuccess(JSONObject response) {
                            
                                callback.onSuccess(response);
                            
                        }
                    });
                

                

            }//Method count__contactChefs definition ends here..

            

        
    
        
            //Method create definition
            public void create(  HashMap<String, Object> data, final ObjectCallback<Chef> callback){
                


                
                    
                    
                    invokeStaticMethod("create", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method create definition ends here..

            

        
    
        
            //Method createMany definition
            public void createMany(  HashMap<String, Object> data, final ObjectCallback<Chef> callback){
                


                
                    
                    
                    invokeStaticMethod("createMany", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method createMany definition ends here..

            

        
    
        
            //Method upsert definition
            public void upsert(  HashMap<String, Object> data, final ObjectCallback<Chef> callback){
                


                
                    
                    
                    invokeStaticMethod("upsert", ImmutableMap.of("data", data), new Adapter.JsonObjectCallback() {
                    
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
            public void findById(  String id,  HashMap<String, Object> filter, final ObjectCallback<Chef> callback){
                


                
                    
                    
                    invokeStaticMethod("findById", ImmutableMap.of("id", id, "filter", filter), new Adapter.JsonObjectCallback() {
                    
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
                

                

            }//Method findById definition ends here..

            

        
    
        
            //Method find definition
            public void find(  HashMap<String, Object> filter, final ListCallback<Chef> callback){
                


                

                
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
                                    List<Chef> chefList = new ArrayList<Chef>();
                                    ChefRepository chefRepo = getRestAdapter().createRepository(ChefRepository.class);

                                    for (Map<String, Object> obj : result) {
                                        Chef chef = chefRepo.createObject(obj);
                                        chefList.add(chef);
                                    }
                                    callback.onSuccess(chefList);
                                }else{
                                    callback.onSuccess(null);
                                }
                            
                        }
                    });
                

            }//Method find definition ends here..

            

        
    
        
            //Method findOne definition
            public void findOne(  HashMap<String, Object> filter, final ObjectCallback<Chef> callback){
                


                
                    
                    
                    invokeStaticMethod("findOne", ImmutableMap.of("filter", filter), new Adapter.JsonObjectCallback() {
                    
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
            public void updateAttributes(  String chefId,  HashMap<String, Object> data, final ObjectCallback<Chef> callback){
                


                
                    
                    
                    invokeStaticMethod("prototype.updateAttributes", ImmutableMap.of("chefId", chefId, "data", data), new Adapter.JsonObjectCallback() {
                    
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
