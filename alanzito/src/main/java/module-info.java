module com.example.alanzito {
    requires javafx.controls;
    requires javafx.fxml;

    // Abrimos el paquete para que JavaFX pueda leerlo
    opens com.example.alanzito to javafx.fxml;

    exports com.example.alanzito;
}