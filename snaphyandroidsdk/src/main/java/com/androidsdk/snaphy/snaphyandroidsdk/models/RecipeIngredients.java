package com.androidsdk.snaphy.snaphyandroidsdk.models;




import com.strongloop.android.loopback.Model;


import com.strongloop.android.loopback.Model;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

//Now import repository of related models..

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;

    

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.IngredientsRepository;

    


import java.util.ArrayList;
import java.util.HashMap;



public class RecipeIngredients extends Model {


    private RecipeIngredients that ;

    public RecipeIngredients (){
        that = this;
    }

    
        
            
            
            
                private Double quantity;
                /* Adding Getter and Setter methods */
                public Double getQuantity(){
                    return quantity;
                }

                /* Adding Getter and Setter methods */
                public void setQuantity(Double quantity){
                    this.quantity = quantity;
                }

            
            

        
    
        
            
            
                private String recipeMetric;
                /* Adding Getter and Setter methods */
                public String getRecipeMetric(){
                    return recipeMetric;
                }

                /* Adding Getter and Setter methods */
                public void setRecipeMetric(String recipeMetric){
                    this.recipeMetric = recipeMetric;
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
                public void get__recipe( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Recipe> callback) {
                    //Define methods here..
                    final RecipeIngredientsRepository  recipeIngredientsRepo = restAdapter.createRepository(RecipeIngredientsRepository.class);
                    


                    

                    

                    recipeIngredientsRepo.get__recipe(that.id, refresh,  new ObjectCallback<Recipe> (){
                        

                        
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


                            
                        
                    
                        
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                

            
            
            
        
    
        
            
                //Define belongsTo relation method here..
                private Ingredients  ingredients ;

                public Ingredients getIngredients() {
                    return ingredients;
                }

                public void setIngredients(Ingredients ingredients) {
                    this.ingredients = ingredients;
                }

                //Adding related model automatically in case of include statement from server..
                public void setIngredients(HashMap<String, Object> ingredients) {
                    //First create a dummy Repo class object for customer.
                    IngredientsRepository ingredientsRepository = new IngredientsRepository();
                    Ingredients ingredients1 = ingredientsRepository.createObject(ingredients);
                    setIngredients(ingredients1);
                }

                //Adding relation method..
                public void addRelation(Ingredients ingredients) {
                    this.setCustomer(ingredients);
                }


                //Now add instance methods to fetch the related belongsTo Model..
                

                
                        
                    

                //Write the method here..
                public void get__ingredients( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Ingredients> callback) {
                    //Define methods here..
                    final RecipeIngredientsRepository  recipeIngredientsRepo = restAdapter.createRepository(RecipeIngredientsRepository.class);
                    


                    

                    

                    recipeIngredientsRepo.get__ingredients(that.id, refresh,  new ObjectCallback<Ingredients> (){
                        

                        
                            @Override
                            public void onSuccess(Ingredients object) {
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
