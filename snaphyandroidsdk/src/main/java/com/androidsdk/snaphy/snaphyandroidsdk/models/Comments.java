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
import com.androidsdk.snaphy.snaphyandroidsdk.repository.CommentsRepository;

//Now import repository of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CustomerRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Comments extends Model {


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

    private Comments that ;

    public Comments (){
        that = this;
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

            
            
            
            

        
    
        
            
            
                private String comment;
                /* Adding Getter and Setter methods */
                public String getComment(){
                    return comment;
                }

                /* Adding Getter and Setter methods */
                public void setComment(String comment){
                    this.comment = comment;
                    //Update hashMap value..
                    hashMap.put("comment", comment);
                }

            
            
            
            

        
    
        
            
            
            
                private double rating;
                /* Adding Getter and Setter methods */
                public double getRating(){
                    return rating;
                }

                /* Adding Getter and Setter methods */
                public void setRating(double rating){
                    this.rating = rating;
                    //Update hashMap value..
                    hashMap.put("rating", rating);
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
                                        final CommentsRepository  commentsRepo = restAdapter.createRepository(CommentsRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        commentsRepo.get__customer( (String)that.getId(), refresh,  new ObjectCallback<Customer> (){
                                            

                                            
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
                    private Recipe  recipe ;

                    public Recipe getRecipe() {
                        return recipe;
                    }

                    public void setRecipe(Recipe recipe) {
                        this.recipe = recipe;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setRecipe(Map<String, Object> recipe) {
                        //First create a dummy Repo class object for customer.
                        RecipeRepository recipeRepository = new RecipeRepository();
                        Recipe recipe1 = recipeRepository.createObject(recipe);
                        setRecipe(recipe1);
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setRecipe(HashMap<String, Object> recipe) {
                        //First create a dummy Repo class object for customer.
                        RecipeRepository recipeRepository = new RecipeRepository();
                        Recipe recipe1 = recipeRepository.createObject(recipe);
                        setRecipe(recipe1);
                    }

                    //Adding relation method..
                    public void addRelation(Recipe recipe) {
                        that.setRecipe(recipe);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                        

                                    //Write the method here..
                                    public void get__recipe( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Recipe> callback) {
                                        //Define methods here..
                                        final CommentsRepository  commentsRepo = restAdapter.createRepository(CommentsRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        commentsRepo.get__recipe( (String)that.getId(), refresh,  new ObjectCallback<Recipe> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Recipe object) {
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
