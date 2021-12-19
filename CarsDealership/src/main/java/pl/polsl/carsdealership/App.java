package pl.polsl.carsdealership;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * main class, needed to launch application
 * @version 1.2
 * @author piotr
 */
public class App extends Application {

    /**
     * method used to start application
     * @param stage stage where everything is shown
     * @throws IOException yes
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("LoginMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Car Dealership");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * main method of programme
     * @param args standard arguments from terminal
     */
    public static void main(String[] args) {
        launch();
    }
}