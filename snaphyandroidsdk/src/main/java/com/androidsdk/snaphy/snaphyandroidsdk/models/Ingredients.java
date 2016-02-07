package com.androidsdk.snaphy.snaphyandroidsdk.models;



import com.strongloop.android.loopback.Model;


import java.util.ArrayList;
import java.util.HashMap;


    


public class Ingredients extends Model {



    
        
            
            
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

            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
}
