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
import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;

//Now import repository of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CustomerRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CuisinesRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CategoryRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CommentsRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeTagRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.IngredientsRepository;
            
                import com.androidsdk.snaphy.snaphyandroidsdk.models.RecipeIngredients;
                import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeIngredientsRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.WishlistRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeAnalyticRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Recipe extends Model {


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

    private Recipe that ;

    public Recipe (){
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

            
            
            
            

        
    
        
            
            
                private String description;
                /* Adding Getter and Setter methods */
                public String getDescription(){
                    return description;
                }

                /* Adding Getter and Setter methods */
                public void setDescription(String description){
                    this.description = description;
                    //Update hashMap value..
                    hashMap.put("description", description);
                }

            
            
            
            

        
    
        
            
            
            
            
                private Map<String, Object> mainImage;
                /* Adding Getter and Setter methods */
                public Map<String, Object> getMainImage(){
                    return mainImage;
                }

                /* Adding Getter and Setter methods */
                public void setMainImage(Map<String, Object> mainImage){
                    this.mainImage = mainImage;
                    //Update Map value..
                    hashMap.put("mainImage", mainImage);
                }

            
            

        
    
        
            
            
                private String recipeType;
                /* Adding Getter and Setter methods */
                public String getRecipeType(){
                    return recipeType;
                }

                /* Adding Getter and Setter methods */
                public void setRecipeType(String recipeType){
                    this.recipeType = recipeType;
                    //Update hashMap value..
                    hashMap.put("recipeType", recipeType);
                }

            
            
            
            

        
    
        
            
            
            
                private double servings;
                /* Adding Getter and Setter methods */
                public double getServings(){
                    return servings;
                }

                /* Adding Getter and Setter methods */
                public void setServings(double servings){
                    this.servings = servings;
                    //Update hashMap value..
                    hashMap.put("servings", servings);
                }

            
            
            

        
    
        
            
            
                private String added;
                /* Adding Getter and Setter methods */
                public String getAdded(){
                    return added;
                }

                /* Adding Getter and Setter methods */
                public void setAdded(String added){
                    this.added = added;
                    //Update hashMap value..
                    hashMap.put("added", added);
                }

            
            
            
            

        
    
        
            
            
                private String status;
                /* Adding Getter and Setter methods */
                public String getStatus(){
                    return status;
                }

                /* Adding Getter and Setter methods */
                public void setStatus(String status){
                    this.status = status;
                    //Update hashMap value..
                    hashMap.put("status", status);
                }

            
            
            
            

        
    
        
            
            
                private String youtubeVideoId;
                /* Adding Getter and Setter methods */
                public String getYoutubeVideoId(){
                    return youtubeVideoId;
                }

                /* Adding Getter and Setter methods */
                public void setYoutubeVideoId(String youtubeVideoId){
                    this.youtubeVideoId = youtubeVideoId;
                    //Update hashMap value..
                    hashMap.put("youtubeVideoId", youtubeVideoId);
                }

            
            
            
            

        
    
        
            
            
            
            
                private Map<String, Object> cuisines_;
                /* Adding Getter and Setter methods */
                public Map<String, Object> getCuisines_(){
                    return cuisines_;
                }

                /* Adding Getter and Setter methods */
                public void setCuisines_(Map<String, Object> cuisines_){
                    this.cuisines_ = cuisines_;
                    //Update Map value..
                    hashMap.put("cuisines_", cuisines_);
                }

            
            

        
    
        
            
            
            
            
                private Map<String, Object> category_;
                /* Adding Getter and Setter methods */
                public Map<String, Object> getCategory_(){
                    return category_;
                }

                /* Adding Getter and Setter methods */
                public void setCategory_(Map<String, Object> category_){
                    this.category_ = category_;
                    //Update Map value..
                    hashMap.put("category_", category_);
                }

            
            

        
    
        
            
            
            
            
                private Map<String, Object> recipeTags_;
                /* Adding Getter and Setter methods */
                public Map<String, Object> getRecipeTags_(){
                    return recipeTags_;
                }

                /* Adding Getter and Setter methods */
                public void setRecipeTags_(Map<String, Object> recipeTags_){
                    this.recipeTags_ = recipeTags_;
                    //Update Map value..
                    hashMap.put("recipeTags_", recipeTags_);
                }

            
            

        
    
        
            

                private List<Map<String, Object>> stepsImage;
                /* Adding Getter and Setter methods */
                public List<Map<String, Object>> getStepsImage(){
                    return stepsImage;
                }

                /* Adding Getter and Setter methods */
                public void setStepsImage(List<Map<String, Object>> stepsImage){
                    this.stepsImage = stepsImage;

                    //TODO change this to custom array with double quotes escaped if error occured when sending to server..
                    hashMap.put("stepsImage", stepsImage);
                }

            
            
            
            
            

        
    
        
            

                private List<Map<String, Object>> stepsDescription;
                /* Adding Getter and Setter methods */
                public List<Map<String, Object>> getStepsDescription(){
                    return stepsDescription;
                }

                /* Adding Getter and Setter methods */
                public void setStepsDescription(List<Map<String, Object>> stepsDescription){
                    this.stepsDescription = stepsDescription;

                    //TODO change this to custom array with double quotes escaped if error occured when sending to server..
                    hashMap.put("stepsDescription", stepsDescription);
                }

            
            
            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
                
                    //Define belongsTo relation method here..
                    private Customer  customer ;

                    public Customer getCustomer() {
                        return customer;
                    }

                    public void setCustomer(Customer customer) {
                        this.customer = customer;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setCustomer(Map<String, Object> customer) {
                        //First create a dummy Repo class object for customer.
                        CustomerRepository customerRepository = new CustomerRepository();
                        Customer customer1 = customerRepository.createObject(customer);
                        setCustomer(customer1);
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setCustomer(HashMap<String, Object> customer) {
                        //First create a dummy Repo class object for customer.
                        CustomerRepository customerRepository = new CustomerRepository();
                        Customer customer1 = customerRepository.createObject(customer);
                        setCustomer(customer1);
                    }

                    //Adding relation method..
                    public void addRelation(Customer customer) {
                        that.setCustomer(customer);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                    

                                    //Write the method here..
                                    public void get__customer( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Customer> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.get__customer( (String)that.getId(), refresh,  new ObjectCallback<Customer> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Customer object) {
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
                                 
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                

                 
                 
             
          
    
        
                
                
                
                    //TODO ADD BACKWARD COMPATIBILITY FOR hasManyThrough relationship..warning backward compatibility may leads to cyclic error..
                    //Define belongsTo relation method here..
                    private List<Cuisines>  cuisines ;

                    public List<Cuisines> getCuisines() {
                        return cuisines;
                    }


                    public void setCuisines(List<Cuisines> cuisines) {
                        boolean hashType = false;
                        List<HashMap<String, Object>> hashMaps = new ArrayList<>();
                        for(Object o: cuisines){
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
                            setCuisines1(hashMaps);
                        }else{
                            this.cuisines = cuisines;
                        }
                    }

                    /*

                    //Adding related model automatically in case of include statement from server..
                    public void setCuisines1(List<Map<String, Object>> cuisines) {
                        //First create a dummy Repo class object for ..
                        CuisinesRepository cuisinesRepository = new CuisinesRepository();
                        List<Cuisines> result = new ArrayList<>();
                        for (Map<String, Object> obj : cuisines) {
                            //Also add relation to child type for two way communication..
                            Cuisines obj1 = cuisinesRepository.createObject(obj);
                            result.add(obj1);
                        }
                        setCuisines(result);
                    }

                    */

                    //Adding related model automatically in case of include statement from server..
                    public void setCuisines1(List<HashMap<String, Object>> cuisines) {
                        //First create a dummy Repo class object for ..
                        CuisinesRepository cuisinesRepository = new CuisinesRepository();
                        List<Cuisines> result = new ArrayList<>();
                        for (HashMap<String, Object> obj : cuisines) {
                            //Also add relation to child type for two way communication..
                            Cuisines obj1 = cuisinesRepository.createObject(obj);
                            result.add(obj1);
                        }
                        setCuisines(result);
                    }


                    //Adding relation method..
                    public void addRelation(List<Cuisines> cuisines, Cuisines dummyClassInstance) {
                        that.setCuisines(cuisines);
                    }


                    //Adding relation method..
                    //This will add a new data to the list relation object..
                    public void addRelation(Cuisines cuisines) {
                        try{
                            that.getCuisines().add(cuisines);
                        }catch(Exception e){
                            List< Cuisines> cuisines1 = new ArrayList();
                            //Now add this item to list..
                            cuisines1.add(cuisines);
                            //Now set data....
                            that.setCuisines(cuisines1);
                        }
                    }

                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        

                                    //Write the method here..
                                    public void findById__cuisines( String fk,  RestAdapter restAdapter, final ObjectCallback<Cuisines> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.findById__cuisines( (String)that.getId(), fk,  new ObjectCallback<Cuisines> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Cuisines object) {
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
                                    public void destroyById__cuisines( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.destroyById__cuisines( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                    public void updateById__cuisines( String fk,  Cuisines data,  RestAdapter restAdapter, final ObjectCallback<Cuisines> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.updateById__cuisines( (String)that.getId(), fk, data.convertMap(),  new ObjectCallback<Cuisines> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Cuisines object) {
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
                                    public void link__cuisines( String fk,  RestAdapter restAdapter, final ObjectCallback<Cuisines> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.link__cuisines( (String)that.getId(), fk,  new ObjectCallback<Cuisines> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Cuisines object) {
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
                                    public void unlink__cuisines( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.unlink__cuisines( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                    public void exists__cuisines( String fk,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.exists__cuisines( (String)that.getId(), fk,  new Adapter.JsonObjectCallback(){
                                            

                                            
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
                                    public void get__cuisines( Map<String,  ? extends Object> filter,  RestAdapter restAdapter, final ListCallback<Cuisines> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.get__cuisines( (String)that.getId(), filter,  new ListCallback<Cuisines> (){
                                            

                                            


                                            
                                                @Override
                                                
                                                    public void onSuccess(List<Cuisines> object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            Cuisines obj = new Cuisines();
                                                            addRelation(object, obj);
                                                            //Disabling two way communication for cyclic error..
                                                            /*for (Cuisines obj : object) {
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
                                    public void create__cuisines( Cuisines data,  RestAdapter restAdapter, final ObjectCallback<Cuisines> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.create__cuisines( (String)that.getId(), data.convertMap(),  new ObjectCallback<Cuisines> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Cuisines object) {
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
                                    public void delete__cuisines( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        



                                        recipeRepo.delete__cuisines( (String)that.getId(),  new VoidCallback (){
                                            
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
                                    public void count__cuisines( Map<String,  ? extends Object> where,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.count__cuisines( (String)that.getId(), where,  new Adapter.JsonObjectCallback(){
                                            

                                            
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

                 
             
          
    
        
                
                
                
                    //TODO ADD BACKWARD COMPATIBILITY FOR hasManyThrough relationship..warning backward compatibility may leads to cyclic error..
                    //Define belongsTo relation method here..
                    private List<Category>  category ;

                    public List<Category> getCategory() {
                        return category;
                    }


                    public void setCategory(List<Category> category) {
                        boolean hashType = false;
                        List<HashMap<String, Object>> hashMaps = new ArrayList<>();
                        for(Object o: category){
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
                            setCategory1(hashMaps);
                        }else{
                            this.category = category;
                        }
                    }

                    /*

                    //Adding related model automatically in case of include statement from server..
                    public void setCategory1(List<Map<String, Object>> category) {
                        //First create a dummy Repo class object for ..
                        CategoryRepository categoryRepository = new CategoryRepository();
                        List<Category> result = new ArrayList<>();
                        for (Map<String, Object> obj : category) {
                            //Also add relation to child type for two way communication..
                            Category obj1 = categoryRepository.createObject(obj);
                            result.add(obj1);
                        }
                        setCategory(result);
                    }

                    */

                    //Adding related model automatically in case of include statement from server..
                    public void setCategory1(List<HashMap<String, Object>> category) {
                        //First create a dummy Repo class object for ..
                        CategoryRepository categoryRepository = new CategoryRepository();
                        List<Category> result = new ArrayList<>();
                        for (HashMap<String, Object> obj : category) {
                            //Also add relation to child type for two way communication..
                            Category obj1 = categoryRepository.createObject(obj);
                            result.add(obj1);
                        }
                        setCategory(result);
                    }


                    //Adding relation method..
                    public void addRelation(List<Category> category, Category dummyClassInstance) {
                        that.setCategory(category);
                    }


                    //Adding relation method..
                    //This will add a new data to the list relation object..
                    public void addRelation(Category category) {
                        try{
                            that.getCategory().add(category);
                        }catch(Exception e){
                            List< Category> category1 = new ArrayList();
                            //Now add this item to list..
                            category1.add(category);
                            //Now set data....
                            that.setCategory(category1);
                        }
                    }

                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                        

                                    //Write the method here..
                                    public void findById__category( String fk,  RestAdapter restAdapter, final ObjectCallback<Category> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.findById__category( (String)that.getId(), fk,  new ObjectCallback<Category> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Category object) {
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
                                    public void destroyById__category( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.destroyById__category( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                    public void updateById__category( String fk,  Category data,  RestAdapter restAdapter, final ObjectCallback<Category> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.updateById__category( (String)that.getId(), fk, data.convertMap(),  new ObjectCallback<Category> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Category object) {
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
                                    public void link__category( String fk,  RestAdapter restAdapter, final ObjectCallback<Category> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.link__category( (String)that.getId(), fk,  new ObjectCallback<Category> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Category object) {
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
                                    public void unlink__category( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.unlink__category( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                    public void exists__category( String fk,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.exists__category( (String)that.getId(), fk,  new Adapter.JsonObjectCallback(){
                                            

                                            
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
                                    public void get__category( Map<String,  ? extends Object> filter,  RestAdapter restAdapter, final ListCallback<Category> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.get__category( (String)that.getId(), filter,  new ListCallback<Category> (){
                                            

                                            


                                            
                                                @Override
                                                
                                                    public void onSuccess(List<Category> object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            Category obj = new Category();
                                                            addRelation(object, obj);
                                                            //Disabling two way communication for cyclic error..
                                                            /*for (Category obj : object) {
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
                                    public void create__category( Category data,  RestAdapter restAdapter, final ObjectCallback<Category> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.create__category( (String)that.getId(), data.convertMap(),  new ObjectCallback<Category> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Category object) {
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
                                    public void delete__category( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        



                                        recipeRepo.delete__category( (String)that.getId(),  new VoidCallback (){
                                            
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
                                    public void count__category( Map<String,  ? extends Object> where,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.count__category( (String)that.getId(), where,  new Adapter.JsonObjectCallback(){
                                            

                                            
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

                 
             
          
    
        
                
                
                    
                    //Define hasMany relation method here..
                    private List<Comments>  comments ;

                    public List<Comments> getComments() {
                        return comments;
                    }

                    public void setComments(List<Comments> comments) {
                        boolean hashType = false;
                        List<HashMap<String, Object>> hashMaps = new ArrayList<>();
                        for(Object o: comments){
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
                            setComments1(hashMaps);
                        }else{
                            this.comments = comments;
                        }
                    }

                /*    //Adding related model automatically in case of include statement from server.. Adding 1 for removing same name error..
                    public void setComments1(List<Map<String, Object>> comments) {
                        //First create a dummy Repo class object for ..
                        CommentsRepository commentsRepository = new CommentsRepository();
                        List<Comments> result = new ArrayList<>();
                        for (Map<String, Object> obj : comments) {
                            //Also add relation to child type for two way communication..
                            Comments obj1 = commentsRepository.createObject(obj);
                            result.add(obj1);

                        }
                        setComments(result);

                    }

                */

                    //Adding related model automatically in case of include statement from server.. Adding 1 for removing same name error..
                    public void setComments1(List<HashMap<String, Object>> comments) {
                        //First create a dummy Repo class object for ..
                        CommentsRepository commentsRepository = new CommentsRepository();
                        List<Comments> result = new ArrayList<>();
                        for (HashMap<String, Object> obj : comments) {
                            //Also add relation to child type for two way communication..
                            Comments obj1 = commentsRepository.createObject(obj);
                            result.add(obj1);

                        }
                        setComments(result);

                    }


                    //Adding relation method..
                    //Add a dummy class Name object to seperate data..
                    public void addRelation(List<Comments> comments, Comments dummyClassInstance) {
                        that.setComments(comments);

                    }

                    //Adding relation method..
                    //This will add a new data to the list relation object..
                    public void addRelation(Comments comments) {
                        try{
                            that.getComments().add(comments);
                        }catch(Exception e){
                            List< Comments> comments1 = new ArrayList();
                            //Now add this item to list..
                            comments1.add(comments);
                            //Now set data....
                            that.setComments(comments1);
                        }
                    }

                    


                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        

                                    //Write the method here..
                                    public void findById__comments( String fk,  RestAdapter restAdapter, final ObjectCallback<Comments> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.findById__comments( (String)that.getId(), fk,  new ObjectCallback<Comments> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Comments object) {
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
                                    public void destroyById__comments( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.destroyById__comments( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                    public void updateById__comments( String fk,  Comments data,  RestAdapter restAdapter, final ObjectCallback<Comments> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.updateById__comments( (String)that.getId(), fk, data.convertMap(),  new ObjectCallback<Comments> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Comments object) {
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
                                    public void get__comments( Map<String,  ? extends Object> filter,  RestAdapter restAdapter, final ListCallback<Comments> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.get__comments( (String)that.getId(), filter,  new ListCallback<Comments> (){
                                            

                                            


                                            
                                                @Override
                                                
                                                    public void onSuccess(List<Comments> object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            Comments obj = new Comments();
                                                            addRelation(object, obj);
                                                            //Disabling two way communication for cyclic error..
                                                            /*for (Comments obj : object) {
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
                                    public void create__comments( Comments data,  RestAdapter restAdapter, final ObjectCallback<Comments> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.create__comments( (String)that.getId(), data.convertMap(),  new ObjectCallback<Comments> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Comments object) {
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
                                    public void delete__comments( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        



                                        recipeRepo.delete__comments( (String)that.getId(),  new VoidCallback (){
                                            
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
                                    public void count__comments( Map<String,  ? extends Object> where,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.count__comments( (String)that.getId(), where,  new Adapter.JsonObjectCallback(){
                                            

                                            
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
                                 
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                

                
                    //Define hasMany, hasManyThrough method here..

                 
                 
             
          
    
        
                
                
                
                    //TODO ADD BACKWARD COMPATIBILITY FOR hasManyThrough relationship..warning backward compatibility may leads to cyclic error..
                    //Define belongsTo relation method here..
                    private List<RecipeTag>  recipeTags ;

                    public List<RecipeTag> getRecipeTags() {
                        return recipeTags;
                    }


                    public void setRecipeTags(List<RecipeTag> recipeTags) {
                        boolean hashType = false;
                        List<HashMap<String, Object>> hashMaps = new ArrayList<>();
                        for(Object o: recipeTags){
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
                            setRecipeTags1(hashMaps);
                        }else{
                            this.recipeTags = recipeTags;
                        }
                    }

                    /*

                    //Adding related model automatically in case of include statement from server..
                    public void setRecipeTags1(List<Map<String, Object>> recipeTags) {
                        //First create a dummy Repo class object for ..
                        RecipeTagRepository recipeTagsRepository = new RecipeTagRepository();
                        List<RecipeTag> result = new ArrayList<>();
                        for (Map<String, Object> obj : recipeTags) {
                            //Also add relation to child type for two way communication..
                            RecipeTag obj1 = recipeTagsRepository.createObject(obj);
                            result.add(obj1);
                        }
                        setRecipeTags(result);
                    }

                    */

                    //Adding related model automatically in case of include statement from server..
                    public void setRecipeTags1(List<HashMap<String, Object>> recipeTags) {
                        //First create a dummy Repo class object for ..
                        RecipeTagRepository recipeTagsRepository = new RecipeTagRepository();
                        List<RecipeTag> result = new ArrayList<>();
                        for (HashMap<String, Object> obj : recipeTags) {
                            //Also add relation to child type for two way communication..
                            RecipeTag obj1 = recipeTagsRepository.createObject(obj);
                            result.add(obj1);
                        }
                        setRecipeTags(result);
                    }


                    //Adding relation method..
                    public void addRelation(List<RecipeTag> recipeTags, RecipeTag dummyClassInstance) {
                        that.setRecipeTags(recipeTags);
                    }


                    //Adding relation method..
                    //This will add a new data to the list relation object..
                    public void addRelation(RecipeTag recipeTags) {
                        try{
                            that.getRecipeTags().add(recipeTags);
                        }catch(Exception e){
                            List< RecipeTag> recipeTags1 = new ArrayList();
                            //Now add this item to list..
                            recipeTags1.add(recipeTags);
                            //Now set data....
                            that.setRecipeTags(recipeTags1);
                        }
                    }

                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        

                                    //Write the method here..
                                    public void findById__recipeTags( String fk,  RestAdapter restAdapter, final ObjectCallback<RecipeTag> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.findById__recipeTags( (String)that.getId(), fk,  new ObjectCallback<RecipeTag> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(RecipeTag object) {
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
                                    public void destroyById__recipeTags( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.destroyById__recipeTags( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                    public void updateById__recipeTags( String fk,  RecipeTag data,  RestAdapter restAdapter, final ObjectCallback<RecipeTag> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.updateById__recipeTags( (String)that.getId(), fk, data.convertMap(),  new ObjectCallback<RecipeTag> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(RecipeTag object) {
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
                                    public void link__recipeTags( String fk,  RestAdapter restAdapter, final ObjectCallback<RecipeTag> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.link__recipeTags( (String)that.getId(), fk,  new ObjectCallback<RecipeTag> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(RecipeTag object) {
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
                                    public void unlink__recipeTags( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.unlink__recipeTags( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                    public void exists__recipeTags( String fk,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.exists__recipeTags( (String)that.getId(), fk,  new Adapter.JsonObjectCallback(){
                                            

                                            
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
                                    public void get__recipeTags( Map<String,  ? extends Object> filter,  RestAdapter restAdapter, final ListCallback<RecipeTag> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.get__recipeTags( (String)that.getId(), filter,  new ListCallback<RecipeTag> (){
                                            

                                            


                                            
                                                @Override
                                                
                                                    public void onSuccess(List<RecipeTag> object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            RecipeTag obj = new RecipeTag();
                                                            addRelation(object, obj);
                                                            //Disabling two way communication for cyclic error..
                                                            /*for (RecipeTag obj : object) {
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
                                    public void create__recipeTags( RecipeTag data,  RestAdapter restAdapter, final ObjectCallback<RecipeTag> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.create__recipeTags( (String)that.getId(), data.convertMap(),  new ObjectCallback<RecipeTag> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(RecipeTag object) {
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
                                    public void delete__recipeTags( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        



                                        recipeRepo.delete__recipeTags( (String)that.getId(),  new VoidCallback (){
                                            
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
                                    public void count__recipeTags( Map<String,  ? extends Object> where,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.count__recipeTags( (String)that.getId(), where,  new Adapter.JsonObjectCallback(){
                                            

                                            
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

                 
             
          
    
        
                
                
                    
                    //Define hasMany relation method here..
                    private List<Ingredients>  ingredients ;

                    public List<Ingredients> getIngredients() {
                        return ingredients;
                    }

                    public void setIngredients(List<Ingredients> ingredients) {
                        boolean hashType = false;
                        List<HashMap<String, Object>> hashMaps = new ArrayList<>();
                        for(Object o: ingredients){
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
                            setIngredients1(hashMaps);
                        }else{
                            this.ingredients = ingredients;
                        }
                    }

                /*    //Adding related model automatically in case of include statement from server.. Adding 1 for removing same name error..
                    public void setIngredients1(List<Map<String, Object>> ingredients) {
                        //First create a dummy Repo class object for ..
                        IngredientsRepository ingredientsRepository = new IngredientsRepository();
                        List<Ingredients> result = new ArrayList<>();
                        for (Map<String, Object> obj : ingredients) {
                            //Also add relation to child type for two way communication..
                            Ingredients obj1 = ingredientsRepository.createObject(obj);
                            result.add(obj1);

                        }
                        setIngredients(result);

                    }

                */

                    //Adding related model automatically in case of include statement from server.. Adding 1 for removing same name error..
                    public void setIngredients1(List<HashMap<String, Object>> ingredients) {
                        //First create a dummy Repo class object for ..
                        IngredientsRepository ingredientsRepository = new IngredientsRepository();
                        List<Ingredients> result = new ArrayList<>();
                        for (HashMap<String, Object> obj : ingredients) {
                            //Also add relation to child type for two way communication..
                            Ingredients obj1 = ingredientsRepository.createObject(obj);
                            result.add(obj1);

                        }
                        setIngredients(result);

                    }


                    //Adding relation method..
                    //Add a dummy class Name object to seperate data..
                    public void addRelation(List<Ingredients> ingredients, Ingredients dummyClassInstance) {
                        that.setIngredients(ingredients);

                    }

                    //Adding relation method..
                    //This will add a new data to the list relation object..
                    public void addRelation(Ingredients ingredients) {
                        try{
                            that.getIngredients().add(ingredients);
                        }catch(Exception e){
                            List< Ingredients> ingredients1 = new ArrayList();
                            //Now add this item to list..
                            ingredients1.add(ingredients);
                            //Now set data....
                            that.setIngredients(ingredients1);
                        }
                    }

                    
                        //Write hasManyThrough def too..
                        private List<RecipeIngredients>  recipeIngredients ;

                        public List<RecipeIngredients> getRecipeIngredients() {
                            return recipeIngredients;
                        }

                        public void setRecipeIngredients(List<RecipeIngredients> recipeIngredients) {
                            this.recipeIngredients = recipeIngredients;
                        }

                        //Adding throughRelation method..
                        //Add a dummy class Name object to seperate data..
                        public void addRelation(List<RecipeIngredients> recipeIngredients, RecipeIngredients dummyClassInstance) {
                            that.setRecipeIngredients(recipeIngredients);

                        }

                        //Adding throughRelation method..
                        //This will add a new data to the list throughRelation object..
                        public void addRelation(RecipeIngredients recipeIngredients) {
                            try{
                                that.getRecipeIngredients().add(recipeIngredients);
                            }catch(Exception e){
                                List< RecipeIngredients> recipeIngredients1 = new ArrayList();
                                //Now add this item to list..
                                recipeIngredients1.add(recipeIngredients);
                                //Now set data....
                                that.setRecipeIngredients(recipeIngredients1);
                            }
                        }


                    


                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        

                                    //Write the method here..
                                    public void findById__ingredients( String fk,  RestAdapter restAdapter, final ObjectCallback<Ingredients> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.findById__ingredients( (String)that.getId(), fk,  new ObjectCallback<Ingredients> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Ingredients object) {
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
                                    public void destroyById__ingredients( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.destroyById__ingredients( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                    public void updateById__ingredients( String fk,  Ingredients data,  RestAdapter restAdapter, final ObjectCallback<Ingredients> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.updateById__ingredients( (String)that.getId(), fk, data.convertMap(),  new ObjectCallback<Ingredients> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Ingredients object) {
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
                                    public void link__ingredients( String fk,  RecipeIngredients data,  RestAdapter restAdapter, final ObjectCallback<RecipeIngredients> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.link__ingredients( (String)that.getId(), fk, data.convertMap(),  new ObjectCallback<RecipeIngredients> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(RecipeIngredients object) {
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
                                    public void unlink__ingredients( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.unlink__ingredients( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                    public void exists__ingredients( String fk,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.exists__ingredients( (String)that.getId(), fk,  new Adapter.JsonObjectCallback(){
                                            

                                            
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
                                    public void get__ingredients( Map<String,  ? extends Object> filter,  RestAdapter restAdapter, final ListCallback<Ingredients> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.get__ingredients( (String)that.getId(), filter,  new ListCallback<Ingredients> (){
                                            

                                            


                                            
                                                @Override
                                                
                                                    public void onSuccess(List<Ingredients> object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            Ingredients obj = new Ingredients();
                                                            addRelation(object, obj);
                                                            //Disabling two way communication for cyclic error..
                                                            /*for (Ingredients obj : object) {
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
                                    public void create__ingredients( Ingredients data,  RestAdapter restAdapter, final ObjectCallback<Ingredients> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.create__ingredients( (String)that.getId(), data.convertMap(),  new ObjectCallback<Ingredients> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Ingredients object) {
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
                                    public void delete__ingredients( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        



                                        recipeRepo.delete__ingredients( (String)that.getId(),  new VoidCallback (){
                                            
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
                                    public void count__ingredients( Map<String,  ? extends Object> where,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.count__ingredients( (String)that.getId(), where,  new Adapter.JsonObjectCallback(){
                                            

                                            
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
                                 
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                

                
                    //Define hasMany, hasManyThrough method here..

                 
                 
             
          
    
        
                
                
                
                    //TODO ADD BACKWARD COMPATIBILITY FOR hasManyThrough relationship..warning backward compatibility may leads to cyclic error..
                    //Define belongsTo relation method here..
                    private List<Wishlist>  wishlists ;

                    public List<Wishlist> getWishlists() {
                        return wishlists;
                    }


                    public void setWishlists(List<Wishlist> wishlists) {
                        boolean hashType = false;
                        List<HashMap<String, Object>> hashMaps = new ArrayList<>();
                        for(Object o: wishlists){
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
                            setWishlists1(hashMaps);
                        }else{
                            this.wishlists = wishlists;
                        }
                    }

                    /*

                    //Adding related model automatically in case of include statement from server..
                    public void setWishlists1(List<Map<String, Object>> wishlists) {
                        //First create a dummy Repo class object for ..
                        WishlistRepository wishlistsRepository = new WishlistRepository();
                        List<Wishlist> result = new ArrayList<>();
                        for (Map<String, Object> obj : wishlists) {
                            //Also add relation to child type for two way communication..
                            Wishlist obj1 = wishlistsRepository.createObject(obj);
                            result.add(obj1);
                        }
                        setWishlists(result);
                    }

                    */

                    //Adding related model automatically in case of include statement from server..
                    public void setWishlists1(List<HashMap<String, Object>> wishlists) {
                        //First create a dummy Repo class object for ..
                        WishlistRepository wishlistsRepository = new WishlistRepository();
                        List<Wishlist> result = new ArrayList<>();
                        for (HashMap<String, Object> obj : wishlists) {
                            //Also add relation to child type for two way communication..
                            Wishlist obj1 = wishlistsRepository.createObject(obj);
                            result.add(obj1);
                        }
                        setWishlists(result);
                    }


                    //Adding relation method..
                    public void addRelation(List<Wishlist> wishlists, Wishlist dummyClassInstance) {
                        that.setWishlists(wishlists);
                    }


                    //Adding relation method..
                    //This will add a new data to the list relation object..
                    public void addRelation(Wishlist wishlists) {
                        try{
                            that.getWishlists().add(wishlists);
                        }catch(Exception e){
                            List< Wishlist> wishlists1 = new ArrayList();
                            //Now add this item to list..
                            wishlists1.add(wishlists);
                            //Now set data....
                            that.setWishlists(wishlists1);
                        }
                    }

                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        

                                    //Write the method here..
                                    public void findById__wishlists( String fk,  RestAdapter restAdapter, final ObjectCallback<Wishlist> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.findById__wishlists( (String)that.getId(), fk,  new ObjectCallback<Wishlist> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Wishlist object) {
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
                                    public void destroyById__wishlists( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.destroyById__wishlists( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                    public void updateById__wishlists( String fk,  Wishlist data,  RestAdapter restAdapter, final ObjectCallback<Wishlist> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.updateById__wishlists( (String)that.getId(), fk, data.convertMap(),  new ObjectCallback<Wishlist> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Wishlist object) {
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
                                    public void link__wishlists( String fk,  RestAdapter restAdapter, final ObjectCallback<Wishlist> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.link__wishlists( (String)that.getId(), fk,  new ObjectCallback<Wishlist> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Wishlist object) {
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
                                    public void unlink__wishlists( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.unlink__wishlists( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                    public void exists__wishlists( String fk,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.exists__wishlists( (String)that.getId(), fk,  new Adapter.JsonObjectCallback(){
                                            

                                            
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
                                    public void get__wishlists( Map<String,  ? extends Object> filter,  RestAdapter restAdapter, final ListCallback<Wishlist> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.get__wishlists( (String)that.getId(), filter,  new ListCallback<Wishlist> (){
                                            

                                            


                                            
                                                @Override
                                                
                                                    public void onSuccess(List<Wishlist> object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            Wishlist obj = new Wishlist();
                                                            addRelation(object, obj);
                                                            //Disabling two way communication for cyclic error..
                                                            /*for (Wishlist obj : object) {
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
                                    public void create__wishlists( Wishlist data,  RestAdapter restAdapter, final ObjectCallback<Wishlist> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.create__wishlists( (String)that.getId(), data.convertMap(),  new ObjectCallback<Wishlist> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Wishlist object) {
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
                                    public void delete__wishlists( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        



                                        recipeRepo.delete__wishlists( (String)that.getId(),  new VoidCallback (){
                                            
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
                                    public void count__wishlists( Map<String,  ? extends Object> where,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.count__wishlists( (String)that.getId(), where,  new Adapter.JsonObjectCallback(){
                                            

                                            
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

                 
             
          
    
        
                
                    //Define belongsTo relation method here..
                    private RecipeAnalytic  recipeAnalytics ;

                    public RecipeAnalytic getRecipeAnalytics() {
                        return recipeAnalytics;
                    }

                    public void setRecipeAnalytics(RecipeAnalytic recipeAnalytics) {
                        this.recipeAnalytics = recipeAnalytics;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setRecipeAnalytics(Map<String, Object> recipeAnalytics) {
                        //First create a dummy Repo class object for customer.
                        RecipeAnalyticRepository recipeAnalyticsRepository = new RecipeAnalyticRepository();
                        RecipeAnalytic recipeAnalytics1 = recipeAnalyticsRepository.createObject(recipeAnalytics);
                        setRecipeAnalytics(recipeAnalytics1);
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setRecipeAnalytics(HashMap<String, Object> recipeAnalytics) {
                        //First create a dummy Repo class object for customer.
                        RecipeAnalyticRepository recipeAnalyticsRepository = new RecipeAnalyticRepository();
                        RecipeAnalytic recipeAnalytics1 = recipeAnalyticsRepository.createObject(recipeAnalytics);
                        setRecipeAnalytics(recipeAnalytics1);
                    }

                    //Adding relation method..
                    public void addRelation(RecipeAnalytic recipeAnalytics) {
                        that.setRecipeAnalytics(recipeAnalytics);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        

                                    //Write the method here..
                                    public void get__recipeAnalytics( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<RecipeAnalytic> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.get__recipeAnalytics( (String)that.getId(), refresh,  new ObjectCallback<RecipeAnalytic> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(RecipeAnalytic object) {
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
                                    public void create__recipeAnalytics( RecipeAnalytic data,  RestAdapter restAdapter, final ObjectCallback<RecipeAnalytic> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.create__recipeAnalytics( (String)that.getId(), data.convertMap(),  new ObjectCallback<RecipeAnalytic> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(RecipeAnalytic object) {
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
                                    public void update__recipeAnalytics( RecipeAnalytic data,  RestAdapter restAdapter, final ObjectCallback<RecipeAnalytic> callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeRepo.update__recipeAnalytics( (String)that.getId(), data.convertMap(),  new ObjectCallback<RecipeAnalytic> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(RecipeAnalytic object) {
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
                                    public void destroy__recipeAnalytics( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final RecipeRepository  recipeRepo = restAdapter.createRepository(RecipeRepository.class);
                                        
                                        



                                        recipeRepo.destroy__recipeAnalytics( (String)that.getId(),  new VoidCallback (){
                                            
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
