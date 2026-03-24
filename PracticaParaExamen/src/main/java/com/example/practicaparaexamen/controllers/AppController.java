package com.example.demolistview.controllers;
//impotacion conexion con los demas archivos de crud
import com.example.demolistview.models.Contacto;
import com.example.demolistview.services.PersonService;



import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AppController {
    @FXML private TextField txtNombre, txtTelefono;
    @FXML private ComboBox<String> cmbParentesco;
    @FXML private ListView<Contacto> lvContactos;

    private PersonService service = new PersonService();

    // arreglo para parentescos
    private String[] opciones = {"Padre", "Madre"    , "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"};

    @FXML
    public void initialize() {
        cmbParentesco.getItems().addAll(opciones);
    }

    @FXML
    private void handleAgregar() {
        String nom = txtNombre.getText();
        String tel = txtTelefono.getText();
        String par = cmbParentesco.getValue();

        // validaciones reglas
        if (nom.isEmpty() || tel.isEmpty() || par == null) return;
        if (tel.length() != 10) return; // solo de 10 dijitos no mas
        if (service.buscar(nom) != null) return; // no duplicar nombres

        service.agregar(new Contacto(nom, tel, par));
        actualizarVista();
        handleLimpiar();
    }

    @FXML
    private void handleBuscar() {
        Contacto encontrado = service.buscar(txtNombre.getText());
        if (encontrado != null) {
            txtTelefono.setText(encontrado.getTelefono());
            cmbParentesco.setValue(encontrado.getParentesco());
        }
    }

    @FXML
    private void handleActualizar() {
        if (service.actualizar(txtNombre.getText(), txtTelefono.getText(), cmbParentesco.getValue())) {
            actualizarVista();
        }
    }

    @FXML
    private void handleEliminar() {
        if (service.eliminar(txtNombre.getText())) {
            actualizarVista();
            handleLimpiar();
        }
    }

    @FXML
    private void handleLimpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        cmbParentesco.setValue(null);
    }

    private void actualizarVista() {
        lvContactos.getItems().setAll(service.getLista());
    }
}