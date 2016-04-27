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
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.PopularityRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Chef extends Model {


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

            
            
            
            

        
    
        
            
            
            
            
            
                private Map<String, Object> geolocation = new HashMap();
                /* Adding Getter and Setter methods */
                public Map<String, Object> getGeolocation(){
                    return geolocation;
                }
                /* Adding Getter and Setter methods */
                public double getGeolocationLatitide(){
                    if(geolocation != null){
                        return (Double)geolocation.get("lat");
                    }else{
                        return 0;
                    }
                }

                /* Adding Getter and Setter methods */
                public double getGeolocationLongitude(){
                    if(geolocation != null){
                        return (Double)geolocation.get("lng");
                    }else{
                        return 0;
                    }

                }

                /* Adding Getter and Setter methods */
                public void setGeolocation(Map<String, Object> geolocation){
                    this.geolocation.putAll(geolocation);
                    //Update Map value..
                    hashMap.put("geolocation", geolocation);
                }

                /* Adding Getter and Setter methods */
                public void setGeolocation(double lat, double lng){
                    this.geolocation.put("lat", lat);
                    this.geolocation.put("lng", lng);
                    //Update Map value..
                    hashMap.put("geolocation", geolocation);
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

            
            
            
            

        
    
        
            
            
            
                private double allowedRecipes;
                /* Adding Getter and Setter methods */
                public double getAllowedRecipes(){
                    return allowedRecipes;
                }

                /* Adding Getter and Setter methods */
                public void setAllowedRecipes(double allowedRecipes){
                    this.allowedRecipes = allowedRecipes;
                    //Update hashMap value..
                    hashMap.put("allowedRecipes", allowedRecipes);
                }

            
            
            

        
    
        
            
            
                private String expiryDate;
                /* Adding Getter and Setter methods */
                public String getExpiryDate(){
                    return expiryDate;
                }

                /* Adding Getter and Setter methods */
                public void setExpiryDate(String expiryDate){
                    this.expiryDate = expiryDate;
                    //Update hashMap value..
                    hashMap.put("expiryDate", expiryDate);
                }

            
            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
                
                    //Define belongsTo relation method here..
                    private Customer  customer ;

                    public Customer getCustomer() {
                        return customer;
                    }

                    public void setCustomer(Customer customer) {
                        this.customer = customer;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setCustomer(Map<String, Object> customer) {
                        //First create a dummy Repo class object for customer.
                        CustomerRepository customerRepository = new CustomerRepository();
                        Customer customer1 = customerRepository.createObject(customer);
                        setCustomer(customer1);
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setCustomer(HashMap<String, Object> customer) {
                        //First create a dummy Repo class object for customer.
                        CustomerRepository customerRepository = new CustomerRepository();
                        Customer customer1 = customerRepository.createObject(customer);
                        setCustomer(customer1);
                    }

                    //Adding relation method..
                    public void addRelation(Customer customer) {
                        that.setCustomer(customer);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                    

                                    //Write the method here..
                                    public void get__customer( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Customer> callback) {
                                        //Define methods here..
                                        final ChefRepository  chefRepo = restAdapter.createRepository(ChefRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.get__customer( (String)that.getId(), refresh,  new ObjectCallback<Customer> (){
                                            

                                            
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
                                 
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                

                 
                 
             
          
    
        
                
                    //Define belongsTo relation method here..
                    private Popularity  popularities ;

                    public Popularity getPopularities() {
                        return popularities;
                    }

                    public void setPopularities(Popularity popularities) {
                        this.popularities = popularities;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setPopularities(Map<String, Object> popularities) {
                        //First create a dummy Repo class object for customer.
                        PopularityRepository popularitiesRepository = new PopularityRepository();
                        Popularity popularities1 = popularitiesRepository.createObject(popularities);
                        setPopularities(popularities1);
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
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.create__popularities( (String)that.getId(), data.convertMap(),  new ObjectCallback<Popularity> (){
                                            

                                            
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
                                        
                                        
                                        
                                        
                                        



                                        chefRepo.update__popularities( (String)that.getId(), data.convertMap(),  new ObjectCallback<Popularity> (){
                                            

                                            
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
