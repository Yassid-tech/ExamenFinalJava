module com.poo.examenfinaljava {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.poo.examenfinaljava to javafx.fxml;
    exports com.poo.examenfinaljava;
}