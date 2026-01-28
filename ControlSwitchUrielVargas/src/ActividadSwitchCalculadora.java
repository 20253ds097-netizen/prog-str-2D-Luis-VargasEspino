import java.util.Scanner;

public class ActividadSwitchCalculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menú de Calculadora");
        System.out.println("1Sumar");
        System.out.println("2 Restar");
        System.out.println("3 Multiplicar");
        System.out.println("4 Dividir");
        System.out.print("Elija una opción de 1 a 4");
        int opcion = scanner.nextInt();

        System.out.print("Ingrese el valor de a: ");
        double a = scanner.nextDouble();
        System.out.print("Ingrese el valor de b: ");
        double b = scanner.nextDouble();

        double resultado = 0;
        String operacionTexto = "";
        boolean mostrarResultado = true;

        switch (opcion) {
            case 1:
                operacionTexto = "Suma";
                resultado = a + b;
                break;
            case 2:
                operacionTexto = "Resta";
                resultado = a - b;
                break;
            case 3:
                operacionTexto = "Multiplicación";
                resultado = a * b;
                break;
            case 4:
                operacionTexto = "División";
                if (b == 0) {
                    System.out.println("Error: No se puede dividir entre cero.");
                    mostrarResultado = false;
                } else {
                    resultado = a / b;
                }
                break;
            default:
                System.out.println("Opción inválida.");
                mostrarResultado = false;
                break;
        }

        // 5. Impresión de resultados
        if (mostrarResultado) {
            System.out.println("\n--- Resumen ---");
            System.out.println("Operación elegida: " + operacionTexto);
            System.out.println("Valores ingresados: a = " + a + ", b = " + b);
            System.out.println("Resultado: " + resultado);
        }

        scanner.close();
    }
}