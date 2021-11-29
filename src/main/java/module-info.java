module com.example.apspota {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.apspota to javafx.fxml;
    exports com.example.apspota;
}