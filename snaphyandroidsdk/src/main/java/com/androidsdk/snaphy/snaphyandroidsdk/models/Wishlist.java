package com.androidsdk.snaphy.snaphyandroidsdk.models;




import com.strongloop.android.loopback.Model;


import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

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
                    private Customer  customer ;

                    public Customer getCustomer() {
                        return customer;
                    }

                    public void setCustomer(Customer customer) {
                        this.customer = customer;
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
                    public void get__customers( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Customer> callback) {
                        //Define methods here..
                        final WishlistRepository  wishlistRepo = restAdapter.createRepository(WishlistRepository.class);
                        


                        

                        

                        wishlistRepo.get__customers( (String)that.getId(), refresh,  new ObjectCallback<Customer> (){
                            

                            
                                @Override
                                public void onSuccess(Customer object) {
                                    //now add relation to this recipe.
                                    addRelation(object);
                                    //Also add relation to child type for two way communication..
                                    object.addRelation(that);
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
                    public void create__customers( Customer data,  RestAdapter restAdapter, final ObjectCallback<Customer> callback) {
                        //Define methods here..
                        final WishlistRepository  wishlistRepo = restAdapter.createRepository(WishlistRepository.class);
                        


                        

                        

                        wishlistRepo.create__customers( (String)that.getId(), data,  new ObjectCallback<Customer> (){
                            

                            
                                @Override
                                public void onSuccess(Customer object) {
                                    //now add relation to this recipe.
                                    addRelation(object);
                                    //Also add relation to child type for two way communication..
                                    object.addRelation(that);
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
                    public void update__customers( Customer data,  RestAdapter restAdapter, final ObjectCallback<Customer> callback) {
                        //Define methods here..
                        final WishlistRepository  wishlistRepo = restAdapter.createRepository(WishlistRepository.class);
                        


                        

                        

                        wishlistRepo.update__customers( (String)that.getId(), data,  new ObjectCallback<Customer> (){
                            

                            
                                @Override
                                public void onSuccess(Customer object) {
                                    //now add relation to this recipe.
                                    addRelation(object);
                                    //Also add relation to child type for two way communication..
                                    object.addRelation(that);
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


                                
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                
                
                
            
        
    
        
                
                
                
                    //Define hasAndBelongsToMany..

                
            
        
    

}
