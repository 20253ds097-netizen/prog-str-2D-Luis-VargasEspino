public class Persona {
    private int id;
    private String name;
    private boolean activo;
    private double promedio;
    public Persona() {}
    public Persona(int id, String name, double promedio) {
        this.id = id;
        this.name = name;
        this.promedio = promedio;
        this.activo = true;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public double getPromedio() {
        return promedio;
    }
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    @Override
    public String toString() {
        return "ID=" + id +
                "Nombre=" + name +
                "Activo=" + activo +
                "Promedio=" + promedio;
    }
}