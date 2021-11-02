package pl.polsl.piotr.januszkiewicz.cardealership.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import pl.polsl.piotr.januszkiewicz.cardealership.model.*;
import java.util.Scanner;
/**
 * class responsible for collecting response from user.
 * @author piotr
 */
public class Communication {
   
    public int passDataToModel(Scanner collectInputData){
        
        String carModel = collectInputData.nextLine();
        Database model = new Database();
       
        return model.checkIfCarExists(carModel);
    }
}
