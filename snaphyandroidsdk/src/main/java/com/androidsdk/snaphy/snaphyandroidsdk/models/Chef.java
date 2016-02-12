package com.androidsdk.snaphy.snaphyandroidsdk.models;




import com.strongloop.android.loopback.Model;



import org.json.JSONObject;
import org.json.JSONArray;

import java.util.List;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.Adapter;

//Import self repository..
import com.androidsdk.snaphy.snaphyandroidsdk.repository.ChefRepository;

//Now import repository of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CustomerRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CourseRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.ContactChefRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.PopularityRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;



public class Chef extends Model {


    //For converting all model values to hashMap
    private HashMap<String, Object> hashMap = new HashMap<>();

    public HashMap<String, Object> convertHashMap(){
        if(that.getId() != null){
            return hashMap;
        }else{
            hashMap.put("id", that.getId());
            return hashMap;
        }
    }

    private Chef that ;

    public Chef (){
        that = this;
    }

    
        
            
            
                private String address;
                /* Adding Getter and Setter methods */
                public String getAddress(){
                    return address;
                }

                /* Adding Getter and Setter methods */
                public void setAddress(String address){
                    this.address = address;
                    //Update hashMap value..
                    hashMap.put("address", address);
                }

            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
                private String status;
                /* Adding Getter and Setter methods */
                public String getStatus(){
                    return status;
                }

                /* Adding Getter and Setter methods */
                public void setStatus(String status){
                    this.status = status;
                    //Update hashMap value..
                    hashMap.put("status", status);
                }

            
            
            

        
    
        
            
            
                private String added;
                /* Adding Getter and Setter methods */
                public String getAdded(){
                    return added;
                }

                /* Adding Getter and Setter methods */
                public void setAdded(String added){
                    this.added = added;
                    //Update hashMap value..
                    hashMap.put("added", added);
                }

            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
                
                    //Define belongsTo relation method here..
                    private Customer  customers ;

                    public Customer getCustomers() {
                        return customers;
                    }

