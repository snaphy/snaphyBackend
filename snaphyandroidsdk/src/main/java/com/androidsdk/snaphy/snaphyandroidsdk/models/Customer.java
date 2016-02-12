package com.androidsdk.snaphy.snaphyandroidsdk.models;




import com.strongloop.android.loopback.User;



import org.json.JSONObject;
import org.json.JSONArray;

import java.util.List;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.Adapter;

//Import self repository..
import com.androidsdk.snaphy.snaphyandroidsdk.repository.CustomerRepository;

//Now import repository of related models..

    
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CommentsRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.WishlistRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.ChefRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.ContactChefRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.OrderRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeAnalyticRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;



public class Customer extends com.strongloop.android.loopback.User {


    private Customer that ;

    public Customer (){
        that = this;
    }

    
        
            
            
                private String date;
                /* Adding Getter and Setter methods */
                public String getDate(){
                    return date;
                }

                /* Adding Getter and Setter methods */
                public void setDate(String date){
                    this.date = date;
                }

            
            
            

        
    
        
            
            
                private String phoneNumber;
                /* Adding Getter and Setter methods */
                public String getPhoneNumber(){
                    return phoneNumber;
                }

                /* Adding Getter and Setter methods */
                public void setPhoneNumber(String phoneNumber){
                    this.phoneNumber = phoneNumber;
                }

            
            
            

        
    
        
            
            
                private String email;
                /* Adding Getter and Setter methods */
                public String getEmail(){
                    return email;
                }

                /* Adding Getter and Setter methods */
                public void setEmail(String email){
                    this.email = email;
                }

            
            
            

        
    
        
            
            
                private String firstName;
                /* Adding Getter and Setter methods */
                public String getFirstName(){
                    return firstName;
                }

                /* Adding Getter and Setter methods */
                public void setFirstName(String firstName){
                    this.firstName = firstName;
                }

            
            
            

        
    
        
            
            
                private String lastName;
                /* Adding Getter and Setter methods */
                public String getLastName(){
                    return lastName;
                }

                /* Adding Getter and Setter methods */
                public void setLastName(String lastName){
                    this.lastName = lastName;
                }

            
            
            

        
    
        
            
            
                private String password;
                /* Adding Getter and Setter methods */
                public String getPassword(){
                    return password;
                }

                /* Adding Getter and Setter methods */
                public void setPassword(String password){
                    this.password = password;
                }

            
            
            

        
    
        
            
            
            
            
                private HashMap<String, Object> profilePic;
                /* Adding Getter and Setter methods */
                public HashMap<String, Object> getProfilePic(){
                    return profilePic;
                }

                /* Adding Getter and Setter methods */
                public void setProfilePic(HashMap<String, Object> profilePic){
                    this.profilePic = profilePic;
                }

            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    


    



    //Now adding relations between related models
    
         
          
    
        
                
                
                    
                    //Define hasMany relation method here..
                    private List<Recipe>  recipes ;

                    public List<Recipe> getRecipes() {
                        return recipes;
                    }

                    public void setRecipes(List<Recipe> recipes) {
                        this.recipes = recipes;
                        //Disabling backend compatibility for cyclic error
                        /*
                        //Now add backward compatibility for the relation belongsTo for hasMany..
                        for (Recipe obj : recipes) {
                            obj.addRelation(that);
                        }
                        */
                    }

                    //Adding related model automatically in case of include statement from server.. Adding 1 for removing same name error..
                    public void setRecipes1(List<HashMap<String, Object>> recipes) {
                        //First create a dummy Repo class object for ..
                        RecipeRepository recipesRepository = new RecipeRepository();
                        List<Recipe> result = new ArrayList<>();
                        for (HashMap<String, Object> obj : recipes) {
                            //Also add relation to child type for two way communication..
                            Recipe obj1 = recipesRepository.createObject(obj);
                            //Disabling backend compatibility for cyclic error
                            /*//Now add backward compatibility for the relation belongsTo for hasMany..
                            obj1.addRelation(that);*/
                            result.add(obj1);
                        }
                        setRecipes(result);
                    }


