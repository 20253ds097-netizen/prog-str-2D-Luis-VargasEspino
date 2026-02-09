import java.util.Scanner;

public class Main {

    // Al ponerlo aquí afuera, todos los métodos lo pueden usar directamente
    // Esto nos permite quitar el (Scanner lector) de los paréntesis
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        ShippingCalculator calculadora = new ShippingCalculator();

        // --- ENTRADAS ---
        double pesoKg = pedirPeso();
        int distanciaKm = pedirDistancia();
        int tipoServicio = pedirServicio();
        boolean esZonaRemota = pedirZona();

        // --- PROCESO ---
        double subtotal = calculadora.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
        double impuestoIva = calculadora.calcularIVA(subtotal);
        double totalAPagar = subtotal + impuestoIva;

        // --- SALIDA ---
        imprimirResultado(tipoServicio, pesoKg, distanciaKm, esZonaRemota, subtotal, impuestoIva, totalAPagar);
    }

    // Ahora los métodos están "vacíos" por dentro de los paréntesis
    public static double pedirPeso() {
        System.out.println("Ingrese el peso (0.1 a 50.0 kg):");
        return teclado.nextDouble();
    }

    public static int pedirDistancia() {
        System.out.println("Ingrese la distancia (1 a 2000 km):");
        return teclado.nextInt();
    }

    public static int pedirServicio() {
        System.out.println("Seleccione servicio (1-Estandar, 2-Express):");
        return teclado.nextInt();
    }

    public static boolean pedirZona() {
        System.out.println("¿Es zona remota? (true/false):");
        return teclado.nextBoolean();
    }

    public static void imprimirResultado(int servicio, double peso, int distancia, boolean zonaRemota,
                                         double subtotal, double iva, double total) {
        System.out.println("\n--- TICKET DE ENVIO ---");

        if (servicio == 1) {
            System.out.println("Servicio: Estandar");
        } else {
            System.out.println("Servicio: Express");
        }

        System.out.println("Peso: " + peso + " kg");
        System.out.println("Distancia: " + distancia + " km");
        System.out.println("Zona remota: " + zonaRemota);
        System.out.println("-----------------------");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("IVA (16%): $" + iva);
        System.out.println("TOTAL A PAGAR: $" + total);
    }
}