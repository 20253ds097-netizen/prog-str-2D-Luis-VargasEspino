import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Alumno[] alumnos = new Alumno[25];
        int opcion = -1;

        do {
            System.out.println("sistema de alumnads");
            System.out.println("1. Alta Alumno");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Actualizar Promedio");
            System.out.println("4. Baja Logica");
            System.out.println("5. Listar Activos");
            System.out.println("6. Reportes");
            System.out.println("0. Salir");
            System.out.print("Seleccione ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.print("ID (>0): ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        // Validaciones ID
                        boolean repetido = false;
                        for(Alumno a : alumnos) if(a != null && a.id == id) repetido = true;

                        if (id <= 0 || repetido) {
                            System.out.println("ID invalido o repetido.");
                            break;
                        }

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        if (nombre.trim().isEmpty()) {
                            System.out.println("El nombre no puede estar vacio.");
                            break;
                        }

                        System.out.print("Promedio (0-10): ");
                        double prom = sc.nextDouble();
                        if (prom < 0 || prom > 10) {
                            System.out.println("Promedio fuera de rango.");
                            break;
                        }

                        for (int i = 0; i < alumnos.length; i++) {
                            if (alumnos[i] == null) {
                                alumnos[i] = new Alumno(id, nombre, prom);
                                System.out.println("Alumno registrado.");
                                break;
                            }
                        }
                        break;

                    case 2:
                        System.out.print("ID a buscar: ");
                        int buscarId = sc.nextInt();
                        boolean encontrado = false;
                        for (Alumno a : alumnos) {
                            if (a != null && a.id == buscarId && a.activo) {
                                System.out.println("Encontrado: " + a);
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) System.out.println("No encontrado o inactivo.");
                        break;

                    case 3:
                        System.out.print("ID para actualizar promedio: ");
                        int actId = sc.nextInt();
                        for (Alumno a : alumnos) {
                            if (a != null && a.id == actId && a.activo) {
                                System.out.print("Nuevo promedio: ");
                                double nuevoProm = sc.nextDouble();
                                if (nuevoProm >= 0 && nuevoProm <= 10) a.promedio = nuevoProm;
                                else System.out.println("Invalido.");
                            }
                        }
                        break;

                    case 4:
                        System.out.print("ID para baja: ");
                        int bajaId = sc.nextInt();
                        for (Alumno a : alumnos) {
                            if (a != null && a.id == bajaId) {
                                a.activo = false;
                                System.out.println("Baja realizada.");
                            }
                        }
                        break;

                    case 5:
                        System.out.println("\nLISTA DE ACTIVOS:");
                        for (Alumno a : alumnos) {
                            if (a != null && a.activo) System.out.println(a);
                        }
                        break;

                    case 6:
                        double suma = 0, max = -1, min = 11;
                        int cont = 0, sobresalientes = 0;
                        Alumno mejor = null, peor = null;

                        for (Alumno a : alumnos) {
                            if (a != null && a.activo) {
                                suma += a.promedio;
                                cont++;
                                if (a.promedio >= 8.0) sobresalientes++;
                                if (a.promedio > max) { max = a.promedio; mejor = a; }
                                if (a.promedio < min) { min = a.promedio; peor = a; }
                            }
                        }

                        if (cont > 0) {
                            System.out.println("Promedio General Activos: " + (suma / cont));
                            System.out.println("Mejor Alumno: " + mejor);
                            System.out.println("Peor Alumno: " + peor);
                            System.out.println("Alumnos con >= 8.0: " + sobresalientes);
                        } else System.out.println("No hay alumnos activos.");
                        break;

                    case 0:
                        System.out.println("Fin del programa.");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
            } else {
                System.out.println("Entrada no valida.");
                sc.next();
            }
        } while (opcion != 0);
    }
}
