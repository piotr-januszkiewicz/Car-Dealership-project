module pl.polsl.carsdealership {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.polsl.carsdealership to javafx.fxml;
    exports pl.polsl.carsdealership;
}