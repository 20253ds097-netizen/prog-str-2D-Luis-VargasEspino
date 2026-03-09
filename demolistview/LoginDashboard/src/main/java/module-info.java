module com.example.logindashboard {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.logindashboard to javafx.fxml;
    exports com.example.logindashboard;
}