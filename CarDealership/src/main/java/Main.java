/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import pl.polsl.piotr.januszkiewicz.cardealership.view.UserInterface;

/**
 * Main class responsible for first interaction with user.
 * Collects data from user and decides wether to let in or not.
 * 
 * @author piotr
 */
public class Main {

    /**
     *  this object is a data structure used to hold username and password.
     */
    private static String[] usernameAndPassword = new String[]{null, null};
    /**
     *  this object is used to inform wether user is new or logging in.
     */
    private static int isNewUser = 0;
    
    
    
    /**
     * This method returns a new variable containing
     * username and password passed as arguments from command line.
     * 
     * @param args the command line arguments
     * @return String table with username and password
     */
    private static String[] readData(String[] args){
        
        if(args.length == 0)
            return usernameAndPassword;
        if(args[0].equals("-c"))
            isNewUser = 1;
        
        System.out.println(args.length);
        
        if((args.length == 2 && isNewUser == 0) || 
           (args.length == 3 && isNewUser == 1)){
        
            usernameAndPassword[0] = args[isNewUser];
            usernameAndPassword[1] = args[isNewUser+1];
        }
           
        return usernameAndPassword;
    }
    
    /**
     * This method checks if there are arguments passed
     * from a command line.
     * 
     * @param usernameAndPassword array with username and password
     * @return 0 if both arguments are passed, 1 otherwise
     */
    private static int checkIfArgsAreNotEmpty(){
        
        if(usernameAndPassword[0] == null || usernameAndPassword[1] == null){
            
            System.out.println("You have to put username and password");
            return 1;
        }
        
        return 0;
    }
    
    
    /**
     * contains users account data to log in
     * if you are a new client you need to create an account.
     * For that you have to put -c as first argument.
     * First (after -c) argument is a username and next one is password.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        int isDataPassed = 1;
        
        usernameAndPassword = readData(args);
        isDataPassed = checkIfArgsAreNotEmpty();
        
        if(isDataPassed == 1)
            return;
        if(isNewUser == 1)
            System.out.println("Welcome new customer!");
        
        UserInterface view = new UserInterface();
        view.printR();
    }
}
