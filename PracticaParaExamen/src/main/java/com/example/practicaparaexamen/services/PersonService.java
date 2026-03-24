package com.example.demolistview.services;

import com.example.demolistview.models.Contacto;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    // almacenar datos en la memoria sin archivo
    private List<Contacto> listaContactos = new ArrayList<>();

    public void agregar(Contacto c) {
        listaContactos.add(c);
    }

    public Contacto buscar(String nombre) {
        return listaContactos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst().orElse(null);
    }

    public boolean eliminar(String nombre) {
        Contacto c = buscar(nombre);
        return listaContactos.remove(c);
    }

    public boolean actualizar(String nombre, String nuevoTel, String nuevoPar) {
        Contacto c = buscar(nombre);
        if (c != null) {
            c.setTelefono(nuevoTel);
            c.setParentesco(nuevoPar);
            return true;
        }
        return false;
    }

    public List<Contacto> getLista() {
        return listaContactos;
    }
}