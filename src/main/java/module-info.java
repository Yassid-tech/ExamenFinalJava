module com.poo.examenfinaljava {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.poo.examenfinaljava to javafx.fxml;
    exports com.poo.examenfinaljava;
}