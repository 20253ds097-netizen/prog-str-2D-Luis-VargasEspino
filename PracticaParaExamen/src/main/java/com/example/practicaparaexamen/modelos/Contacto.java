package com.example.demolistview.models;

public class Contacto {
    private String nombre;
    private String telefono;
    private String parentesco;

    public Contacto(String nombre, String telefono, String parentesco) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.parentesco = parentesco;
    }

    // Getters,Setters para el crud
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String t) { this.telefono = t; }
    public String getParentesco() { return parentesco; }
    public void setParentesco(String p) { this.parentesco = p; }

    @Override
    public String toString() {
        return nombre + " - " + telefono + " (" + parentesco + ")";
    }
}