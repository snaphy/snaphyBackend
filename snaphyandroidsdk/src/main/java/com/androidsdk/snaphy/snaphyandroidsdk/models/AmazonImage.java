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
import com.androidsdk.snaphy.snaphyandroidsdk.repository.AmazonImageRepository;

//Now import repository of related models..


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class AmazonImage extends Model {


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

    private AmazonImage that ;

    public AmazonImage (){
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
                    //Update hashMap value..
                    hashMap.put("name", name);
                }

            
            
            
            

        
    
        
            
            
                private String container;
                /* Adding Getter and Setter methods */
                public String getContainer(){
                    return container;
                }

                /* Adding Getter and Setter methods */
                public void setContainer(String container){
                    this.container = container;
                    //Update hashMap value..
                    hashMap.put("container", container);
                }

            
            
            
            

        
    
        
            
            
                private String type;
                /* Adding Getter and Setter methods */
                public String getType(){
                    return type;
                }

                /* Adding Getter and Setter methods */
                public void setType(String type){
                    this.type = type;
                    //Update hashMap value..
                    hashMap.put("type", type);
                }

            
            
            
            

        
    
        
            
            
            
            
                private Map<String, Object> url;
                /* Adding Getter and Setter methods */
                public Map<String, Object> getUrl(){
                    return url;
                }

                /* Adding Getter and Setter methods */
                public void setUrl(Map<String, Object> url){
                    this.url = url;
                    //Update Map value..
                    hashMap.put("url", url);
                }

            
            

        
    
        
            
            
            
            
            

        
    


    



    //Now adding relations between related models
      

}
