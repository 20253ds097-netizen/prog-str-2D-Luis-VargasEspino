import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona[] personas = new Persona[20];
        PersonaService service = new PersonaService();

        int opcion;
        do {
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Alta");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Baja Logica");
            System.out.println("4. Listar Activas");
            System.out.println("5. Actualizar Nombre");
            System.out.println("6. Reportes");
            System.out.println("7. Salir");
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
                case 6:
                    service.reportes(personas);
                    break;
                case 7:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while(opcion != 7);

        sc.close();
    }
}
