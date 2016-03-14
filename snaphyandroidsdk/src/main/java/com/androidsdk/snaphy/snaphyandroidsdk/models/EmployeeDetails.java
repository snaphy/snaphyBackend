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
import java.util.Map;



public class EmployeeDetails extends Model {


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
                    //Update hashMap value..
                    hashMap.put("address", address);
                }

            
            
            
            

        
    
        
            
            
                private String contactNumber;
                /* Adding Getter and Setter methods */
                public String getContactNumber(){
                    return contactNumber;
                }

                /* Adding Getter and Setter methods */
                public void setContactNumber(String contactNumber){
                    this.contactNumber = contactNumber;
                    //Update hashMap value..
                    hashMap.put("contactNumber", contactNumber);
                }

            
            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
                
                    //Define belongsTo relation method here..
                    private Employee  employee ;

                    public Employee getEmployee() {
                        return employee;
                    }

                    public void setEmployee(Employee employee) {
                        this.employee = employee;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setEmployee(Map<String, Object> employee) {
                        //First create a dummy Repo class object for customer.
                        EmployeeRepository employeeRepository = new EmployeeRepository();
                        Employee employee1 = employeeRepository.createObject(employee);
                        setEmployee(employee1);
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setEmployee(HashMap<String, Object> employee) {
                        //First create a dummy Repo class object for customer.
                        EmployeeRepository employeeRepository = new EmployeeRepository();
                        Employee employee1 = employeeRepository.createObject(employee);
                        setEmployee(employee1);
                    }

                    //Adding relation method..
                    public void addRelation(Employee employee) {
                        that.setEmployee(employee);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                    

                                    //Write the method here..
                                    public void get__employee( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Employee> callback) {
                                        //Define methods here..
                                        final EmployeeDetailsRepository  employeeDetailsRepo = restAdapter.createRepository(EmployeeDetailsRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        employeeDetailsRepo.get__employee( (String)that.getId(), refresh,  new ObjectCallback<Employee> (){
                                            

                                            
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
                                 
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                

                 
                 
             
          
      

}
