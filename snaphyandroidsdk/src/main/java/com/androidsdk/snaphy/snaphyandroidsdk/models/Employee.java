package com.androidsdk.snaphy.snaphyandroidsdk.models;




import com.strongloop.android.loopback.User;



import org.json.JSONObject;
import org.json.JSONArray;

import java.util.List;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.Adapter;

//Import self repository..
import com.androidsdk.snaphy.snaphyandroidsdk.repository.EmployeeRepository;

//Now import repository of related models..

    
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.EmployeeDetailsRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Employee extends com.strongloop.android.loopback.User {


    //For converting all model values to hashMap
    private Map<String, Object> hashMap = new HashMap<>();

    public Map<String,  ? extends Object> convertMap(){
        if(that.getId() != null){
            return hashMap;
        }else{
            hashMap.put("id", that.getId());
            return hashMap;
        }
    }

    private Employee that ;

    public Employee (){
        that = this;
    }

    
        
            
            
                private String username;
                /* Adding Getter and Setter methods */
                public String getUsername(){
                    return username;
                }

                /* Adding Getter and Setter methods */
                public void setUsername(String username){
                    this.username = username;
                    //Update hashMap value..
                    hashMap.put("username", username);
                }

            
            
            
            

        
    
        
            
            
                private String firstName;
                /* Adding Getter and Setter methods */
                public String getFirstName(){
                    return firstName;
                }

                /* Adding Getter and Setter methods */
                public void setFirstName(String firstName){
                    this.firstName = firstName;
                    //Update hashMap value..
                    hashMap.put("firstName", firstName);
                }

            
            
            
            

        
    
        
            
            
                private String lastName;
                /* Adding Getter and Setter methods */
                public String getLastName(){
                    return lastName;
                }

                /* Adding Getter and Setter methods */
                public void setLastName(String lastName){
                    this.lastName = lastName;
                    //Update hashMap value..
                    hashMap.put("lastName", lastName);
                }

            
            
            
            

        
    
        
            
            
                private String date;
                /* Adding Getter and Setter methods */
                public String getDate(){
                    return date;
                }

                /* Adding Getter and Setter methods */
                public void setDate(String date){
                    this.date = date;
                    //Update hashMap value..
                    hashMap.put("date", date);
                }

            
            
            
            

        
    
        
            
            
                private String email;
                /* Adding Getter and Setter methods */
                public String getEmail(){
                    return email;
                }

                /* Adding Getter and Setter methods */
                public void setEmail(String email){
                    this.email = email;
                    //Update hashMap value..
                    hashMap.put("email", email);
                }

            
            
            
            

        
    
        
            
            
                private String password;
                /* Adding Getter and Setter methods */
                public String getPassword(){
                    return password;
                }

                /* Adding Getter and Setter methods */
                public void setPassword(String password){
                    this.password = password;
                    //Update hashMap value..
                    hashMap.put("password", password);
                }

            
            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    


    



    //Now adding relations between related models
    
         
          
    
        
                
                    //Define belongsTo relation method here..
                    private EmployeeDetails  employeeDetails ;

                    public EmployeeDetails getEmployeeDetails() {
                        return employeeDetails;
                    }

                    public void setEmployeeDetails(EmployeeDetails employeeDetails) {
                        this.employeeDetails = employeeDetails;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setEmployeeDetails(Map<String, Object> employeeDetails) {
                        //First create a dummy Repo class object for customer.
                        EmployeeDetailsRepository employeeDetailsRepository = new EmployeeDetailsRepository();
                        EmployeeDetails employeeDetails1 = employeeDetailsRepository.createObject(employeeDetails);
                        setEmployeeDetails(employeeDetails1);
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setEmployeeDetails(HashMap<String, Object> employeeDetails) {
                        //First create a dummy Repo class object for customer.
                        EmployeeDetailsRepository employeeDetailsRepository = new EmployeeDetailsRepository();
                        EmployeeDetails employeeDetails1 = employeeDetailsRepository.createObject(employeeDetails);
                        setEmployeeDetails(employeeDetails1);
                    }

                    //Adding relation method..
                    public void addRelation(EmployeeDetails employeeDetails) {
                        that.setEmployeeDetails(employeeDetails);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                         
                            
                         
                            
                        

                                    //Write the method here..
                                    public void get__employeeDetails( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<EmployeeDetails> callback) {
                                        //Define methods here..
                                        final EmployeeRepository  employeeRepo = restAdapter.createRepository(EmployeeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        employeeRepo.get__employeeDetails( (String)that.getId(), refresh,  new ObjectCallback<EmployeeDetails> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(EmployeeDetails object) {
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
                                    public void create__employeeDetails( EmployeeDetails data,  RestAdapter restAdapter, final ObjectCallback<EmployeeDetails> callback) {
                                        //Define methods here..
                                        final EmployeeRepository  employeeRepo = restAdapter.createRepository(EmployeeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        employeeRepo.create__employeeDetails( (String)that.getId(), data.convertMap(),  new ObjectCallback<EmployeeDetails> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(EmployeeDetails object) {
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
                                    public void update__employeeDetails( EmployeeDetails data,  RestAdapter restAdapter, final ObjectCallback<EmployeeDetails> callback) {
                                        //Define methods here..
                                        final EmployeeRepository  employeeRepo = restAdapter.createRepository(EmployeeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        employeeRepo.update__employeeDetails( (String)that.getId(), data.convertMap(),  new ObjectCallback<EmployeeDetails> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(EmployeeDetails object) {
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
                                    public void destroy__employeeDetails( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final EmployeeRepository  employeeRepo = restAdapter.createRepository(EmployeeRepository.class);
                                        
                                        



                                        employeeRepo.destroy__employeeDetails( (String)that.getId(),  new VoidCallback (){
                                            
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
