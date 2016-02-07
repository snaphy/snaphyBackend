package com.androidsdk.snaphy.snaphyandroidsdk.models;



import com.strongloop.android.loopback.Model;


import java.util.ArrayList;
import java.util.HashMap;


    


public class Recipe extends Model {



    
        
            
            
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

            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
}
