package pl.polsl.piotr.januszkiewicz.cardealership.view;


import pl.polsl.piotr.januszkiewicz.cardealership.controller.*;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Class responsible for printing requests for data and response from program.
 * 
 * @author piotr
 */
public class UserInterface {
   
    /**
     *  this object is used to determine wether searched car exist or not.
     */
     int doesCarExist;
             
    /**
     * method used to print car request.
     */
    private void printCarRequest(){
        
        System.out.println("Podaj marke auta, ktora cie interesuje");
    }
    
    /**
     * method used to print response from program.
     */
    private void printResponse(){
         if(doesCarExist == 1)
            System.out.println("This car does indeed exist in our database");
        if(doesCarExist == 0)
            System.out.println("Sorry...");
    }
    
    /**
     * method used to call print requests for data and response.
     */
    public void printR(){
        
        Scanner collectInputData = new Scanner(System.in);
        Communication controller = new Communication();

        printCarRequest();
        
        doesCarExist = controller.passDataToModel(collectInputData);
        
        printResponse();
    }
    
    
    
}
