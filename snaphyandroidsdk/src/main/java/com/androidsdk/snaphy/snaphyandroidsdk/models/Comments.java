package com.androidsdk.snaphy.snaphyandroidsdk.models;




import com.strongloop.android.loopback.Model;


import com.strongloop.android.loopback.Model;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

//Now import repository of related models..

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.CustomerRepository;

    

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;

    


import java.util.ArrayList;
import java.util.HashMap;



public class Comments extends Model {


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
                }

            
            
            

        
    
        
            
            
                private String status;
                /* Adding Getter and Setter methods */
                public String getStatus(){
                    return status;
                }

                /* Adding Getter and Setter methods */
                public void setStatus(String status){
                    this.status = status;
                }

            
            
            

        
    
        
            
            
                private String comment;
                /* Adding Getter and Setter methods */
                public String getComment(){
                    return comment;
                }

                /* Adding Getter and Setter methods */
                public void setComment(String comment){
                    this.comment = comment;
                }

            
            
            

        
    
        
            
            
            
                private Double rating;
                /* Adding Getter and Setter methods */
                public Double getRating(){
                    return rating;
                }

                /* Adding Getter and Setter methods */
                public void setRating(Double rating){
                    this.rating = rating;
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
                public void setCustomer(HashMap<String, Object> customer) {
                    //First create a dummy Repo class object for customer.
                    CustomerRepository customerRepository = new CustomerRepository();
                    Customer customer1 = customerRepository.createObject(customer);
                    setCustomer(customer1);
                }

                //Adding relation method..
                public void addRelation(Customer customer) {
                    this.setCustomer(customer);
                }


                //Now add instance methods to fetch the related belongsTo Model..
                

                

                //Write the method here..
                public void get__customer( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Customer> callback) {
                    //Define methods here..
                    final CommentsRepository  commentsRepo = restAdapter.createRepository(CommentsRepository.class);
                    


                    

                    

                    commentsRepo.get__customer(that.id, refresh,  new ObjectCallback<Customer> (){
                        

                        
                            @Override
                            public void onSuccess(Customer object) {
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


                            
                        
                    
                        
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                

            
            
            
        
    
        
            
                //Define belongsTo relation method here..
                private Recipe  recipe ;

                public Recipe getRecipe() {
                    return recipe;
                }

                public void setRecipe(Recipe recipe) {
                    this.recipe = recipe;
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
                    this.setCustomer(recipe);
                }


                //Now add instance methods to fetch the related belongsTo Model..
                

                
                        
                    

                //Write the method here..
                public void get__recipe( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Recipe> callback) {
                    //Define methods here..
                    final CommentsRepository  commentsRepo = restAdapter.createRepository(CommentsRepository.class);
                    


                    

                    

                    commentsRepo.get__recipe(that.id, refresh,  new ObjectCallback<Recipe> (){
                        

                        
                            @Override
                            public void onSuccess(Recipe object) {
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


                            
                        
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                

            
            
            
        
    

}
