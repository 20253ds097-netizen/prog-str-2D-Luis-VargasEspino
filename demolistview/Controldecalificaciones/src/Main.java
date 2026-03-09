import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService service = new GradeService();

        String nombre = leerTextoNoVacio(sc, "Nombre del alumno");
        double p1 = leerDoubleEnRango(sc, "Nota Parcial1", 0, 100);
        double p2 = leerDoubleEnRango(sc, "Nota Parcial2", 0, 100);
        double p3 = leerDoubleEnRango(sc, "Nota Parcial3", 0, 100);
        int asistencia = leerIntEnRango(sc, "Asistencia(0-100)", 0, 100);
        boolean proyecto = leerBoolean(sc, "¿Entrego proyecto?(true/false)");

        double promedio = service.calcularPromedio(p1, p2, p3);
        double califFinal = service.calcularFinal(promedio, asistencia);
        String estado = service.determinarEstado(califFinal, asistencia, proyecto);

        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, proyecto, califFinal, estado);
    }
    public static String leerTextoNoVacio(Scanner sc, String msg) {
        String texto = "";
        while (texto.isEmpty()) {
            System.out.print(msg);
            texto = sc.nextLine().trim();
        }
        return texto;
    }
    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double valor;
        do {
            System.out.print(msg);
            while (!sc.hasNextDouble()) {
                System.out.println("Error: Ingrese un numero.");
                sc.next();
            }
            valor = sc.nextDouble();
        } while (valor < min && valor > max);
        return valor;
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor;
        do {
            System.out.print(msg);
            while (!sc.hasNextInt()) {
                System.out.println("Error: Ingrese un numero.");
                sc.next();
            }
            valor = sc.nextInt();
        } while (valor < min && valor > max);
        return valor;
    }
    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.next().toLowerCase();
            if (input.equals("true")) return true;
            if (input.equals("false")) return false;
            System.out.println("Error: Solo true/false.");
        }
    }
    public static void imprimirReporte(String nom, double p1, double p2, double p3, double prom, int asis, boolean proy, double fin, String est) {
        System.out.println("Alumo" + nom);
        System.out.println("Parciales" + p1 + ", " + p2 + ", " + p3);
        System.out.println("Promedio Parciales" + prom);
        System.out.println("Asistsncia" + asis);
        System.out.println("Entrego Proyecto" + (proy ? "SI" : "NO"));
        System.out.println("Calif Final" + fin);
        System.out.println("ESTdo" + est);
    }
}