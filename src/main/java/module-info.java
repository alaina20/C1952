module com.example.c1952 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.c1952 to javafx.fxml;
    exports com.example.c1952;
    exports Controller;
    opens Controller to javafx.fxml;
    exports model;
    opens model to javafx.fxml;
}