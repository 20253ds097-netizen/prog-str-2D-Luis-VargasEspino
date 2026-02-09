import java.util.Scanner;

public class InputDataValidator {

    public int getValidInt(Scanner scanner, String msg) {
        int value;
        while (true) {
            System.out.println(msg);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value > 0) {
                    return value; // Dato correcto
                } else {
                    System.out.println("El dato está fuera de rango (1-n)");
                }
            } else {
                System.out.println("El dato no es numérico");
                scanner.next(); // Limpiar el error del scanner
            }
        }
    }
}