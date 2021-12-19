package pl.polsl.carsdealership;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author piotr
 */
public class Car {
    
    /**
     * private fields that hold cars' data: model, color, year of production, price
     */
    private final String model;
    private final String color;
    private final int year;
    private final int price;
    
    /**
     * constructor used to create Car object
     *
     * @param Model model of the car
     * @param Color color of the car
     * @param Year year of production
     * @param Price price for the car
     */
    public Car(String Model, String Color, int Year, int Price) {
        model = Model;
        color = Color;
        year = Year;
        price = Price;
    }

    /**
     * method used to read cars' model
     * 
     * @return cars' model
     */
    public String getModel() {
        return model;
    }

    /**
     * method used to read cars' color
     * 
     * @return cars' color
     */
    public String getColor() {
        return color;
    }

    /**
     * method used to read cars' year of production
     * 
     * @return cars' year of production
     */
    public int getYear() {
        return year;
    }

    /**
     * method used to read cars' price
     *
     * @return cars' price
     */
    public int getPrice() {
        return price;
    }
}
