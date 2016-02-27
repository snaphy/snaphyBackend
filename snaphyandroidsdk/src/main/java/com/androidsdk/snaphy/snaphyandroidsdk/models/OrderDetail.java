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
import com.androidsdk.snaphy.snaphyandroidsdk.repository.OrderDetailRepository;

//Now import repository of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.OrderRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeIngredientsRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class OrderDetail extends Model {


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

    private OrderDetail that ;

    public OrderDetail (){
        that = this;
    }

    
        
            
            
            
                private double requiredQuantity;
                /* Adding Getter and Setter methods */
                public double getRequiredQuantity(){
                    return requiredQuantity;
                }

                /* Adding Getter and Setter methods */
                public void setRequiredQuantity(double requiredQuantity){
                    this.requiredQuantity = requiredQuantity;
                    //Update hashMap value..
                    hashMap.put("requiredQuantity", requiredQuantity);
                }

            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
                
                    //Define belongsTo relation method here..
                    private Order  order ;

                    public Order getOrder() {
                        return order;
                    }

                    public void setOrder(Order order) {
                        this.order = order;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setOrder(Map<String, Object> order) {
                        //First create a dummy Repo class object for customer.
                        OrderRepository orderRepository = new OrderRepository();
                        Order order1 = orderRepository.createObject(order);
                        setOrder(order1);
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setOrder(HashMap<String, Object> order) {
                        //First create a dummy Repo class object for customer.
                        OrderRepository orderRepository = new OrderRepository();
                        Order order1 = orderRepository.createObject(order);
                        setOrder(order1);
                    }

                    //Adding relation method..
                    public void addRelation(Order order) {
                        that.setOrder(order);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                    

                                    //Write the method here..
                                    public void get__order( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Order> callback) {
                                        //Define methods here..
                                        final OrderDetailRepository  orderDetailRepo = restAdapter.createRepository(OrderDetailRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        orderDetailRepo.get__order( (String)that.getId(), refresh,  new ObjectCallback<Order> (){
                                            

                                            
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
                                 
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                

                 
                 
             
          
    
        
                
                    //Define belongsTo relation method here..
                    private RecipeIngredients  recipeIngredients ;

                    public RecipeIngredients getRecipeIngredients() {
                        return recipeIngredients;
                    }

                    public void setRecipeIngredients(RecipeIngredients recipeIngredients) {
                        this.recipeIngredients = recipeIngredients;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setRecipeIngredients(Map<String, Object> recipeIngredients) {
                        //First create a dummy Repo class object for customer.
                        RecipeIngredientsRepository recipeIngredientsRepository = new RecipeIngredientsRepository();
                        RecipeIngredients recipeIngredients1 = recipeIngredientsRepository.createObject(recipeIngredients);
                        setRecipeIngredients(recipeIngredients1);
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setRecipeIngredients(HashMap<String, Object> recipeIngredients) {
                        //First create a dummy Repo class object for customer.
                        RecipeIngredientsRepository recipeIngredientsRepository = new RecipeIngredientsRepository();
                        RecipeIngredients recipeIngredients1 = recipeIngredientsRepository.createObject(recipeIngredients);
                        setRecipeIngredients(recipeIngredients1);
                    }

                    //Adding relation method..
                    public void addRelation(RecipeIngredients recipeIngredients) {
                        that.setRecipeIngredients(recipeIngredients);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                        

                                    //Write the method here..
                                    public void get__recipeIngredients( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<RecipeIngredients> callback) {
                                        //Define methods here..
                                        final OrderDetailRepository  orderDetailRepo = restAdapter.createRepository(OrderDetailRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        orderDetailRepo.get__recipeIngredients( (String)that.getId(), refresh,  new ObjectCallback<RecipeIngredients> (){
                                            

                                            
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
                                    public void create__recipeIngredients( RecipeIngredients data,  RestAdapter restAdapter, final ObjectCallback<RecipeIngredients> callback) {
                                        //Define methods here..
                                        final OrderDetailRepository  orderDetailRepo = restAdapter.createRepository(OrderDetailRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        orderDetailRepo.create__recipeIngredients( (String)that.getId(), data.convertMap(),  new ObjectCallback<RecipeIngredients> (){
                                            

                                            
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
                                    public void update__recipeIngredients( RecipeIngredients data,  RestAdapter restAdapter, final ObjectCallback<RecipeIngredients> callback) {
                                        //Define methods here..
                                        final OrderDetailRepository  orderDetailRepo = restAdapter.createRepository(OrderDetailRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        orderDetailRepo.update__recipeIngredients( (String)that.getId(), data.convertMap(),  new ObjectCallback<RecipeIngredients> (){
                                            

                                            
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
                                    public void destroy__recipeIngredients( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final OrderDetailRepository  orderDetailRepo = restAdapter.createRepository(OrderDetailRepository.class);
                                        
                                        



                                        orderDetailRepo.destroy__recipeIngredients( (String)that.getId(),  new VoidCallback (){
                                            
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
