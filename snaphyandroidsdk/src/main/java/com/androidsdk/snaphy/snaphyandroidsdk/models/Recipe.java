package com.androidsdk.snaphy.snaphyandroidsdk.models;




import com.strongloop.android.loopback.Model;


import com.strongloop.android.loopback.Model;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

//Now import repository of related models..

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.CustomerRepository;

    

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.CuisinesRepository;

    

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.PriorityRepository;

    

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.CategoryRepository;

    

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.CommentsRepository;

    

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeTagRepository;

    

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.IngredientsRepository;

    

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.WishlistRepository;

    


import java.util.ArrayList;
import java.util.HashMap;



public class Recipe extends Model {


    private Recipe that ;

    public Recipe (){
        that = this;
    }

    
        
            
            
                private String name;
                /* Adding Getter and Setter methods */
                public String getName(){
                    return name;
                }

                /* Adding Getter and Setter methods */
                public void setName(String name){
                    this.name = name;
                }

            
            
            

        
    
        
            
            
                private String description;
                /* Adding Getter and Setter methods */
                public String getDescription(){
                    return description;
                }

                /* Adding Getter and Setter methods */
                public void setDescription(String description){
                    this.description = description;
                }

            
            
            

        
    
        
            
            
            
            
                private HashMap<String, Object> mainImage;
                /* Adding Getter and Setter methods */
                public HashMap<String, Object> getMainImage(){
                    return mainImage;
                }

                /* Adding Getter and Setter methods */
                public void setMainImage(HashMap<String, Object> mainImage){
                    this.mainImage = mainImage;
                }

            

        
    
        
            
            
                private String recipeType;
                /* Adding Getter and Setter methods */
                public String getRecipeType(){
                    return recipeType;
                }

                /* Adding Getter and Setter methods */
                public void setRecipeType(String recipeType){
                    this.recipeType = recipeType;
                }

            
            
            

        
    
        
            
            
            
                private Double servings;
                /* Adding Getter and Setter methods */
                public Double getServings(){
                    return servings;
                }

                /* Adding Getter and Setter methods */
                public void setServings(Double servings){
                    this.servings = servings;
                }

            
            

        
    
        
            
            
                private String added;
                /* Adding Getter and Setter methods */
                public String getAdded(){
                    return added;
                }

                /* Adding Getter and Setter methods */
                public void setAdded(String added){
                    this.added = added;
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

            
            
            

        
    
        
            
            
                private String youtubeVideoId;
                /* Adding Getter and Setter methods */
                public String getYoutubeVideoId(){
                    return youtubeVideoId;
                }

                /* Adding Getter and Setter methods */
                public void setYoutubeVideoId(String youtubeVideoId){
                    this.youtubeVideoId = youtubeVideoId;
                }

            
            
            

        
    
        
            

                private ArrayList<HashMap<String, Object>> stepsImage;
                /* Adding Getter and Setter methods */
                public ArrayList<HashMap<String, Object>> getStepsImage(){
                    return stepsImage;
                }

                /* Adding Getter and Setter methods */
                public void setStepsImage(ArrayList<HashMap<String, Object>> stepsImage){
                    this.stepsImage = stepsImage;
                }

            
            
            
            

        
    
        
            

                private ArrayList<HashMap<String, Object>> stepsDescription;
                /* Adding Getter and Setter methods */
                public ArrayList<HashMap<String, Object>> getStepsDescription(){
                    return stepsDescription;
                }

                /* Adding Getter and Setter methods */
                public void setStepsDescription(ArrayList<HashMap<String, Object>> stepsDescription){
                    this.stepsDescription = stepsDescription;
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
                    final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                    


                    

                    

                    recipeRepo.get__customer(that.id, refresh,  new ObjectCallback<Customer> (){
                        

                        
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


                            
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                

            
            
            
        
    
        
            
            
            
                //Define hasAndBelongsToMany..

            
        
    
        
            
                //Define belongsTo relation method here..
                private Priority  priority ;

                public Priority getPriority() {
                    return priority;
                }

                public void setPriority(Priority priority) {
                    this.priority = priority;
                }

                //Adding related model automatically in case of include statement from server..
                public void setPriority(HashMap<String, Object> priority) {
                    //First create a dummy Repo class object for customer.
                    PriorityRepository priorityRepository = new PriorityRepository();
                    Priority priority1 = priorityRepository.createObject(priority);
                    setPriority(priority1);
                }

                //Adding relation method..
                public void addRelation(Priority priority) {
                    this.setCustomer(priority);
                }


                //Now add instance methods to fetch the related belongsTo Model..
                

                
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    

                //Write the method here..
                public void get__priorities( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Priority> callback) {
                    //Define methods here..
                    final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                    


                    

                    

                    recipeRepo.get__priorities(that.id, refresh,  new ObjectCallback<Priority> (){
                        

                        
                            @Override
                            public void onSuccess(Priority object) {
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
                public void create__priorities( Priority data,  RestAdapter restAdapter, final ObjectCallback<Priority> callback) {
                    //Define methods here..
                    final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                    


                    

                    

                    recipeRepo.create__priorities(that.id, data,  new ObjectCallback<Priority> (){
                        

                        
                            @Override
                            public void onSuccess(Priority object) {
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
                public void update__priorities( Priority data,  RestAdapter restAdapter, final ObjectCallback<Priority> callback) {
                    //Define methods here..
                    final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                    


                    

                    

                    recipeRepo.update__priorities(that.id, data,  new ObjectCallback<Priority> (){
                        

                        
                            @Override
                            public void onSuccess(Priority object) {
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
                public void destroy__priorities( RestAdapter restAdapter, final VoidCallback callback) {
                    //Define methods here..
                    final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                    


                    

                    

                    recipeRepo.destroy__priorities(that.id,  new VoidCallback (){
                        
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


                            
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                        
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                

            
            
            
        
    
        
            
            
            
                //Define hasAndBelongsToMany..

            
        
    
        
            
            
                //Define hasMany, hasManyThrough method here..

            
            
        
    
        
            
            
            
                //Define hasAndBelongsToMany..

            
        
    
        
            
            
                //Define hasMany, hasManyThrough method here..

            
            
        
    
        
            
            
            
                //Define hasAndBelongsToMany..

            
        
    

}
