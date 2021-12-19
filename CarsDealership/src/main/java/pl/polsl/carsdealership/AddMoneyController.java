package pl.polsl.carsdealership;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddMoneyController {

    @FXML private TextField Money;

    private Label moneyLabel;

    @FXML
    private void submit(Event event) throws IOException {
        moneyLabel.setText(Money.getText());

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void passMoneyObject(Label Balance){
        this.moneyLabel = Balance;
    }

}
