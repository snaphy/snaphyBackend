package com.androidsdk.snaphy.snaphyandroidsdk.models;




import com.strongloop.android.loopback.Model;


import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

//Import self repository..
import com.androidsdk.snaphy.snaphyandroidsdk.repository.IngredientCategoryRepository;

//Now import repository of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.IngredientsRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;



public class IngredientCategory extends Model {


    private IngredientCategory that ;

    public IngredientCategory (){
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

            
            
            

        
    
        
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
                
                
                    //Define hasMany, hasManyThrough method here..

                
                
            
        
    

}
