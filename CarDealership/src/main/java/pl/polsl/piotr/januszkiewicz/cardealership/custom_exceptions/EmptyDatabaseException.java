/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.piotr.januszkiewicz.cardealership.custom_exceptions;

/**
 *
 * @author piotr
 */
public class EmptyDatabaseException extends Exception {
    public EmptyDatabaseException(String errorMessage){
        super(errorMessage);
    }
    
    
    
}
