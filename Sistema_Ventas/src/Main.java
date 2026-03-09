import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double subtotal = 0;

        System.out.println("Ingrese los precios (0 para terminar):");
        while (true) {

            if (!sc.hasNextDouble()) {
                System.out.println("Entrada inválida");
                return;
            }

            double precio = sc.nextDouble();

            if (precio == 0) break;


            if (!esPrecioValido(precio)) {
                System.out.println("Precio inválido");
                continue;
            }

            subtotal = calcularSubtotal(subtotal, precio);
        }

        System.out.println("Seleccione método de pago (1. Efectivo, 2. Tarjeta):");
        if (!sc.hasNextInt()) {
            System.out.println("Entrada inválida");
            return;
        }

        int metodoPago = sc.nextInt();
        if (metodoPago != 1 && metodoPago != 2) {
            System.out.println("Opción no válida");
            return;
        }


        double montoDescuento = calcularDescuento(subtotal, metodoPago);
        double total = calcularTotal(subtotal, montoDescuento);

        // 6. Ticket final
        System.out.println("\n--- TICKET DE VENTA ---");
        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Descuento: $%.2f%n", montoDescuento);
        System.out.printf("Total a pagar: $%.2f%n", total);
    }

    // --- MÉTODOS ESTÁTICOS ---

    static boolean esPrecioValido(double p) {
        return p > 0;
    }

    static double calcularSubtotal(double subtotalActual, double precio) {
        return subtotalActual + precio;
    }

    static double calcularDescuento(double subtotal, int metodoPago) {
        if (subtotal >= 500) {
            if (metodoPago == 1) return subtotal * 0.08;
            if (metodoPago == 2) return subtotal * 0.05;
        }
        return 0;
    }

    static double calcularTotal(double subtotal, double descuento) {
        return subtotal - descuento;
    }
}
