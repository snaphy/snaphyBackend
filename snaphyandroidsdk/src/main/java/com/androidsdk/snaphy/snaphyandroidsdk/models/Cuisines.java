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
import com.androidsdk.snaphy.snaphyandroidsdk.repository.CuisinesRepository;

//Now import repository of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Cuisines extends Model {


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

    private Cuisines that ;

    public Cuisines (){
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

            
            
            
            

        
    
        
            
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
                
                
                
                    //TODO ADD BACKWARD COMPATIBILITY FOR hasManyThrough relationship..warning backward compatibility may leads to cyclic error..
                    //Define belongsTo relation method here..
                    private List<Recipe>  recipes ;

                    public List<Recipe> getRecipes() {
                        return recipes;
                    }


                    public void setRecipes(List<Recipe> recipes) {
                        boolean hashType = false;
                        List<HashMap<String, Object>> hashMaps = new ArrayList<>();
                        for(Object o: recipes){
                            if(o.getClass().equals(HashMap.class)){
                                hashType = true;
                                HashMap<String, Object> dataObj = (HashMap<String, Object>)o;
                                hashMaps.add(dataObj);
                            }else if(o.getClass().equals(HashMap.class)){
                                hashType = true;
                                HashMap<String, Object> dataObj = (HashMap<String, Object>)o;
                                hashMaps.add(dataObj);
                            }
                        }

                        if(hashType){
                            setRecipes1(hashMaps);
                        }else{
                            this.recipes = recipes;
                        }
                    }

                    /*

                    //Adding related model automatically in case of include statement from server..
                    public void setRecipes1(List<Map<String, Object>> recipes) {
                        //First create a dummy Repo class object for ..
                        RecipeRepository recipesRepository = new RecipeRepository();
                        List<Recipe> result = new ArrayList<>();
                        for (Map<String, Object> obj : recipes) {
                            //Also add relation to child type for two way communication..
                            Recipe obj1 = recipesRepository.createObject(obj);
                            result.add(obj1);
                        }
                        setRecipes(result);
                    }

                    */

                    //Adding related model automatically in case of include statement from server..
                    public void setRecipes1(List<HashMap<String, Object>> recipes) {
                        //First create a dummy Repo class object for ..
                        RecipeRepository recipesRepository = new RecipeRepository();
                        List<Recipe> result = new ArrayList<>();
                        for (HashMap<String, Object> obj : recipes) {
                            //Also add relation to child type for two way communication..
                            Recipe obj1 = recipesRepository.createObject(obj);
                            result.add(obj1);
                        }
                        setRecipes(result);
                    }


                    //Adding relation method..
                    public void addRelation(List<Recipe> recipes, Recipe dummyClassInstance) {
                        that.setRecipes(recipes);
                    }


                    //Adding relation method..
                    //This will add a new data to the list relation object..
                    public void addRelation(Recipe recipes) {
                        try{
                            that.getRecipes().add(recipes);
                        }catch(Exception e){
                            List< Recipe> recipes1 = new ArrayList();
                            //Now add this item to list..
                            recipes1.add(recipes);
                            //Now set data....
                            that.setRecipes(recipes1);
                        }
                    }

                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                    

                                    //Write the method here..
                                    public void findById__recipes( String fk,  RestAdapter restAdapter, final ObjectCallback<Recipe> callback) {
                                        //Define methods here..
                                        final CuisinesRepository  cuisinesRepo = restAdapter.createRepository(CuisinesRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        cuisinesRepo.findById__recipes( (String)that.getId(), fk,  new ObjectCallback<Recipe> (){
                                            

                                            
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
                                    public void destroyById__recipes( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final CuisinesRepository  cuisinesRepo = restAdapter.createRepository(CuisinesRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        cuisinesRepo.destroyById__recipes( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                 
                            
                        

                                    //Write the method here..
                                    public void updateById__recipes( String fk,  Recipe data,  RestAdapter restAdapter, final ObjectCallback<Recipe> callback) {
                                        //Define methods here..
                                        final CuisinesRepository  cuisinesRepo = restAdapter.createRepository(CuisinesRepository.class);
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        



                                        cuisinesRepo.updateById__recipes( (String)that.getId(), fk, data.convertMap(),  new ObjectCallback<Recipe> (){
                                            

                                            
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
                                    public void link__recipes( String fk,  RestAdapter restAdapter, final ObjectCallback<Recipe> callback) {
                                        //Define methods here..
                                        final CuisinesRepository  cuisinesRepo = restAdapter.createRepository(CuisinesRepository.class);
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        



                                        cuisinesRepo.link__recipes( (String)that.getId(), fk,  new ObjectCallback<Recipe> (){
                                            

                                            
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
                                    public void unlink__recipes( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final CuisinesRepository  cuisinesRepo = restAdapter.createRepository(CuisinesRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        cuisinesRepo.unlink__recipes( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                 
                            
                        

                                    //Write the method here..
                                    public void exists__recipes( String fk,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final CuisinesRepository  cuisinesRepo = restAdapter.createRepository(CuisinesRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        cuisinesRepo.exists__recipes( (String)that.getId(), fk,  new Adapter.JsonObjectCallback(){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(JSONObject object) {
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
                                    public void get__recipes( Map<String,  ? extends Object> filter,  RestAdapter restAdapter, final ListCallback<Recipe> callback) {
                                        //Define methods here..
                                        final CuisinesRepository  cuisinesRepo = restAdapter.createRepository(CuisinesRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        cuisinesRepo.get__recipes( (String)that.getId(), filter,  new ListCallback<Recipe> (){
                                            

                                            


                                            
                                                @Override
                                                
                                                    public void onSuccess(List<Recipe> object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            Recipe obj = new Recipe();
                                                            addRelation(object, obj);
                                                            //Disabling two way communication for cyclic error..
                                                            /*for (Recipe obj : object) {
                                                                //Also add relation to child type for two way communication..
                                                                obj.addRelation(that);
                                                            }*/

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
                                        final CuisinesRepository  cuisinesRepo = restAdapter.createRepository(CuisinesRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        cuisinesRepo.create__recipes( (String)that.getId(), data.convertMap(),  new ObjectCallback<Recipe> (){
                                            

                                            
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
                                    public void delete__recipes( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final CuisinesRepository  cuisinesRepo = restAdapter.createRepository(CuisinesRepository.class);
                                        
                                        



                                        cuisinesRepo.delete__recipes( (String)that.getId(),  new VoidCallback (){
                                            
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
                                 
                            
                        

                                    //Write the method here..
                                    public void count__recipes( Map<String,  ? extends Object> where,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final CuisinesRepository  cuisinesRepo = restAdapter.createRepository(CuisinesRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        cuisinesRepo.count__recipes( (String)that.getId(), where,  new Adapter.JsonObjectCallback(){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(JSONObject object) {
                                                        callback.onSuccess(object);
                                                    }
                                                
                                            


                                            

                                            @Override
                                            public void onError(Throwable t) {
                                                //Now calling the callback
                                                callback.onError(t);
                                            }

                                        });
                                    } //method def ends here.
                                 
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                

                 
                
                    //Define hasAndBelongsToMany..

                 
             
          
      

}