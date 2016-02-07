package com.androidsdk.snaphy.snaphyandroidsdk.models;




import com.strongloop.android.loopback.Model;


import com.strongloop.android.loopback.Model;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

//Now import repository of related models..

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.UserRepository;

    


import java.util.ArrayList;
import java.util.HashMap;



public class AccessToken extends Model {


    private AccessToken that ;

    public AccessToken (){
        that = this;
    }

    
        
            
            
            
            

        
    
        
            
            
            
                private Double ttl;
                /* Adding Getter and Setter methods */
                public Double getTtl(){
                    return ttl;
                }

                /* Adding Getter and Setter methods */
                public void setTtl(Double ttl){
                    this.ttl = ttl;
                }

            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
            
                //Define belongsTo relation method here..
                private User  user ;

                public User getUser() {
                    return user;
                }

                public void setUser(User user) {
                    this.user = user;
                }

                //Adding related model automatically in case of include statement from server..
                public void setUser(HashMap<String, Object> user) {
                    //First create a dummy Repo class object for customer.
                    UserRepository userRepository = new UserRepository();
                    User user1 = userRepository.createObject(user);
                    setUser(user1);
                }

                //Adding relation method..
                public void addRelation(User user) {
                    this.setCustomer(user);
                }


                //Now add instance methods to fetch the related belongsTo Model..
                

                

            
            
            
        
    

}
