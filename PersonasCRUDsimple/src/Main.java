import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona[] personas = new Persona[20];
        PersonaService service = new PersonaService();
        int opcion = -1;

        do {
            System.out.println("\n---------- MENU DE GESTION ----------");
            System.out.println("1.- Alta");
            System.out.println("2.- Buscar por ID (solo activas)");
            System.out.println("3.- Baja logica por ID");
            System.out.println("4.- Listar activas");
            System.out.println("5.- Actualizar nombre por ID");
            System.out.println("0.- Salir");
            System.out.print("Elige una opcion: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        service.alta(sc, personas);
                        break;
                    case 2:
                        service.buscar(sc, personas);
                        break;
                    case 3:
                        service.bajaLogica(sc, personas);
                        break;
                    case 4:
                        service.listarActivas(personas);
                        break;
                    case 5:
                        service.actualizarNombre(sc, personas);
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opcion invalida. Intente de nuevo.");
                        break;
                }
            } else {
                System.out.println("Error: Ingrese un numero valido.");
                sc.next(); // Limpia el buffer si el usuario mete letras
            }
        } while (opcion != 0);

        sc.close();
    }
}