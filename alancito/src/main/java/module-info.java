module com.example.alancito {
    requires javafx.controls;
    requires javafx.fxml;

    // Esto es lo que permite que el FXML use tus controladores
    opens com.example.alancito.controllers to javafx.fxml;

    exports com.example.alancito;
}