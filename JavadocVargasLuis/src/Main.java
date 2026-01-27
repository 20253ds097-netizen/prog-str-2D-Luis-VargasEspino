import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----- MENÚ DE OPERACIONES -----");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular área de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. Calcular área de un círculo");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el peso (kg): ");
                    double peso = scanner.nextDouble();
                    System.out.print("Ingresa la altura (m): ");
                    double altura = scanner.nextDouble();
                    System.out.printf("Tu IMC es: %.2f%n", calcularIMC(peso, altura));
                    break;

                case 2:
                    System.out.print("Ingresa la base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingresa la altura: ");
                    double altRect = scanner.nextDouble();
                    System.out.println("El área del rectángulo es: " + calcularAreaRectangulo(base, altRect));
                    break;

                case 3:
                    System.out.print("Ingresa los grados Celsius: ");
                    double celsius = scanner.nextDouble();
                    System.out.println("La temperatura en Fahrenheit es: " + convertirCelsiusAFahrenheit(celsius));
                    break;

                case 4:
                    System.out.print("Ingresa el radio del círculo: ");
                    double radio = scanner.nextDouble();
                    System.out.printf("El área del círculo es: %.2f%n", calcularAreaCirculo(radio));
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
            System.out.println(); // Salto de línea para claridad

        } while (opcion != 5);

        scanner.close();
    }

    /**
     * Calcula el Índice de Masa Corporal (IMC) basado en el peso y la altura.
     * @param peso El peso de la persona en kilogramos.
     * @param altura La altura de la persona en metros.
     * @return El valor calculado del IMC.
     */
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    /**
     * Calcula el área de un rectángulo multiplicando su base por su altura.
     * @param base La medida del lado horizontal.
     * @param altura La medida del lado vertical.
     * @return El área total del rectángulo.
     */
    public static double calcularAreaRectangulo(double base, double altura) {
        return base * altura;
    }

    /**
     * Convierte una temperatura de grados Celsius a grados Fahrenheit.
     * @param celsius La temperatura en grados centígrados.
     * @return La temperatura equivalente en grados Fahrenheit.
     */
    public static double convertirCelsiusAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    /**
     * Calcula el área de un círculo utilizando el radio y la constante PI.
     * @param radio La distancia desde el centro hasta el borde del círculo.
     * @return El área total del círculo.
     */
    public static double calcularAreaCirculo(double radio) {
        return Math.PI * (radio * radio);
    }
}