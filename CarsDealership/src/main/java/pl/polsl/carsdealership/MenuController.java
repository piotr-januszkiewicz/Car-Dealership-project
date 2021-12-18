package pl.polsl.carsdealership;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
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
        modelColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("Model"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("Color"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("Year"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("Price"));
        
        tableView.setItems(getCars());
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
            
            Car newElem = new Car(String.valueOf(Model.getText()), String.valueOf(Color.getText()), 
                    Integer.parseInt(Year.getText()), Integer.parseInt(Price.getText()));    
            backend.addNewCarToList(newElem);
            Model.setText("");
            Color.setText("");
            Year.setText("");
            Price.setText("");
        }
        
        tableView.setItems(getCars());
    }

    @FXML
    private void buyCar() throws IOException {

        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("BoughtCar.fxml"));
        Parent parent = fxmlloader.load();

        Scene scene = new Scene(parent, 300, 200);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    private void addMoney(){

    }

    @FXML
    private void deleteFromTable() {
        tableView.getSelectionModel().getSelectedItems().forEach(activity -> {
            backend.removeCarFromList(activity);
        });
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItems());
        tableView.setItems(getCars());
    }

    @FXML
    private void Exit(){

    }
}
