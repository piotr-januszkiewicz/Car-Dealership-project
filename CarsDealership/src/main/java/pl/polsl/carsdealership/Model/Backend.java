package pl.polsl.carsdealership.Model;

import java.util.*;

/**
 * class responsible for communication between controller and database
 *
 * @version 1.2
 * @author Piotr Januszkiewicz
 */
public class Backend {

    /**
     * private fields that hold 2 lists containing users and cars data
     */
   // private static List<User> userList;
    private static List<Car> carList;

   
    public Backend(){
        /* userList = new ArrayList<User>(){}; */
        carList = new ArrayList<Car>() {};
    }

    /**
     * method give information about size of car list
     * 
     * @return size of car list
     */
    public List<Car> getCarList() {
        return carList;
    }

    /**
     * method adds a new object to car list
     * 
     * @param newCar a new car
     */
    public void addNewCarToList(Car newCar) {
        carList.add(newCar);
    }

    /**
     * method returns a car list object
     * 
     * @return a list of cars
     */
    public List<Car> passCarList() {
        return carList;
    }
    
    /**
     * method removes a car from list
     *
     * @param pos Car object
     */
    public void removeCarFromList(Car pos) {
        carList.remove(pos);
    }

    /**
     * method checks if a car is in range of given money budget
     * 
     * @param money price customer is willing to pay for a car
     * @param CarPrice price for a car
     * @return information if car is in range of money
     */
    public int checkIfCarInRangeOfMoney(int money, int CarPrice) {
        if (CarPrice >= 0 && CarPrice <= money) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * method checks if amount of money for a car set by manager is valid
     * 
     * @param CarPrice price for a car
     * @return information if car price is valid
     */
    public Boolean checkIfPriceInRange(int CarPrice) {
        return CarPrice >= 0 && CarPrice <= 50000000;
    }

    /**
     * method checks if cars' year of production set by manager is valid
     * 
     * @param CarYear cars' year of production
     * @return information if given year of production is valid
     */
    public Boolean checkIfYearInRange(int CarYear) {
        return CarYear >= 1930 && CarYear <= 2021;
    }
}
