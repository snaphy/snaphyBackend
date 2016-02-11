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
import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeAnalyticRepository;

//Now import repository of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;



public class RecipeAnalytic extends Model {


    private RecipeAnalytic that ;

    public RecipeAnalytic (){
        that = this;
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

            
            

        
    
        
            
            
                private String added;
                /* Adding Getter and Setter methods */
                public String getAdded(){
                    return added;
                }

                /* Adding Getter and Setter methods */
                public void setAdded(String added){
                    this.added = added;
                }

            
            
            

        
    
        
            
            
                private String lastModified;
                /* Adding Getter and Setter methods */
                public String getLastModified(){
                    return lastModified;
                }

                /* Adding Getter and Setter methods */
                public void setLastModified(String lastModified){
                    this.lastModified = lastModified;
                }

            
            
            

        
    
        
            
            
            
                private Double averageRating;
                /* Adding Getter and Setter methods */
                public Double getAverageRating(){
                    return averageRating;
                }

                /* Adding Getter and Setter methods */
                public void setAverageRating(Double averageRating){
                    this.averageRating = averageRating;
                }

            
            

        
    
        
            
            
            
                private Double totalComment;
                /* Adding Getter and Setter methods */
                public Double getTotalComment(){
                    return totalComment;
                }

                /* Adding Getter and Setter methods */
                public void setTotalComment(Double totalComment){
                    this.totalComment = totalComment;
                }

            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
                
                    //Define belongsTo relation method here..
                    private Recipe  recipes ;

                    public Recipe getRecipes() {
                        return recipes;
                    }

                    public void setRecipes(Recipe recipes) {
                        this.recipes = recipes;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setRecipes(HashMap<String, Object> recipes) {
                        //First create a dummy Repo class object for customer.
                        RecipeRepository recipesRepository = new RecipeRepository();
                        Recipe recipes1 = recipesRepository.createObject(recipes);
                        setRecipes(recipes1);
                    }

                    //Adding relation method..
                    public void addRelation(Recipe recipes) {
                        that.setRecipes(recipes);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                    

                                    //Write the method here..
                                    public void get__recipes( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Recipe> callback) {
                                        //Define methods here..
                                        final RecipeAnalyticRepository  recipeAnalyticRepo = restAdapter.createRepository(RecipeAnalyticRepository.class);
                                        


                                        

                                        

                                        recipeAnalyticRepo.get__recipes( (String)that.getId(), refresh,  new ObjectCallback<Recipe> (){
                                            

                                            
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
                                 
                            
                        

                                    //Write the method here..
                                    public void create__recipes( Recipe data,  RestAdapter restAdapter, final ObjectCallback<Recipe> callback) {
                                        //Define methods here..
                                        final RecipeAnalyticRepository  recipeAnalyticRepo = restAdapter.createRepository(RecipeAnalyticRepository.class);
                                        


                                        

                                        

                                        recipeAnalyticRepo.create__recipes( (String)that.getId(), data,  new ObjectCallback<Recipe> (){
                                            

                                            
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
                                 
                            
                        

                                    //Write the method here..
                                    public void update__recipes( Recipe data,  RestAdapter restAdapter, final ObjectCallback<Recipe> callback) {
                                        //Define methods here..
                                        final RecipeAnalyticRepository  recipeAnalyticRepo = restAdapter.createRepository(RecipeAnalyticRepository.class);
                                        


                                        

                                        

                                        recipeAnalyticRepo.update__recipes( (String)that.getId(), data,  new ObjectCallback<Recipe> (){
                                            

                                            
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
                                 
                            
                        

                                    //Write the method here..
                                    public void destroy__recipes( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeAnalyticRepository  recipeAnalyticRepo = restAdapter.createRepository(RecipeAnalyticRepository.class);
                                        


                                        

                                        

                                        recipeAnalyticRepo.destroy__recipes( (String)that.getId(),  new VoidCallback (){
                                            
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