                    public void setCustomers(Customer customers) {
                        this.customers = customers;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setCustomers(HashMap<String, Object> customers) {
                        //First create a dummy Repo class object for customer.
                        CustomerRepository customersRepository = new CustomerRepository();
                        Customer customers1 = customersRepository.createObject(customers);
                        setCustomers(customers1);
                    }

                    //Adding relation method..
                    public void addRelation(Customer customers) {
                        that.setCustomers(customers);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                    

                                    //Write the method here..
                                    public void get__customers( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Customer> callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.get__customers( (String)that.getId(), refresh,  new ObjectCallback<Customer> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Customer object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            addRelation(object);
                                                            //Also add relation to child type for two way communication..Removing two way communication for cyclic error
                                                            //object.addRelation(that);
                                                            callback.onSuccess(object);
                                                        }else{
                                                            callback.onSuccess(null);
                                                        }

                                                    }
                                                
                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        

                                    //Write the method here..
                                    public void create__customers( Customer data,  RestAdapter restAdapter, final ObjectCallback<Customer> callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.create__customers( (String)that.getId(), data.convertHashMap(),  new ObjectCallback<Customer> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Customer object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            addRelation(object);
                                                            //Also add relation to child type for two way communication..Removing two way communication for cyclic error
                                                            //object.addRelation(that);
                                                            callback.onSuccess(object);
                                                        }else{
                                                            callback.onSuccess(null);
                                                        }

                                                    }
                                                
                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        

                                    //Write the method here..
                                    public void update__customers( Customer data,  RestAdapter restAdapter, final ObjectCallback<Customer> callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.update__customers( (String)that.getId(), data.convertHashMap(),  new ObjectCallback<Customer> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Customer object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            addRelation(object);
                                                            //Also add relation to child type for two way communication..Removing two way communication for cyclic error
                                                            //object.addRelation(that);
                                                            callback.onSuccess(object);
                                                        }else{
                                                            callback.onSuccess(null);
                                                        }

                                                    }
                                                
                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        

                                    //Write the method here..
                                    public void destroy__customers( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        



                                        chefRepo.destroy__customers( (String)that.getId(),  new VoidCallback (){
                                            
                                                @Override
                                                public void onSuccess() {
                                                    callback.onSuccess();
                                                }
                                            

                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                

                 
                 
             
          
    
        
                
                
                    
                    //Define hasMany relation method here..
                    private List<Course>  courses ;

                    public List<Course> getCourses() {
                        return courses;
                    }

                    public void setCourses(List<Course> courses) {
                        this.courses = courses;
                        //Disabling backend compatibility for cyclic error
                        /*
                        //Now add backward compatibility for the relation belongsTo for hasMany..
                        for (Course obj : courses) {
                            obj.addRelation(that);
                        }
                        */
                    }

                    //Adding related model automatically in case of include statement from server.. Adding 1 for removing same name error..
                    public void setCourses1(List<HashMap<String, Object>> courses) {
                        //First create a dummy Repo class object for ..
                        CourseRepository coursesRepository = new CourseRepository();
                        List<Course> result = new ArrayList<>();
                        for (HashMap<String, Object> obj : courses) {
                            //Also add relation to child type for two way communication..
                            Course obj1 = coursesRepository.createObject(obj);
                            result.add(obj1);

                        }
                        setCourses(result);

                    }


                    //Adding relation method..
                    //Add a dummy class Name object to seperate data..
                    public void addRelation(List<Course> courses, Course dummyClassInstance) {
                        that.setCourses(courses);

                    }

                    //Adding relation method..
                    //This will add a new data to the list relation object..
                    public void addRelation(Course courses) {
                        try{
                            that.getCourses().add(courses);
                        }catch(Exception e){
                            List< Course> courses1 = new ArrayList();
                            //Now add this item to list..
                            courses1.add(courses);
                            //Now set data....
                            that.setCourses(courses1);
                        }
                    }

                    


                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        

                                    //Write the method here..
                                    public void findById__courses( String fk,  RestAdapter restAdapter, final ObjectCallback<Course> callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.findById__courses( (String)that.getId(), fk,  new ObjectCallback<Course> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Course object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            addRelation(object);
                                                            //Also add relation to child type for two way communication..Removing two way communication for cyclic error
                                                            //object.addRelation(that);
                                                            callback.onSuccess(object);
                                                        }else{
                                                            callback.onSuccess(null);
                                                        }

                                                    }
                                                
                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        

                                    //Write the method here..
                                    public void destroyById__courses( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.destroyById__courses( (String)that.getId(), fk,  new VoidCallback (){
                                            
                                                @Override
                                                public void onSuccess() {
                                                    callback.onSuccess();
                                                }
                                            

                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        

                                    //Write the method here..
                                    public void updateById__courses( String fk,  Course data,  RestAdapter restAdapter, final ObjectCallback<Course> callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.updateById__courses( (String)that.getId(), fk, data.convertHashMap(),  new ObjectCallback<Course> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Course object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            addRelation(object);
                                                            //Also add relation to child type for two way communication..Removing two way communication for cyclic error
                                                            //object.addRelation(that);
                                                            callback.onSuccess(object);
                                                        }else{
                                                            callback.onSuccess(null);
                                                        }

                                                    }
                                                
                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                         
                            
                         
                            
                         
                            
                        

                                    //Write the method here..
                                    public void get__courses( HashMap<String, Object> filter,  RestAdapter restAdapter, final ListCallback<Course> callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.get__courses( (String)that.getId(), filter,  new ListCallback<Course> (){
                                            

                                            


                                            
                                                @Override
                                                
                                                    public void onSuccess(List<Course> object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            Course obj = new Course();
                                                            addRelation(object, obj);
                                                            //Disabling two way communication for cyclic error..
                                                            /*for (Course obj : object) {
                                                                //Also add relation to child type for two way communication..
                                                                obj.addRelation(that);
                                                            }*/

                                                            callback.onSuccess(object);
                                                        }else{
                                                            callback.onSuccess(null);
                                                        }

                                                    }
                                                
                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        

                                    //Write the method here..
                                    public void create__courses( Course data,  RestAdapter restAdapter, final ObjectCallback<Course> callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.create__courses( (String)that.getId(), data.convertHashMap(),  new ObjectCallback<Course> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Course object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            addRelation(object);
                                                            //Also add relation to child type for two way communication..Removing two way communication for cyclic error
                                                            //object.addRelation(that);
                                                            callback.onSuccess(object);
                                                        }else{
                                                            callback.onSuccess(null);
                                                        }

                                                    }
                                                
                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        

                                    //Write the method here..
                                    public void delete__courses( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        



                                        chefRepo.delete__courses( (String)that.getId(),  new VoidCallback (){
                                            
                                                @Override
                                                public void onSuccess() {
                                                    callback.onSuccess();
                                                }
                                            

                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        

                                    //Write the method here..
                                    public void count__courses( HashMap<String, Object> where,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.count__courses( (String)that.getId(), where,  new Adapter.JsonObjectCallback(){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(JSONObject object) {
                                                        callback.onSuccess(object);
                                                    }
                                                
                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                

                
                    //Define hasMany, hasManyThrough method here..

                 
                 
             
          
    
        
                
                
                    
                    //Define hasMany relation method here..
                    private List<ContactChef>  contactChefs ;

                    public List<ContactChef> getContactChefs() {
                        return contactChefs;
                    }

                    public void setContactChefs(List<ContactChef> contactChefs) {
                        this.contactChefs = contactChefs;
                        //Disabling backend compatibility for cyclic error
                        /*
                        //Now add backward compatibility for the relation belongsTo for hasMany..
                        for (ContactChef obj : contactChefs) {
                            obj.addRelation(that);
                        }
                        */
                    }

                    //Adding related model automatically in case of include statement from server.. Adding 1 for removing same name error..
                    public void setContactChefs1(List<HashMap<String, Object>> contactChefs) {
                        //First create a dummy Repo class object for ..
                        ContactChefRepository contactChefsRepository = new ContactChefRepository();
                        List<ContactChef> result = new ArrayList<>();
                        for (HashMap<String, Object> obj : contactChefs) {
                            //Also add relation to child type for two way communication..
                            ContactChef obj1 = contactChefsRepository.createObject(obj);
                            result.add(obj1);

                        }
                        setContactChefs(result);

                    }


                    //Adding relation method..
                    //Add a dummy class Name object to seperate data..
                    public void addRelation(List<ContactChef> contactChefs, ContactChef dummyClassInstance) {
                        that.setContactChefs(contactChefs);

                    }

                    //Adding relation method..
                    //This will add a new data to the list relation object..
                    public void addRelation(ContactChef contactChefs) {
                        try{
                            that.getContactChefs().add(contactChefs);
                        }catch(Exception e){
                            List< ContactChef> contactChefs1 = new ArrayList();
                            //Now add this item to list..
                            contactChefs1.add(contactChefs);
                            //Now set data....
                            that.setContactChefs(contactChefs1);
                        }
                    }

                    


                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        

                                    //Write the method here..
                                    public void findById__contactChefs( String fk,  RestAdapter restAdapter, final ObjectCallback<ContactChef> callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.findById__contactChefs( (String)that.getId(), fk,  new ObjectCallback<ContactChef> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(ContactChef object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            addRelation(object);
                                                            //Also add relation to child type for two way communication..Removing two way communication for cyclic error
                                                            //object.addRelation(that);
                                                            callback.onSuccess(object);
                                                        }else{
                                                            callback.onSuccess(null);
                                                        }

                                                    }
                                                
                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        

                                    //Write the method here..
                                    public void destroyById__contactChefs( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.destroyById__contactChefs( (String)that.getId(), fk,  new VoidCallback (){
                                            
                                                @Override
                                                public void onSuccess() {
                                                    callback.onSuccess();
                                                }
                                            

                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        

                                    //Write the method here..
                                    public void updateById__contactChefs( String fk,  ContactChef data,  RestAdapter restAdapter, final ObjectCallback<ContactChef> callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.updateById__contactChefs( (String)that.getId(), fk, data.convertHashMap(),  new ObjectCallback<ContactChef> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(ContactChef object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            addRelation(object);
                                                            //Also add relation to child type for two way communication..Removing two way communication for cyclic error
                                                            //object.addRelation(that);
                                                            callback.onSuccess(object);
                                                        }else{
                                                            callback.onSuccess(null);
                                                        }

                                                    }
                                                
                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        

                                    //Write the method here..
                                    public void get__contactChefs( HashMap<String, Object> filter,  RestAdapter restAdapter, final ListCallback<ContactChef> callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.get__contactChefs( (String)that.getId(), filter,  new ListCallback<ContactChef> (){
                                            

                                            


                                            
                                                @Override
                                                
                                                    public void onSuccess(List<ContactChef> object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            ContactChef obj = new ContactChef();
                                                            addRelation(object, obj);
                                                            //Disabling two way communication for cyclic error..
                                                            /*for (ContactChef obj : object) {
                                                                //Also add relation to child type for two way communication..
                                                                obj.addRelation(that);
                                                            }*/

                                                            callback.onSuccess(object);
                                                        }else{
                                                            callback.onSuccess(null);
                                                        }

                                                    }
                                                
                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        

                                    //Write the method here..
                                    public void create__contactChefs( ContactChef data,  RestAdapter restAdapter, final ObjectCallback<ContactChef> callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.create__contactChefs( (String)that.getId(), data.convertHashMap(),  new ObjectCallback<ContactChef> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(ContactChef object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            addRelation(object);
                                                            //Also add relation to child type for two way communication..Removing two way communication for cyclic error
                                                            //object.addRelation(that);
                                                            callback.onSuccess(object);
                                                        }else{
                                                            callback.onSuccess(null);
                                                        }

                                                    }
                                                
                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        

                                    //Write the method here..
                                    public void delete__contactChefs( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        



                                        chefRepo.delete__contactChefs( (String)that.getId(),  new VoidCallback (){
                                            
                                                @Override
                                                public void onSuccess() {
                                                    callback.onSuccess();
                                                }
                                            

                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        

                                    //Write the method here..
                                    public void count__contactChefs( HashMap<String, Object> where,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.count__contactChefs( (String)that.getId(), where,  new Adapter.JsonObjectCallback(){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(JSONObject object) {
                                                        callback.onSuccess(object);
                                                    }
                                                
                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                

                
                    //Define hasMany, hasManyThrough method here..

                 
                 
             
          
    
        
                
                    //Define belongsTo relation method here..
                    private Popularity  popularities ;

                    public Popularity getPopularities() {
                        return popularities;
                    }

                    public void setPopularities(Popularity popularities) {
                        this.popularities = popularities;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setPopularities(HashMap<String, Object> popularities) {
                        //First create a dummy Repo class object for customer.
                        PopularityRepository popularitiesRepository = new PopularityRepository();
                        Popularity popularities1 = popularitiesRepository.createObject(popularities);
                        setPopularities(popularities1);
                    }

                    //Adding relation method..
                    public void addRelation(Popularity popularities) {
                        that.setPopularities(popularities);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                         
                            
                         
                            
                         
                            
                        

                                    //Write the method here..
                                    public void get__popularities( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Popularity> callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.get__popularities( (String)that.getId(), refresh,  new ObjectCallback<Popularity> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Popularity object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            addRelation(object);
                                                            //Also add relation to child type for two way communication..Removing two way communication for cyclic error
                                                            //object.addRelation(that);
                                                            callback.onSuccess(object);
                                                        }else{
                                                            callback.onSuccess(null);
                                                        }

                                                    }
                                                
                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        

                                    //Write the method here..
                                    public void create__popularities( Popularity data,  RestAdapter restAdapter, final ObjectCallback<Popularity> callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.create__popularities( (String)that.getId(), data.convertHashMap(),  new ObjectCallback<Popularity> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Popularity object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            addRelation(object);
                                                            //Also add relation to child type for two way communication..Removing two way communication for cyclic error
                                                            //object.addRelation(that);
                                                            callback.onSuccess(object);
                                                        }else{
                                                            callback.onSuccess(null);
                                                        }

                                                    }
                                                
                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        

                                    //Write the method here..
                                    public void update__popularities( Popularity data,  RestAdapter restAdapter, final ObjectCallback<Popularity> callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.update__popularities( (String)that.getId(), data.convertHashMap(),  new ObjectCallback<Popularity> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Popularity object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            addRelation(object);
                                                            //Also add relation to child type for two way communication..Removing two way communication for cyclic error
                                                            //object.addRelation(that);
                                                            callback.onSuccess(object);
                                                        }else{
                                                            callback.onSuccess(null);
                                                        }

                                                    }
                                                
                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        

                                    //Write the method here..
                                    public void destroy__popularities( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        



                                        chefRepo.destroy__popularities( (String)that.getId(),  new VoidCallback (){
                                            
                                                @Override
                                                public void onSuccess() {
                                                    callback.onSuccess();
                                                }
                                            

                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                

                 
                 
             
          
      

}
