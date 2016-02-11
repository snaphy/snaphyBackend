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
import com.androidsdk.snaphy.snaphyandroidsdk.repository.EmployeeDetailsRepository;

//Now import repository of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.EmployeeRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;



public class EmployeeDetails extends Model {


    private EmployeeDetails that ;

    public EmployeeDetails (){
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
                }

            
            
            

        
    
        
            
            
            
                private Double contactNumber;
                /* Adding Getter and Setter methods */
                public Double getContactNumber(){
                    return contactNumber;
                }

                /* Adding Getter and Setter methods */
                public void setContactNumber(Double contactNumber){
                    this.contactNumber = contactNumber;
                }

            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
                
                    //Define belongsTo relation method here..
                    private Employee  employees ;

                    public Employee getEmployees() {
                        return employees;
                    }

                    public void setEmployees(Employee employees) {
                        this.employees = employees;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setEmployees(HashMap<String, Object> employees) {
                        //First create a dummy Repo class object for customer.
                        EmployeeRepository employeesRepository = new EmployeeRepository();
                        Employee employees1 = employeesRepository.createObject(employees);
                        setEmployees(employees1);
                    }

                    //Adding relation method..
                    public void addRelation(Employee employees) {
                        that.setEmployees(employees);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                    

                                    //Write the method here..
                                    public void get__employees( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Employee> callback) {
                                        //Define methods here..
                                        final EmployeeDetailsRepository  employeeDetailsRepo = restAdapter.createRepository(EmployeeDetailsRepository.class);
                                        


                                        

                                        

                                        employeeDetailsRepo.get__employees( (String)that.getId(), refresh,  new ObjectCallback<Employee> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Employee object) {
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
                                    public void create__employees( Employee data,  RestAdapter restAdapter, final ObjectCallback<Employee> callback) {
                                        //Define methods here..
                                        final EmployeeDetailsRepository  employeeDetailsRepo = restAdapter.createRepository(EmployeeDetailsRepository.class);
                                        


                                        

                                        

                                        employeeDetailsRepo.create__employees( (String)that.getId(), data,  new ObjectCallback<Employee> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Employee object) {
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
                                    public void update__employees( Employee data,  RestAdapter restAdapter, final ObjectCallback<Employee> callback) {
                                        //Define methods here..
                                        final EmployeeDetailsRepository  employeeDetailsRepo = restAdapter.createRepository(EmployeeDetailsRepository.class);
                                        


                                        

                                        

                                        employeeDetailsRepo.update__employees( (String)that.getId(), data,  new ObjectCallback<Employee> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Employee object) {
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
                                    public void destroy__employees( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final EmployeeDetailsRepository  employeeDetailsRepo = restAdapter.createRepository(EmployeeDetailsRepository.class);
                                        


                                        

                                        

                                        employeeDetailsRepo.destroy__employees( (String)that.getId(),  new VoidCallback (){
                                            
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