                    //Adding relation method..
                    //Add a dummy class Name object to seperate data..
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
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.findById__recipes( (String)that.getId(), fk,  new ObjectCallback<Recipe> (){
                                            

                                            
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
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.destroyById__recipes( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.updateById__recipes( (String)that.getId(), fk, data,  new ObjectCallback<Recipe> (){
                                            

                                            
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
                                    public void get__recipes( HashMap<String, Object> filter,  RestAdapter restAdapter, final ListCallback<Recipe> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.get__recipes( (String)that.getId(), filter,  new ListCallback<Recipe> (){
                                            

                                            


                                            
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
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.create__recipes( (String)that.getId(), data,  new ObjectCallback<Recipe> (){
                                            

                                            
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
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.delete__recipes( (String)that.getId(),  new VoidCallback (){
                                            
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
                                    public void count__recipes( HashMap<String, Object> where,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.count__recipes( (String)that.getId(), where,  new Adapter.JsonObjectCallback(){
                                            

                                            
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

                 
                 
             
          
    
        
                
                
                    
                    //Define hasMany relation method here..
                    private List<Comments>  comments ;

                    public List<Comments> getComments() {
                        return comments;
                    }

                    public void setComments(List<Comments> comments) {
                        this.comments = comments;
                        //Disabling backend compatibility for cyclic error
                        /*
                        //Now add backward compatibility for the relation belongsTo for hasMany..
                        for (Comments obj : comments) {
                            obj.addRelation(that);
                        }
                        */
                    }

                    //Adding related model automatically in case of include statement from server.. Adding 1 for removing same name error..
                    public void setComments1(List<HashMap<String, Object>> comments) {
                        //First create a dummy Repo class object for ..
                        CommentsRepository commentsRepository = new CommentsRepository();
                        List<Comments> result = new ArrayList<>();
                        for (HashMap<String, Object> obj : comments) {
                            //Also add relation to child type for two way communication..
                            Comments obj1 = commentsRepository.createObject(obj);
                            //Disabling backend compatibility for cyclic error
                            /*//Now add backward compatibility for the relation belongsTo for hasMany..
                            obj1.addRelation(that);*/
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
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.findById__comments( (String)that.getId(), fk,  new ObjectCallback<Comments> (){
                                            

                                            
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
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.destroyById__comments( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.updateById__comments( (String)that.getId(), fk, data,  new ObjectCallback<Comments> (){
                                            

                                            
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
                                    public void get__comments( HashMap<String, Object> filter,  RestAdapter restAdapter, final ListCallback<Comments> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.get__comments( (String)that.getId(), filter,  new ListCallback<Comments> (){
                                            

                                            


                                            
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
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.create__comments( (String)that.getId(), data,  new ObjectCallback<Comments> (){
                                            

                                            
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
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.delete__comments( (String)that.getId(),  new VoidCallback (){
                                            
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
                                    public void count__comments( HashMap<String, Object> where,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.count__comments( (String)that.getId(), where,  new Adapter.JsonObjectCallback(){
                                            

                                            
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

                 
                 
             
          
    
        
                
                    //Define belongsTo relation method here..
                    private Wishlist  wishlists ;

                    public Wishlist getWishlists() {
                        return wishlists;
                    }

                    public void setWishlists(Wishlist wishlists) {
                        this.wishlists = wishlists;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setWishlists(HashMap<String, Object> wishlists) {
                        //First create a dummy Repo class object for customer.
                        WishlistRepository wishlistsRepository = new WishlistRepository();
                        Wishlist wishlists1 = wishlistsRepository.createObject(wishlists);
                        setWishlists(wishlists1);
                    }

                    //Adding relation method..
                    public void addRelation(Wishlist wishlists) {
                        that.setWishlists(wishlists);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        

                                    //Write the method here..
                                    public void get__wishlists( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Wishlist> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.get__wishlists( (String)that.getId(), refresh,  new ObjectCallback<Wishlist> (){
                                            

                                            
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
                                    public void create__wishlists( Wishlist data,  RestAdapter restAdapter, final ObjectCallback<Wishlist> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.create__wishlists( (String)that.getId(), data,  new ObjectCallback<Wishlist> (){
                                            

                                            
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
                                    public void update__wishlists( Wishlist data,  RestAdapter restAdapter, final ObjectCallback<Wishlist> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.update__wishlists( (String)that.getId(), data,  new ObjectCallback<Wishlist> (){
                                            

                                            
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
                                    public void destroy__wishlists( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.destroy__wishlists( (String)that.getId(),  new VoidCallback (){
                                            
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
                                 
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                

                 
                 
             
          
    
        
                
                    //Define belongsTo relation method here..
                    private Chef  chefs ;

                    public Chef getChefs() {
                        return chefs;
                    }

                    public void setChefs(Chef chefs) {
                        this.chefs = chefs;
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
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.get__chefs( (String)that.getId(), refresh,  new ObjectCallback<Chef> (){
                                            

                                            
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
                                 
                            
                        

                                    //Write the method here..
                                    public void create__chefs( Chef data,  RestAdapter restAdapter, final ObjectCallback<Chef> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.create__chefs( (String)that.getId(), data,  new ObjectCallback<Chef> (){
                                            

                                            
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
                                 
                            
                        

                                    //Write the method here..
                                    public void update__chefs( Chef data,  RestAdapter restAdapter, final ObjectCallback<Chef> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.update__chefs( (String)that.getId(), data,  new ObjectCallback<Chef> (){
                                            

                                            
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
                                 
                            
                        

                                    //Write the method here..
                                    public void destroy__chefs( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.destroy__chefs( (String)that.getId(),  new VoidCallback (){
                                            
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
                                 
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                

                 
                 
             
          
    
        
                
                
                    
                    //Define hasMany relation method here..
                    private List<ContactChef>  contactChefs ;

                    public List<ContactChef> getContactChefs() {
                        return contactChefs;
                    }

                    public void setContactChefs(List<ContactChef> contactChefs) {
                        this.contactChefs = contactChefs;
                        //Disabling backend compatibility for cyclic error
                        /*
                        //Now add backward compatibility for the relation belongsTo for hasMany..
                        for (ContactChef obj : contactChefs) {
                            obj.addRelation(that);
                        }
                        */
                    }

                    //Adding related model automatically in case of include statement from server.. Adding 1 for removing same name error..
                    public void setContactChefs1(List<HashMap<String, Object>> contactChefs) {
                        //First create a dummy Repo class object for ..
                        ContactChefRepository contactChefsRepository = new ContactChefRepository();
                        List<ContactChef> result = new ArrayList<>();
                        for (HashMap<String, Object> obj : contactChefs) {
                            //Also add relation to child type for two way communication..
                            ContactChef obj1 = contactChefsRepository.createObject(obj);
                            //Disabling backend compatibility for cyclic error
                            /*//Now add backward compatibility for the relation belongsTo for hasMany..
                            obj1.addRelation(that);*/
                            result.add(obj1);
                        }
                        setContactChefs(result);
                    }


                    //Adding relation method..
                    //Add a dummy class Name object to seperate data..
                    public void addRelation(List<ContactChef> contactChefs, ContactChef dummyClassInstance) {
                        that.setContactChefs(contactChefs);

                    }

                    //Adding relation method..
                    //This will add a new data to the list relation object..
                    public void addRelation(ContactChef contactChefs) {
                        try{
                            that.getContactChefs().add(contactChefs);
                        }catch(Exception e){
                            List< ContactChef> contactChefs1 = new ArrayList();
                            //Now add this item to list..
                            contactChefs1.add(contactChefs);
                            //Now set data....
                            that.setContactChefs(contactChefs1);
                        }
                    }

                    


                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        

                                    //Write the method here..
                                    public void findById__contactChefs( String fk,  RestAdapter restAdapter, final ObjectCallback<ContactChef> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.findById__contactChefs( (String)that.getId(), fk,  new ObjectCallback<ContactChef> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(ContactChef object) {
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
                                    public void destroyById__contactChefs( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.destroyById__contactChefs( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                    public void updateById__contactChefs( String fk,  ContactChef data,  RestAdapter restAdapter, final ObjectCallback<ContactChef> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.updateById__contactChefs( (String)that.getId(), fk, data,  new ObjectCallback<ContactChef> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(ContactChef object) {
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
                                    public void get__contactChefs( HashMap<String, Object> filter,  RestAdapter restAdapter, final ListCallback<ContactChef> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.get__contactChefs( (String)that.getId(), filter,  new ListCallback<ContactChef> (){
                                            

                                            


                                            
                                                @Override
                                                
                                                    public void onSuccess(List<ContactChef> object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            ContactChef obj = new ContactChef();
                                                            addRelation(object, obj);
                                                            //Disabling two way communication for cyclic error..
                                                            /*for (ContactChef obj : object) {
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
                                    public void create__contactChefs( ContactChef data,  RestAdapter restAdapter, final ObjectCallback<ContactChef> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.create__contactChefs( (String)that.getId(), data,  new ObjectCallback<ContactChef> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(ContactChef object) {
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
                                    public void delete__contactChefs( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.delete__contactChefs( (String)that.getId(),  new VoidCallback (){
                                            
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
                                    public void count__contactChefs( HashMap<String, Object> where,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.count__contactChefs( (String)that.getId(), where,  new Adapter.JsonObjectCallback(){
                                            

                                            
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

                 
                 
             
          
    
        
                
                
                    
                    //Define hasMany relation method here..
                    private List<Order>  orders ;

                    public List<Order> getOrders() {
                        return orders;
                    }

                    public void setOrders(List<Order> orders) {
                        this.orders = orders;
                        //Disabling backend compatibility for cyclic error
                        /*
                        //Now add backward compatibility for the relation belongsTo for hasMany..
                        for (Order obj : orders) {
                            obj.addRelation(that);
                        }
                        */
                    }

                    //Adding related model automatically in case of include statement from server.. Adding 1 for removing same name error..
                    public void setOrders1(List<HashMap<String, Object>> orders) {
                        //First create a dummy Repo class object for ..
                        OrderRepository ordersRepository = new OrderRepository();
                        List<Order> result = new ArrayList<>();
                        for (HashMap<String, Object> obj : orders) {
                            //Also add relation to child type for two way communication..
                            Order obj1 = ordersRepository.createObject(obj);
                            //Disabling backend compatibility for cyclic error
                            /*//Now add backward compatibility for the relation belongsTo for hasMany..
                            obj1.addRelation(that);*/
                            result.add(obj1);
                        }
                        setOrders(result);
                    }


                    //Adding relation method..
                    //Add a dummy class Name object to seperate data..
                    public void addRelation(List<Order> orders, Order dummyClassInstance) {
                        that.setOrders(orders);

                    }

                    //Adding relation method..
                    //This will add a new data to the list relation object..
                    public void addRelation(Order orders) {
                        try{
                            that.getOrders().add(orders);
                        }catch(Exception e){
                            List< Order> orders1 = new ArrayList();
                            //Now add this item to list..
                            orders1.add(orders);
                            //Now set data....
                            that.setOrders(orders1);
                        }
                    }

                    


                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        

                                    //Write the method here..
                                    public void findById__orders( String fk,  RestAdapter restAdapter, final ObjectCallback<Order> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.findById__orders( (String)that.getId(), fk,  new ObjectCallback<Order> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Order object) {
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
                                    public void destroyById__orders( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.destroyById__orders( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                    public void updateById__orders( String fk,  Order data,  RestAdapter restAdapter, final ObjectCallback<Order> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.updateById__orders( (String)that.getId(), fk, data,  new ObjectCallback<Order> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Order object) {
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
                                    public void get__orders( HashMap<String, Object> filter,  RestAdapter restAdapter, final ListCallback<Order> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.get__orders( (String)that.getId(), filter,  new ListCallback<Order> (){
                                            

                                            


                                            
                                                @Override
                                                
                                                    public void onSuccess(List<Order> object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            Order obj = new Order();
                                                            addRelation(object, obj);
                                                            //Disabling two way communication for cyclic error..
                                                            /*for (Order obj : object) {
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
                                    public void create__orders( Order data,  RestAdapter restAdapter, final ObjectCallback<Order> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.create__orders( (String)that.getId(), data,  new ObjectCallback<Order> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Order object) {
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
                                    public void delete__orders( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.delete__orders( (String)that.getId(),  new VoidCallback (){
                                            
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
                                    public void count__orders( HashMap<String, Object> where,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.count__orders( (String)that.getId(), where,  new Adapter.JsonObjectCallback(){
                                            

                                            
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

                 
                 
             
          
    
        
                
                
                    
                    //Define hasMany relation method here..
                    private List<RecipeAnalytic>  recipeAnalytics ;

                    public List<RecipeAnalytic> getRecipeAnalytics() {
                        return recipeAnalytics;
                    }

                    public void setRecipeAnalytics(List<RecipeAnalytic> recipeAnalytics) {
                        this.recipeAnalytics = recipeAnalytics;
                        //Disabling backend compatibility for cyclic error
                        /*
                        //Now add backward compatibility for the relation belongsTo for hasMany..
                        for (RecipeAnalytic obj : recipeAnalytics) {
                            obj.addRelation(that);
                        }
                        */
                    }

                    //Adding related model automatically in case of include statement from server.. Adding 1 for removing same name error..
                    public void setRecipeAnalytics1(List<HashMap<String, Object>> recipeAnalytics) {
                        //First create a dummy Repo class object for ..
                        RecipeAnalyticRepository recipeAnalyticsRepository = new RecipeAnalyticRepository();
                        List<RecipeAnalytic> result = new ArrayList<>();
                        for (HashMap<String, Object> obj : recipeAnalytics) {
                            //Also add relation to child type for two way communication..
                            RecipeAnalytic obj1 = recipeAnalyticsRepository.createObject(obj);
                            //Disabling backend compatibility for cyclic error
                            /*//Now add backward compatibility for the relation belongsTo for hasMany..
                            obj1.addRelation(that);*/
                            result.add(obj1);
                        }
                        setRecipeAnalytics(result);
                    }


                    //Adding relation method..
                    //Add a dummy class Name object to seperate data..
                    public void addRelation(List<RecipeAnalytic> recipeAnalytics, RecipeAnalytic dummyClassInstance) {
                        that.setRecipeAnalytics(recipeAnalytics);

                    }

                    //Adding relation method..
                    //This will add a new data to the list relation object..
                    public void addRelation(RecipeAnalytic recipeAnalytics) {
                        try{
                            that.getRecipeAnalytics().add(recipeAnalytics);
                        }catch(Exception e){
                            List< RecipeAnalytic> recipeAnalytics1 = new ArrayList();
                            //Now add this item to list..
                            recipeAnalytics1.add(recipeAnalytics);
                            //Now set data....
                            that.setRecipeAnalytics(recipeAnalytics1);
                        }
                    }

                    


                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        

                                    //Write the method here..
                                    public void findById__recipeAnalytics( String fk,  RestAdapter restAdapter, final ObjectCallback<RecipeAnalytic> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.findById__recipeAnalytics( (String)that.getId(), fk,  new ObjectCallback<RecipeAnalytic> (){
                                            

                                            
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
                                    public void destroyById__recipeAnalytics( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.destroyById__recipeAnalytics( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                    public void updateById__recipeAnalytics( String fk,  RecipeAnalytic data,  RestAdapter restAdapter, final ObjectCallback<RecipeAnalytic> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.updateById__recipeAnalytics( (String)that.getId(), fk, data,  new ObjectCallback<RecipeAnalytic> (){
                                            

                                            
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
                                    public void get__recipeAnalytics( HashMap<String, Object> filter,  RestAdapter restAdapter, final ListCallback<RecipeAnalytic> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.get__recipeAnalytics( (String)that.getId(), filter,  new ListCallback<RecipeAnalytic> (){
                                            

                                            


                                            
                                                @Override
                                                
                                                    public void onSuccess(List<RecipeAnalytic> object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            RecipeAnalytic obj = new RecipeAnalytic();
                                                            addRelation(object, obj);
                                                            //Disabling two way communication for cyclic error..
                                                            /*for (RecipeAnalytic obj : object) {
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
                                    public void create__recipeAnalytics( RecipeAnalytic data,  RestAdapter restAdapter, final ObjectCallback<RecipeAnalytic> callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.create__recipeAnalytics( (String)that.getId(), data,  new ObjectCallback<RecipeAnalytic> (){
                                            

                                            
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
                                    public void delete__recipeAnalytics( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.delete__recipeAnalytics( (String)that.getId(),  new VoidCallback (){
                                            
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
                                    public void count__recipeAnalytics( HashMap<String, Object> where,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                                        


                                        

                                        

                                        customerRepo.count__recipeAnalytics( (String)that.getId(), where,  new Adapter.JsonObjectCallback(){
                                            

                                            
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

                 
                 
             
          
      

}
