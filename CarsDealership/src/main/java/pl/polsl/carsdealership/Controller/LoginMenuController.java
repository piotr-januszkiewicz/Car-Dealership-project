package pl.polsl.carsdealership.Controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * class used to handle case where client wants to add money to its' wallet
 * @version 1.2
 * @author piotr
 */
public class LoginMenuController {

    /**
     * text field used to write login
     */
    @FXML private TextField Login;

    /**
     * password field used to write password
     */
    @FXML private PasswordField Password;

    /**
     * method checks if given login and password is ok
     * @throws IOException yes
     */
    @FXML
    private void checkIfLoginAndPassIsOk() throws IOException {
        if(Login.getText().equals("admin") && Password.getText().equals("admin")) {
            openProperFxml("/pl/polsl/carsdealership/MainMenu.fxml");
        }else{
            openProperFxml("/pl/polsl/carsdealership/ClientMenu.fxml");
        }
        Login.setText("");
        Password.setText("");
    }

    /**
     * method used to open proper menu
     * @param fxml fxml file to open
     * @throws IOException yes
     */
    private void openProperFxml(String fxml) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(fxml));
        Parent parent = fxmlloader.load();

        Scene scene = new Scene(parent, 600, 400);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
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
