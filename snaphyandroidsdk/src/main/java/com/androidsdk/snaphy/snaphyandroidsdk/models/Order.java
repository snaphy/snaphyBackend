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
import com.androidsdk.snaphy.snaphyandroidsdk.repository.OrderRepository;

//Now import repository of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CustomerRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.OrderDetailRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Order extends Model {


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

    private Order that ;

    public Order (){
        that = this;
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

            
            
            
            

        
    
        
            
            
                private String customerAddress;
                /* Adding Getter and Setter methods */
                public String getCustomerAddress(){
                    return customerAddress;
                }

                /* Adding Getter and Setter methods */
                public void setCustomerAddress(String customerAddress){
                    this.customerAddress = customerAddress;
                    //Update hashMap value..
                    hashMap.put("customerAddress", customerAddress);
                }

            
            
            
            

        
    
        
            
            
            
                private double customerPincode;
                /* Adding Getter and Setter methods */
                public double getCustomerPincode(){
                    return customerPincode;
                }

                /* Adding Getter and Setter methods */
                public void setCustomerPincode(double customerPincode){
                    this.customerPincode = customerPincode;
                    //Update hashMap value..
                    hashMap.put("customerPincode", customerPincode);
                }

            
            
            

        
    
        
            
            
            
                private double phoneNumber;
                /* Adding Getter and Setter methods */
                public double getPhoneNumber(){
                    return phoneNumber;
                }

                /* Adding Getter and Setter methods */
                public void setPhoneNumber(double phoneNumber){
                    this.phoneNumber = phoneNumber;
                    //Update hashMap value..
                    hashMap.put("phoneNumber", phoneNumber);
                }

            
            
            

        
    
        
            

                private List<Map<String, Object>> staticIngredients;
                /* Adding Getter and Setter methods */
                public List<Map<String, Object>> getStaticIngredients(){
                    return staticIngredients;
                }

                /* Adding Getter and Setter methods */
                public void setStaticIngredients(List<Map<String, Object>> staticIngredients){
                    this.staticIngredients = staticIngredients;

                    //TODO change this to custom array with double quotes escaped if error occured when sending to server..
                    hashMap.put("staticIngredients", staticIngredients);
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
                                        final OrderRepository  orderRepo = restAdapter.createRepository(OrderRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        orderRepo.get__customer( (String)that.getId(), refresh,  new ObjectCallback<Customer> (){
                                            

                                            
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
                                 
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                         
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                

                 
                 
             
          
    
        
                
                
                    
                    //Define hasMany relation method here..
                    private List<OrderDetail>  orderDetails ;

                    public List<OrderDetail> getOrderDetails() {
                        return orderDetails;
                    }

                    public void setOrderDetails(List<OrderDetail> orderDetails) {
                        boolean hashType = false;
                        List<HashMap<String, Object>> hashMaps = new ArrayList<>();
                        for(Object o: orderDetails){
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
                            setOrderDetails1(hashMaps);
                        }else{
                            this.orderDetails = orderDetails;
                        }
                    }

                /*    //Adding related model automatically in case of include statement from server.. Adding 1 for removing same name error..
                    public void setOrderDetails1(List<Map<String, Object>> orderDetails) {
                        //First create a dummy Repo class object for ..
                        OrderDetailRepository orderDetailsRepository = new OrderDetailRepository();
                        List<OrderDetail> result = new ArrayList<>();
                        for (Map<String, Object> obj : orderDetails) {
                            //Also add relation to child type for two way communication..
                            OrderDetail obj1 = orderDetailsRepository.createObject(obj);
                            result.add(obj1);

                        }
                        setOrderDetails(result);

                    }

                */

                    //Adding related model automatically in case of include statement from server.. Adding 1 for removing same name error..
                    public void setOrderDetails1(List<HashMap<String, Object>> orderDetails) {
                        //First create a dummy Repo class object for ..
                        OrderDetailRepository orderDetailsRepository = new OrderDetailRepository();
                        List<OrderDetail> result = new ArrayList<>();
                        for (HashMap<String, Object> obj : orderDetails) {
                            //Also add relation to child type for two way communication..
                            OrderDetail obj1 = orderDetailsRepository.createObject(obj);
                            result.add(obj1);

                        }
                        setOrderDetails(result);

                    }


                    //Adding relation method..
                    //Add a dummy class Name object to seperate data..
                    public void addRelation(List<OrderDetail> orderDetails, OrderDetail dummyClassInstance) {
                        that.setOrderDetails(orderDetails);

                    }

                    //Adding relation method..
                    //This will add a new data to the list relation object..
                    public void addRelation(OrderDetail orderDetails) {
                        try{
                            that.getOrderDetails().add(orderDetails);
                        }catch(Exception e){
                            List< OrderDetail> orderDetails1 = new ArrayList();
                            //Now add this item to list..
                            orderDetails1.add(orderDetails);
                            //Now set data....
                            that.setOrderDetails(orderDetails1);
                        }
                    }

                    


                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                     
                            
                        

                                    //Write the method here..
                                    public void findById__orderDetails( String fk,  RestAdapter restAdapter, final ObjectCallback<OrderDetail> callback) {
                                        //Define methods here..
                                        final OrderRepository  orderRepo = restAdapter.createRepository(OrderRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        orderRepo.findById__orderDetails( (String)that.getId(), fk,  new ObjectCallback<OrderDetail> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(OrderDetail object) {
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
                                    public void destroyById__orderDetails( String fk,  RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final OrderRepository  orderRepo = restAdapter.createRepository(OrderRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        orderRepo.destroyById__orderDetails( (String)that.getId(), fk,  new VoidCallback (){
                                            
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
                                    public void updateById__orderDetails( String fk,  OrderDetail data,  RestAdapter restAdapter, final ObjectCallback<OrderDetail> callback) {
                                        //Define methods here..
                                        final OrderRepository  orderRepo = restAdapter.createRepository(OrderRepository.class);
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        



                                        orderRepo.updateById__orderDetails( (String)that.getId(), fk, data.convertMap(),  new ObjectCallback<OrderDetail> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(OrderDetail object) {
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
                                    public void get__orderDetails( Map<String,  ? extends Object> filter,  RestAdapter restAdapter, final ListCallback<OrderDetail> callback) {
                                        //Define methods here..
                                        final OrderRepository  orderRepo = restAdapter.createRepository(OrderRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        orderRepo.get__orderDetails( (String)that.getId(), filter,  new ListCallback<OrderDetail> (){
                                            

                                            


                                            
                                                @Override
                                                
                                                    public void onSuccess(List<OrderDetail> object) {
                                                        if(object != null){
                                                            //now add relation to this recipe.
                                                            OrderDetail obj = new OrderDetail();
                                                            addRelation(object, obj);
                                                            //Disabling two way communication for cyclic error..
                                                            /*for (OrderDetail obj : object) {
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
                                    public void create__orderDetails( OrderDetail data,  RestAdapter restAdapter, final ObjectCallback<OrderDetail> callback) {
                                        //Define methods here..
                                        final OrderRepository  orderRepo = restAdapter.createRepository(OrderRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        orderRepo.create__orderDetails( (String)that.getId(), data.convertMap(),  new ObjectCallback<OrderDetail> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(OrderDetail object) {
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
                                    public void delete__orderDetails( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Define methods here..
                                        final OrderRepository  orderRepo = restAdapter.createRepository(OrderRepository.class);
                                        
                                        



                                        orderRepo.delete__orderDetails( (String)that.getId(),  new VoidCallback (){
                                            
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
                                    public void count__orderDetails( Map<String,  ? extends Object> where,  RestAdapter restAdapter, final Adapter.JsonObjectCallback  callback ) {
                                        //Define methods here..
                                        final OrderRepository  orderRepo = restAdapter.createRepository(OrderRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        orderRepo.count__orderDetails( (String)that.getId(), where,  new Adapter.JsonObjectCallback(){
                                            

                                            
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
