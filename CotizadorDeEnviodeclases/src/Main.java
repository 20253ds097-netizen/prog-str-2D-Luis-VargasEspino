import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShippingCalculator calc = new ShippingCalculator();
        double peso = leerDoubleEnRango(sc, "Ingrese el peso (0.1 a 50.0 kg)", 0.1, 50.0);
        int dist = leerIntEnRango(sc, "Ingrese la distancia (1 a 2000 km)", 1, 2000);
        int serv = leerIntEnRango(sc, "Tipo de servicio (1-Estandar, 2-Express)", 1, 2);
        boolean remota = leerBoolean(sc, "¿Es zona remota? (true/false)");
        double subtotal = calc.calcularSubtotal(peso, dist, serv, remota);
        double iva = calc.calcularIVA(subtotal);
        double total = calc.calcularTotal(subtotal, iva);
        imprimirTicket(serv, peso, dist, remota, subtotal, iva, total);

        sc.close();
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double val;
        do {
            System.out.print(msg);
            while (!sc.hasNextDouble()) {
                System.out.println("Ingrese un numero.");
                sc.next();
            }
            val = sc.nextDouble();
            if (val < min && val > max) {
                System.out.println("Valor fuera de rango ");
            }
        } while (val < min && val > max);
        return val;
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int val;
        do {
            System.out.print(msg);
            while (!sc.hasNextInt()) {
                System.out.println("Ingrese un numero entero.");
                sc.next();
            }
            val = sc.nextInt();
            if (val < min && val > max) {
                System.out.println("Valor fuera de rango (" + min + "-" + max + ")");
            }
        } while (val < min && val > max);
        return val;
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        System.out.print(msg);
        while (true) {
            String input = sc.next().toLowerCase(); // sc.next() lee hasta el espacio
            if (input.equals("true")) return true;
            if (input.equals("false")) return false;
            System.out.print(" Escriba true o false: ");
        }
    }
    public static void imprimirTicket(int servicio, double peso, int distancia, boolean remota,
                                      double subtotal, double iva, double total) {
        System.out.println("TICKET");
        System.out.println("Servicio" + (servicio == 1 ? "Estandar" : "Express"));
        System.out.println("Peso" + peso + " kg");
        System.out.println("Distancia" + distancia + " km");
        System.out.println("ZonaRemota" + (remota ? "Si" : "No"));
        System.out.println("Subtotal " + subtotal);
        System.out.println("IVA" + iva);
        System.out.println("TOTAL" + total);
    }
}