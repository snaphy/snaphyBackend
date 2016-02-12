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
import com.androidsdk.snaphy.snaphyandroidsdk.repository.CourseRepository;

//Now import repository of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.ChefRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.ContactChefRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;



public class Course extends Model {


    //For converting all model values to hashMap
    private HashMap<String, Object> hashMap = new HashMap<>();

    public HashMap<String, Object> convertHashMap(){
        if(that.getId() != null){
            return hashMap;
        }else{
            hashMap.put("id", that.getId());
            return hashMap;
        }
    }

    private Course that ;

    public Course (){
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

            
            
            

        
    
        
            
            
                private String courseDuration;
                /* Adding Getter and Setter methods */
                public String getCourseDuration(){
                    return courseDuration;
                }

                /* Adding Getter and Setter methods */
                public void setCourseDuration(String courseDuration){
                    this.courseDuration = courseDuration;
                    //Update hashMap value..
                    hashMap.put("courseDuration", courseDuration);
                }

            
            
            

        
    
        
            
            
                private String courseFees;
                /* Adding Getter and Setter methods */
                public String getCourseFees(){
                    return courseFees;
                }

                /* Adding Getter and Setter methods */
                public void setCourseFees(String courseFees){
                    this.courseFees = courseFees;
                    //Update hashMap value..
                    hashMap.put("courseFees", courseFees);
                }

            
            
            

        
    
        
            

                private List<String> courseRecipes;
                /* Adding Getter and Setter methods */
                public List<String> getCourseRecipes(){
                    return courseRecipes;
                }

                /* Adding Getter and Setter methods */
                public void setCourseRecipes(List<String> courseRecipes){
                    this.courseRecipes = courseRecipes;

                    //TODO change this to custom array with double quotes escaped if error occured when sending to server..
                    hashMap.put("courseRecipes", courseRecipes);
                }

            
            
            
            

        
    
        
            
            
            
            

        
    
        
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
                
                    //Define belongsTo relation method here..
                    private Chef  chef ;

                    public Chef getChef() {
                        return chef;
                    }

                    public void setChef(Chef chef) {
                        this.chef = chef;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setChef(HashMap<String, Object> chef) {
                        //First create a dummy Repo class object for customer.
                        ChefRepository chefRepository = new ChefRepository();
                        Chef chef1 = chefRepository.createObject(chef);
                        setChef(chef1);
                    }

                    //Adding relation method..
                    public void addRelation(Chef chef) {
                        that.setChef(chef);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                    

                                    //Write the method here..
                                    public void get__chef( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Chef> callback) {
                                        //Define methods here..
                                        final CourseRepository  courseRepo = restAdapter.createRepository(CourseRepository.class);
                                        


                                        

                                        

                                        courseRepo.get__chef( (String)that.getId(), refresh,  new ObjectCallback<Chef> (){
                                            

                                            
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
                                        final CourseRepository  courseRepo = restAdapter.createRepository(CourseRepository.class);
                                        


                                        

                                        

                                        courseRepo.findById__contactChefs( (String)that.getId(), fk,  new ObjectCallback<ContactChef> (){
                                            

                                            
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
                                        final CourseRepository  courseRepo = restAdapter.createRepository(CourseRepository.class);
                                        


                                        

                                        

                                        courseRepo.destroyById__contactChefs( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                        final CourseRepository  courseRepo = restAdapter.createRepository(CourseRepository.class);
                                        


                                        

                                        

                                        courseRepo.updateById__contactChefs( (String)that.getId(), fk, data,  new ObjectCallback<ContactChef> (){
                                            

                                            
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
                                        final CourseRepository  courseRepo = restAdapter.createRepository(CourseRepository.class);
                                        


                                        

                                        

                                        courseRepo.get__contactChefs( (String)that.getId(), filter,  new ListCallback<ContactChef> (){
                                            

                                            


                                            
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
                                        final CourseRepository  courseRepo = restAdapter.createRepository(CourseRepository.class);
                                        


                                        

                                        

                                        courseRepo.create__contactChefs( (String)that.getId(), data,  new ObjectCallback<ContactChef> (){
                                            

                                            
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
                                        final CourseRepository  courseRepo = restAdapter.createRepository(CourseRepository.class);
                                        


                                        

                                        

                                        courseRepo.delete__contactChefs( (String)that.getId(),  new VoidCallback (){
                                            
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
                                        final CourseRepository  courseRepo = restAdapter.createRepository(CourseRepository.class);
                                        


                                        

                                        

                                        courseRepo.count__contactChefs( (String)that.getId(), where,  new Adapter.JsonObjectCallback(){
                                            

                                            
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
