module pl.polsl.carsdealership {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.polsl.carsdealership to javafx.fxml;
//    exports pl.polsl.carsdealership;
    exports pl.polsl.carsdealership.Controller;
    opens pl.polsl.carsdealership.Controller to javafx.fxml;
    exports pl.polsl.carsdealership.Model;
    opens pl.polsl.carsdealership.Model to javafx.fxml;
}