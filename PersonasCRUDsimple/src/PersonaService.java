import java.util.Scanner;

public class PersonaService {

    // Validación de ID repetido
    private boolean existeId(Persona[] personas, int id) {
        for (Persona p : personas) {
            if (p != null && p.getId() == id) return true;
        }
        return false;
    }

    public void alta(Scanner sc, Persona[] personas) {
        System.out.print("Ingrese ID (mayor a 0): ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        if (id <= 0) {
            System.out.println("Error: El ID debe ser mayor a 0.");
            return;
        }
        if (existeId(personas, id)) {
            System.out.println("Error: El ID ya existe.");
            return;
        }

        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return;
        }

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                personas[i] = new Persona(id, nombre);
                System.out.println("Registro exitoso.");
                return;
            }
        }
    }

    public void buscar(Scanner sc, Persona[] personas) {
        System.out.print("ID a buscar: ");
        int id = sc.nextInt();
        for (Persona p : personas) {
            if (p != null && p.getId() == id && p.isActiva()) {
                System.out.println("Encontrado: " + p);
                return;
            }
        }
        System.out.println("Persona no encontrada o inactiva.");
    }

    public void bajaLogica(Scanner sc, Persona[] personas) {
        System.out.print("ID para dar de baja: ");
        int id = sc.nextInt();
        for (Persona p : personas) {
            if (p != null && p.getId() == id) {
                p.setActiva(false);
                System.out.println("Baja realizada.");
                return;
            }
        }
        System.out.println("ID no encontrado.");
    }

    public void listarActivas(Persona[] personas) {
        System.out.println("--- Lista de Personas Activas ---");
        for (Persona p : personas) {
            if (p != null && p.isActiva()) System.out.println(p);
        }
    }

    public void actualizarNombre(Scanner sc, Persona[] personas) {
        System.out.print("ID para actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Persona p : personas) {
            if (p != null && p.getId() == id && p.isActiva()) {
                System.out.print("Nuevo nombre: ");
                String nuevo = sc.nextLine();
                if (!nuevo.trim().isEmpty()) {
                    p.setNombre(nuevo);
                    System.out.println("Nombre actualizado.");
                } else {
                    System.out.println("Nombre inválido.");
                }
                return;
            }
        }
        System.out.println("Persona no encontrada o inactiva.");
    }
}