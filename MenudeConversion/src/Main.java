import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // Contadores inicializados
        int cCelsiusF = 0;
        int cFahrenheitC = 0;
        int cKmMillas = 0;
        int cMillasKm = 0;

        do {
            System.out.println("\nMENÚ DE CONVERSIONES (1-4)(5-Salir)");
            System.out.println("1 °C a °F");
            System.out.println("2 °F a °C");
            System.out.println("3 Km a Millas");
            System.out.println("4 Millas a Km");
            System.out.println("5 Salir");

            System.out.print("Elija una opción: ");
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
            } else {
                System.out.println("Error: Ingrese un número entre 1 y 5.");
                sc.next(); // Limpiar el buffer para evitar bucle infinito
                continue;
            }

            if (opcion >= 1 && opcion <= 4) {
                double entrada = leerValorNumerico(sc, "Ingrese el valor a convertir: ");

                switch (opcion) {
                    case 1:
                        double f = (entrada * 9.0 / 5.0) + 32;
                        System.out.printf("Resultado: %.2f%n", f);
                        cCelsiusF++;
                        break;
                    case 2:
                        double c = (entrada - 32) * 5.0 / 9.0;
                        System.out.printf("Resultado: %.2f%n", c);
                        cFahrenheitC++;
                        break;
                    case 3:
                        double mi = entrada * 0.621371;
                        System.out.printf("Resultado: %.2f%n", mi);
                        cKmMillas++;
                        break;
                    case 4:
                        double km = entrada / 0.621371;
                        System.out.printf("Resultado: %.2f%n", km);
                        cMillasKm++;
                        break;
                }
            } else if (opcion != 5) {
                System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 5);

        // Impresión del resumen solicitado
        int total = cCelsiusF + cFahrenheitC + cKmMillas + cMillasKm;
        System.out.println("\n--- RESUMEN DE CONVERSIONES ---");
        System.out.println("Conversiones °C a °F: " + cCelsiusF);
        System.out.println("Conversiones °F a °C: " + cFahrenheitC);
        System.out.println("Conversiones Km a Millas: " + cKmMillas);
        System.out.println("Conversiones Millas a Km: " + cMillasKm);
        System.out.println("TOTAL REALIZADAS: " + total);

        sc.close();
    }

    public static double leerValorNumerico(Scanner sc, String mensaje) {
        double valor = 0;
        boolean esValido = false;
        while (!esValido) {
            System.out.print(mensaje);
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                esValido = true;
            } else {
                System.out.println("Error: El dato debe ser numérico.");
                sc.next(); // Limpiar entrada incorrecta
            }
        }
        return valor;
    }
}