package pl.polsl.carsdealership;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
//TODO:  podział na paczki, testy

/**
 * main menu controller for administrator
 * @version 1.2
 * @author piotr
 */
public class MenuController implements Initializable{

    /**
     * object used to communicate with model
     */
    private Backend backend;

    /**
     * table that include information about cars
     */
    @FXML
    private TableView<Car> tableView;

    /**
     * column of table, gives information about cars' model
     */
    @FXML private TableColumn<Car, String> modelColumn;

    /**
     * column of table, gives information about cars' color
     */
    @FXML private TableColumn<Car, String> colorColumn;

    /**
     * column of table, gives information about cars' year of production
     */
    @FXML private TableColumn<Car, Integer> yearColumn;

    /**
     * column of table, gives information about cars' price
     */
    @FXML private TableColumn<Car, Integer> priceColumn;

    /**
     * label that informs user about how much money does he/she has in its' wallet
     */
    @FXML private Label Balance;

    /**
     * textfield used when a new car is to be added, holds model information
     */
    @FXML private TextField Model;

    /**
     * textfield used when a new car is to be added, holds color information
     */
    @FXML private TextField Color;

    /**
     * textfield used when a new car is to be added, holds year information
     */
    @FXML private TextField Year;

    /**
     * textfield used when a new car is to be added, holds price information
     */
    @FXML private TextField Price;

    /**
     * constructor creating a new model object
     */

    public MenuController()
    {
        backend = new Backend();
    }

    /**
     * method that overrides method implemented in interface. used to create a visualization of a table
     * @param url i dont think i know
     * @param rb i literally have no idea
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("Model"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("Color"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("Year"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));

        tableView.setItems(getCars());
        tableView.setEditable(true);
        modelColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        colorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        yearColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        priceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    }

    /**
     * method used to get a list of cars from model
     * @return observable list of cars
     */
    public ObservableList<Car> getCars(){
        ObservableList<Car> cars = FXCollections.observableArrayList();
        for(Car element : backend.getCarList()){
            cars.add(element);
        }
        return cars;
    }

    /**
     * method used to create a new car object
     * @throws IOException yes
     */
    @FXML
    private void addNewCar() throws IOException{
        if(!Model.getText().isEmpty() && !Color.getText().isEmpty() &&
                !Year.getText().isEmpty() && !Price.getText().isEmpty()){

            if(backend.checkIfPriceInRange(Integer.parseInt(Price.getText())) &&
                    backend.checkIfYearInRange(Integer.parseInt(Year.getText())))
            {
                Car newElem = new Car(String.valueOf(Model.getText()), String.valueOf(Color.getText()),
                        Integer.parseInt(Year.getText()), Integer.parseInt(Price.getText()));
                backend.addNewCarToList(newElem);
                Model.setText("");
                Color.setText("");
                Year.setText("");
                Price.setText("");

                tableView.setItems(getCars());
            }else{
                openDialogWindow("WrongValue.fxml");
            }
        }else{
            openDialogWindow("WrongValue.fxml");
        }
    }

    /**
     * method used to open a new dialog window
     * @param source fxml file to open
     * @throws IOException yes
     */
    private void openDialogWindow(String source) throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(source));
        Parent parent = fxmlloader.load();

        Scene scene = new Scene(parent, 300, 200);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    /**
     * method used to let a user buy the car. Method checks if any car is set and if client has enough money.
     * @throws IOException yes
     */
    @FXML
    private void buyCar() throws IOException {

        if(!tableView.getSelectionModel().getSelectedItems().isEmpty()){
            if(Integer.parseInt(Balance.getText()) >= tableView.getSelectionModel().getSelectedItem().getPrice()){

                int balance = Integer.parseInt(Balance.getText());
                Balance.setText(String.valueOf(balance - tableView.getSelectionModel().getSelectedItem().getPrice()));
                deleteFromTable();
                openDialogWindow("BoughtCar.fxml");

            }else{
                openDialogWindow("PoorPerson.fxml");
            }
        }
    }

    /**
     * method used to add money to clients' wallet
     * @throws IOException yes
     */
    @FXML
    private void addMoney() throws IOException {

        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("AddMoneyDialog.fxml"));
        Parent parent = fxmlloader.load();
        AddMoneyController addMoneyController = fxmlloader.<AddMoneyController>getController();
        addMoneyController.passMoneyObject(Balance);

        Scene scene = new Scene(parent, 300, 200);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    /**
     * method used to delete a record from table
     */
    @FXML
    private void deleteFromTable() {
        tableView.getSelectionModel().getSelectedItems().forEach(activity -> {
            backend.removeCarFromList(activity);
        });
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItems());
        tableView.setItems(getCars());
    }

    /**
     * method used to edit selected object in model column
     * @param carStringCellEditEvent editing event
     */
    public void onEditChangedModel(TableColumn.CellEditEvent<Car, String> carStringCellEditEvent) {
        Car car = tableView.getSelectionModel().getSelectedItem();
        car.setModel(carStringCellEditEvent.getNewValue());

    }

    /**
     * method used to edit selected object in color column
     * @param carStringCellEditEvent editing event
     */
    public void onEditChangedColor(TableColumn.CellEditEvent<Car, String> carStringCellEditEvent) {
        Car car = tableView.getSelectionModel().getSelectedItem();
        car.setColor(carStringCellEditEvent.getNewValue());

    }

    /**
     * method used to edit selected object in year column
     * @param carIntegerCellEditEvent editing event
     */
    public void onEditChangedYear(TableColumn.CellEditEvent<Car, Integer> carIntegerCellEditEvent) {
        Car car = tableView.getSelectionModel().getSelectedItem();
        car.setYear(carIntegerCellEditEvent.getNewValue());

    }

    /**
     * method used to edit selected object in price column
     * @param carIntegerCellEditEvent editing event
     */
    public void onEditChangedPrice(TableColumn.CellEditEvent<Car, Integer> carIntegerCellEditEvent) {
        Car car = tableView.getSelectionModel().getSelectedItem();
        car.setPrice(carIntegerCellEditEvent.getNewValue());

    }

    /**
     * method used to exit from application
     * @param event needed to make stage close possible
     */
    @FXML
    private void exit(Event event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
