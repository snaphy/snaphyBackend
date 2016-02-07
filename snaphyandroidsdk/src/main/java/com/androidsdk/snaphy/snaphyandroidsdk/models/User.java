package com.androidsdk.snaphy.snaphyandroidsdk.models;




import com.strongloop.android.loopback.Model;


import com.strongloop.android.loopback.Model;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

//Now import repository of related models..

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.AccessTokenRepository;

    


import java.util.ArrayList;
import java.util.HashMap;



public class User extends Model {


    private User that ;

    public User (){
        that = this;
    }

    
        
            
            
                private String realm;
                /* Adding Getter and Setter methods */
                public String getRealm(){
                    return realm;
                }

                /* Adding Getter and Setter methods */
                public void setRealm(String realm){
                    this.realm = realm;
                }

            
            
            

        
    
        
            
            
                private String username;
                /* Adding Getter and Setter methods */
                public String getUsername(){
                    return username;
                }

                /* Adding Getter and Setter methods */
                public void setUsername(String username){
                    this.username = username;
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

            
            
            

        
    
        
            
            
            
            
                private HashMap<String, Object> credentials;
                /* Adding Getter and Setter methods */
                public HashMap<String, Object> getCredentials(){
                    return credentials;
                }

                /* Adding Getter and Setter methods */
                public void setCredentials(HashMap<String, Object> credentials){
                    this.credentials = credentials;
                }

            

        
    
        
            
            
            
            
                private HashMap<String, Object> challenges;
                /* Adding Getter and Setter methods */
                public HashMap<String, Object> getChallenges(){
                    return challenges;
                }

                /* Adding Getter and Setter methods */
                public void setChallenges(HashMap<String, Object> challenges){
                    this.challenges = challenges;
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

            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
            
            
                //Define hasMany, hasManyThrough method here..

            
            
        
    

}
