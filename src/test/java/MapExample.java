//package javacollections;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

	
	// map is used to store key value pairs
	//Here , we are making use of map , to pass required headers to the specific request
	// req is an object of type 'RequestObject' in rest assured library 
	
//	req.setHeader("Authorization",key1);
//    req.setHeader("Content-Type","application/json");
//    req.setPathParam("FullfilmentNo",data.get("STSOrderNumber"));
	
	public static void main(String args[]){  
		  Map<Integer,String> map=new HashMap<Integer,String>();  
		  map.put(100,"Amit");  
		  map.put(101,"Vijay");  
		  map.put(102,"Rahul");  
		  //Elements can traverse in any order  
		  for(Map.Entry m:map.entrySet()){  
		   System.out.println(m.getKey()+" "+m.getValue());  
		  }  
		   
	
	HashMap<Integer,String> hm=new HashMap<Integer,String>();    
    System.out.println("Initial list of elements: "+hm);  
      hm.put(100,"Amit");    
      hm.put(101,"Vijay");    
      hm.put(102,"Rahul");   
       
      System.out.println("After invoking put() method ");  
      for(Map.Entry m:hm.entrySet()){    
       System.out.println(m.getKey()+" "+m.getValue());    
      }  
        
      hm.putIfAbsent(103, "Gaurav");  
      System.out.println("After invoking putIfAbsent() method ");  
      for(Map.Entry m:hm.entrySet()){    
           System.out.println(m.getKey()+" "+m.getValue());    
          }  
      HashMap<Integer,String> map1=new HashMap<Integer,String>();  
      map1.put(104,"Ravi");  
      map1.putAll(hm);  
      System.out.println("After invoking putAll() method ");  
      for(Map.Entry m:map1.entrySet()){    
           System.out.println(m.getKey()+" "+m.getValue());    
          }  
 }  
}
