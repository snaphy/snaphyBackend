package com.androidsdk.snaphy.snaphyandroidsdk.models;




import com.strongloop.android.loopback.Model;


import com.strongloop.android.loopback.Model;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

//Now import repository of related models..

    
        import com.androidsdk.snaphy.snaphyandroidsdk.repository.RoleRepository;

    


import java.util.ArrayList;
import java.util.HashMap;



public class RoleMapping extends Model {


    private RoleMapping that ;

    public RoleMapping (){
        that = this;
    }

    
        
            
            
            
            

        
    
        
            
            
                private String principalType;
                /* Adding Getter and Setter methods */
                public String getPrincipalType(){
                    return principalType;
                }

                /* Adding Getter and Setter methods */
                public void setPrincipalType(String principalType){
                    this.principalType = principalType;
                }

            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
            
                //Define belongsTo relation method here..
                private Role  role ;

                public Role getRole() {
                    return role;
                }

                public void setRole(Role role) {
                    this.role = role;
                }

                //Adding related model automatically in case of include statement from server..
                public void setRole(HashMap<String, Object> role) {
                    //First create a dummy Repo class object for customer.
                    RoleRepository roleRepository = new RoleRepository();
                    Role role1 = roleRepository.createObject(role);
                    setRole(role1);
                }

                //Adding relation method..
                public void addRelation(Role role) {
                    this.setCustomer(role);
                }


                //Now add instance methods to fetch the related belongsTo Model..
                

                

            
            
            
        
    

}
