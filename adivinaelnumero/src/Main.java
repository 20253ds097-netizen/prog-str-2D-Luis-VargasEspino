import java.util.Random;
import java.util.Scanner;

public class Main {
    static int fueraDeRangoContador = 0;
    static int noNumericoContador = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int secreto = random.nextInt(100) + 1;
        int intentos = 0;
        int limiteIntentos = 7;

        boolean gano = false;

        System.out.println("Bienvenido al juego de adivinar un numero");
        System.out.println("He pensado un número entre 1 y 100. Tienes 7 intentos.");

        while (intentos < limiteIntentos && !gano) {
            System.out.println("Intento " + (intentos + 1) + " de " + limiteIntentos + ":");

            int numero = obtenerNumeroValido(sc, 1, 100);

            intentos++;

            if (numero == secreto) {
                System.out.println("Ganaste Lo lograste en " + intentos + " intentos.");
                gano = true;
            } else if (numero > secreto) {
                System.out.println("El número secreto es menor.");
            } else {
                System.out.println("El número secreto es mayor.");
            }
        }

        if (!gano) {
            System.out.println("Perdiste. El número secreto era: " + secreto);
        }
        System.out.println("Entradas fuera de rango (1-100): " + fueraDeRangoContador);
        System.out.println("Entradas no numéricas: " + noNumericoContador);
        sc.close();
    }

    /**
     *  Este metodo Valida que la entrada sea un número y esté dentro del rango.
     * Incrementa los contadores de errores.
     */
    public static int obtenerNumeroValido(Scanner sc, int min, int max) {
        while (true) {
            System.out.print("Ingresa tu número: ");
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Error: El número debe estar entre " + min + " y " + max + ".");
                    fueraDeRangoContador++; // Conteo de fuera de rango
                }
            } else {
                System.out.println("Error: Debes ingresar un dato numérico.");
                noNumericoContador++; // Conteo de no numérico
                sc.next();
            }
        }
    }
}