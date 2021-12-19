package pl.polsl.carsdealership.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * class responsible for handling border cases by showing dialog window with information "Wrong value"
 * @version 1.2
 * @author piotr
 */
public class StandardDialogController {

    /**
     * method used to close dialog after the button is pressed
     * @param event reading event type
     */
    @FXML
    private void ok(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
