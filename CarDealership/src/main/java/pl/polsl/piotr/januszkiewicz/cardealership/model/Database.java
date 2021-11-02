package pl.polsl.piotr.januszkiewicz.cardealership.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Array;
/**
 *
 * @author piotr
 */
public class Database {
    
   private final static String []cars = new String [] 
   {"Lamborghini", "Peugeot", "BMW"};
   
   private final static Map<String, String> users = 
           new HashMap<String, String> ();
   
   
   
   public int checkIfCarExists(String car_model){
       
       for(int i=0;i<cars.length;i++){
            if(Array.get(cars, i).equals(car_model))
                return 1;
       }
       return 0;
   }
   
   public int checkIfUserExists(String[] usernameAndPassword){
       
       
       return 0;
   }
}
