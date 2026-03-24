module com.example.practicaparaexamen {
    requires javafx.controls;
    requires javafx.fxml;

    // Esto permite que JavaFX lea tus archivos FXML
    opens com.example.practicaparaexamen to javafx.fxml;

    // ESTA ES LA LÍNEA CLAVE:
    // Permite que el cargador de FXML entre a tu carpeta de controladores
    opens com.example.demolistview.controllers to javafx.fxml;

    // Exporta los paquetes para que sean visibles
    exports com.example.practicaparaexamen;
    exports com.example.demolistview.controllers;
    exports com.example.demolistview.models;
}