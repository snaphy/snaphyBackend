package com.androidsdk.snaphy.snaphyandroidsdk.models;




import com.strongloop.android.loopback.Model;


import com.strongloop.android.loopback.Model;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

//Now import repository of related models..

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;

    


import java.util.ArrayList;
import java.util.HashMap;



public class Priority extends Model {


    private Priority that ;

    public Priority (){
        that = this;
    }

    
        
            
            
                private String priority;
                /* Adding Getter and Setter methods */
                public String getPriority(){
                    return priority;
                }

                /* Adding Getter and Setter methods */
                public void setPriority(String priority){
                    this.priority = priority;
                }

            
            
            

        
    
        
            
            
            
                private Double totalViews;
                /* Adding Getter and Setter methods */
                public Double getTotalViews(){
                    return totalViews;
                }

                /* Adding Getter and Setter methods */
                public void setTotalViews(Double totalViews){
                    this.totalViews = totalViews;
                }

            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
            
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
                public void get__recipes( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Recipe> callback) {
                    //Define methods here..
                    final PriorityRepository  priorityRepo = restAdapter.createRepository(PriorityRepository.class);
                    


                    

                    

                    priorityRepo.get__recipes(that.id, refresh,  new ObjectCallback<Recipe> (){
                        

                        
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


                            
                        
                    

                //Write the method here..
                public void create__recipes( Recipe data,  RestAdapter restAdapter, final ObjectCallback<Recipe> callback) {
                    //Define methods here..
                    final PriorityRepository  priorityRepo = restAdapter.createRepository(PriorityRepository.class);
                    


                    

                    

                    priorityRepo.create__recipes(that.id, data,  new ObjectCallback<Recipe> (){
                        

                        
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


                            
                        
                    

                //Write the method here..
                public void update__recipes( Recipe data,  RestAdapter restAdapter, final ObjectCallback<Recipe> callback) {
                    //Define methods here..
                    final PriorityRepository  priorityRepo = restAdapter.createRepository(PriorityRepository.class);
                    


                    

                    

                    priorityRepo.update__recipes(that.id, data,  new ObjectCallback<Recipe> (){
                        

                        
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


                            
                        
                    

                //Write the method here..
                public void destroy__recipes( RestAdapter restAdapter, final VoidCallback callback) {
                    //Define methods here..
                    final PriorityRepository  priorityRepo = restAdapter.createRepository(PriorityRepository.class);
                    


                    

                    

                    priorityRepo.destroy__recipes(that.id,  new VoidCallback (){
                        
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
