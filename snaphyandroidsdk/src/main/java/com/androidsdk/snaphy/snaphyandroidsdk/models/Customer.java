package com.androidsdk.snaphy.snaphyandroidsdk.models;




import com.strongloop.android.loopback.Model;


import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

//Import self repository..
import com.androidsdk.snaphy.snaphyandroidsdk.repository.CustomerRepository;

//Now import repository of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CommentsRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.WishlistRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;



public class Customer extends Model {


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
    
        
                
                
                    //Define hasMany, hasManyThrough method here..

                
                
            
        
    
        
                
                
                    //Define hasMany, hasManyThrough method here..

                
                
            
        
    
        
                
                    //Define belongsTo relation method here..
                    private Wishlist  wishlist ;

                    public Wishlist getWishlist() {
                        return wishlist;
                    }

                    public void setWishlist(Wishlist wishlist) {
                        this.wishlist = wishlist;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setWishlist(HashMap<String, Object> wishlist) {
                        //First create a dummy Repo class object for customer.
                        WishlistRepository wishlistRepository = new WishlistRepository();
                        Wishlist wishlist1 = wishlistRepository.createObject(wishlist);
                        setWishlist(wishlist1);
                    }

                    //Adding relation method..
                    public void addRelation(Wishlist wishlist) {
                        that.setWishlist(wishlist);
                    }


                    //Now add instance methods to fetch the related belongsTo Model..
                    

                    
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        

                    //Write the method here..
                    public void get__wishlists( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Wishlist> callback) {
                        //Define methods here..
                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                        


                        

                        

                        customerRepo.get__wishlists( (String)that.getId(), refresh,  new ObjectCallback<Wishlist> (){
                            

                            
                                @Override
                                public void onSuccess(Wishlist object) {
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
                    public void create__wishlists( Wishlist data,  RestAdapter restAdapter, final ObjectCallback<Wishlist> callback) {
                        //Define methods here..
                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                        


                        

                        

                        customerRepo.create__wishlists( (String)that.getId(), data,  new ObjectCallback<Wishlist> (){
                            

                            
                                @Override
                                public void onSuccess(Wishlist object) {
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
                    public void update__wishlists( Wishlist data,  RestAdapter restAdapter, final ObjectCallback<Wishlist> callback) {
                        //Define methods here..
                        final CustomerRepository  customerRepo = restAdapter.createRepository(CustomerRepository.class);
                        


                        

                        

                        customerRepo.update__wishlists( (String)that.getId(), data,  new ObjectCallback<Wishlist> (){
                            

                            
                                @Override
                                public void onSuccess(Wishlist object) {
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


                                
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                
                
                
            
        
    

}
