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
import com.androidsdk.snaphy.snaphyandroidsdk.repository.CompanyInfoRepository;

//Now import repository of related models..


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class CompanyInfo extends Model {


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

    private CompanyInfo that ;

    public CompanyInfo (){
        that = this;
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

            
            
            
            

        
    
        
            
            
                private String html;
                /* Adding Getter and Setter methods */
                public String getHtml(){
                    return html;
                }

                /* Adding Getter and Setter methods */
                public void setHtml(String html){
                    this.html = html;
                    //Update hashMap value..
                    hashMap.put("html", html);
                }

            
            
            
            

        
    
        
            
            
                private String edited;
                /* Adding Getter and Setter methods */
                public String getEdited(){
                    return edited;
                }

                /* Adding Getter and Setter methods */
                public void setEdited(String edited){
                    this.edited = edited;
                    //Update hashMap value..
                    hashMap.put("edited", edited);
                }

            
            
            
            

        
    
        
            
            
            
            
            

        
    


    



    //Now adding relations between related models
      

}
