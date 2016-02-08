package com.androidsdk.snaphy.snaphyandroidsdk.models;




import com.strongloop.android.loopback.Model;


import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

//Import self repository..
import com.androidsdk.snaphy.snaphyandroidsdk.repository.IngredientsRepository;

//Now import repository of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.IngredientCategoryRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;
            
                import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeIngredientsRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;



public class Ingredients extends Model {


    private Ingredients that ;

    public Ingredients (){
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

            
            
            

        
    
        
            
            
                private String sellingMetrics;
                /* Adding Getter and Setter methods */
                public String getSellingMetrics(){
                    return sellingMetrics;
                }

                /* Adding Getter and Setter methods */
                public void setSellingMetrics(String sellingMetrics){
                    this.sellingMetrics = sellingMetrics;
                }

            
            
            

        
    
        
            
            
            
                private Double minimumQuantity;
                /* Adding Getter and Setter methods */
                public Double getMinimumQuantity(){
                    return minimumQuantity;
                }

                /* Adding Getter and Setter methods */
                public void setMinimumQuantity(Double minimumQuantity){
                    this.minimumQuantity = minimumQuantity;
                }

            
            

        
    
        
            
            
            
                private Double price;
                /* Adding Getter and Setter methods */
                public Double getPrice(){
                    return price;
                }

                /* Adding Getter and Setter methods */
                public void setPrice(Double price){
                    this.price = price;
                }

            
            

        
    
        
            

                private ArrayList<HashMap<String, Object>> tags;
                /* Adding Getter and Setter methods */
                public ArrayList<HashMap<String, Object>> getTags(){
                    return tags;
                }

                /* Adding Getter and Setter methods */
                public void setTags(ArrayList<HashMap<String, Object>> tags){
                    this.tags = tags;
                }

            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
                
                    //Define belongsTo relation method here..
                    private IngredientCategory  ingredientCategory ;

                    public IngredientCategory getIngredientCategory() {
                        return ingredientCategory;
                    }

                    public void setIngredientCategory(IngredientCategory ingredientCategory) {
                        this.ingredientCategory = ingredientCategory;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setIngredientCategory(HashMap<String, Object> ingredientCategory) {
                        //First create a dummy Repo class object for customer.
                        IngredientCategoryRepository ingredientCategoryRepository = new IngredientCategoryRepository();
                        IngredientCategory ingredientCategory1 = ingredientCategoryRepository.createObject(ingredientCategory);
                        setIngredientCategory(ingredientCategory1);
                    }

                    //Adding relation method..
                    public void addRelation(IngredientCategory ingredientCategory) {
                        that.setIngredientCategory(ingredientCategory);
                    }


                    //Now add instance methods to fetch the related belongsTo Model..
                    

                    

                    //Write the method here..
                    public void get__ingredientCategory( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<IngredientCategory> callback) {
                        //Define methods here..
                        final IngredientsRepository  ingredientsRepo = restAdapter.createRepository(IngredientsRepository.class);
                        


                        

                        

                        ingredientsRepo.get__ingredientCategory( (String)that.getId(), refresh,  new ObjectCallback<IngredientCategory> (){
                            

                            
                                @Override
                                public void onSuccess(IngredientCategory object) {
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


                                
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                
                
                
            
        
    
        
                
                
                    //Define hasMany, hasManyThrough method here..

                
                
            
        
    

}
