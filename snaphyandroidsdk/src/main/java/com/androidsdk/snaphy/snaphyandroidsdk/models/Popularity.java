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
import com.androidsdk.snaphy.snaphyandroidsdk.repository.PopularityRepository;

//Now import repository of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.ChefRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Popularity extends Model {


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

    private Popularity that ;

    public Popularity (){
        that = this;
    }

    
        
            
            
            
                private double popularity;
                /* Adding Getter and Setter methods */
                public double getPopularity(){
                    return popularity;
                }

                /* Adding Getter and Setter methods */
                public void setPopularity(double popularity){
                    this.popularity = popularity;
                    //Update hashMap value..
                    hashMap.put("popularity", popularity);
                }

            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
                
                    //Define belongsTo relation method here..
                    private Chef  chefs ;

                    public Chef getChefs() {
                        return chefs;
                    }

                    public void setChefs(Chef chefs) {
                        this.chefs = chefs;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setChefs(Map<String, Object> chefs) {
                        //First create a dummy Repo class object for customer.
                        ChefRepository chefsRepository = new ChefRepository();
                        Chef chefs1 = chefsRepository.createObject(chefs);
                        setChefs(chefs1);
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setChefs(HashMap<String, Object> chefs) {
                        //First create a dummy Repo class object for customer.
                        ChefRepository chefsRepository = new ChefRepository();
                        Chef chefs1 = chefsRepository.createObject(chefs);
                        setChefs(chefs1);
                    }

                    //Adding relation method..
                    public void addRelation(Chef chefs) {
                        that.setChefs(chefs);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                    

                                    //Write the method here..
                                    public void get__chefs( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Chef> callback) {
                                        //Define methods here..
                                        final PopularityRepository  popularityRepo = restAdapter.createRepository(PopularityRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        popularityRepo.get__chefs( (String)that.getId(), refresh,  new ObjectCallback<Chef> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Chef object) {
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
                                 
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                

                 
                 
             
          
      

}
