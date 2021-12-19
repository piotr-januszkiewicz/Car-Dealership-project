package pl.polsl.carsdealership.Controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * class used to handle case where client wants to add money to its' wallet
 * @version 1.2
 * @author piotr
 */
public class AddMoneyController {

    /**
     * text field used to pass amount of money to add to wallet
     */
    @FXML private TextField Money;

    /**
     * object keeping label from main menu. Added value will be written here
     */
    private Label moneyLabel;

    /**
     * method adds given amount of money to label and go back to main menu
     * @param event needed to make stage close possible
     */
    @FXML
    private void submit(Event event){

        if(Integer.parseInt(Money.getText()) >0 && Integer.parseInt(Money.getText())<50000000 )
        {
            int money = Integer.parseInt(moneyLabel.getText());
            money+=Integer.parseInt(Money.getText());
            moneyLabel.setText(String.valueOf(money));

            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        }
    }

    /**
     * method used to pass a label object
     * @param Balance amount of money taken from main menu
     */
    public void passMoneyObject(Label Balance){
        this.moneyLabel = Balance;
    }

}
