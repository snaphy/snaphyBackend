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
import com.androidsdk.snaphy.snaphyandroidsdk.repository.WishlistRepository;

//Now import repository of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CustomerRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;



public class Wishlist extends Model {


    private Wishlist that ;

    public Wishlist (){
        that = this;
    }

    
        
            
            
            
            

        
    
        
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
                
                    //Define belongsTo relation method here..
                    private Customer  customers ;

                    public Customer getCustomers() {
                        return customers;
                    }

                    public void setCustomers(Customer customers) {
                        this.customers = customers;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setCustomers(HashMap<String, Object> customers) {
                        //First create a dummy Repo class object for customer.
                        CustomerRepository customersRepository = new CustomerRepository();
                        Customer customers1 = customersRepository.createObject(customers);
                        setCustomers(customers1);
                    }

                    //Adding relation method..
                    public void addRelation(Customer customers) {
                        that.setCustomers(customers);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                    

                                    //Write the method here..
                                    public void get__customers( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Customer> callback) {
                                        //Define methods here..
                                        final WishlistRepository  wishlistRepo = restAdapter.createRepository(WishlistRepository.class);
                                        


                                        

                                        

                                        wishlistRepo.get__customers( (String)that.getId(), refresh,  new ObjectCallback<Customer> (){
                                            

                                            
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
                                 
                            
                        

                                    //Write the method here..
                                    public void create__customers( Customer data,  RestAdapter restAdapter, final ObjectCallback<Customer> callback) {
                                        //Define methods here..
                                        final WishlistRepository  wishlistRepo = restAdapter.createRepository(WishlistRepository.class);
                                        


                                        

                                        

                                        wishlistRepo.create__customers( (String)that.getId(), data,  new ObjectCallback<Customer> (){
                                            

                                            
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
                                 
                            
                        

                                    //Write the method here..
                                    public void update__customers( Customer data,  RestAdapter restAdapter, final ObjectCallback<Customer> callback) {
                                        //Define methods here..
                                        final WishlistRepository  wishlistRepo = restAdapter.createRepository(WishlistRepository.class);
                                        


                                        

                                        

                                        wishlistRepo.update__customers( (String)that.getId(), data,  new ObjectCallback<Customer> (){
                                            

                                            
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
                                 
                            
                        

                                    //Write the method here..
                                    public void destroy__customers( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final WishlistRepository  wishlistRepo = restAdapter.createRepository(WishlistRepository.class);
                                        


                                        

                                        

                                        wishlistRepo.destroy__customers( (String)that.getId(),  new VoidCallback (){
                                            
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
                                 
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                

                 
                 
             
          
    
        
                
                
                
                    //TODO ADD BACKWARD COMPATIBILITY FOR hasManyThrough relationship..warning backward compatibility may leads to cyclic error..
                    //Define belongsTo relation method here..
                    private List<Recipe>  recipes ;

                    public List<Recipe> getRecipes() {
                        return recipes;
                    }

                    public void setRecipes(List<Recipe> recipes) {
                        this.recipes = recipes;
                    }

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
                                        final WishlistRepository  wishlistRepo = restAdapter.createRepository(WishlistRepository.class);
                                        


                                        

                                        

                                        wishlistRepo.findById__recipes( (String)that.getId(), fk,  new ObjectCallback<Recipe> (){
                                            

                                            
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
                                        final WishlistRepository  wishlistRepo = restAdapter.createRepository(WishlistRepository.class);
                                        


                                        

                                        

                                        wishlistRepo.destroyById__recipes( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                        final WishlistRepository  wishlistRepo = restAdapter.createRepository(WishlistRepository.class);
                                        


                                        

                                        

                                        wishlistRepo.updateById__recipes( (String)that.getId(), fk, data,  new ObjectCallback<Recipe> (){
                                            

                                            
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
                                    public void link__recipes( String fk,  Recipe data,  RestAdapter restAdapter, final ObjectCallback<Recipe> callback) {
                                        //Define methods here..
                                        final WishlistRepository  wishlistRepo = restAdapter.createRepository(WishlistRepository.class);
                                        


                                        

                                        

                                        wishlistRepo.link__recipes( (String)that.getId(), fk, data,  new ObjectCallback<Recipe> (){
                                            

                                            
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
                                        final WishlistRepository  wishlistRepo = restAdapter.createRepository(WishlistRepository.class);
                                        


                                        

                                        

                                        wishlistRepo.unlink__recipes( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                        final WishlistRepository  wishlistRepo = restAdapter.createRepository(WishlistRepository.class);
                                        


                                        

                                        

                                        wishlistRepo.exists__recipes( (String)that.getId(), fk,  new Adapter.JsonObjectCallback(){
                                            

                                            
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
                                    public void get__recipes( HashMap<String, Object> filter,  RestAdapter restAdapter, final ListCallback<Recipe> callback) {
                                        //Define methods here..
                                        final WishlistRepository  wishlistRepo = restAdapter.createRepository(WishlistRepository.class);
                                        


                                        

                                        

                                        wishlistRepo.get__recipes( (String)that.getId(), filter,  new ListCallback<Recipe> (){
                                            

                                            


                                            
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
                                        final WishlistRepository  wishlistRepo = restAdapter.createRepository(WishlistRepository.class);
                                        


                                        

                                        

                                        wishlistRepo.create__recipes( (String)that.getId(), data,  new ObjectCallback<Recipe> (){
                                            

                                            
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
                                        final WishlistRepository  wishlistRepo = restAdapter.createRepository(WishlistRepository.class);
                                        


                                        

                                        

                                        wishlistRepo.delete__recipes( (String)that.getId(),  new VoidCallback (){
                                            
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
                                        final WishlistRepository  wishlistRepo = restAdapter.createRepository(WishlistRepository.class);
                                        


                                        

                                        

                                        wishlistRepo.count__recipes( (String)that.getId(), where,  new Adapter.JsonObjectCallback(){
                                            

                                            
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
