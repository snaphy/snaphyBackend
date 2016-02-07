package com.androidsdk.snaphy.snaphyandroidsdk.models;




import com.strongloop.android.loopback.User;


import com.strongloop.android.loopback.Model;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

//Now import repository of related models..

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.AccessTokenRepository;

    

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.EmployeeDetailsRepository;

    


import java.util.ArrayList;
import java.util.HashMap;



public class Employee extends User {


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
                }

            
            
            

        
    
        
            
            
                private String firstName;
                /* Adding Getter and Setter methods */
                public String getFirstName(){
                    return firstName;
                }

                /* Adding Getter and Setter methods */
                public void setFirstName(String firstName){
                    this.firstName = firstName;
                }

            
            
            

        
    
        
            
            
                private String lastName;
                /* Adding Getter and Setter methods */
                public String getLastName(){
                    return lastName;
                }

                /* Adding Getter and Setter methods */
                public void setLastName(String lastName){
                    this.lastName = lastName;
                }

            
            
            

        
    
        
            
            
                private String date;
                /* Adding Getter and Setter methods */
                public String getDate(){
                    return date;
                }

                /* Adding Getter and Setter methods */
                public void setDate(String date){
                    this.date = date;
                }

            
            
            

        
    
        
            
            
                private String email;
                /* Adding Getter and Setter methods */
                public String getEmail(){
                    return email;
                }

                /* Adding Getter and Setter methods */
                public void setEmail(String email){
                    this.email = email;
                }

            
            
            

        
    
        
            
            
                private String password;
                /* Adding Getter and Setter methods */
                public String getPassword(){
                    return password;
                }

                /* Adding Getter and Setter methods */
                public void setPassword(String password){
                    this.password = password;
                }

            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
            
            
                //Define hasMany, hasManyThrough method here..

            
            
        
    
        
            
                //Define belongsTo relation method here..
                private EmployeeDetails  employeeDetails ;

                public EmployeeDetails getEmployeeDetails() {
                    return employeeDetails;
                }

                public void setEmployeeDetails(EmployeeDetails employeeDetails) {
                    this.employeeDetails = employeeDetails;
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
                    this.setCustomer(employeeDetails);
                }


                //Now add instance methods to fetch the related belongsTo Model..
                

                
                        
                    
                        
                    
                        
                    

                //Write the method here..
                public void get__employeeDetails( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<EmployeeDetails> callback) {
                    //Define methods here..
                    final EmployeeRepository  employeeRepo = restAdapter.createRepository(EmployeeRepository.class);
                    


                    

                    

                    employeeRepo.get__employeeDetails(that.id, refresh,  new ObjectCallback<EmployeeDetails> (){
                        

                        
                            @Override
                            public void onSuccess(EmployeeDetails object) {
                                //now add relation to this recipe.
                                addRelation(object);
                                //Also add relation to child type for two way communication..
                                object.addRelation(that);
                                callback.onSuccess(object);
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
                    


                    

                    

                    employeeRepo.create__employeeDetails(that.id, data,  new ObjectCallback<EmployeeDetails> (){
                        

                        
                            @Override
                            public void onSuccess(EmployeeDetails object) {
                                //now add relation to this recipe.
                                addRelation(object);
                                //Also add relation to child type for two way communication..
                                object.addRelation(that);
                                callback.onSuccess(object);
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
                    


                    

                    

                    employeeRepo.update__employeeDetails(that.id, data,  new ObjectCallback<EmployeeDetails> (){
                        

                        
                            @Override
                            public void onSuccess(EmployeeDetails object) {
                                //now add relation to this recipe.
                                addRelation(object);
                                //Also add relation to child type for two way communication..
                                object.addRelation(that);
                                callback.onSuccess(object);
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
                    


                    

                    

                    employeeRepo.destroy__employeeDetails(that.id,  new VoidCallback (){
                        
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
