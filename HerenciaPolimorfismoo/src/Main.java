public class Main {
    public static void main(String[] args) {

        // --- Ejemplo de Herencia ---
        Perro dogo = new Perro("Dogo");
        Gato rawrl = new Gato("rawrl");

        dogo.comer();
        dogo.hacerSonido();
        dogo.marcarTerritorio();

        rawrl.comer();
        rawrl.hacerSonido();

        System.out.println("-----------------------------");

        // --- Ejemplo de Polimorfismo ---
        // Creamos un arreglo de la clase padre (Animal) pero guardamos objetos hijos
        Animal[] animales = new Animal[3];
        animales[0] = new Perro("Ramonchis");
        animales[1] = new Gato("Salem");
        animales[2] = new Perro("Firulais");

        for (Animal animal : animales) {
            // Se ejecuta el sonido correspondiente a la clase real del objeto
            animal.hacerSonido();
        }

        System.out.println("_____________________________");

        // --- Ejemplo de Casting e InstanceOf ---
        Animal miercoles = new Perro("Miercoles");

        // Verificamos si la variable tipo Animal es realmente un Perro
        if (miercoles instanceof Perro) {
            // Convertimos (Casting) para acceder a métodos específicos de Perro
            Perro miercolesConvertido = (Perro) miercoles;
            miercolesConvertido.marcarTerritorio();
        }
    }
}