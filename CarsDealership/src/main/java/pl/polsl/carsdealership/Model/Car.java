package pl.polsl.carsdealership.Model;

/**
 * class used to create a car object
 * @version 1.2
 * @author piotr
 */
public class Car {

    /**
     * private fields that hold cars' data: model, color, year of production, price
     */
    private  String model;
    private  String color;
    private  int year;
    private  int price;

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
     * method used to read cars' model
     *
     * @return cars' model
     */
    public void setModel(String Model) {
        this.model = Model;
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
     * method used to read cars' model
     *
     * @return cars' model
     */
    public void setColor(String Color) {
        this.color = Color;
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
     * method used to read cars' model
     *
     * @return cars' model
     */
    public void setYear(int Year) {
        this.year = Year;
    }

    /**
     * method used to read cars' price
     *
     * @return cars' price
     */
    public int getPrice() {
        return price;
    }

    /**
     * method used to read cars' model
     *
     * @return cars' model
     */
    public void setPrice(int Price) {
        this.price = Price;
    }

}
