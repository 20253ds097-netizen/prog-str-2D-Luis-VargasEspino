import java.util.Scanner;
public class PersonaService {
    private boolean existeId(Persona[] personas, int id) {
        for (Persona persona : personas) {
            if (persona != null && persona.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public void alta(Scanner sc, Persona[] personas) {
        int id;
        double promedio;
        System.out.println("Alta de Persona");
        System.out.print("Ingresa el id: ");
        if (!sc.hasNextInt()) {
            System.out.println("Error: el id debe ser un número entero");
            sc.nextLine();
            return;
        }
        id = sc.nextInt();
        sc.nextLine();
        if (id <= 0) {
            System.out.println("El id debe ser mayor que 0");
            return;
        }
        if (existeId(personas, id)) {
            System.out.println("El id ya existe");
            return;
        }
        System.out.print("Ingresa el nombre: ");
        String nombre = sc.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío");
            return;
        }
        System.out.print("Ingresa el promedio: ");
        if (!sc.hasNextDouble()) {
            System.out.println("Ingrese un numero valido");
            sc.nextLine();
            return;
        }
        promedio = sc.nextDouble();
        sc.nextLine();
        if (promedio < 0 || promedio > 10) {
            System.out.println("El promedio debe estar entre 0 y 10");
            return;
        }
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                personas[i] = new Persona(id, nombre, promedio);
                System.out.println("Registro hecho correctamente");
                return;
            }
        }

        System.out.println("No hay espacio disponible");
    }
    public void buscar(Scanner sc, Persona[] personas) {
        System.out.print("Id para buscar: ");
        int id = sc.nextInt();
        for (Persona p : personas) {
            if (p != null && p.getId() == id && p.isActivo()) {
                System.out.println("Resultado: " + p);
                return;
            }
        }

        System.out.println("No existe persona activa con ese id");
    }
    public void bajaLogica(Scanner sc, Persona[] personas) {
        System.out.print("Id para dar de baja: ");
        int id = sc.nextInt();

        for (Persona p : personas) {
            if (p != null && p.getId() == id) {
                p.setActivo(false);
                System.out.println("Baja realizada");
                return;
            }
        }

        System.out.println("No fue encontrado");
    }
    public void listarActivas(Persona[] personas) {
        System.out.println("Personas activas:");
        for (Persona p : personas) {
            if (p != null && p.isActivo()) {
                System.out.println(p);
            }
        }
    }
    public void actualizarNombre(Scanner sc, Persona[] personas) {
        System.out.print("ID a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Persona p : personas) {
            if (p != null && p.getId() == id && p.isActivo()) {
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = sc.nextLine();

                if (!nuevoNombre.trim().isEmpty()) {
                    p.setName(nuevoNombre);
                    System.out.println("Actualizado correctamente");
                } else {
                    System.out.println("Nombre invalido");
                }
                return;
            }
        }

        System.out.println("No se puede actualizar");
    }
    public void reportes(Persona[] personas) {
        double suma = 0;
        int contador = 0;
        int mayoresA8 = 0;
        Persona mayor = null;
        Persona menor = null;
        for (Persona p : personas) {
            if (p != null && p.isActivo()) {

                double prom = p.getPromedio();
                suma += prom;
                contador++;

                if (prom >= 8.0) {
                    mayoresA8++;
                }

                if (mayor == null || prom > mayor.getPromedio()) {
                    mayor = p;
                }

                if (menor == null || prom < menor.getPromedio()) {
                    menor = p;
                }
            }
        }
        if (contador == 0) {
            System.out.println("No hay alumnos activos");
            return;
        }
        double promedioGeneral = suma / contador;
        System.out.println(" REPORTES ");
        System.out.println("Promedio general: " + promedioGeneral);
        System.out.println("Mayor promedio: " + mayor);
        System.out.println("Menor promedio: " + menor);
        System.out.println("Cantidad con promedio >= 8: " + mayoresA8);
    }
}

