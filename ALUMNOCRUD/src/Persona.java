
public class Persona {
    private int id;
    private String name;
    private boolean activo;
    private double promedio;

    public Persona() {
    }

    public Persona(int id, String name, double promedio) {
        this.id = id;
        this.name = name;
        this.promedio = promedio;
        this.activo = true;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActivo() {
        return this.activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public double getPromedio() {
        return this.promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public String toString() {
        return "ID=" + this.id + "Nombre=" + this.name + "Activo=" + this.activo + "Promedio=" + this.promedio;
    }
}
