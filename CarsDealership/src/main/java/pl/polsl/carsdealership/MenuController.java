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
//TODO:  javadoc, podział na paczki, testy

/**
 * main menu controller for administrator
 * @version 1.2
 * @author piotr
 */
public class MenuController implements Initializable{
    
    private Backend backend;
   
    @FXML private TableView<Car> tableView;
    
    @FXML private TableColumn<Car, String> modelColumn;
    @FXML private TableColumn<Car, String> colorColumn;
    @FXML private TableColumn<Car, Integer> yearColumn;
    @FXML private TableColumn<Car, Integer> priceColumn;
    
    @FXML private TextField Model;
    @FXML private TextField Color;
    @FXML private TextField Year;
    @FXML private TextField Price;

    @FXML private Label Balance;

    public MenuController()
    {
        backend = new Backend();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
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
    
    public ObservableList<Car> getCars(){
        ObservableList<Car> cars = FXCollections.observableArrayList();
        for(Car element : backend.getCarList())
        {
            cars.add(element);
        }
        return cars;
    }

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

    private void openDialogWindow(String source) throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(source));
        Parent parent = fxmlloader.load();

        Scene scene = new Scene(parent, 300, 200);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

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

    @FXML
    private void deleteFromTable() {
        tableView.getSelectionModel().getSelectedItems().forEach(activity -> {
            backend.removeCarFromList(activity);
        });
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItems());
        tableView.setItems(getCars());
    }

    public void onEditChangedModel(TableColumn.CellEditEvent<Car, String> carStringCellEditEvent) {
        Car car = tableView.getSelectionModel().getSelectedItem();
        car.setModel(carStringCellEditEvent.getNewValue());

    }

    public void onEditChangedColor(TableColumn.CellEditEvent<Car, String> carStringCellEditEvent) {
        Car car = tableView.getSelectionModel().getSelectedItem();
        car.setColor(carStringCellEditEvent.getNewValue());

    }

    public void onEditChangedYear(TableColumn.CellEditEvent<Car, Integer> carIntegerCellEditEvent) {
        Car car = tableView.getSelectionModel().getSelectedItem();
        car.setYear(carIntegerCellEditEvent.getNewValue());

    }

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
